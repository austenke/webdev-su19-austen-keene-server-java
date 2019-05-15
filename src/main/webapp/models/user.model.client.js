function User(username, password, firstName, lastName) {
    this.username = username;
    this.password = password;
    this.firstName = firstName;
    this.lastName = lastName;

    this.setUsername = setUsername;
    this.getUsername = getUsername;
    this.setPassword = setPassword;
    this.getPassword = getPassword;
    this.setFirst = setFirst;
    this.getFirst = getFirst;
    this.setLast = setLast;
    this.getLast = getLast;

    function getUsername() {
        return this.username;
    }

    function setUsername(username) {
        this.username = username;
    }

    function getPassword() {
        return this.password;
    }

    function setPassword(password) {
        this.password = password;
    }

    function getFirst() {
        return this.firstName;
    }

    function setFirst(firstName) {
        this.firstName = firstName;
    }

    function getLast() {
        return this.lastName;
    }

    function setLast(lastName) {
        this.lastName = lastName;
    }

}
