package iot.restapi;

import com.amazonaws.services.iot.client.AWSIotException;
import iot.domain.*;
import iot.repos.LocationRepository;
import iot.service.VesselSimulatorService;
import iot.util.CsvUtil;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class VesselIoTSimulator {
    private static final Logger logger = LoggerFactory.getLogger(VesselIoTSimulator.class);
    private Track track;
    private VesselSimulatorService vesselSimulatorService;

    public VesselIoTSimulator(VesselSimulatorService vesselSimulatorService , @Value("${vessel.vid}") String vid) throws IOException {
        this.vesselSimulatorService = vesselSimulatorService;
        this.track = vesselSimulatorService.readRawData(vid);
    }


    public void start() throws InterruptedException, IOException, AWSIotException {
        vesselSimulatorService.setVesselIoTSimulator(this);
        vesselSimulatorService.initIoTData();
        vesselSimulatorService.start();
    }
}
