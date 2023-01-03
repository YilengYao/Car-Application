package com.example.carapplication.repository;

import com.example.carapplication.graphql.generated.types.Car;

import java.util.List;

public interface CarStore {
    public List<Car> allCars();

}
