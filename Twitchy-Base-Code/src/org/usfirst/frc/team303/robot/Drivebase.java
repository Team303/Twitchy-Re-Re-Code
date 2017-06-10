package org.usfirst.frc.team303.robot;

import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.RobotDrive;

public class Drivebase {

	CANTalon FL;
	CANTalon FR;
	CANTalon BL;
	CANTalon BR;
	RobotDrive drivebase;
	
	public Drivebase() {
		FL = new CANTalon(RobotMap.FL);
		FR = new CANTalon(RobotMap.FR);
		BL = new CANTalon(RobotMap.BL);
		BR = new CANTalon(RobotMap.BR);
		drivebase = new RobotDrive(FL, BL, FR, BR);
		drivebase.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, RobotMap.FL_INV);
		drivebase.setInvertedMotor(RobotDrive.MotorType.kFrontRight, RobotMap.FR_INV);
		drivebase.setInvertedMotor(RobotDrive.MotorType.kRearLeft, RobotMap.BL_INV);
		drivebase.setInvertedMotor(RobotDrive.MotorType.kRearRight, RobotMap.BR_INV);
		drivebase.setSafetyEnabled(true);
	}
	
	public void drivebaseInit() {
		
		
	}
	
	public void drive(double left, double right) {
		drivebase.tankDrive(left, right);
	}
	
}

