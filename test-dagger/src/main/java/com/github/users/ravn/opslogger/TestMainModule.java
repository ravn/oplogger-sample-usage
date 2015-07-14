package com.github.users.ravn.opslogger;

import com.equalexperts.logging.LogMessage;
import com.equalexperts.logging.OpsLogger;
import com.equalexperts.logging.OpsLoggerFactory;
import dagger.Module;
import dagger.Provides;

import javax.inject.Singleton;
import java.nio.file.Paths;

@Module
public class TestMainModule {
    @Provides
    @Singleton
    OpsLogger<uk.gov.gds.performance.collector.CollectorLogMessages> provideOpsLogger() {
        return new OpsLoggerFactory()
                .setDestination(System.out)
                .setStackTraceStoragePath(Paths.get("/tmp/stacktraces"))
                .build();
    }
}
