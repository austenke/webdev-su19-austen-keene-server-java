(function () {

    const $usernameFld = $('#usernameFld');
    const $passwordFld = $('#passwordFld');
    const $firstNameFld = $('#firstNameFld');
    const $lastNameFld = $('#lastNameFld');
    const $roleFld = $('#roleFld');
    const $dobFld = $('#dobFld');

    const tbody = $('#tableBody');

    const userService = new UserService();

    let updateId = "";

    userService.findAllUsers(renderUsers).then(function(response) {
        renderUsers(response);
    });

    function renderUsers(users) {
        tbody.empty();
        for(i in users) {
            renderUser(users[i])
        }
    }

    function renderUser(user) {
        console.log("Rendering: " + JSON.stringify(user));

        const row = $('.userRowTemplate').clone();
        row.removeClass('d-none');
        row.removeClass('userRowTemplate');
        const usernameCol = row.find('.usernameCol');
        const passwordCol = row.find('.passwordCol');
        const firstNameCol = row.find('.firstNameCol');
        const lastNameCol = row.find('.lastNameCol');
        const roleCol = row.find('.roleCol');
        const dobCol = row.find('.dobCol');
        const deleteBtn = row.find('.deleteBtn');
        const editBtn = row.find('.editBtn');
        deleteBtn.click(deleteUser);
        deleteBtn.attr('id', user.id);
        editBtn.click(editUser);
        editBtn.attr('user', JSON.stringify(user));

        usernameCol.html(user.username);
        passwordCol.html(user.password);
        firstNameCol.html(user.firstName);
        lastNameCol.html(user.lastName);
        roleCol.html(user.role);
        dobCol.html(user.dob);

        $usernameFld.val("");
        $passwordFld.val("");
        $firstNameFld.val("");
        $lastNameFld.val("");
        $roleFld.val("");
        $dobFld.val("");

        tbody.append(row);
    }

    function createUser() {
        const username = $usernameFld.val();
        const password = $passwordFld.val();
        const firstName = $firstNameFld.val();
        const lastName = $lastNameFld.val();
        const role = $roleFld.val();
        const dob = $dobFld.val();

        const user = {
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role,
            dob: dob
        };

        userService
            .createUser(user)
            .then(renderUsers)
    }

    function editUser() {
        console.log("FOOOOO")
        const editBtn = $(event.currentTarget);
        const user = JSON.parse(editBtn.attr('user'));
        console.log("User val is: " + JSON.stringify(user));
        $usernameFld.val(user.username);
        $passwordFld.val(user.password);
        $firstNameFld.val(user.firstName);
        $lastNameFld.val(user.lastName);
        $roleFld.val(user.role);
        $dobFld.val(user.dob);
        updateId = user.id;
    }

    function updateUser() {
        const username = $usernameFld.val();
        const password = $passwordFld.val();
        const firstName = $firstNameFld.val();
        const lastName = $lastNameFld.val();
        const role = $roleFld.val();
        const dob = $dobFld.val();
        const id = updateId;
        updateId = "";

        const user = {
            id: id,
            username: username,
            password: password,
            firstName: firstName,
            lastName: lastName,
            role: role,
            dob: dob
        };

        userService
            .updateUser(id, user)
            .then(renderUsers)
    }

    function deleteUser(event) {
        console.log("SDJFHSDKJHF")
        const deleteBtn = $(event.currentTarget);
        userService.deleteUser(deleteBtn.attr('id')).then(renderUsers);
    }

    $('#wbdv-create').click(createUser);
    $('#wbdv-update').click(updateUser);
})();