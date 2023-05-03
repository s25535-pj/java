//package com.example.demo;
//
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//@RestController
//@RequestMapping("/homework")
//public class PracaDomowaController {
//
//    @GetMapping("/hello/{carName}")
//    public ResponseEntity<Car> returnGetNewCarPathVariable(@PathVariable("carName") String carName){
//        return ResponseEntity.ok(new Car(carName));
//    }
//    @GetMapping("/hello")
//    public ResponseEntity<Car> returnGetNewCarRequestParam(@RequestParam("carName") String carName){
//        return ResponseEntity.ok(new Car(carName));
//    }
//
//    @PutMapping("/hello/{carName}")
//    public ResponseEntity<Car> returnPutNewCarPathVariable(@PathVariable("carName") String carName){
//        return ResponseEntity.ok(new Car(carName));
//    }
//
//    @PutMapping("/hello")
//    public ResponseEntity<Car> returnPutNewCarRequestBody(@RequestBody Car car){
//        return ResponseEntity.ok(car);
//    }
//
//    @PostMapping("/hello")
//    public ResponseEntity<Car> returnPostNewCarRequestBody(@RequestBody Car car){
//        return ResponseEntity.ok(car);
//    }
//
//    @DeleteMapping ("/hello{carName}")
//    public ResponseEntity<String> returnOnlyStatus200(@PathVariable("carName") String carName){
////        System.out.println("Car: " + carName + "deleted");
//        return ResponseEntity.ok().build();
//    }
//}