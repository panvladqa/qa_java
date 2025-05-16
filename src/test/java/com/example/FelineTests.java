package com.example;

import org.junit.Test;
import static org.junit.Assert.assertTrue;

/**
 * Тестовый класс для проверки корректности работы методов класса Feline.
 */
public class FelineTests {

    /**
     * Тестирует метод getFamily(), который должен возвращать название семейства
     */
    @Test
    public void getFamilyIsCorrect() {
        String expectedFelineFamilyName = "Кошачьи";
        assertTrue("Некорректное название семейства кошачьих",
                new Feline().getFamily().equals(expectedFelineFamilyName));
    }

    /**
     * Тестирует метод getKittens(int kittensCount), который должен возвращать
     * переданное количество котят.
     */
    @Test
    public void getKittensInputCountIsCorrect() {
        int expectedCount = 5;
        assertTrue("Некорректное количество котят",
                new Feline().getKittens(expectedCount) == expectedCount);
    }

    /**
     * Тестирует метод getKittens(), который должен возвращать стандартное
     * количество котят (по умолчанию).
     */
    @Test
    public void getKittensDefaultIsCorrect() {
        int expectedCount = 1;
        assertTrue("Некорректное количество котят",
                new Feline().getKittens() == expectedCount);
    }

    /**
     * Тестирует метод eatMeat(), который должен возвращать список пищи для хищника.
     */
    @Test
    public void eatMeatIsCorrect() throws Exception {
        Feline feline = new Feline();
        assertTrue("Неправильный список еды",
                feline.eatMeat().equals(feline.getFood("Хищник")));
    }
}