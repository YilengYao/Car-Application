package com.example.carapplication.repository.jooq;

import com.example.carapplication.graphql.generated.types.Car;
import com.example.carapplication.graphql.generated.types.CarYearRange;
import com.example.carapplication.graphql.generated.types.Gender;
import com.example.carapplication.repository.CarStore;
import org.jooq.Condition;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static com.example.carapplication.jooq.generator.Tables.CARS;

public class JooqCarStore implements CarStore {

    private final DSLContext context;

    @Autowired
    public JooqCarStore(DSLContext context) {
        this.context = context;
    }

    @Override
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
            final Optional<CarYearRange> carYearRange) {
        Condition condition = DSL.trueCondition();
        if (firstName.isPresent()) {
            condition = condition.and(CARS.FIRST_NAME.eq(firstName.get()));
        }
        if (lastName.isPresent()) {
            condition = condition.and(CARS.LAST_NAME.eq(lastName.get()));
        }
        if (gender.isPresent()) {
            condition = condition.and(CARS.GENDER.eq(com.example.carapplication.jooq.generator.enums.CarsGender.valueOf(gender.get().name())));
        }
        if (country.isPresent()) {
            condition = condition.and(CARS.COUNTRY.eq(country.get()));
        }
        if (city.isPresent()) {
            condition = condition.and(CARS.CITY.eq(city.get()));
        }
        if (creditCardType.isPresent()) {
            condition = condition.and(CARS.CREDIT_CARD_TYPE.eq(creditCardType.get()));
        }
        if (currency.isPresent()) {
            condition = condition.and(CARS.CURRENCY.eq(currency.get()));
        }
        if (ethnicity.isPresent()) {
            condition = condition.and(CARS.ETHNICITY.eq(ethnicity.get()));
        }
        if (carMake.isPresent()) {
            condition = condition.and(CARS.CAR_MAKE.eq(carMake.get()));
        }
        if (carModel.isPresent()) {
            condition = condition.and(CARS.CAR_MODEL.eq(carModel.get()));
        }
        if (carYearRange.isPresent()) {
            condition = condition.and(CARS.CAR_MODEL_YEAR.between(carYearRange.get().getMin_year(), carYearRange.get().getMax_year()));
        }

        var result = context.selectFrom(CARS)
                .where(condition)
                .fetch();

        return deserializeRecord(result);
    }

    @Override
    public List<Car> cars(List<String> ids, List<String> emails, List<String> carVins) {
        if (ids == null && emails == null && carVins == null) {
            return Collections.emptyList();
        }
        Condition condition = DSL.trueCondition();
        if (ids != null) {
            condition = condition.in(CARS.CAR_ID.in(ids));
        }
        if (emails != null) {
            condition = condition.in(CARS.EMAIL.in(emails));
        }
        if (carVins != null) {
            condition = condition.in(CARS.CAR_VIN.in(carVins));
        }
        var result = context.selectFrom(CARS)
                .where(condition)
                .fetch();
        return deserializeRecord(result);
    }

    private List<Car> deserializeRecord(Result<com.example.carapplication.jooq.generator.tables.records.CarsRecord> carResult) {
        List<Car> carList = new ArrayList<>();
        for (org.jooq.Record record: carResult) {
            String carId = record.get(CARS.CAR_ID).toString();
            String firstName = record.get(CARS.FIRST_NAME);
            String lastName = record.get(CARS.LAST_NAME);
            String email = record.get(CARS.EMAIL);
            String gender = record.get(CARS.GENDER).toString();
            String country = record.get(CARS.COUNTRY);
            String city = record.get(CARS.CITY);
            String streetNumber = record.get(CARS.STREET_NUMBER);
            String address = record.get(CARS.ADDRESS);
            String creditCardType = record.get(CARS.CREDIT_CARD_TYPE);
            Long creditCard = record.get(CARS.CREDIT_CARD);
            String currency = record.get(CARS.CURRENCY);
            String ethnicity = record.get(CARS.ETHNICITY);
            String carMake = record.get(CARS.CAR_MAKE);
            String carModel = record.get(CARS.CAR_MODEL);
            Integer carModelYear = record.get(CARS.CAR_MODEL_YEAR);
            String carVin = record.get(CARS.CAR_VIN);

            carList.add(Car.newBuilder()
                            .car_id(carId)
                            .first_name(firstName)
                            .last_name(lastName)
                            .email(email)
                            .gender(Gender.valueOf(gender))
                            .country(country)
                            .city(city)
                            .street_number(streetNumber)
                            .address(address)
                            .credit_card_type(creditCardType)
                            .credit_card(creditCard.intValue())
                            .currency(currency)
                            .ethnicity(ethnicity)
                            .car_make(carMake)
                            .car_model(carModel)
                            .car_model_year(carModelYear)
                            .car_vin(carVin)
                    .build());
        }

        return carList;
    }

}
