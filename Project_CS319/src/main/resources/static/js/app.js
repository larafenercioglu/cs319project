function sendMessage() {
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var msg = document.getElementById("subject").value;
    alert("Your message has been send");
}

function sendRegInformation()  {

    //event.preventDefault();
    //alert("Your registration information has been send");
    document.getElementById("mySideRegister").style.width = "0";
}

function openSideNav(clicked_tag) {

    if( clicked_tag == "AboutUs" ) {
        document.getElementById("mySideAboutUs").style.width = "34%";
    }
    else if( clicked_tag == "Register") {
        document.getElementById("mySideRegister").style.width = "34%";
    }
    else {
        document.getElementById("mySideContact").style.width = "34%";
    }
}

function closeSideNav(clicked_tag) {

    if( clicked_tag.parentNode.id == "mySideAboutUs" ) {
        document.getElementById("mySideAboutUs").style.width = "0";
    }
    else if( clicked_tag.parentNode.id == "mySideRegister" ) {
        document.getElementById("mySideRegister").style.width = "0";
    }
    else {
        document.getElementById("mySideContact").style.width = "0";
    }
}