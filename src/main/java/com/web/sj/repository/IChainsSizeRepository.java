package com.web.sj.repository;

import java.util.List;

import com.web.sj.domain.ChainsSize;

public interface IChainsSizeRepository {
	
	public List<ChainsSize> getAllChainsSizes();
	
	public void addChainsSizes(Integer productId, Integer chainsSizeId);
	
	public List<ChainsSize> availableChainsSizeByParameters(String productCategory);

}
