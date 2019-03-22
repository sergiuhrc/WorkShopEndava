package com.endava.demo.dao;

import com.endava.demo.entity.Intern;

import java.util.List;

public interface InternDAO {
     List<Intern> findAll();
    void save(Intern intern);
    void saveAfterUpdate(Intern intern);
    int getMaxId();
    void delete(int id);
    Intern update(int id);
}
