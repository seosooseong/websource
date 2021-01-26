package domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BookVO {

//	code number(4) PRIMARY KEY,
//	title nvarchar2(50) not null,
//	writer nvarchar2(20) not null,
//	price number(8) not null
	private int code;
	private String title;
	private String writer;
	private int price;

}
