package emt.lab.labexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@ServletComponentScan
public class LabExerciseApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabExerciseApplication.class, args);
    }

}
