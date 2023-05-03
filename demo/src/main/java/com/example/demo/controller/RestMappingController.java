package com.example.demo.controller;

import com.example.demo.model.Car;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/test")
public class RestMappingController {

    @GetMapping("/helloWorld")
    public ResponseEntity<String> helloDefaultValue(){
        return ResponseEntity.ok("Hello World");
    }
    @GetMapping("/model")
    public ResponseEntity<Car> returnNewCar(){
        return ResponseEntity.ok(new Car("Toyota"));
    }
    @GetMapping("/hello/{someVariable}")
    public ResponseEntity<String> returnSomeValuePathVariable(@PathVariable ("someVariable") String value){
        return ResponseEntity.ok(value);
    }

    @GetMapping("/hello")
    public ResponseEntity<String> returnSomeValueRequestParam(@RequestParam ("reqParam") String value){
        return ResponseEntity.ok(value);
    }

    @PostMapping("/model")
    public ResponseEntity<Car> returnNewCustomCat(@RequestBody Car car){
        return ResponseEntity.ok(car);
    }

    @GetMapping("/exception")
    public ResponseEntity<String> exeption(){
        throw new RuntimeException("Tresc mojego bledu");
    }
}














