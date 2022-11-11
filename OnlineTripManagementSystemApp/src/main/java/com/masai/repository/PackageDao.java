package com.masai.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.masai.model.Packages;

@Repository
public interface PackageDao extends JpaRepository<Packages, Integer> {

}
