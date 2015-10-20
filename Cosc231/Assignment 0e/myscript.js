var style = document.createElement("STYLE");
var node = document.createTextNode("table,th,td{border: 1px black solid;}");
style.appendChild(node);
var node = document.createTextNode("body{background-color:#4FB363;}");
style.appendChild(node);
var node = document.createTextNode("h3{color:#B34F9F;");
style.appendChild(node);
document.head.appendChild(style);
	
var title = document.createElement("TITLE");
var node = document.createTextNode("Josh Yu's Site");
title.appendChild(node);
document.head.appendChild(title);

var div = document.getElementById("container");
	
var header = document.createElement("H3");
var node = document.createTextNode("Welcome to the site of Josh Yu")
header.appendChild(node);
div.appendChild(header);

var a = document.createElement("a");
var linkText = document.createTextNode("My 231 Folder");
a.appendChild(linkText);
a.href = "http://people.emich.edu/jyu8/231";

linebreak = document.createElement("br");
a.appendChild(linebreak);

div.appendChild(a);

var a2 = document.createElement("a");
var linkText = document.createTextNode(" My Github");
a2.appendChild(linkText);
a2.href = "https://github.com/jyu8";
div.appendChild(a2);

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
var thtext = document.createTextNode("Begin/End Time");
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


var row1 = document.createElement("TR");

var td = document.createElement("TD");
var a = document.createElement("a");
var linkText = document.createTextNode("Cosc 231");
a.appendChild(linkText);
a.href = "https://github.com/pegurnee-edu/cosc231-fa15";
td.appendChild(a);
row1.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("Internet-Based-Computing");
td.appendChild(tdtext);
row1.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("T,Th");
td.appendChild(tdtext);
row1.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("2:00 / 3:50");
td.appendChild(tdtext);
row1.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("Eddie Gurnee");
td.appendChild(tdtext);
row1.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("PH 514");
td.appendChild(tdtext);
row1.appendChild(td);

row1.style.color = "#7A5E1C";
table.appendChild(row1);


var row2 = document.createElement("TR");

var td = document.createElement("TD");
var a = document.createElement("a");
var linkText = document.createTextNode("Cosc 311");
a.appendChild(linkText);
a.href = "http://emunix.emich.edu/~haynes/311/wi10/index.html";
td.appendChild(a);
row2.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("Algorithms & Data Structures");
td.appendChild(tdtext);
row2.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("T,Th");
td.appendChild(tdtext);
row2.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("7:20 / 8:35");
td.appendChild(tdtext);
row2.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("Suchindran Maniccam");
td.appendChild(tdtext);
row2.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("PH 202");
td.appendChild(tdtext);
row2.appendChild(td);

row2.style.color = "#4F6DB3";
table.appendChild(row2);


var row1 = document.createElement("TR");

var td = document.createElement("TD");
var a = document.createElement("a");
var linkText = document.createTextNode("Cosc 341");
a.appendChild(linkText);
a.href = "http://emunix.emich.edu/~haynes/";
td.appendChild(a);
row1.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("Programming Languages");
td.appendChild(tdtext);
row1.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("M,W");
td.appendChild(tdtext);
row1.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("10:00 / 11:15");
td.appendChild(tdtext);
row1.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("Susan Haynes");
td.appendChild(tdtext);
row1.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("PH 203");
td.appendChild(tdtext);
row1.appendChild(td);

row1.style.color = "#7A5E1C";
table.appendChild(row1);


var row2 = document.createElement("TR");

var td = document.createElement("TD");
var a = document.createElement("a");
var linkText = document.createTextNode("Math 360");
a.appendChild(linkText);
a.href = "https://canvas.emich.edu/courses/16001";
td.appendChild(a);
row2.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("Statistical Methods");
td.appendChild(tdtext);
row2.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("M,W");
td.appendChild(tdtext);
row2.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("5:30 / 6:45");
td.appendChild(tdtext);
row2.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("Rita Chattopadhyay");
td.appendChild(tdtext);
row2.appendChild(td);

var td = document.createElement("TD");
var tdtext = document.createTextNode("PH 321");
td.appendChild(tdtext);
row2.appendChild(td);

row2.style.color = "#4F6DB3";
table.appendChild(row2);

div.appendChild(table);

linebreak = document.createElement("br");
div.appendChild(linebreak);

var listtext = document.createTextNode("My favorite Pokemon");
div.appendChild(listtext);
var list = document.createElement("UL");

var listnode = document.createElement("LI");
var listnodetext = document.createTextNode("Magnemite");
listnode.appendChild(listnodetext);
list.appendChild(listnode);

var listnode = document.createElement("LI");
var listnodetext = document.createTextNode("Magnemite");
listnode.appendChild(listnodetext);
list.appendChild(listnode);

var listnode = document.createElement("LI");
var listnodetext = document.createTextNode("Magnemite");
listnode.appendChild(listnodetext);
list.appendChild(listnode);

var listnode = document.createElement("LI");
var listnodetext = document.createTextNode("Magneton");
listnode.appendChild(listnodetext);
list.appendChild(listnode);

div.appendChild(list); 


var para = document.createElement("P");
var img = document.createElement("IMG");
img.setAttribute("src", "images/pic.jpg");
img.setAttribute("alt", "My Row");
img.setAttribute("height", "300");
img.setAttribute("width", "400");
img.style.cssFloat = "left";
para.appendChild(img);

var paratext = document.createTextNode("Lorem ipsum dolor sit amet, consectetur \
adipiscing elit. Aliquam ac leo dol or. Sed vel laoreet neque, a semper mauris. \
 Vivamus at maximus erat, ac fin ibus turpis. Vestibulum eros sem, volutpat a \
 vehicula a, pulvinar sit amet ");
para.appendChild(paratext);
var strong = document.createElement("STRONG");
var strongtext = document.createTextNode(" ipsum ");
strong.appendChild(strongtext);
para.appendChild(strong);

var paratext = document.createTextNode("tempor dui pulvinar vel. Aliquam blandit \
sodales lobortis. Suspendisse blandit sodales pretium. Donec ut ipsum cursus, \
 convallis metus eu, Suspendisse in metus vel tortor dictum ultricies vitae in nisi. \
 Mauris ut mattis diam, quis rutrum felis. Donec luctus vestibulum justo, ac auctor \
 neque tempor eget. Morbi velit mauris, euismod non blandit at, vehicula vulputate \
eros. Integer tempus, augue vel rhoncus convallis,\
 felis ante varius tellus, et ullamcorper sem libero ac urna. Sed ornare purus quis nisl \
 amet vehicula purus tincidunt. Vivamus eget erat aliquet, consectetur dui ac,\
porttitor massa. Mauris ac mollis eros. Maecenas fermentum aliquet metus eget \
convallis. Sed nec tempor arcu.");
	 
para.appendChild(paratext);
para.style.fontFamily = "Courier New";	
para.style.textIndent = "50px";
para.style.border = "double";

div.appendChild(para);

function Grayscale()
{
	document.body.style.backgroundColor = "gray";
	document.getElementById("container").style.filter = 'grayscale(100%)';
}
function IncreaseFont()
{
if (document.body.style.fontSize == "") 
	document.body.style.fontSize = "1.4em";
document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (.1) + "em";
}

function DecreaseFont()
{
if (document.body.style.fontSize == "") 
	document.body.style.fontSize = "1.4em";
document.body.style.fontSize = parseFloat(document.body.style.fontSize) + (-.1) + "em";
}

function MenuVisibility()
{
	document.getElementById("AssistOptions").style.visibility = 'visible';
	document.getElementById("AssistMenu").style.visibility = 'hidden';
}
