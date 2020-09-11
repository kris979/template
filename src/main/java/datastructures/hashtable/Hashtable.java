package datastructures.hashtable;

public class Hashtable {

    private Entry[] entries = new Entry[16];

    public void put(String key, Integer value) {

        Entry entry = new Entry(key, value, null);
        int hash = key.hashCode();
        int index = hash % 16;
        Entry oldEntry = entries[index];
        if (oldEntry == null)
            entries[index] = entry;
        else {
        }
    }

    public Integer get(String key) {
        int hash = key.hashCode();
        int index = hash % 16;
        return entries[index].value;
    }
}
