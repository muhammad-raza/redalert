(function($) {

'use strict';
$(function(){
	var currentPage, nextPage, PrevPage, canvas, context;


	$('.right_hand_side').fadeIn(500).css("display","inline-block");
	// turn.init('book');

	function openBook(page){		
		currentPage = page || 1;
		clearCanvas();
		renderPDF(currentPage);
		$('.left').data('page', currentPage-1);
		$('.right').data('page', currentPage+1);		
		$('body').addClass('open');
		$('.book_gallery_container').addClass('display');
		setTimeout(function(){$('.book_gallery_container').addClass('open');},0);		
	}

	function closeBook(){
		$('body').removeClass('open');
		$('.book_gallery_container').removeClass('open');		
		setTimeout(function(){$('.book_gallery_container').removeClass('display');},300);
		clearCanvas();
	}

	$('.the_book_image').on('click', function(){
		openBook(1);
	});

	$('.read_online').on('click', function(){
		openBook(1);
	});		

	$('.left').on('click', function(){		
		openBook($(this).data('page'));
	});	

	$('.right').on('click', function(){		
		openBook($(this).data('page'));
	});	

	$('.close').on('click', function(){
		closeBook(currentPage);
	});

	$(document).keydown(function(e){
	    if (e.keyCode == 37) { 	
	    	openBook($('.left').data('page'));
	    }else if(e.keyCode == 39){
	    	openBook($('.right').data('page'));
	    }
	});

	function renderPDF(pageNum){
		PDFJS.getDocument('pdf/redalert.pdf').then(function(pdf) {
		  // Using promise to fetch the page
		  pdf.getPage(pageNum).then(function(page) {
		    var scale = 1.25;
		    var viewport = page.getViewport(scale);

		    //
		    // Prepare canvas using PDF page dimensions
		    //
		    canvas = document.getElementById('canvas');
		    context = canvas.getContext('2d');
		    canvas.height = viewport.height;
		    canvas.width = viewport.width;		    
		    //
		    // Render PDF page into canvas context
		    //
		    var renderContext = {
		      canvasContext: context,
		      viewport: viewport
		    };
		    page.render(renderContext);
		  });
		});
	}

	function clearCanvas(){
		if (context){
			context.clearRect(0,0,canvas.width, canvas.height)
		}
	}


});

})(jQuery);