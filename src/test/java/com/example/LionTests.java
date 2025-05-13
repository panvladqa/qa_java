package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

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

        new Lion(feline, "Не определено");
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

        MatcherAssert.assertThat("Некорректное количество котят",
                lion.getKittens(),
                equalTo(expectedCount)
        );
    }

    /**
     * Тестирует метод getFood(), который должен возвращать список еды,
     * полученный от зависимости Feline.
     */
    @Test
    public void getFoodIsCorrect() throws Exception {
        Lion lion = new Lion(feline, "Самец");
        List<String> expectedListOfFood = List.of("Пища");

        // Подменяем именно метод getFood с параметром "Хищник"
        Mockito.when(feline.getFood("Хищник")).thenReturn(expectedListOfFood);

        MatcherAssert.assertThat(
                "Некорректный список еды",
                lion.getFood(),
                equalTo(expectedListOfFood)
        );
    }
}