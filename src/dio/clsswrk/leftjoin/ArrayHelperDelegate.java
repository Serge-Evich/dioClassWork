package dio.clsswrk.leftjoin;

import java.util.ArrayList;
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
        for (T t : array) {
            if (t.equals(el))
                return true;
        }
        return false;
    }
    private <T> boolean contains(T el,List<T> list) {
        for (T t : list) {
            if (t.equals(el))
                return true;
        }
        return false;
    }
    private <T> T[] noDup(T[] array) {
        List<T> list = new ArrayList<T>();
        for (T t : array) {
            if (!contains(t, list)) {
                list.add(t);
            }
        }
        T[] res = (T[])list.toArray();
        return res;
    }

    public Product[] mergeProduct(Product[] prod1, Product[] prod2) {
        prod1 = noDup(prod1);
        prod2 = noDup(prod2);
        return arrayHelper.mergeProduct(prod1, prod2);
    }
}
