package myLibraries.util;

/*
 * MyArrays.java
 *
 * Version:
 *     $1.0$
 *
 * Revisions:
 *     $1.0$
 */


import java.util.Arrays;

/**
 * Provide methods related to the Arrays Class
 *
 * @author       Xiaoyu Tongyang
 */

public class MyArrays {

    /**
     * given indices are out of boundary?
     */

    public static
    boolean isOutOfIndex( int i, int size ) {
        return isOutOfIndex( i, i, size );
    }

    public static
    boolean isOutOfIndex( int l, int r, int size ) {
        return l < 0 || r >= size;
    }

    /**
     * medium index
     */

    public static
    int mid( int left, int right ) {
        return ( right - left ) / 2 + left;
    }

    /**
     * print 2D array
     */

    public static
    String print2DArrays( int[][] arrays, boolean upsideDownRow ) {
        StringBuilder text = new StringBuilder();
        if ( upsideDownRow )
            for ( int i = arrays.length - 1; i >= 0; i-- )
                text.append( Arrays.toString( arrays[ i ] ) ).append( "\n" );
        else
            for ( int[] array : arrays )
                text.append( Arrays.toString( array ) ).append( "\n" );

        return text.toString();
    }

    public static
    String print2DArrays( float[][] arrays, boolean upsideDownRow ) {
        StringBuilder text = new StringBuilder();
        if ( upsideDownRow )
            for ( int i = arrays.length - 1; i >= 0; i-- )
                text.append( Arrays.toString( arrays[ i ] ) ).append( "\n" );
        else
            for ( float[] array : arrays )
                text.append( Arrays.toString( array ) ).append( "\n" );

        return text.toString();
    }

    public static
    String print2DArrays( double[][] arrays, boolean upsideDownRow ) {
        StringBuilder text = new StringBuilder();
        if ( upsideDownRow )
            for ( int i = arrays.length - 1; i >= 0; i-- )
                text.append( Arrays.toString( arrays[ i ] ) ).append( "\n" );
        else
            for ( double[] array : arrays )
                text.append( Arrays.toString( array ) ).append( "\n" );

        return text.toString();
    }
}
