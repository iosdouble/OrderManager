/**
 * 登录请求
 */
function loginSubmit() {
    // var pwd=SHA1("ectl"+$("#username").val()+SHA1($("#password").val()));
    var requestData = JSON.stringify({
        username: $("#username").val(),
        // password: pwd
        password:$("#password").val()
    });
    console.log(requestData);
    sendRequest2("/login", requestData, false, loginCallBack);
}

/**
 * 登录回调
 * @param response
 */
function loginCallBack(response) {
	console.log("callback");
    if (response == "success") {
        window.location = 'index';
    } else {
    	toastr.warning(response);
        $("#err-msg").css("opacity", "1");
        window.event.returnValue = false;
    }
}