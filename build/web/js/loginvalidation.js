"use strict";
// Assume a username must be at least 4 
// characters and a password must be at least 4 characters long
// The username input field can not be empty
// The password input field can not be empty

// Global variables
const errorDiv = document.createElement("div");
errorDiv.id = "err-div";
const section = document.querySelector(".login-section");
const form = document.querySelector(".login-form");
console.log(section);

// Wait for the window to load the document
window.addEventListener("load", function(){
    // Wait for the user to submit the form
    form.addEventListener("submit", function(evt){
        // If the form is not valid
        if(!validateForm()){
            // Then prevent the form from submission
            evt.preventDefault();
        }// The form will automatically submit if it is valid
    }, false);
}, false);

function validateForm(){
    // Return the boolean value of all the validation methods
    return (validateUsername() && validatePassword());
}

function validateUsername(){
    // Get the username field
    let username = document.getElementById("username");
    console.log(username);
    
    // Test the length of the username field
    if(username.value !== ""){
        if(username.value.length >= 4){
            // If the user already tried to enter data into the form
            if(document.getElementById("err-div")){
                form.removeChild(errorDiv);
            }
            return true
        } else {
            // Display the error to the user
            errorDiv.innerHTML = "<p>The username must be at least 4 characters long.</p>";
            form.insertBefore(errorDiv, username.nextElementSibling.nextElementSibling);
        } 
    } else {
        // Display the error to the user
        errorDiv.innerHTML = "<p>The username cannot be left empty.</p>";
        form.insertBefore(errorDiv, username.nextSibling);
    }
    // If the method reaches this statement, then the user input an error
    return false;
}

function validatePassword(){
    // Get the password input element
    let password = document.getElementById("password");

    if(password.value !== ""){
        if(password.value.length >= 4){
            // If the user already tried to enter data into the form
            if(document.getElementById("err-div")){
                form.removeChild(document.getElementById("err-div"));
            }
            return true;
        } else{
            errorDiv.innerHTML = "<p>The password must be at least 4 characters long.</p>";
            form.insertBefore(errorDiv, password.nextElementSibling.nextElementSibling); 
        }
    } else {
        errorDiv.innerHTML = "<p>The password field cannot be left empty.</p>";
        form.insertBefore(errorDiv, password.nextElementSibling.nextElementSibling);
    }

    // If the method reaches this statement, then the user input an error
    return false;
}
