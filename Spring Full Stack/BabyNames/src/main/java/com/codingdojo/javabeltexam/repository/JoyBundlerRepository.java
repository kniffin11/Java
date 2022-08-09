package com.codingdojo.javabeltexam.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.javabeltexam.models.JoyBundler;

public interface JoyBundlerRepository extends CrudRepository<JoyBundler, Long>{
	List<JoyBundler> findAll();
}
