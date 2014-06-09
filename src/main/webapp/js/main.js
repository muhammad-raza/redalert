(function($) {

'use strict';
$(function(){
	$('.right_hand_side').fadeIn(500).css("display","inline-block");	
	$('.mobile_menu_button').on('click', function(){
		$('.mobile_left_nav').fadeIn(100);
	});	

	$('.close').on('click', function(){
		$('.mobile_left_nav').fadeOut(100);
	});	
	
	var move = $('.upper_body').height()+10;
	$(window).scroll(function(){        
       if ($(window).scrollTop() > move){
       		$(".nav_list").css('width', $(".nav_list").width()+'px');
       		$(".nav_list").addClass('fixed');

		}else{
			$(".nav_list").css('width', '100%');
			$(".nav_list").removeClass('fixed');
		}
    });

    $( window ).resize(function() {
  		$(".nav_list").css('width', '100%');
		$(".nav_list").removeClass('fixed');
	});    
	
    function validateName(name){
    	return !!name && name != "" && name.length < 25;
    }

	function validateEmail(email) {
	  var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	  return regex.test(email) && !!email && email != "" && email.length < 40;
	}

	function validateMessage(message){
		return !!message && message != "" && message.length < 250;
	}

	$('#adminLogin').on('click', function(e){
		e.preventDefault();
		$('#adminForm').submit();
	});

	$('#sendEmailButton').on('click', function(e){
		e.preventDefault();		
		var error, el, name = $('#nameInput')[0].value, email = $('#emailInput')[0].value,
		message = $('#messageInput')[0].value;
		if (!validateName(name)){
			error = "Please enter a valid Name";
			el = $('#nameInput');
		}
		if(!validateEmail(email) && !error){
			error = "Email address is not valid. please try again";
			el = $('#emailInput');
			$('#nameInput').removeClass('error');

		}
		if(!validateMessage(message) && !error){
			error = "Message is not valid. Please try less than 150 words.";
			el = $('#messageInput');
			$('#nameInput').removeClass('error');
			$('#emailInput').removeClass('error');

		}
		if(error){
			$('.status').addClass('error');
			el.addClass('error');
			$('.status').html(error);
		}else{			
			$('.status').removeClass('error');
			$('.status').html('');
			$('#nameInput').removeClass('error');
			$('#emailInput').removeClass('error');
			$('#messageInput').removeClass('error');			
			$('#emailForm').submit();			
		}		
	});

});

})(jQuery);