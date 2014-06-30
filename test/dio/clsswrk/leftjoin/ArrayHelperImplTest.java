package dio.clsswrk.leftjoin;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertArrayEquals;

public class ArrayHelperImplTest {
    private  ArrayHelper testClass;

    @Before
    public void setup()
    {
        testClass = new ArrayHelperImpl();
    }
//    int[] leftArray = new int[]{1, 5, 4, 23, 65, 32, 78};
//    int[] rightArray = new int[]{3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
//    int[] test = new int[]{1,5,4,23,65,32,78,5,4,1,32,5};
    @Test
    public void testLeftUnion() throws Exception {
        //initialize variables inputs
        int[] leftArray = new int[]{1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = new int[]{3, 5, 24, 4, 1, 2, 34, 45, 32, 5};

        int[] expectedValue = new int[]{1,5,4,23,65,32,78,5,4,1,32,5};
        //initialize mocks

        //initialize class to test
        //ArrayHelperImpl testClass = new ArrayHelperImpl();

        //Invoke method on class to test
        int[] returnedValue = testClass.leftUnion(leftArray, rightArray);

        //assert return value

        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testLeftUnion_RightArrayIsEmpty() throws Exception
    {
        //initialize variables inputs
        int[] leftArray = new int[]{1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = new int[0];

        int[] expectedValue = new int[]{1, 5, 4, 23, 65, 32, 78};

        //initialize mocks

        //initialize class to test
        //ArrayHelperImpl testClass = new ArrayHelperImpl();

        //Invoke method on class to test
        int[] returnedValue = testClass.leftUnion(leftArray, rightArray);

        //assert return value

        assertArrayEquals(expectedValue, returnedValue);


    }
    @Test
    public void testLeftUnion_LeftArrayIsEmpty() throws Exception {
        int[] leftArray = new int[0];
        int[] rightArray = new int[]{3, 5, 24, 4, 1, 2, 34, 45, 32, 5};

        int[] expectedValue = new int[0];
        //Invoke method on class to test
        int[] returnedValue = testClass.leftUnion(leftArray, rightArray);
        //assert return value

        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testLeftUnion_NullRightArray() throws Exception {
        int[] leftArray = new int[]{1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = null;
        int[] expectedValue = new int[]{1, 5, 4, 23, 65, 32, 78};
        int[] returnedValue = testClass.leftUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testLeftUnion_NullLeftArray() throws Exception {
        int[] leftArray = null;
        int[] rightArray = new int[]{3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedValue = new int[0];
        int[] returnedValue = testClass.leftUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testLeftUnion_ZeroRightArray() throws Exception {
        int[] leftArray = new int[]{1, 5, 4, 23, 65, 32, 78};
        int[] rightArray = new int[7];
        int[] expectedValue = new int[]{1, 5, 4, 23, 65, 32, 78};
        int[] returnedValue = testClass.leftUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testLeftUnion_ZeroLeftArray() throws Exception {
        int[] leftArray = new int[5];
        int[] rightArray = new int[]{3, 5, 24, 4, 1, 2, 34, 45, 32, 5};
        int[] expectedValue = new int[5];
        int[] returnedValue = testClass.leftUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }


    @Test
    public void testMerge() throws Exception {
        int[] leftArray = new int[]{1,5,4,23,65,32,78};
        int[] rightArray = new int[]{3,5,24,54,1,2,34,45,32};

        int[] expectedValue = new int[]{1,5,4,23,65,32,78,3,24,54,2,34,45};
        //Invoke method on class to test
        int[] returnedValue = testClass.merge(leftArray, rightArray);
        //assert return value

        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testMerge_RightArrayIsEmpty() throws Exception {
        int[] leftArray = new int[]{1,5,4,23,65,32,78};
        int[] rightArray = new int[0];
        int[] expectedValue = new int[]{1,5,4,23,65,32,78};
        int[] returnedValue = testClass.merge(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testMerge_LeftArrayIsEmpty() throws Exception {
        int[] leftArray = new int[0];
        int[] rightArray = new int[]{3,5,24,54,1,2,34,45,32};
        int[] expectedValue = new int[]{3,5,24,54,1,2,34,45,32};
        int[] returnedValue = testClass.merge(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testMerge_RightArrayIsNull() throws Exception {
        int[] leftArray = new int[]{1,5,4,23,65,32,78};
        int[] rightArray = null;
        int[] expectedValue = new int[]{1,5,4,23,65,32,78};
        int[] returnedValue = testClass.merge(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testMerge_LeftArrayIsNull() throws Exception {
        int[] leftArray = null;
        int[] rightArray = new int[]{3,5,24,54,1,2,34,45,32};
        int[] expectedValue = new int[]{3,5,24,54,1,2,34,45,32};
        int[] returnedValue = testClass.merge(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testMerge_Duplicate() throws Exception {
        int[] leftArray = new int[]{1,2,1,3,4,3,5,4,6};
        int[] rightArray = new int[]{7,8,7,9,8,10,5,1,2};

        int[] expectedValue = new int[]{1,2,3,4,5,6,7,8,9,10};
        //Invoke method on class to test
        int[] returnedValue = testClass.merge(leftArray, rightArray);
        //assert return value

        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testInnerUnion() throws Exception {
        int[] leftArray = new int[]{1,5,4,23,65,32,78};
        int[] rightArray = new int[]{3,5,24,4,1,2,34,45,32,5};
        int[] expectedValue = new int[]{5,4,1,32};
        int[] returnedValue = testClass.innerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testInnerUnion_RightArrayIsEmpty() throws Exception {
        int[] leftArray = new int[]{1,5,4,23,65,32,78};
        int[] rightArray = new int[0];
        int[] expectedValue = new int[0];
        int[] returnedValue = testClass.innerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testInnerUnion_LeftArrayIsEmpty() throws Exception {
        int[] leftArray = new int[0];
        int[] rightArray = new int[]{3,5,24,4,1,2,34,45,32,5};
        int[] expectedValue = new int[0];
        int[] returnedValue = testClass.innerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testInnerUnion_RightArrayIsNull() throws Exception {
        int[] leftArray = new int[]{1,5,4,23,65,32,78};
        int[] rightArray = null;
        int[] expectedValue = new int[0];
        int[] returnedValue = testClass.innerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testInnerUnion_LeftArrayIsNull() throws Exception {
        int[] leftArray = null;
        int[] rightArray = new int[]{3,5,24,4,1,2,34,45,32,5};
        int[] expectedValue = new int[0];
        int[] returnedValue = testClass.innerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testInnerUnion_Duplicate() throws Exception {
        int[] leftArray = new int[]{1,1,3,3,2,2,5,5};
        int[] rightArray = new int[]{3,5,24,4,1,2,34,45,32,5};
        int[] expectedValue = new int[]{3,5,1,2};
        int[] returnedValue = testClass.innerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testOuterUnion() throws Exception {
        int[] leftArray = new int[]{1,5,4,23,65,32,78};
        int[] rightArray = new int[]{3,5,24,4,1,2,34,45,32,5};
        int[] expectedValue = new int[]{23,65,78,3,24,2,34,45};
        int[] returnedValue = testClass.outerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testOuterUnion_RightArrayIsEmpty() throws Exception {
        int[] leftArray = new int[]{1,5,4,23,65,32,78};
        int[] rightArray = new int[0];
        int[] expectedValue = new int[]{1,5,4,23,65,32,78};
        int[] returnedValue = testClass.outerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testOuterUnion_LeftArrayIsEmpty() throws Exception {
        int[] leftArray = new int[0];
        int[] rightArray = new int[]{3,5,24,4,1,2,34,45,32,5};
        int[] expectedValue = new int[]{3,5,24,4,1,2,34,45,32};
        int[] returnedValue = testClass.outerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testOuterUnion_RightArrayIsNull() throws Exception {
        int[] leftArray = new int[]{1,5,4,23,65,32,78};
        int[] rightArray = null;
        int[] expectedValue = new int[]{1,5,4,23,65,32,78};
        int[] returnedValue = testClass.outerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testOuterUnion_LeftArrayIsNull() throws Exception {
        int[] leftArray = null;
        int[] rightArray = new int[]{3,5,24,4,1,2,34,45,32,5};
        int[] expectedValue = new int[]{3,5,24,4,1,2,34,45,32};
        int[] returnedValue = testClass.outerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
    @Test
    public void testOuterUnion_Duplicate() throws Exception {
        int[] leftArray = new int[]{1,5,4,3,2,1,5,22,4};
        int[] rightArray = new int[]{9,10,5,17,7,12,6};
        int[] expectedValue = new int[]{1, 4, 3, 2, 22, 9, 10, 17, 7, 12, 6};
        int[] returnedValue = testClass.outerUnion(leftArray, rightArray);
        assertArrayEquals(expectedValue, returnedValue);
    }
}