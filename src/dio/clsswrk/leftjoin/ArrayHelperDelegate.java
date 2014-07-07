package dio.clsswrk.leftjoin;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
            //local code review (vtegza): could be replaced with @ 07.07.14
            if (el.equals(t))
                return true;
        }
        return false;
    }

    //local code review (vtegza): simplify @ 07.07.14
    private <T> boolean contains(T el, List<T> list) {
        for (T t : list) {
            if (el.equals(t))
                return true;
        }
        return false;
    }

    private <T> T[] noDup(T[] array) {
        if (array == null)
            throw new IllegalArgumentException("null in noDup method argument");
        //local code review (vtegza): use diamond operator @ 07.07.14
        List<T> list = new ArrayList<>();
        for (T t : array) {
            if (t != null && !contains(t, list)) {
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
