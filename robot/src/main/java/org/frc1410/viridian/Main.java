package org.frc1410.viridian;

import edu.wpi.first.wpilibj.RobotBase;

public interface Main {
  static void main(String[] args) {
	  RobotBase.startRobot(Robot::new);
  }
}
