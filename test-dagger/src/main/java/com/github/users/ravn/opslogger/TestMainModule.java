package com.github.users.ravn.opslogger;

import com.equalexperts.logging.LogMessage;
import com.equalexperts.logging.OpsLogger;
import com.equalexperts.logging.OpsLoggerFactory;
import dagger.Module;
import dagger.Provides;

import javax.inject.Named;
import javax.inject.Singleton;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Module
public class TestMainModule {

    public static final String CLASS_TYPE = "ClassType";

    private final Map<String, String> configurationMap;

    public TestMainModule(Map<String, String> configurationMap) {
        this.configurationMap = Collections.unmodifiableMap(configurationMap);
    }


    @Provides
    @Singleton
    OpsLogger<uk.gov.gds.performance.collector.CollectorLogMessages> provideOpsLogger() {
        return new OpsLoggerFactory()
                .setDestination(System.out)
                .setStackTraceStoragePath(Paths.get("/tmp/stacktraces"))
                .build();
    }

    /**
     * Get class type to provide application name in log line.
     * @return
     */
    @Provides @Named(CLASS_TYPE) String provideClassType() {
        return configurationMap.get(CLASS_TYPE);
    }
}
