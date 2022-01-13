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
        $.get("http://localhost:8080/word", function (data) {
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