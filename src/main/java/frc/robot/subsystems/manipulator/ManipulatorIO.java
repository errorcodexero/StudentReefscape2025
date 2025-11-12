package frc.robot.subsystems.manipulator;

import static edu.wpi.first.units.Units.*;

import org.littletonrobotics.junction.AutoLog;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Voltage;

public interface ManipulatorIO {
    @AutoLog
    public static class ManipulatorIOInputs {
        
        // Arm
        public boolean armReady = false;
        public Angle armPosition = Degrees.of(0); 
        public Current armCurrent = Amps.of(0); 
        public Voltage armVoltage = Volts.of(0); 
        public AngularVelocity armVelocity = RadiansPerSecond.of(0); 
        public Angle armRawMotorPosition = Degrees.of(0);
        public AngularVelocity armRawMotorVelocity = DegreesPerSecond.of(0.0) ;
      
        // Elevator
        public Distance elevatorPosition = Meters.of(0); 
        public LinearVelocity elevatorVelocity = MetersPerSecond.of(0); 
        public Angle elevatorRawMotorPosition = Degrees.of(0);
        public AngularVelocity elevatorRawMotorVelocity = DegreesPerSecond.of(0.0) ;

        // Elevator 1
        public boolean elevator1Ready = false;
        public Voltage elevator1Voltage = Volts.of(0);
        public Current elevator1Current = Amps.of(0);  

        // Elevator 2
        public boolean elevator2Ready = false;
        public Voltage elevator2Voltage = Volts.of(0);
        public Current elevator2Current = Amps.of(0); 

        // Encoder
        public Angle absoluteEncoder = Degrees.of(0); 
        public double rawAbsoluteEncoder = 0;
    }

    public default void updateInputs(ManipulatorIOInputs inputs) {}
}
