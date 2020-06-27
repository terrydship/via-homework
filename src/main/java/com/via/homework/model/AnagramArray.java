package com.via.homework.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * Contains all the possible anagrams of a given string.
 * Note that duplicates are removed.
 *
 * @author Terry Deng
 */

@Getter
@Setter
@AllArgsConstructor
public class AnagramArray {
    private Set<String> anagrams;
}
