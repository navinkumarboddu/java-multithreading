package com.learnjava.parallelstreams;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ReduceExampleTest {

    ReduceExample reduceExample = new ReduceExample();

    @Test
    void reduce_sum_ParallelStream() {

        List<Integer> inputList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        int result = reduceExample.reduce_sum_ParallelStream(inputList);
        assertEquals(36, result);
    }

    @Test
    void reduce_sum_parallelStream_emptyList() {

        List<Integer> inputList = new ArrayList<>();

        int result = reduceExample.reduce_sum_ParallelStream(inputList);

        assertEquals(0, result);
    }

    @Test
    void reduce_multiply_parallelStream() {

        List<Integer> inputList = Arrays.asList(1, 2, 3, 4);

        int result = reduceExample.reduce_multiply_parallelStream(inputList);

        assertEquals(24, result);
    }

    @Test
    void reduce_multiply_parallelStream_emptyList() {

        List<Integer> inputList = new ArrayList<>();

        int result = reduceExample.reduce_multiply_parallelStream(inputList);

        assertEquals(1, result);
    }
}