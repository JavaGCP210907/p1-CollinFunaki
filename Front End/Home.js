
//add functionality to our buttons using an eventListener
//so when these buttons get clicked, the appropriate function below gets called
//for home page
document.getElementById("eloginbutton").addEventListener("click", employeeLogin);
document.getElementById("mloginbutton").addEventListener("click", managerLogin);

function employeeLogin(){
    window.location.href = "Employee_Login.html"
}

function managerLogin(){
    window.location.href = "Manager_Login.html"
}

