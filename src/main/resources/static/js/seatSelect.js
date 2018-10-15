function SSFn() {
    var Fn = this;
    var last_eco, last_first;
    this.init = function() {
        Fn.fetchData();

        $('[data-toggle="tooltip"]').tooltip();
        $('.first-seat').bind('click', function () {
            Fn.first_click(this);
        });
        $('.eco-seat').bind('click', function () {
            Fn.eco_click(this);
        });
        $('#btn-submit').bind('click', function () {
            Fn.submit();
        });
    }

    this.fetchData = function() {
        var occupied_list = $('#input-occupied').val();
        if(occupied_list) {
            occupied_list = occupied_list.split(",");
            // console.log(occupied_list);
            $(occupied_list).each(function (index) {
                // console.log($('div[title='+ occupied_list[index] + ']').prop("class"));
                $('div[title='+ occupied_list[index] + ']').removeClass($('div[title='+ occupied_list[index] + ']').prop("class"));
                $('div[title='+ occupied_list[index] + ']').addClass("occupied");
            });
        }

    }

    this.first_click = function(e) {
        // console.log($(e).data('original-title'));
        $('#seat_num_selected').text($(e).data('original-title'));
        $('#price_accord').text($('#input-price-first').val());
        $('#input-seat-type').val("1");
        $(e).css('background-color', '#76B474');


        if(last_first) {
            last_first.style.backgroundColor = '#3a78c3';
        }
        if(last_eco) {
            last_eco.style.backgroundColor =  '#B9DEA0';
        }
        last_first = e;
    }

    this.eco_click = function(e) {
        // console.log($(e).data('original-title'));
        $('#seat_num_selected').text($(e).data('original-title'));
        $('#price_accord').text($('#input-price-eco').val());
        $('#input-seat-type').val("0");
        $(e).css('background-color', '#76B474');


        if(last_first) {
            last_first.style.backgroundColor = '#3a78c3';
        }
        if(last_eco) {
            last_eco.style.backgroundColor =  '#B9DEA0';
        }
        last_eco = e;
    }
    
    this.submit = function () {
        var first_name = $('#input-first-name').val();
        var last_name = $('#input-last-name').val();
        var age = $('#input-age').val();
        var seat_num = $('#seat_num_selected').text();
        var seat_type = $('#input-seat-type').val();
        var airline_num = $('#input-airline-num').val();
        var plane_model = $('#input-plane-model').val();
        var price = $('#price_accord').text();
        console.log(price);
        var data = {
            airlineNum: airline_num,
            planeModel: plane_model,
            guestFirstName: first_name,
            guestLastName: last_name,
            guestAge: age,
            seatNum: seat_num,
            price: price,
            seatType: seat_type
        };

        $.ajax({
            url: "json/seat/reserve",
            type:"POST",
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
    new SSFn().init();

});

