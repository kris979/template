package hashtable;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class HashtableTest {

    private Hashtable hashtable = new Hashtable();

    @Test
    public void putAndGet() {
        hashtable.put("Kris", 41);
        assertThat(hashtable.get("Kris"), is(41));
    }
}