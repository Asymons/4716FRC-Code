package org.usfirst.frc.team4716.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMoveForwardStraight extends CommandGroup {
    
    public  AutoMoveForwardStraight() {
    	
    	//TRUE IS LEFT, FALSE IS RIGHT
    	addSequential(new Drive_Forward_Manul(5.8,-0.7));
    	addSequential(new Drive_Turn(0.7,82,false));
    	addSequential(new Drive_Forward_Manul(2.5, -0.7));
    	addSequential(new Drive_Forward_Manul(0.1,0));
    }
}
