package frc.robot.commands.Vision_Commands;

import frc.robot.Constants;
import frc.robot.Vision.VisionCamera;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import java.util.concurrent.TimeUnit;

import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.motorcontrol.PWMTalonFX;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.vision.VisionRunner;
import edu.wpi.first.vision.VisionThread;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.VictorSPX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;
import io.github.pseudoresonance.pixy2api.Pixy2CCC.Block;


public class VisionTracking extends CommandBase {
    private static final int IMG_WIDTH = 316;
    private double centerX = 0.0;
    private DriveTrain m_DriveTrain;
    private VisionCamera m_visionRed;

  public VisionTracking(DriveTrain subsystem) {
        // Use addRequirements() here to declare subsystem dependencies.
        m_DriveTrain = subsystem;
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
        }
    else{
            centerX = 0;
        }
    int width = m_visionRed.getWidth();
    System.out.print("Width is" + width);
    double turn = centerX - (IMG_WIDTH / 2);
    String s=String.valueOf(turn);  
    String x=String.valueOf(centerX); 
    System.out.print("Turn value is" + s);
    System.out.print("X value is" + x);
    if (centerX == 0){
        m_DriveTrain.arcadeDrive(0, 0);
    }
    else if(centerX <= 168 && centerX >= 148){
        m_DriveTrain.arcadeDrive(0.6, 0);
    }
    else{
        m_DriveTrain.arcadeDrive(0, turn * 0.005);
    }
    
    try {
        Thread.sleep(100);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
  }
}

