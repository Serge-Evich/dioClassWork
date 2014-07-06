package dio.clsswrk.leftjoin;

import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Димон on 24.06.2014.
 */
public class ArrayHelperImpl implements ArrayHelper {
    @Override
    public int[] leftUnion(int[] leftArray, int[] rightArray){
        if (leftArray == null)
            leftArray = new int[0];
        if (rightArray == null)
            rightArray = new int[0];
        if (isMaxValueSize(leftArray))
            leftArray = new int[0];
        if (isMaxValueSize(rightArray))
            rightArray = new int[0];

        int count = 0;

        int[] tempRight = new int[leftArray.length + rightArray.length];
        for (int i : rightArray){
            for (int j : leftArray){
                if ((j == i)) {
                    tempRight[count] = j;
                    count++;
                }
            }
        }
        tempRight = trim(tempRight, count);
        return arrayMerge(leftArray, tempRight);
    }

    public int[] merge(int[] leftArray, int[] rightArray) {
        if (leftArray == null)
            leftArray = new int[0];
        if (rightArray == null)
            rightArray = new int[0];
        if (isMaxValueSize(leftArray))
            leftArray = new int[0];
        if (isMaxValueSize(rightArray))
            rightArray = new int[0];

        if (isEmpty(leftArray) && isEmpty(rightArray)) {
            return leftArray;
        }
        if (isEmpty(leftArray)) {
            return noDup(rightArray);
        }
        if (isEmpty(rightArray)) {
            return noDup(leftArray);
        }
        return noDup(arrayMerge(leftArray, rightArray));
    }

    public Product[] mergeProduct(Product[] prod1, Product[] prod2) {
        return productMerge(prod1, prod2);
    }
    public int[] innerUnion(int[] leftArray, int[] rightArray) {

        if (leftArray == null)
            leftArray = new int[0];
        if (rightArray == null)
            rightArray = new int[0];

        if (isEmpty(leftArray) || isEmpty(rightArray)) {
            return new int[0];
        }
        int count = 0;
        int minLength = (leftArray.length < rightArray.length) ? leftArray.length : rightArray.length;
        int[] tempArray = new int[minLength];

        for (int i : rightArray) {
            if (contains(i, leftArray) && !contains(i, tempArray)) {
                tempArray[count] = i;
                count++;
            }
        }
        return trim(tempArray, count);
    }
    public int[] outerUnion(int[] leftArray, int[] rightArray) {

        if (leftArray == null)
            leftArray = new int[0];
        if (rightArray == null)
            rightArray = new int[0];
        int count = 0;

        int[] tempArray = new int[leftArray.length + rightArray.length];
        for (int i : leftArray) {
            if (!(contains(i, rightArray) || contains(i, tempArray))) {
                tempArray[count] = i;
                count++;
            }
        }
        for (int i : rightArray) {
            if (!(contains(i, leftArray) || contains(i, tempArray))) {
                tempArray[count] = i;
                count++;
            }
        }
        return trim(tempArray, count);
    }
    private boolean contains(int el, int[] array) {
        boolean res = false;
        for (int i : array){
            if (el == i)
                res = true;
        }
        return res;

    }
    private int absSum(int[] array) {
        int sum = 0;
        for (int i : array) {
            sum += Math.abs(i);
        }
        return sum;
    }
    private boolean isEmpty(int[] array) {
        if(array.length == 0)
            return true;
        if (absSum(array) == 0)
            return true;
        else
            return false;
    }
    private int[] noDup(int[] array) {
        int count = 0;
        int[] tempArray = new int[array.length];
        for (int i : array) {
            if (!contains(i, tempArray)) {
                tempArray[count] = i;
                count++;
            }
        }

        return trim(tempArray, count);

    }
    private int[] arrayMerge(int[] leftArray, int[] rightArray) {
        int[] res = new int[leftArray.length + rightArray.length];
        int index1 = 0;
        for (int i : leftArray) {
            res[index1] = i;
            index1++;
        }
        for (int i = leftArray.length;i < res.length;i++) {
            res[i] = rightArray[i - leftArray.length];
        }
        return res;
    }
    private Product[] productMerge(Product[] prod1, Product[] prod2) {
        Product[] res = new Product[prod1.length + prod2.length];
        int index = 0;
        for (Product p : prod1) {
            res[index] = p;
            index++;
        }
        for (int i = prod1.length;i < res.length;i++) {
            res[i] = prod2[i - prod1.length];
        }
        return res;
    }
    private int[] trim(int[] array, int length) {
        int[] res = new int[length];
        for (int i = 0;i < res.length;i++) {
            res[i] = array[i];
        }
        return res;
    }
    private boolean isMaxValueSize(int[] array) {
        Integer length = Integer.valueOf(array.length);
        if (length.equals(Integer.MAX_VALUE))
            return true;
        else
            return false;
    }
}
