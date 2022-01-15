package frc.robot.maps;

import com.chopshop166.chopshoplib.maps.DifferentialDriveMap;
import com.chopshop166.chopshoplib.outputs.SmartMotorController;
import com.chopshop166.chopshoplib.outputs.WDSolenoid;
import com.chopshop166.chopshoplib.sensors.MockGyro;

import edu.wpi.first.wpilibj.GyroBase;

public class RobotMap {
    public static class DriveMap {
        private final SmartMotorController left;
        private final SmartMotorController right;
        private final GyroBase gyro;

        public DriveMap() {
            this(new SmartMotorController(), new SmartMotorController(), new MockGyro());
        }

        public DriveMap(final SmartMotorController left, final SmartMotorController right, final GyroBase gyro) {
            this.left = left;
            this.right = right;
            this.gyro = gyro;
        }

        public SmartMotorController getLeft() {
            return left;
        }

        public SmartMotorController getRight() {
            return right;
        }

        public GyroBase getGyro() {
            return gyro;
        }
    }

    public DifferentialDriveMap getDriveMap() {
        return new DifferentialDriveMap(new SmartMotorController(), new SmartMotorController(), 1.0);
    }

    // Add an Intake Map with a IDSolenoid
    // and a Motor Controller
    public static class IntakeMap {
    }
}
