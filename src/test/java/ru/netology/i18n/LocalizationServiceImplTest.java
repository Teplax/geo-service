package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;
@DisplayName("LocalizationServiceImpl Test")
class LocalizationServiceImplTest {
    //given
    @ParameterizedTest
    @CsvSource (value = {"RUSSIA, Добро пожаловать",
                        "GERMANY, Welcome",
                        "USA, Welcome",
                        "BRAZIL, Welcome",
                        "POLAND, Welcome"
    })
    @DisplayName("Method locale")
    void locale(Country country, String greetings) {
        //when
        LocalizationServiceImpl locService=new LocalizationServiceImpl();
        //then
        Assertions.assertEquals(greetings,locService.locale(country));
    }
}