package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LauncherSystem;

public class IntakeCommand extends CommandBase {
  private final LauncherSystem m_launcher;
  
  public IntakeCommand(LauncherSystem subsystem) {
    this.m_launcher = subsystem;
    addRequirements(this.m_launcher);
  }
  
  public void initialize() {}
  
  public void execute() {
    this.m_launcher.launch(1.0D);
  }
  
  public void end(boolean interrupted) {
    this.m_launcher.launch(0.0D);
  }
  
  public boolean isFinished() {
    return false;
  }
}
