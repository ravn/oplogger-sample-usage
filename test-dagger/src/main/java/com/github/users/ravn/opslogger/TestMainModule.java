package com.github.users.ravn.opslogger;

import com.equalexperts.logging.LogMessage;
import com.equalexperts.logging.OpsLogger;
import com.equalexperts.logging.OpsLoggerFactory;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.nio.file.Paths;
import java.util.concurrent.atomic.AtomicLong;

@Module
public class TestMainModule {
    static AtomicLong invocations = new AtomicLong();
    @Provides
    @Singleton
    OpsLogger<uk.gov.gds.performance.collector.CollectorLogMessages> provideOpsLogger() {
        System.out.println(">>> provideOpsLogger() <<<");
        if (invocations.incrementAndGet() != 1) {
            System.out.println("Invocated more than once");
        }
        return new OpsLoggerFactory()
                .setDestination(System.out)
                .setStackTraceStoragePath(Paths.get("/tmp/stacktraces"))
                .build();
    }
}
