package com.via.homework;

import com.via.homework.exception.InvalidStringException;
import com.via.homework.model.AnagramBoolean;
import com.via.homework.service.HomeworkService;
import com.via.homework.service.ViaHomeworkService;
import org.junit.jupiter.api.Test;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Terry Deng
 */

@SpringBootTest
public class ViaHomeworkServiceTest {
    /**
     * Test the real service here instead of the stubbing one by using {@link Spy}
     */
    @Spy
    private HomeworkService viaHomeworkService = new ViaHomeworkService();

    @Test
    public void areAnagrams_true() {
        String string1 = "cinema";
        String string2 = "iceman";

        AnagramBoolean anagramBoolean = viaHomeworkService.areAnagrams(string1, string2);
        assertTrue(anagramBoolean.isAreAnagrams());
    }

    @Test
    public void areAnagrams_false() {
        String string1 = "cinema";
        String string2 = "Iceman";

        AnagramBoolean anagramBoolean = viaHomeworkService.areAnagrams(string1, string2);
        assertFalse(anagramBoolean.isAreAnagrams());
    }

    @Test
    public void areAnagrams_exception() {
        String string1 = "cinema";
        String string2 = "!ceman";

        Exception exception = assertThrows(InvalidStringException.class, () -> {
            viaHomeworkService.areAnagrams(string1, string2);
        });

        String expectedMessage = "Invalid String";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);
    }

}
