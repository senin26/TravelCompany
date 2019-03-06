package storage;

public class SequenceGenerator {

   /* private static long val;

    private SequenceGenerator() {
    }

    public static long getVal(){
        return val++;
    }*/
   protected long value = 0;

   public long getVal() {
        return value++;
    }


}