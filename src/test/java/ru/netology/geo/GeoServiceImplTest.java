package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import java.util.stream.Stream;

import static ru.netology.geo.GeoServiceImpl.LOCALHOST;
import static ru.netology.geo.GeoServiceImpl.MOSCOW_IP;

@DisplayName("GeoserviceImpl Test")
public class GeoServiceImplTest {
    //given
   GeoService geoService = new GeoServiceImpl();
    public static Stream<Arguments> locationAndIp() {
        return Stream.of(Arguments.of(new Location(null, null, null, 0), "127.0.0.1"),
                        Arguments.of(new Location("Moscow", Country.RUSSIA, "Lenina", 15), "172.0.32.11"),
                        Arguments.of(new Location("New York", Country.USA, " 10th Avenue", 32), "96.44.183.149"),
                        Arguments.of(new Location("Moscow", Country.RUSSIA, null, 0), "172.123.12.0.21"),
                        Arguments.of(new Location("New York", Country.USA, null,  0), "96.098.876.123")
        );
    }

   @ParameterizedTest
   @MethodSource("locationAndIp")
   @DisplayName("Testing method byIp()")
    void byIp(Location expected, String ip){
        //when
        Location result = geoService.byIp(ip);
        //then
        Assertions.assertEquals(result,expected);
   }

    @ParameterizedTest
    //given
    @CsvSource(
            value = {
                    "53.568721, 132.143825",
                    "34.123234, -23.452729",
                    "-12.730265, 178.825502"
            }
    )
    @DisplayName("Testing method byCoordinates()")
    void byCoordinates(double latitude, double longtitude) {
        //then
        Assertions.assertThrows(RuntimeException.class,()->{
            geoService.byCoordinates(latitude,longtitude);
        });

    }


}