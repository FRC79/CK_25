// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.wpilibj.DoubleSolenoid.Value.*;


public class Pneumatics extends SubsystemBase {

  DoubleSolenoid DoublePCM1 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
  DoubleSolenoid DoublePCM2 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
  DoubleSolenoid DoublePCM3 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);
  DoubleSolenoid DoublePCM4 = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 1, 2);

  /** Creates a new Pneumatics. */
  public Pneumatics() {}

  public void turnOffSolonoid(){
    DoublePCM1.set(kOff);
    DoublePCM2.set(kOff);
    DoublePCM3.set(kOff);
    DoublePCM4.set(kOff);
  }

  public void forwardPiston(){
    DoublePCM1.set(kForward);
    DoublePCM2.set(kForward);
    DoublePCM3.set(kForward);
    DoublePCM4.set(kForward);
  }

  public void reversePiston(){
    DoublePCM1.set(kReverse);
    DoublePCM2.set(kReverse);
    DoublePCM3.set(kReverse);
    DoublePCM4.set(kReverse);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
