package storage;

public class SequenceGenerator {

    private static long val;

    private SequenceGenerator() {
    }

    public static long getVal(){
        return val++;
    }


}