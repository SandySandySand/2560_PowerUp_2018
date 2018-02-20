/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team2560.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap 
{
	//CAN Values
	public static int leftMotor = 2;
	public static int rightMotor = 1;
	public static int leftFollow = 4; 
	public static int rightFollow = 3;
	
	//PWM Values
	public static int elevator = 0;
	public static int climber = 1;
	
	//PCM Values
	public static int soleportone = 0;
	public static int soleporttwo = 1;
	
	//Joystick Ports
	public static int joystick0 = 0;
	public static int joystick1 = 1;
	
	//Joystick Buttons
	public static int openclaw = 1;
	public static int down = 2;
	public static int closeclaw = 3;
	public static int lift = 4;
	public static int climb = 5;
	
	//DIO Port
	public static int limit = 0;
}
