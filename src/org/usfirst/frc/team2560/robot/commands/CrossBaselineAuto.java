package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CrossBaselineAuto extends CommandGroup 
{

    public CrossBaselineAuto() 
    {
      addSequential(new DriveForwardEncoder(126, 0.5)); //drives past baseline at any place of setup
    }
}
