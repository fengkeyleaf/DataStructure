package myLibraries.util.tree.tools;

/*
 * TestBBST.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $1.0$
 */

import myLibraries.util.tree.RedBlackTree;

/**
 * Test BBST
 *
 * @author       Xiaoyu Tongyang, or call me sora for short
 */

public final class TestBBST {
    public static
    void main( String[] args ) {
        RedBlackTree<String, Integer> BBST = new RedBlackTree<>();
        int num = 1;
        BBST.put( "S", num++ ); // 1
        BBST.put( "E", num++ );
        BBST.put( "A", num++ ); // 3
        BBST.put( "R", num++ );
        BBST.put( "C", num++ ); // 5
        BBST.put( "H", num++ );
        BBST.put( "X", num++ ); // 7
        BBST.put( "M", num++ );
        BBST.put( "P", num++ ); // 9
        BBST.put( "L", num++ );

//        System.out.println( BBST.get( "M" ) ); // 8
//        System.out.println( BBST.get( "A" ) ); // 3
//        System.out.println( BBST.get( "X" ) ); // 7
//        System.out.println( BBST.get( "O" ) ); // null
//        System.out.println( BBST.get( "MM" ) ); // null

//        BBST.deleteMin(); // A -> 3
//        BBST.deleteMax(); // X -> 7

        BBST.checkValidTreeStructure();
        BBST.delete( "M" );
        BBST.checkValidTreeStructure();
        BBST.delete( "H" );
        BBST.checkValidTreeStructure();
        BBST.delete( "R" );
        BBST.inorderPrint();

        num = 1;
        RedBlackTree<Integer, Integer> BBST2 = new RedBlackTree<>();
        BBST2.put( 2, 2 ); // 1
        BBST2.put( 1, 1 ); // 2
        BBST2.put( 3, 3 ); // 3

        BBST2.checkValidTreeStructure();
        BBST2.delete( 0 );
        BBST2.checkValidTreeStructure();
        BBST2.delete( 4 );
        BBST2.checkValidTreeStructure();
        BBST2.inorderPrint();
        BBST2.deleteMin();
        BBST2.deleteMin();
        BBST2.deleteMin();
        BBST2.inorderPrint();

        RedBlackTree<String, Integer> BBST3 = new RedBlackTree<>();
        BBST3.put( "H", num++ );
        BBST3.put( "C", num++ ); // 5
        BBST3.put( "R", num++ );
        BBST3.put( "A", num++ ); // 3

        BBST3.delete( "C" );
        BBST3.inorderPrint();
    }
}
