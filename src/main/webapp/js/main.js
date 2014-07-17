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

	function validateCompleteForm(){
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
			return false;
		}else{			
			$('.status').removeClass('error');
			$('.status').html('');
			$('#nameInput').removeClass('error');
			$('#emailInput').removeClass('error');
			$('#messageInput').removeClass('error');			
			return true;
			
		}	
	}

	$('#sendEmailButton').on('click', function(e){
		e.preventDefault();		
		var isValidate = validateCompleteForm();
		if (isValidate){
			$('#emailForm').submit();
		}
	});
	
	$('#sendCommentButton').on('click', function(e){
		e.preventDefault();		
		var isValidate = validateCompleteForm();		
		if (isValidate){			
			$.ajax({
                url: $("#commentForm").attr( "action"),
                type: 'POST',
                data: $('#commentForm').serialize(),
                success: function (returnData) {
                    if(returnData === 'passed'){
                    	$('.status').html("*Your comment is wating author's approval*");						
                    	$('.status').removeClass('error');
                    }else if (returnData === "failed"){
                    	$('.status').html("Some error has occured. please try again later.");
                    	$('.status').addClass('error');
                    }else if(returnData === 'alreadyCommented'){
                    	$('.status').html("You have already commented. Your comment will be reviewed by author. please wait for a while before commenting again");						
                    	$('.status').addClass('error');
                    }
                },
                error: function () {
                    alert("error");
                }
            });

		}
	});
	
	function adminFunction(el){
		var action = el.html(), commentId = el.data('commentid'),
		comment = el.parent().parent()[0];
		$.ajax({
            url: '/ajax/comment/'+commentId,
            type: 'POST',
            data: {action: action},
            success: function (returnData) {
                if(returnData === 'deleted'){                	                	
                	$(comment).css('max-height', '0');
                	alert("Comment Deleted");
                }else if (returnData === "allowed"){                	
                	el.addClass('displayNone');
                	$(comment).find('.simpleButtonRed').removeClass('displayNone');                	
                	alert("Comment Allowed");
                }else if(returnData === 'disallowed'){                	
                	el.addClass('displayNone');  
                	$(comment).find('.simpleButtonGreen').removeClass('displayNone');
                	console.debug();              	
                	alert("Comment DisAllowed");
                }
            },
            error: function () {
                alert("Error has occured. Please try again later.");
            }
        });
	}

	$('.simpleButtonDelete').on('click', function(){
		adminFunction($(this));
	});

	$('.simpleButtonRed').on('click', function(){		
		adminFunction($(this));
	});

	$('.simpleButtonGreen').on('click', function(){
		adminFunction($(this));
	});




	function validateInput(value){
    	return !!value && value != "";
    }    

    $('#postBlogButton').on('click', function(ev){
    	ev.preventDefault();
		var isValidate = true, topic = $('#topicInput')[0].value,
		description = $('#descriptionInput')[0].value, month = $('#monthInput')[0].value,
		year = $('#yearInput')[0].value;
		
		isValidate = validateInput(topic) && validateInput(description) &&
		validateInput(month) && validateInput(year);
		
		if(isValidate){		

			var data = $('#blogForm').serialize();			
			// alert(data);
		$.ajax({
            url: '/ajax/addBlog',
            type: 'POST',
            data: {topic: topic, description: description, month: month, year: year},
            success: function () {
                alert("Thanks. Blog saved successfully !");
            },
            error: function () {
                alert("Error has occured. Please try again later.");
            }
        });

		}else{
			$('.status').addClass('error');
			$('.status').html('Could not post form. Some of the filds are missing !');
		}
	});
    
    
    $('.simpleBlogDelete').on('click', function(){

    	var el = $(this), blogId = el.data('blogid'), blog = el.parent();
		$.ajax({
            url: '/ajax/blog/'+blogId,
            type: 'POST',
            success: function () {
            	$(blog).css('max-height', '0');
            	alert("Comment Deleted");
            },
            error: function () {
                alert("Error has occured. Please try again later.");
            }
        });


	});

});

})(jQuery);