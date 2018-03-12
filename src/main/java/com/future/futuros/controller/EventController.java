package com.future.futuros.controller;

import com.future.futuros.Service.MathService;
import com.mifmif.common.regex.Generex;
import org.dozer.inject.Inject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.MarshalException;
import java.util.concurrent.*;

@RestController
@RequestMapping("/events")
public class EventController {

    private static ExecutorService executor = Executors.newFixedThreadPool(4);
    private MathService mathService = new MathService(executor);

    @Inject
    Future<String> future;


    Generex generex;


    @RequestMapping("/sumar")
    public String Saludo(@RequestParam(value = "a", defaultValue = "1") String a, @RequestParam(value = "b", defaultValue = "2") String b){
        String resultado = null;
        try {
            future = mathService.sumar(Float.valueOf(a), Float.valueOf(b));
            resultado = future.get();
        }
        catch (InterruptedException | ExecutionException e){};

        return resultado;
    }

    @RequestMapping(value = "/regex", method = RequestMethod.POST)
    public String generarCodigo(@RequestParam(value = "pattern") String pattern){
        generex = new Generex(pattern);
        return generex.random();
    }
}
