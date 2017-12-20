// utils.js

/******************************** Variables globales. ********************************/

// expresiones regulares para reemplazar tildes y eñes.
var ntildeRe = new RegExp ('&ntilde;', 'g') ;
var ntildeCapRe = new RegExp ('&Ntilde;', 'g');
var aacuteRe = new RegExp ('&aacute;', 'g');
var aacuteCapRe = new RegExp ('&Aacute;', 'g');
var eacuteRe = new RegExp ('&eacute;', 'g');
var eacuteCapRe = new RegExp ('&Eacute;', 'g');
var iacuteRe = new RegExp ('&iacute;', 'g');
var iacuteCapRe = new RegExp ('&Iacute;', 'g');
var oacuteRe = new RegExp ('&oacute;', 'g');
var oacuteCapRe = new RegExp ('&Oacute;', 'g');
var uacuteRe = new RegExp ('&uacute;', 'g');
var uacuteCapRe = new RegExp ('&Uacute;', 'g');
var uumlRe = new RegExp ('&uuml;', 'g');
var uumlCapRe = new RegExp ('&Uuml;', 'g');
// jsanca: expresion para verificar si es una cantidad.
var IS_AMOUNT_EXPRESSION = "^-?(\\d)+(\\.(\\d)+)*$";
// Patron para uso de las fechas
var DD_MM_YYYY = "dd/MM/yyyy";
// Patron para uso de las fechas
var MM_DD_YYYY = "MM/dd/yyyy";

/************************************* Funciones. *************************************/

/**
Carga la página y los componentes que requieran inicialización.
jvillalobos. 08-11-2004
*/
function loadBody(selectedMenuOption) {
	// oculta las listas del menú. Se hace de esta manera para que los usuarios
	// que no tienen javascript habilitado puedan ver las opciones.
	// se llama 2 veces a la función porque en el primer llamado se asigna el
	// display como block y en el segundo llamado se asigna como none.
	toggleObject("BankProductsItemSubOptionList","block");
	toggleObject("BankProductsItemSubOptionList","block");
	toggleObject("CreditProductsItemSubOptionList", "block");
	toggleObject("CreditProductsItemSubOptionList", "block");
	toggleObject("InvestmentProductsItemSubOptionList", "block");
	toggleObject("InvestmentProductsItemSubOptionList", "block");
}

/*
Resalta una serie de elementos en el menú para hacer notar cuál opción está seleccionada.
jvillalobos. 22-09-2004
*/
function selectMenuItem(option, subOptionList, subOption) {
	var opt = findObject(option);
	var subOpt;
	
	if (opt) {
		opt.style["fontWeight"] = "bold";
		
		if (toggleObject(subOptionList, "block")) {
			toggleObject(subOption, "inline");
		}
	}
}

/*
Encuentra un objeto en el documento.
jvillalobos. 14-09-2004
*/
function findObject(n, d) {

	var p,i,x;
	
	if(!d){
		d = document;
	}

	if((p = n.indexOf("?")) > 0 && parent.frames.length) {
    	d=parent.frames[n.substring(p+1)].document; n=n.substring(0,p);
    }
    
	if(!(x=d[n])&&d.all) {
		x=d.all[n];
	}
	
	for (i=0;!x&&i<d.forms.length;i++) {
		x=d.forms[i][n];
	}
	
  	for(i=0;!x&&d.layers&&i<d.layers.length;i++) {
  		x = findObject(n,d.layers[i].document);
  	}
	
	if(!x && d.getElementById) {
		x = d.getElementById(n);
	}
	
	return x;
}

/*
Realiza un efecto de rollover sobre una imagen.
jvillalobos. 14-09-2004
*/
function rollOverImage() {
	var i,x;
	var j=0;
	var a = rollOverImage.arguments;
	
	document.preloadedImages = new Array;
  
	for(i = 0; i < (a.length-2); i += 3) {
		if ((x = findObject(a[i])) != null){
			document.preloadedImages[j++] = x;
			
			if(!x.oSrc) {
				x.oSrc = x.src;
			}
			
			x.src = a[i+2];
		}
	}
}

/*
Realiza un efecto de rollout en una imagen.
jvillalobos. 14-09-2004
*/
function rollOutImage() {
	var i, x, a=document.preloadedImages;
	
	for(i = 0; a && i < a.length && (x = a[i]) && x.oSrc; i++) {
		x.src=x.oSrc;
	}
}

/*
Aparece / desaparece un objeto. 'name' es el nombre del objeto y 'type' es el tipo de
display del objeto (block o inline). Retorna false si el objeto no fue encontrado.
jvillalobos. 21-09-2004
*/
function toggleObject(name, type) {
	var obj = findObject(name);
	var result = false;

	if(obj){
		if (obj.style["display"] == null || obj.style["display"] == "none" ||
			obj.style["display"] == "") {

			if(type) {
				obj.style["display"] = type;
			} else {
				obj.style["display"] = "block";
			}
		} else {
			obj.style["display"] = "none";
		}
		
		result = true;
	}

	return result;
}


