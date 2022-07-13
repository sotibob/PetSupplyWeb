"use strict";
// Assume a username must be at least 4 
// characters and a password must be at least 4 characters long
// The first name and last name field can not be empty and be at least 3 characters long
// The email field must match a regular email format and cannot be empty
// The re-type password field must match the first password field

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
    return (validateFirstName() && validateLastName() && validateUsername() && validateEmail() && validatePassword() && validateConfirmPassword() && validatePhone());
}

function validateFirstName(){
    // Assume first-name cannot be less than 3 characters long
    // First, get the first name input element
    let fName = document.getElementById("first-name");
    if(fName.value !== ""){
        if(fName.value.length >= 3){
            if(document.getElementById("err-div")){
                form.removeChild(document.getElementById("err-div"));
            }
            return true;
        } else {
            errorDiv.innerHTML = "<p>The first name field must be at least 3 characters in length"
            form.insertBefore(errorDiv, fName.nextElementSibling);
        }
    } else {
        errorDiv.innerHTML = "<p>The first name field must contain a value.</p>";
        form.insertBefore(errorDiv, fName.nextElementSibling);
    }
    return false;
}

function validateLastName(){
    // Assume first-name cannot be less than 3 characters long
    // First, get the first name input element
    let lName = document.getElementById("last-name");
    if(lName.value !== ""){
        if(lName.value.length >= 3){
            if(document.getElementById("err-div")){
                form.removeChild(document.getElementById("err-div"));
            }
            return true;
        } else {
            errorDiv.innerHTML = "<p>The last name field must be at least 3 characters in length"
            form.insertBefore(errorDiv, lName.nextElementSibling);
        }
    } else {
        errorDiv.innerHTML = "<p>The last name field must contain a value.</p>";
        form.insertBefore(errorDiv, lName.nextElementSibling);
    }
    return false;
}

// Tests the input of the email field against an email regular expression
function validateEmail(){
    let email = document.getElementById("email");
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value)){
        if(document.getElementById("err-div")){
            document.querySelector("form").removeChild(document.getElementById("err-div"));
        }
        return true;
    }
        
    errorDiv.innerHTML = "<p>Email invalid. Please ensure that your email follows a typical format: example@email.com</p>";
    email.parentElement.insertBefore(errorDiv, email.nextElementSibling.nextElementSibling);
    
    return false;
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
        form.insertBefore(errorDiv, username.nextElementSibling.nextElementSibling);
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

function validateConfirmPassword(){
    // Get the first password value
    let firstPasswordEntry = document.getElementById("password").value;
    let reEnterPassword = document.getElementById("password-repeat");

    // If the reEnterPassword value is equal to the firstPasswordEntry value
    if(reEnterPassword.value === firstPasswordEntry){
        if(document.getElementById("err-div")){
            form.removeChild(document.getElementById("err-div"));
        }
        return true;
    } else {
        errorDiv.innerHTML = "<p>The password you entered does not match the first that you entered.</p>";
        form.insertBefore(errorDiv, reEnterPassword.nextElementSibling.nextElementSibling);
    }
    return false;
}

function validatePhone(){
    let phone = document.getElementById("phone");
    let phoneRegEx = /^\(?([0-9]{3})\)?[-. ]?([0-9]{3})[-. ]?([0-9]{4})$/;
    if(phoneRegEx.test(phone.value)){
        if(document.getElementById("err-div")){
            form.removeChild(document.getElementById("err-div"));
        }
        return true;
    } else {
        errorDiv.innerHTML = "<p>The phone number you entered is invalid. Try the format ###-###-####.</p>";
        form.insertBefore(errorDiv, phone.nextElementSibling.nextElementSibling);
    }
        
    return false;
}