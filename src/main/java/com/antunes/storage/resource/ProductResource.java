package com.antunes.storage.resource;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.antunes.storage.domain.Product;
import com.antunes.storage.dto.ProductDTO;
import com.antunes.storage.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;
	
	Logger logger = LogManager.getLogger(ProductResource.class);
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		
		try {
			Product obj = productService.find(id);
			return ResponseEntity.ok().body(obj);
		}
		catch (ObjectNotFoundException e) {
			logger.error("Metodo find(Integer id) - Dados nao encontrados", e.getMessage());
			return ResponseEntity.notFound().build();
		}
		catch (Exception e) {
			logger.error("Metodo find(Integer id) - Erro ao buscar dados", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ProductDTO objDto){
		
		Product obj = productService.fromDTO(objDto);
		try {
			productService.save(obj);
			return ResponseEntity.noContent().build();
		} 
		catch (Exception e) {
			logger.error("Metodo insert(ProductDTO objDto) - Erro ao inserir dados", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ProductDTO objDto, @PathVariable Integer id) {
		Product obj = productService.fromDTO(objDto);
		obj.setId(id);
		
		try {
			productService.update(obj);
			return ResponseEntity.noContent().build();
		} 
		catch (ObjectNotFoundException e) {
			logger.error("Metodo update(ProductDTO, Integer id) - Dados nao encontrados", e.getMessage());
			return ResponseEntity.notFound().build();
		}
		catch (Exception e) {
			logger.error("Metodo update(ProductDTO, Integer id) - Erro ao buscar dados", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		
		try {
			productService.delete(id);
			return ResponseEntity.noContent().build();
		} 
		catch (ObjectNotFoundException e) {
			logger.error("Metodo delete(Integer id) - Dados nao encontrados", e.getMessage());
			return ResponseEntity.notFound().build();
		}
		catch (Exception e) {
			logger.error("Metodo delete(Integer id) - Erro ao buscar dados", e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ProductDTO>> findAll() {
		List<Product> list = productService.getList();
		List<ProductDTO> listDto = list.stream().map(obj -> new ProductDTO(obj)).collect(Collectors.toList());  
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ProductDTO>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="nome") String orderBy, 
			@RequestParam(value="direction", defaultValue="ASC") String direction) {
		Page<Product> list = productService.findPage(page, linesPerPage, orderBy, direction);
		Page<ProductDTO> listDto = list.map(obj -> new ProductDTO(obj));  
		return ResponseEntity.ok().body(listDto);
	}	
}
