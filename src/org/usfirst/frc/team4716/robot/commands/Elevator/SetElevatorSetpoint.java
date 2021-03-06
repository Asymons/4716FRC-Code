package org.usfirst.frc.team4716.robot.commands.Elevator;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class SetElevatorSetpoint extends Command {

	private double setpoint;
	
    public SetElevatorSetpoint(double setpoint) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	this.setpoint = setpoint;
    	requires(Robot.elevator);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevator.enable();
    	Robot.elevator.setSetpoint(setpoint);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//    	if(Robot.elevator.getEncoderDistance() > setpoint){
//    		return true;
//    	}else if(setpoint == 0 && Robot.elevator.getEncoderDistance() < 30){
//    		return true;
//    	}else{
//    		return false;
//    	}
    	return Robot.elevator.onTarget();

    	
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.elevator.disable();
    	Robot.elevator.moveElevCIM(0);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	Robot.elevator.disable();
    	Robot.elevator.moveElevCIM(0);
    }
}
