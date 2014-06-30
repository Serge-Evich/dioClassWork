package dio.clsswrk.leftjoin;

import java.util.Arrays;

/**
 * Created by Димон on 24.06.2014.
 */
public class Main {
    public static void main(String[] args) {
        //leftUnion test
        int[] leftArray = new int[]{1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = new int[]{3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] test = new int[]{1,5,4,23,65,32,78,5,4,1,32,5};
        int[] res = null;
        ArrayHelper arrayHelper = new ArrayHelperImpl();
//        res = arrayHelper.leftUnion(leftArray, rightArray);
//        System.out.println(Arrays.toString(res));
//        System.out.println(Arrays.equals(res, test));
        //merge test
        leftArray = new int[]{1,2,1,3,4,3,5,4,6};
        rightArray = new int[]{7,8,7,9,8,10,5,1,2};
        test = new int[]{1,2,3,4,5,6,7,8,9,10};
        res = arrayHelper.merge(leftArray, rightArray);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.equals(res, test));
        leftArray = new int[]{1,5,4,23,65,32,78};
        rightArray = new int[]{3,5,24,4,1,2,34,45,32,5};
        test = new int[]{5,4,32,1};
//        res = arrayHelper.innerUnion(leftArray, rightArray);
//        System.out.println(Arrays.toString(res));
//        System.out.println(Arrays.equals(res, test));
//        leftArray = new int[]{1,5,4,23,65,32,78};
//        rightArray = new int[]{3,5,24,4,1,2,34,45,32,5};
//        test = new int[]{23,65,78,3,24,2,34,45};
//        res = arrayHelper.outerUnion(leftArray, rightArray);
//        System.out.println(Arrays.toString(res));
//        System.out.println(Arrays.equals(res, test));

    }
}
