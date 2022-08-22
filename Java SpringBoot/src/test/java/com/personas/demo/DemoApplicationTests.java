package com.personas.demo;

import com.personas.demo.controller.Controlador;
import com.personas.demo.models.Persona;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private Controlador controlador;

	@Test
	void contextLoads() {
		List<Persona> prueba= controlador.listarEmpleados();
		System.out.println( prueba);
	}

}
