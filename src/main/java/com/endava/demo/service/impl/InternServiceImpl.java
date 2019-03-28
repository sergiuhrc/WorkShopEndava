package com.endava.demo.service.impl;

import com.endava.demo.dao.InternDAO;
import com.endava.demo.entity.Intern;
import com.endava.demo.service.InternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class InternServiceImpl implements InternService {

    @Autowired
    private InternDAO internDAO;


    @Override
    public List<Intern> getAllInterns() {
        return internDAO.findAll();
    }

    @Override
    public void add(@Autowired Intern intern) {

        internDAO.save(intern);
    }

    @Override
    public void update(@Autowired Intern intern) {

        internDAO.update(intern);
    }

    @Override
    public void delete(int id) {
        internDAO.delete(id);

    }

    @Override
    public Intern update(int id) {
        return internDAO.getObjectForUpdate(id);
    }

}
