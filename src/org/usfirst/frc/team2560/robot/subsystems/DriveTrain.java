package org.usfirst.frc.team2560.robot.subsystems;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SerialPort.Port;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import org.usfirst.frc.team2560.robot.RobotMap;
import org.usfirst.frc.team2560.robot.commands.DriveWithController;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import com.kauailabs.navx.frc.AHRS;

/**
 *
 */
public class DriveTrain extends Subsystem implements PIDOutput 
{

    private WPI_TalonSRX left,  right, leftFollow, rightFollow; 
    private DifferentialDrive drive;
    private AHRS ahrs;
    public PIDController rotatePID;
    
    public double kP = 0;
	public double kI = 0;
	public double kD = 0;

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
    	
    	//ahrs = new AHRS(Port.kUSB);
    	
    	/*rotatePID = new PIDController(kP, kI, kD, ahrs,  this);
    	//rotatePID.setContinuous(true);
    	rotatePID.setInputRange(-360, 360);
    	rotatePID.setOutputRange(-1.0, 1.0);*/
    }
    
    @Override 
	public void pidWrite(double output) {
		// does nothing
		
	}
    
    //drive commands
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
	
	//gyro commands
    
	public void reset()
	{
		ahrs.reset();
	}
	
	public double getAngle()
	{
		return ahrs.getAngle();
	}
	
	//encoder commands
	public double getLeftPos()
	{
		return left.getSelectedSensorPosition(0);
	}
	
	public double getRightPos()
	{
		return right.getSelectedSensorPosition(0);
	}
	
	public void resetEnc()
	{
		left.setSelectedSensorPosition(0, 0, 10);
		right.setSelectedSensorPosition(0, 0, 10);
	}
	
    public void initDefaultCommand() 
    {
        //setDefaultCommand(new DriveWithController());
    }

	
}

