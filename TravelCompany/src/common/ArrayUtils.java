package common;


public final class ArrayUtils {

    private ArrayUtils() {

    }

    public static void deleteByIndex(Object[] arr, int index) {
        System.arraycopy(arr, index + 1, arr, index, arr.length - index - 1);
    }

}
