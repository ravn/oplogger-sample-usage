package com.github.users.ravn.opslogger;

import dagger.Component;
import uk.gov.gds.performance.collector.ClassThatLogs;

import javax.inject.Singleton;

public class TestMain {
    @Singleton
    @Component(modules = {TestMainModule.class})
    public interface ClassThatLogsMaker {
        ClassThatLogs maker();
    }

    public static void main(String... args) {

        ClassThatLogs classThatLogs = DaggerTestMain_ClassThatLogsMaker.builder().build().maker();
        classThatLogs.logSuccess();
        System.exit(1);
    }
}