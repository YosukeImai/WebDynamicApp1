/**
 * 
 */
function pushBtn(){
	var form=document.getElementById('loginForm');
	var password=document.getElementById('textPass').value;
	var hashStr=sha256(password);//hashing
	document.getElementById('hashPass').setAttribute("value",hashStr);
	form.submit();
}

function sha256(src_text){
	var shaObj = new jsSHA("SHA-256", "TEXT");
	shaObj.update(src_text);
	var sha256digest = shaObj.getHash("HEX");
	return sha256digest;
}