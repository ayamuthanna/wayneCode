package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LauncherSystem extends SubsystemBase {
  private final CANSparkMax m_motor1 = new CANSparkMax(5, CANSparkMaxLowLevel.MotorType.kBrushless);
  
  private final RelativeEncoder m_climbEncoder = this.m_motor1.getEncoder();

  public LauncherSystem() {
    reset();
    this.m_climbEncoder.setPositionConversionFactor(100.0D);
  }
  
  public void periodic() {
    log();
  }
  
  public void reset() {
    this.m_climbEncoder.setPosition(0.0D);
  }
  
  public void log() {
    SmartDashboard.putNumber("climber height", this.m_climbEncoder.getPosition());
  }
  
  public void launch(double speed) {
    this.m_motor1.set(speed);
  }
}
