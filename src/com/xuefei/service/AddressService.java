package com.xuefei.service;

import com.xuefei.dao.AddressDao;
import com.xuefei.entity.Address;

public class AddressService {
	private AddressDao dao=new AddressDao();
	public Address getById(int id) {
		return dao.getById(id);
	}
	public void save(){
		dao.save();
	}
	
}
