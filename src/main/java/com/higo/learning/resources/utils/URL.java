package com.higo.learning.resources.utils;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class URL {

    public static List<Integer> decodeIntList(String s) {
        return Arrays.asList(s.split(","))
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static String decodeParam(String s) {
        return URLDecoder.decode(s, StandardCharsets.UTF_8);
    }
}
