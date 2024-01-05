package br.com.samuel.helloworld.infrastructure;

import jakarta.persistence.Persistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);


    public static void main(String[] args) {
        LOG.info("[step:to-be-init] [id:1] Inicializando o Spring");

        SpringApplication.run(Main.class, args);

        LOG.info("[step:inittialized] [id:2] Spring inicializado..");

        String version = Persistence.class.getPackage().getImplementationVersion();
        System.out.println("JPA Version: " + version);
    }
}
