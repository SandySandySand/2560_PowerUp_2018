package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveForward extends Command {

    private double power;
	
	public DriveForward(double power) //inputs power parameter from user
    {
        //requires(Robot.drivetrain);
        this.power = power; //turns the power parameter to the private power variable making it a global-eque variable
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	//Robot.drivetrain.tankDrive(power, power);	//drives forward using the power set by the user
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	//Robot.drivetrain.stop(); //stops both motors
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end(); //follows command in end method
    }
}
