package org.usfirst.frc.team303.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ClawWheels {

	static CANTalon lClawWheel = new CANTalon(RobotMap.LCLAWWHEEL);
	static CANTalon rClawWheel = new CANTalon(RobotMap.RCLAWWHEEL);
	double speedy = 0.5;
	
	public ClawWheels(){
	
		lClawWheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rClawWheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		lClawWheel.setInverted(RobotMap.LCLAWWHEEL_INV);
	}
	
	public void control(boolean speed, double inv){
		if (speed == true){
			lClawWheel.set(speedy*inv);
			rClawWheel.set(speedy*inv);
		}else if(speed == false){
			lClawWheel.set(0);
			rClawWheel.set(0);
		}
		if(OI.xPov == 1){
			speedy+=0.02;
			SmartDashboard.putNumber("speed", speedy);
		}else if(OI.xPov == 5){
			speedy-=0.02;
			SmartDashboard.putNumber("speed", speedy);
		}else{
			SmartDashboard.putNumber("speed", speedy);
		}
		
		
	}
}

