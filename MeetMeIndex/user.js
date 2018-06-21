setTimeout("waiting()", 0);

function waiting() {
	if(localStorage.userAcronym == "M") {
		document.getElementById("picture").src = "Dennis_Profilbild.jpg";
	} else if (localStorage.userAcronym == "D") {
		document.getElementById("picture").src = "Dennis_Profilbild.jpg";
	} else if (localStorage.userAcronym == "C") {
		document.getElementById("picture").src = "Chris_Profilbild.jpg";
	} else if (localStorage.userAcronym == "P") {
		document.getElementById("picture").src = "Dennis_Profilbild.jpg";
} 

}

var theUrl = "http://localhost:8080/TeamDirectoryWeb/api/user";
var xmlHttp;

xmlHttp = new XMLHttpRequest();
xmlHttp.open("GET", (theUrl + "/name/" + localStorage.userAcronym));
xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
xmlHttp.send();
xmlHttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        var text = JSON.parse(this.responseText);
        document.getElementById("name").innerHTML = "Name: " + text;
    }
};

xmlHttp = new XMLHttpRequest();
xmlHttp.open("GET", (theUrl + "/age/" + localStorage.userAcronym));
xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
xmlHttp.send();
xmlHttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        var text = JSON.parse(this.responseText);
        document.getElementById("age").innerHTML = "Alter: " + text;
    }
};

xmlHttp = new XMLHttpRequest();
xmlHttp.open("GET", (theUrl + "/starsign/" + localStorage.userAcronym));
xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
xmlHttp.send();
xmlHttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        var text = JSON.parse(this.responseText);
        document.getElementById("sign").innerHTML = "Sternzeichen: " + text;
    }
};

xmlHttp = new XMLHttpRequest();
xmlHttp.open("GET", (theUrl + "/course/" + localStorage.userAcronym));
xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded; charset=UTF-8");
xmlHttp.send();
xmlHttp.onreadystatechange = function() {
    if (this.readyState === 4 && this.status === 200) {
        var text = JSON.parse(this.responseText);
        document.getElementById("studies").innerHTML = "Studiengang: " + text;
    }
};