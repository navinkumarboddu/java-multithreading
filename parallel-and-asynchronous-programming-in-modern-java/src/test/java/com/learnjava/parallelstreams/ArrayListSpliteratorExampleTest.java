package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArrayListSpliteratorExampleTest {

    ArrayListSpliteratorExample arrayListSpliteratorExample = new ArrayListSpliteratorExample();

    @RepeatedTest(5)
    void multipleEachValue() {
        int maxNumberOfItems = 1000000;
        ArrayList<Integer> inputList = DataSet.generateArrayList(maxNumberOfItems);

        List<Integer> resultList = arrayListSpliteratorExample.multipleEachValue(inputList, maxNumberOfItems, false);

        assertEquals(maxNumberOfItems, resultList.size());
    }

    @RepeatedTest(5)
    void multipleEachValueParallel() {
        int maxNumberOfItems = 1000000;
        ArrayList<Integer> inputList = DataSet.generateArrayList(maxNumberOfItems);

        List<Integer> resultList = arrayListSpliteratorExample.multipleEachValue(inputList, maxNumberOfItems, true);

        assertEquals(maxNumberOfItems, resultList.size());
    }
}