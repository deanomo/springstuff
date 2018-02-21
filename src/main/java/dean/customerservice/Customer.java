package dean.customerservice;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Customer {
    private int id;
    private String name;
    private int age;

    public Customer(){
    }

    public Customer(int id, String name, int age){
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString(){
        String info = String.format("Customer with id = %d, name = %s, age = %d", id, name, age);
        return info;
    }

    public static Optional<String> serial(Object o) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return Optional.of(mapper.writeValueAsString(o));
        } catch(IOException e) {

        }
        return Optional.empty();
    }

}