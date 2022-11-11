package com.masai.service;

import java.util.List;

import com.masai.exceptions.PackageException;
import com.masai.model.Packages;

public interface PackageService {

	public Packages addPackage(Packages packages) throws PackageException;
	
	public Packages deletePackage(int packageId) throws PackageException;
	
	public Packages searchPackage(int packageId) throws PackageException;
	
	public List<Packages>  viewAllPackage() throws PackageException;
}
