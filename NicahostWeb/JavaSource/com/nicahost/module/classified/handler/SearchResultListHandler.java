package com.nicahost.module.classified.handler;

import java.util.List;

import com.nicahost.common.util.vlh.ValueListHandler;
import com.nicahost.common.util.vlh.ValueListHandlerException;
import com.nicahost.module.classified.dao.ClassifiedDAO;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class SearchResultListHandler extends ValueListHandler {

	private String projectCriteria = null;


	public SearchResultListHandler(String proCriteria) {
		this.projectCriteria = proCriteria;
	}
	/**
	 * @see com.nicahost.common.util.vlh.ValueListHandler#executeSearch(Object)
	 */
	public void executeSearch(Object criteria) throws ValueListHandlerException {
		this.projectCriteria = (String) criteria; 
		this.executeSearch();
	}
  // executes search. Client can invoke this
  // provided that the search criteria has been
  // properly set. Used to perform search to refresh
  // the list with the latest data.

	  public void executeSearch()  throws ValueListHandlerException {
	    try {
    	  if (projectCriteria == null) {
        	throw new ValueListHandlerException("Project Criteria required...");
	      }
	      ClassifiedDAO dao = new ClassifiedDAO();
	      
    	  List resultsList =  dao.searchCriteria(projectCriteria);
		  setList(resultsList);
	    } catch (Exception e) {
    	  // Handle exception, throw ListHandlerException
	    }
	  }



}
