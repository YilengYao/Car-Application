package com.example.carapplication.repository;

import com.example.carapplication.graphql.generated.types.Car;
import com.example.carapplication.graphql.generated.types.CarYearRange;
import com.example.carapplication.graphql.generated.types.Gender;

import java.util.List;
import java.util.Optional;

public interface CarStore {
    public List<Car> allCars(
            final Optional<String> firstName,
            final Optional<String> lastName,
            final Optional<Gender> gender,
            final Optional<String> country,
            final Optional<String> city,
            final Optional<String> creditCardType,
            final Optional<String> currency,
            final Optional<String> ethnicity,
            final Optional<String> carMake,
            final Optional<String> carModel,
            final Optional<CarYearRange> carYearRange);

    public List<Car> cars(
            final List<String> ids,
            final List<String> emails,
            final List<String> carVins);
}
