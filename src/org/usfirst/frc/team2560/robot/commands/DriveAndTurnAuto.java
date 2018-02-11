package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class DriveAndTurnAuto extends CommandGroup {

    public DriveAndTurnAuto() 
    {
        addSequential(new DriveForwardGyroAndEncoder(120, 0.5));
        Timer.delay(2);
        addSequential(new Turn(90));
    }
}
