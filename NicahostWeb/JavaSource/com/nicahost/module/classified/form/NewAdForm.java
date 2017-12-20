package com.nicahost.module.classified.form;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.nicahost.common.util.IPathConverter;
import com.nicahost.common.util.PathConverter;
import com.nicahost.module.classified.config.bean.ClasificadosInitParamBean;

/**
 * @author henry
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class NewAdForm extends ActionForm {
	private static int MAX_FILE_SIZE;
	private String title;
	private String desc;
	private String name;
	private String phone;
	private String email;
	private String category;
	private String categoryName;
	private FormFile myFile;
	private String fileName;
	private String price;
	private String imgPath;
	private String duration;
	private String currency;
	
	

	
	/**
	 * Default constructor
	 */
	public NewAdForm() {
		
		super();
		this.resetFields();
	}

    /**
     * Called by the framework to validate the form.
     *
     * @param mapping The set of action mappings
     * @param request The http servlet request
     * @return The errors encountered during the validation, if any
     */
    public ActionErrors validate(ActionMapping mapping, HttpServletRequest request ){
		ActionErrors errors = new ActionErrors();    

		
		if (isEmpty(title)) {
			errors.add("title",new ActionMessage("error.title","titulo"));	
		}		
		
		if (isEmpty(desc)) {
			errors.add("desc",new ActionMessage("error.description","Descripcion"));		
		} else if (desc.length() > 250) {
			errors.add("desc",new ActionMessage("error.desctiptionTooLong","Muy largo"));		
		}
		
		if (isEmpty(name)) {
			errors.add("name",new ActionMessage("error.name","Nombre"));	
		}
		
		if (isEmpty(email) && isEmpty(phone)) {
			errors.add("contact",new ActionMessage("error.contact","contacto"));		
		}
		
		if (isEmpty(price)) {
			errors.add("price",new ActionMessage("error.price","Precio"));
		}
		
		if (isEmpty(currency)) {
			errors.add("currency",new ActionMessage("error.currency","moneda"));
		}
		
		categoryName = category.substring(category.lastIndexOf("_")+1);
		category = category.substring(0,category.lastIndexOf("_"));
		
		if (myFile.getFileSize() > 0 ) {
			if (myFile.getFileSize() > MAX_FILE_SIZE) {
				
				errors.add("image",new ActionMessage("error.image","imagen"));
			} else {					
				String imgPath = ClasificadosInitParamBean.getInstance().getValue("uploadimgpath");
				String fileName;
				IPathConverter pathConverter = new PathConverter();
				imgPath = pathConverter.getAbsolutePath(imgPath);
				File f = new File(imgPath);			
				fileName = f.getPath() + File.separator + myFile.getFileName();
			
				try {					
					FileOutputStream fos = new FileOutputStream(fileName);
					fos.write(myFile.getFileData());
					fos.close();				
				} catch (FileNotFoundException fnfex) { 
					fnfex.printStackTrace();
					errors.add("filenotfound", new ActionMessage("error.file"));				
				} catch (IOException ioex) {
					ioex.printStackTrace();
					errors.add("io", new ActionMessage("error.file"));
				}
			}
		}
		
		return errors;
    }


	private boolean isEmpty(String value) {
		boolean res = false;
		
		if (value == null || value.trim().equals("") )
			res = true;
			
		return res;			
	}
    /**
     * Called by the framework to reset the fields back to their default values.
     *
     * @param mapping The set of action mappings
     * @param request The http servlet request
     */
    public void reset(ActionMapping mapping, HttpServletRequest request) {
	// resetFields();  //NOTA: descomentar en caso que el form sea de scope session.
    }

    /**
    * Reset the fields back to their defaults.
    */
    protected void resetFields() {	
    	this.category = "";
    	this.desc = "";
    	this.email = "";
    	this.name = "";
    	this.phone = "";
    	this.title = "";
    	this.price = "";
    	this.imgPath = ClasificadosInitParamBean.getInstance().getValue(ClasificadosInitParamBean.TEMP_IMG);
    	this.currency = "";
    	this.duration = "";
    	MAX_FILE_SIZE =  Integer.parseInt(ClasificadosInitParamBean.getInstance().getValue("maxuploadimgsize"));
    	
    }
	

	/**
	 * Returns the category.
	 * @return String
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Returns the desc.
	 * @return String
	 */
	public String getDesc() {
		return desc;
	}

	/**
	 * Returns the email.
	 * @return String
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Returns the name.
	 * @return String
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the phone.
	 * @return String
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Returns the title.
	 * @return String
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the category.
	 * @param category The category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Sets the desc.
	 * @param desc The desc to set
	 */
	public void setDesc(String desc) {
		this.desc = desc;
	}

	/**
	 * Sets the email.
	 * @param email The email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Sets the name.
	 * @param name The name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the phone.
	 * @param phone The phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * Sets the title.
	 * @param title The title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return
	 */
	public FormFile getMyFile() {
		return myFile;
	}

	/**
	 * @param file
	 */
	public void setMyFile(FormFile file) {
		myFile = file;
	}

	/**
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @param string
	 */
	public void setFileName(String string) {
		fileName = string;
	}

	/**
	 * @return
	 */
	public String getPrice() {
		return price;
	}

	/**
	 * @param string
	 */
	public void setPrice(String string) {
		price = string;
	}

	/**
	 * @return
	 */
	public String getImgPath() {
		return imgPath;
	}

	/**
	 * @param string
	 */
	public void setImgPath(String string) {
		imgPath = string;
	}

	/**
	 * @return
	 */
	public String getCategoryName() {
		return categoryName;
	}

	/**
	 * @param string
	 */
	public void setCategoryName(String string) {
		categoryName = string;
	}

	/**
	 * @return
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * @return
	 */
	public String getDuration() {
		return duration;
	}

	/**
	 * @param string
	 */
	public void setCurrency(String string) {
		currency = string;
	}

	/**
	 * @param string
	 */
	public void setDuration(String string) {
		duration = string;
	}

}
