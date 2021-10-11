const url = "http://localhost:3000/" //putting in our base URL

//show past tickets when user click past tickets button
document.getElementById("view").addEventListener("click", viewPast);
//show add reimbursement form when user click add reimbursement button
document.getElementById("add").addEventListener("click", addNew);

var username = sessionStorage.getItem("username");
console.log(username);

//function to view past an employees reimbursemnt request tickets
async function viewPast(){

    document.getElementById("employeeReimbBody").innerHTML="";
    document.getElementById("submitNew").innerHTML="";

    // create heading
    document.getElementById("thead").innerHTML="<tr>"+
                                                "<th>ID</th>"+
                                                "<th>Amount</th>"+
                                                "<th>Date Submitted</th>"+
                                                "<th>Date Resolved</th>"+
                                                "<th>Description</th>"+
                                                "<th>Receipt</th>"+
                                                "<th>Author</th>"+
                                                "<th>Resolver</th>"+
                                                "<th>Status</th>"+
                                                "<th>Type</th>"+
                                                "</tr>"

    let response = await fetch(url + "reimbursements", {credentials: "include"}); 


    let data = await response.json(); //get the JSON data, turn it into a JS object
    console.log(data);

    //for every reimbursement object we get back, put it in the table
    for (let reimb of data){

        if(reimb.author.username == username){

            //store auhtor id and author name in a session variable
            sessionStorage.setItem("authorid", reimb.author.id);
            sessionStorage.setItem("author", reimb.author.firstName+" "+reimb.author.lastName);
        
            let row = document.createElement("tr") //create a table row

            let cell = document.createElement("td"); //create a cell for the field
            cell.innerHTML = reimb.id; //fill the cell with the appropriate reimbursement data
            row.appendChild(cell); //add the td element (cell) to the tr element (row)

            //then we do this ^ for every field in the reimbursements table
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
            cell7.innerHTML = reimb.author.firstName + " " + reimb.author.lastName;
            row.appendChild(cell7);

            console.log(reimb.resolved)
            if(reimb.resolved == "unresolved"){
                let cell8 = document.createElement("td");
                cell8.innerHTML = "TBD";
                row.appendChild(cell8);
            } else{
                let cell8 = document.createElement("td");
                cell8.innerHTML = reimb.resolver.firstName + " " + reimb.resolver.lastName;
                row.appendChild(cell8);
            }

            let cell9 = document.createElement("td");
            cell9.innerHTML = reimb.status.status;
            row.appendChild(cell9);

            let cell10 = document.createElement("td");
            cell10.innerHTML = reimb.type.type;
            row.appendChild(cell10);


            //the tr called row that we created in the for loop get appended in the table body
            //a new row will be appended for every reimbursement objec that come in
            document.getElementById("employeeReimbBody").appendChild(row)
        }
    }

}


//function to add a new reimbursment request
async function addNew(){

    document.getElementById("employeeReimbBody").innerHTML="";
    document.getElementById("submitNew").innerHTML="";

    let response1 = await fetch(url + "reimbursements", {credentials: "include"}); 
    let data = await response1.json(); //get the JSON data, turn it into a JS object

    // create heading
    document.getElementById("thead").innerHTML="<tr>"+
                                                "<th>Author</th>"+
                                                "<th>Amount</th>"+
                                                "<th>Description</th>"+
                                                "<th>Type</th>"+
                                                "</tr>"

    let row = document.createElement("tr") //create a table row

    // //id cell
    // let cell = document.createElement("td"); //create a cell for the field
    // cell.innerHTML = ""; //fill the cell with the appropriate reimbursement data
    // row.appendChild(cell); //add the td element (cell) to the tr element (row)

    //authorid cell
    let cell = document.createElement("td");
    cell.innerHTML = sessionStorage.getItem("author");
    row.appendChild(cell);

    //amount cell
    let cell2 = document.createElement("td");
    cell2.innerHTML = "<input type = 'number' size=3 id=amount class='form-control'>";
    row.appendChild(cell2);

    //date submitted cell
    // let cell3 = document.createElement("td");
    // let resolved = reimb.resolved
    // cell3.innerHTML = new Date();
    // row.appendChild(cell3);

    //date resolved cell
    // let cell4 = document.createElement("td");
    // cell4.innerHTML = "";
    // row.appendChild(cell4);

    //description cell
    let cell5 = document.createElement("td");
    cell5.innerHTML = "<input type = 'text' size=3 id=description class='form-control'>";
    row.appendChild(cell5);

    //recipt cell
    // let cell6 = document.createElement("td");
    // let receipt = reimb.receipt
    // cell6.innerHTML = "<input type = 'text' size=3 id=receipt class='form-control'>";
    // row.appendChild(cell6);

    //resolver cell
    // let cell8 = document.createElement("td");
    // resolverid = reimb.resolver.id
    // cell8.innerHTML = "";
    // row.appendChild(cell8);

    //status cell
    // let cell9 = document.createElement("td");
    // let status = reimb.status.status
    // cell9.innerHTML = "";
    // row.appendChild(cell9);

    //type cell
    let cell10 = document.createElement("td");
    cell10.innerHTML = "<select name='filter' id='typeFilter' class='form-control'>" +
                            "<option value='Lodging'>Lodging</option>"+
                            "<option value='Food'>Food</option>"+
                            "<option value='Travel'>Travel</option>"+
                            "<option value='Other'>Other</option></select>";
    row.appendChild(cell10);

    //a new row will be appended for every Avenegr objec that come in
    document.getElementById("employeeReimbBody").appendChild(row)

    let submitNew = document.createElement("button")
    document.getElementById("submitNew").appendChild(submitNew)
    submitNew.innerHTML="Add request"
    submitNew.setAttribute("class", "btn btn-dark")
    //When the button is clicked, add the new reimbursemnt request to the database
    document.getElementById("submitNew").addEventListener("click", submit);



    //function to actually submit the changes and add a row to the database
    async function submit(){

        //gather user input from the login inputs
        let amount = document.getElementById("amount").value;
        let submitted = new Date();
        let resolved = "unresolved";
        let description = document.getElementById("description").value;
        let receipt = null;
        let authorid = sessionStorage.getItem("authorid");
        let resolverid = null;
        let status = "pending";
        let type = document.getElementById("typeFilter").value;

        //we want to send the user/pass as JSON, so we need to make a JS object to send
        let reimbRequest = {
            amount : amount,
            submitted : submitted,
            resolved : resolved,
            description : description,
            receipt : receipt,
            author : {id : authorid},
            resolver : {id : resolverid},
            status : {status: status},
            type : {type : type}
        }

        console.log(reimbRequest)
        
        // send a POST to the the url + newReimb
        let response2 = await fetch(url + "newReimb", {

            method: "POST", //send a POST request
            body: JSON.stringify(reimbRequest), //turn our JS into JSON
            credentials: "include"
            //this last line will ensure that the cookie is captured
            //future fetches will also require this "include" value to send the cookie back

        });

        // window.alert("Reimbursement request submitted!"); 
        document.getElementById("thead").innerHTML="";
        document.getElementById("employeeReimbBody").innerHTML="";
        document.getElementById("submitNew").innerHTML="Reimbursement request submitted!";
    }

}