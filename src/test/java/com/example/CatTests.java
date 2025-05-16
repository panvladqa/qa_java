package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

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
        assertTrue("Кот мяукает не так",
                new Cat(feline).getSound().equals(expectedString));
    }

    /**
     * Тестирует метод getFood(), который должен возвращать список еды для кота.
     */
    @Test
    public void getFoodIsCorrect() throws Exception {
        Cat cat = new Cat(feline);
        List<String> expectedListOfFood = List.of("Мясо");
        Mockito.when(feline.eatMeat()).thenReturn(expectedListOfFood);
        assertTrue("Вернулся некорректный список еды",
                cat.getFood().equals(expectedListOfFood));
    }
}