package org.usfirst.frc.team303.robot;

import com.ctre.CANTalon;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Claw {
	
	static CANTalon claw = new CANTalon(RobotMap.CLAW);
	double P = 10;
	double I = 0.0004;
	double D = 0.1;
	int limitSwitchI;
	
	public Claw(){
		
		claw.changeControlMode(CANTalon.TalonControlMode.Position);
		claw.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		claw.configEncoderCodesPerRev(360);
		claw.enableLimitSwitch(false, false);
		claw.setPID(P, I, D);
		claw.enableBrakeMode(false);
		claw.setSafetyEnabled(true);
		claw.enable();
	}
	
	public void Control(double pos){
		claw.set(pos);
	}
	
	public double xboxClawControl(double oldclaw){
		if(limitSwitchI>=15) {
			limitSwitchI = 0;
		}
		else {limitSwitchI++;}
		
		SmartDashboard.putNumber("i", limitSwitchI);
		
		if(claw.isFwdLimitSwitchClosed() && limitSwitchI>=14){
			
			claw.setEncPosition(0);
			return 0;
		} if(OI.xBtnA)
			return -0.015;
		else if(OI.xBtnB)
			return -0.20;
		else if(OI.xBtnX)
			return -0.20;
		else if(OI.xBtnY)
			return oldclaw;
		else if((OI.xlY)>0.75)
			return oldclaw - 0.005;
		else if((OI.xlY)<-0.75)
			return oldclaw + 0.005;
		else return oldclaw;
	}
	
	public double clawGetCheck(){
		double clawPos = claw.getPosition();
		SmartDashboard.putNumber("Claw Rotation", clawPos);
		SmartDashboard.putBoolean("FwdLimit", claw.isFwdLimitSwitchClosed());
		if(claw.isFwdLimitSwitchClosed())
			claw.setEncPosition(0);
		
		return clawPos;
	}
}