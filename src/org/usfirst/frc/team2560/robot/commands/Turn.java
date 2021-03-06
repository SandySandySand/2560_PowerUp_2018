package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Turn extends Command {

	private double requiredAngle;
	
    public Turn(double requiredAngle) 
    {
        requires(Robot.drivetrain); //turn robot using drive and Kp
        this.requiredAngle = requiredAngle;
    } 

    // Called just before this Command runs the first time
    protected void initialize() 
    { 
    	//Robot.drivetrain.reset();
    	Robot.drivetrain.rotatePID.setSetpoint(requiredAngle);
    	Robot.drivetrain.rotatePID.enable();
    	Robot.drivetrain.rotatePID.setAbsoluteTolerance(0.05);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double currentAngle = Robot.drivetrain.getAngle();
    	Robot.drivetrain.gyroDrive(0, Robot.drivetrain.rotatePID.get(), false);	//create method that turns robot according to gyro angle
    }//end of execute

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return Robot.drivetrain.rotatePID.onTarget(); //return to false if error is given or program fails to work
    }

    // Called once after isFinished returns true
    protected void end() 
    {
    	Robot.drivetrain.stop();//stops both motors
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() 
    {
    	end();
    }
}
