package com.via.homework.service;

import com.via.homework.model.AnagramArray;
import com.via.homework.model.AnagramBoolean;

/**
 * @author Terry Deng
 */

public interface HomeworkService {
    AnagramBoolean areAnagrams(String string1, String string2);
    AnagramBoolean areAnagramsAlternative(String string1, String string2);
    AnagramArray getAnagrams(String string1);
}
