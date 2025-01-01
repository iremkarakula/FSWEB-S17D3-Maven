package com.workintech.zoo.controller;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.validations.ZooValidations;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/kangaroos")
public class KangarooController {

    private Map<Integer, Kangaroo> kangaroos;

    @PostConstruct
    public void init(){
        kangaroos = new HashMap<>();
        kangaroos.put(1, new Kangaroo(1,"irem", 15.0, 20.0, "male", false));

    }

    @GetMapping
    public List<Kangaroo> find(){
        return kangaroos.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Kangaroo find(@PathVariable("id") Integer id){
        ZooValidations.checkIdIsValid(id);
        ZooValidations.checkKangarooExistence(id, kangaroos, true);
        return kangaroos.get(id);
    }

    @PostMapping
    public Kangaroo save(@RequestBody Kangaroo kangaroo){

        ZooValidations.checkKangarooExistence(kangaroo.getId(), kangaroos, false);
        kangaroos.put(kangaroo.getId(), kangaroo);
        return kangaroos.get(kangaroo.getId());
    }

    @PutMapping("/{id}")
    public Kangaroo update(@PathVariable("id") Integer id,@RequestBody Kangaroo kangaroo){
        ZooValidations.checkIdIsValid(id);
        ZooValidations.checkKangarooExistence(kangaroo.getId(), kangaroos, true);
        kangaroo.setId(id);
        kangaroos.put(id, kangaroo);
        return kangaroos.get(id);
    }

    @DeleteMapping("/{id}")
    public Kangaroo delete(@PathVariable("id") Integer id){
        ZooValidations.checkIdIsValid(id);
        return kangaroos.remove(id);
    }
}


