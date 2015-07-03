package uk.gov.gds.performance.collector;

import com.equalexperts.logging.OpsLogger;

import static uk.gov.gds.performance.collector.CollectorLogMessage.SUCCESS;
import static uk.gov.gds.performance.collector.CollectorLogMessage.UNKNOWN_ERROR;

public class ClassThatLogs {
    private final OpsLogger<CollectorLogMessage> logger;

    @javax.inject.Inject
    public ClassThatLogs(OpsLogger<CollectorLogMessage> logger) {
        this.logger = logger;
    }

    public void logSuccess() {
        logger.log(SUCCESS, 42);
    }

    public void logException() {
        RuntimeException e = new RuntimeException();
        logger.log(UNKNOWN_ERROR, e);
        throw e;
    }

    public void baz() {

    }
}
