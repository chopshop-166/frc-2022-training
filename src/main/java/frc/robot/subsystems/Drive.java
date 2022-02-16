// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.chopshop166.chopshoplib.commands.SmartSubsystemBase;
import com.chopshop166.chopshoplib.maps.DifferentialDriveMap;
import com.chopshop166.chopshoplib.motors.SmartMotorController;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Drive extends SmartSubsystemBase {

  private final SmartMotorController left;
  private final SmartMotorController right;
  private final DifferentialDrive driveTrain;

  public Drive(final DifferentialDriveMap map) {
    this.left = map.getLeft();
    this.right = map.getRight();
    driveTrain = new DifferentialDrive(left, right);
  }

  public CommandBase tankDrive(final DoubleSupplier left, final DoubleSupplier right) {
    return running("Tank Drive", () -> {
      driveTrain.tankDrive(left.getAsDouble(), right.getAsDouble());
    });
  }

  public CommandBase arcadeDrive(final DoubleSupplier forward, final DoubleSupplier rotation) {
    return running("Tank Drive", () -> {
      driveTrain.arcadeDrive(forward.getAsDouble(), rotation.getAsDouble());
    });
  }

  @Override
  public void reset() {
    // Nothing to reset here
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    // Use this for any background processing
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
  }

  @Override
  public void safeState() {

  }
}
