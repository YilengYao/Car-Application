package com.example.carapplication.repository;

import com.example.carapplication.graphql.generated.types.Car;
import com.example.carapplication.graphql.generated.types.CarYearRange;
import com.example.carapplication.graphql.generated.types.CreateCarOutput;
import com.example.carapplication.graphql.generated.types.Gender;
import com.netflix.graphql.dgs.InputArgument;

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

    public CreateCarOutput createCar(
            final String firstName,
            final String lastName,
            final String email,
            final Gender gender,
            final String country,
            final String city,
            final String streetNumber,
            final String address,
            final String creditCardType,
            final Long creditCard,
            final String currency,
            final String ethnicity,
            final String carMake,
            final String carModelYear,
            final Integer carYear,
            final String carVin);
}
