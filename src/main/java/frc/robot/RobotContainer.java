// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.Constants.OIConstants;
import frc.robot.Constants.PneumaticsConstants;
import frc.robot.commands.Climb_Commands.*;
import frc.robot.commands.Roller_Commands.*;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Rollers;
import frc.robot.subsystems.Pneumatics;


/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  /* Subsystems */
  private Rollers _Rollers = new Rollers();
  private Pneumatics _Pneumatics = new Pneumatics();
  /* commands */

  /* joysticks */
  public Joystick driver = new Joystick(Constants.OIConstants.DRIVER);
  public GenericHID operator = new Joystick(Constants.OIConstants.OPERATOR);

  private DriveTrain m_DriveTrain;

// A chooser for autonomous commands
  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
   * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings(){
    
    // Shooter Buttons
    new JoystickButton(operator, OIConstants.INTAKE_BUTTON).whenPressed(new Intake(_Rollers));

    new JoystickButton(operator, OIConstants.SHOOT_BUTTON).whenPressed(new Shoot(_Rollers));

    new JoystickButton(operator, OIConstants.WHEEL_BUTTON).whenPressed(new Wheel(_Rollers));

    new JoystickButton(operator, OIConstants.INTAKE_BUTTON).whenReleased(new Stop(_Rollers));

    new JoystickButton(operator, OIConstants.SHOOT_BUTTON).whenReleased(new Stop(_Rollers));

    new JoystickButton(operator, OIConstants.WHEEL_BUTTON).whenReleased(new StopWheel(_Rollers));

    // Pneumatics Buttons
    new JoystickButton(operator, OIConstants.UP_BUTTON).whenPressed(new PushUp(_Pneumatics));

    new JoystickButton(operator, OIConstants.DOWN_BUTTON).whenPressed(new PushDown(_Pneumatics));

    // Climber Buttons
    new JoystickButton(operator, OIConstants.JERRY_BUTTON).whileHeld(new SlideUp(_Rollers));

    new JoystickButton(operator, OIConstants.TOM_BUTTON).whileHeld(new SlideDown(_Rollers));

  }
  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
}
