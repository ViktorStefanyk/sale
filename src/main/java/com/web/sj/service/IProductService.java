package com.web.sj.service;

import java.util.List;

import com.web.sj.domain.Category;
import com.web.sj.domain.ChainsSize;
import com.web.sj.domain.Gemstone;
import com.web.sj.domain.Gender;
import com.web.sj.domain.Material;
import com.web.sj.domain.PendantSize;
import com.web.sj.domain.Product;
import com.web.sj.domain.RingSize;
import com.web.sj.domain.Type;

public interface IProductService {
	
	public List<Product> getAllProducts();
	
	public List<Gemstone> getGemstones();
	
	public List<Gemstone> availableGemstoneByParameter(String productCategory);
	
	public List<Category> getCategories();
	
	public List<Material> getMaterial();
	
	public List<Material> availableMaterialByParameter(String productCategory);
	
	public List<Type> getTypes();
	
	public List<Type> availableTypeByParameter(String productCategory);
	
	public List<RingSize> getAllRingSizes();
	
	public List<ChainsSize> getAllChainsSizes();
	
	public void addProduct(Product product);
	
	public void addMainImage(Integer productId, String imageName, String imageRole);
	
	public List<Product> getProductsByParameter(String productCategory, List<Integer> productGemstones, 
			List<Integer> productType, List<Integer> productMaterial,
			Integer productMinPrice, Integer productMaxPrice,
			List<Integer> sizeRing, List<Integer> sizeChains,
			List<Integer> sizePendant, Integer productGender);	
	
	public List<RingSize> availableRingSizeByParameters(String productCategory);
	
	public List<ChainsSize> availableChainsSizeByParameters(String productCategory);
	
	public List<PendantSize> getAllPendantSizes();
	
	public List<PendantSize> availablePendantByParameter(String productCategory);
	
	public List<Gender> getGenders();
	
	public List<Gender> availableGenderByParameter(String productCategory);
	
	
}
