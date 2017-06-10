package org.usfirst.frc.team303.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

public class Pneumatics {

	Compressor compressor = new Compressor(0);
	Solenoid piston = new Solenoid(62, 0);
	Solenoid gearShift = new Solenoid(62, 1);
	
	public Pneumatics() {
		compressor.setClosedLoopControl(true);
		
		compressor.start();
		
	}
	
	public void ControlShot(boolean pistonS) {
		piston.set(pistonS);
		
	}
	public void ControlShift(boolean gearShiftS){
		gearShift.set(gearShiftS);
	}
}
