package org.usfirst.frc.team303.robot;

import com.ctre.CANTalon;

public class Claw {
	
	static CANTalon claw;
	
	public Claw(){
		claw = new CANTalon(RobotMap.CLAW);
	}
	public void ClawInit(){
		claw.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	
	public void Control(double pos){
		claw.set(pos);
	}
}
