package com.metatron.workshopjavafxjdbc.model.dao;

import com.metatron.workshopjavafxjdbc.model.dao.impl.DepartmentDaoJDBC;
import com.metatron.workshopjavafxjdbc.model.dao.impl.SellerDaoJDBC;
import com.metatron.workshopjavafxjdbc.db.DB;
import com.metatron.workshopjavafxjdbc.db.DbIntegrityException;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}
	
	public static DepartmentDao createDepartmentDao() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}
}
