// Global variables to control what the user sees on the form
const errorDiv = document.createElement("div");
errorDiv.id = "err-div";
const section = document.querySelector("section");

// Listen for when the window finishes loading the document
window.addEventListener("load", function(){
    let form = this.document.querySelector("form");

    // Add an event listener to the form element
    form.addEventListener("submit", function(evt){
        // Add custom validation
        // If the validateForm() method returns false
        if(!validateForm())
            // Then prevent the submit from occuring
            evt.preventDefault();
        // Else the form will submit automatically
    }, false);
}, false);

// validateForm() returns the boolean value of all the other validate methods
function validateForm(){
    return validateStreet() && validateZipCode() && validateCity() && validateState() && validateEmail();
}

// Returns true if the value of the street is not an empty string
function validateStreet(){
    let street = document.getElementById("street");
    if(street.value !== ""){
        if(document.getElementById("err-div")){
            document.querySelector("form").removeChild(document.getElementById("err-div"));
        }
        return true;
    }
    
    errorDiv.innerHTML = "<p>Street field must contain a value</p>";
    street.parentElement.insertBefore(errorDiv, street.nextElementSibling);

    return false;
}

// Returns true if the value of city is not an empty string
function validateCity(){
    let city = document.getElementById("city");

    if(city.value !== ""){
        if(document.getElementById("err-div")){
            document.querySelector("form").removeChild(document.getElementById("err-div"));
        }
        return true;
    }
    
    errorDiv.innerHTML = "<p>City field must contain a value</p>";
    city.parentElement.insertBefore(errorDiv, city.nextElementSibling);

    return false;
}

// Returns true if the state input is not empty
function validateState(){
    // Assume input is invalid
    let state = document.getElementById("cust-state");

    // If the value of the input is not empty
    if(state.value !== ""){
        // Then make sure the user has not tried to submit the form without a value
        if(document.getElementById("err-div")){
            document.querySelector("form").removeChild(document.getElementById("err-div"));
        }

        // Return true if there is a value
        return true;
    }

    // Otherwise, tell the user that the input needs to contain a value and return false
    errorDiv.innerHTML = "<p>Please select a state.</p>";
    state.parentElement.insertBefore(errorDiv, state.nextElementSibling);

    return false;
}

// Tests the input of the email field against an email regular expression
function validateEmail(){
    let email = document.getElementById("cust-email");
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value)){
        if(document.getElementById("err-div")){
            document.querySelector("form").removeChild(document.getElementById("err-div"));
        }
        return true;
    }
        
    errorDiv.innerHTML = "<p>Email invalid. Please ensure that your email follows a typical format: example@email.com</p>";
    email.parentElement.insertBefore(errorDiv, email.nextElementSibling);
    
    return false;
}

// Returns true if the zip code field is a number and the length of the string is exactly 5 characters long
function validateZipCode(){
    let zip = document.getElementById("zip");
    let isZip = false;
    if(!isNaN(zip.value) && zip.value.length === 5){
        if(document.getElementById("err-div")){
            document.querySelector("form").removeChild(document.getElementById("err-div"));
        }
        isZip = true;
    } else{
        errorDiv.innerHTML = "<p>Zip code field must contain a number and be 5 characters long.</p>";
        zip.parentElement.insertBefore(errorDiv, zip.nextElementSibling);
        isZip = false;
    }
    
    return isZip;
}

/*
    Make sure each field has a value and the value is the right type and format.

    email needs to follow the format of 'emaiuser@domain.com'

    zipcode does not need to exceed 5 characters and cannot be less than 5 characters. The zip code also needs to be a number

    street and city are the only inputs that do not need special formatting; they cannot be empty, however.
*/