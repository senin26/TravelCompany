package storage;

public class SequenceGenerator {

    private static long val;

    private SequenceGenerator() {
    }

    public static long getNextValue(){
        return val++;
    }


}