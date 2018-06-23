var Module = (function(window, document, undefined) {

    function init() {

        var userUrl = "http://localhost:8080/TeamDirectoryWeb/api/user";
        var postUrl = "http://localhost:8080/TeamDirectoryWeb/api/user";
        var postingContainer = document.getElementById("posting-container");
        var formButton = document.getElementsByClassName("post-post")[0];

        formButton.addEventListener("click", postPosting);

        if (sessionStorage.getItem("userId") == null || sessionStorage.getItem("userId") == "") {
            alert("ERROR: Couldn't find user");
        } else {
            var userId = sessionStorage.getItem("userId");
        }

        var xhttp = new XMLHttpRequest();
        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
            	handleServerResponse(this.responseText);
            }
        }
        xhttp.open("GET", userUrl + "?userId=" + userId, true);
        xhttp.send();

        function handleServerResponse(response) {
            var nameEl = document.getElementById("name");
            var ageEl = document.getElementById("age");
            var starsignEl = document.getElementById("starsign");
            var courseEl = document.getElementById("course");
            var imgEl = document.getElementById("user-image");

            var jsonResponse = JSON.parse(response);

            nameEl.innerHTML = jsonResponse.name;
            ageEl.innerHTML = jsonResponse.age;
            starsign.innerHTML = jsonResponse.starsign;
            courseEl.innerHTML = jsonResponse.course;
            imgEl.src = jsonResponse.imagePath;

            var postings = jsonResponse.postings;
            
            if (typeof(postings) != "undefined") {
            	for (i = 0; i < postings.length; i++) {
                    createPosting(postings[i]);
                }
            }

        }

        function createPosting(posting) {
            var postingDiv = document.createElement("div");
            var contentP = document.createElement("p");
            var authorSpan = document.createElement("span");
            var dateSpan = document.createElement("span");
            authorSpan.classList.add("author");
            dateSpan.classList.add("date");
            var authorText = document.createTextNode(posting.author);
            var dateText = document.createTextNode(posting.date);
            var contentText = document.createTextNode(posting.content);
            postingDiv.appendChild(dateSpan).appendChild(dateText);
            postingDiv.appendChild(contentP).appendChild(contentText);
            postingDiv.appendChild(authorSpan).appendChild(authorText);
            postingContainer.appendChild(postingDiv);
        }

        function postPosting(e) {
            var e = e || window.event;
            e.preventDefault();
            var authorIn = document.getElementById("author");
            var contentIn = document.getElementById("content");
            var author = authorIn.value;
            var content = contentIn.value;
            authorIn.value = "";
            contentIn.value = "";
            var xhttp = new XMLHttpRequest();
            xhttp.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    var jsonResponse = JSON.parse(this.response);
                    var posting = {
                        "author": author,
                        "date": jsonResponse.date,
                        "content": content

                    }
                    createPosting(posting);
                }
            }
            xhttp.open("POST", postUrl, true);
            var params = "author=" + author + "&targetId=" + userId + "&content=" + content;
            xhttp.send(params);
            // ladeanimation?
        }

        //handleServerResponse('{"name":"Markus", "age":"19", "starsign":"Löwe", "course":"Wirtschaftsinformatik", "postings":[{"author":"Peddah", "date":"21.06.2018 14:39", "content":"Dies ist ein Kommentar"}, {"author":"Dennis", "date":"21.06.2018 14:44", "content":"Hurensohn"}, {"author":"Chris", "date":"21.06.2018 14:55", "content":"cool"}]}');

    }

    if (document.readyState == "loading") {
        document.addEventListener("DOMContentLoaded", function() {
            init();
        });
    } else {
        init();
    }

})(window, document)