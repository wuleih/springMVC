/**
 * 
 */
$(function(){
	
	$(document).on("click","button.btn_example",function(){
	  var ht = "<div>这是神马情况~~~</div>";
	  $(this).append(ht);
    });
	
});