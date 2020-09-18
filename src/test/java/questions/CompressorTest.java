package questions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompressorTest {

    private Compressor compressor = new Compressor();
    @Test
    void name() {
        assertEquals("aaabbc",compressor.compress("aaabbc"));
        assertEquals("a3b2",compressor.compress("aaabb"));
        assertEquals("ab",compressor.compress("ab"));
        assertEquals("a3",compressor.compress("aaa"));

        assertEquals("aaabbc",compressor.compressSolution("aaabbc"));
        assertEquals("a3b2",compressor.compressSolution("aaabb"));
        assertEquals("ab",compressor.compressSolution("ab"));
        assertEquals("a3",compressor.compressSolution("aaa"));
    }
}