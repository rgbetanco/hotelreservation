/**
This is a JavaScript library that will allow you to easily add some basic DHTML
drop-down datepicker functionality to your forms and pages. This script is not as
full-featured as others you may find on the Internet, but it's free, it's easy to
understand, and it's easy to change.

You'll also want to include a stylesheet that makes the datepicker elements
look nice. Example styles have been included directly in this HTML page for ease
of reference.

I've tested this lightly with Internet Explorer 6 and Mozilla Firefox. I have no idea
how compatible it is with other browsers. You are free to use this in any way you'd
like, with no charge or obligation.

version 1.3
September 9, 2004
Julian Robichaux -- http://www.nsftools.com

HISTORY
--  version 1.0 (Sept. 4, 2004):
Initial release.

--  version 1.1 (Sept. 5, 2004):
Added capability to define the date format to be used, either globally (using the
defaultDateSeparator and defaultDateFormat variables) or when the displayDatePicker
function is called.

--  version 1.2 (Sept. 7, 2004):
Fixed problem where datepicker x-y coordinates weren't right inside of a table.
Fixed problem where datepicker wouldn't display over selection lists on a page.
Added a call to the datePickerClosed function (if one exists) after the datepicker 
is closed, to allow the developer to add their own custom validation after a date
has been chosen. For this to work, you must have a function called datePickerClosed
somewhere on the page, that accepts a field object as a parameter. See the
example in the comments of the updateDateField function for more details.

--  version 1.3 (Sept. 9, 2004)
Fixed problem where adding the <div> and <iFrame> used for displaying the datepicker
was causing problems on IE 6 with global variables that had handles to objects on
the page (I fixed the problem by adding the elements using document.createElement()
and document.body.appendChild() instead of document.body.innerHTML += ...).
*/

var datePickerDivID = "datepicker";
var iFrameDivID = "datepickeriframe";

var dayShort1 = 'Do';
var dayShort2 = 'Lu'
var dayShort3 = 'Ma'
var dayShort4 = 'Mi'
var dayShort5 = 'Ju'
var dayShort6 = 'Vi'
var dayShort7 = 'Sa'

var dayMed1 = 'Dom';
var dayMed2 = 'Lun';
var dayMed3 = 'Mar';
var dayMed4 = 'Mie';
var dayMed5 = 'Jue';
var dayMed6 = 'Vie';
var dayMed7 = 'Sab';

var dayLong1 = 'Domingo';
var dayLong2 = 'Lunes';
var dayLong3 = 'Martes';
var dayLong4 = 'Miécoles';
var dayLong5 = 'Jueves';
var dayLong6 = 'Viernes';
var dayLong7 = 'Sábado';

var monthShort1 = 'Ene';
var monthShort2 = 'Feb';
var monthShort3 = 'Mar';
var monthShort4 = 'Abr';
var monthShort5 = 'May';
var monthShort6 = 'Jun';
var monthShort7 = 'Jul';
var monthShort8 = 'Ago';
var monthShort9 = 'Set';
var monthShort10 = 'Oct';
var monthShort11 = 'Nov';
var monthShort12 = 'Dic';

var monthMed1 = 'Ene';
var monthMed2 = 'Feb';
var monthMed3 = 'Mar';
var monthMed4 = 'Abr';
var monthMed5 = 'May';
var monthMed6 = 'Jun';
var monthMed7 = 'Jul';
var monthMed8 = 'Ago';
var monthMed9 = 'Set';
var monthMed10 = 'Oct';
var monthMed11 = 'Nov';
var monthMed12 = 'Dic';

var monthLong1 = 'Enero';
var monthLong2 = 'Febrero';
var monthLong3 = 'Marzo';
var monthLong4 = 'Abril';
var monthLong5 = 'Mayo';
var monthLong6 = 'Junio';
var monthLong7 = 'Julio';
var monthLong8 = 'Agosto';
var monthLong9 = 'Setiembre';
var monthLong10 = 'Octubre';
var monthLong11 = 'Noviembre';
var monthLong12 = 'Diciembre';

var thisDayStr = 'Hoy';
var closeStr = 'Cerrar'

