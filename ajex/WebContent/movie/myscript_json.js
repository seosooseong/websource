/**
 * 
 */

$(function() {
	init();
	
	$("#btn1").click(function() {
		let url = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=";
		
		url += $("#txtYear").val()+$("#selMon").val()+$("#selDay").val();
		
		
		let str ="";
		$.get({
			url: url,
			success: function(data) {
				console.log(data);
		   //console 창 보고 배열을 끌고 오자                            item 변수사용
				$(data.boxOfficeResult.dailyBoxOfficeList).each(function(idx,item){
					//순위
					str +=  item.rank +" 위";					
					//증감
					var rankInten = parseInt(item.rankInten);
					
					if(rankInten > 0){
						str = str + "(▲";
					}else if(rankInten < 0){
						str = str + "(▼";
					}else{
						str = str + "( ";
					}
					str += rankInten +" )";
					
					
					//영화코드
					var movieCd= item.movieCd;
					
					//영화명
					var movieNm = item.movieNm+"<br>";
					str += "<a href='#' onclick='javascript:info("+movieCd+")'>"+movieNm+"</a>";
					
					$("#msg").html(str);
				})

			}
		})
	})
})
				//movieCd 받아서 주소+cd
function info(movieCd){ 
	//영화 상세정보 요청
	let url ="http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key=f5eef3421c602c6cb7ea224104795888&movieCd="+movieCd;
	
	$.get({
		url: url,
		success:function(data){
			console.log(data);
				
				// 변수사용
				let movieInfo= data.movieInfoResult.movieInfo;
				
				let str ="<ul>";

				//한글제목
				var movieNm= movieInfo.movieNm;	
				//영어제목
				var movieNmEn= movieInfo.movieNmEn;
				//상영시간
				var showTm=movieInfo.showTm;
				//감독
				var peopleNm= movieInfo.director[0].peopleNm;
				//출연배우
				var actors ="";
//				$(data).find("actor").each(function(){
//					actors += $(this).find("peopleNm").text();
//				})

				//배우 , 넣기
				var length = movieInfo.actors.length;
				
				$(movieInfo.actors).each(function(idx,item){
				if(idx == length -1){
					actors += item.peopleNm;
				}else{
					actors += item.peopleNm+",";
				}
				
			})
				str += "<li>영화제목 : "+movieNm +"</li>";
				str += "<li>영어제목 : "+movieNmEn +"</li>";
				str += "<li>상영시간 : "+showTm +"</li>";
				str += "<li>감독 : "+peopleNm +"</li>";
				str += "<li>출연배우 : "+actors +"</li></ul>";
				
				$(".box3").html(str);
		}
	})
}
				

function init() {
	//어제 날짜 세팅
	var newDate = new Date();
	var year = newDate.getFullYear();   //년도 추출
	var month = newDate.getMonth() + 1; //월은 0부터 시작
	var day = newDate.getDate() - 1;    //어제 날짜가 필요함. -1

	$("#txtYear").val(year);

	if (month < 10) {
		month = "0" + month;
	}
	if (day < 10) {
		day = "0" + day;
	}
	$("#selMon").val(month);
	$("#selDay").val(day);
}