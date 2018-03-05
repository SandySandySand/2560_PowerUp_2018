package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class EveryAutoStart extends CommandGroup 
{

	//This is the start to every auto, one that will move the lift and claw allowing us to get the cube.
    public EveryAutoStart() 
    {
    	addSequential(new LiftUp(), 1.7); //lifts elevator, dropping cube
        addSequential(new UnsetBothSolenoids(), 0.2); //allows the claw to open
        addSequential(new StopLift(), 0.6);//stops the lift for a second
        addSequential(new GoDown(), 0.8); //drops lifter
        addSequential(new SetBothSolenoids(), 0.1); //grabs POWER CUBE
        addSequential(new StopLift(), 0.6); //stops lift after grabbing of POWER CUBE
        addSequential(new LiftUp(), 0.8); //lifts elevator
    }
}
