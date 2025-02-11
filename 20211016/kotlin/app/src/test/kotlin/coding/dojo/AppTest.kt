/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package coding.dojo

import kotlin.test.*

class AppTest {
    private fun sumFromOneToFive(): Int {
        return (1..5).sum()
    }

    @Test
    fun testSumFromOneToFive() {
        assertEquals(15, sumFromOneToFive())
    }

    private fun excludeFiveFromOneToFive(): Int {
        return (1..5).filter { it != 5 }.sum()
    }

    @Test
    fun testFilter() {
        assertEquals(10, excludeFiveFromOneToFive())
    }

    private fun includedInOneToFive(i: Int): Boolean {
        return (1..5).contains(i)
    }

    @Test
    fun testInclude() {
        assertTrue { includedInOneToFive(1) }
        assertFalse { includedInOneToFive(6) }
    }

    private fun solution(numbers: IntArray): Int {
        return (0..9).filterNot { numbers.contains(it) }.sum()
    }

    @Test
    fun testSample() {
        assertEquals(14, solution(intArrayOf(1,2,3,4,6,7,8,0)))
        assertEquals(6, solution(intArrayOf(5,8,4,0,6,7,9)))
    }
}