//var dayArrayShort = new Array('Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa');
var dayArrayShort = new Array(dayShort1, dayShort2, dayShort3, dayShort4, dayShort5, dayShort6, dayShort7);
//var dayArrayMed = new Array('Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat');
var dayArrayMed = new Array(dayMed1, dayMed2, dayMed3, dayMed4, dayMed5, dayMed6, dayMed7);
//var dayArrayLong = new Array('Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday', 'Friday', 'Saturday');
var dayArrayLong = new Array(dayLong1, dayLong2, dayLong3, dayLong4, dayLong5, dayLong6, dayLong7);
//var monthArrayShort = new Array('Jan', 'Feb', 'Mar', 'Apr', 'May', 'Jun', 'Jul', 'Aug', 'Sep', 'Oct', 'Nov', 'Dec');
var monthArrayShort = new Array(monthShort1, monthShort2, monthShort3, monthShort4, monthShort5, monthShort6, monthShort7, monthShort8, monthShort9, monthShort10, monthShort11, monthShort12);
//var monthArrayMed = new Array('Jan', 'Feb', 'Mar', 'Apr', 'May', 'June', 'July', 'Aug', 'Sept', 'Oct', 'Nov', 'Dec');
var monthArrayMed = new Array(monthMed1, monthMed2, monthMed3, monthMed4, monthMed5, monthMed6, monthMed7, monthMed8, monthMed9, monthMed10, monthMed11, monthMed12);
//var monthArrayLong = new Array('January', 'February', 'March', 'April', 'May', 'June', 'July', 'August', 'September', 'October', 'November', 'December');
var monthArrayLong = new Array(monthLong1, monthLong2, monthLong3, monthLong4, monthLong5, monthLong6, monthLong7, monthLong8, monthLong9, monthLong10, monthLong11, monthLong12);
  
// these variables define the date formatting we're expecting and outputting.
// If you want to use a different format by default, change the defaultDateSeparator
// and defaultDateFormat variables either here or on your HTML page.
var defaultDateSeparator = "/";		// common values would be "/" or "."
//var defaultDateFormat = "mdy"	// valid values are "mdy", "dmy", and "ymd"
var defaultDateFormat = "dd/MM/yyyy"	// valid values are "dd/MM/yyyy", "MM/dd/yyyy", and "yyyy/MM/dd"
var dateSeparator = defaultDateSeparator;
var dateFormat = defaultDateFormat;

/**
This is the main function you'll call from the onClick event of a button.
Normally, you'll have something like this on your HTML page:

Start Date: <input name="StartDate"> 
<input type=button value="select" onclick="displayDatePicker('StartDate');">

That will cause the datepicker to be displayed beneath the StartDate field and
any date that is chosen will update the value of that field. If you'd rather have the
datepicker display beneath the button that was clicked, you can code the button
like this:

<input type=button value="select" onclick="displayDatePicker('StartDate', this);">

So, pretty much, the first argument (dateFieldName) is a string representing the
name of the field that will be modified if the user picks a date, and the second
argument (displayBelowThisObject) is optional and represents an actual node
on the HTML document that the datepicker should be displayed below.

In version 1.1 of this code, the dtFormat and dtSep variables were added, allowing
you to use a specific date format or date separator for a given call to this function.
Normally, you'll just want to set these defaults globally with the defaultDateSeparator
and defaultDateFormat variables, but it doesn't hurt anything to add them as optional
parameters here. An example of use is:

<input type=button value="select" onclick="displayDatePicker('StartDate', false, 'dmy', '.');">

This would display the datepicker beneath the StartDate field (because the 
displayBelowThisObject parameter was false), and update the StartDate field with
the chosen value of the datepicker using a date format of dd.mm.yyyy
*/
function displayDatePicker(dateFieldName, displayBelowThisObject, dtFormat, dtSep)
{
  var targetDateField = document.getElementsByName(dateFieldName).item(0);
  
  // if we weren't told what node to display the datepicker beneath, just display it
  // beneath the date field we're updating
  if (!displayBelowThisObject)
    displayBelowThisObject = targetDateField;
  
  // if a date separator character was given, update the dateSeparator variable
  if (dtSep)
    dateSeparator = dtSep;
  else
    dateSeparator = defaultDateSeparator;
  
  // if a date format was given, update the dateFormat variable
  if (dtFormat)
    dateFormat = dtFormat;
  else
    dateFormat = defaultDateFormat;
  
  var x = displayBelowThisObject.offsetLeft;
  var y = displayBelowThisObject.offsetTop + displayBelowThisObject.offsetHeight;
  
  // deal with elements inside tables and such
  var parent = displayBelowThisObject;
  while (parent.offsetParent) {
    parent = parent.offsetParent;
    x += parent.offsetLeft;
    y += parent.offsetTop;
  }
  
  drawDatePicker(targetDateField, x, y);
}


