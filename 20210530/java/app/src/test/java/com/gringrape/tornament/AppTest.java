/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.gringrape.tornament;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AppTest {
    int round = 1;

    int groupNo(int i) {
        return (i + 1) / 2;
    }

    int solution(int N, int a, int b) {
        if (groupNo(a) == groupNo(b)) {
            return round;
        }

        round += 1;

        return solution(N, groupNo(a), groupNo(b));
    }

    @Test void testIsWorking() {
        assertEquals(1 + 1, 2);
    }

    @Test void meetOnRound1() {
        this.round = 1;
        assertEquals(solution(2, 1, 2), 1);

        this.round = 1;
        assertNotEquals(solution(4, 2, 3), 1);

        this.round = 1;
        assertEquals(solution(4, 3, 4), 1);
    }

    @Test void meetOnRound2() {
        this.round = 1;
        assertEquals(solution(4, 1, 3), 2);

        this.round = 1;
        assertEquals(solution(4, 2, 3), 2);
    }

    @Test void meetOnRound3() {
        this.round = 1;
        assertEquals(solution(8, 4, 7), 3);

        this.round = 1;
        assertEquals(solution(8, 1, 8), 3);
    }
}
