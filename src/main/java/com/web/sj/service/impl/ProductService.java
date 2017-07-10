package com.web.sj.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.sj.domain.Category;
import com.web.sj.domain.ChainsSize;
import com.web.sj.domain.Gemstone;
import com.web.sj.domain.Gender;
import com.web.sj.domain.Material;
import com.web.sj.domain.PendantSize;
import com.web.sj.domain.Product;
import com.web.sj.domain.RingSize;
import com.web.sj.domain.Type;
import com.web.sj.repository.IAddProductRepository;
import com.web.sj.repository.ICategoryRepository;
import com.web.sj.repository.IChainsSizeRepository;
import com.web.sj.repository.IFilterProductRepository;
import com.web.sj.repository.IGemstoneRepository;
import com.web.sj.repository.IGenderRepository;
import com.web.sj.repository.IImageRepository;
import com.web.sj.repository.IMaterialRepository;
import com.web.sj.repository.IPendantSizeRepository;
import com.web.sj.repository.IProductRepository;
import com.web.sj.repository.IRingSizeRepository;
import com.web.sj.repository.ITypeRepository;
import com.web.sj.service.IProductService;

@Service
public class ProductService implements IProductService {
	
	@Autowired public IProductRepository productRepository;
	@Autowired public IGemstoneRepository gemstoneRepository;
	@Autowired public ICategoryRepository categoryRepository;
	@Autowired public IMaterialRepository materialRepository;
	@Autowired public ITypeRepository typeRepository;
	@Autowired public IRingSizeRepository ringRepository;
	@Autowired public IChainsSizeRepository chainsRepository;
	@Autowired public IAddProductRepository addProductRepository;
	@Autowired public IImageRepository imageRepository;
	@Autowired public IFilterProductRepository filterProductRepository;
	@Autowired public IPendantSizeRepository pendantRepository;
	@Autowired public IGenderRepository genderRepository;

	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public List<Gemstone> getGemstones() {
		return gemstoneRepository.getGemstones();
	}

	public List<Category> getCategories() {
		return categoryRepository.getCategories();
	}

	public List<Material> getMaterial() {
		return materialRepository.getMaterial();
	}

	public List<Type> getTypes() {
		return typeRepository.getTypes();
	}

	public List<RingSize> getAllRingSizes() {
		return ringRepository.getAllRingSizes();
	}

	public List<ChainsSize> getAllChainsSizes() {
		return chainsRepository.getAllChainsSizes();
	}

	public void addProduct(Product product) {
		addProductRepository.addProduct(product);
		for (RingSize ringSize : product.getProductRingSizes()) {
			if (ringSize != null && ringSize.isRingSizeFlag()) {
				ringRepository.addRingSizes(product.getProductId(), ringSize.getRingSizeId());
			}
		}
		
		for (ChainsSize chainsSize : product.getProductChainsSizes()) {
			if (chainsSize != null && chainsSize.isChainsSizeFlag()) {
				chainsRepository.addChainsSizes(product.getProductId(), chainsSize.getChainsSizeId());
			}
		}
		for (PendantSize pendantSize : product.getProductPendantSizes()) {
			if (pendantSize != null && pendantSize.isPendantSizeFlag()) {
				pendantRepository.addPendantSizes(product.getProductId(), pendantSize.getPendantSizeId());
			}
		}
		
	}

	public void addMainImage(Integer productId, String imageName, String imageRole) {
		imageRepository.addMainImage(productId, imageName, imageRole);
	}

	public List<Product> getProductsByParameter(String productCategory, List<Integer> productGemstones, 
			List<Integer> productType, List<Integer> productMaterial,
			Integer productMinPrice, Integer productMaxPrice,
			List<Integer> sizeRing, List<Integer> sizeChains,
			List<Integer> sizePendant, Integer productGender) {
		return filterProductRepository.getProductsByParameter(productCategory, productGemstones, productType, productMaterial, productMinPrice, productMaxPrice, sizeRing, sizeChains, sizePendant, productGender);
	}

	public List<RingSize> availableRingSizeByParameters(String productCategory) {
		return ringRepository.availableRingSizeByParameters(productCategory);
	}

	public List<ChainsSize> availableChainsSizeByParameters(String productCategory) {
		return chainsRepository.availableChainsSizeByParameters(productCategory);
	}

	public List<Gemstone> availableGemstoneByParameter(String productCategory) {
		return gemstoneRepository.availableGemstoneByParameter(productCategory);
	}

	public List<Material> availableMaterialByParameter(String productCategory) {
		return materialRepository.availableMaterialByParameter(productCategory);
	}

	public List<Type> availableTypeByParameter(String productCategory) {
		return typeRepository.availableTypeByParameter(productCategory);
	}

	public List<PendantSize> getAllPendantSizes() {
		return pendantRepository.getAllPendantSizes();
	}

	public List<PendantSize> availablePendantByParameter(String productCategory) {
		return pendantRepository.availablePendantByParameter(productCategory);
	}

	public List<Gender> getGenders() {
		return genderRepository.getGenders();
	}

	public List<Gender> availableGenderByParameter(String productCategory) {
		return genderRepository.availableGenderByParameter(productCategory);
	}

}
