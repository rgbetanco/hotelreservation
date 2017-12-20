package com.nicahost.module.classified.action;

import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.nicahost.common.util.vlh.ValueListHandler;
import com.nicahost.framework.common.exception.BaseException;
import com.nicahost.framework.common.form.FooterForm;
import com.nicahost.framework.common.form.HeaderForm;
import com.nicahost.module.classified.config.bean.ClasificadosInitParamBean;
import com.nicahost.module.classified.form.SearchForm;
import com.nicahost.module.classified.service.ClassifiedService;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class BrowseAction extends ClasificadosBaseAction {

	private static int hitsPerPage =
		Integer
			.valueOf(
				ClasificadosInitParamBean.getInstance().getValue(
					ClasificadosInitParamBean.MAX_HITS))
			.intValue();
	
	private static int maxPagesToShow = 10;

	/**
	 * @see com.nicahost.framework.common.action.BaseAction#executeAction(ActionMapping, ActionForm, HttpServletRequest, HttpServletResponse, HeaderForm, FooterForm)
	 */
	public ActionForward runAction(
		ActionMapping mapping,
		ActionForm form,
		HttpServletRequest request,
		HttpServletResponse response,
		HeaderForm headerForm,
		FooterForm footerForm)
		throws Exception {

		ActionForward forward = null;
		int pageIndex = 1;
		int indx = 0;
		
		SearchForm searchForm = (SearchForm) form;
		
		//String criteriaBrowse = request.getParameter("criteria");
		String criteriaParam = searchForm.getCriteria();
		
		String page = request.getParameter("page");
		String catIdParam = searchForm.getCatId();

		String criteria;
		
		if (criteriaParam != null && !criteriaParam.equals("")) {
			criteria = criteriaParam;
			searchForm.setCatId(null);	
		} else {
			criteria = catIdParam;
			searchForm.setCriteria(null);
		}

		ValueListHandler resultList = null;

		ClassifiedService service = ClassifiedService.getInstance();
		//		resultList = service.browseBySubject(catId);			
		resultList = service.getResult(criteria);

		int totalHits = resultList.getSize();
		int totalPages = totalHits / hitsPerPage;
		
		totalPages = totalPages * hitsPerPage < totalHits ? totalPages + 1: totalPages;
		
		request.setAttribute("resultList", resultList);
		request.setAttribute("totalHits", Integer.toString(totalHits));
		request.setAttribute("totalPages", Integer.toString(totalPages));
		request.setAttribute("criteria", criteria);

		try {
			if (page != null) {
				indx = Integer.valueOf(page).intValue();
			}

			indx = resultList.getSize() < indx ? pageIndex : indx;
			pageIndex = pageIndex > indx ? pageIndex : indx;

		} catch (Exception ex) {
			throw new BaseException("It's not a valid index");
		}

		int currentPage = pageIndex;

		pageIndex = (pageIndex * hitsPerPage) - hitsPerPage;

		resultList.setIndex(pageIndex);

		String hasPrevious = new Boolean(resultList.hasPrevious()).toString();

		Collection result = resultList.getNextElements(hitsPerPage);

		String hasNext = new Boolean(resultList.hasNext()).toString();
		
		int loopNumber = (currentPage / maxPagesToShow) + 1 ;
		int maxLastPage = loopNumber * maxPagesToShow;
		
		int minLastPage = currentPage <= maxPagesToShow ? (currentPage - maxPagesToShow) : 0;		
		minLastPage = minLastPage <= 0 ? 1 : minLastPage;
		
		maxLastPage = maxLastPage < (totalPages) ? maxLastPage : totalPages;
		//maxLastPage = maxLastPage <= maxPagesToShow ? 1 : maxLastPage;
		
		request.setAttribute("maxLastPage",Integer.toString(maxLastPage));
		request.setAttribute("minLastPage",Integer.toString(minLastPage));
		
		request.setAttribute("result", result);
		request.setAttribute("currentPage", Integer.toString(currentPage));
		request.setAttribute("hasNext", hasNext);
		request.setAttribute("hasPrevious", hasPrevious);
		
		Collection categories = service.getCategoriesAsCollection();				
		request.setAttribute("categories",categories);
		
		String imgPath = ClasificadosInitParamBean.getInstance().getValue(ClasificadosInitParamBean.TEMP_IMG);
		request.setAttribute("imgPath", imgPath);

		forward = mapping.findForward("Success");

		return forward;
	}

}
