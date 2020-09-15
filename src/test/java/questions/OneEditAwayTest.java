package questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OneEditAwayTest {

    private OneEditAway oneEditAway = new OneEditAway();

    @Test
    void oneWay() {
        assertTrue(oneEditAway.oneAway("one", "one"));
        assertTrue(oneEditAway.oneAway("one", "on"));
        assertTrue(oneEditAway.oneAway("one", "one1"));
        assertTrue(oneEditAway.oneAway("one", "ona"));
        assertTrue(oneEditAway.oneAway("aab", "aaa"));
    }
}