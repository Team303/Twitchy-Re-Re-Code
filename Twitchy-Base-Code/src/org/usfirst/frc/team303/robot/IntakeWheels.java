package org.usfirst.frc.team303.robot;

import com.ctre.CANTalon;

public class IntakeWheels {

	static CANTalon intakeWheels = new CANTalon(RobotMap.INTAKEWHEELS);
	
	public void IntakeWheels() {	
		intakeWheels.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
		
	public void Control(double speed){
		intakeWheels.set(speed);
	}
	
}
