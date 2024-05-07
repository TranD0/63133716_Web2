$(document).ready(function() {
    var a = 1;
    eye();

    function eye() {
      $('.eye').click(function() {
        if (a == 1) {
          $('#password').attr('type', 'text');
          a = 0;
        } else {
          $('#password').attr('type', 'password');
          a = 1;
        }
        $('.fa-eye-slash').toggleClass('close');
        $('.fa-eye').toggle();
      });
    }
  });

  function registerForm() {
    $("#formTitle").text("Registration");
    $('.Login_form').hide();
    $('.Registration_form').toggle();
    $('.forgotpassword_form').hide();
  }

  function forgotPassword() {
    $("#formTitle").text("ForgotPassword");
    $('.Login_form').toggle();
    $('.forgotpassword_form').toggle();

  }

  function loginForm() {
    $("#formTitle").text("Login");
    $('.Login_form').toggle();
    $('.forgotpassword_form').hide();
    $('.Registration_form').hide();
  }

  function error(errorMessage, errorCode) {
    $("#error" + errorCode).text(errorMessage);
  }


  function success() {
    swal({
      title: "tràu quâu",
      text: "thành công rầu",
      icon: "success",
      button: null,
    });
  }