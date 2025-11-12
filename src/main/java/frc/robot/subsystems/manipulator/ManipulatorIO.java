package frc.robot.subsystems.manipulator;
import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import org.littletonrobotics.junction.AutoLog;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;



public interface ManipulatorIO  {
  @AutoLog
   public static class ManipulatorIOInputs {
    //inputs of postion,current,voltage and velocity (acceleration) 
    public class ArmStatus {
      public boolean armReady = false;
      public Angle armPosition = Degrees.of(0);
      public Current armCurrent = null;
      public Voltage armVoltage = null;
      public AngularVelocity armVelocity = RadiansPerSecond.of(0);
      public Angle armRawMotorPosition = Degrees.of(0);
      public AngularVelocity  armRawMotorVelocity = DegreesperSecond  
  
   
   }
}
