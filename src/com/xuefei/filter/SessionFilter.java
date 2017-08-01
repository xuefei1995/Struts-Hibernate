package com.xuefei.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.xuefei.utils.HibernateUtils;

public class SessionFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		Transaction tx =null;
		try {
			Session session=HibernateUtils.getSession();
			tx = session.beginTransaction();
			arg2.doFilter(arg0, arg1);
		} catch (HibernateException e) {
			tx.rollback();//如果发生异常则回滚
			e.printStackTrace();
		} finally {
			tx.commit();//线程方式创建的session提交后自动关闭
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}

}
