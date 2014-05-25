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
});

})(jQuery);