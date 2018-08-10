$(document).ready(function () {

    // Activated the table


    /*$.ajax({
     type: "POST",
     contentType: "application/json",
     url: "/DeploymentWebApp/getAjax",
     data: JSON.stringify(""),
     dataType: 'json',
     success: function (result) {
     alert('--->'+result.status)
     },
     error: function (e) {
     alert("Error!")
     console.log("ERROR: ", e);
     }
     });*/



    var tableClient = $('#tableClient').DataTable({
        "autoWidth": false,
        "columnDefs": [
            {"targets": [0],
                "visible": false,
                "searchable": false}
        ]

    });

    
    $.ajax({
        url: 'apexClasses',
        success: function (data) {
            var classData = JSON.parse(data);
            for (var i = 0; i < classData.length; i++) {
                
                tableClient.row.add([
                    classData[i].classname,
                    "<input type='checkbox' value='"+classData[i].classname+"' id=''>",
                    classData[i].classname
                ]).draw();
            }
            //$('#result').html(data);
        }
    });


    $("#pickerDateBirth").datetimepicker({
        format: 'DD/MM/YYYY'
    });


    $(window).load(function () {

    });

    $("#buttonSearch").click(function () {
        tableClient.clear().draw();
        tableClient.ajax.reload();

    });

    $("#buttonInsert").click(function () {
        $(this).callAjax("insertClient", "");

        $(".form-control").val("");

    });

    $("#buttonDelete").click(function () {

        var valuesChecked = $("#tableClient input[type='checkbox']:checkbox:checked").map(
                function () {
                    return this.value;
                }).get().join(",");
        alert(valuesChecked);
        $(this).callAjax("deleteClient", valuesChecked);

    });

    $.fn.callAjax = function (method, checkeds) {
        $.ajax({
            type: "POST",
            url: "/BootstrapSpringProject/" + method,
            dataType: "json",
            timeout: 100000,
            data: {name: $("#name").val(), lastname: $("#lastname").val(), dateBirth: $("#dateBirth").val(),
                register: $("#register").val(), checked: checkeds},

            success: function (data) {
                tableClient.clear().draw();
                tableClient.ajax.reload();
            },
            error: function (e) {
                alert("ERROR: ", e);
            }
        });
    }

});


