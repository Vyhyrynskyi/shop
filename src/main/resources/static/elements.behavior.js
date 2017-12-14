/**
 * 
 */
/*
 * Huston we have a problem: val() on keyup with non numeric values in <input
 * type="number"> returns an empty string - it's browser's issue.
 */
function checkAmount(element, event) {
	var value = element.val();// .replace(/[e\+\-]/i, ' ');
	value = value.replace(/[e\+\-]/gi, '');
	value.replace(/^[0+]/g, '');
	value = parseInt(value, 10);
	var theEvent = event || window.event;
	var max = parseInt(element.attr("max"), 10);
	var regex = /^[1-9][0-9]*$/;
	if (!regex.test(value)) {
		theEvent.returnValue = false;
		if (theEvent.preventDefault)
			theEvent.preventDefault();
	}
	if (value < 1) {
		value = 1;
	}
	if (value > max) {
		value = max;
	}
	element.val(value);
};
function amountToURL(element){
	var parent = element.parent();
	var amountField = parent.children("input[type=number]");
	var amount = amountField.val();
	var oldURL = element.attr("href");
	var newURL = oldURL + "&amount=" +amount;
	element.attr("href", newURL);
	
}

function validateNumber(evt) {
	var theEvent = evt || window.event;
	var regex = /^[1-9][0-9]*$/;
	if (!regex.test(key)) {
		theEvent.returnValue = false;
		if (theEvent.preventDefault)
			theEvent.preventDefault();
	}
}