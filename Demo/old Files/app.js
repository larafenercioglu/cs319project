let users = [];
let initalUser = {
    mail: "gokhan.tas@ug.bilkent.edu.tr",
    pw: "testing123"
}

users.push(initalUser);
localStorage.setItem("allUsers",JSON.stringify(users));

/*
localStorage.setItem("mail", "gokhan.tas@ug.bilkent.edu.tr");
localStorage.setItem("pw", "testing123");
*/

function getInputValue() {

    var flag = true;

    // Selecting the input element and get its value 
    var email = document.getElementById("input_email").value;
    var password = document.getElementById("input_password").value;

    let usersInSystem = JSON.parse(localStorage.getItem('allUsers'));

    for( var i = 0; i < usersInSystem.length; i++) {
        if(usersInSystem[i].mail == email && usersInSystem[i].pw == password) {
            alert("Redirecting...");
            flag = false;
            break;
        }
    }
    if( flag ) {
        alert("Access Denied!!!");
    }

}
function sendMessage() {
    var fname = document.getElementById("fname").value;
    var lname = document.getElementById("lname").value;
    var msg = document.getElementById("subject").value;
    alert("Your message has been send");
}

function sendRegInformation()  {
    var name = document.getElementById("register_name").value;
    var surname = document.getElementById("register_surname").value;
    var id = document.getElementById("register_id").value;
    var email = document.getElementById("register_email").value;
    var password = document.getElementById("register_password").value;

    let newUser = {
        mail: email,
        pw: password
    }

    let usersInSystem = JSON.parse(localStorage.getItem('allUsers'));
    usersInSystem.push(newUser);
    console.log(usersInSystem);
    localStorage.setItem("allUsers",JSON.stringify(usersInSystem));
    alert("Your registration information has been send");
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
