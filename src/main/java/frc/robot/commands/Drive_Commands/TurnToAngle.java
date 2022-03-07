package frc.robot.commands.Drive_Commands;

import java.sql.Time;
import java.util.Date;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Timer;
import frc.robot.subsystems.DriveTrain;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveSubsystem;

/** A command that will turn the robot to the specified angle. */
public class TurnToAngle extends PIDCommand {
  /**
   * Turns to robot to the specified angle.
   *
   * @param targetAngleDegrees The angle to turn to
   * @param drive The drive subsystem to use
   */
  double requiredTime = 5000;
  double reachCorrectSpot = 0;
  
  public TurnToAngle(double targetAngleDegrees, DriveTrain drive, DriveSubsystem subsystem) {
    super(
        new PIDController(0.02, 0.02, 0),
        // Close loop on heading
        drive::getHeading,
        // Set reference to target
        targetAngleDegrees,
        // Pipe output to turn robot
        output -> {
            subsystem.arcadeDrive(0, output);
        },
        // Require the drive
        drive);

    // Set the controller to be continuous (because it is an angle controller)
    getController().enableContinuousInput(-180, 180);
    // Set the controller tolerance - the delta tolerance ensures the robot is stationary at the
    // setpoint before it is considered as having reached the reference
    getController()
        .setTolerance(5, 10);
  }

  @Override
  public boolean isFinished() {
    // End when the controller is at the reference.
    if (getController().atSetpoint() == true) {
      if (reachCorrectSpot == 0) {
        reachCorrectSpot = System.currentTimeMillis();
      }
      else if (System.currentTimeMillis() - reachCorrectSpot > 1000){
        System.out.print("True");
        return getController().atSetpoint();
      }
    }
    else {
      System.out.print("Reset Time");
      reachCorrectSpot = 0;
    }
    System.out.print("False");
    return false;
    
  }
}