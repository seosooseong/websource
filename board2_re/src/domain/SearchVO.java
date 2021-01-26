package domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SearchVO {
	private String criteria; //검색조건
	private String keyword; //검색어
}
