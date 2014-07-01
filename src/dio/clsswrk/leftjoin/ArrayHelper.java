package dio.clsswrk.leftjoin;

/**
 * Created by Димон on 24.06.2014.
 */
public interface ArrayHelper {
    int[] leftUnion(int[] leftArray, int[] rightArray);
    int[] merge(int[] leftArray, int[] rightArray);
    int[] innerUnion(int[] leftArray, int[] rightArray);
    int[] outerUnion(int[] leftArray, int[] rightArray);
    Product[] mergeProduct(Product[] prod1, Product[] prod2);



}
