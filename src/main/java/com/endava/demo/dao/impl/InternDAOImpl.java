package com.endava.demo.dao.impl;

import com.endava.demo.dao.InternDAO;
import com.endava.demo.entity.Intern;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.endava.demo.entity.InternStreams.JAVA;

@Repository
public class InternDAOImpl implements InternDAO {

    private static List<Intern> internList = new ArrayList<>();

    static {
        internList.add(new Intern(0, "Joric", 21, JAVA));
        internList.add(new Intern(101, "Mihaela", 21, JAVA));
        internList.add(new Intern(2, "Eugen", 18, JAVA));
        internList.add(new Intern(3, "Xenia", 19, JAVA));
//        internList.add(new Intern(4, "Denisa", 21, ANALYST));
    }

    @Override
    public List<Intern> findAll() {
        return internList;
    }

    @Override
    public void save(Intern intern) {

        if (internList.size() <= 0) {

            intern.setId(0);
        } else {

            intern.setId(getMaxId() + 1);
        }
        internList.add(intern);

    }

    @Override
    public void saveAfterUpdate(Intern intern) {

        if (internList.size() <= 0) {

//            intern.setId(0);
        } else {

            intern.setId(intern.getId());
        }
        int index = 0;
        for (Intern i : internList) {
            System.out.println(i.getId());

            if (intern.getId() == i.getId()) {
                System.out.println(index);
                internList.set(index, intern);
            }
            index++;
        }
        System.out.println("-------------------------------------------");
        System.out.println(internList);


    }

    public static void main(String[] args) {

    }

    @Override
    public int getMaxId() {
        return internList.stream().mapToInt(Intern::getId).max().getAsInt();
    }

    @Override
    public void delete(int id) {
        for (Intern i : new ArrayList<>(internList)) {
            if (i.getId() == id)
                internList.remove(i);
        }

    }

    @Override
    public Intern update(int id) {
        Intern intern = new Intern();
        for (Intern i : new ArrayList<>(internList)) {
            if (i.getId() == id) {

//                internList.get(id);
                intern.setId(i.getId());
                intern.setName(i.getName());
                intern.setAge(i.getAge());
                intern.setStream(i.getStream());

//            System.out.println( internList.get(id));

                return intern;
            }
        }
        System.out.println(intern);
        return null;

    }
}

//    public static void main(String[] args) {
//        System.out.println("Max: "+getMaxId());
//    }

