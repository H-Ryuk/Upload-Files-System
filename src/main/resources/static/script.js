document.getElementById("fileUploadForm").addEventListener("submit", function(event) {
    event.preventDefault(); // Prevent form from submitting the traditional way

    const fileInput = document.getElementById("file");
    const file = fileInput.files[0];

    if (!file) {
        document.getElementById("statusMessage").innerHTML = "Please select a file.";
        return;
    }

    const formData = new FormData();
    formData.append("file", file);

    // Send POST request to upload the file
    fetch('http://localhost:8080/api/v1/upload', {
        method: 'POST',
        body: formData
    })
        .then(response => {
            if (response.ok) {
                return response.text(); // Get response message if successful
            } else {
                throw new Error('File upload failed with status ' + response.status);
            }
        })
        .then(data => {
            // If the response is successful, show success message
            document.getElementById("statusMessage").innerHTML = data;
            document.getElementById("statusMessage").classList.add("success");
            document.getElementById("statusMessage").classList.remove("error");
        })
        .catch(error => {
            // If there's an error, show error message
            document.getElementById("statusMessage").innerHTML = error.message;
            document.getElementById("statusMessage").classList.add("error");
            document.getElementById("statusMessage").classList.remove("success");
        });
});
