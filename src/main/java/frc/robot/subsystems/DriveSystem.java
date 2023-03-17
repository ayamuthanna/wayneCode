package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class DriveSystem extends SubsystemBase {
  CANSparkMax leftMotor1 = new CANSparkMax(Constants.DriveTrainConstants.leftmotor1CANID, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax leftMotor2 = new CANSparkMax(Constants.DriveTrainConstants.leftmotor2CANID, CANSparkMaxLowLevel.MotorType.kBrushless);
  
  CANSparkMax rightMotor1 = new CANSparkMax(Constants.DriveTrainConstants.rightmotor1CANID, CANSparkMaxLowLevel.MotorType.kBrushless);
  CANSparkMax rightMotor2 = new CANSparkMax(Constants.DriveTrainConstants.rightmotor2CANID, CANSparkMaxLowLevel.MotorType.kBrushless);
  
 RelativeEncoder m_leftEncoder = leftMotor1.getEncoder();
 RelativeEncoder m_rightEncoder = rightMotor1.getEncoder();
  
 MotorControllerGroup m_leftMotors = new MotorControllerGroup(leftMotor1, leftMotor2);
 MotorControllerGroup m_rightMotors = new MotorControllerGroup(rightMotor1, rightMotor2);
  
DifferentialDrive m_drive = new DifferentialDrive(m_leftMotors, m_rightMotors);
  
  public DriveSystem() {

    leftMotor1.restoreFactoryDefaults();
    leftMotor2.restoreFactoryDefaults();
    rightMotor1.restoreFactoryDefaults();
    rightMotor2.restoreFactoryDefaults();
  
    m_leftEncoder.setPosition(0);
    m_rightEncoder.setPosition(0);
    
    leftMotor1.follow(leftMotor2);
    rightMotor2.follow(rightMotor2);

    m_leftMotors.setInverted(true);
    m_rightMotors.setInverted(false);
  }
  
  public void arcadeDrive(double fwd, double rot)
  {
    m_drive.arcadeDrive(fwd,rot);
  }
  public void periodic() {
    //log();
  }
  
  public void drive(double leftVolts, double rightVolts) {
    m_leftMotors.setVoltage(-leftVolts);
    m_rightMotors.setVoltage(rightVolts);

    m_drive.feed();
  }
 /* 
  public double getDistance() {
    return (this.m_leftEncoder.getPosition() - this.m_rightEncoder.getPosition()) / 2.0D;
  }
  
  public double getVelocity() {
    return (this.m_leftEncoder.getVelocity() - this.m_rightEncoder.getVelocity()) / 2.0D;
  }
  
  public void reset() {
    this.m_leftEncoder.setPosition(0.0D);
    this.m_rightEncoder.setPosition(0.0D);
  }
  
  public void log() {
    SmartDashboard.putNumber("Left Distance", this.m_leftEncoder.getPosition());
    SmartDashboard.putNumber("Right Distance", -this.m_rightEncoder.getPosition());
    SmartDashboard.putNumber("Left Speed", this.m_leftEncoder.getVelocity());
    SmartDashboard.putNumber("Right Speed", -this.m_rightEncoder.getVelocity());
  }
  */

}
