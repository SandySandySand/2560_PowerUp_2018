package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftStationAutoSORS extends CommandGroup 
{

    public LeftStationAutoSORS() 
    {
    	addSequential(new LiftUp(), 1.7); //lifts elevator, dropping cube
        addSequential(new UnsetBothSolenoids(), 0.2); //allows the claw to open
        addSequential(new StopLift(), 0.6);//stops the lift for a second
        addSequential(new GoDown(), 0.8); //drops lifter
        addSequential(new SetBothSolenoids(), 0.1); //grabs POWER CUBE
        addSequential(new StopLift(), 0.6); //stops lift after grabbing of POWER CUBE
        addSequential(new LiftUp(), 0.8); //lifts elevator
        //end of cube sequence auto things
    	addSequential(new DriveForwardEncoder(92, 0.8)); //drives close to switch
		addSequential(new Turn(90)); //turns 90 degrees 
		addSequential(new DriveForwardEncoder(168, 0.8)); //drives across field
		addSequential(new Turn(-90)); //turns 90 degrees
		addSequential(new DriveForwardEncoder(166, 0.8)); //drives to edge of switch
		addSequential(new Turn(-90)); //turns 90 degrees
		addSequential(new DriveForwardEncoder(12, 0.8)); //drives right up to switch
		//end of driving sequence
		addSequential(new LiftUp(), 3.0); //lifts elevator high enough for switch
		addSequential(new UnsetBothSolenoids()); //drops cube
    }
}
