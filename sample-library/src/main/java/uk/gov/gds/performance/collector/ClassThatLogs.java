package uk.gov.gds.performance.collector;

import com.equalexperts.logging.OpsLogger;

import javax.inject.Named;

import static uk.gov.gds.performance.collector.CollectorLogMessages.SUCCESS;
import static uk.gov.gds.performance.collector.CollectorLogMessages.UNKNOWN_ERROR;

public class ClassThatLogs {
    private final OpsLogger<CollectorLogMessages> logger;
    private String classType;

    @javax.inject.Inject
    public ClassThatLogs(OpsLogger<CollectorLogMessages> logger, @Named("ClassType") String classType) {
        this.logger = logger;
        this.classType = classType;
    }

    public void logSuccess() {
        logger.log(SUCCESS, classType, 42);
    }

    public void logException() {
        RuntimeException e = new RuntimeException();
        logger.log(UNKNOWN_ERROR, e);
        throw e;
    }

    public void baz() {

    }
}
