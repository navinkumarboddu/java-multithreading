package com.learnjava.parallelstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.learnjava.util.CommonUtil.startTimer;
import static com.learnjava.util.CommonUtil.timeTaken;

public class ArrayListSpliteratorExample {

    public List<Integer> multipleEachValue(ArrayList<Integer> inputList, int multiplyValue, boolean isParallel){

        startTimer();
        Stream<Integer> stream = inputList.stream();

        if(isParallel){
            stream.parallel();
        }

        List<Integer> resultList = stream
                .map(i -> i * multiplyValue)
                .collect(Collectors.toList());
        timeTaken();
        return resultList;
    }
}
