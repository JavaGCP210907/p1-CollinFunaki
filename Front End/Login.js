const url = "http://localhost:3000/" //putting in our base URL in a variable for cleaner code below
//eventually we'll use this in our fetch request and make call to the server by appending endpoint

//add functionality to our bytton using an eventListener
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
    let response = await fetch(url + "login", {

        method: "POST", //send a POST request
        body: JSON.stringify(user), //turn our JS into JSON
        credentials: "include"
        //this last line will ensure that the cookie is captured
        //future fetches will also require this "include" value to send the cookie back

    });

    console.log(response.status); //useful for debug 

    //control flow based onsuccess or failed login
    if(response.status===200){
        //wipe out login row and welcome user
        window.location.href = "Finance_Manager.html"

    } else{
        document.getElementById("login").innerText="Login failed... try again!"
    }
}

//function to display the reimbursment table
// async function getReimbs() { //async returns a promise (which fetch returns)

//     //we will send a fetch request
//     //we need to include {credentials: "include"} in order to make use of the user's cookie
//     let response = await fetch(url + "reimbursements", {credentials: "include"}); 

//     console.log(response);

//         let data = await response.json(); //get the JSON data, turn it into a JS object

//         //for every avenger object we get back, put it in the table
//         for (let reimb of data){

//             let row = document.createElement("tr") //create a table row

//             let cell = document.createElement("td"); //create a cell for the field
//             cell.innerHTML = reimb.id; //fill the cell with the appropriate reimbursement data
//             row.appendChild(cell); //add the td element (cell) to the tr element (row)

//             //then we do this ^ for every field in the avenger model
//             let cell2 = document.createElement("td");
//             cell2.innerHTML = reimb.amount;
//             row.appendChild(cell2);

//             let cell3 = document.createElement("td");
//             cell3.innerHTML = reimb.submitted;
//             row.appendChild(cell3);

//             let cell4 = document.createElement("td");
//             cell4.innerHTML = reimb.resolved;
//             row.appendChild(cell4);

//             let cell5 = document.createElement("td");
//             cell5.innerHTML = avenger.description;
//             row.appendChild(cell5);

//             let cell6 = document.createElement("td");
//             cell6.innerHTML = reimb.receipt;
//             row.appendChild(cell6);

//             let cell7 = document.createElement("td");
//             cell7.innerHTML = reimb.author;
//             row.appendChild(cell7);

//             let cell8 = document.createElement("td");
//             cell8.innerHTML = reimb.author;
//             row.appendChild(cell8);

//             let cell9 = document.createElement("td");
//             cell9.innerHTML = reimb.resolver;
//             row.appendChild(cell9);

//             let cell10 = document.createElement("td");
//             cell10.innerHTML = reimb.status;
//             row.appendChild(cell10);

//             let cell11 = document.createElement("td");
//             cell11.innerHTML = reimb.type;
//             row.appendChild(cell11);


//             //the tr called row that we created in the for loop get appended in the table body
//             //a new row will be appended for every Avenegr objec that come in
//              document.getElementById("reimb_table").appendChild(row)
//         }
// }
