// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

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
      public static final int LEFT_MOTOR1_PORT    = 1;
      public static final int LEFT_MOTOR2_PORT    = 3;
      
      public static final int RIGHT_MOTOR1_PORT   = 2;
      public static final int RIGHT_MOTOR2_PORT   = 4; 

      /* encoders */
      public static final int RIGHT_ENCODER_PORT_A        = 0;     // port for the A channel of right encoder
      public static final int RIGHT_ENCODER_PORT_B        = 1;     // port for the B channel of right encoder
      public static final boolean RIGHT_ENCODER_REVERSE   = true;  // is the right encoder reversed?

      public static final int LEFT_ENCODER_PORT_A         = 2;     // port for the A channel of left encoder
      public static final int LEFT_ENCODER_PORT_B         = 3;     // port for the B channel of leff encoder
      public static final boolean LEFT_ENCODER_REVERSE    = false; // is the left encoder reversed?
  }    

  public static final class RollerConstants {
    /* roller vicors */
    public static final int INTAKE    = 6;
    public static final int CLIP_LOW  = 9;
    public static final int CLIP_HIGH = 12;
    public static final int DUMPER    = 11;
  }


  public static final class OIConstants {
    /* joysticks */
    public static final int DRIVER    = 0; // driver joystick port (usb) on laptop (changeable w/ oi in driver station)
    public static final int OPERATOR  = 1; // driver joystick port (usb) on laptop (changeable w/ oi in driver station)
  
    /* Controller Buttons */
    public static final int INTAKE_BUTTON = 1;
    public static final int DUMP_BUTTON = 3;
  }
}
