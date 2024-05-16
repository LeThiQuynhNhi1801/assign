var user=""
function assignTasks() {
    const urls = window.location.href;

// Phân tích URL và trích xuất phần số
    const parts = urls.split('/');
    const number = parts[parts.length - 1];
    var assignList = [];

    var taskForms = document.querySelectorAll('.task-form');
    taskForms.forEach(function(taskForm) {
        var name = taskForm.querySelector('input[name="name"]').value;
        var description = taskForm.querySelector('textarea[name="description"]').value;
        var deadline = taskForm.querySelector('input[name="deadline"]').value;

        var userList = [];
        var checkboxes = taskForm.querySelectorAll('input[name="user"]:checked');
        checkboxes.forEach(function(checkbox) {
            userList.push(checkbox.value);
        });


        var assign = {
            "name": name,
            "description": description,
            "listUser": userList,
            "deadline": deadline,
            "idTeam": number // Thay đổi idTeam tùy thuộc vào dữ liệu thực tế
        };

        assignList.push(assign);
    });

    var data = {
        "listAssign": assignList
    };
    console.log(data)
    var idUser = localStorage.getItem('idUser');

    const xhr = new XMLHttpRequest();
    xhr.open('POST', 'http://127.0.0.1:8080/api/assign/addAssign/'+idUser+'?idTeam='+number);
    xhr.setRequestHeader('Access-Control-Allow-Origin','Authorization, Content-Type')// Thay thế bằng URL API của bạn
    xhr.setRequestHeader('Content-Type', 'application/json'); // Set header Content-Type cho JSON
    xhr.onload = function() {
        if (xhr.status === 201) {
            alert(
                "giao viec thanh cong"
            )
        } else {
            // Yêu cầu thất bại
            console.error('Error:', xhr.statusText);
        }
    };
    xhr.send(JSON.stringify(data));

}

function fetchData(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === 4 && xhr.status === 200) {
            callback(xhr.responseText);
        }
    };
    xhr.open("GET", url, true);
    xhr.send();
}


// Fetch data from API and render teams
fetchData("http://127.0.0.1:8080/apiv1/user/inTeam/1", function(response) {
    var teams = JSON.parse(response);
    console.log(teams);
    const addUserButtons = document.querySelectorAll('.addUser');

    teams.forEach(function(team) {
        user += `<label><input type="checkbox" name="user" value="`+ team.id + `">`+ team.username +`</label><br>`;
    });
    var teamsContainer = document.getElementsByClassName("user-select")[0]; // Chọn phần tử đầu tiên trong danh sách

    teamsContainer.innerHTML = user;
});console.log(user)
function toggleUserSelect(button) {
    var userSelect = button.parentElement.querySelector('.user-select');
    if (userSelect.style.display === "none") {
        userSelect.style.display = "block";
    } else {
        userSelect.style.display = "none";
    }
}

function addTaskForm() {
    var taskForm = document.createElement('div');
    taskForm.classList.add('task-form');
    taskForm.innerHTML = `
                <label for="name">Tên nhiệm vụ:</label>
                <input type="text" id="name" name="name">
                <br>
                <label for="description">Mô tả:</label>
                <textarea id="description" name="description"></textarea>
                <br>
                <label for="deadline">Deadline:</label>
                <input type="datetime-local" id="deadline" name="deadline">
                <br>
                <button type="button" onclick="toggleUserSelect(this)">Chọn người thực hiện</button>
                <div class="user-select">`
                    + user +
                `</div>
                <button type="button" onclick="removeTaskForm(this)">Xóa</button>
            `;
    document.getElementById('assignForm').appendChild(taskForm);
}

function removeTaskForm(button) {
    var taskForm = button.parentElement;
    taskForm.remove();
}