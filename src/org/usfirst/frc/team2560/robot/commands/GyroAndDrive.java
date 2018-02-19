package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class GyroAndDrive extends Command 
{
	double multiplier = 0.45; //power level for robot drive
	
    public GyroAndDrive() 
    {
    	//requires(Robot.drivetrain); //needs robot drivetrain subsystem to run
    }
    
    // Called just before this Command runs the first time
    protected void initialize() 
    {
    	//Robot.drivetrain.reset(); //reset gyro position
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	
    	//double angle = Robot.drivetrain.getAngle(); //gets current angle that robot is facing, hopefully 0
    	double Kp = 0.03; //PID P control variable
    	//Robot.drivetrain.gyroDrive(1*multiplier, -angle*Kp, true); //drives forwards using the gyro to correct any heading error
    	Timer.delay(0.04); //waits .04 of a second before looping
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
    	end();
    }
}
