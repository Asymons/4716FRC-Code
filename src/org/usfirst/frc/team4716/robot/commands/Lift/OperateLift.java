package org.usfirst.frc.team4716.robot.commands.Lift;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/*
 * Steven Rice
*/
public class OperateLift extends Command {

	private boolean tilted;
    public OperateLift(boolean tilted) {
    	this.tilted = tilted;
    	requires (Robot.lift);
    }

    protected void initialize() {
    	if(tilted == true){
    	Robot.lift.LiftPush();
    	tilted = false;
    	}else if(tilted == false){
    	Robot.lift.LiftPull();
    	tilted = true;
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	return tilted == Robot.lift.getPulledPosition() ? true:false;
    }

    protected void end() {
    	Robot.lift.LiftOff();
    }

    protected void interrupted() {
    	end();
    }
}