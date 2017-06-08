package org.usfirst.frc.team303.robot;

import com.ctre.CANTalon;

public class ClawWheels {

	static CANTalon lClawWheel;
	static CANTalon rClawWheel;
	
	public ClawWheels(){
		lClawWheel = new CANTalon(RobotMap.LCLAWWHEEL);
		rClawWheel = new CANTalon(RobotMap.RCLAWWHEEL);
	}
	
	public void ClawWheelInit(){
		lClawWheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rClawWheel.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	
	public void control(boolean speed){
		if (speed == true){
			lClawWheel.set(1);
			rClawWheel.set(1);
		}else if(speed == false){
			lClawWheel.set(0);
			rClawWheel.set(0);
		}
	}
}

