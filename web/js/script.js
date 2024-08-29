/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function userRegistration() {


    var user = {
        mobile: document.getElementById("mobile").value,
        name: document.getElementById("name").value,
        gender: document.getElementById("male").checked?"Male":"Female",
        country: document.getElementById("country").value,
        password: document.getElementById("password").value
      

    };

    var ajax = new XMLHttpRequest();
    ajax.open("POST", "User_Registration", true);
    ajax.setRequestHeader("Content-Type", "application/jason");
    
    ajax.onreadystatechange = function (){
        if(ajax.readyState ===4 && ajax.status === 200){
            var jsObject = JSON.parse(ajax.responseText);
            if(jsObject.msg=="success"){
                window.local = "user_login.html";
            }else{
                document.getElementById("error").innerHTML="Mobile number is already used";
            }
        }
    };
    ajax.send(JSON.stringify(user));
}

function  userLogin(){
    
    var user = {
        mobile:document.getElementById("mobile").value,
        password:document.getElementById("password").value,
    };
    
    var ajax = new XMLHttpRequest();
    ajax.open("POST","User_Login",true);
    ajax.setRequestHeader("Content-Type","application/json");
    
    ajax.onreadystatechange = function (){
        if(ajax.readyState ===4 && ajax.status === 200){
            var jsObject = JSON.parse(ajax.responseText);
            if(jsObject.msg=="success"){
                window.local = "user_login.html";
            }else{
                document.getElementById("error").innerHTML="Invalid login details";
            }
        }
    };
}

function goToRegistration(){
    
    window.location = "user_registration.html";
}

function  logout(){
    window.location="User_Logout";
}