package org.usfirst.frc.team303.robot;

import com.ctre.CANTalon;
import com.ctre.CANTalon.TalonControlMode;

public class Intake {

	static CANTalon intake = new CANTalon(RobotMap.INTAKE);
	
	
	public void Intake(){
		
		intake.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
	}
	
	public void IntakeInit(){
	}
	
	public void Control(double pos){
		intake.set(pos);
	}
}
