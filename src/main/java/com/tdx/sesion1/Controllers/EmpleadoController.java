package com.tdx.sesion1.Controllers;

import com.tdx.sesion1.Models.EmpleadoModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    @Value("${welcome.message:Hello, World!}")
    private String welcomeMessage;

    @Value("${server.port:8080}")
    private int serverPort;

    private final List<EmpleadoModel> empleados = new ArrayList<>();

    @PostMapping("/insertar")
    public String insertarEmpleado (@RequestBody EmpleadoModel empleado){
        empleados.add(empleado);
        return "Empleado agregado correctamente";
    }

    @GetMapping("/listar")
    public List<EmpleadoModel> listaEmpleado(){
        return  empleados;
    }

    @GetMapping("/hello")
    public String sayHello() {
        return welcomeMessage + " (Running on port: " + serverPort + ")";
    }
}
