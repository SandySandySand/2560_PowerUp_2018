package org.usfirst.frc.team2560.robot.subsystems;

import org.usfirst.frc.team2560.robot.RobotMap;

import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

/**
 *
 */
public class DriveTrain extends Subsystem 
{
	private CANTalon left, right, leftFollow, rightFollow;
	private DifferentialDrive drive;
   

    public void initDefaultCommand() 
    {
        left = new CANTalon(RobotMap.leftMotor);
        left.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        right = new CANTalon(RobotMap.rightMotor);
        right.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        
        leftFollow = new CANTalon(RobotMap.leftFollow);
        leftFollow.changeControlMode(CANTalon.TalonControlMode.Follower);
        leftFollow.set(left.getDeviceID());
        
        rightfollow = new CANTalon(RobotMap.rightFollow);
        rightFollow.changeControlMode(CANTalon.TalonControlMode.Follower);
        rightFollow.set(right.getDeviceID());
        
        drive = new DifferentialDrive(left, right);
    }
}

