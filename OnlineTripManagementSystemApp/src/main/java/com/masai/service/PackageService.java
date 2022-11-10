package com.masai.service;

import com.masai.exceptions.PackageException;

public interface PackageService {

	public Package addPackage(Package pckage) throws PackageException;
	
	public Package deletePackage(Package package1) throws PackageException;
	
}
