package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.assertTrue;

import java.util.List;

/**
 * Тестовый класс для проверки метода getFood() класса Animal
 * с использованием параметризованных тестов JUnit 4.
 */
@RunWith(Parameterized.class)
public class AnimalParameterizedTests {

    private final String animalKind;
    private final List<String> expectedListOfFood;

    /**
     * Конструктор для инициализации тестовых параметров.
     *
     * @param animalKind тип животного
     * @param expectedListOfFood ожидаемый список еды
     */
    public AnimalParameterizedTests(String animalKind, List<String> expectedListOfFood) {
        this.animalKind = animalKind;
        this.expectedListOfFood = expectedListOfFood;
    }

    /**
     * Метод, предоставляющий набор тестовых данных.
     * Возвращает массив объектов, каждый из которых содержит:
     * - тип животного
     * - ожидаемый список еды
     *
     * @return массив тестовых данных
     */
    @Parameterized.Parameters(name = "Класс Animal. Тип животного: {0}")
    public static Object[][] setParamsForTest() {
        return new Object[][] {
                {"Хищник", List.of("Животные", "Птицы", "Рыба")},
                {"Травоядное", List.of("Трава", "Различные растения")}
        };
    }

    /**
     * Проверяет корректность возвращаемого значения метода getFood()
     * у класса Animal для разных типов животных.
     *
     * @throws Exception если произошла ошибка при получении списка еды
     */
    @Test
    public void getFoodIsCorrect() throws Exception {
        assertTrue("Неправильный набор еды",
                new Animal().getFood(animalKind).equals(expectedListOfFood));
    }
}