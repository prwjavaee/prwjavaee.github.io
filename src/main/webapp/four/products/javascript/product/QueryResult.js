$(function () {
    const headRow = $('thead tr');
    const bodyRows = $('tbody tr');
    const deleteBtn = $('.delete');
    const deleteConfirmBtn = $('.delete-confirmed');

    function toggleDelete() {
        let rowCount = bodyRows.length;
        if (rowCount === 0) {
            deleteBtn.hide();
            $('.buttons').css('width', '200');
        } else {
            deleteBtn.show();
            $('.buttons').css('width', '400');
        }
    }

    toggleDelete();
    $('tbody').on('MutationObserver', toggleDelete);

    let isDeleteFuncActive = false;
    function deleteRow() {
        if (!isDeleteFuncActive) {
            deleteConfirmBtn.css('display', 'block');
            $('.add').css('display', 'none');
            $('.query').css('display', 'none');
            $('.buttons').css('width', '550');
            $('.delete-column').css('display', 'table-cell');
            deleteBtn.css('background-color', 'lightgreen');
            deleteBtn.html('<i class="fa-solid fa-xmark"></i> 取消刪除');

        } else {
            deleteConfirmBtn.css('display', 'none');
            $('.add').css('display', 'block');
            $('.query').css('display', 'block');
            $('.buttons').css('width', '400');
            $('.delete-column').css('display', 'none');
            deleteBtn.html('<i class="fa-solid fa-trash-can"></i> 刪除資料');
            deleteBtn.css('background-color', 'lightcoral');
        }
        isDeleteFuncActive = !isDeleteFuncActive;
    }

    deleteBtn.on('click', function () {
        deleteRow();
    })

    deleteConfirmBtn.on('click', function () {
        deleteRow();
        $('.delete-form').submit();
    })
    
    $('#search-submit').on('click', function(event){
		event.preventDefault();
		if(validateForm()){
			$('.search-form').submit();
		} else{
			alert('請輸入查詢關鍵字');
		}
	})
})