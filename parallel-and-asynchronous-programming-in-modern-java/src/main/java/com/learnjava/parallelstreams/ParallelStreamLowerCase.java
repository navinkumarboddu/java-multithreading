package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;

import java.util.List;
import java.util.stream.Collectors;

import static com.learnjava.util.CommonUtil.*;
import static com.learnjava.util.LoggerUtil.log;

public class ParallelStreamLowerCase {

    public static void main(String[] args) {
        List<String> names = DataSet.namesList();
        ParallelStreamLowerCase parallelStreamLowerCase = new ParallelStreamLowerCase();

        startTimer();
        List<String> resultList = parallelStreamLowerCase.string_toLowerCase(names);
        log("resultList :" + resultList);
        timeTaken();
    }

    private String toLowerCase(String input) {
        delay(500);
        return input.toLowerCase();
    }

    public List<String> string_toLowerCase(List<String> namesList) {
        return namesList.
                parallelStream()
                .map(this::toLowerCase)
                .collect(Collectors.toList());
    }
}
