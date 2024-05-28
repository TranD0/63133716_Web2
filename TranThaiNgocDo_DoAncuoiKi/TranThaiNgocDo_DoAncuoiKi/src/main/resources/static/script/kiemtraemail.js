$(document).ready(function(){
    $('#email').on('blur', function(){
        var email = $(this).val();
        $.ajax({
            url: '/Admin/NhanVien/KiemTraEmail',
            type: 'GET',
            data: {'email': email},
            success: function(response){
                if(response.exists){
                    $('#emailFeedback').html('<span class="text-danger">Email đã tồn tại!</span>');
                } else {
                    $('#emailFeedback').html('');
                }
            }
        });
    });

    $('#email').on('input', function(){
        $('#emailFeedback').html('');
    });
});
