package com.xuefei.action;

import com.xuefei.entity.Address;
import com.xuefei.service.AddressService;
import com.xuefei.utils.BaseAction;

public class AddressAction extends BaseAction {
	private static final long serialVersionUID = 1L;
	private int id;
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddress() {
		AddressService service=new AddressService();
		Address address = service.getById(id);
		requestMap.put("address", address);
		return SUCCESS;
	}
	
	public String save(){
		AddressService service=new AddressService();
		service.save();
		return "save";
	}
}