/**
Draw the datepicker object (which is just a table with calendar elements) at the
specified x and y coordinates, using the targetDateField object as the input tag
that will ultimately be populated with a date.

This function will normally be called by the displayDatePicker function.
*/
function drawDatePicker(targetDateField, x, y)
{
  var dt = getFieldDate(targetDateField.value);
  
  // the datepicker table will be drawn inside of a <div> with an ID defined by the
  // global datePickerDivID variable. If such a div doesn't yet exist on the HTML
  // document we're working with, add one.
  if (!document.getElementById(datePickerDivID)) {
    // don't use innerHTML to update the body, because it can cause global variables
    // that are currently pointing to objects on the page to have bad references
    //document.body.innerHTML += "<div id='" + datePickerDivID + "' class='dpDiv'></div>";
    var newNode = document.createElement("div");
    newNode.setAttribute("id", datePickerDivID);
    newNode.setAttribute("class", "dpDiv");
    newNode.setAttribute("style", "visibility: hidden;");
    document.body.appendChild(newNode);
  }
  
  // move the datepicker div to the proper x,y coordinate and toggle the visiblity
  var pickerDiv = document.getElementById(datePickerDivID);
  pickerDiv.style.position = "absolute";
  pickerDiv.style.left = x + "px";
  pickerDiv.style.top = y + "px";
  pickerDiv.style.visibility = (pickerDiv.style.visibility == "visible" ? "hidden" : "visible");
  pickerDiv.style.zIndex = 10000;
  
  // draw the datepicker table
  refreshDatePicker(targetDateField.name, dt.getFullYear(), dt.getMonth(), dt.getDate());
}


/**
This is the function that actually draws the datepicker calendar.
*/
function refreshDatePicker(dateFieldName, year, month, day)
{
  // if no arguments are passed, use today's date; otherwise, month and year
  // are required (if a day is passed, it will be highlighted later)
  var thisDay = new Date();
  
  if ((month >= 0) && (year > 0)) {
    thisDay = new Date(year, month, 1);
  } else {
    day = thisDay.getDate();
    thisDay.setDate(1);
  }
  
  // the calendar will be drawn as a table
  // you can customize the table elements with a global CSS style sheet,
  // or by hardcoding style and formatting elements below
  var crlf = "\r\n";
  var TABLE = "<table cols=7 class='dpTable'>" + crlf;
  var xTABLE = "</table>" + crlf;
  var TR = "<tr class='dpTR'>";
  var TR_title = "<tr class='dpTitleTR'>";
  var TR_days = "<tr class='dpDayTR'>";
  var TR_todaybutton = "<tr class='dpTodayButtonTR'>";
  var xTR = "</tr>" + crlf;
  var TD = "<td class='dpTD'";	// leave this tag open, because we'll be adding an onClick event
  var TD_title = "<td colspan=5 class='dpTitleTD'>";
  var TD_buttons = "<td class='dpButtonTD'>";
  var TD_todaybutton = "<td colspan=7 class='dpTodayButtonTD'>";
  var TD_days = "<td class='dpDayTD'>";
  var TD_selected = "<td class='dpDayHighlightTD'";	// leave this tag open, because we'll be adding an onClick event
  var xTD = "</td>" + crlf;
  var DIV_title = "<div class='dpTitleText'>";
  var DIV_selected = "<div class='dpDayHighlight'>";
  var xDIV = "</div>";
  
  // start generating the code for the calendar table
  var html = TABLE;
  
  // this is the title bar, which displays the month and the buttons to
  // go back to a previous month or forward to the next month
  html += TR_title;
  html += TD_buttons + getButtonCode(dateFieldName, thisDay, -1, "&lt;") + xTD;
  html += TD_title + DIV_title + monthArrayLong[thisDay.getMonth()] + " " + thisDay.getFullYear() + xDIV + xTD;
  html += TD_buttons + getButtonCode(dateFieldName, thisDay, 1, "&gt;") + xTD;
  html += xTR;
  
  // this is the row that indicates which day of the week we're on
  html += TR_days;
  for(i = 0; i < dayArrayShort.length; i++)
    html += TD_days + dayArrayShort[i] + xTD;
  html += xTR;
  
  // now we'll start populating the table with days of the month
  html += TR;
  
  // first, the leading blanks
  for (i = 0; i < thisDay.getDay(); i++)
    html += TD + "&nbsp;" + xTD;
  
  // now, the days of the month
  do {
    dayNum = thisDay.getDate();
    TD_onclick = " onclick=\"updateDateField('" + dateFieldName + "', '" + getDateString(thisDay) + "');\">";
    
    if (dayNum == day)
      html += TD_selected + TD_onclick + DIV_selected + dayNum + xDIV + xTD;
    else
      html += TD + TD_onclick + dayNum + xTD;
    
    // if this is a Saturday, start a new row
    if (thisDay.getDay() == 6)
      html += xTR + TR;
    
    // increment the day
    thisDay.setDate(thisDay.getDate() + 1);
  } while (thisDay.getDate() > 1)
  
  // fill in any trailing blanks
  if (thisDay.getDay() > 0) {
    for (i = 6; i > thisDay.getDay(); i--)
      html += TD + "&nbsp;" + xTD;
  }
  html += xTR;
  
  // add a button to allow the user to easily return to today, or close the calendar
  var today = new Date();
  var todayString = "Today is " + dayArrayMed[today.getDay()] + ", " + monthArrayMed[today.getMonth()] + " " + today.getDate();
  html += TR_todaybutton + TD_todaybutton;
  html += "<button class='dpTodayButton' onClick='refreshDatePicker(\"" + dateFieldName + "\");'>"+thisDayStr+"</button> ";
  html += "<button class='dpTodayButton' onClick='updateDateField(\"" + dateFieldName + "\");'>"+closeStr+"</button>";
  html += xTD + xTR;
  
  // and finally, close the table
  html += xTABLE;
  
  document.getElementById(datePickerDivID).innerHTML = html;
  // add an "iFrame shim" to allow the datepicker to display above selection lists
  adjustiFrame();
}


