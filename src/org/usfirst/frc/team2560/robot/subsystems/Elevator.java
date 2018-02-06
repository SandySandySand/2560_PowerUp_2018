package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.RobotMap;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem 
{
	
    private Spark lift;
    
    public Elevator()
    {
    	lift = new Spark(RobotMap.elevator);
    }

    public void liftUp(double power)
    {
    	lift.set(power);
    }
    
    public void goDown(double power)
    {
    	lift.set(-power);
    }
    
    public void stop()
    {
    	lift.set(0);
    }
    
    public void initDefaultCommand() 
    {
        
    }
}

