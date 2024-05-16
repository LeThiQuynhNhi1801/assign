// Function to make an HTTP GET request
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

// Function to render teams data
function renderTeams(teams) {
    var teamsContainer = document.getElementById("teams-container");
    teamsContainer.innerHTML = ''
    teams.forEach(function(team) {
        var teamDiv = document.createElement("div");
        teamDiv.classList.add("team");

        var teamNameSpan = document.createElement("span");
        teamNameSpan.classList.add("team-name");
        teamNameSpan.textContent = team.teamName;

        var assignButton = document.createElement("button");
        assignButton.classList.add("btn-giaoviec");
        assignButton.textContent = "Giao việc";

        // Add click event listener to the assign button
        assignButton.onclick = function() {
            // Redirect to the assign page
            window.location.href = "/assign/" + team.idTeam;
        };
        teamDiv.appendChild(teamNameSpan);
        teamDiv.appendChild(assignButton);
        teamsContainer.appendChild(teamDiv);
    });
}

// Fetch data from API and render teams
fetchData("http://127.0.0.1:8082/apiv1/user/allTeam/" + localStorage.getItem('idUser'), function(response) {
    var teams = JSON.parse(response);
    renderTeams(teams);
});