function validateForm() {
    let isValid = true;
    $('.validate').each(function () {
        if ($(this).val().trim() === '') {
            isValid = false;
            return false;
        }
    });
    return isValid;
}

$('.confirmed').on('click', function (event) {
    event.preventDefault();
    if (validateForm()) {
        $('.main-form').submit();
    } else {
        alert('請填寫所有必填項！');
        $('.model').css('display', 'none');
    }
})