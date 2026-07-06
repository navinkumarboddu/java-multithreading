package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static com.learnjava.util.CommonUtil.startTimer;
import static com.learnjava.util.CommonUtil.timeTaken;
import static org.junit.jupiter.api.Assertions.*;

class ParallelStreamExampleTest {

    ParallelStreamExample parallelStreamExample = new ParallelStreamExample();

    @Test
    void stringTransform() {
        List<String> inputList = DataSet.namesList();

        startTimer();
        List<String> resultList = parallelStreamExample.stringTransform(inputList);
        timeTaken();

        assertEquals(resultList.size(), inputList.size());

        resultList.forEach(
                name -> {
                    assertTrue(name.contains("-")
                );
        });
    }

    @ParameterizedTest
    @ValueSource(booleans = {false, true})
    void stringTransform1(boolean isParallel) {
        List<String> inputList = DataSet.namesList();

        startTimer();
        List<String> resultList = parallelStreamExample.stringTransform1(inputList,isParallel);
        timeTaken();

        assertEquals(resultList.size(), inputList.size());

        resultList.forEach(
                name -> {
                    assertTrue(name.contains("-")
                    );
                });
    }
}