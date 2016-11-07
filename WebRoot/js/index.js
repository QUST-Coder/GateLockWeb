
  var startInput = function functionName() {
    var button = document.getElementById('startbutton')
    button.textContent = "正在录入"
    button.disabled = "disabled"
  }

  var changeState = function (newState) {
    domELem = document.getElementById('startbutton')
    domELem.textContent = newState
  }

  var checkID = function (){
    alert('a')
    var checkflag = ""
    var data = document.getElementById('user_id').value
    checkflag = fetchData('checkID')
    setTimeout('', 100)
    checkflag = JSON.parse(checkflag)
    console.log(checkflag)
  }

  var pushButton = function () {

  }

  var fetchData = function (method, data, callback) {
      if (window.XMLHttpRequest) {
        var http_request = new XMLHttpRequest()
      } else {
        alert('兄弟赶紧去下个新浏览器')
        window.location="http://www.firefox.com.cn/download/"
      }
      if (callback == undefined) {
        callback = function foo() {}
      }
      http_request.onreadystatechange = callback
      switch (method) {
        case "checkID":
          http_request.open('GET', 'http://localhost:3000/checkID.json', true)
          //data = 'studentId=' + data
          break;
        case "startInput":
          http_request.open('POST', 'http://192.168.0.4:7070/apis/fingerregist', true)
          data = ""
          break;
        case "queryState":
          http_request.open('POST', 'http://192.168.0.4:7070/apis/registstate', true)
          break;
        default:
          delete http_request
          alert('api错误')
        http_request.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded')
        callback()
      }
      http_request.send()
      http_request.onload = function () {
        console.log(http_request.responseText)
        return http_request.responseText
      }
  }

window.onload = function () {
    var button = document.getElementById('startbutton')
    button.addEventListener("click", checkID)
}
