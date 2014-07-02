package dio.clsswrk.leftjoin;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * Created by Димон on 01.07.2014.
 */
public class ArrayHelperDelegate {
    private final ArrayHelper arrayHelper;
    public ArrayHelperDelegate(ArrayHelper arrayHelper) {
        this.arrayHelper = arrayHelper;
    }


    private <T> boolean contains(T el, T[] array) {
        if (el == null || array == null)
            throw new IllegalArgumentException("null in contains method arguments");
        for (T t : array) {
            if (t == null)
                continue;
            if (t.equals(el))
                return true;
        }
        return false;
    }
    private <T> boolean contains(T el, List<T> list) {
        if (el == null || list == null)
            throw new IllegalArgumentException("null in contains method arguments");
        for (T t : list) {
            if (t == null)
                continue;
            if (t.equals(el))
                return true;
        }
        return false;
    }
    private <T> T[] noDup(T[] array) {
        if (array == null)
            throw new IllegalArgumentException("null in noDup method argument");
        List<T> list = new ArrayList<T>();
        for (T t : array) {
            if (t == null)
                continue;
            if (!contains(t, list)) {
                list.add(t);
            }
        }

        return (T[]) Arrays.copyOf(list.toArray(), list.size(), array.getClass());// line from ArrayList source

    }

    public Product[] mergeProduct(Product[] prod1, Product[] prod2) {
        Product[] merge = arrayHelper.mergeProduct(prod1, prod2);
        return noDup(merge);
    }
}
