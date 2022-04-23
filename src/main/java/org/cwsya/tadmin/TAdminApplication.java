package org.cwsya.tadmin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.cwsya.tadmin.mapper")
public class TAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(TAdminApplication.class, args);
    }

}
