package com.example;

import org.hamcrest.MatcherAssert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Тестовый класс для проверки корректности работы методов класса LionAlex.
 */
@RunWith(MockitoJUnitRunner.class)
public class LionAlexTests {

    @Mock
    Feline feline;

    /**
     * Тестирует метод getKittens(), который у LionAlex всегда должен возвращать 0,
     * так как он — персонаж и не размножается в рамках истории.
     */
    @Test
    public void getKittensIsAlwaysZero() throws Exception {
        MatcherAssert.assertThat("У льва Алекса не может быть котят",
                new LionAlex(feline).getKittens(),
                equalTo(0)
        );
    }

    /**
     * Тестирует метод getPlaceOfLiving(), который должен возвращать место проживания льва Алекса.
     */
    @Test
    public void getPlaceOfLivingIsCorrect() throws Exception {
        MatcherAssert.assertThat("Лев Алекс живёт не там",
                new LionAlex(feline).getPlaceOfLiving(),
                equalTo("Нью-Йоркский зоопарк")
        );
    }

    /**
     * Тестирует метод getFriends(), который должен возвращать список друзей льва Алекса.
     */
    @Test
    public void getFriendsIsCorrect() throws Exception {
        List<String> expectedList = List.of(
                "Зебра Марти",
                "Бегемотиха Глория",
                "Жираф Мелман"
        );
        MatcherAssert.assertThat("Неправильный список друзей",
                new LionAlex(feline).getFriends(),
                equalTo(expectedList)
        );
    }
}