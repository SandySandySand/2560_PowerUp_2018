package org.usfirst.frc.team2560.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class CenterStationAutoSOLS extends CommandGroup 
{

    public CenterStationAutoSOLS() 
    {
        addSequential(new DriveForwardEncoder(48, 0.5));
        addSequential(new Turn(-90));
        addSequential(new DriveForwardEncoder(48, 0.5));
        
    }
}
