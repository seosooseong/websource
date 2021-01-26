package domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class BoardVO {

	private int bno; //번호
	private String name; //작성자
	private String password; //비번
	private String title; //제목
	private String content; //내용
	private String attach; //첨부파일
	private int re_ref; // 답글 작성시 참조 번호
	private int re_lev; // 답글 레벨
	private int re_seq; // 답글 순서
	private int readcount; // 조회수
	private Date regdate; // 작성 날짜


}
