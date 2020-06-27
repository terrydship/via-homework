package com.via.homework.service;

import com.via.homework.exception.InvalidStringException;
import com.via.homework.model.AnagramArray;
import com.via.homework.model.AnagramBoolean;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Anagrams related services.
 * All the implementations assume that anagrams are case sensitive
 * i.e. "cinema" and "Iceman" are not anagrams of each other.
 *
 * @author Terry Deng
 */

@Service("viaHomeworkService")
public class ViaHomeworkService implements HomeworkService {

    /**
     * Check if two strings are anagrams of each other.
     * Time complexity is O(n).
     * <p>
     * The idea is to calculate the number of character appearance in string1, and plus 1
     * each time the same character is found. Then traverse all the characters in string2, and
     * minus 1 each time the character is found. If any character in string2 is not found or the
     * number of character appearance is not zero after the loop, then string1 and string 2 are NOT
     * anagrams of each other, otherwise they are.
     *
     * @param string1
     * @param string2
     * @return {@link AnagramBoolean}
     */
    @Override
    public AnagramBoolean areAnagrams(String string1, String string2) {
        if (!isValidString(string1) || !isValidString(string2)) {
            throw new InvalidStringException("Invalid String");
        }

        if (string1.length() != string2.length()) {
            return new AnagramBoolean(false);
        }

        Map<Character, Integer> map = new HashMap<>();

        for (Character c: string1.toCharArray()) {
            if (!map.containsKey(c)) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }

        for (Character c: string2.toCharArray()) {
            if (!map.containsKey(c)) {
                return new AnagramBoolean(false);
            } else {
                map.put(c, map.get(c) - 1);
            }
        }

        for (Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() != 0) {
                return new AnagramBoolean(false);
            }
        }

        return new AnagramBoolean(true);
    }

    /**
     * Alternative way to check if two strings are anagrams of each other.
     * Time complexity is O(n log(n)) due to Arrays.sort, which is NOT good enough.
     * @deprecated
     *
     * @param string1
     * @param string2
     * @return {@link AnagramBoolean}
     */
    @Deprecated
    @Override
    public AnagramBoolean areAnagramsAlternative(String string1, String string2) {
        if (!isValidString(string1) || !isValidString(string2)) {
            throw new InvalidStringException("Invalid String");
        }

        if (string1.length() != string2.length()) {
            return new AnagramBoolean(false);
        }

        char[] charArray1 = string1.toCharArray();
        char[] charArray2 = string2.toCharArray();
        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return new AnagramBoolean(Arrays.equals(charArray1, charArray2));
    }

    /**
     * Get all the possible anagrams of the given string
     * Time complexity is O(n!) given a string of length n. i.e. the factorial of n.
     * <p>
     * The idea is to get the first character and the rest part of the string, then pass the rest part
     * of the string to the recursive function to get all the anagrams of the rest part of the string, then
     * traverse them and put the first character at all possible positions, until the rest part of the string
     * is empty.
     * Note that TreeSet is used to get rid of the duplicates and sort for readability.
     *
     * @param string1
     * @return {@link AnagramArray}
     */
    @Override
    public AnagramArray getAnagrams(String string1) {
        Set<String> anagramsSet = new TreeSet<>();

        if (string1.length() == 0) {
            anagramsSet.add("");
            return new AnagramArray(anagramsSet);
        }

        if (!isValidString(string1)) {
            throw new InvalidStringException("Invalid String");
        }

        char firstCharacter = string1.charAt(0);
        String restCharacters = string1.substring(1);
        Set<String> recursiveAnagramsSet = getAnagrams(restCharacters).getAnagrams();

        for (String anagram: recursiveAnagramsSet) {
            for (int i = 0; i <= anagram.length(); i++) {
                StringBuilder sb = new StringBuilder();
                sb.append(anagram.substring(0, i)).append(firstCharacter).append(anagram.substring(i));
                anagramsSet.add(sb.toString());
            }
        }
        return new AnagramArray(anagramsSet);
    }

    /**
     * Note that empty string is non alpha-numerical.
     */
    private boolean isValidString(String string) {
        return StringUtils.isAlphanumeric(string);
    }

}
