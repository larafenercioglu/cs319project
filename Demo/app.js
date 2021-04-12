localStorage.setItem("mail", "gokhan.tas@ug.bilkent.edu.tr");
localStorage.setItem("pw", "test123");

function getInputValue(){
    // Selecting the input element and get its value 
    var email = document.getElementById("input_email").value;
    var password = document.getElementById("input_password").value;

    if(email == localStorage.getItem("mail") && password == localStorage.getItem("pw")) {
        alert("İÇERDESİN");
    }
    else {
        alert("sie");
    }
}