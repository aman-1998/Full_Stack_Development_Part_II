function validateForm() {
  debugger
  var toast = document.getElementsByClassName("mtoast");
  var error = document.getElementsByClassName("errorMessage");
  
  // Default message
  var errorMsg = "Error occured while submitting"; 
  
  var errorOccured = false;
  let name = document.forms["myForm"]["name"].value;
  let email = document.forms["myForm"]["email"].value;
  let dob = document.forms["myForm"]["dob"].value;
  let gender = document.forms["myForm"]["gender"].value;
  let country = document.forms["myForm"]["country"].value;
  let language = document.querySelectorAll('input[type=checkbox]:checked');
 
  //Name validation
  if (name == "") {
    errorMsg = "Name can not be empty";
    errorOccured = true;
  } else if(email == "") { // Email validation
	errorMsg = "Email can not be empty";
    errorOccured = true;
  }else if (dob == "") { //DOB validation
    errorMsg = "Date of birth can not be empty";
    errorOccured = true;
  } else if (gender == "") { //Gender validation
    errorMsg = "Gender must be selected";
    errorOccured = true;
  } else if (country == "") { //Country validation
    errorMsg = "Country must be selected";
    errorOccured = true;
  } else if (language.length == 0) { //Language validation
    errorMsg = "At least one language must be selected";
    errorOccured = true;
  }
  
  // Error occured in submitting form
  if(errorOccured == true) {
  	error[0].innerHTML = errorMsg;
  	toast[0].style.display = "block";
  	debugger
  	
  	var toast2 = document.getElementsByClassName("mtoast2");
  	if(toast2.length != 0) {
		toast2[0].style.display = "none";
	}
	return false;
  }
}

function vanishClientSideError() {
	 var toast1 = document.getElementsByClassName("mtoast");
	 toast1[0].style.display = "none";
	 
	  
}

function vanishServerSideError() {
	var toast2 = document.getElementsByClassName("mtoast2");
	toast2[0].style.display = "none";
}

function resetForm() {
	document.getElementById("myForm").reset();
}