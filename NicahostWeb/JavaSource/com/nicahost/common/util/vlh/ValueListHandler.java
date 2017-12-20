package com.nicahost.common.util.vlh;

import java.util.Collection;
import java.util.LinkedList;
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
public abstract class ValueListHandler implements ValueListIterator {

  protected List list;
  protected ListIterator listIterator;


  protected void setList(List list) throws ValueListHandlerException {
    this.list = list;
    if(list != null)
      listIterator =  list.listIterator();
    else
      throw new ValueListHandlerException("List empty");
  }


  public Collection getList(){
    return list;
  }
   
   
  public abstract void executeSearch(Object criteria) throws ValueListHandlerException;
    
        

	/**
	 * @see com.nicahost.common.util.vlh.ValueListIterator#getSize()
	 */
	public int getSize() throws ValueListHandlerException {
	    int size = 0;
        
    	if (list != null)
	      size = list.size();
    	else
	      throw new ValueListHandlerException("No Data"); //No Data

	    return size;
	}

	/**
	 * @see com.nicahost.common.util.vlh.ValueListIterator#getCurrentElement()
	 */
	public Object getCurrentElement() throws ValueListHandlerException {
	    Object obj = null;
    	// Will not advance iterator
	    if (list != null)
    	{
	      int currIndex = listIterator.nextIndex();
    	  obj = list.get(currIndex);
	    }
    	else
	      throw new ValueListHandlerException("List is empty");
	      
    	return obj;

	}

	/**
	 * @see com.nicahost.common.util.vlh.ValueListIterator#getPreviousElements(int)
	 */
	public List getPreviousElements(int count) throws ValueListHandlerException {
	    int i = 0;
	    Object object = null;
    	LinkedList list = new LinkedList();
	    if (listIterator != null) {
    	  while (listIterator.hasPrevious() && (i < count)){
        	object = listIterator.previous();
	        list.add(object);
    	    i++;
	      }
	    }// end if
    	else
	      throw new ValueListHandlerException("List is empty"); // No data

	    return list;

	}

	/**
	 * @see com.nicahost.common.util.vlh.ValueListIterator#getNextElements(int)
	 */
	public List getNextElements(int count) throws ValueListHandlerException {
	    int i = 0;
    	Object object = null;
	    LinkedList list = new LinkedList();
    	if(listIterator != null){
	      while(  listIterator.hasNext() && (i < count) ){
    	    object = listIterator.next();
        	list.add(object);
	        i++;
    	  }
	    } // end if
    	else
	      throw new ValueListHandlerException("List is empty"); // No data

    return list;

	}

	/**
	 * @see com.nicahost.common.util.vlh.ValueListIterator#resetIndex()
	 */
	public void resetIndex() throws ValueListHandlerException {
	    if(listIterator != null){
    	  listIterator = list.listIterator();
	    }
    	else
	      throw new ValueListHandlerException("List is empty"); // No data
		
	}

	/**
	 * @see java.util.Iterator#hasNext()
	 */
	public boolean hasNext() {
		return listIterator.hasNext();
	}

	/**
	 * @see java.util.Iterator#next()
	 */
	public Object next() {
		Object object = null;
		
		if (listIterator != null) {
			if (listIterator.hasNext() )
				object = listIterator.next();	
		} 
		
		return object;
	}

	/**
	 * @see java.util.ListIterator#hasPrevious()
	 */
	public boolean hasPrevious() {
		return listIterator.hasPrevious();
	}

	/**
	 * @see java.util.ListIterator#previous()
	 */
	public Object previous() {
		Object object = null;
		
		if (listIterator != null) {
			if (listIterator.hasPrevious() )
				object = listIterator.previous();	
		}
		return object;

	}

	/**
	 * @see java.util.ListIterator#nextIndex()
	 */
	public int nextIndex() {
		return listIterator.nextIndex();
	}

	/**
	 * @see java.util.ListIterator#previousIndex()
	 */
	public int previousIndex() {
		return listIterator.previousIndex();
	}

	/**
	 * @see java.util.Iterator#remove()
	 */
	public void remove() 	{
		this.list = null;
		this.listIterator = null;
		
	}

	/**
	 * @see java.util.ListIterator#set(Object)
	 */
	public void set(Object o) {
		try {
			this.setList((List) o);
		} catch (ValueListHandlerException bex) {/* do nothing*/}
		
	}

	/**
	 * @see java.util.ListIterator#add(Object)
	 */
	public void add(Object o) {
		if (list != null) {
			list.add(o);
			listIterator = list.listIterator();
		} else {
			list = new LinkedList();
			list.add(o);
			listIterator = list.listIterator();
		}
	}


	public void setIndex(int offset) {

		if (offset < list.size() && offset >= 0) {		
			listIterator = list.listIterator(offset);
		}
		
	}

}
