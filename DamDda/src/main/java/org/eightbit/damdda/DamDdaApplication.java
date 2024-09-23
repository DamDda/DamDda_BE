package org.eightbit.damdda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import javax.persistence.EntityListeners;

@EnableJpaAuditing
@SpringBootApplication
public class DamDdaApplication {

    public static void main(String[] args) {
        SpringApplication.run(DamDdaApplication.class, args);
    }

}