/**
Convenience function for writing the code for the buttons that bring us back or forward
a month.
*/
function getButtonCode(dateFieldName, dateVal, adjust, label)
{
  var newMonth = (dateVal.getMonth() + adjust) % 12;
  var newYear = dateVal.getFullYear() + parseInt((dateVal.getMonth() + adjust) / 12);
  if (newMonth < 0) {
    newMonth += 12;
    newYear += -1;
  }
  
  return "<button class='dpButton' onClick='refreshDatePicker(\"" + dateFieldName + "\", " + newYear + ", " + newMonth + ");'>" + label + "</button>";
}


/**
Convert a JavaScript Date object to a string, based on the dateFormat and dateSeparator
variables at the beginning of this script library.
*/
function getDateString(dateVal)
{
  var dayString = "00" + dateVal.getDate();
  var monthString = "00" + (dateVal.getMonth()+1);
  dayString = dayString.substring(dayString.length - 2);
  monthString = monthString.substring(monthString.length - 2);
  
  switch (dateFormat) {
	case "dd/MM/yyyy" :
      return dayString + dateSeparator + monthString + dateSeparator + dateVal.getFullYear();
    case "yyyy/MM/dd" :
      return dateVal.getFullYear() + dateSeparator + monthString + dateSeparator + dayString;
    case "MM/dd/yyyy" :
    default :
      return monthString + dateSeparator + dayString + dateSeparator + dateVal.getFullYear();
      
  }
}


/**
Convert a string to a JavaScript Date object.
*/
function getFieldDate(dateString)
{
  var dateVal;
  var dArray;
  var d, m, y;

  try {
    dArray = splitDateString(dateString);
    if (dArray) {
      switch (dateFormat) {
        case "dd/MM/yyyy" :
          d = parseInt(dArray[0], 10);
          m = parseInt(dArray[1], 10) - 1;
          y = parseInt(dArray[2], 10);
          break;
        case "yyyy/MM/dd" :
          d = parseInt(dArray[2], 10);
          m = parseInt(dArray[1], 10) - 1;
          y = parseInt(dArray[0], 10);
          break;
        case "MM/dd/yyyy" :
        default :
          d = parseInt(dArray[1], 10);
          m = parseInt(dArray[0], 10) - 1;
          y = parseInt(dArray[2], 10);
          break;
      }
      dateVal = new Date(y, m, d);
    } else {
      dateVal = new Date(dateString);
    }
  } catch(e) {
    dateVal = new Date();
  }
  
  return dateVal;
}


