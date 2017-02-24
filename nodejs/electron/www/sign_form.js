function validateForm()
 {
  /** var x = document.forms["myForm"]["inputEmail"].value;
	var y = document.forms["myForm"]["inputPassword"].value;**/
		var x=document.getElementById("inputEmail").value;
			var y=document.getElementById("inputPassword").value;
			var z=document.getElementById("userName").value;
			
    if (x == "" || y == "" || z == "")
	{
        alert("field must be filled out");
        return false;
    }
}

