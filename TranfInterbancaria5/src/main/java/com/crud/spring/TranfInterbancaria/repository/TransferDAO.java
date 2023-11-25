package com.crud.spring.TranfInterbancaria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.spring.TranfInterbancaria.entity.Transfer;

@Repository
public interface TransferDAO extends JpaRepository<Transfer, Long>{
	
}
