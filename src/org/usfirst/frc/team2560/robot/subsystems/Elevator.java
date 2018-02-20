package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.Robot;
import org.usfirst.frc.team2560.robot.RobotMap;
import org.usfirst.frc.team2560.robot.commands.StopLift;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem 
{
	
    private Spark lift;
    private DigitalInput limitSwitch;
    
    public Elevator()
    {
    	lift = new Spark(RobotMap.elevator);
    	limitSwitch = new DigitalInput(RobotMap.limit);
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
    
    //limit switch things
    public boolean getLSValue()
    {
    	return limitSwitch.get();
    }
    
    public void initDefaultCommand() 
    {
    	// TODO Auto-generated method stub
    	 //setDefaultCommand(new stopLift());
    }
}

