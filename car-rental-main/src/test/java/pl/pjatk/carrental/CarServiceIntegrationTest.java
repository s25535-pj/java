package pl.pjatk.carrental;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.pjatk.carrental.model.Car;
import pl.pjatk.carrental.model.CarType;
import pl.pjatk.carrental.model.RentalInfo;
import pl.pjatk.carrental.model.User;
import pl.pjatk.carrental.storage.CarStorage;
import pl.pjatk.carrental.storage.RentalStorage;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
class CarServiceIntegrationTest {
    @Autowired
    private CarService carService;

    @MockBean
    private CarStorage carStorage;

    @MockBean
    private RentalStorage rentalStorage;

    @Test
    void successRent() {
        //given
        when(carStorage.findCarByVin(any()))
                .thenReturn(Optional.of(new Car("Opel", "Astra", "1234", CarType.STANDARD)));
        when(rentalStorage.isCarRented(any())).thenReturn(false);
        RentalInfo testRental = carService.rentCar(
                new User("1"), "aaaaaa",
                LocalDate.of(2022, 11, 23),
                LocalDate.of(2022, 11, 24)
        );
        //then
        assertThat(testRental.getPrice()).isEqualTo(300);
    }

    @Test
    void carDoesntExistInDataBase() {
        RentalInfo testRental = carService.rentCar(
                new User("1"), "aaaaaa",
                LocalDate.of(2022, 11, 23),
                LocalDate.of(2022, 11, 24)
        );
        assertThat(testRental).isNull();
    }

    @Test
    void carIsCurrentlyRented() {
        //when
        RentalInfo testRental = carService.rentCar(
                new User("1"), "aaaaaa",
                LocalDate.of(2022, 11, 23),
                LocalDate.of(2022, 11, 24)
        );
        //then
        assertThat(testRental).isNull();
    }

    @Test
    void premiumClassCarIsPricier() {
        //when
        RentalInfo testRental = carService.rentCar(
                new User("1"), "aaaaaa",
                LocalDate.of(2022, 11, 23),
                LocalDate.of(2022, 11, 24)
        );
        //then
        assertThat(testRental.getPrice()).isEqualTo(450);
    }

    @Test
    void givenEndDateIsBeforeStartDate() {
        //when
        RentalInfo testRental = carService.rentCar(
                new User("1"), "aaaaaa",
                LocalDate.of(2022, 11, 24),
                LocalDate.of(2022, 11, 23)
        );
        //then
        assertThat(testRental).isNull();
    }
}
