// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.DoubleSupplier;

import com.chopshop166.chopshoplib.commands.CommandRobot;
import com.chopshop166.chopshoplib.controls.ButtonXboxController;
import com.chopshop166.chopshoplib.controls.ButtonXboxController.Direction;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.XboxController.Button;
import frc.robot.maps.RobotMap;
import frc.robot.subsystems.CounterSubsystem;
import frc.robot.subsystems.Drive;
import io.github.oblarg.oblog.Logger;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends CommandRobot {

    private final ButtonXboxController controller = new ButtonXboxController(0);
    private final CounterSubsystem counterA = new CounterSubsystem("A");
    private final CounterSubsystem counterB = new CounterSubsystem("B");

    private final RobotMap map = getMapForName("Francois", RobotMap.class, "frc.robot.maps");

    private final Drive drive = new Drive(map.getDriveMap());

    /** Set up the button bindings. */
    @Override
    public void configureButtonBindings() {
        controller.getButton(Button.kA).whenPressed(counterA.increment());
        controller.getButton(Button.kB).whenPressed(parallel("Run stuff",counterA.incrementWhileRunning(), sequence("Wait then increment b", counterA.check(50), counterB.incrementWhileRunning()));
        controller.getButton(Button.kX).whenPressed(counterA.print());
        controller.getPovButton(Direction.Up).whenPressed(counterB.increment());
        controller.getPovButton(Direction.Left).whenPressed(counterB.print());
        controller.getPovButton(Direction.Down).whenPressed(counterB.decrement());
    }

    /** Send commands and data to Shuffleboard. */
    @Override
    public void populateDashboard() {
    }

    /** Set the default commands for each subsystem. */
    @Override
    public void setDefaultCommands() {
        drive.setDefaultCommand(drive.arcadeDrive(() -> controller.getTriggers(), () -> controller.getX(Hand.kLeft)));
    }

    /**
     * This function is run when the robot is first started up and should be used
     * for any initialization code.
     */
    @Override
    public void robotInit() {
        super.robotInit();
        Logger.configureLoggingAndConfig(this, false);
    }

    @Override
    public void robotPeriodic() {
        super.robotPeriodic();
        Logger.updateEntries();
    }
}
