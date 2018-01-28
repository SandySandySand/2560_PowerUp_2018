package org.usfirst.frc.team2560.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team2560.robot.RobotMap;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

/**
 *
 */
public class DriveTrain extends Subsystem 
{

    private WPI_TalonSRX left, leftFollow, right, rightFollow;
    private DifferentialDrive drive;

    public DriveTrain()
    {
    	left = new WPI_TalonSRX(RobotMap.leftMotor);
    	left.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    	right = new WPI_TalonSRX(RobotMap.rightMotor);
    	right.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, 0, 0);
    	
    	leftFollow = new WPI_TalonSRX(RobotMap.leftFollow);
    	leftFollow.follow(left);
    	rightFollow = new WPI_TalonSRX(RobotMap.rightFollow);
    	rightFollow.follow(right);
    	
    	drive = new DifferentialDrive(left, right);
    }
    
    public void arcadeDrive(double forwardAxis, double twist)
    {
    	drive.arcadeDrive(forwardAxis, twist);
    }
    
    public void tankDrive(double leftAxis, double rightAxis)
	{
		drive.tankDrive(leftAxis, rightAxis);
	}
	
	public void stop()
	{
		drive.tankDrive(0, 0);
	}
	
	public void gyroDrive(double outputMagnitude, double curve, Boolean turn)
	{
		drive.curvatureDrive(outputMagnitude, curve, turn);
	}
    
    public void initDefaultCommand() 
    {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

