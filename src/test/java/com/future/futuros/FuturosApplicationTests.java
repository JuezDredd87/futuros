package com.future.futuros;

import com.future.futuros.Service.MathService;
import com.mifmif.common.regex.Generex;
import org.apache.catalina.Executor;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.beans.IntrospectionException;
import java.io.InterruptedIOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FuturosApplicationTests {
	private final static Logger log = LoggerFactory.getLogger(FuturosApplicationTests.class);

	private static ExecutorService executor;

	@BeforeClass
	public static void setUp(){
		executor = Executors.newFixedThreadPool(4);
	}

	@AfterClass
	public static void shutDown(){
		executor.shutdown();
	}

	@Test
	public void testFuture() throws InterruptedException, ExecutionException {
		MathService mathService = new MathService(executor);
		Future<String> futureSumar;
		Future<String> futureRestar;
		Future<String> futureMultiplicar;
		Future<String> futureDividir;

		log.info("Lanzamos el futuro para la operacion sumar");
		futureSumar = mathService.sumar(2, 3);
		log.info("Futuro lanzando");
		assertEquals("5.0", futureSumar.get());

		log.info("Lanzamos el futuro para la operacion restar");
		futureRestar = mathService.restar(2, 3);
		log.info("Futuro lanzando");
		assertEquals("-1.0", futureRestar.get());

		log.info("Lanzamos el futuro para la operacion multiplicar");
		futureMultiplicar = mathService.multiplicar(2, 3);
		log.info("Futuro lanzando");
		assertEquals("6.0", futureMultiplicar.get());

		log.info("Lanzamos el futuro para la operacion dividir");
		futureDividir = mathService.dividir(2, 3);
		log.info("Futuro lanzando");
		assertEquals("0.6666667", futureDividir.get());

	}
}
