package com.future.futuros.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class MathService {

    private final ExecutorService executor;
    private final static Logger log = LoggerFactory.getLogger(MathService.class);

    public MathService(ExecutorService executor){
        this.executor = executor;
    }

    public Future<String> sumar(float a, float b) throws InterruptedException{
        return executor.submit(()->{
            TimeUnit.SECONDS.sleep(3);
            log.info("Comenzando con proceso sumar");
            return String.valueOf(a + b);
        } );
    }

    public Future<String> restar (float a, float b) throws InterruptedException{
        return executor.submit(()->{
            TimeUnit.SECONDS.sleep(3);
            log.info("Comenzando con proceso restar");
            return String.valueOf(a - b);
        });
    }

    public Future<String> multiplicar (float a, float b) throws InterruptedException{
        return executor.submit(()->{
            TimeUnit.SECONDS.sleep(3);
            log.info("Comenzando con proceso multiplicar");
            return String.valueOf(a * b);
        });
    }

    public Future<String> dividir (float a, float b) throws InterruptedException{
        return executor.submit(()->{
            TimeUnit.SECONDS.sleep(3);
            log.info("Comenzando con proceso dividir");
            return String.valueOf(a / b);
        });
    }
}