/**
Permite controlar los submits dobles. Muestra un mensaje si el usuario intenta
hacer doble submit.
*/
function validSubmit() {
	var result = false;
	submitCount++;
	
	if (submitCount == 1) {
		result = true;
	} else {
		alert(redirectLabel);
	}	
	return result;
}

/**
Permite controlar los submits dobles. 
Ejecuta el submit del FORM.
*/
function singleSubmit(form) {

	var result = validSubmit();
	if (result) {
		form.submit();
	} 	
	return result;
}

/**
 * Reemplaza las ocurrencias de referencias a entidades HTML (e.g. &ntilde ;, &aacute ;,...)
 * por sus caracteres equivalentes.
 */
function replaceCharacterEntities(str) {
	// ver las variables globales.
	str = str.replace(ntildeRe, 'ñ');
	str = str.replace(ntildeCapRe, 'Ñ');
	str = str.replace(aacuteRe, 'á');
	str = str.replace(aacuteCapRe, 'Á');
	str = str.replace(eacuteRe, 'é');
	str = str.replace(eacuteCapRe, 'É');
	str = str.replace(iacuteRe, 'í');
	str = str.replace(iacuteCapRe, 'Í');
	str = str.replace(oacuteRe, 'ó');
	str = str.replace(oacuteCapRe, 'Ó');
	str = str.replace(uacuteRe, 'ú');
	str = str.replace(uacuteCapRe, 'Ú');
	str = str.replace(uumlRe, 'ü');
	str = str.replace(uumlCapRe, 'Ü');
	return str;
}

/**
 * Selecciona del select, el item con el indice indicado en index.
 */
function selectIndex (select, index) {
	if ( index < select.length) {select.selectedIndex = index;}
} // selectIndex.

/**
 * Selecciona del select, el item con el value indicado en option.
 */
function selectOption (select, option) {
	for (var i = 0; i < select.length; ++i) {
		if (select.options[i].value == option) {
			select.options [i].selected = true;
			return;  
	    }
	}
} // selectOption.

/**
 * Hides - shows a group of tags by the id value and the tag type
 * @param tag tag type, i.e.: 'tr' 'a'
 * @param tagId id value
 * @param hide if true hides the tags, otherwise shows the hidden tags
 */
function hideTags(tag, tagId, hide)
{
     obj = document.getElementsByTagName(tag);

	 for (i=0; i<obj.length; i++) {
		if (obj[i].id == tagId) {
			if (hide) { obj[i].style.display = ''; }
			else      { obj[i].style.display = 'none'; }
		}
     }
}

/**
 * Allows writing only numbers that may contain a dot in a textbox. Do not allows negative numbers
 * @param event the keypressed event
 * @param obj the object to be checked
 * @usage i.e. <input type='text' onkeypress='return checkNum(event,this)'/>
 */
function checkNumber(event, obj) {
	var noIE=false;
	if (!event) var event = window.event;
	if (event.keyCode) code = event.keyCode;
	else if (event.which) {code = event.which; noIE=true;}
	// check double dot
	if (obj.value.indexOf('.') != -1 && code == 46) return false; 

	return ( (code >= 48 && code <= 57 ) || code == 46 || code == 8 || (code == 35 && noIE==true) );
}
/**
 * Allows writing only numbers,with no dots in a textbox. Do not allows negative numbers
 * @param event the keypressed event
 * @param obj the object to be checked
 * @usage i.e. <input type='text' onkeypress='return checkNum(event,this)'/>
 */
function checkNumberNoDot(event, obj) {
	var noIE=false;
	if (!event) var event = window.event;
	if (event.keyCode) code = event.keyCode;
	else if (event.which) {code = event.which; noIE=true;}
	return ( (code >= 48 && code <= 57 ) || code == 8 || (code == 35 && noIE==true) );
}
/*
* Checks that the keys CRTL+V are not pressed
* @param event the keydown event
* @param obj the object to be checked
* @return false if the CRTL+V is pressed otherwise returns true
*/
function noPaste(event, obj){

	if (event.modifiers && Event.CONTROL_MASK){
	  return false; //netscape 4.0
	}
    else if (event.ctrlKey && (event.keyCode == 86)){
    	return false;//iexplorer, netscape 6.0, firefox
    }
    else return true;
    
}

/**
 * Check if VALUE is empty. Either 0 or "" or empty string "   ".
 * @param str input string
 * @return boolean
 * @see http://
 */
