package com.example.carapplication.repository.jooq;

import com.example.carapplication.graphql.generated.types.Car;
import com.example.carapplication.graphql.generated.types.Gender;
import com.example.carapplication.repository.CarStore;
import org.jooq.DSLContext;
import org.jooq.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.example.carapplication.jooq.generator.Tables.CARS;

public class JooqCarStore implements CarStore {

    private final DSLContext context;

    @Autowired
    public JooqCarStore(DSLContext context) {
        this.context = context;
    }

    @Override
    public List<Car> allCars() {
        var result = context.select().from(CARS).fetch();

        return deserializeRecord(result);
    }

    private List<Car> deserializeRecord(Result<org.jooq.Record> carResult) {
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
