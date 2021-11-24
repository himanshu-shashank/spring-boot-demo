package com.example.streams.functionalinterface;

import java.util.Optional;

public class _Optional {
    public static void main(String[] args) {

        Optional.ofNullable(null)
                .ifPresentOrElse(
                        email -> System.out.println("Sending email to " + email),
                        () -> System.out.println("Cannot send email"));

        Object value = Optional.ofNullable("Hello")
                .orElseThrow(
                        ()-> new IllegalStateException("exception")
                );
        System.out.println(value);


        Optional.ofNullable("Himanshu")
                .ifPresent(
                        email -> System.out.println("Sending email to " + email)
                );

    }
}
