$(function() {
	const form = $('.productForm');

	function newInput(name, value) {
		$('<input>').attr({
			type: 'hidden',
			name: name,
			value: value
		}).appendTo(form);
	}

	function purchase() {
		let quantity = $('.number').val();
		if (quantity != 0) {
			form.submit();
		} else{
			$('.model').css('display', 'block');
			$('.model-title').text('請先選擇購買數量！')
		}
	}

	$('#purchase').click(function() {
		newInput('action', 'DirectPurchase');
		purchase();
	});

	$('#cart').click(function() {
		newInput('action', 'AddToCart');
		purchase();
	});
})