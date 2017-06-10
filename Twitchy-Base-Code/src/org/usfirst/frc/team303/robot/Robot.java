package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;




public class Robot extends IterativeRobot {
	
	static Drivebase drivebase = new Drivebase();
	static Claw claw = new Claw();
	static ClawWheels clawWheels = new ClawWheels();
	static Intake intake = new Intake();
	static IntakeWheels intakeWheels = new IntakeWheels();
	static Pneumatics pneumatics = new Pneumatics();
	static double old = 0;
	//make the things
	
	@Override
	public void robotInit() {
		
		
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
		drivebase.drive(OI.lY,OI.rY);
		//driving is left and right sticks
		old = claw.xboxClawControl(old);
		claw.Control(old);
		//claw up and down is xbox left stick y axis
		intake.Control(OI.xrY);
		//intake up and down is xbox right stick y axis
		pneumatics.ControlShift(OI.rBtn[1]);
		//shift to high gear is right joystick trigger
		if(OI.xRightTrigger>0.9){
			clawWheels.control(true, 1);
			pneumatics.ControlShot(true);
			SmartDashboard.putBoolean("compressor enabled?", true);
		}else if(OI.xRightTrigger>0.2){
			clawWheels.control(true, 1);
			pneumatics.ControlShot(false);
			SmartDashboard.putBoolean("compressor enabled?", false);
		}else if(OI.xRightTrigger<=0.2){
			clawWheels.control(false, 1);
			pneumatics.ControlShot(false);
			SmartDashboard.putBoolean("compressor enabled?", false);
		}
		
		SmartDashboard.putNumber("trigger value", OI.xRightTrigger);
		//shoot is xbox right trigger
		
		//if more than 5 spin wheels up, if more than 75 shoot, if less than 5 stop
		
		if(OI.xLeftBumper){
			intakeWheels.Control(1);
			clawWheels.control(false, -1);
		}else if(OI.xRightBumper){
			intakeWheels.Control(-1);
			clawWheels.control(true, -1);
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

