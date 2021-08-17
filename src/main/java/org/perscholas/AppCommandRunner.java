package org.perscholas;

import org.perscholas.dao.IStudentRepo;
import org.perscholas.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class AppCommandRunner implements CommandLineRunner {

    IStudentRepo studentRepo;
    @Autowired
    public AppCommandRunner(IStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    @Override
    public void run(String... args) throws Exception {
        studentRepo.save(new Student("Jafer", "habboubi@gmail.com"));
        studentRepo.save(new Student("Tamara", "tamara@gmail.com"));
        studentRepo.save(new Student("Tim", "Tim@gmail.com"));
        studentRepo.save(new Student("Ashwini", "Ashwini@gmail.com"));
        studentRepo.save(new Student("Trevor", "Trevor@gmail.com"));
        studentRepo.save(new Student("test", "test@gmail.com"));
        studentRepo.save(new Student("cooper", "cooper@gmail.com"));



    }
}
