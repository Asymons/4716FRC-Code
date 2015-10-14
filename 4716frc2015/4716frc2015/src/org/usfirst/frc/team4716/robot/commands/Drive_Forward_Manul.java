package org.usfirst.frc.team4716.robot.commands;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Drive_Forward_Manul extends Command {

	
    public Drive_Forward_Manul() {
    	requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.drivetrain.reset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.drivetrain.arcadeDrive(1.0, Robot.drivetrain.getTurning());
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        	return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.drivetrain.driveSet(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.drivetrain.driveSet(0);
    }
}
