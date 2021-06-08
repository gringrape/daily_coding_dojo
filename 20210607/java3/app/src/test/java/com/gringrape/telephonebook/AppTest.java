/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.gringrape.telephonebook;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

class AppTest {
    @Test void testIsWorking() {
        assertThat(1 + 1).isEqualTo(2);
    }

    Set<String> putSubstrings(String string, Set<String> hash) {
        List<String> subStrings = IntStream.rangeClosed(1, string.length())
                .mapToObj(i -> string.substring(0, i))
                .collect(Collectors.toList());

        hash.addAll(subStrings);

        return hash;
    }

    @Test void putPiecesToHash() {
        Set<String> set = putSubstrings("abc", new HashSet<>());

        assertThat(set.contains("a")).isTrue();
        assertThat(set.contains("ab")).isTrue();
        assertThat(set.contains("abc")).isTrue();

        assertThat(set.contains("d")).isFalse();
    }

    String[] sortDescending(String[] array) {
        Arrays.sort(
                array,
                Comparator.comparing(String::length).reversed()
        );

        return array;
    }

    @Test void testSortDescending() {
        assertThat(
                sortDescending(new String[]{"a", "ab", "abc"})
        ).isEqualTo(new String[]{"abc", "ab", "a"});
    }

    boolean solution(String[] phoneBook) {
        Set<String> hash = new HashSet<>();
        sortDescending(phoneBook);

        for (String phoneNumber : phoneBook) {
            if (hash.contains(phoneNumber)) {
                return false;
            }
            putSubstrings(phoneNumber, hash);
        }

        return true;
    }

    @Test void examples() {
        assertThat(solution(new String[]{"119", "97674223", "1195524421"})).isFalse();
        assertThat(solution(new String[]{"123","456","789"})).isTrue();
        assertThat(solution(new String[]{"12","123","1235","567","88"})).isFalse();
    }
}
