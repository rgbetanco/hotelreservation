package com.nicahost.common.util.vlh;

import java.util.List;
import java.util.ListIterator;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */

public interface ValueListIterator extends ListIterator{
    
  public int getSize() 
    throws ValueListHandlerException;
    
  public Object getCurrentElement() 
    throws ValueListHandlerException;
    
  public List getPreviousElements(int count) 
    throws ValueListHandlerException;
    
  public List getNextElements(int count) 
    throws ValueListHandlerException;
    
  public void resetIndex()
    throws ValueListHandlerException;

  // other common methods as required

}

