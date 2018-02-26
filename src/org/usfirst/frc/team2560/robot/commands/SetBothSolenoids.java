package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetBothSolenoids extends Command {

    public SetBothSolenoids() 
    {
        requires(Robot.claw);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Robot.claw.setSoleOne();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.claw.offSole();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
