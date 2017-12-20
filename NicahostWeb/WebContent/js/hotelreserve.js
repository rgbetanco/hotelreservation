// hotelreserve.js
/*
* Revisa el field1 contra el field2 con la funcion compareAmount definida
* en utils.js en caso de que field1 sea mayor a field2 muestra el label
* @param field1 objeto input inicial
* @param field2 objeto input final
* @param label etiqueta a mostrar
*/
function checkField(field1, field2,label) {
  var comparation = 0;
  var amount1 = field1.value;//campo desde
  var amount2 = field2.value;//campo hasta
  if (compareAmount(amount1,amount2) > 0){//Si el campo inicial es mayor que el campo final
  	alert(label);
  	field2.focus();
  	return false;
  }
  else{
  	return true;
  }
}

/* Revisa que field1 sea menor a field2
* en caso de que field1 sea mayor a field2 muestra el label de 
* comparación de referencias
* @param field1 objeto input inicial
* @param field2 objeto input final
*/
function checkAccountStateReference(field1, field2) {
  return checkField(field1,field2,compareReferencesAlert);
}
/* Revisa que field1 sea menor a field2
* en caso de que field1 sea mayor a field2 muestra el label de 
* comparación de montos
* @param field1 objeto input inicial
* @param field2 objeto input final
*/
function checkAccountStateAmount(field1,field2){
  return checkField(field1,field2,compareAmountsAlert);
}
/* Revisa que la fecha contenida en initField sea menor a endField 
* en caso de que initField sea mayor a endField muestra el label de comparación de fechas
* en caso de que la fecha inicial sea mayor que el dia actual muestra el label de comparación de fechas
* comparación de referencias
* @param initField objeto input inicial
* @param endField objeto input final
* @param todayField objeto con fecha del servidor
* @param datePattern patrón de fecha 
*/

function checkAccountStateDate(initField, endField, todayField, datePattern) {
  var comparation = 0;
  var initDate = initField.value;//campo desde
  var endDate = endField.value;//campo hasta
  var todayDate = todayField.value; //campo para validar

  if (isEmpty(initDate)) {
	alert(emptyInitialDateAlert);
	initField.focus();
	return false;
  }
  if (isEmpty(endDate)) {
	alert(emptyFinalDateAlert);
	endField.focus();
	return false;
  }

  if (compareDate(endDate, todayDate, datePattern) < 1){
    alert(invalidDateAlert) // fecha inicio mayor a fecha actual
   return false;
  }
  else if (compareDate(initDate, endDate, datePattern) < 1){
       
       checkTwoYear(initDate, todayDate, datePattern);//Revisa que la diferencia en años no exceda en 2 años con la fecha actual
       if (compareDate(initDate, todayDate, datePattern) < 1){//Si la fecha es mayor
         initField.value = todayDate;
       }
       return true;
  }
  else{
    alert(compareDateAlert);
    return false;
   }
}
/* Despliega un mensaje de información si la fecha contenida en initialDate es dos años
*  menor a serverDAte
* @param initialDate fecha inicial
* @param serverDate fecha del servidor
* @param datePattern patrón de fecha
*/

function checkTwoYear(initialDate, serverDate, datePattern){

    var initDate = parseDate(initialDate, datePattern);
	var today = parseDate(serverDate, datePattern);

	today.setMinutes(0);
	today.setHours(0);
	today.setSeconds(0);
	today.setMilliseconds(0);
	
	twoYearsAgo = new Date();
	twoYearsAgo.setMinutes(0);
	twoYearsAgo.setHours(0);
	twoYearsAgo.setSeconds(0);
	twoYearsAgo.setMilliseconds(0);		
	twoYearsAgo.setYear( today.getFullYear() - 2 );
	
	if (initDate.getFullYear() <= twoYearsAgo.getFullYear()) {
		alert(twoYearWarningStr);
	}
}

/*
* Limpia los campos del form de estado de cuenta de banco 
* Actualiza la fecha inicial poniendole la fecha del primer dia del mes actual
* Actualiza la fecha final poniendole la fecha del dia del mes actual
* @param form form que contiene los campos
* @param datePattern patrón de fecha
* @return false para no ejecutar la acción
*/

function cleanFields(form,datePattern){
  
  form.initAmount.value = "";
  form.limitAmount.value = "";
  
  form.initReference.value = "";
  form.endReference.value = "";
  
  setInitDate(form.initDate,form.serverDate,datePattern);
  setEndDate(form.endDate,form.serverDate,datePattern);
  
  return false; 
}

/*
* Funcion utilizada para sumar una unidad al mes pasado por parametro
* ademas rellena con un cero a la izquierda en caso de que sea menor a 10
* @param month mes a rellenar y/o modificar
* @return String con el mes modificado 
*/

function setAccountStateMonth(month){
  var result = new String(month+1);
  if (result.length < 2){
    result = "0"+result ;
  }
  return result;
}
/*
* Funcion utilizada para rellenar con un cero a la izquierda en caso de que el dia sea menor a 10
* @param day dia a rellenar y/o modificar
* @return String con el dia modificado 
*/
function setAccountStateDay(day){
  var result = new String(day);
  if (result.length < 2){
    result = "0"+result ;
  }
  return result;
}

/*
* Funcion utilizada para asignar el primer dia del mes actual
* @param field campo asignar la fecha
* @param todaDate fecha del dia actual
* @param datePattern patrón de fecha
*/

function setInitDate(field,todayDate,datePattern){

	var today = parseDate(todayDate.value,datePattern);
	var initDay = "01";
	var separator = "/";
	var initDate = initDay + separator + setAccountStateMonth(today.getMonth()) + separator + today.getFullYear();
	field.value = initDate;
}

/*
* Funcion utilizada para asignar el dia del mes actual
* @param field campo asignar la fecha
* @param todaDate fecha del dia actual
* @param datePattern patrón de fecha
*/
function setEndDate(field,todayDate,datePattern){

	var today = parseDate(todayDate.value,datePattern);
	var separator = "/";
	var initDate = setAccountStateDay(today.getDate()) + separator + setAccountStateMonth(today.getMonth()) + separator + today.getFullYear();
	field.value = initDate;
}
/*
* Funcion utilizada para asignar el ultimo dia del mes anterior
* @param form form con los campos a asignar 
* @param datePattern patrón de fecha
*/
function setLastMonth(form, datePattern){

  setInitDate(form.initDate,form.lastMonthDate,datePattern);
  form.endDate.value = form.lastMonthDate.value;
  return true;
}

