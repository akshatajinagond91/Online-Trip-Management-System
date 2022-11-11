package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exceptions.PackageException;

import com.masai.model.Packages;

import com.masai.repository.PackageDao;

@Service
public class PackageServiceImpl implements PackageService {

	@Autowired
	public PackageDao packagedao;

	@Override
	public Packages addPackage(Packages packages) throws PackageException {

		Optional<Packages> optional = packagedao.findById(packages.getPackageId());

		if (optional.isPresent()) {
			throw new PackageException("Package Already Exist with PackageId : " + packages.getPackageId());
		} else {
			packagedao.save(packages);
			return packages;
		}

	}

	@Override
	public Packages deletePackage(int packageId) throws PackageException {

		Optional<Packages> optional = packagedao.findById(packageId);

		if (optional.isPresent()) {
			Packages packages = optional.get();
			packagedao.delete(packages);
			return packages;
		} else {
			throw new PackageException("Package Doesn't Exist with PackageId : " + packageId);
		}
	}

	@Override
	public Packages searchPackage(int packageId) throws PackageException {
		Optional<Packages> optional = packagedao.findById(packageId);
		if (optional.isPresent()) {
			Packages packages = optional.get();
			return packages;
		} else {
			throw new PackageException("Package does not exists with packageId" + packageId);
		}
	}

	@Override
	public List<Packages> viewAllPackage() throws PackageException {

		// TODO Auto-generated method stub
		List<Packages> packages = packagedao.findAll();
		if (packages.isEmpty())
			throw new PackageException("No Package is present in database");
		return packages;
	}

}