/**
Try to split a date string into an array of elements, using common date separators.
If the date is split, an array is returned; otherwise, we just return false.
*/
function splitDateString(dateString)
{
  var dArray;
  if (dateString.indexOf("/") >= 0)
    dArray = dateString.split("/");
  else if (dateString.indexOf(".") >= 0)
    dArray = dateString.split(".");
  else if (dateString.indexOf("-") >= 0)
    dArray = dateString.split("-");
  else if (dateString.indexOf("\\") >= 0)
    dArray = dateString.split("\\");
  else
    dArray = false;
  
  return dArray;
}

/**
Update the field with the given dateFieldName with the dateString that has been passed,
and hide the datepicker. If no dateString is passed, just close the datepicker without
changing the field value.

Also, if the page developer has defined a function called datePickerClosed anywhere on
the page or in an imported library, we will attempt to run that function with the updated
field as a parameter. This can be used for such things as date validation, setting default
values for related fields, etc. For example, you might have a function like this to validate
a start date field:

function datePickerClosed(dateField)
{
  var dateObj = getFieldDate(dateField.value);
  var today = new Date();
  today = new Date(today.getFullYear(), today.getMonth(), today.getDate());
  
  if (dateField.name == "StartDate") {
    if (dateObj < today) {
      // if the date is before today, alert the user and display the datepicker again
      alert("Please enter a date that is today or later");
      dateField.value = "";
      document.getElementById(datePickerDivID).style.visibility = "visible";
      adjustiFrame();
    } else {
      // if the date is okay, set the EndDate field to 7 days after the StartDate
      dateObj.setTime(dateObj.getTime() + (7 * 24 * 60 * 60 * 1000));
      var endDateField = document.getElementsByName("EndDate").item(0);
      endDateField.value = getDateString(dateObj);
    }
  }
}

*/
function updateDateField(dateFieldName, dateString)
{
  var targetDateField = document.getElementsByName(dateFieldName).item(0);
  if (dateString){
    targetDateField.value = dateString;
  }
  document.getElementById(datePickerDivID).style.visibility = "hidden";
  adjustiFrame();
  
  // after the datepicker has closed, optionally run a user-defined function called
  // datePickerClosed, passing the field that was just updated as a parameter
  // (note that this will only run if the user actually selected a date from the datepicker)
  if ((dateString) && (typeof(datePickerClosed) == "function"))
    datePickerClosed(targetDateField);
}


/**
Use an "iFrame shim" to deal with problems where the datepicker shows up behind
selection list elements, if they're below the datepicker. The problem and solution are
described at:

http://dotnetjunkies.com/WebLog/jking/archive/2003/07/21/488.aspx
http://dotnetjunkies.com/WebLog/jking/archive/2003/10/30/2975.aspx
*/
function adjustiFrame(pickerDiv, iFrameDiv)
{
  if (!document.getElementById(iFrameDivID)) {
    // don't use innerHTML to update the body, because it can cause global variables
    // that are currently pointing to objects on the page to have bad references
    //document.body.innerHTML += "<iframe id='" + iFrameDivID + "' src='javascript:false;' scrolling='no' frameborder='0'>";
    var newNode = document.createElement("iFrame");
    newNode.setAttribute("id", iFrameDivID);
    newNode.setAttribute("src", "javascript:false;");
    newNode.setAttribute("scrolling", "no");
    newNode.setAttribute("frameborder", "0");
    document.body.appendChild(newNode);
  }
  
  if (!pickerDiv)
    pickerDiv = document.getElementById(datePickerDivID);
  if (!iFrameDiv)
    iFrameDiv = document.getElementById(iFrameDivID);
  
  try {
    iFrameDiv.style.position = "absolute";
    iFrameDiv.style.width = pickerDiv.offsetWidth;
    iFrameDiv.style.height = pickerDiv.offsetHeight;
    iFrameDiv.style.top = pickerDiv.style.top;
    iFrameDiv.style.left = pickerDiv.style.left;
    iFrameDiv.style.zIndex = pickerDiv.style.zIndex - 1;
    iFrameDiv.style.visibility = pickerDiv.style.visibility;
  } catch(e) {
  }
}
