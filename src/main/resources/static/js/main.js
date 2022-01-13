$(document).ready(function () {

    setNickname();
    getWord();

    $("#answer-form").submit(function () {
        var answer = $("#answer").val();

        if (answer === localStorage['current.word']) {
            alert("correct!");
            getWord();
        } else {
            alert("wrong!");
        }

        document.getElementById("answer-form").reset();
    });

    function getWord() {
        let url = "http://localhost:8080"

        if (location.hostname !== "localhost" || location.hostname !== "127.0.0.1") {
            url = "https://scrumble-de.herokuapp.com";
        }

        $.get(url + "/word", function (data) {
            localStorage['current.word'] = data.word
            localStorage['current.shuffled'] = data.shuffled
            localStorage['current.meaning'] = data.meaning
            $("#word").text(data.shuffled);
        });
    }

    function setNickname() {
        if (localStorage['user.nickname'] !== undefined) {
            $("#nickname").text(localStorage['user.nickname']);
        } else {
            localStorage['user.nickname'] = prompt("Please enter your name");
            $("#nickname").text(localStorage['user.nickname']);
        }
    }

});