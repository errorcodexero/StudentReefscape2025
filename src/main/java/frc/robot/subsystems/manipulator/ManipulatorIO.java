package frc.robot.subsystems.manipulator;
import static edu.wpi.first.units.Units.Amps;
import static edu.wpi.first.units.Units.Degrees;
import static edu.wpi.first.units.Units.Meters;
import static edu.wpi.first.units.Units.MetersPerSecond;
import static edu.wpi.first.units.Units.RadiansPerSecond;
import static edu.wpi.first.units.Units.Volts;

import org.littletonrobotics.junction.AutoLog;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Distance;
import edu.wpi.first.units.measure.LinearVelocity;
import edu.wpi.first.units.measure.Voltage;



public interface ManipulatorIO  {
  @AutoLog
   public static class ManipulatorIOInputs {
    //inputs of postion,current,voltage and velocity (acceleration) 
    public static final AngularVelocity DegreesperSecond = null;
    
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
      //elevator contants (inputs of voltage and postion) 
       public boolean elevator1isReady = false;  
       public Voltage elevator1vVoltage = Volts.of(0);
       public  Current elevator1Current = Amps.of(0);

   }
     

