const url = "http://localhost:3000/" //putting in our base URL

document.getElementById("displayAll").addEventListener("click", getReimbs) //when user clicks this button the reimbursements table will display

async function getReimbs() { //async returns a promise (which fetch returns)

//we will send a fetch request
//we need to include {credentials: "include"} in order to make use of the user's cookie
let response = await fetch(url + "reimbursements", {credentials: "include"}); 

console.log(response);

let data = await response.json(); //get the JSON data, turn it into a JS object
console.log(data);
//for every avenger object we get back, put it in the table
for (let reimb of data){

    let row = document.createElement("tr") //create a table row

    let cell = document.createElement("td"); //create a cell for the field
    cell.innerHTML = reimb.id; //fill the cell with the appropriate reimbursement data
    row.appendChild(cell); //add the td element (cell) to the tr element (row)

    //then we do this ^ for every field in the avenger model
    let cell2 = document.createElement("td");
    cell2.innerHTML = reimb.amount;
    row.appendChild(cell2);

    let cell3 = document.createElement("td");
    cell3.innerHTML = reimb.submitted;
    row.appendChild(cell3);

    let cell4 = document.createElement("td");
    cell4.innerHTML = reimb.resolved;
    row.appendChild(cell4);

    let cell5 = document.createElement("td");
    cell5.innerHTML = reimb.description;
    row.appendChild(cell5);

    let cell6 = document.createElement("td");
    cell6.innerHTML = reimb.receipt;
    row.appendChild(cell6);

    let cell7 = document.createElement("td");
    cell7.innerHTML = reimb.author.id;
    row.appendChild(cell7);

    let cell8 = document.createElement("td");
    cell8.innerHTML = reimb.resolver.id;
    row.appendChild(cell8);

    let cell9 = document.createElement("td");
    cell9.innerHTML = reimb.status.status;
    row.appendChild(cell9);

    let cell10 = document.createElement("td");
    cell10.innerHTML = reimb.type.type;
    row.appendChild(cell10);


    //the tr called row that we created in the for loop get appended in the table body
    //a new row will be appended for every Avenegr objec that come in
    document.getElementById("reimbBody").appendChild(row)
    }
}