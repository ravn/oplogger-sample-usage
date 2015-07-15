package com.github.users.ravn.opslogger;

import dagger.Component;
import uk.gov.gds.performance.collector.ClassThatLogs;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

public class TestMain {
    @Singleton
    @Component(modules = {TestMainModule.class})
    public interface ClassThatLogsMaker {
        ClassThatLogs maker();
    }

    public static void main(String... args) {
        Map<String, String> map = new HashMap<>();
        map.put(TestMainModule.CLASS_TYPE, "*Ok*");
        ClassThatLogsMaker maker = DaggerTestMain_ClassThatLogsMaker.builder().testMainModule(new TestMainModule(map)).build();
        maker.maker().logSuccess();
        //maker.maker().logException();
        System.exit(1);
    }
}