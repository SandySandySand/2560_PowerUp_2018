/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2560.robot;

import org.usfirst.frc.team2560.robot.commands.Climb;
import org.usfirst.frc.team2560.robot.commands.GoDown;
import org.usfirst.frc.team2560.robot.commands.SetBothSolenoids;
import org.usfirst.frc.team2560.robot.commands.UnsetBothSolenoids;
import org.usfirst.frc.team2560.robot.commands.LiftUp;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI 
{
	public Joystick joystick0, joystick1;

	public OI()
	{
		joystick0 = new Joystick(RobotMap.joystick0);
		joystick1 = new Joystick(RobotMap.joystick1);
		
		
		Button openClaw = new JoystickButton(joystick1, RobotMap.openclaw);
		openClaw.whenPressed(new SetBothSolenoids());
		
		Button closeClaw = new JoystickButton(joystick1, RobotMap.closeclaw);
		closeClaw.whenPressed(new UnsetBothSolenoids());
		
	    Button lift = new JoystickButton(joystick1, RobotMap.lift);
		lift.whileHeld(new LiftUp());
		
		Button down = new JoystickButton(joystick1, RobotMap.down);
		down.cancelWhenPressed(new LiftUp());
		down.whileHeld(new GoDown());
		
		Button climb = new JoystickButton(joystick1, RobotMap.climb);
		climb.whileHeld(new Climb());
	}
	public Joystick getJoystick0()
	{
		return joystick0;
	}
	
	public Joystick getJoystick1()
	{
		return joystick1;
	}
}
