package com.endava.demo.service;

import com.endava.demo.entity.Intern;

import java.util.List;

public interface InternService {
    List<Intern> getAllInterns();

    void add(Intern intern);

    void delete(int id);

    Intern update(int id);

    void update(Intern intern);
}
