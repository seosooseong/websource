package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.ProductVO;
import service.ProdService;
import service.ProdServiceImpl;

public class ProdAddAction implements Action {
	
	private String path;
	
	public ProdAddAction(String path) {
		super();
		this.path = path;
	}
	
	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ProductVO vo = new ProductVO();
		
		vo.setCategory(request.getParameter("category"));
		vo.setName(request.getParameter("name"));
		vo.setContent(request.getParameter("content"));
		vo.setPsize(request.getParameter("psize"));
		vo.setColor(request.getParameter("color"));
		vo.setAmount(Integer.parseInt(request.getParameter("amount")));
		vo.setPrice(Integer.parseInt(request.getParameter("price")));
		
		
		ProdService service = new ProdServiceImpl();
		boolean result = service.insertProd(vo);
		if(!result) {
			path="product_write.jsp";
		}
		return new ActionForward(path, true);
	}

}
