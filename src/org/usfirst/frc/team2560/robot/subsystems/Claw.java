package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.RobotMap;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem 
{

    private Solenoid soleOne, soleTwo;
    
    public Claw()
    {
    	soleOne = new Solenoid(RobotMap.soleone);
    	soleTwo = new Solenoid(RobotMap.soletwo);
    }
    
    public void setSoleOne()
    {
    	soleOne.set(true);
    }
    
    public void setSoleTwo()
    {
    	soleTwo.set(true);
    }
    
    public void unsetSoleOne()
    {
    	soleOne.set(false);
    }
    
    public void unsetSoleTwo()
    {
    	soleTwo.set(false);
    }

    public void initDefaultCommand()
    {

    }
}

