package org.usfirst.frc.team4716.robot;

import org.usfirst.frc.team4716.robot.commands.ElevatorLiftProcess;
import org.usfirst.frc.team4716.robot.commands.ElevatorUnloadProcess;
import org.usfirst.frc.team4716.robot.commands.HoldSystemLock;
import org.usfirst.frc.team4716.robot.commands.HoldSystemRelease;
import org.usfirst.frc.team4716.robot.commands.LiftPull;
import org.usfirst.frc.team4716.robot.commands.LiftPush;
import org.usfirst.frc.team4716.robot.commands.ManualElevDown;
import org.usfirst.frc.team4716.robot.commands.ManualElevUp;
import org.usfirst.frc.team4716.robot.commands.ResetRobot;
import org.usfirst.frc.team4716.robot.commands.SetElevatorSetpoint;
import org.usfirst.frc.team4716.robot.commands.SpeedCommand;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * Author: Alessio Symons
 * Class: OI
 * Summary: This class is the OI class, aka Input Output Class. Its main purpose
 * is to create the Joystick class such that a Joystick can be used to interact
 * with the commands. 
 */
public class OI {

	/*
	 * Declare the Joysticks used. Usually there are two  
	 * joysticks for robot control, one for test commands 
	 * 
	 * 		Constructor - 
	 * 		n - Port Number, Integer.
	 * 
	 */

	Joystick stick 		= new Joystick(0);
	Joystick stick2		= new Joystick(1);
	Joystick control 	= new Joystick(2);
	Joystick test 		= new Joystick(3);

	/*
	 * Declare the Joystick buttons used on the robot.	
	 * 
	 *		Constructor - 
	 *		joystick - Joystick object
	 *		n - Button Number, Integer
	 */
	JoystickButton but1   = new JoystickButton(stick, 1);
	JoystickButton but2   = new JoystickButton(stick, 2);
	JoystickButton but3   = new JoystickButton(stick, 3);
	JoystickButton but4   = new JoystickButton(stick, 4);
	JoystickButton but5   = new JoystickButton(stick, 5);
	JoystickButton but6   = new JoystickButton(stick, 6);
	JoystickButton but7   = new JoystickButton(stick, 7);

	JoystickButton sbut1  = new JoystickButton(stick2, 1);
	JoystickButton sbut2  = new JoystickButton(stick2, 2);
	JoystickButton sbut3  = new JoystickButton(stick2, 3);
	JoystickButton sbut4  = new JoystickButton(stick2, 4);
	JoystickButton sbut5  = new JoystickButton(stick2, 5);
	JoystickButton sbut6  = new JoystickButton(stick2, 6);
	JoystickButton sbut7  = new JoystickButton(stick2, 7);
	JoystickButton sbut8  = new JoystickButton(stick2, 8);
	JoystickButton sbut9  = new JoystickButton(stick2, 9);
	JoystickButton sbut10 = new JoystickButton(stick2, 10);
	JoystickButton sbut11 = new JoystickButton(stick2, 11);

	JoystickButton tbut1  = new JoystickButton(test, 1);
	JoystickButton tbut2  = new JoystickButton(test, 2);
	JoystickButton tbut3  = new JoystickButton(test, 3);
	JoystickButton tbut4  = new JoystickButton(test, 4);
	JoystickButton tbut5  = new JoystickButton(test, 5);
	JoystickButton tbut6  = new JoystickButton(test, 6);
	JoystickButton tbut7  = new JoystickButton(test, 7); 
	JoystickButton tbut8  = new JoystickButton(test, 8);
	JoystickButton tbut9  = new JoystickButton(test, 9);

	
	/*
	 * Purpose of this constructor is to declare what buttons
	 * do and put them in the SmartDashboard.
	 */
	public OI() {
		
		
		/*
		 * These are all the joystick commands we use.
		 * 
		 * 		Joystick Commands -
		 * 		whenPressed() - Does an action when button is pressed
		 * 		and action is completed fully.
		 * 		whenReleased() - Does an action when button is lifted
		 * 		and action is completed fully.
		 * 		whileHeld() - Does an action when button is pressed
		 * 		downwards and constantly completes action until release.
		 */
		sbut1.whenPressed(new ElevatorLiftProcess());
		sbut2.whenPressed(new ElevatorUnloadProcess());
		sbut3.whenPressed(new ResetRobot());
		sbut4.whenPressed(new HoldSystemLock()); // Moves Tilt Forward
		sbut5.whenPressed(new HoldSystemRelease()); // Moves Tilt back
		sbut6.whenPressed(new LiftPull()); // tilt pull
		sbut7.whenPressed(new LiftPush()); // tilt push
		sbut8.whileHeld(new ManualElevUp());
		sbut9.whileHeld(new ManualElevDown());
		sbut10.whenPressed(new SpeedCommand(false));
		sbut11.whenPressed(new SpeedCommand(true));

		tbut1.whenPressed(new ElevatorLiftProcess());
		tbut2.whenPressed(new HoldSystemLock()); // Moves Tilt Forward
		tbut3.whenPressed(new HoldSystemRelease()); // Moves Tilt back
		tbut4.whenPressed(new SetElevatorSetpoint(2000));

		tbut6.whenPressed(new LiftPull()); // tilt pull
		tbut7.whenPressed(new LiftPush()); // tilt push
		tbut8.whileHeld(new ManualElevUp());
		tbut9.whileHeld(new ManualElevDown());
		
		
		/*
		 * These are all the SmartDashboard Commands.
		 * 
		 * 		Joystick Commands -
		 * 			putData()- 
		 * 			Puts information about command on SmartDashboard	
		 * 				Parameters -
		 * 				name - String
		 * 				command - create a new object which will be the command
		 */
		
		SmartDashboard.putData("Elevator Lift Process", new ElevatorLiftProcess());
		SmartDashboard.putData("Hold System Lock", new HoldSystemLock());
		SmartDashboard.putData("Hold System Release", new HoldSystemRelease());
		SmartDashboard.putData("Lift Pull", new LiftPull());
		SmartDashboard.putData("Lift Push", new LiftPush());

	}
	
	
	/*
	 * These are all the getters for the joysticks
	 * 		return - 
	 * 		getX() - Returns x value of joystick
	 * 		getY() - Returns y value of joystick
	 */

	public double getLeftSpeed() {
		return stick.getY();
	}

	public double getRightSpeed() {
		return stick2.getY();
	}

	public double getJoyX() {
		return stick.getX();
	}

	public double getJoyY() {
		return stick.getY();
	}

}
