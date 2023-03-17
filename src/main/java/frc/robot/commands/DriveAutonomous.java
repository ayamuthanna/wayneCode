package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveSystem;
import java.util.function.DoubleSupplier;
import frc.robot.subsystems.LauncherSystem;

public class DriveAutonomous extends CommandBase {
  private final DriveSystem m_driveTrain;
  
  private final LauncherSystem m_launcher;
  
  private final Timer timer = new Timer();
  
  public DriveAutonomous(DriveSystem driveTrain, LauncherSystem launcher) {
    this.m_driveTrain = driveTrain;
    this.m_launcher = launcher;
    addRequirements(this.m_driveTrain);
  }
  
  public void initialize() {
    this.timer.reset();
    this.timer.start();
  }
  
  public void execute() {
    if (isFinished()) return;
    /*DoubleSupplier s = () -> 0.25D;
    DoubleSupplier rot = () -> 0.25D;
    new DriveCommand(m_driveTrain, s, rot);*/
    //this.m_driveTrain.drive(1.0D, 0.0D);

    while (timer.get() < 2) {
      m_launcher.launch(1);
      return;
    }

    m_launcher.launch(0);
      this.m_driveTrain.arcadeDrive(-0.50d, 0);
  }

  public void end(boolean interrupted) {
    this.m_driveTrain.drive(0.0D, 0.0D);
  }
  
  public boolean isFinished() {
    return (this.timer.get() >= 5.63D);
  }
}
 