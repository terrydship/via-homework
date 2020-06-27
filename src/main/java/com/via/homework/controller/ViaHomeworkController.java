package com.via.homework.controller;

import com.via.homework.model.AnagramArray;
import com.via.homework.model.AnagramBoolean;
import com.via.homework.service.HomeworkService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Terry Deng
 */

@RestController
public class ViaHomeworkController {

    @Autowired
    private HomeworkService viaHomeworkService;

    @ApiOperation("Check if two given strings are anagrams of each other")
    @GetMapping("/anagrams/{string1}/{string2}")
    @ResponseStatus(HttpStatus.OK)
    public AnagramBoolean areAnagrams(@PathVariable String string1, @PathVariable String string2) {
        return viaHomeworkService.areAnagrams(string1, string2);
    }

    @ApiOperation("Return all the possible anagrams of the given string")
    @GetMapping("/anagrams/{string1}")
    @ResponseStatus(HttpStatus.OK)
    public AnagramArray getAnagrams(@PathVariable String string1) {
        return viaHomeworkService.getAnagrams(string1);
    }

}
