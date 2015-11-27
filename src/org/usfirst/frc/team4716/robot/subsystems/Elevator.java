package org.usfirst.frc.team4716.robot.subsystems;

import org.usfirst.frc.team4716.robot.RobotMap;
import org.usfirst.frc.team4716.robot.commands.StopElevator;

import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Elevator extends PIDSubsystem {
	   
    private SpeedController leftElevCIM, rightElevCIM;
    private Encoder elevEncoder;
    private DigitalInput limit;
    private PIDController pid;
    
    public Elevator(){
    	//objects
    	super("Elevator", 0.05,0,0.1);
    	leftElevCIM = new Talon(4);
    	rightElevCIM = new Talon(7);
    	limit = new DigitalInput(6);
    	elevEncoder	= new Encoder(RobotMap.ELEVATOR_ENCODER_PORT_1, RobotMap.ELEVATOR_ENCDER_PORT_2,
    							  false, EncodingType.k4X);
    	//properties
    	elevEncoder.setDistancePerPulse(1.0); //inches per pulse 
    	setAbsoluteTolerance(50);
    	
    	//live window
    	LiveWindow.addActuator("Elevator", "Elevator CIM", (Talon) leftElevCIM);
    	LiveWindow.addActuator("Elevator", "Elevator CIM", (Talon) rightElevCIM);
    	LiveWindow.addSensor("Encoder", "Elevator Encoder", elevEncoder);
    	
    }

    public void initDefaultCommand() {
        setDefaultCommand(new StopElevator());
    }
    
    //getters     
    public double getEncoderDistance(){
    	return elevEncoder.getDistance();
    }
    
    public boolean limitGet(){
    	return limit.get();
    }
    
    //setters
    public void moveElevCIM(double speed){
    	leftElevCIM.set(speed);
    	rightElevCIM.set(speed);
    }
    
    public void encoderReset(){
    	elevEncoder.reset();
    }
    //logging
    public void smartDashLog(){
    	SmartDashboard.putNumber("Elevator Encoder", elevEncoder.getDistance());
    }
    
    protected double returnPIDInput() {
        return elevEncoder.pidGet();
    }


    /**
     * Use the motor as the PID output. This method is automatically called by
     * the subsystem.
     */
    protected void usePIDOutput(double d) {
        leftElevCIM.set(-d);
        rightElevCIM.set(-d);
    }
    
}

