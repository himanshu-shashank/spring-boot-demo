package com.example.streams.tests;


import com.example.streams.beans.Car;
import com.example.streams.beans.Person;
import com.example.streams.beans.PersonDTO;
import com.example.streams.mockdata.MockData;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class TransformationsMapAndReduce {

    @Test
    void yourFirstTransformationWithMap() throws IOException {
        List<Person> people = MockData.getPeople();

        Function<Person, PersonDTO> personPersonDTOFunction = person ->
                new PersonDTO(
                        person.getId(),
                        person.getFirstName(),
                        person.getAge());

        List<PersonDTO> dtos = people.stream()
                .filter(person -> person.getAge() > 20)
                .map(personPersonDTOFunction)
                //.map(PersonDTO::map)
                .collect(Collectors.toList());

        dtos.forEach(System.out::println);

    }

    @Test
    void mapToDoubleAndFindAverageCarPrice() throws IOException {
        List<Car> cars = MockData.getCars();
        double avg = cars.stream()
                .mapToDouble(Car::getPrice)
                .average()
                .orElse(0);
        System.out.println(avg);
    }

    @Test
    public void reduce() {
        int[] integers = {1, 2, 3, 4, 99, 100, 121, 1302, 199};
        //identity is initial value
        //of type T and accumulator is a
        //function for combining two values.
        int sum = Arrays.stream(integers).reduce(0, Integer::sum);
        int sub = Arrays.stream(integers).reduce(0, (a, b) -> a - b);
        System.out.println(sum);
        System.out.println(sub);
    }
}

