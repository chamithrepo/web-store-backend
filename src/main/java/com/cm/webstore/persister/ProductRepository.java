package com.cm.webstore.persister;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cm.webstore.domain.Product;

/**
 * @author Chamith_Madusanka
 *
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID>{
	

}

