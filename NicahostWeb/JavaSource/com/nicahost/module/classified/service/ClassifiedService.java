package com.nicahost.module.classified.service;

import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.RenderedImage;
import java.awt.image.WritableRaster;
import java.awt.image.renderable.ParameterBlock;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import javax.media.jai.InterpolationNearest;
import javax.media.jai.JAI;
import javax.media.jai.OpImage;
import javax.media.jai.RenderedOp;

import org.apache.struts.upload.FormFile;

import com.nicahost.common.util.IPathConverter;
import com.nicahost.common.util.PathConverter;
import com.nicahost.common.util.UniqueIdentifierGenerator;
import com.nicahost.common.util.vlh.ValueListHandler;
import com.nicahost.framework.common.exception.BaseException;
import com.nicahost.module.classified.bean.AdvertisementBean;
import com.nicahost.module.classified.bean.BankAccountBean;
import com.nicahost.module.classified.bean.CountryBean;
import com.nicahost.module.classified.bean.PaymentInfoBean;
import com.nicahost.module.classified.bean.ProfileBean;
import com.nicahost.module.classified.config.bean.ClasificadosInitParamBean;
import com.nicahost.module.classified.config.bean.ClasificadosInitParamDAO;
import com.nicahost.module.classified.dao.ClassifiedDAO;
import com.nicahost.module.classified.dto.AccountDTO;
import com.nicahost.module.classified.exception.ChangePasswordException;
import com.nicahost.module.classified.exception.UploadFileException;
import com.nicahost.module.classified.handler.BrowseListHandler;
import com.nicahost.module.classified.handler.SearchResultListHandler;
import com.sun.media.jai.codec.SeekableStream;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class ClassifiedService {

	private static ClassifiedService service = null;
	/**
	 * Constructor for ClassifiedService.
	 */
	private ClassifiedService() {		
	}
	
	
	public static ClassifiedService getInstance() {
		
		if (service == null) {
			service = new ClassifiedService();
		}
		
		return service;		
	}

	public Collection getCategoriesAsCollection() throws Exception {
		Collection res;
		ClasificadosInitParamDAO dao = ClasificadosInitParamDAO.getInstance();
		res = dao.getCategoriesAsCollection();		
		return res;
	}
	
	public Collection getCategoriesAsOptions() throws Exception {
		Collection res;
		ClasificadosInitParamDAO dao = ClasificadosInitParamDAO.getInstance();
		res = dao.getCategoriesAsOptions();		
		return res;
	}
	
	public Collection getNicaraguaBanks() throws Exception {
		Collection res;
		ClasificadosInitParamDAO dao = ClasificadosInitParamDAO.getInstance();
		res = dao.getNicaraguaBanks();
		return res;
	}
	

	
	public Collection getNicaraguaStates() throws Exception {
		Collection res = new ArrayList();
		ClasificadosInitParamDAO dao = ClasificadosInitParamDAO.getInstance();
		res = dao.getStatesForCountry("Nicaragua");
		
		return res;
	}

	public Collection getNicaraguaRegions() throws Exception {
		Collection res = new ArrayList();
		ClasificadosInitParamDAO dao = ClasificadosInitParamDAO.getInstance();
		res = dao.getRegionsForCountry("Nicaragua");
		
		return res;
	}
	
	public Collection getWorldWideStates() throws Exception {
		Collection res = new ArrayList();
		ClasificadosInitParamDAO dao = ClasificadosInitParamDAO.getInstance();
		res = dao.getStatesForCountry("World Wide");
		
		return res;
	}	

	public Collection getWorldWideRegions() throws Exception {
		Collection res = new ArrayList();
		ClasificadosInitParamDAO dao = ClasificadosInitParamDAO.getInstance();
		res = dao.getRegionsForCountry("World Wide");
		
		return res;
	}	

	
	public Collection getShippingLocations() throws Exception {
		ClasificadosInitParamDAO dao = ClasificadosInitParamDAO.getInstance();
		return dao.getShippingLocations();		
	}
	
	public Collection getPicks() throws Exception {
		ClasificadosInitParamDAO dao = ClasificadosInitParamDAO.getInstance();
		
		return dao.getPicks();
	}
		
	public String getCategoryName(String catId) {
		String res = null;
		ClasificadosInitParamDAO dao = ClasificadosInitParamDAO.getInstance();
		res = dao.getCategoryName(catId);
		return res;
	}
	
	public ProfileBean addNewUser(String email, String userName, String password) throws Exception {
		AccountDTO dto = new AccountDTO(email,userName,password);		
		ClassifiedDAO dao = new ClassifiedDAO();
		dao.addNewUser(dto);
		
		//Aqui para devolver el profile del usuario recien agregado
		// Sera necesario volver a llamar al dao?  Se supone que si solo fue recien agregado, entonces
		// solo posee email, uname y password?  
		ProfileBean bean = null;
		bean = dao.getProfile(email,userName);
		
		return bean;
	}
	
	public boolean changePassword(String email, String oldPassword, String newPassword) throws Exception {
		boolean res = false;
		ClassifiedDAO dao = new ClassifiedDAO();
		res = dao.changePwd(email,oldPassword,newPassword);
		
		return res;
	}
	
	public boolean forgotPassword(String email) throws Exception {
		boolean res = false;
		ClassifiedDAO dao = new ClassifiedDAO();
		String newpass = dao.generateTempPwd(email);
		ClassifiedMailService mailService = ClassifiedMailService.getInstance();
		mailService.sendMessageNewPassword(email,newpass);
		
		return res;
	}
	
	public ProfileBean authenticate(String email, String password) throws Exception {
		ProfileBean bean = new ProfileBean();
		ClassifiedDAO dao = new ClassifiedDAO();
		
		if (dao.authenticate(email, password)) {
			bean = dao.getProfile(email,null);
		}
		
		if (bean.getStatus().equals(ClassifiedDAO.STATUS_NEWPASSWORD)) {
			throw new ChangePasswordException();
		}

		
		return bean;
	}
	
	public ProfileBean getProfile(String email, String userName, String password) throws Exception {
		ProfileBean bean = new ProfileBean();
		ClassifiedDAO dao = new ClassifiedDAO();
		
		if (dao.authenticate(email, password)) {
			bean = dao.getProfile(email,userName);
		}
		
		if (bean.getStatus().equals(ClassifiedDAO.STATUS_NEWPASSWORD)) {
			throw new ChangePasswordException();
		}		
		return bean;
	}
	
	
	public boolean insertAdvertisement(AdvertisementBean adBean) throws Exception {
		boolean success = false;
		int res = 0;
		ClassifiedDAO dao = new ClassifiedDAO();
		System.out.println("Entrando al insertAdvertisement del service");
		res = dao.doInsert(adBean);
		
		if (res > 0) {		
			success=true;
			//vuelvo a cargar los parametros de la categoria cada vez que inserto un nuevo registro
			ClasificadosInitParamDAO.loadCategories();
		}
		
		return success;
	}
	
	public boolean addNewSellerAccount(PaymentInfoBean creditcards, BankAccountBean bankaccount, ProfileBean user, String sellingFee) throws Exception {
		ClassifiedDAO dao = new ClassifiedDAO();
		int res = dao.addNewSellerAccount(creditcards,bankaccount,user,sellingFee);
		
		boolean success = res<0?false:true;		
		return success;
	}
	
	public boolean activateSellerAccount(String email) throws Exception {
		ClassifiedDAO dao = new ClassifiedDAO();
		int res = dao.activateSellerAccount(email);
		
		boolean success = res <0?false:true;		
		return success;
	}
	
	
	public ValueListHandler getResult(String criteria) throws Exception {
		ValueListHandler res = null;
		
		boolean isBrowse = false;
		try {
			int cat = Integer.valueOf(criteria).intValue();
			isBrowse = true;
		} catch (Exception ex) {
			isBrowse = false;
		}
	
		if (isBrowse) {
			res = this.browseBySubject(criteria);
		} else {
			res = this.searchCriteria(criteria);
		}
			
		return res;	
	}
	
	
	public ValueListHandler browseBySubject(String catId) throws Exception {
		BrowseListHandler listHandler = null;
		
		try {
			int cat = Integer.valueOf(catId).intValue();
		} catch (Exception ex) {
			throw new BaseException("error.criteria.arg");
		}
		
		listHandler = new BrowseListHandler(catId);
		listHandler.executeSearch();
		
		if (listHandler.getSize() <= 0) {
			throw new BaseException("error.result.empty");
		}
			
		return listHandler;
				
	}
	
	public AdvertisementBean getItem(String itemId) throws Exception {
		try {
			int Id = Integer.valueOf(itemId).intValue();
		} catch (Exception ex) {
			throw new BaseException("error.result.empty");
		}
		
		ClassifiedDAO dao = new ClassifiedDAO();
		
		return dao.getItem(itemId);
		
	}
	
	
	public ValueListHandler searchCriteria(String criteria) throws Exception {
		SearchResultListHandler listHandler = null;
		
		criteria = criteria.trim();
		
		if (criteria == null || criteria.trim().equals("")) {
			throw new BaseException("error.criteria.empty");			
		}
		
		if (criteria.toLowerCase().startsWith("and") || criteria.toLowerCase().startsWith("or")) {
			throw new BaseException("error.criteria.arg");	
		}
		
		if (criteria.toLowerCase().endsWith("and") || criteria.toLowerCase().endsWith("or")) {
			throw new BaseException("error.criteria.arg");	
		}
		
		listHandler = new SearchResultListHandler(criteria);
		listHandler.executeSearch();

		if (listHandler.getSize() <= 0) {
			throw new BaseException("error.result.empty");
		}
		
		return listHandler;			
					
	}
	
	
	public String uploadFile(FormFile myFile) throws Exception { 

		String res = myFile.getFileName() == null? "":myFile.getFileName();    
		
		if (myFile.getFileSize() > 0 ) {				
				String imgPath = ClasificadosInitParamBean.getInstance().getValue("uploadimgpath");
				String fileName;
				IPathConverter pathConverter = new PathConverter();
				imgPath = pathConverter.getAbsolutePath(imgPath);
				fileName = UniqueIdentifierGenerator.generateCode() + myFile.getFileName();
				try {					
					FileOutputStream fos = new FileOutputStream(imgPath + File.separator + fileName);
					
					fos.write(myFile.getFileData());
					res = fileName;
					fos.close();				
				} catch (FileNotFoundException fnfex) { 
					fnfex.printStackTrace();
					throw new UploadFileException();				
				} catch (IOException ioex) {
					ioex.printStackTrace();
					throw new UploadFileException();
				}
			}			
			
		return res;
	}
	
	/** http://java.about.com/library/weekly/aa_img_resize.htm */
	public RenderedOp resizeImageMethod1(FormFile myFile, int width, int height) throws Exception {
		RenderedOp objImage = null;
		if (myFile.getFileSize()>0) {
			try {
				InputStream is = myFile.getInputStream();
				SeekableStream s = SeekableStream.wrapInputStream(is,true);
				objImage = JAI.create("stream",s);
				((OpImage) objImage.getRendering()).setTileCache(null);
				float xScale = width / objImage.getWidth();
				float yScale = height / objImage.getHeight();
				
				ParameterBlock pb = new ParameterBlock();
				pb.addSource(objImage);		// the source image
				pb.add(xScale);				// the xScale
				pb.add(yScale);				// the yScale
				pb.add(0.0F);				//the x translation
				pb.add(0.0F);				//the y translation
				pb.add(new InterpolationNearest()); //the interpolation
				
				objImage = JAI.create("scale",pb,null);
				
			} catch(FileNotFoundException foe) {
				foe.printStackTrace();
				throw new UploadFileException();
			}
		}
		
		return objImage;
	}
	
	public void resizeImageMethod2(FormFile myFile, int width, int height) throws Exception {
		RenderedImage img = null; 
		BufferedImage bimg = fromRenderedToBuffered(img);
		bimg.getScaledInstance(width,height,0);
	}
	
	/** http://www.mambo.net/as/view/175 */
	public BufferedImage fromRenderedToBuffered(RenderedImage img) {
			if (img instanceof BufferedImage) {
				return (BufferedImage) img;
			}

			ColorModel     cm = img.getColorModel();
			int            w  = img.getWidth();
			int            h  = img.getHeight();
			WritableRaster raster = cm.createCompatibleWritableRaster(w,h);
			boolean        isAlphaPremultiplied = cm.isAlphaPremultiplied();
			Hashtable      props = new Hashtable();
			String []      keys = img.getPropertyNames();

			if (keys != null) {
				for (int i = 0 ; i < keys.length ; i++) {
					props.put(keys[i], img.getProperty(keys[i]));
				}
			}
			BufferedImage ret = new BufferedImage(cm, raster,
												  isAlphaPremultiplied,
												  props);
			img.copyData(raster);
			return ret;
		}
	
	
	public void deleteUploadedFile(String _fileName) {
		String fileName = _fileName==null?"":_fileName;
		
		String imgPath = ClasificadosInitParamBean.getInstance().getValue("uploadimgpath");
		IPathConverter pathConverter = new PathConverter();
		imgPath = pathConverter.getAbsolutePath(imgPath);
		if (!fileName.equals("")) {
			File f = new File(imgPath + File.separator + fileName);
			f.delete();
			
		}
	}	
	

}
