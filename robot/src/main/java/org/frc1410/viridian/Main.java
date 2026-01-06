//WAIT! this package below should read "org.frc1410.viridian" IF you are on Viridian Framework, if you've forked Viridian into the current year(like Rebuilt2026)
//this should read org.frc1410.[namehere] AND your file path should read robot\src\main\java\org\frc1410\[name here]

package org.frc1410.viridian;

import edu.wpi.first.wpilibj.RobotBase;

public interface Main {
  static void main(String[] args) {
	  RobotBase.startRobot(Robot::new);
  }
}