function isEmpty(str)
{
    ret = false;

    if ( typeof str == "string" )
    {
        if ( (str == "") || (str.search(/^\\s*$/) != -1) )
        {
            ret = true;
        }
    }
    else if ( typeof str == "number" )
    {
        if ( str == 0  || str == 0.0 ) ret = true;
    }
    return ret;
}

/**
 * Parsea un String y lo convierte en un objeto de fecha de javascript
 * si no se especifica el formato utiliza el formato DD_MM_YYYY por defecto
 * @param str String que contiene la fecha a parsear
 * @param dateFormat String que contiene el formato de la fecha
 */
function parseDate( str, dateFormat )
{   
	re = /(\d{1,2})\/(\d{1,2})\/(\d{4})/
	var arr = re.exec( str );
	var mDate;

	if (dateFormat){
	  if (dateFormat == DD_MM_YYYY){
		  mDate = new Date( parseInt(arr[3]), parseInt(arr[2], 10) - 1, parseInt(arr[1], 10) );
	  }
	  else if (dateFormat == MM_DD_YYYY){
		  mDate = new Date( parseInt(arr[3]), parseInt(arr[1], 10) - 1, parseInt(arr[2], 10) );
		 }
	}
	else{
		mDate = new Date( parseInt(arr[3]), parseInt(arr[2], 10) - 1, parseInt(arr[1], 10) );
	}
	return mDate;
}
/**
* Compara amount1 con amount2
* Si es menor retorna -1
* Si es mayor retorna 1
* Si es igual retorna 0
*/
function compareAmount(amount1,amount2) {
    var result = 0;
    if (parseFloat(amount1) > parseFloat(amount2)) {
			result = 1;
	}
	else if (parseFloat(amount1) < parseFloat(amount2)) {
		result = -1;
	}
	return result;
}
/*
* Funcion que compara la fecha initDate con la fecha endDate se
* agrega el patrón de las fechas para su comparacion
* -1 en caso de que la fecha inicio sea menor que la fecha fin 
* 1 en caso de que la fecha inicio sea mayor que la fecha fin 
* 0 en cualquier otro caso
*/
function compareDate(initDate, endDate, datePattern) {
	var result = 0;
	var endDateCmp = parseDate(endDate, datePattern);
	var initDateCmp = parseDate(initDate, datePattern);
	//Verifica si la fecha de inicio es menor que la fecha final 
	if ( initDateCmp < endDateCmp)  {
		result =  -1;
	}//si la fecha final es mayor que la actual
	else if (initDateCmp > endDateCmp){
	    result = 1;
	}
	return result;
}

/*
*
*
*/
function diffDay(initDate, endDate,datePattern) {
	date1 = parseDate(initDate,datePattern).getTime();
	date2 = parseDate(endDate,datePattern).getTime();
	milsecdiff = date2 - date1;
	result = milsecdiff /(1000 * 60 * 60 * 24);
	return result;
}

/*********************************************************************************************************
  * Elimina los espacios en blanco de la cadena, al final de la cadena.
  * retorna la cadena sin espacios.
  * jsanca
  */
  function trimLast (svalue) {
     // Elimina uno o mas espacios.
          
     var re = /[ ]+/;    
     return svalue.replace (re,"");
  } // trim.
    
  /*********************************************************************************************************
  * Verifica si el string es un monto, verifica signo negativo.
  * retorna true si es un monto false en caso contrario.
  * jsanca
  */
  function isAmount (svalue) {
  
   var regExp = RegExp (IS_AMOUNT_EXPRESSION);
   return regExp.test (svalue);
  } // isAmount

   /* Realiza el submit del los form de descarga y resetea el contador de submit.
   jrgonzalez*/
   function submitDownload(form) {  	
     form.submit();
     submitCount = 0;
   }

   

function Num(evt,flg){	
	var key=nav4 ? evt.which : evt.keyCode;
	if(flg) return ((key <= 13) || (key >= 48 && key <= 57));
	if((key <= 13) || (key >= 48 && key <= 57)) return true;
	return false;
}

function Contar(f,formBodyName,formCounterName, maxlimite) {

	var body = getFormEle(f,formBodyName);
	var counter = getFormEle(f,formCounterName);
	var suma= maxlimite - body.value.length;	
	counter.value = suma;
	
	if(suma <= 0) {
		alert("Hey! la cantidad máxima de caracteres es de " + maxlimite + ".");
		var texto = body.value.substring(0,maxlimite);
		body.value = texto;
		return false;
	}
	return true;
}

function getFormEle(f,controlname) {
	var ele;
	for (i=0; i < f.length;i++) {
		if (f.elements[i].name == controlname) {
			ele = f.elements[i];
		}
	}	
	return ele;
}


function actualice(f, formBodyName) {
	var body = getFormEle(f,formBodyName);
	var suma= body.value.length;
	return suma;
}   
   