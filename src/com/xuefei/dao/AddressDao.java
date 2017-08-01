package com.xuefei.dao;

import com.xuefei.entity.Address;
import com.xuefei.entity.User;
import com.xuefei.utils.HibernateUtils;

public class AddressDao {
	public Address getById(int id) {
		return (Address) HibernateUtils.getSession().get(Address.class, id);
	}
	public void save(){
		User u=new User();
		u.setName("张三");
		u.setAge(20);
		Address a1=new Address();
		a1.setMessage("北京");
		a1.setUser(u);
		Address a2=new Address();
		a2.setMessage("上海");
		a2.setUser(u);
		HibernateUtils.getSession().save(u);
		HibernateUtils.getSession().save(a1);
		HibernateUtils.getSession().save(a2);
	}
}
