package dio.clsswrk.leftjoin;

import java.util.Arrays;

/**
 * Created by Димон on 24.06.2014.
 */
public class Main {
    public static void main(String[] args) {

        ArrayHelperDelegate arrayHelperDelegate = new ArrayHelperDelegate(new ArrayHelperImpl());
        Product[] leftprods = new Product[4];
        Product[] rightprods = new Product[4];
        leftprods[0] = new Product.Builder().name("Samsung")
                .category(Category.SMARTPHONE)
                .price(299.99)
                .height(30)
                .length(20)
                .weight(60)
                .width(20)
                .build();
        leftprods[1] = new Product.Builder().name("Samsung")
                .category(Category.SMARTPHONE)
                .price(299.99)
                .height(30)
                .length(20)
                .weight(60)
                .width(20)
                .build();
        leftprods[2] = new Product.Builder().name("HP")
                .category(Category.SERVER)
                .price(15000)
                .height(300)
                .length(200)
                .weight(2000)
                .width(200)
                .build();
        leftprods[3] = new Product.Builder().name("Gigabyte")
                .category(Category.DESKTOP)
                .price(500)
                .height(150)
                .length(200)
                .weight(2000)
                .width(200)
                .build();
        rightprods[0] = new Product.Builder().name("SonyEricson")
                .category(Category.SMARTPHONE)
                .price(299.99)
                .height(30)
                .length(20)
                .weight(60)
                .width(20)
                .build();
        rightprods[1] = new Product.Builder().name("Samsung")
                .category(Category.SMARTPHONE)
                .price(299.99)
                .height(30)
                .length(20)
                .weight(60)
                .width(20)
                .build();
        rightprods[2] = new Product.Builder().name("HP")
                .category(Category.SERVER)
                .price(15000)
                .height(300)
                .length(200)
                .weight(2000)
                .width(200)
                .build();
        rightprods[3] = new Product.Builder().name("HP")
                .category(Category.SERVER)
                .price(15000)
                .height(300)
                .length(200)
                .weight(2000)
                .width(200)
                .build();
        Product[] test = new Product[4];
        test[0] = new Product.Builder().name("Samsung")
                .category(Category.SMARTPHONE)
                .price(299.99)
                .height(30)
                .length(20)
                .weight(60)
                .width(20)
                .build();
        test[1] = new Product.Builder().name("HP")
                .category(Category.SERVER)
                .price(15000)
                .height(300)
                .length(200)
                .weight(2000)
                .width(200)
                .build();
        test[2] = new Product.Builder().name("Gigabyte")
                .category(Category.DESKTOP)
                .price(500)
                .height(150)
                .length(200)
                .weight(2000)
                .width(200)
                .build();
        test[3] = new Product.Builder().name("SonyEricson")
                .category(Category.SMARTPHONE)
                .price(299.99)
                .height(30)
                .length(20)
                .weight(60)
                .width(20)
                .build();

        Product[] result = arrayHelperDelegate.mergeProduct(leftprods, rightprods);
        System.out.println(Arrays.toString(test));
        System.out.println(Arrays.toString(result));

        System.out.println(Arrays.equals(result, test));






//
//        ArrayHelper arrayHelper = new ArrayHelperImpl();
//        res = arrayHelper.leftUnion(leftArray, rightArray);
//        System.out.println(Arrays.toString(res));
//        System.out.println(Arrays.equals(res, test));
//        //merge test
//        leftArray = new int[]{1,2,1,3,4,3,5,4,6};
//        rightArray = new int[]{7,8,7,9,8,10,5,1,2};
//        test = new int[]{1,2,3,4,5,6,7,8,9,10};
//        res = arrayHelper.merge(leftArray, rightArray);
//        System.out.println(Arrays.toString(res));
//        System.out.println(Arrays.equals(res, test));
//        leftArray = new int[]{1,5,4,23,65,32,78};
//        rightArray = new int[]{3,5,24,4,1,2,34,45,32,5};
//        test = new int[]{5,4,32,1};
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
