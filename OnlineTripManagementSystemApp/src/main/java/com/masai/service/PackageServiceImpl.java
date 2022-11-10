package com.masai.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.PackageException;
import com.masai.repository.PackageDao;

@Service
public class PackageServiceImpl implements PackageService{

	@Autowired
	PackageDao packageDao;
	
	@Override
	public Package addPackage(Package pckage) throws PackageException {
		// TODO Auto-generated method stub
		return null;
		
	}

	@Override
	public Package deletePackage(Package pckage) throws PackageException {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
