package com.antunes.storage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

//	@Autowired
//	private ProductRepository productRepo;
//	@Autowired
//	private CategoryRepository categoryRepo;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

//	@Override
//	public void run(String... args) throws Exception {
//		Category cat1 = new Category(null,"Smart TV"); 
//		Category cat2 = new Category(null,"Eletrodomesticos");
//		Product prod1 = new Product(null,"Smart TV Samsung 40 polegadas", 2500, "Smart TV", 100, cat1);
//		Product prod2 = new Product(null,"Cafeteira", 100, "Cafeteira", 200, cat2);
//				 
//		categoryRepo.saveAll(Arrays.asList(cat1, cat2));
//		productRepo.saveAll(Arrays.asList(prod1, prod2));
//		
//	}
}
