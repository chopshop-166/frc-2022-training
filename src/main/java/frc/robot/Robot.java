// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.chopshop166.chopshoplib.commands.CommandRobot;
import com.chopshop166.chopshoplib.controls.ButtonXboxController;
import com.chopshop166.chopshoplib.controls.ButtonXboxController.POVDirection;

import frc.robot.maps.RobotMap;
import frc.robot.subsystems.CounterSubsystem;
import frc.robot.subsystems.Drive;

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
        controller.a().whenPressed(counterA.increment());
        controller.b().whenPressed(parallel("Run stuff", counterA.incrementWhileRunning(),
                sequence("Wait then increment b", counterA.check(50), counterB.incrementWhileRunning())));
        controller.x().whenPressed(counterA.print());
        controller.getPovButton(POVDirection.UP).whenPressed(counterB.increment());
        controller.getPovButton(POVDirection.LEFT).whenPressed(counterB.print());
        controller.getPovButton(POVDirection.DOWN).whenPressed(counterB.decrement());
    }

    /** Send commands and data to Shuffleboard. */
    @Override
    public void populateDashboard() {
    }

    /** Set the default commands for each subsystem. */
    @Override
    public void setDefaultCommands() {
        drive.setDefaultCommand(drive.arcadeDrive(controller::getTriggers, controller::getLeftX));
    }
}
