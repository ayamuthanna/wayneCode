package frc.robot;

//import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.commands.DriveCommand;
import frc.robot.commands.DropCommand;
import frc.robot.commands.LiftCommand;
import frc.robot.commands.DriveAutonomous;
import frc.robot.commands.IntakeCommand;
import frc.robot.commands.LaunchCommand;
import frc.robot.subsystems.ArmSystem;
import frc.robot.subsystems.Camera;
import frc.robot.subsystems.DriveSystem;
import frc.robot.subsystems.LauncherSystem;

import java.util.Objects;
import java.util.function.DoubleSupplier;

public class RobotContainer {
    public final DriveSystem driveTrain = new DriveSystem();
    private final LauncherSystem launcher = new LauncherSystem();
    private final ArmSystem arm = new ArmSystem();
    private final Camera camera = new Camera();

    public static XboxController m_operatorController = new XboxController(0);




    public RobotContainer() {
        configureButtonBindings();
        Objects.requireNonNull(this.m_operatorController);
        //JoystickButton rightTrigger = new JoystickButton(this.m_operatorController, XboxController.Button.kRightBumper.value);
        //double z = this.m_operatorController.getZ();
        driveTrain.setDefaultCommand(new DriveCommand(
            driveTrain,
            () -> m_operatorController.getLeftY(), // m_operatorController.getRawAxis(1);
            () -> m_operatorController.getRightX())); //m_operatorController.getRawAxis(4); 
    }
/*
    public static float clamp(float value, float min, float max) {
        return Math.max(min, Math.min(max, value));
    }

    public static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
        
    }
    */

    private void configureButtonBindings() {
        POVButton o_dpadUp = new POVButton(this.m_operatorController, 0);
        POVButton o_dpadLeft = new POVButton(this.m_operatorController, 90);
        POVButton o_dpadDown = new POVButton(this.m_operatorController, 180);
        POVButton o_dpadRight = new POVButton(this.m_operatorController, 270);
        JoystickButton o_aButton = new JoystickButton(this.m_operatorController, XboxController.Button.kA.value);
        JoystickButton o_bButton = new JoystickButton(this.m_operatorController, XboxController.Button.kB.value);
        JoystickButton o_xButton = new JoystickButton(this.m_operatorController, XboxController.Button.kX.value);
        JoystickButton o_yButton = new JoystickButton(this.m_operatorController, XboxController.Button.kY.value);
        JoystickButton o_lBumberButton = new JoystickButton(this.m_operatorController, XboxController.Button.kLeftBumper.value);
        JoystickButton o_rBumberButton = new JoystickButton(this.m_operatorController, XboxController.Button.kRightBumper.value);
        JoystickButton o_lTriggerButton = new JoystickButton(this.m_operatorController, XboxController.Axis.kLeftTrigger.value);
        JoystickButton o_rTriggerButton = new JoystickButton(this.m_operatorController, XboxController.Axis.kRightTrigger.value);
        JoystickButton o_startButton = new JoystickButton(this.m_operatorController, XboxController.Button.kStart.value);
        JoystickButton o_lStickButton = new JoystickButton(this.m_operatorController, XboxController.Button.kLeftStick.value);
        JoystickButton o_rStickButton = new JoystickButton(this.m_operatorController, XboxController.Button.kRightStick.value);
        JoystickButton o_backButton = new JoystickButton(this.m_operatorController, XboxController.Button.kBack.value);
        o_aButton.whenHeld(new DropCommand(this.arm));
        o_yButton.whenHeld(new LiftCommand(this.arm));
       // o_yButton.whenHeld(new AscendCommand(this.climber));
        //o_bButton.whenHeld(new DescendCommand(this.climber)); ggg
        o_rTriggerButton.whenHeld(new LaunchCommand(this.launcher));
        o_lTriggerButton.whenHeld(new IntakeCommand(this.launcher));
        // o_lstick
        //o_lBumberButton.whenHeld(new DriveCommand(0.3d, 0, this.driveTrain));
        /*
        o_lTriggerButton.whenHeld(new DriveCommand(-1, m_operatorController.getRightX(), this.driveTrain));
        o_rTriggerButton.whenHeld(new DriveCommand(1, m_operatorController.getRightX(), this.driveTrain));
        o_lBumberButton.whenHeld(new DriveCommand(-0.4, m_operatorController.getRightX(), this.driveTrain));
        o_rBumberButton.whenHeld(new DriveCommand(0.4, m_operatorController.getRightX(), this.driveTrain));
        */
    }

    public Command getAutonomousCommand() {
        return new DriveAutonomous(this.driveTrain, this.launcher);
    }
}
