package com.devops.springmvc.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

public class HTemplate {

	@Autowired(required=false)
	private HibernateTemplate hTemp;
	
	public HibernateTemplate getHTemplate() {
		
		return hTemp;
	}
	
}
