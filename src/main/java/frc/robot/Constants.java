// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import io.github.pseudoresonance.pixy2api.Pixy2CCC;
import edu.wpi.first.wpilibj.AnalogInput;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public static final class RobotRecorderConstants{
    
    public static final double  UPDATE_FREQUENCY      = 15;     // miliseconds (maybe change to microseconds)
    public static final double  RECORDING_DURATION    = 5;      // seconds
    public static final String  SAVE_FILE_EXTENSION   = ".lmao";// extension for files that robotArrays are saved in
    public static final String  SAVE_FILE_PATH        = "/home/lvuser/";// path on the roborio to keep robotArray files( thanks for ruining the cool looking code )
    public static final String  SAVE_FILE_NAME        = "test"; // name of the file to make or read
    public static final boolean PRINT_DEBUG_INFO      = true;   // true to print info about the recoring and playback
    public static final boolean VERBOSE_DEBUG_PRINT   = true;   // true to print a lot of in depth info about recording and playback
    public static final boolean SHOULD_RECORD         = true;   // if false will block the "start recording" method
    public static final boolean INTERPOLATE_VALUES    = true;   // should data retreived between updates be interpolated (a method of constructing new data points between two given data points)
  }
  
  public static final class DriveConstants {

      /* motors */
      public static final int LEFT_MOTOR1_PORT    = 15;
      public static final int LEFT_MOTOR2_PORT    = 14;
      
      public static final int RIGHT_MOTOR1_PORT   = 0;
      public static final int RIGHT_MOTOR2_PORT   = 1; 

      /* encoders */
      public static final int RIGHT_ENCODER_PORT_A        = 0;     // port for the A channel of right encoder
      public static final int RIGHT_ENCODER_PORT_B        = 1;     // port for the B channel of right encoder
      public static final boolean RIGHT_ENCODER_REVERSE   = true;  // is the right encoder reversed?

      public static final int LEFT_ENCODER_PORT_A         = 2;     // port for the A channel of left encoder
      public static final int LEFT_ENCODER_PORT_B         = 3;     // port for the B channel of leff encoder
      public static final boolean LEFT_ENCODER_REVERSE    = false; // is the left encoder reversed?

      public static final int kLeftMotor1Port = 15;
      public static final int kLeftMotor2Port = 14;
      public static final int kRightMotor1Port = 0;
      public static final int kRightMotor2Port = 1;

      public static final int[] kLeftEncoderPorts = new int[] {0, 1};
      public static final int[] kRightEncoderPorts = new int[] {2, 3};
      public static final boolean kLeftEncoderReversed = false;
      public static final boolean kRightEncoderReversed = true;

      public static final int kEncoderCPR = 1024;
      public static final double kWheelDiameterInches = 6;
      public static final double kEncoderDistancePerPulse =
          // Assumes the encoders are directly mounted on the wheel shafts
          (kWheelDiameterInches * Math.PI) / (double) kEncoderCPR;

      public static final boolean kGyroReversed = false;

      public static final double kStabilizationP = 1;
      public static final double kStabilizationI = 0.5;
      public static final double kStabilizationD = 0;

      public static final double kTurnP = 1;
      public static final double kTurnI = 0;
      public static final double kTurnD = 0;

      public static final double kMaxTurnRateDegPerS = 100;
      public static final double kMaxTurnAccelerationDegPerSSquared = 300;

      public static final double kTurnToleranceDeg = 5;
  }    

  public static final class RollerConstants {
    /* roller vicors */
    public static final int INTAKE    = 10;
    public static final int SHOOT  = 11;
    public static final int WHEEL    = 9;
    public static final int SLIDE_FRONT  = 12;
    public static final int SLIDE_BACK  = 13;

  }


  public static final class OIConstants {
    /* joysticks */
    public static final int DRIVER    = 0; // driver joystick port (usb) on laptop (changeable w/ oi in driver station)
    public static final int OPERATOR  = 1; // driver joystick port (usb) on laptop (changeable w/ oi in driver station)
  
    /* Controller Buttons */
    public static final int INTAKE_BUTTON = 0;
    public static final int SHOOT_BUTTON = 3;
    public static final int WHEEL_BUTTON = 1;
    public static final int UP_BUTTON = 4;
    public static final int DOWN_BUTTON = 5;
    public static final int JERRY_BUTTON = 6;
    public static final int TOM_BUTTON = 7;

  }

  public static final class VisionConstants{
    public static final byte Red_Signature = Pixy2CCC.CCC_SIG1;
    public static final byte Blue_Signature = Pixy2CCC.CCC_SIG2;
  }

  public static final class PneumaticsConstants{
  }

  public static final class TopRollersConstants{
  }
}
