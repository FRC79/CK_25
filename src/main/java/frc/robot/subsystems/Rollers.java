/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.RollerConstants;

public class Rollers extends SubsystemBase {
  // intake victors
  private VictorSPX intakeMotor = new VictorSPX(RollerConstants.INTAKE);
  // ball clip victors
  private final VictorSPX shootMotor = new VictorSPX(RollerConstants.SHOOT);
  // ball dump victors
  private final VictorSPX wheelMotor = new VictorSPX(RollerConstants.WHEEL);

  private final VictorSPX frontSlideMotor = new VictorSPX(RollerConstants.SLIDE_FRONT);
  private final VictorSPX backSlideMotor = new VictorSPX(RollerConstants.SLIDE_BACK);

  /**
   * Creates a new BallConveyer.
   */
  public Rollers() {
    
  }

  public void setIntakeMotors(double speed){
    intakeMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setShootMotor(double speed){
    shootMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setWheelMotors(double speed){
    wheelMotor.set(ControlMode.PercentOutput, speed);
  }

  public void setSlideMotors(double speed){
    frontSlideMotor.set(ControlMode.PercentOutput, speed);
    backSlideMotor.set(ControlMode.PercentOutput, speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
