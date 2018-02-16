package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class LeftStationAutoSO extends CommandGroup {

    public LeftStationAutoSO() 
    {
    	String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
        if(gameData.length() > 0)
        {
		  if(gameData.charAt(0) == 'L')
		  {
			addSequential(new DriveForwardEncoder(190, 0.8)); //drives close to switch
			addSequential(new Turn(90)); //turns 90 degrees 
			addSequential(new LiftUp(), 3.0); //lifts elevator high enough for switch
			addSequential(new UnsetBothSolenoids()); //drops cube
		  } 
		  else 
		  {
			addSequential(new DriveForwardEncoder(92, 0.8)); //drives close to switch
			addSequential(new Turn(90)); //turns 90 degrees 
			addSequential(new DriveForwardEncoder(168, 0.8)); //drives across field
			addSequential(new Turn(90)); //turns 90 degrees
			addSequential(new DriveForwardEncoder(166, 0.8)); //drives to edge of switch
			addSequential(new Turn(90)); //turns 90 degrees
			addSequential(new DriveForwardEncoder(12, 0.8)); //drives right up to switch
			addSequential(new LiftUp(), 3.0); //lifts elevator high enough for switch
			addSequential(new UnsetBothSolenoids()); //drops cube
		  }
        }
    	
    	
    }
}
