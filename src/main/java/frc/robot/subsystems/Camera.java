package frc.robot.subsystems;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.cscore.UsbCamera;



public class Camera extends SubsystemBase {

    public Camera(){
        // UsbCamera frontCam = CameraServer.getInstance().startAutomaticCapture(0);
        UsbCamera frontCam = CameraServer.startAutomaticCapture(0);
        frontCam.setFPS(15);
        UsbCamera checkCam = CameraServer.startAutomaticCapture(1);
    }
/* 
    @Override

    public void initDefaultCommand()
    {

    }
    
    
*/
}