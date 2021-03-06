package org.usfirst.frc.team4716.robot.commands.DriveTrain;

import org.usfirst.frc.team4716.robot.RobotMap;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SpeedCommand extends Command {
	
	boolean _fast;

    public SpeedCommand(boolean fast) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);

    	_fast = fast;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	if(_fast == true){
    		RobotMap.mFactor = 0.85;
    	}else if(_fast == false){
    		RobotMap.mFactor = 0.7;
    	}
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
