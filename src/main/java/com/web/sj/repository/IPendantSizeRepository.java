package com.web.sj.repository;

import java.util.List;

import com.web.sj.domain.PendantSize;

public interface IPendantSizeRepository {
	
	public List<PendantSize> getAllPendantSizes();
	
	public void addPendantSizes(Integer productId, Integer pendantSizeId);
	
	public List<PendantSize> availablePendantByParameter(String productCategory);
	

}
