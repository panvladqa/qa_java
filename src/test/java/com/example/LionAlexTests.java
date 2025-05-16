package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

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
        assertTrue("У льва Алекса не может быть котят",
                new LionAlex(feline).getKittens() == 0);
    }

    /**
     * Тестирует метод getPlaceOfLiving(), который должен возвращать место проживания льва Алекса.
     */
    @Test
    public void getPlaceOfLivingIsCorrect() throws Exception {
        assertTrue("Лев Алекс живёт не там",
                new LionAlex(feline).getPlaceOfLiving().equals("Нью-Йоркский зоопарк"));
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
        assertTrue("Неправильный список друзей",
                new LionAlex(feline).getFriends().equals(expectedList));
    }
}