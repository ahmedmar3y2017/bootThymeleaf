$(document).ready(function () {

    // SUBMIT FORM
    $("#customerForm").submit(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPost();
    });


    function ajaxPost() {

        // PREPARE FORM DATA
        var person = {
            name: $("#name").val(),
            address: $("#address").val()
        }

        console.log(window.location + "save");
        console.log("Data : "+JSON.stringify(person));

        // DO POST
        $.ajax({
            type: "POST",
            contentType: "application/json",
            url: window.location + "save",
            data: JSON.stringify(person),
            dataType: 'json',
            success: function (result) {
                console.log("Result : "+result.data.name)
                if (result.status == "Done") {
                    $("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" +
                        "Post Successfully! <br>" +
                        "---> Customer's Info: Name  = " +
                        result.data.name + " ,Address = " + result.data.address + "</p>");
                } else {
                    $("#postResultDiv").html("<strong>Error</strong>");
                }
                console.log(result);
            },
            error: function (e) {
                alert("Error!")
                console.log("ERROR: ", e);
            }
        });

        // Reset FormData after Posting
        resetData();

    }

    function resetData() {
        $("#name").val("");
        $("#address").val("");
    }
})



