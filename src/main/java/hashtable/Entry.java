package hashtable;

public class Entry {

    public String key;
    public Integer value;
    public Entry next;


    public Entry(String key,Integer value, Entry next) {
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
