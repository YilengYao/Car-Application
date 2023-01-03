package com.example.carapplication.graphql;

import com.example.carapplication.graphql.generated.types.Car;
import com.example.carapplication.repository.CarStore;
import com.netflix.graphql.dgs.DgsComponent;
import com.netflix.graphql.dgs.DgsQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@DgsComponent
public class CarsDatafetcher {

    private final CarStore carStore;

    @Autowired
    public CarsDatafetcher(CarStore carStore) {
        this.carStore = carStore;
    }

    @DgsQuery
    public List<Car> allCars() {
        return carStore.allCars();
    }
}
