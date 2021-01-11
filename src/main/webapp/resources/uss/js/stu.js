'use strict'
var stu = stu || {}
stu.insertMany = x => {
	$.getJSON(`${x}/students/insert-many/${$('#stu-data-count').val()}`, 
			d => { location.reload();})}

stu.truncate = x => {
	$.getJSON(`${x}/students/truncate`, d => {
		location.reload();})}

stu.count = x => {
	$.getJSON(`${x}/students/count`, d => {
		$(`#stu-count`).text(d)})}

stu.list = x => {
	$.getJSON(`${x.ctx}/students/page/${x.pageSize}/${x.pageNum}`, d => { 
		$(`<h3/>`)
		.attr({id: `title`})
		.text(`학생목록`)
		.appendTo(`#mgr-data-mgt-stu`)
		$(`<table/>`)
		.attr({id: `tab`})
		.css({width: `100%`})
		.appendTo(`#title`) 
		$(`<tr/>`).attr({id: `tr_1`}).appendTo(`#tab`)
		$.each(
			[`No`,`아이디`,`이름`,`생년월일`,`성별`,`등록일`,`전공과목`],
			(i, j) => {
			$(`<th>${j}</th>`).css({backgroundColor: `green`})
			.appendTo(`#tr_1`)
		})
		
		$.each(d.list, 
			(i, j) => {
				$(`<tr><td>${j.stuNum}</td>
			   	       <td>${j.userid}</td>
			   	       <td>${j.name}</td>
					   <td>${j.birthday}</td>
					   <td>${j.gender}</td>
					   <td>${j.regDate}</td>
					   <td>${j.subject}</td></tr>`)
						.css({padding: `15px`, textAlign: `left`, fontSize: `medium`})
						.appendTo(`#tab`)
			})
		
		$(`<div/>`)
		.attr({id: `stu_page`})
		.addClass(`pagination`)
		.appendTo(`#mgr-data-mgt-stu`)
		const page = d.page
		
		/* Function* range(start, end) {
			for(let i = start ; i <= end ; i++) {
				yield i ;
			}
		   }
		아래는 for가 배제된 재귀함수 형태  */
		function* range(start, end) {
			yield start;
			if(start === end) return;
			yield* range(start + 1, end);
		}
		
		if(page.existPrev){
			$(`<a/>`)
			.attr({href: `#`})
			.text(`<<`)
			.css({backgroundColor: `gray`})
			.appendTo(`#stu_page`)
			.click(e => {
				e.preventDefault()
				$(`#mgr-data-mgt-stu`).empty()
				stu.list({ctx: x.ctx, pageSize: `10`, pageNum: page.prevBlock})
			})
		}
		
		$.each([...range(page.startPage, page.endPage)],
				(i, j) => {
					$(`<a/>`)
					.attr({href: `#`})
					.css({backgroundColor: (j != page.pageNum) ? `gray` : `green`})
					.text(`${j}`)
					.appendTo(`#stu_page`)
					.click(e => {
						e.preventDefault()
						$(`#mgr-data-mgt-stu`).empty()
						stu.list({ctx: x.ctx, pageSize: `10`, pageNum: j})
					})
		})
		
		if(page.existNext){
			$(`<a/>`)
			.attr({href: `#`})
			.css({backgroundColor: `gray`})
			.text(`>>`)
			.appendTo(`#stu_page`)
			.click(e => {
				e.preventDefault()
				$(`#mgr-data-mgt-stu`).empty()
				stu.list({ctx: x.ctx, pageSize: `10`, pageNum: page.nextBlock})
			})
		}
	})
}

/*
const userid = localStorage.getItem('searchId')
$.getJSON(`/students/${userid}`, d => {
	$('#profileImage').html(`<img src="${d.profileImage}" alt="${d.name}" class="img-fluid rounded-circle mb-2" width="128" height="128" />
							<h5 class="card-title mb-0">${d.name}</h5>
							<div class="text-muted mb-2">Lead Developer</div>

							<div>
								<a class="btn btn-primary btn-sm" href="#">Follow</a>
								<a class="btn btn-primary btn-sm" href="#"><span data-feather="message-square"></span> Message</a>
							</div>`)		
	$(`#subject`).html(`<h5 class="h6 card-title">수강과목</h5>
							<a href="#" class="badge badge-primary mr-1 my-1">${d.subject}</a>
							`)
							//stuNum, userid, password, name, ssn, regDate, subject, profileImage
	$(`#about`).html(`<h5 class="h6 card-title">About</h5>
							<ul class="list-unstyled mb-0">
								<li class="mb-1"><span data-feather="home" class="feather-sm mr-1"></span> 학생번호 : <a href="#">${d.stuNum}</a></li>

								<li class="mb-1"><span data-feather="briefcase" class="feather-sm mr-1"></span> 생년월일 : <a href="#">${d.ssn}</a></li>
								<li class="mb-1"><span data-feather="map-pin" class="feather-sm mr-1"></span> 주소 : <a href="#">서울</a></li>
							</ul>`)
})

$('#signupbtn').click(e => {
            e.preventDefault()
            $.ajax({
                url: `/students`,
                type: 'POST',
                data: JSON.stringify({
                    userid: $('#userid').val(), 
                    ssn: $('#ssn').val(), 
                    regDate: $('#regDate').val(), 
                    subject: $('#subject').val(), 
                    name: $('#name').val(),
                    password: $('#password').val()
                }),
                dataType: 'json',
                contentType: 'application/json',
                success: d => {
                   location.href='/move/uss/login'
                },
                error: e => {
                    console.log(`학습자등록 실패: ${e.responseText}`)
                    location.href = '/move/cmm/404'
                }
            })
        })

const userid = sessionStorage.getItem('userid')
		$.getJSON(`/students/${userid}`, d => {
			$('#profileImage').html(`<img src="${d.profileImage}" alt="${d.name}" class="img-fluid rounded-circle mb-2" width="128" height="128" />
									<h5 class="card-title mb-0">${d.name}</h5>
									<div class="text-muted mb-2">Lead Developer</div>

									<div>
										<a class="btn btn-primary btn-sm" href="#">Follow</a>
										<a class="btn btn-primary btn-sm" href="#"><span data-feather="message-square"></span> Message</a>
									</div>`)		
			$(`#subject`).html(`<h5 class="h6 card-title">수강과목</h5>
									<a href="#" class="badge badge-primary mr-1 my-1">${d.subject}</a>
									`)
									//stuNum, userid, password, name, ssn, regDate, subject, profileImage
			$(`#about`).html(`<h5 class="h6 card-title">About</h5>
									<ul class="list-unstyled mb-0">
										<li class="mb-1"><span data-feather="home" class="feather-sm mr-1"></span> 학생번호 : <a href="#">${d.stuNum}</a></li>

										<li class="mb-1"><span data-feather="briefcase" class="feather-sm mr-1"></span> 생년월일 : <a href="#">${d.ssn}</a></li>
										<li class="mb-1"><span data-feather="map-pin" class="feather-sm mr-1"></span> 주소 : <a href="#">서울</a></li>
									</ul>`)}
		})
 */