// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive_Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.RobotController;



public class DriveInchAway extends CommandBase {

  private final AnalogInput m_ultrasonic = new AnalogInput(0);

  private DriveTrain m_DriveTrain;

  private boolean end = false;

  /** Creates a new DriveInchAway. */
  public DriveInchAway(DriveTrain subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveTrain = subsystem;
    addRequirements(m_DriveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double rawValue = m_ultrasonic.getValue();
    double voltage_scale_factor = 5/RobotController.getVoltage5V();
    //double currentDistanceCentimeters = rawValue * voltage_scale_factor * 0.125;
    double currentDistanceInches = rawValue * voltage_scale_factor * 0.0492;
    if (currentDistanceInches <= 22){
      m_DriveTrain.arcadeDrive(-0.25, 0);
    }
    else{
      end = true;
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_DriveTrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return end;
  }
}
