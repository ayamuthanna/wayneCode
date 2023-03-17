package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel;
import com.revrobotics.RelativeEncoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ArmSystem extends SubsystemBase {
  private final CANSparkMax m_motor1 = new CANSparkMax(6, CANSparkMaxLowLevel.MotorType.kBrushless);
  
  private final RelativeEncoder m_armEncoder = this.m_motor1.getEncoder();
  
  public ArmSystem() {
    reset();
    this.m_armEncoder.setPositionConversionFactor(10.0D);
  }
  
  public void periodic() {}
  
  public void moveLauncher(double speed) {
    this.m_motor1.set(speed);
  }
  
  public void reset() {
    this.m_armEncoder.setPosition(0.0D);
  }
}
