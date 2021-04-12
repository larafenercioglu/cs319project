localStorage.setItem("mail", "gokhan.tas@ug.bilkent.edu.tr");
localStorage.setItem("pw", "testing123");

function getInputValue() {
    // Selecting the input element and get its value 
    var email = document.getElementById("input_email").value;
    var password = document.getElementById("input_password").value;

    if (email == localStorage.getItem("mail") && password == localStorage.getItem("pw")) {
        alert("Redirecting...");
    }
    else {
        alert("Access Denied!!!");
    }
}
function sendMessage() {
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var msg = document.getElementById("subject").value;
    alert("Your message has been send");
}

function openSideNav(clicked_tag) {

    if( clicked_tag == "AboutUs" ) {
        document.getElementById("mySideAboutUs").style.width = "34%";
    }
    else {
        document.getElementById("mySideContact").style.width = "34%";
    }
}

function closeSideNav(clicked_tag) {

    if( clicked_tag.parentNode.id == "mySideAboutUs" ) {
        document.getElementById("mySideAboutUs").style.width = "0";
    }
    else {
        document.getElementById("mySideContact").style.width = "0";
    }
}
