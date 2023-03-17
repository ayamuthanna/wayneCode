package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.ArmSystem;

public class LiftCommand extends CommandBase {
  private final ArmSystem m_arm;
  
  public LiftCommand(ArmSystem subsystem) {
    this.m_arm = subsystem;
    addRequirements(this.m_arm);
  }
  
  public void initialize() {}
  
  public void execute() {
    this.m_arm.moveLauncher(0.2D);
  }
  
  public void end(boolean interrupted) {
    this.m_arm.moveLauncher(0.0D);
  }
  
  public boolean isFinished() {
    return false;
  }
}
