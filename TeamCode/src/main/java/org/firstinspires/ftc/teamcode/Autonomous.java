package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.Callable;

/**
 * Main Autonomous Class
 * Created by James on 2016-10-09.
 */

@com.qualcomm.robotcore.eventloop.opmode.Autonomous(name="Autonomous")
public class Autonomous extends LinearOpMode {

    private Robot robot = new Robot("proto1", new Callable<Boolean>() {
        @Override
        public Boolean call() throws Exception {
            return opModeIsActive();
        }
    });

    //TODO: Define Path List
    private HashMap<String, PathBase> pathList = new HashMap<>( );
    private PathBase selectedPath;

    private int delay; //delay is in milliseconds

    @Override
    public void runOpMode() throws InterruptedException {
        //Register paths
        pathList.put("Blue Forward To Centre", new ForwardToCentre(robot, Alliance.BLUE, new Coordinate(0, 0)));
        pathList.put("Ball Knocker", new BallKnocker(robot, Alliance.NA, new Coordinate(0, 0)));

        //Run configuration

        //Select Path
        Set<String> strPathList = pathList.keySet();
        selectedPath = pathList.get("Ball Knocker");

        waitForStart();

        //Run selected path
        selectedPath.run();
    }
}
