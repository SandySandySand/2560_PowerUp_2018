/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2560.robot;

import org.usfirst.frc.team2560.robot.commands.CrossBaselineAuto;
import org.usfirst.frc.team2560.robot.commands.LeftStationAutoSOLS;
import org.usfirst.frc.team2560.robot.commands.LeftStationAutoSORS;
import org.usfirst.frc.team2560.robot.commands.RightStationAutoSOLS;
import org.usfirst.frc.team2560.robot.commands.RightStationAutoSORS;
import org.usfirst.frc.team2560.robot.commands.CenterStationAutoSOLS;
import org.usfirst.frc.team2560.robot.commands.CenterStationAutoSORS;
import org.usfirst.frc.team2560.robot.subsystems.Claw;
import org.usfirst.frc.team2560.robot.subsystems.Climber;
import org.usfirst.frc.team2560.robot.subsystems.DriveTrain;
import org.usfirst.frc.team2560.robot.subsystems.Elevator;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends TimedRobot 
{
	public static Claw claw;
	public static DriveTrain drivetrain;
	public static Elevator elevator;
	public static Climber climb;
	public static OI m_oi;
	
	Command m_autonomousCommand;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() 
	{
		claw = new Claw();
		drivetrain = new DriveTrain();
		elevator = new Elevator();
		climb = new Climber();
		m_oi = new OI();
		
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	@Override
	public void disabledInit() 
	{
		SmartDashboard.putNumber("Encoder Ticks", Robot.drivetrain.getLeftPos());
	}

	@Override
	public void disabledPeriodic() 
	{
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("Encoder Ticks", Robot.drivetrain.getLeftPos());
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() 
	{
		String gameData;
		gameData = DriverStation.getInstance().getGameSpecificMessage();
        if(gameData.length() > 0)
        {
			if(gameData.charAt(0) == 'L')
			{
				m_autonomousCommand = new LeftStationAutoSOLS(); //RightStationAutoSOLS(); //CenterStationAutoSOLS(); //CrossBaselineAuto();
			} 
			else 
			{
				m_autonomousCommand = new LeftStationAutoSORS(); //RightStationAutoSORS(); //CenterStationAutoSORS(); //CrossBaselineAuto();
			}
        }
		
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) 
		{
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() 
	{
		Scheduler.getInstance().run(); 
	}

	@Override
	public void teleopInit() 
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null) {
			m_autonomousCommand.cancel();
		}
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() 
	{
		Scheduler.getInstance().run();
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() 
	{
	}
}
