"use strict";
window.addEventListener("load", function(){
    // Get the data from the url submitted by the user
    let data = getUserData();

    // If the data array is not empty
    if(data !== []){

        // Then get all the inputs from the form
        let inputs = this.document.querySelectorAll("input");

        /*Important Note: The state field is not an input element, 
        it is a select element. It will not be included
        in the HTMLCollection returned by the document.querySelector() method.
        */

        for(let i = 0; i < data.length; i++){
            // Account for the state field
            if(i === 3){
                this.document.getElementById("cust-state").value = data[i];
                inputs[i].value = data[i + 1];
                break;
            } else{
                inputs[i].value = data[i];
            }
        }

        console.log(inputs);

    }
}, false);

function parseURL(){
    // If the user actuall submitted the form
    if(location.search){
        // Then get the user data
        let urlData = decodeURIComponent(location.search);
        console.log("Parsing urlData " + urlData);

        // Take the '?' symbol out of the data string
        urlData = urlData.substring(1, urlData.length);
        // Replace all occurences of the + sybmol with a space
        urlData = urlData.replace(/\+/g, ' ');
        // console.log(urlData);

        return urlData;
    }
    return "";
}

function splitURLData(){
    let urlData = parseURL();
    if(urlData !== ""){
        urlData = urlData.split('&');

        // Creates an array of name-value pairs
        // console.log("Spliting urlData " + urlData);
        return urlData;
    }

    return [];    
}

function getUserData(){
    // Get the split user data array
    let userData = splitURLData();

    // If the data array is not empty
    if(userData !== []){

        // Then parse the data array into the specific values
        let dataArr = [];
        userData.forEach(element => {
            dataArr.push(element.substring(element.lastIndexOf('=')  + 1, element.length));
        });
        // console.log("Getting the values " + dataArr);

        return dataArr;
    }

    return [];
}