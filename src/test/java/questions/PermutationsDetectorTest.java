package questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PermutationsDetectorTest {

    private PermutationsDetector detector = new PermutationsDetector();

    @Test
    public void testPermutations() {
        assertTrue(detector.detect("abc", "cba"));
        assertFalse(detector.detect("abc", "zxy"));
    }

}