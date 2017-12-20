// Comparator Utilities 
// Copyright (c) 2002 Alex Blewitt <Alex.Blewitt@ioshq.com>
// Copyright (c) 2002 JavaWorld
// First published by JavaWorld in December 2002
// http://www.javaworld.com/javaworld/jw-12-2002/jw-1227-sort.html
//
//    This library is free software; you can redistribute it and/or
//    modify it under the terms of the GNU Lesser General Public
//    License as published by the Free Software Foundation; either
//    version 2.1 of the License, or (at your option) any later version.
//
//    This library is distributed in the hope that it will be useful,
//    but WITHOUT ANY WARRANTY; without even the implied warranty of
//    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
//    Lesser General Public License for more details.
//
//    You should have received a copy of the GNU Lesser General Public
//    License along with this library; if not, write to the Free Software
//    Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
//  
//    Alternatively, it is downloadable at http://www.gnu.org/licenses/lgpl.txt
//
//  For more information, see the COPYRIGHT notice in the root directory

 
package com.nicahost.common.util;

import java.util.Comparator;


/** Allows two comparators to be merged together.
 * 
 * Allows two compatarators to be merged, so that if the major comparator
 * returns equal, the other comparator is used. This can then be used to form
 * composite comparaisons.
 *
 * <P><B>Example</B>
 * <PRE>
 * java.util.Collections.sort(list,
 *   new CompositeComparator(
 *    new BeanPropertyComparator("lastName"),
 *    new BeanPropertycComparator("firstName")
 *   )
 *  );
 * </PRE>
 *
 * The example above sorts items on last name, and then first name. Two beans
 * with the same last name will then be sorted on first name.
 * @see BeanPropertyComparator
 * @author Alex Blewitt &lt;<I><A href="mailto:Alex.Blewitt@ioshq.com">Alex.Blewitt@ioshq.com</A></I>&gt;
 * @version 1.0
 */
public class CompositeComparator implements Comparator {
    /** The major comparator.
     */
    private Comparator major;
    /** The minor comparator.
     */
    private Comparator minor;
    /** Create a new <CODE>CompositeComparator</CODE> using the given comparators.
     * @param major the most significant comparator
     * @param minor the least significant comparator
     */    
    public CompositeComparator(Comparator major, Comparator minor) {
        this.major = major;
        this.minor = minor;
    }
    
    /** Compare two objects using the comparators given.
     * 
     * Compares using the most significant comparator first. If they are
     * equal, then returns the comparison with the least significant comparator.
     * @param o1 the object to compare
     * @param o2 the object to compare to
     * @return 
     * <PRE>
     * int result = major.compare(o1,o2);
     * if (result != 0) {
     *   return result;
     * } else {
     *   return minor.compare(o1,o2);
     * }
     * </PRE>
     */    
    public int compare(Object o1, Object o2) {
        int result = major.compare(o1,o2);
        if (result != 0) {
            return result;
        } else {
            return minor.compare(o1,o2);
        }
    }
    
}
