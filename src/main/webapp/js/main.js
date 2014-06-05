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
});

})(jQuery);