package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Тестовый класс для проверки корректности работы методов класса Cat.
 */
@RunWith(MockitoJUnitRunner.class)
public class CatTests {

    @Mock
    Feline feline;

    /**
     * Тестирует метод getSound(), который должен возвращать звук, издаваемый котом.
     */
    @Test
    public void getSoundIsCorrect() {
        String expectedString = "Мяу";

        MatcherAssert.assertThat("Кот мяукает не так",
                new Cat(feline).getSound(),
                equalTo(expectedString)
        );
    }

    /**
     * Тестирует метод getFood(), который должен возвращать список еды для кота.
     */
    @Test
    public void getFoodIsCorrect() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedListOfFood = List.of("Мясо");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat("Вернулся некорректный список еды",
                cat.getFood(),
                equalTo(expectedListOfFood)
        );
    }
}