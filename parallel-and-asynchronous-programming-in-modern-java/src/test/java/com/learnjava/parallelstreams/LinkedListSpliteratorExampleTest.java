package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListSpliteratorExampleTest {

    LinkedListSpliteratorExample linkedListSpliteratorExample = new LinkedListSpliteratorExample();

    @RepeatedTest(5)
    void multipleEachValue() {

        int maxNumberOfItems = 1000000;
        LinkedList<Integer> inputList = DataSet.generateIntegerLinkedList(maxNumberOfItems);

        List<Integer> resultList = linkedListSpliteratorExample.multipleEachValue(inputList, maxNumberOfItems, false);

        assertEquals(maxNumberOfItems, resultList.size());

    }

    @RepeatedTest(5)
    void multipleEachValueParallel() {

        int maxNumberOfItems = 1000000;
        LinkedList<Integer> inputList = DataSet.generateIntegerLinkedList(maxNumberOfItems);

        List<Integer> resultList = linkedListSpliteratorExample.multipleEachValue(inputList, maxNumberOfItems, true);

        assertEquals(maxNumberOfItems, resultList.size());

    }
}