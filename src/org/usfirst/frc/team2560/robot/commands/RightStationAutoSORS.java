package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightStationAutoSORS extends CommandGroup 
{

    public RightStationAutoSORS() 
    {
    	addSequential(new LiftUp(), 1.7); //lifts elevator, dropping cube
        addSequential(new UnsetBothSolenoids(), 0.2); //allows the claw to open
        addSequential(new StopLift(), 0.6);//stops the lift for a second
        addSequential(new GoDown(), 0.8); //drops lifter
        addSequential(new SetBothSolenoids(), 0.1); //grabs POWER CUBE
        addSequential(new StopLift(), 0.6); //stops lift after grabbing of POWER CUBE
        addSequential(new LiftUp(), 0.8); //lifts elevator
        //end of cube sequence auto things
        addSequential(new ResetEncoders(), 0.2); //sets encoders at 0 for proper calculation
		addSequential(new DriveForwardEncoder(160, 0.65)); //drives close to switch NOTE: Value 190inches, works for scale
		addSequential(new Turn(-90)); //turns left 90 degrees
        addSequential(new ResetEncoders(), 0.2); //sets encoders at 0 for proper calculation
        addSequential(new DriveForwardEncoder(24, 0.65)); //drives up to switch wall
        //end of driving sequence
		addSequential(new LiftUp(), 1.5); //lifts elevator high enough for switch
		addSequential(new UnsetBothSolenoids(), 0.1); //drops cube
    }
}
