
function checkID() {
  var data = $("#user_id").val();
  var url = "apis/iddetection";

  var success = function (resData) {
    newState = resData["message"];
    if (newState == "fail") {
      newState = "学号重复，验证失败";
      $("#status").html(newState);
    }

  }

  var error = function (jqxhr, errorCode) {
    alert(errorCode);
  }

  $.ajax({
    type: "POST",
    url: url,
    data: data,
    success: success,
    error: error,
    contentType: "application/x-www-form-urlencoded; charset=UTF-8",
    dataType: "json",
    statusCode: {
      404: function() {
        alert("404")
      }
    }
  });
}


function startInput() {
  var url = "apis/fingerregist";

  var success = function (resData) {
    resData = resData["messge"];
    if (resData == "fail") {
      $("#status").html("系统繁忙中，请稍后再试");
    }
    window.location = "http://localhost:7070/recording.html"
  }

  var error = function (jqxhr, errorCode) {
    alert(errorCode);
  }

  $.ajax({
    type: "POST",
    url: url,
    success: success,
    error: error,
    contentType: "application/x-www-form-urlencoded; charset=UTF-8",
    dataType: "json",
    statusCode: {
      404: function() {
        alert("404")
      }
    }
  })
}


window.onload = function () {
  document.getElementById("startbutton").addEventListener("click", checkID)
}
