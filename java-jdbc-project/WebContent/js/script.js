$(document).ready(function() {
	$('#slides').superslides({
		animation:'fade',
		play:5000,
		/*setting pagination to false  remove the 3 dotes buttons*/
		pagination:false
	});
	var typed = new Typed(".typed", {
		strings: ["Welcome To My Ferrari Home Page ", "Fill Out The Form below To Register"],
		typeSpeed: 70,
		loop: true,
		startDelay:1000,
		showCursor:false
		
	});
});