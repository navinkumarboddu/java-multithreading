package com.learnjava.parallelstreams;

import com.learnjava.util.DataSet;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.learnjava.util.CommonUtil.*;
import static com.learnjava.util.LoggerUtil.log;

public class ParallelStreamExample {

    public List<String> stringTransform(List<String> namesList) {
        return namesList.
                parallelStream()
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    public List<String> stringTransform1(List<String> namesList, boolean isParallel) {
        Stream<String> namesStream = namesList.stream();

        if(isParallel){
            namesStream = namesStream.parallel();
        }

        return namesStream
                .map(this::addNameLengthTransform)
                .collect(Collectors.toList());
    }

    public static void main() {

        List<String> names = DataSet.namesList();
        ParallelStreamExample parallelStreamExample = new ParallelStreamExample();

        startTimer();
        List<String> resultList = parallelStreamExample.stringTransform(names);
        log("resultList :" + resultList);
        timeTaken();
    }

    private String addNameLengthTransform(String name) {
        delay(500);
        return name.length()+" - "+name ;
    }
}
