package frc.robot.subsystems.manipulator;
import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Volts;
import static edu.wpi.first.units.Units.Watts;
import org.littletonrobotics.junction.AutoLog;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Power;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj.sysid.SysIdRoutineLog;



public interface ManipulatorIO  {
  @AutoLog
  public static class ManipulatorIOInputs {
    //inputs of postion,current,voltage and velocity (acceleration) 
    
    public AngularVelocity DegreesperSecond = null;
    
    public class ArmStatus {
      
      public boolean armReady = false;
      public Angle armPosition = Degrees.of(0);
      public Current armCurrent = null;
      public Voltage armVoltage = null;
      public AngularVelocity armVelocity = RadiansPerSecond.of(0);
      public Angle armRawMotorPosition = Degrees.of(0);
      public AngularVelocity  armRawMotorVelocity = DegreesperSecond;  
      public int syncCount =  Integer.MAX_VALUE; 
      
      //constants for elevator part of the manipulator  
      public Distance elevatorPostion = Meters.of(0);
      public LinearVelocity elevatorVelocity = MetersPerSecond.of(0); 
      public Angle elevatorRawMotorPostion = Degrees.of(syncCount);
    }
  }
  
  //elevator contants (inputs of the voltage and postion) 
  public boolean elevator1isReady = false;  
  public Voltage elevator1vVoltage = Volts.of(0);
  public  Current elevator1Current = Amps.of(0);
  public Power  elevator1power = Watts.zero();
  public Power elevator1powerAvg = Watts.zero(); 

//elevator 2 constants (inputs of the voltage and postion)
public boolean elevator2isReady = false;
public Voltage elevator2vVoltage= Volts.of(0);
public Current elevator2Current = Amps.of(0);
public Power elevator2power= Watts.zero();
public Power elevator2powerAvg = Watts.zero(); 

//encoder 
public Angle absoluteEncoder = Degrees.of(0);
public double rawabsoluteEncoder = 0;
  
 // updating the inputs on the elevator 
   public default void updateInputs(ManipulatorIOInputs inputs) {}
    public default void toggleSyncing()  {} 
     
    //need for SYS ID support 
    public default void logArmMotor(SysIdRoutineLog log) {}

    public default void setElevatorMotorVoltage(double vol) {}

    public default void logElevatorMotor(SysIdRoutineLog log) {}

    // ELEVATOR METHODS
    public default void setElevatorTarget(Distance dist) {}
    public default void setElevatorPosition(Distance d) {} ;

    // ARM METHODS
    public default void setArmTarget(Angle angle) {}
}
  




