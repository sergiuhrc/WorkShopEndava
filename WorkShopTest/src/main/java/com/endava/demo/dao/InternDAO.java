package com.endava.demo.dao;

import com.endava.demo.entity.Intern;

import java.util.List;

public interface InternDAO {
    List<Intern> findAll();

    void save(Intern intern);

    void update(Intern intern);

    void delete(int id);

    Intern getObjectForUpdate(int id);
}
