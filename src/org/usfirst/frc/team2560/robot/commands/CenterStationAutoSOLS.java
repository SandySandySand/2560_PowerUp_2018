package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterStationAutoSOLS extends CommandGroup 
{

    public CenterStationAutoSOLS() 
    {
    	addSequential(new LiftUp(), 1.7); //lifts elevator, dropping cube
        addSequential(new UnsetBothSolenoids(), 0.2); //allows the claw to open
        addSequential(new StopLift(), 0.6);//stops the lift for a second
        addSequential(new GoDown(), 0.8); //drops lifter
        addSequential(new SetBothSolenoids(), 0.1); //grabs POWER CUBE
        addSequential(new StopLift(), 0.6); //stops lift after grabbing of POWER CUBE
        addSequential(new LiftUp(), 0.8); //lifts elevator
        //end of cube sequence auto things
        addSequential(new ResetEncoders(), 0.1);//sets encoders at 0 for proper calculation
        addSequential(new DriveForwardEncoder(48, 0.5));//drives forward at half speed
        addSequential(new Turn(-90)); //makes a 90 degree left turn
        addSequential(new ResetEncoders(), 0.1);//sets encoders at 0 for proper calculation
        addSequential(new DriveForwardEncoder(48, 0.5)); //drives to left side
        addSequential(new Turn(90)); //makes a right turn
        addSequential(new ResetEncoders(), 0.1);//sets encoders at 0 for proper calculation
        addSequential(new DriveForwardEncoder(48, 0.5));//drives right up to the switch
        //end of driving sequence
        addSequential(new LiftUp(), 2.0); //lifts higher than the switch
        addSequential(new UnsetBothSolenoids(), 0.1); //drops cube
    }
}
