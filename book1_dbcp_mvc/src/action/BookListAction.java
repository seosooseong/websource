package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.BookVO;
import service.BookService;
import service.BookServiceImpl;

public class BookListAction implements Action {
	
	private String path;
	
	public BookListAction(String path) {
		super();
		this.path = path;
	}

	@Override
	public ActionFowrd execute(HttpServletRequest request, HttpServletResponse response) throws Exception {

		BookService service = new BookServiceImpl();
		List<BookVO> list = service.getList();
		
		//받은걸 담고
		request.setAttribute("list", list);
		
		return new ActionFowrd(path, false);
	}

}
