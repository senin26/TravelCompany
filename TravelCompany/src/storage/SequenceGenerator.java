package storage;

public final class SequenceGenerator {

    private static long val;

    private SequenceGenerator() {
    }

    public static long getVal(){
        return val++;
    }
}