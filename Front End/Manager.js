const url = "http://localhost:3000/" //putting in our base URL

//when mangager clicks this button the reimbursements table will display
document.getElementById("displayAll").addEventListener("click", getReimbs)

//when manager changes dropdown menu it filter based on selection
document.getElementById("filter").addEventListener("change", filter) 

//when manager clicks update status, they can edit the status field of a table
document.getElementById("updateStatus").addEventListener("click", updateStatus)


//function to get all reimbursements
async function getReimbs() { //async returns a promise (which fetch returns)

    //we will send a fetch request
    //we need to include {credentials: "include"} in order to make use of the user's cookie
    let response = await fetch(url + "reimbursements", {credentials: "include"}); 

    console.log(response);

    let data = await response.json(); //get the JSON data, turn it into a JS object
    console.log(data);

    //clear whats in the table
    document.getElementById("reimbBody").innerHTML="";

    //for every reimbursement object we get back, put it in the table
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



//function to filter the table by status
async function filter(){

    document.getElementById("reimbBody").innerHTML="";

    let response = await fetch(url + "reimbursements", {credentials: "include"}); 

    console.log(response);

    let data = await response.json(); //get the JSON data, turn it into a JS object
    console.log(data);
    //for every reimbursement object we get back, put it in the table
    for (let reimb of data){

        let selectedStatus = document.getElementById("filter").value
        if(reimb.status.status == selectedStatus){

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
}

//function to update a status
async function updateStatus(){

    //clear body of the table
    document.getElementById("reimbBody").innerHTML="";
    //clear button div
    document.getElementById("submitUpdateDiv").innerHTML="";

    var input = window. prompt("Enter your id of the reimburement you would like to update: ");

    let response = await fetch(url + "reimbursements", {credentials: "include"}); 

    console.log(response);

    let data = await response.json(); //get the JSON data, turn it into a JS object
    console.log(data);

    //get the reimbursement with id equal to user input
    for (let reimb of data){
        
        if(reimb.id==input){

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

            //allow the manager to edit this cell
            let cell9 = document.createElement("td");
            cell9.innerHTML = "<select id='statusDropdown'>" +
                                "<option value=''>Select an Option</option>"+
                                "<option value='Pending'>Pending</option>"+
                                "<option value='Denied'>Denied</option>"+
                                "<option value='Approved'>Approved</option></select>";
            row.appendChild(cell9);

            let cell10 = document.createElement("td");
            cell10.innerHTML = reimb.type.type;
            row.appendChild(cell10);


            //the tr called row that we created in the for loop get appended in the table body
            //a new row will be appended for every Avenegr objec that come in
            document.getElementById("reimbBody").appendChild(row)


            //add a button to submit changes
            let submitUpdate = document.createElement("button")
            document.getElementById("submitUpdateDiv").appendChild(submitUpdate)
            submitUpdate.setAttribute("id", "submitUpdate")
            submitUpdate.innerHTML="Sumbit status update"

            //When the button is clicked, add the new reimbursemnt request to the database
            document.getElementById("submitUpdate").addEventListener("click", submit);
        
            //function to actually submit the changes and edit the reimbursement status in the database
            async function submit(){
        
                //gather user input from status dropdown
                let status = document.getElementById("statusDropdown").value;
                let reimbId = reimb.id;
        
                //we want to send the user/pass as JSON, so we need to make a JS object to send
                let statusUpdate = {
                    reimbId:reimb.id,
                    status:status
                }
                
                console.log(statusUpdate)
                
                // send a PATCH request to the url + Reimbursements
                let response = await fetch(url + "reimbursements", {
        
                    method: "PATCH", //send a Patch request
                    body: JSON.stringify(statusUpdate), //turn our JS into JSON
                    credentials: "include"
                    //this last line will ensure that the cookie is captured
                    //future fetches will also require this "include" value to send the cookie back
        
                });

                //send confirmation box to user
                if (confirm("Are you sure you want to update this status?") == true) {
                alert("Status updated!");
                //clear body of the table
                document.getElementById("reimbBody").innerHTML="";
                //clear button div
                document.getElementById("submitUpdateDiv").innerHTML="";
                } else {
                alert("Status update cancelled!");
                }
        
        
            }


        }
    }
}