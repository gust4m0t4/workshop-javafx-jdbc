package com.metatron.workshopjavafxjdbc.model.services;

import com.metatron.workshopjavafxjdbc.model.dao.DaoFactory;
import com.metatron.workshopjavafxjdbc.model.dao.DepartmentDao;
import com.metatron.workshopjavafxjdbc.model.entities.Department;

import java.util.List;

public class DepartmentService {

    private DepartmentDao dao = DaoFactory.createDepartmentDao();

    public List<Department> findAll() {
        return  dao.findAll();

    }
}
