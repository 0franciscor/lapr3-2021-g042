package lapr.project.model;

import lapr.project.mapper.dto.SummaryDto;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Date;

class SummaryTest {
    @Test
    void getMmsiCode() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getMmsiCode(), "210950000");
    }

    @Test
    void getName() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getName(), "VARAMO");
    }

    @Test
    void getStartBaseDate() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getStartBaseDate(), new Date(2020, 12, 31, 17, 19));
    }

    @Test
    void getEndBaseDate() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getEndBaseDate(), new Date(2020, 12, 24, 14, 30));

    }

    @Test
    void getTotalMovementTime() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getTotalMovementTime(), "02:30:12");
    }

    @Test
    void getTotalMovements() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getTotalMovements(), 23);
    }

    @Test
    void getMaximumSog() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getMaximumSog(), 156, 0.0);
    }

    @Test
    void getMeanSog() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getMeanSog(), 124, 0.0);
    }

    @Test
    void getMaximumCog() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getMaximumCog(), 16, 0.0);
    }

    @Test
    void getMeanCog() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getMeanCog(), 12, 0.0);
    }

    @Test
    void getDepartureLatitude() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getDepartureLatitude(), "42.97875");
    }

    @Test
    void getDepartureLongitude() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getDepartureLongitude(), "-66.97001");
    }

    @Test
    void getArrivalLatitude() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getArrivalLatitude(), "42.92236");
    }

    @Test
    void getArrivalLongitude() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getArrivalLongitude(), "-66.97243");
    }

    @Test
    void getTravelledDistance() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getTravelledDistance(), 120, 0.0);
    }

    @Test
    void getDeltaDistance() {
        Summary summary = new Summary("210950000", "VARAMO", new Date(2020, 12, 31, 17, 19), new Date(2020, 12, 24, 14, 30), "02:30:12", 23, 156, 124, 16, 12, "42.97875", "-66.97001", "42.92236", "-66.97243" , 120, 50);
        Assert.assertEquals(summary.getDeltaDistance(), 50, 0.0);
    }
}