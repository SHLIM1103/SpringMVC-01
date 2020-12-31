'use strict'
var common = common || {}
common = (()=>{
	const init = ctx => {
		localStorage.setItem('ctx', ctx)
		$('#manager_register').click(e => {location.href = `${ctx}/admin/mgr/register`})
		$('#teacher_register').click(e => {location.href = `${ctx}/admin/tea/register`})
		$(`#linkedin`).click(e => {location.href = `${ctx}/`})
		$(`#stu-join`).click(e => {location.href = `${ctx}/user/register`})
		$(`#stu-login`).click(e => {location.href = `${ctx}/user/login`})
		$(`#blog_default`).click(e => {location.href = `${ctx}/content/bbs/index`})
		$(`#icon1`).html(`<img src="https://images.pexels.com/photos/220453/pexels-photo-220453.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500" alt="">`)
		$(`#icon2`).html(`<img src="http://lavinephotography.com.au/wp-content/uploads/2017/01/PROFILE-Photography-112.jpg" alt="">`)
		$(`#icon3`).html(`<img src="http://lavinephotography.com.au/wp-content/uploads/2017/01/PROFILE-Photography-107.jpg" alt="">`)
		$(`#title`).text(`원어민 어학 사이트`)
		$(`#message`).text(`화상강의솔루션, 스카이프 등을 이용하여\n 필리핀등 원어민 강사와 한국 학생간에 회화 교육을 하는 사이트 구축.`)

	}
	
	const goHome = () => {
		$(`#goHome`).click(e => {location.href = ` ${localStorage.getItem('ctx')}/`})
	}
	return {init, goHome}
})()

$('#home').click(e => {location.href = '/'})
        $('#facebook').click(e => {location.href = '/transfer/sym/tea/index'})
        $('#signupbtn').click(e => {
            e.preventDefault()
            $.ajax({
                url: `/teachers`,
                type: 'POST',
                data: JSON.stringify({
                    name: $('#name').val(),
                    password: $('#password').val(),
                    subject: $('#subject').val()
                }),
                dataType: 'json',
                contentType: 'application/json',
                success: d => {
                   location.href='/transfer/sym/tea/index'
                },
                error: e => {
                    console.log(`교강사등록 실패: ${e.responseText}`)
                    location.href = '/move/cmm/404'
                }
            })
        })