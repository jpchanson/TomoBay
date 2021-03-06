/////////////////////////////////STARTOF AJAX BUTTON///////////////////////////////////////////
/*********************************************************************************************
 * This function performs an AJAX get request using the queryString provided, it uses the data
 * found at inputSelector to perform this query. Once results have been found it places them in
 * the element found at resultSelector. while waiting for the results a spinner is shown, the 
 * path for which is images/ajax-loader-small-grey.gif relative to the root directory.
 * @param inputSelector the css selector for the input element used to hold the data for the
 * GET request.
 * @param queryString the query string that performs the get request
 * @param resultSelector the CSS selector for the element to dump the results in.
 *********************************************************************************************/
function ajaxButton(inputSelector, queryString, resultSelector)
{
	var input = $(inputSelector).val();
	$(resultSelector).html("<img src='images/ajax-loader-small-grey.gif' alt='Wait' />");
	$.get(queryString+input, function(data, textStatus)
	{display(data, resultSelector);});
}

/*********************************************************************************************
 * This function performs an AJAX get request using the queryString provided, it uses the data
 * found at inputSelector to perform this query. Once results have been found it places them in
 * the element found at resultSelector. while waiting for the results a spinner is shown, the 
 * path for which is images/ajax-loader-small-grey.gif relative to the root directory.
 * @param directInput the raw input value for the GET request
 * @param queryString the query string that performs the get request
 * @param resultSelector the CSS selector for the element to dump the results in.
 *********************************************************************************************/
function ajaxButtonDI(directInput, queryString, resultSelector)
{
	$(resultSelector).html("<img src='images/ajax-loader-small-grey.gif' alt='Wait' />");
	$.get(queryString+directInput, function(data, textStatus)
	{display(data, resultSelector);});
}

/*********************************************************************************************
 * This function performs an AJAX get request using the queryString provided, it uses the data
 * found at inputSelector to perform this query. Once results have been found it places them in
 * the element found at resultSelector. while waiting for the results a spinner is shown, the 
 * path for which is images/ajax-loader-small-grey.gif relative to the root directory.
 * @param inputArray the array of CSS input selectors to pass to the GET request. The first element
 * in the array is will be passed to the GET request first and so on.
 * @param queryString the query string that performs the get request
 * @param resultSelector the CSS selector for the element to dump the results in.
 *********************************************************************************************/
function ajaxButtonMultiInput(inputArray, queryString, resultSelector)
{
	var input = "";
	for(var i = 0 ; i < inputArray.length ; ++i)
	{
		if(i == inputArray.length-1){input+=$(inputArray[i]).val();}
		else{input+=$(inputArray[i]).val()+"|";}
	}
	$(resultSelector).html("<img src='images/ajax-loader-small-grey.gif' alt='Wait' />");
	$.get(queryString+input, function(data, textStatus)
	{display(data, resultSelector);});
}
/**********************************************************************************************
 * This function is a helper function for ajaxButton, it is responsible for fading the old
 * result out and fading the new result in, as well as removing the spinner.
 * @param data
 * @param resultSelector
 **********************************************************************************************/
function display(data, resultSelector)
	{
		$(resultSelector).fadeOut("5000", function()
				{
					$(resultSelector).hide();
					$(resultSelector).text(data);
					$(resultSelector).fadeIn("10000");
				});
	}
//////////////////////////////////////ENDOF AJAX BUTTON////////////////////////////////////////