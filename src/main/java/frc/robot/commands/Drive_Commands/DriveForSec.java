// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.Drive_Commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj.RobotController;



public class DriveForSec extends CommandBase {

  private DriveTrain m_DriveTrain;

  private boolean finished = false;
  
  private double startTime = 0;

  private double driveTime = 250;

  /** Creates a new DriveInchAway. */
  public DriveForSec(DriveTrain subsystem) {
    // Use addRequirements() here to declare subsystem dependencies.
    m_DriveTrain = subsystem;
    addRequirements(m_DriveTrain);

  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    startTime = System.currentTimeMillis();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (System.currentTimeMillis() - startTime > driveTime){
      finished = true;
    }
    else {
      m_DriveTrain.arcadeDrive(0.5, 0);
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
    return finished;
  }
}
