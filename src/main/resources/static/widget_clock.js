window.setInterval(function() {
    var clockSpan = document.getElementById("widget_lab_clock");
    clockSpan.innerHTML = (new Date()).toTimeString();
}, 1000);