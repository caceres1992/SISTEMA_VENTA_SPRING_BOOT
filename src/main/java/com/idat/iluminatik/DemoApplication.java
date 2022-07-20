package com.idat.iluminatik;

import com.idat.iluminatik.data.RunnerData;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @Bean
    public RunnerData getRunner(){
        return new RunnerData();
    }
}
