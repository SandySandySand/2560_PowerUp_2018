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
    	addSequential(new LiftUp(), 0.8); //lifts elevator, dropping cube
        addSequential(new UnsetBothSolenoids()); //allows the claw to open
        addSequential(new GoDown(), 0.8); //drops lifter
        addSequential(new SetBothSolenoids()); //grabs POWER CUBE
    }
}
