const url = "http://localhost:3000/" //putting in our base URL in a variable for cleaner code below
//eventually we'll use this in our fetch request and make call to the server by appending endpoint



//add functionality to our buttons using an eventListener
//so when these buttons get clicked, the appropriate function below gets called
document.getElementById("loginButton").addEventListener("click", loginFunc);


//login functionality below
//this function will send the user-ipnutted login credentials to our server
async function loginFunc(){

    //gather user input from the login inputs
    let usern = document.getElementById("username").value;
    let userp = document.getElementById("password").value;

    //we want to send the user/pass as JSON, so we need to make a JS object to send
    let user = {
        username:usern,
        password:userp
    }
    
    console.log(user)
    
    //now I'm going to set up my fetch request to the server
    //remember the second paramter fetch() can take?
    //its esentially a connfiguration object! the settings of our fetch request
    //if you dont include it, itll send a GET request by defualt
    let response = await fetch(url + "mlogin", {

        method: "POST", //send a POST request
        body: JSON.stringify(user), //turn our JS into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured
        //future fetches will also require this "include" value to send the cookie back

    });

    console.log(response.status); //useful for debug 

    //control flow based onsuccess or failed login
    if(response.status===200 ){
        //wipe out login row and welcome user
        window.location.href = "Manager.html"

    } else{
        document.getElementById("login").innerText="Login failed... try again!"
    }
}
