async function registerFunction(event) {
    event.preventDefault();

    try {
        const nameField = document.querySelector("#input-name");
        const emailField = document.querySelector("#input-email");
        const passwordField = document.querySelector("#input-password");
        if (nameField && emailField && passwordField) {
            const newName = nameField.value.trim();
            const newEmail = emailField.value.trim();
            const newPassword = passwordField.value.trim();
            if (newName !== "") {
                console.log(`The name ${newName} is valid.`);
                if (newEmail !== "") {
                    console.log(`The email ${newEmail} is valid`);
                    if (newPassword !== "") {
                        console.log(`The password ${newPassword} is valid.`);
                        await sendNewUser(newName, newEmail, newPassword);
                        console.log("New data send.");
                    } else {
                        console.log("Invalid password.")
                    }
                } else {
                    console.log("Invalid email.")
                }
            } else {
                console.log("Invalid name value.")
            }
        }
    } catch (error) {
        console.log(`Unexpected error in "registerFunction()": ${error}`);
    }
}

async function sendNewUser(nam, ema, pass) {
    try {
        const urlRequest = `http://localhost:8081/api/user/new`;
        const bodyRequest = {
            email: ema,
            password: pass,
            name: nam,
        };
        const fetchOptions = {
            method: 'POST',
            body: JSON.stringify(bodyRequest),
            headers: {
                "Content-type": "application/json; charset=UTF-8",
                "Access-Control-Allow-Origin": "*",
            },
        };

        const response = await fetch(urlRequest, fetchOptions);
        const convertedJson = await response.json();
        console.log(`Converted JSON: ${convertedJson}`);
        alert(`User ${nam} register successfully.`);
    } catch (error) {
        console.log(`Unexpected error in "sendNewUser()": ${error}`);
    }
}