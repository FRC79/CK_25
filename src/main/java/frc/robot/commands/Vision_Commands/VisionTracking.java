package frc.robot.commands.Vision_Commands;

import frc.robot.Constants;
import frc.robot.Vision.VisionCamera;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSubsystem;
import frc.robot.subsystems.DriveTrain;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;

import java.util.concurrent.TimeoutException;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.RobotController;
import frc.robot.commands.Drive_Commands.*;



public class VisionTracking extends CommandBase {
    private static final int IMG_WIDTH = 316;
    private double centerX = 0.0;
    private DriveTrain m_DriveTrain;
    private DigitalInput m_photoElectic;
    private VisionCamera m_visionRed;
    private DriveSubsystem m_DriveSubsystem;
    private boolean gotBlock = false;

  public VisionTracking(DriveTrain subsystem, DigitalInput photosensor, DriveSubsystem driver) {
        // Use addRequirements() here to declare subsystem dependencies.
        m_DriveTrain = subsystem;
        m_photoElectic = photosensor;
        m_DriveSubsystem = driver;
        addRequirements(m_DriveTrain);
        m_visionRed = new VisionCamera();
      }

    @Override
  public void initialize() {
    VisionCamera.initialize();
  }
    
    @Override
  public void execute() {
    Block r = m_visionRed.getBiggestBlock(Constants.VisionConstants.Red_Signature);
    if (r != null) {
            centerX = r.getX() + (r.getWidth() / 2);
            String w = String.valueOf(r.getWidth());
            String h = String.valueOf(r.getHeight());
            System.out.print("Height of Ball is: " + h);
            System.out.print("Width of ball is: " + w);
        }
    else{
            centerX = 0;
            System.out.print("Ball is not in screen");

        }
    //int width = m_visionRed.getWidth();
    //System.out.print("Width is" + width);
    double turn = centerX - (IMG_WIDTH / 2);
    //String s=String.valueOf(turn);  
    //String x=String.valueOf(centerX);
    String t = String.valueOf(m_photoElectic.get()); 
    System.out.print("Is ball in front: " + t);
    //System.out.print("Turn value is" + s);
    //System.out.print("X value is" + x);
    if (!m_photoElectic.get()){
      if (centerX == 0){
          m_DriveTrain.arcadeDrive(0, 0.5);
      }
      else if(centerX <= 168 && centerX >= 148){
          m_DriveTrain.arcadeDrive(0.6, 0);
      }
      else{
          m_DriveTrain.arcadeDrive(0.25, turn * 0.005);
      }
    }
    else{
      m_DriveTrain.arcadeDrive(0, 0);
      gotBlock = true;
    }
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }

  @Override
  public void end(boolean interrupted) {
  try {
    Thread.sleep(5000);
  } catch (InterruptedException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
  }

  @Override
  public boolean isFinished() {
    return gotBlock;
  }
}

