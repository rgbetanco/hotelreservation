var expDays = 1; // number of days the cookie should last
function GetCookiePopup (name) {  
var arg = name + "=";  
var alen = arg.length;  
var clen = document.cookie.length;  
var i = 0;  
while (i < clen) {    
var j = i + alen;    
if (document.cookie.substring(i, j) == arg)      
return getCookieValPopup (j);    
i = document.cookie.indexOf(" ", i) + 1;    
if (i == 0) break;   
}  
return null;
}

function SetCookiePopup (name, value) {  
var argv = SetCookiePopup.arguments;  
var argc = SetCookiePopup.arguments.length;  
var expires = (argc > 2) ? argv[2] : null;  
var path = (argc > 3) ? argv[3] : null;  
var domain = (argc > 4) ? argv[4] : null;  
var secure = (argc > 5) ? argv[5] : false;  
document.cookie = name + "=" + escape (value) + 
((expires == null) ? "" : ("; expires=" + expires.toGMTString())) + 
((path == null) ? "" : ("; path=" + path)) +  
((domain == null) ? "" : ("; domain=" + domain)) +    
((secure == true) ? "; secure" : "");
}

function DeleteCookiePopup (name) {  
var exp = new Date();  
exp.setTime (exp.getTime() - 1);  
var cval = GetCookiePopup (name);  
document.cookie = name + "=" + cval + "; expires=" + exp.toGMTString();
}
var exp = new Date(); 
exp.setTime(exp.getTime() + (expDays*24*60*60*1000));

function amtPopup(){
var count = GetCookiePopup('count')
if(count == null) {
SetCookiePopup('count','1')
return 1
}
else {
var newcount = parseInt(count) + 1;
DeleteCookiePopup('count')
SetCookiePopup('count',newcount,exp)
return count
   }
}

function getCookieValPopup(offset) {
var endstr = document.cookie.indexOf (";", offset);
if (endstr == -1)
endstr = document.cookie.length;
return unescape(document.cookie.substring(offset, endstr));
}


function vtn(url,w,h) {

	var defaultW=360;
	var defaultH=550;
	var winl = (screen.width-w)/2;
	var wint = (screen.height-h)/2;
	var settings = 'location=0,status=0,scrollbars=0,toolbar=0,menubar=0,directories=0,resizable=0,';
	settings +='width='+w+',';
	settings +='height='+h;
	
//	Date fecha = new Date();
	
	
	if (url != "") {
		url = '/NicahostWeb' + url;
		testwindow= window.open (url, "mywindow", settings);

		testwindow.moveTo(winl,wint);
	} //end if
	
	return true;
}

//Funcion que carga una ventana
function poponload() {
	var url = ""
	var w=360;
	var h=550;
	var winl = (screen.width-(w-350))/2;
	var wint = (screen.height-h)/2;
	var settings = 'location=0,status=0,scrollbars=0,toolbar=0,menubar=0,directories=0,resizable=0,';
	settings +='width='+w+',';
	settings +='height='+h;
	
	date = new Date();
	
	if (url != "") {
		testwindow= window.open (url, date, settings);

		testwindow.moveTo(winl,wint);
	} //end if
}

function checkCountPopup() {
	var expDays = 1; // number of days the cookie should last
	var count = GetCookiePopup('count');
	if (count == null) {
		count=1;
		SetCookiePopup('count', count, exp);

		poponload();

	} else {
		count++;
		SetCookiePopup('count', count, exp);
   }
}
