package com.endava.demo.service;

import com.endava.demo.entity.Intern;

import java.util.List;

public interface InternService {
    public List<Intern> getAllInterns();

    public void add(Intern intern);
    int getMaxId();
    void delete(int id);
    Intern update(int id);
    void addAfterUpdate(Intern intern);
}
