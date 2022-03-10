// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.concurrent.TimeoutException;

import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.SPI;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Rollers;
import frc.robot.commands.Drive_Commands.*;
import frc.robot.commands.Roller_Commands.Intake;
import frc.robot.commands.Roller_Commands.IntakeForever;
import frc.robot.commands.Roller_Commands.RunAll;
import frc.robot.commands.Roller_Commands.Wheel;
import frc.robot.commands.Vision_Commands.*;




/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  private RobotContainer m_robotContainer;

  private final DigitalInput m_photoElectic = new DigitalInput(4);

  /* drive train */
  private DriveTrain m_DriveTrain;

  private DriveSubsystem m_DriveSubsystem;

  private Rollers m_Rollers;

  /* commands */

  private TeleopDrive m_TeleopDrive;

  private SequentialCommandGroup auto;

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.
    m_DriveTrain = new DriveTrain();
    m_Rollers = new Rollers();
    m_DriveSubsystem = new DriveSubsystem();
    m_DriveTrain.gyro.reset();
    Shuffleboard.getTab("Example tab").add(m_DriveTrain.gyro);
    //m_visionTracking = new VisionTracking(m_DriveTrain, m_ultrasonic, m_photoElectic, m_DriveSubsystem);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for items like
   * diagnostics that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.
    CommandScheduler.getInstance().run();
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {
    // schedule the autonomous command (example)
    auto = new SequentialCommandGroup(
    new Wheel(m_Rollers).withTimeout(1),
    new RunAll(m_Rollers).withTimeout(2),
    new DriveInchAway(m_DriveTrain), 
    new TurnToAngle(-90, m_DriveTrain, m_DriveSubsystem),
    new IntakeForever(m_Rollers), 
    new VisionTracking(m_DriveTrain, m_photoElectic, m_DriveSubsystem),
    new TurnToAngle(0, m_DriveTrain, m_DriveSubsystem),
    new DriveForSec(m_DriveTrain).withTimeout(0.75),
    new VisionTracking(m_DriveTrain, m_photoElectic, m_DriveSubsystem),
    new TurnToAngle(0, m_DriveTrain, m_DriveSubsystem),
    new DriveForSec(m_DriveTrain).withTimeout(0.75),
    new Wheel(m_Rollers).withTimeout(1),
    new RunAll(m_Rollers).withTimeout(2));
    if (auto != null) {
      auto.schedule();
      }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    m_TeleopDrive = new TeleopDrive(m_DriveTrain, m_robotContainer); 
    //m_recordDrive = new TestRecordDrive(m_Recorder,m_DriveTrain, m_robotContainer);
    if (auto != null) {
      auto.cancel();
    }
    m_TeleopDrive.schedule();
    //m_recordDrive.schedule();
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}
}
