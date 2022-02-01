package com.waracle.service;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.waracle.model.Cake;
import com.waracle.model.CakeDTO;
import com.waracle.repository.CakeRepository;

@Service
public class CakeService {
	
	org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CakeService.class);
	@Autowired
	private CakeRepository cakeRepository;
	
	
	public List<Cake> getAllCakes() {
		return cakeRepository.findAll();
	}

	
	//Method to GET ALL Cakes
	public Cake getCakeById(Integer id) {
		try {
			return cakeRepository.getById(id);
		} catch (Exception e) {
			logger.error("Unable to find cake with id : {}", id);
			return null;
		}
	}

	//Method to SAVE A Cake
	public Cake save(CakeDTO cakeDTO) {
		try {
			Cake cake = new Cake(cakeDTO.getName(), cakeDTO.getDescription(), cakeDTO.getImageURL());
			return cakeRepository.save(cake);
			
		} catch (IllegalArgumentException e) {
			logger.error("Unable to a null cake object");
			return null;
		}
	}

	//Method to UPDATE A Cake
	public Cake updateCakeById(CakeDTO cakeDTO) {
		try {
			Cake cake = new Cake(cakeDTO.getName(), cakeDTO.getDescription(), cakeDTO.getImageURL());
			return cakeRepository.save(cake);
			
		} catch (IllegalArgumentException e) {
			logger.error("Unable to a null cake object");
			return null;
		}
	}

	//Method to DELETE A Cake
	public void deleteCakeById(Integer id) {
		try {
			cakeRepository.deleteById(id);
		} catch (Exception e) {
			logger.error("Unable to delete Cake as the id passed is null");
		}
	}
	
	
}
