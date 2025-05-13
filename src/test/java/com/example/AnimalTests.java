package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Тестовый класс для проверки корректности работы методов класса Animal.
 */
public class AnimalTests {

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    /**
     * Тестирует метод getFamily(), который должен возвращать строку
     * с перечнем известных семейств животных.
     * Ожидается, что возвращаемое значение будет совпадать с заранее заданной строкой.
     */
    @Test
    public void getFamilyIsCorrect() {
        String expectedString = "Существует несколько семейств: заячьи, беличьи, мышиные, кошачьи, псовые, медвежьи, куньи";

        MatcherAssert.assertThat("Некорректный перечень семейств",
                new Animal().getFamily(),
                equalTo(expectedString)
        );
    }

    @Test
    public void getFoodThrowsException() throws Exception {
        expectedEx.expect(Exception.class);
        expectedEx.expectMessage("Неизвестный вид животного, используйте значение Травоядное или Хищник");

        new Animal().getFood("");
    }
}