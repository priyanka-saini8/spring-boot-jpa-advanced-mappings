package com.example.demoCRUD.dao;

import com.example.demoCRUD.entity.Instructor;

public interface AppDao {

    void save(Instructor instructor);

    Instructor findInstructorById(int theId);

    void deleteById(int theId);
}
