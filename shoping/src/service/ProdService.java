package service;

import java.util.List;

import domain.ProductVO;

public interface ProdService {

	public boolean insertProd(ProductVO vo);
	public List<ProductVO> getList();
}
