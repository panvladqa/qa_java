package com.example;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.assertTrue;

import java.util.List;

/**
 * Тестовый класс для проверки корректности работы методов класса Lion.
 * Используются моки (Mockito) для изоляции зависимостей и JUnit Rules для проверки исключений.
 */
@RunWith(MockitoJUnitRunner.class)
public class LionTests {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Mock
    Feline feline;

    /**
     * Тестирует создание объекта Lion с недопустимым значением пола.
     */
    @Test
    public void createLionThrowsException() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Используйте допустимые значения пола животного - самец или самка");

        try {
            new Lion(feline, "Не определено");
        } catch (Exception e) {
            assertTrue("Определено", true);
            throw e;
        }
    }

    /**
     * Тестирует метод getKittens(), который должен возвращать количество котят,
     * полученное от зависимости Feline.
     */
    @Test
    public void getKittensIsCorrect() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        int expectedCount = 5;
        Mockito.when(feline.getKittens()).thenReturn(expectedCount);
        assertTrue("Некорректное количество котят",
                lion.getKittens() == expectedCount);
    }

    /**
     * Тестирует метод getFood(), который должен возвращать список еды,
     * полученный от зависимости Feline.
     */
    @Test
    public void getFoodIsCorrect() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedListOfFood = List.of("Пища");
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedListOfFood);
        assertTrue("Некорректный список еды",
                lion.getFood().equals(expectedListOfFood));
    }
}