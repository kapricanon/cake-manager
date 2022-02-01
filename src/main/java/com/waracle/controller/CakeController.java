package com.waracle.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.waracle.model.Cake;
import com.waracle.model.CakeDTO;
import com.waracle.service.CakeService;

@RestController
public class CakeController {
	
	//We inject the service class which is called by controller to interface with
	//the data store layer
	@Autowired
	private CakeService cakeService;
	
	@GetMapping("/api/hello")
	public List<Cake> getCakes1() {
        return cakeService.getAllCakes();
    }

    @GetMapping("/cakes")
    public List<Cake> getCakes() {
        return cakeService.getAllCakes();
    }
    
    @GetMapping("/cakes/{id}")
    public Cake getCakesById(@PathVariable Integer id) {
        return cakeService.getCakeById(id);
    }
    
    @PutMapping("/cakes/{id}")
    public Cake updateCakesById(@RequestBody CakeDTO cakeDTO) {
        return cakeService.updateCakeById(cakeDTO);
    }
    
    @DeleteMapping("/cakes/{id}")
    public void deleteCakesById(@PathVariable Integer id) {
        cakeService.deleteCakeById(id);
    }
    
    @PostMapping("/cakes")
    public ResponseEntity<Cake> createCake(@RequestBody CakeDTO cakeDTO) throws URISyntaxException  {
        Cake savedCake = cakeService.save(cakeDTO);
        return ResponseEntity.created(new URI("/cakes/" + savedCake.getId())).body(savedCake);
    }

}
