package org.perscholas.dao;

import org.perscholas.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path="student")
public interface IStudentRepo extends JpaRepository<Student,Long> {
    @RestResource(path = "emails", rel = "emails" ,exported = true)
    Student findByEmail(@Param("email") String email);

}
