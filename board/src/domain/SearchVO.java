package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchVO {
	private String criteria; //검색조건
	private String keyword; //검색어
	
	
	
	//페이지 나누기와 관련된 변수
	
	private int page; //해당페이지번호
	private int amount; //페이지당 게시물수
}
