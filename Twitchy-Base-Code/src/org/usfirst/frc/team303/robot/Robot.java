package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




public class Robot extends IterativeRobot {
	
	static Drivebase drivebase;
	static Claw claw;
	static ClawWheels clawWheels;
	static Intake intake;
	static IntakeWheels intakeWheels;
	static Pneumatics pneumatics;
	
	//make the things
	
	@Override
	public void robotInit() {
		drivebase.drivebaseInit();
		claw.ClawInit();
		clawWheels.ClawWheelInit();
		intake.IntakeInit();
		intakeWheels.IntakeWheelsInit();
		pneumatics.pneumaticsInit();
		
		//initialize the things
	}
	
	@Override
	public void robotPeriodic(){
		OI.update();
		OI.updateXbox();
		
		//update the things
	}

	@Override
	public void autonomousInit() {
		
	}

	@Override
	public void autonomousPeriodic() {
		
	}
	
	public void teleopInit() {
		
	}

	@Override
	public void teleopPeriodic() {
		drivebase.drive(OI.lX,OI.rX);
		//driving is left and right sticks
		claw.Control(OI.xlY);
		//claw up and down is xbox left stick y axis
		intake.Control(OI.xrY);
		//intake up and down is xbox right stick y axis
		pneumatics.ControlShift(OI.rBtn[1]);
		//shift to high gear is right joystick trigger
		if(OI.xRightTrigger>75){
			clawWheels.control(true);
			pneumatics.ControlShot(true);
		}else if(OI.xRightTrigger>5){
			clawWheels.control(true);
			pneumatics.ControlShot(false);
		}else if(OI.xRightTrigger<=5){
			clawWheels.control(false);
			pneumatics.ControlShot(false);
		}
		//shoot is xbox right trigger
		
		//if more than 5 spin wheels up, if more than 75 shoot, if less than 5 stop
		
		if(OI.rBtn[2]){
			intakeWheels.Control(1);
		}else if(OI.lBtn[2]){
			intakeWheels.Control(-1);
		}else {
			intakeWheels.Control(0);
		}
		//button 2 on both joysticks controls intake and outake, right is intake, left is outake
		
		//control the things
	}

	@Override
	public void testPeriodic() {
	}
}

