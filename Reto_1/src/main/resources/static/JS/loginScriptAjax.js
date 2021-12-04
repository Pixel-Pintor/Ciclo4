function loginFunction() {
    let emailUser = $.trim($("#input-email").val());
    let passwordUser = $.trim($("#input-password").val());
    let dataLogin = {
        email: emailUser,
        password: passwordUser
    };

    $.ajax({
        url: `http://localhost:8080/api/user/${emailUser}/${passwordUser}`,
        type: 'GET',
        dataType: 'JSON',
        contentType: 'application/json; charset=utf-8',
        data: JSON.stringify(dataLogin),
        success: function(response) {
            alert("El usuario existe");
            console.log(`Welcome ${response.name}`);
        },

        error:function(jqXHR, textStatus, errorThrown) {
            window.location.reload()
            alert("El usuario no esta registrado.");
        }
    });
}