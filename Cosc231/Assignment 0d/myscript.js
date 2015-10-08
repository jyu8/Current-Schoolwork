
	var style = document.createElement("STYLE");
	var node = document.createTextNode("th,td{border: 1px black solid;}");
	style.appendChild(node);
	document.head.appendChild(style);

	var title = document.createElement("TITLE");
	var node = document.createTextNode("Josh Yu's Site");
	title.appendChild(node);
	document.head.appendChild(title);


	var div = document.getElementById("container");
	

	var header = document.createElement("H3");
	var node = document.createTextNode("Welcome to the site of Josh Yu");
	header.appendChild(node);
	div.appendChild(header);

	var a = document.createElement("a");
	var linkText = document.createTextNode("My 231 Folder");
	a.appendChild(linkText);
	a.title = "My 231 Folder";
	a.href = "http://people.emich.edu/jyu8/231";

	linebreak = document.createElement("br");
	a.appendChild(linebreak);

	div.appendChild(a);



	var a2 = document.createElement("a");
	var linkText = document.createTextNode(" My Github");
	a2.appendChild(linkText);
	a2.title = " My Github";
	a2.href = "https://github.com/jyu8";

	div.appendChild(a2);

	//Paragraph was created in this way because the createTextNode was not accepting newline in its parameters
	var para = document.createElement("p");
	var paratext = document.createTextNode("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Aliquam ac leo dol");
	para.appendChild(paratext);
	linebreak = document.createElement("br");
	para.appendChild(linebreak); 

	var paratext = document.createTextNode("or. Sed vel laoreet neque, a semper mauris. Vivamus at maximus erat, ac fin");
	para.appendChild(paratext);
	linebreak = document.createElement("br");
	para.appendChild(linebreak);

	var paratext = document.createTextNode("ibus turpis. Vestibulum eros sem, volutpat a vehicula a, pulvinar sit amet ");
	para.appendChild(paratext);
	
	var strong = document.createElement("STRONG");
	var strongtext = document.createTextNode("ipsum");
	strong.appendChild(strongtext);
	para.appendChild(strong);

	linebreak = document.createElement("br");
	para.appendChild(linebreak); 

	var paratext = document.createTextNode("tempor dui pulvinar vel. Aliquam blandit sodales lobortis. Suspendisse ");
	para.appendChild(paratext);
	linebreak = document.createElement("br");
	para.appendChild(linebreak); 

	var paratext = document.createTextNode("blandit sodales pretium. Donec ut ipsum cursus, convallis metus eu, ");
	para.appendChild(paratext);
	linebreak = document.createElement("br");
	para.appendChild(linebreak);

	var paratext = document.createTextNode("Suspendisse in metus vel tortor dictum ultricies vitae in nisi.");
	para.appendChild(paratext);
	
	div.appendChild(para);

	var table = document.createElement("TABLE");
	var caption = document.createElement("CAPTION");
	var captiontext = document.createTextNode("Class Schedule");
	caption.appendChild(captiontext);
	table.appendChild(caption);
 	
	var row = document.createElement("TR");

	var th = document.createElement("TH");
	var thtext = document.createTextNode("Class Code/Link");
	th.appendChild(thtext);
	row.appendChild(th);

	var th = document.createElement("TH");
	var thtext = document.createTextNode("Class Title");
	th.appendChild(thtext);
	row.appendChild(th);

	var th = document.createElement("TH");
	var thtext = document.createTextNode("Meeting Days");
	th.appendChild(thtext);
	row.appendChild(th);

	var th = document.createElement("TH");
	var thtext = document.createTextNode("Begin Time");
	th.appendChild(thtext);
	row.appendChild(th);

	var th = document.createElement("TH");
	var thtext = document.createTextNode("End Time");
	th.appendChild(thtext);
	row.appendChild(th);

	var th = document.createElement("TH");
	var thtext = document.createTextNode("Teacher Name");
	th.appendChild(thtext);
	row.appendChild(th);

	var th = document.createElement("TH");
	var thtext = document.createTextNode("Room Number");
	th.appendChild(thtext);
	row.appendChild(th);

	table.appendChild(row); 

	var row = document.createElement("TR");

	var td = document.createElement("TD");
	var a = document.createElement("a");
	var linkText = document.createTextNode("Cosc 231");
	a.appendChild(linkText);
	a.title = "Cosc 231";
	a.href = "https://github.com/pegurnee-edu/cosc231-fa15";
	td.appendChild(a);
	row.appendChild(td);

	table.appendChild(row);





	div.appendChild(table);
