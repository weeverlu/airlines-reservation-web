function AMFn() {
    var Fn = this;
    this.init = function() {
        // Add new airline button
        $('#add-new').bind('click', function() {
            Fn.add();
        });
        // Edit airline button for each
        $('.btn-edit').bind('click', function() {
            Fn.edit(this);
        });
        // cancel button
        $('.close').bind('click', function () {
            Fn.cancel();
        });
        $('.btn-close-modal').bind('click',function () {
            Fn.cancel();
        })
        // submit button
        $('#btn-submit').bind('click',function () {
            Fn.submit();
        });
        // delete button
        $('.btn-delete').bind('click',function () {
            Fn.show_delete(this);
        });
        // delete confirm
        $('#submit-delete').bind('click',function () {
            Fn.submit_delete(this);
        });
    }

    this.add = function() {
        $('.modal-title').first().text("Add New Airline");
        $('#submit_type').val("add");
        $('#edit_id').val("");
    }

    this.edit = function(e) {
        $('#submit_type').val("edit");
        $('#edit_id').val($(e).data('id'));
        $('.modal-title').first().text("Edit Airline");
        console.log($(e).data('flight_num'));
        $('#input-flight-num').val($(e).data('flight_num'));
        $('#input-model').val($(e).data('model'));
        $('#input-num-first').val($(e).data('num_1st'));
        $('#input-price-first').val($(e).data('pri_1st'));
        $('#input-num-eco').val($(e).data('num_eco'));
        $('#input-price-eco').val($(e).data('pri_eco'));
        $('#input-dep-port').val($(e).data('dep_port'));
        $('#input-arr-port').val($(e).data('arr_port'));
        $('#input-dep-time').val($(e).data('dep_time'));
        $('#input-arr-time').val($(e).data('arr_time'));
    }

    this.cancel = function() {
        $('#edit_id').val("");
        $('#submit_type').val("");
        $('#input-flight-num').val("");
        $('#input-model').val("");
        $('#input-num-first').val("");
        $('#input-price-first').val("");
        $('#input-num-eco').val("");
        $('#input-price-eco').val("");
        $('#input-dep-port').val("");
        $('#input-arr-port').val("");
        $('#input-dep-time').val("");
        $('#input-arr-time').val("");
    }

    this.submit = function() {
        var flight_num = $('#input-flight-num').val();
        var model = $('#input-model').val();
        var num_first = $('#input-num-first').val();
        var price_first = $('#input-price-first').val();
        var num_eco = $('#input-num-eco').val();
        var price_eco = $('#input-price-eco').val();
        var dep_port = $('#input-dep-port').val();
        var arr_port = $('#input-arr-port').val();
        var dep_time = $('#input-dep-time').val();
        var arr_time = $('#input-arr-time').val();
        var data = {
            airlineNum: flight_num,
            planeModel: model,
            numFirstclass: num_first,
            numEconomy: num_eco,
            priceFirstclass: price_first,
            priceEconomy: price_eco,
            departurePort: dep_port,
            departureTime: dep_time,
            arrivalPort: arr_port,
            arrivalTime: arr_time
        };
        var url = "json/airManage/";
        if($('#submit_type').val() == "add") {
            url += "addNewOne";
        } else if($('#submit_type').val() == "edit") {
            url += "editThisOne"
            data['id'] =  $('#edit_id').val();
        }

        console.log(data);
        $.ajax({
            url:url,
            type:"POST",
            contentType : "application/json",
            data: JSON.stringify(data),
            dataType: "json",
            success: function (result) {
                console.log(result.status);
                console.log(result.data);
                if(result.status < 0) {
                    alert("Invalid Airline information! Please edit!");
                    window.location.reload();
                } else {
                    window.location.reload();
                }
            }
        });
    }

    this.show_delete = function(e) {
        $('#delete-info').text($(e).data('flight'));
        $('#delete-id').val($(e).data('id'));
    }


    this.submit_delete = function(e) {
        var id = $('#delete-id').val();
        console.log(id);
        var data = {
            id: id
        };
        $.ajax({
            url:'json/airManage/delete',
            type:"DELETE",
            contentType : "application/json",
            data: JSON.stringify(data),
            dataType: "json",
            success: function (result) {
                console.log(result.status);
                console.log(result.data);
                if(result.status < 0) {
                    alert(result.data);
                    window.location.reload();
                } else {
                    window.location.reload();
                }
            }
        });
    }
}

$(document).ready(function(){
    new AMFn().init();
});

