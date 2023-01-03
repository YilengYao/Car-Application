package com.example.carapplication.graphql;

import com.example.carapplication.graphql.generated.types.Car;
import com.example.carapplication.graphql.generated.types.CarYearRange;
import com.example.carapplication.graphql.generated.types.CreateCarOutput;
import com.example.carapplication.graphql.generated.types.Gender;
import com.example.carapplication.repository.CarStore;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsMutation;
import com.netflix.graphql.dgs.DgsQuery;
import com.netflix.graphql.dgs.InputArgument;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@DgsComponent
public class CarsDatafetcher {

    private final CarStore carStore;

    @Autowired
    public CarsDatafetcher(CarStore carStore) {
        this.carStore = carStore;
    }

    @DgsQuery
    public List<Car> allCars(
            @InputArgument("first_name") final Optional<String> firstName,
            @InputArgument("last_name") final Optional<String> lastName,
            @InputArgument("gender") final Optional<Gender> gender,
            @InputArgument("country") final Optional<String> country,
            @InputArgument("city") final Optional<String> city,
            @InputArgument("credit_card_type") final Optional<String> creditCardType,
            @InputArgument("currency") final Optional<String> currency,
            @InputArgument("ethnicity") final Optional<String> ethnicity,
            @InputArgument("car_make") final Optional<String> carMake,
            @InputArgument("car_model") final Optional<String> carModel,
            @InputArgument(name = "car_year_range", collectionType = CarYearRange.class) final Optional<CarYearRange> carYearRange) {
        return carStore.allCars(firstName, lastName, gender, country, city, creditCardType, currency, ethnicity, carMake, carModel, carYearRange);
    }

    @DgsQuery
    public List<Car> cars(
            @InputArgument("ids") final List<String> ids,
            @InputArgument("emails") final List<String> emails,
            @InputArgument("car_vins") final List<String> carVins) {

        return carStore.cars(ids, emails, carVins);
    }

    @DgsMutation
    public CreateCarOutput createCar(
            @InputArgument("first_name") final String firstName,
            @InputArgument("last_name") final String lastName,
            @InputArgument("email") final String email,
            @InputArgument("gender") final Gender gender,
            @InputArgument("country") final String country,
            @InputArgument("city") final String city,
            @InputArgument("street_number") String streetNumber,
            @InputArgument("address") String address,
            @InputArgument("credit_card_type") final String creditCardType,
            @InputArgument("credit_card") final Integer creditCard,
            @InputArgument("currency") final String currency,
            @InputArgument("ethnicity") final String ethnicity,
            @InputArgument("car_make") final String carMake,
            @InputArgument("car_model") final String carModel,
            @InputArgument("car_model_year") final Integer carModelYear,
            @InputArgument("car_vin") final String carVin) {

        return carStore.createCar(firstName, lastName, email, gender, country, city, streetNumber, address, creditCardType, creditCard.longValue(), currency, ethnicity, carMake, carModel, carModelYear, carVin);
    }
}
