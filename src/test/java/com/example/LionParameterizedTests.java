package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import java.util.List;
import java.util.Objects;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Параметризованный тестовый класс для проверки корректности метода doesHaveMane()
 * у класса Lion в зависимости от значения пола животного.
 * Используются параметры:
 * - "Самец" → должен иметь гриву (true)
 * - "Самка" → не должна иметь гриву (false)
 */
@RunWith(Parameterized.class)
public class LionParameterizedTests {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @Mock
    Feline feline;

    private final String sex;

    private final boolean hasMane;

    /**
     * Конструктор для инициализации тестовых параметров.
     */
    public LionParameterizedTests(String sex, boolean hasMane) {
        this.sex = sex;
        this.hasMane = hasMane;
    }

    /**
     * Метод, предоставляющий набор тестовых данных для параметризованного теста.
     */
    @Parameterized.Parameters(name = "Класс Lion. Пол: {0}")
    public static Object[][] setSexForLion() {
        return new Object[][] {
                {"Самец", true},
                {"Самка", false},
        };
    }

    /**
     * Тестирует метод doesHaveMane(), который должен возвращать корректное значение
     * наличия гривы в зависимости от пола льва.
     */
    @Test
    public void doesHaveManeIsCorrect() throws Exception {
        MatcherAssert.assertThat("Грива есть только у льва",
                new Lion(feline, this.sex).doesHaveMane(),
                equalTo(hasMane)
        );
    }
}