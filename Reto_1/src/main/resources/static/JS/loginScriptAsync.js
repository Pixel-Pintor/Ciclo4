async function loginUser(event) {
    event.preventDefault();
    try {
        const emailInput = document.querySelector("#email-user");
        const passwordInput = document.querySelector("#password-user");
        const emptyInput = "";
        if (emailInput && passwordInput) {
            const emailUser = emailInput.value.trim();
            const passwordUser = passwordInput.value.trim();
            if (emailUser !== emptyInput) {
                console.log(`The email ${emailUser} is valid.`);
                if (passwordUser !== emptyInput) {
                    console.log(`The password ${passwordUser} is valid.`);
                    sendDataUser(emailUser, passwordUser)
                        .then(function (response) {
                            console.log(`Response: ${response}`);
                            return response.json();
                        })
                        .then((objectUser) => {
                            if (objectUser.id !== null) {
                                alert(`Welcome user ${objectUser.name}.`)
                                passwordInput.style.backgroundColor = "#9FF08E";
                                emailInput.style.borderColor = "#18D934";
                                passwordInput.style.borderColor = "#18D934";
                            } else {
                                alert(`The user ${emailUser} don't exist.`);
                                passwordInput.style.backgroundColor = "#F07762";
                                emailInput.style.borderColor = "#F01406";
                                passwordInput.style.borderColor = "#F01406";
                            }
                        });
                } else {
                    console.log("Invalid password value.");
                }
            } else {
                console.log("Invalid email value.");
            }
        } else {
            alert("Please fill all the fields.");
        }
    } catch (error) {
        console.log(`Unexpected error in Login User function: ${error}`);
    }
}

function sendDataUser(email, password) {
    try {
        const url = `http://localhost:8081/api/user/${email}/${password}`;
        return fetch(url);
    } catch (error) {
        console.log(`Unexpected error in Send Data User function: ${error}`);
    }
}
