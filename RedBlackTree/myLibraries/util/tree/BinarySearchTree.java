package myLibraries.util.tree;

/*
 * BinarySearchTree.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $1.0$
 */

import myLibraries.util.tree.elements.MapTreeNode;

import java.util.Comparator;

/**
 * Data structure of Binary Search Tree
 * with mapping tree node
 *
 * Note that in order to avoid errors, either a Comparator<K> is provided
 * or the key, K, implements Comparable<K>
 *
 * Reference resource: https://algs4.cs.princeton.edu/home/
 * or Algorithms 4th Edition in Chinese
 *
 * @author       Xiaoyu Tongyang, or call me sora for short
 */

public class BinarySearchTree<K, V> extends AbstractTree {
    protected MapTreeNode<K, V> root;
    // comparator to compare key, K
    protected final Comparator<K> comparator;

    /**
     * constructs to create an instance of BinarySearchTree
     * */

    public BinarySearchTree( Comparator<K> comparator ) {
        this.comparator = comparator;
    }

    public BinarySearchTree() {
        this.comparator = null;
    }

    /**
     * inorderPrint
     * */

    private static<K, V>
    void inorderPrint( MapTreeNode<K, V> root ) {
        if ( root == null ) return;
        inorderPrint( root.left );
        System.out.print( root + " " );
        inorderPrint( root.right );
    }

    /**
     * print this BST in inorder
     * */

    public void inorderPrint() {
        inorderPrint( root );
        System.out.println();
    }

    /**
     * size of this BST
     * */

    // TODO: 5/29/2021 use a variable to store the number of nodes
    //  and thus the size() is in O(1) 
    @Override
    public int size() {
        return size( root );
    }

    /**
     * count how many children this root has
     * */

    protected int size( MapTreeNode<K, V> root ) {
        if ( root == null ) return 0;
        return root.numberOfChildren;
    }

    /**
     * update the number of children that the root has
     * */

    protected MapTreeNode<K, V> updateSize( MapTreeNode<K, V> root ) {
        root.numberOfChildren = size( root.left ) + size( root.right ) + 1;
        return root;
    }

    /**
     * compare keys using Comparable<K> or Comparator<K>
     * */

    protected int compareKeys( MapTreeNode<K, V> root, K key ) {
        // use Comparable<K>
        if ( comparator == null ) {
            Comparable<? super K> comparable = ( Comparable<? super K> ) root.key;
            return comparable.compareTo( key );
        }

        // use Comparator<K>
        return comparator.compare( root.key, key );
    }

    /**
     * get the value associated with the key
     * */
    
    public V get( K key ) {
        return get( root, key );
    }

    // TODO: 5/29/2021 cache,
    //  store the most frequently pull-outed key in a variable
    protected V get( MapTreeNode<K, V> root, K key ) {
        // base case, not found the key
        if ( root == null ) return null;

        int res = compareKeys( root, key );
        // the key may be in the left subtree
        if ( res > 0 ) return get( root.left, key );
        // the key may be in the right subtree
        else if ( res < 0 ) return get( root.right, key );

        // found the key, return the value
        return root.val;
    }

    /**
     * put key -> val into this BST
     * */

    public void put( K key, V val ) {
        root = put( root, key, val );
    }

    private MapTreeNode<K, V> put( MapTreeNode<K, V> root, K key, V val ) {
        // base case, attach the new node to this position
        if ( root == null ) return new MapTreeNode<K, V>( ID++, key, val );

        int res = compareKeys( root, key );
        // the node should be attached in the left subtree
        if ( res > 0 ) root.left =  put( root.left, key, val );
        // the node should be attached in the right subtree
        else if ( res < 0 ) root.right = put( root.right, key, val );
        // added before, update value
        else root.val = val;

        return updateSize( root );
    }

    /**
     * get the minimum key -> value in this BST
     * */

    public K min() {
        // the root is null, i.e the tree is empty,
        // which is missed by the textbook
        return isEmpty() ? null : min( root ).key;
    }

    protected MapTreeNode<K, V> min( MapTreeNode<K, V> root ) {
        if ( root.left == null ) return root;
        return min( root.left );
    }

    /**
     * get the maximum key -> value in this BST
     * */

    public K max() {
        // the root is null, i.e the tree is empty,
        // which is missed by the textbook
        return isEmpty() ? null : max( root ).key;
    }

    protected MapTreeNode<K, V> max( MapTreeNode<K, V> root ) {
        if ( root.right == null ) return root;
        return min( root.right );
    }

    /**
     * delete the minimum key -> value in this BST
     * */

    // TODO: 5/29/2021 return the deleted min val in O(1)
    public void deleteMin() {
        // the root is null, i.e the tree is empty,
        // which is missed by the textbook
        if ( isEmpty() ) return;

        root = deleteMin( root );
    }

    private MapTreeNode<K, V> deleteMin( MapTreeNode<K, V> root ) {
        // base case, this node is the least one in the tree
        // attach its right subtree to its father
        if ( root.left == null ) return root.right;

        // otherwise, look into the left subtree
        root.left = deleteMin( root.left );
        return updateSize( root );
    }

    /**
     * delete the maximum key -> value in this BST
     * */

    // TODO: 5/29/2021 return the deleted max val in O(1)
    public void deleteMax() {
        // the root is null, i.e the tree is empty,
        // which is missed by the textbook
        if ( isEmpty() ) return;

        root = deleteMax( root );
    }

    private MapTreeNode<K, V> deleteMax( MapTreeNode<K, V> root ) {
        // base case, this node is the greatest one in the tree
        // attach its left subtree to its father
        if ( root.right == null ) return root.left;

        // otherwise, look into the right subtree
        root.right = deleteMin( root.right );
        return updateSize( root );
    }

    /**
     * delete the key -> value in this BST
     * */

    // TODO: 5/29/2021 return the deleted val in O(1)
    public void delete( K key ) {
        root = delete( root, key );
    }

    private MapTreeNode<K, V> delete( MapTreeNode<K, V> root, K key ) {
        // base case, not found the key
        if ( root == null ) return null;

        int res = compareKeys( root, key );
        // the key may be in the left subtree
        if ( res > 0 ) root.left = delete( root.left, key );
        // the key may be in the right subtree
        else if ( res < 0 ) root.right = delete( root.right, key );
        // found the key
        else {
            // case 1 or 2, have only one child,
            // either left child or right child
            // just make this child attach to its grandfather
            if ( root.right == null ) return root.left;
            if ( root.left == null ) return root.right;

            // case 3, have two children,
            // replace the value of this node with that of its successor,
            // the one that greater than the node
            // but is the minimum among all the successors of the node
            // and delete the successor,
            // i.e deleteMin( theNode.right )
            MapTreeNode<K, V> temp = root;
            root = min( temp.right );
            root.right = deleteMin( temp.right );
            root.left = temp.left;
        }

        return updateSize( root );
    }
}
