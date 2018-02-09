package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem 
{

    private DoubleSolenoid clawSole;
    
    public Claw()
    {
    	clawSole = new DoubleSolenoid(RobotMap.soleportone, RobotMap.soleporttwo);
    }
    
    public void setSoleOne()
    {
    	clawSole.set(DoubleSolenoid.Value.kForward);
    }
    
    public void unsetSoleOne()
    {
    	clawSole.set(DoubleSolenoid.Value.kReverse);
    }
    
    public void offSole()
    {
    	clawSole.set(DoubleSolenoid.Value.kOff);
    }
    
    public void initDefaultCommand()
    {

    }
}

