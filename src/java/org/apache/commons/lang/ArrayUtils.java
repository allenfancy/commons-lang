/* ====================================================================
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2002-2003 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Commons", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Software Foundation.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */
package org.apache.commons.lang;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
/**
 * <p><code>ArrayUtils</code> contains utility methods for working with
 * arrays.</p>
 *
 * @author Stephen Colebourne
 * @author Moritz Petersen
 * @author <a href="mailto:fredrik@westermarck.com">Fredrik Westermarck</a>
 * @author Nikolay Metchev
 * @author Matthew Hawthorne
 * @since 2.0
 * @version $Id: ArrayUtils.java,v 1.15 2003/06/25 23:33:47 scolebourne Exp $
 */
public class ArrayUtils {

    /** An empty immutable object array */
    public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
    /** An empty immutable class array */
    public static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
    /** An empty immutable string array */
    public static final String[] EMPTY_STRING_ARRAY = new String[0];
    /** An empty immutable long array */
    public static final long[] EMPTY_LONG_ARRAY = new long[0];
    /** An empty immutable Long array */
    public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
    /** An empty immutable int array */
    public static final int[] EMPTY_INT_ARRAY = new int[0];
    /** An empty immutable Integer array */
    public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
    /** An empty immutable short array */
    public static final short[] EMPTY_SHORT_ARRAY = new short[0];
    /** An empty immutable Short array */
    public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
    /** An empty immutable byte array */
    public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
    /** An empty immutable Byte array */
    public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
    /** An empty immutable double array */
    public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
    /** An empty immutable Double array */
    public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
    /** An empty immutable float array */
    public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
    /** An empty immutable Float array */
    public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
    /** An empty immutable boolean array */
    public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
    /** An empty immutable Boolean array */
    public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
    /** An empty immutable char array */
    public static final char[] EMPTY_CHAR_ARRAY = new char[0];
    /** An empty immutable Character array */
    public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];

    /**
     * <p>ArrayUtils instances should NOT be constructed in standard programming.
     * Instead, the class should be used as <code>ArrayUtils.clone(new int[] {2})</code>.</p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean instance
     * to operate.</p>
     */
    public ArrayUtils() {
    }
    
    // Basic methods handling multi-dimensional arrays
    //-----------------------------------------------------------------------
    /**
     * <p>Outputs an array as a String, treating <code>null</code> as an empty array.</p>
     *
     * <p>Multi-dimensional arrays are handled correctly, including
     * multi-dimensional primitive arrays.</p>
     *
     * <p>The format is that of Java source code, for example {a,b}.</p>
     * 
     * @param array  the array to get a toString for, may be <code>null</code>
     * @return a String representation of the array, '{}' if <code>null</code> passed in
     */
    public static String toString(final Object array) {
        return toString(array, "{}");
    }

    /**
     * <p>Outputs an array as a String handling <code>null</code>s.</p>
     *
     * <p>Multi-dimensional arrays are handled correctly, including
     * multi-dimensional primitive arrays.</p>
     *
     * <p>The format is that of Java source code, for example {a,b}.</p>
     * 
     * @param array  the array to get a toString for, may be <code>null</code>
     * @param stringIfNull  the String to return if the array is <code>null</code>
     * @return a String representation of the array
     */    
    public static String toString(final Object array, final String stringIfNull) {
        if (array == null) {
            return stringIfNull;
        }
        return new ToStringBuilder(array, ToStringStyle.SIMPLE_STYLE).append(array).toString();
    }

    /**
     * <p>Get a hashCode for an array handling multi-dimensional arrays correctly.</p>
     * 
     * <p>Multi-dimensional primitive arrays are also handled correctly by this method.</p>
     * 
     * @param array  the array to get a hashCode for, may be <code>null</code>
     * @return a hashCode for the array
     */
    public static int hashCode(final Object array) {
        return new HashCodeBuilder().append(array).toHashCode();
    }

    /**
     * <p>Compares two arrays, using equals(), handling multi-dimensional arrays
     * correctly.</p>
     * 
     * <p>Multi-dimensional primitive arrays are also handled correctly by this method.</p>
     * 
     * @param array1  the array to get a hashCode for, may be <code>null</code>
     * @param array2  the array to get a hashCode for, may be <code>null</code>
     * @return <code>true</code> if the arrays are equal
     */
    public static boolean isEquals(final Object array1, final Object array2) {
        return new EqualsBuilder().append(array1, array2).isEquals();
    }

    //-----------------------------------------------------------------------
    /**
     * <p>Converts the given array into a {@link java.util.Map}. Each element of the array
     * must be either a {@link java.util.Map.Entry} or an Array, containing at least two
     * elements, where the first element is used as key and the second as
     * value.</p>
     *
     * <p>This method can be used to initialize:</p>
     * <pre>
     * // Create a Map mapping colors.
     * Map colorMap = MapUtils.toMap(new String[][] {{
     *     {"RED", "#FF0000"},
     *     {"GREEN", "#00FF00"},
     *     {"BLUE", "#0000FF"}});
     * </pre>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     *
     * @param array  an array whose elements are either a {@link java.util.Map.Entry} or 
     *  an Array containing at least two elements, may be <code>null</code>
     * @return a <code>Map</code> that was created from the array
     * @throws IllegalArgumentException  if one element of this Array is
     *  itself an Array containing less then two elements
     * @throws IllegalArgumentException  if the array contains elements other
     *  than {@link java.util.Map.Entry} and an Array
     */
    public static Map toMap(final Object[] array) {
        if (array == null) {
            return null;
        }
        final Map map = new HashMap((int) (array.length * 1.5));
        for (int i = 0; i < array.length; i++) {
            Object object = array[i];
            if (object instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) object;
                map.put(entry.getKey(), entry.getValue());
            } else if (object instanceof Object[]) {
                Object[] entry = (Object[]) object;
                if (entry.length < 2) {
                    throw new IllegalArgumentException("Array element " + i + ", '" 
                        + object
                        + "', has a length less than 2");
                }
                map.put(entry[0], entry[1]);
            } else {
                throw new IllegalArgumentException("Array element " + i + ", '" 
                        + object
                        + "', is neither of type Map.Entry nor an Array");
            }
        }
        return map;
    }

    //-----------------------------------------------------------------------
    /**
     * <p>Shallow clones an array returning a typecast result and handling
     * <code>null</code>.</p>
     *
     * <p>The objecs in the array are not cloned, thus there is no special
     * handling for multi-dimensional arrays.</p>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to shallow clone, may be <code>null</code>
     * @return the cloned array, or <code>null</code> if <code>null</code>
     *  passed in
     */
    public static Object[] clone(final Object[] array) {
        if (array == null) {
            return null;
        }
        return (Object[]) array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * <code>null</code>.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to clone, may be <code>null</code>
     * @return the cloned array, or <code>null</code> if <code>null</code>
     *  passed in
     */
    public static long[] clone(final long[] array) {
        if (array == null) {
            return null;
        }
        return (long[]) array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * <code>null</code>.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to clone, may be <code>null</code>
     * @return the cloned array, or <code>null</code> if <code>null</code>
     *  passed in
     */
    public static int[] clone(int[] array) {
        if (array == null) {
            return null;
        }
        return (int[]) array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * <code>null</code>.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to clone, may be <code>null</code>
     * @return the cloned array, or <code>null</code> if <code>null</code>
     *  passed in
     */
    public static short[] clone(final short[] array) {
        if (array == null) {
            return null;
        }
        return (short[]) array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * <code>null</code>.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to clone, may be <code>null</code>
     * @return the cloned array, or <code>null</code> if <code>null</code>
     *  passed in
     */
    public static char[] clone(final char[] array) {
        if (array == null) {
            return null;
        }
        return (char[]) array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * <code>null</code>.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to clone, may be <code>null</code>
     * @return the cloned array, or <code>null</code> if <code>null</code>
     *  passed in
     */
    public static byte[] clone(final byte[] array) {
        if (array == null) {
            return null;
        }
        return (byte[]) array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * <code>null</code>.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to clone, may be <code>null</code>
     * @return the cloned array, or <code>null</code> if <code>null</code>
     *  passed in
     */
    public static double[] clone(final double[] array) {
        if (array == null) {
            return null;
        }
        return (double[]) array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * <code>null</code>.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to clone, may be <code>null</code>
     * @return the cloned array, or <code>null</code> if <code>null</code>
     *  passed in
     */
    public static float[] clone(final float[] array) {
        if (array == null) {
            return null;
        }
        return (float[]) array.clone();
    }

    /**
     * <p>Clones an array returning a typecast result and handling
     * <code>null</code>.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to clone, may be <code>null</code>
     * @return the cloned array, or <code>null</code> if <code>null</code>
     *  passed in
     */
    public static boolean[] clone(final boolean[] array) {
        if (array == null) {
            return null;
        }
        return (boolean[]) array.clone();
    }

    //-----------------------------------------------------------------------
    /**
     * <p>Checks whether two arrays are the same length, treating
     * <code>null</code> arrays as length <code>0</code>.
     *
     * <p>Any multi-dimensional aspects of the arrays are ignored.</p>
     * 
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating
     *  <code>null</code> as an empty array
     */    
    public static boolean isSameLength(final Object[] array1, final Object[] array2) {
        if ((array1 == null && array2 != null && array2.length > 0) ||
            (array2 == null && array1 != null && array1.length > 0) ||
            (array1 != null && array2 != null && array1.length != array2.length)) {
                return false;
        }
        return true;
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * <code>null</code> arrays as length <code>0</code>.</p>
     * 
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating
     *  <code>null</code> as an empty array
     */
    public static boolean isSameLength(final long[] array1, final long[] array2) {
        if ((array1 == null && array2 != null && array2.length > 0) ||
            (array2 == null && array1 != null && array1.length > 0) ||
            (array1 != null && array2 != null && array1.length != array2.length)) {
                return false;
        }
        return true;
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * <code>null</code> arrays as length <code>0</code>.</p>
     * 
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating
     *  <code>null</code> as an empty array
     */
    public static boolean isSameLength(final int[] array1, final int[] array2) {
        if ((array1 == null && array2 != null && array2.length > 0) ||
            (array2 == null && array1 != null && array1.length > 0) ||
            (array1 != null && array2 != null && array1.length != array2.length)) {
                return false;
        }
        return true;
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * <code>null</code> arrays as length <code>0</code>.</p>
     * 
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating
     *  <code>null</code> as an empty array
     */
    public static boolean isSameLength(final short[] array1, final short[] array2) {
        if ((array1 == null && array2 != null && array2.length > 0) ||
            (array2 == null && array1 != null && array1.length > 0) ||
            (array1 != null && array2 != null && array1.length != array2.length)) {
                return false;
        }
        return true;
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * <code>null</code> arrays as length <code>0</code>.</p>
     * 
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating
     *  <code>null</code> as an empty array
     */
    public static boolean isSameLength(final char[] array1, final char[] array2) {
        if ((array1 == null && array2 != null && array2.length > 0) ||
            (array2 == null && array1 != null && array1.length > 0) ||
            (array1 != null && array2 != null && array1.length != array2.length)) {
                return false;
        }
        return true;
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * <code>null</code> arrays as length <code>0</code>.</p>
     * 
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating
     *  <code>null</code> as an empty array
     */
    public static boolean isSameLength(final byte[] array1, final byte[] array2) {
        if ((array1 == null && array2 != null && array2.length > 0) ||
            (array2 == null && array1 != null && array1.length > 0) ||
            (array1 != null && array2 != null && array1.length != array2.length)) {
                return false;
        }
        return true;
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * <code>null</code> arrays as length <code>0</code>.</p>
     * 
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating
     *  <code>null</code> as an empty array
     */
    public static boolean isSameLength(final double[] array1, final double[] array2) {
        if ((array1 == null && array2 != null && array2.length > 0) ||
            (array2 == null && array1 != null && array1.length > 0) ||
            (array1 != null && array2 != null && array1.length != array2.length)) {
                return false;
        }
        return true;
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * <code>null</code> arrays as length <code>0</code>.</p>
     * 
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating
     *  <code>null</code> as an empty array
     */
    public static boolean isSameLength(final float[] array1, final float[] array2) {
        if ((array1 == null && array2 != null && array2.length > 0) ||
            (array2 == null && array1 != null && array1.length > 0) ||
            (array1 != null && array2 != null && array1.length != array2.length)) {
                return false;
        }
        return true;
    }

    /**
     * <p>Checks whether two arrays are the same length, treating
     * <code>null</code> arrays as length <code>0</code>.</p>
     * 
     * @param array1 the first array, may be <code>null</code>
     * @param array2 the second array, may be <code>null</code>
     * @return <code>true</code> if length of arrays matches, treating
     *  <code>null</code> as an empty array
     */
    public static boolean isSameLength(final boolean[] array1, final boolean[] array2) {
        if ((array1 == null && array2 != null && array2.length > 0) ||
            (array2 == null && array1 != null && array1.length > 0) ||
            (array1 != null && array2 != null && array1.length != array2.length)) {
                return false;
        }
        return true;
    }

    /**
     * <p>Checks whether two arrays are the same type taking into account
     * multi-dimensional arrays.</p>
     * 
     * @param array1 the first array, must not be <code>null</code>
     * @param array2 the second array, must not be <code>null</code>
     * @return <code>true</code> if type of arrays matches
     * @throws IllegalArgumentException if either array is <code>null</code>
     */    
    public static boolean isSameType(final Object array1, final Object array2) {
        if (array1 == null || array2 == null) {
            throw new NullArgumentException("Array");
        }
        return array1.getClass().getName().equals(array2.getClass().getName());
    }

    //-----------------------------------------------------------------------
    /** 
     * <p>Reverses the order of the given array.</p>
     *
     * <p>There is no special handling for multi-dimensional arrays.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to reverse, may be <code>null</code>
     */
    public static void reverse(final Object[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        Object tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>Reverses the order of the given array.</p>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to reverse, may be <code>null</code>
     */
    public static void reverse(final long[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        long tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>Reverses the order of the given array.</p>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to reverse, may be <code>null</code>
     */
    public static void reverse(final int[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        int tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>Reverses the order of the given array.</p>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to reverse, may be <code>null</code>
     */
    public static void reverse(final short[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        short tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>Reverses the order of the given array.</p>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to reverse, may be <code>null</code>
     */
    public static void reverse(final char[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        char tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>Reverses the order of the given array.</p>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to reverse, may be <code>null</code>
     */
    public static void reverse(final byte[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        byte tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>Reverses the order of the given array.</p>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to reverse, may be <code>null</code>
     */
    public static void reverse(final double[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        double tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>Reverses the order of the given array.</p>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to reverse, may be <code>null</code>
     */
    public static void reverse(final float[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        float tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    /**
     * <p>Reverses the order of the given array.</p>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to reverse, may be <code>null</code>
     */
    public static void reverse(final boolean[] array) {
        if (array == null) {
            return;
        }
        int i = 0;
        int j = array.length - 1;
        boolean tmp;
        while (j > i) {
            tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
            j--;
            i++;
        }
    }

    // IndexOf
    //-----------------------------------------------------------------------
    /**
     * <p>Find the index of the given object in the array.</p>
     *
     * <p>This method returns <code>-1</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to search through for the object, may be <code>null</code>
     * @param objectToFind  the object to find, may be <code>null</code>
     * @return the index of the object within the array, or -1 if not found
     */
    public static int indexOf(final Object[] array, final Object objectToFind) {
        return indexOf(array, objectToFind, 0);
    }

    /**
     * <p>Find the index of the given object in the array starting at the given index.</p>
     *
     * <p>This method returns <code>-1</code> if <code>null</code> input.</p>
     *
     * <p>A negative startIndex is treated as zero. A startIndex larger than the array
     * length will return -1.</p>
     * 
     * @param array  the array to search through for the object, may be <code>null</code>
     * @param objectToFind  the object to find, may be <code>null</code>
     * @param startIndex  the index to start searching at
     * @return the index of the object within the array starting at the
     *  given index, or -1 if not found
     */
    public static int indexOf(final Object[] array, final Object objectToFind, int startIndex) {
        if (array == null) {
            return -1;
        }
        if (startIndex < 0) {
            startIndex = 0;
        }
        if (objectToFind == null) {
            for (int i = startIndex; i < array.length; i++) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = startIndex; i < array.length; i++) {
                if (objectToFind.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * <p>Find the last index of the given object within the array.</p>
     *
     * <p>This method returns <code>-1</code> if <code>null</code> input.</p>
     * 
     * @param array  the array to travers backwords looking for the object, may be <code>null</code>
     * @param objectToFind  the object to find, may be <code>null</code>
     * @return the last index of the object to find, or -1 if not found
     */
    public static int lastIndexOf(final Object[] array, final Object objectToFind) {
        if (array == null) {
            return -1;
        }
        return lastIndexOf(array, objectToFind, array.length - 1);
    }

    /**
     * <p>Find the last index of the given object in the array starting at the given index.</p>
     *
     * <p>This method returns <code>-1</code> if <code>null</code> input.</p>
     *
     * <p>A negative startIndex will return -1. A startIndex larger than the array
     * length will search from the end of the array.</p>
     * 
     * @param array  the array to traverse for looking for the object, may be <code>null</code>
     * @param objectToFind  the object to find, may be <code>null</code>
     * @param startIndex  the start index to travers backwards from
     * @return the last index of the object within the array starting at the given index,
     *  or -1 if not found
     */
    public static int lastIndexOf(final Object[] array, final Object objectToFind, int startIndex) {
        if (array == null) {
            return -1;
        }
        if (startIndex < 0) {
            return -1;
        } else if (startIndex >= array.length) {
            startIndex = array.length - 1;
        }
        if (objectToFind == null) {
            for (int i = startIndex; i >= 0; i--) {
                if (array[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = startIndex; i >= 0; i--) {
                if (objectToFind.equals(array[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * <p>Checks if the object is in the given array.</p>
     *
     * <p>The method returns <code>false</code> if a <code>null</code> array is passed in.</p>
     * 
     * @param array  the array to search through
     * @param objectToFind  the object to find
     * @return <code>true</code> if the array contains the object
     */
    public static boolean contains(final Object[] array, final Object objectToFind) {
        return (indexOf(array, objectToFind) != -1);
    }

    // Primitive/Object converters
    // ----------------------------------------------------------------------
    /**
     * <p>Converts an array of object Booleans to primitives.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  a <code>Boolean</code> array, may be <code>null</code>
     * @return a <code>boolean</code> array
     * @throws NullPointerException if array content is <code>null</code>
     */
    public static boolean[] toPrimitive(final Boolean[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        final boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = array[i].booleanValue();
        }
        return result;
    }

    /**
     * <p>Converts an array of object Booleans to primitives handling null.</p>
     * 
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  a <code>Boolean</code> array, may be <code>null</code>
     * @param valueForNull  the value to insert if <code>null</code> found
     * @return a <code>boolean</code> array
     */
    public static boolean[] toPrimitive(final Boolean[] array, final boolean valueForNull) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BOOLEAN_ARRAY;
        }
        final boolean[] result = new boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            Boolean b = array[i];
            result[i] = (b == null ? valueForNull : b.booleanValue());
        }
        return result;
    }

    /**
     * <p>Converts an array of primitive booleans to objects.</p>
     *
     * <p>This method returns <code>null</code> if <code>null</code> input.</p>
     * 
     * @param array  a <code>boolean</code> array
     * @return a <code>Boolean</code> array
     */
    public static Boolean[] toObject(final boolean[] array) {
        if (array == null) {
            return null;
        } else if (array.length == 0) {
            return EMPTY_BOOLEAN_OBJECT_ARRAY;
        }
        final Boolean[] result = new Boolean[array.length];
        for (int i = 0; i < array.length; i++) {
            result[i] = (array[i] ? Boolean.TRUE : Boolean.FALSE);
        }
        return result;
    }

}
