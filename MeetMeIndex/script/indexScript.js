var Module = (function(window, document, undefined) {

    function init() {

        var w = window,
            d = document,
            e = d.documentElement,
            g = d.getElementsByTagName('body')[0];

        var windowWidth = w.innerWidth || e.clientWidth || g.clientWidth;

        var friends = document.getElementsByClassName("friends")[0];
        var friendsButton = document.getElementsByClassName("show-friends")[0];
        var friendsClose = document.getElementsByClassName("close")[0];
        var friendsWrapper = document.getElementsByClassName("friends-wrapper")[0];
        var friendContainers = document.getElementsByClassName("friend-container");

        var friendContainersCoords = new Array();

        friendsButton.addEventListener("click", showFriends);
        friendsClose.addEventListener("click", showFriends);
        friendsWrapper.addEventListener("click", showUser);

        function getFriendContainersCoords() {
            for (i = 0; i < friendContainers.length; i++) {
                var friendRect = friendContainers[i].getBoundingClientRect();
                var yCoords = Math.round(friendRect.top + (friendContainers[i].offsetHeight / 2));
                var xCoords = Math.round(friendRect.left + (friendContainers[i].offsetWidth / 2));
                var coords = {
                    xCoords : xCoords,
                    yCoords : yCoords
                }
                friendContainersCoords[i] = coords;
                //console.log(coords);
            }
        }

        function showFriends() {
            friends.classList.toggle("showing-friends");
            windowWidth = w.innerWidth || e.clientWidth || g.clientWidth;
            if (windowWidth > 960) {
                if (friends.classList.contains("showing-friends")) {
                    getFriendContainersCoords();
                    document.addEventListener("mousemove", markFriend);
                } else {
                    document.removeEventListener("mousemove", markFriend, false);
                }
            }
        }

        function showUser(e) {
            if (sessionStorage.getItem("userId") != null || sessionStorage.getItem("userId") != "") {
                sessionStorage.removeItem("userId");
            }
            var e = e || window.event;
            var target = e.target || window.target;
            while (!target.classList.contains("friend-container") || target.classList.contains("friends-wrapper")) {
                target = target.parentNode;
            }
            if (target.classList.contains("friends-wrapper")) {
                return;
            }
            var userId = target.getElementsByClassName("user-id")[0].innerHTML;
            sessionStorage.setItem("userId", userId);
        }


        var xCoords, yCoords, distance = null;
        function markFriend(e) {
            var e = e || window.event;
            xCoords = e.clientX;
            yCoords = e.clientY;
            for (i = 0; i < friendContainers.length; i++) {
                distance = Math.floor(Math.sqrt((Math.pow((xCoords - friendContainersCoords[i].xCoords), 2) + Math.pow((yCoords - friendContainersCoords[i].yCoords), 2))));
                if (distance < 300 && distance > 50) {
                    distance = 10 / distance;
                    friendContainers[i].style.transform = "scale(" + (1 + distance) + ", " + (1 + distance) + ")";
                    //console.log(distance);
                }
            }
        }

    }

    if (document.readyState == "loading") {
        document.addEventListener("DOMContentLoaded", function() {
            init();
        });
    } else {
        init();
    }


})(window, document)