package frc.robot.maps;

import com.chopshop166.chopshoplib.maps.DifferentialDriveMap;
import com.chopshop166.chopshoplib.maps.RobotMapFor;
import com.chopshop166.chopshoplib.outputs.PIDSparkMax;
import com.chopshop166.chopshoplib.outputs.SmartMotorController;
import com.chopshop166.chopshoplib.sensors.MockGyro;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.SpeedControllerGroup;

@RobotMapFor("Francois")
public class FrancoisMap extends RobotMap {

    @Override
    public DifferentialDriveMap getDriveMap() {
        PIDSparkMax frontLeft = new PIDSparkMax(29, MotorType.kBrushless);
        PIDSparkMax rearLeft = new PIDSparkMax(25, MotorType.kBrushless);

        PIDSparkMax frontRight = new PIDSparkMax(27, MotorType.kBrushless);
        PIDSparkMax rearRight = new PIDSparkMax(22, MotorType.kBrushless);

        SpeedControllerGroup leftGroup = new SpeedControllerGroup(frontLeft, rearLeft);
        SpeedControllerGroup rightGroup = new SpeedControllerGroup(frontRight, rearRight);

        return new DifferentialDriveMap(new SmartMotorController(leftGroup), new SmartMotorController(rightGroup), 1.0,
                new MockGyro());
    }
}
