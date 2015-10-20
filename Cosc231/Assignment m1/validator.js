var validator = 
{
	isJavaIdentifier: function(testString)
	//Accepts an identifier has groups that begin with a letter but after the first letter can contain letters or numbers
	//that can be seperated by periods and ends with a group
	{
		var re = /([a-zA-Z_$][a-zA-Z\d_$]*\.)*[a-zA-Z_$][a-zA-Z\d_$]*/;
		return re.test(testString);
	},
	isPhone: function(testString) 
	//Accepts 3 digits and 4 digits and perhaps 3 digits at the beginning seperated by . or - or spaces
	{
		var re = /^\d{3}?[\s.-]\d{3}[\s.-]\d{4}$/;
		return re.test(testString);
	},
	isEmail: function(testString) 
	//Accpets letters/digits/underscore and periods followed by @ then letters and digits
	//proceeded by a period and then letter, digits and periods
	{
		var re = /^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]+$/;
		return re.test(testString);
	},
	isDate: function(testString)
	//Accepts 1-9 or 10 11 12 for the month, accepts valid days for the day, and any 4 numbers for the year
	{
		var re = /^(0?[1-9]|1[012])[\/\-](0?[1-9]|[12][0-9]|3[01])[\/\-]\d{4}$/;
		return re.test(testString);
	},
	isEID: function(testString)
	//Accepts 8 digits with an E or e at the beginning
	{
		var re = /^(E{1}|e{1})?\d{8}$/;
		return re.test(testString);
	},
	isA: function(someSortOfRegex,testString) 
	{
		console.log(someSortOfRegex);
		var re = new RegExp(someSortOfRegex);
		return re.test(testString);
	}
};