package frc.robot.maps;

import com.chopshop166.chopshoplib.maps.DifferentialDriveMap;
import com.chopshop166.chopshoplib.motors.SmartMotorController;

public class RobotMap {

    public DifferentialDriveMap getDriveMap() {
        return new DifferentialDriveMap(new SmartMotorController(), new SmartMotorController(), 1.0);
    }

    // Add an Intake Map with a IDSolenoid
    // and a Motor Controller
    public static class IntakeMap {
    }
}
