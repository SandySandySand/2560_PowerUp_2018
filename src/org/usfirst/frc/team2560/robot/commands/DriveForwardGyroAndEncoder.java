package org.usfirst.frc.team2560.robot.commands;

import org.usfirst.frc.team2560.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class DriveForwardGyroAndEncoder extends Command 
{

	private double requiredDistance;
	private double power;
	private final double TICKS_PER_INCH = 217.3;
	private boolean fin = false;
	
    public DriveForwardGyroAndEncoder(double requiredDistance, double power) 
    {
       //requires(Robot.drivetrain);
       this.requiredDistance = requiredDistance;
       this.power = power;
    }

    // Called just before this Command runs the first time
    protected void initialize() //resets value on encoders and navx
    {
    	/*Robot.drivetrain.reset();
    	Robot.drivetrain.resetEnc();*/
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	double ticksToGo = requiredDistance * TICKS_PER_INCH; //calculates ticks needed to go to reach distance
    	SmartDashboard.putNumber("ticks to go auto", ticksToGo);
    	double totalTicks = 0; //will be rolling count of total ticks gone
    	SmartDashboard.putNumber("total ticks", totalTicks);
    	
    	//double angle = Robot.drivetrain.getAngle(); //angle the robot is going
    	//SmartDashboard.putNumber("Angle", angle);
    	double Kp = 0.03; //pid value P
    	
		while (totalTicks < ticksToGo)
		{
			//Robot.drivetrain.gyroDrive(power, angle*Kp, true); //keeps the robot driving straight
			//Robot.drivetrain.tankDrive(power, power);
    		//totalTicks = Math.abs(Robot.drivetrain.getRightPos()); //keeps rolling count of our current position
    		SmartDashboard.putNumber("total ticks", totalTicks);
    		//SmartDashboard.putNumber("Angle", angle);
		}
		fin = true; //finishes the command when destination is reached
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() 
    {
        return fin; //HOPEFULLY, gives the capability for us to not have to use time-based dead reckoning
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
    	end(); //does function in end
    }
}
