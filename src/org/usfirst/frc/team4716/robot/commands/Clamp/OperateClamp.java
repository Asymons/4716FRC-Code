package org.usfirst.frc.team4716.robot.commands.Clamp;

import org.usfirst.frc.team4716.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class OperateClamp extends Command {

	private boolean hold;
    public OperateClamp(boolean hold) {
    	this.hold = hold;
    	requires (Robot.lift);
    }

    protected void initialize() {
    	if(hold == true){
    	Robot.clamp.ClampRelease();
    	hold = false;
    	}else if(hold == false){
    	Robot.clamp.ClampLock();
    	hold = true;
    	}
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	
    	return hold == Robot.clamp.getHoldPosition() ? true:false;
    }

    protected void end() {
    	Robot.clamp.ClampOff();
    }

    protected void interrupted() {
    	end();
    }
}
