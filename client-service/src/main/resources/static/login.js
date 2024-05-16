document.getElementById("loginForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Ngăn chặn gửi form mặc định

    var formData = {
        username: document.getElementsByName("username")[0].value,
        password: document.getElementsByName("password")[0].value
    };

    console.log(formData)

    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (xhttp.status == 200) {
            var response = JSON.parse(xhttp.responseText);
                console.log(response)
                // Lưu idUser vào local storage
                localStorage.setItem('idUser', response.id);
                // Chuyển hướng sang trang giao diện home
                window.location.href = '/home'
        }else {
            console.error('Lỗi:', xhttp.status);
            alert('Đã có lỗi xảy ra khi đăng nhập. Vui lòng thử lại sau.');
        }
    };

    xhttp.open("POST", "http://127.0.0.1:8082/apiv1/user/login", true);
    xhttp.setRequestHeader("Content-Type", "application/json");
    xhttp.send(JSON.stringify(formData));
});