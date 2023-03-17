package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
import java.util.function.DoubleSupplier;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class DriveCommand extends CommandBase {
  private final DriveSystem m_driveTrain;
  private DoubleSupplier fwd, rot;
  //private final double m_speed;
  
  //private final double m_rotate;
  
  public DriveCommand(DriveSystem m_driveTrain, DoubleSupplier fwd, DoubleSupplier rot) {
    this.m_driveTrain = m_driveTrain;
    this.fwd = fwd;
    this.rot = rot;
    addRequirements(m_driveTrain);
  }
  
  @Override

  public void initialize() {

    System.out.println("Starting controller drive command");
  }
  
  @Override 

  public void execute() {
    m_driveTrain.arcadeDrive(-fwd.getAsDouble(), rot.getAsDouble());

    /*
    double rotate = -this.m_rotate;
    SmartDashboard.putNumber("rotate", rotate);
    this.m_driveTrain.drive(this.m_speed, rotate);
    SmartDashboard.putNumber("driving", this.m_speed);
    */
  }
  
  public void end(boolean interrupted) {
    m_driveTrain.drive(0.0D, 0.0D);
  }
  
  @Override
  public boolean isFinished() {
    return false;
  }
}
