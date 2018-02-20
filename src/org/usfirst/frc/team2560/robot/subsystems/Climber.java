package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem 
{

	private Spark climb;
	
    public Climber()
    {
    	climb = new Spark(RobotMap.climber);
    }
    
    public void climbUp(double speed)
    {
    	climb.set(speed);
    }
    
    public void stopClimb()
    {
    	climb.set(0);
    }

    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

