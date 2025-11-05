package frc.robot.subsystems.grabber;

import com.ctre.phoenix6.hardware.TalonFX;

import frc.robot.subsystems.grabber.GrabberConstants.Grabber;

public class GrabberIOHardware {
    private TalonFX grabber_motor_;

    public GrabberIOHardware() {
        grabber_motor_ = new TalonFX(GrabberConstants.Grabber.kMotorCANID);
    }
}
