function UserService() {

    this.createUser = function (user) {
        user.id = (new Date()).getTime();

        return fetch("http://localhost:8080/users", {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response) {
            return response.json()
        })
    };

    this.updateUser = function (userId, user) {
        return fetch("http://localhost:8080/users/" + userId, {
            method: 'POST',
            body: JSON.stringify(user),
            headers: {
                'content-type': 'application/json'
            }
        }).then(function(response) {
            return response.json();
        })
    };

    this.findAllUsers = function () {
        return fetch("http://localhost:8080/users", {
            method: 'GET'
        }).then(function(response) {
            return response.json();
        })
    };

    this.findUserById = function (userId) {
        return fetch("http://localhost:8080/users/" + userId, {
            method: 'GET'
        }).then(function(response) {
            return response.json();
        })
    };

    this.deleteUser = function(userId) {
        return fetch("http://localhost:8080/users/" + userId, {
            method: 'DELETE'
        }).then(function(response) {
            return response.json();
        })
    };
}