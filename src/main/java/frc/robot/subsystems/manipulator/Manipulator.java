package frc.robot.subsystems.manipulator;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.wpilibj2.command.SubsystemBase;


public class Manipulator extends SubsystemBase {

    private final ManipulatorIO io_;
    private final ManipulatorIOInputsAutoLogged inputs_;

    public Manipulator(ManipulatorIO io) {
        io_ = io;
        inputs_ = new ManipulatorIOInputsAutoLogged();
    }

    @Override
    public void periodic() {
        io_.updateInputs(inputs_);
    }

    
    // Elevator Methods

    public void setElevatorPosition() {}

    public Distance getElevatorPosition() {
            return null;
    }

    public boolean isElevatorAtTarget() {
            return false;
    }

    // Arm Methods

    public void setArmPosition() {}

    public Angle getArmPosition() {
            return null;
    }

    public boolean isArmAtTarget() {
            return false;
    }

    // General 

    public boolean doesCrossKeepOut() {
        return false;
    }
}
