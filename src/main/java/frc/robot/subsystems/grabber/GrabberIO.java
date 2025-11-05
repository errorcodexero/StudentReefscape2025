package frc.robot.subsystems.grabber;

import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Radians;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecondPerSecond;
import static edu.wpi.first.units.Units.Volts;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularAcceleration;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;

public interface GrabberIO {
    
    @AutoLog
    public class GrabberIOInputs {

        public Angle grabberPosition = Radians.zero();
        public AngularVelocity grabberVelocity = RadiansPerSecond.zero();
        public AngularAcceleration grabberAccel = RadiansPerSecondPerSecond.zero();
        public Voltage grabberVoltage = Volts.zero();
        public Current grabberCurrent = Amps.zero();

        public boolean hasAlgae = false;
        public boolean algaeSensor1 = false;
        public boolean algaeSensor2 = false;

        public boolean hasCoral = false;
        public boolean coralSensor = false;
    }

    public default void updateInputs(GrabberIOInputs inputs){};

    public default void setGrabberVoltage(Voltage voltage){};

    public default void setGrabberTarget(Angle angle){};


}
