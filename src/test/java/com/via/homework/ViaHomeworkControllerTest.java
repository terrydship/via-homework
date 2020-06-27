package com.via.homework;

import com.via.homework.controller.ViaHomeworkController;
import com.via.homework.exception.InvalidStringException;
import com.via.homework.model.AnagramArray;
import com.via.homework.model.AnagramBoolean;
import com.via.homework.service.HomeworkService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

/**
 * @author Terry Deng
 */

@SpringBootTest
class ViaHomeworkControllerTest {

    @Mock
    private HomeworkService viaHomeworkService;

    @InjectMocks
    private ViaHomeworkController viaHomeworkController;

    @Test
    public void areAnagrams_true() {
        when(viaHomeworkService.areAnagrams(anyString(), anyString()))
                .thenReturn(new AnagramBoolean(true));

        AnagramBoolean anagramBoolean = viaHomeworkController.areAnagrams(anyString(), anyString());
        verify(viaHomeworkService, times(1)).areAnagrams(anyString(), anyString());
        assertTrue(anagramBoolean.isAreAnagrams());
    }

    @Test
    public void areAnagrams_exception() {
        when(viaHomeworkService.areAnagrams(anyString(), anyString()))
                .thenThrow(InvalidStringException.class);

        assertThrows(InvalidStringException.class, () -> {
            viaHomeworkController.areAnagrams(anyString(), anyString());
        });
    }

    @Test
    public void getAnagrams_success() {
        Set<String> anagramsSet = new HashSet<>();
        anagramsSet.add("ab");
        anagramsSet.add("ba");

        when(viaHomeworkService.getAnagrams(anyString()))
                .thenReturn(new AnagramArray(anagramsSet));

        AnagramArray anagramArray = viaHomeworkController.getAnagrams(anyString());
        verify(viaHomeworkService, times(1)).getAnagrams(anyString());
        assertEquals(2, anagramArray.getAnagrams().size());
    }

    @Test
    public void getAnagrams_exception() {
        when(viaHomeworkService.getAnagrams(anyString()))
                .thenThrow(InvalidStringException.class);

        assertThrows(InvalidStringException.class, () -> {
            viaHomeworkController.getAnagrams(anyString());
        });
    }

}
