package com.workintech.zoo.validations;

import com.workintech.zoo.entity.Kangaroo;
import com.workintech.zoo.exceptions.ZooException;
import org.springframework.http.HttpStatus;

import java.util.Map;

public class ZooValidations {


    public static void checkIdIsValid(Integer id) {

        if(id == null || id<0){
            throw new ZooException("Geçersiz id", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkKangarooExistence(Integer id, Map<Integer, Kangaroo> kangaroos, Boolean existence){
        if (kangaroos == null) {
            throw new ZooException("Kanguru veritabanı mevcut değil", HttpStatus.INTERNAL_SERVER_ERROR);
        }


        if(existence){
            if(!kangaroos.containsKey(id)){
                throw new ZooException("Kayıt bulunamadı", HttpStatus.NOT_FOUND);
            }
        } else {
            if(kangaroos.containsKey(id))
           throw new ZooException("Zaten kayıt var", HttpStatus.BAD_REQUEST);
        }
    }
}
