package com.JuhAmil.Lista.de.Vendas.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.JuhAmil.Lista.de.Vendas.entidades.Venda;

public interface VendaRepository extends JpaRepository<Venda, Long>{
	
	@Query("SELECT obj FROM Venda obj WHERE obj.data BETWEEN :min AND :max ORDER BY obj.total DESC")
	Page<Venda> findVendas(LocalDate min, LocalDate max, Pageable pageable);

}
