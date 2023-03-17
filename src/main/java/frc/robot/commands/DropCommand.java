package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSystem;

public class DropCommand extends CommandBase {
  private final ArmSystem m_arm;
  
  public DropCommand(ArmSystem subsystem) {
    this.m_arm = subsystem;
    addRequirements(this.m_arm);
  }
  
  public void initialize() {}
  
  public void execute() {
    this.m_arm.moveLauncher(-0.18D);
  }
  
  public void end(boolean interrupted) {
    this.m_arm.moveLauncher(0.0D);
  }
  
  public boolean isFinished() {
    return false;
  }
}
