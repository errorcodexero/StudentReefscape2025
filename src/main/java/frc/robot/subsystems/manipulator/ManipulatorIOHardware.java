package frc.robot.subsystems.manipulator;
import static edu.wpi.first.units.Units.*;

import org.xerosw.util.TalonFXFactory;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.SoftwareLimitSwitchConfigs;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.fasterxml.jackson.databind.cfg.MapperConfig;

import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.math.numbers.N1;
import edu.wpi.first.math.numbers.N2;
import edu.wpi.first.math.system.LinearSystem;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.DutyCycleEncoderSim;


public class ManipulatorIOHardware implements ManipulatorIO  {

    private StatusSignal <Angle> elevator_pos_sig; 
    private StatusSignal <AngularVelocity> elevator_vel_sig;
    private StatusSignal <Voltage> elevator_1_vol_sig; 
    private StatusSignal <Current> elevator_1_current_sig;
    
    private StatusSignal <Voltage> elevator_2_vol_sig; 
    private StatusSignal <Current> elevator_2_current_sig_; 
    
    private Voltage elevator_voltage_;
    
    private final Debouncer armErrorDebounce_= new Debouncer(0.5);
    private final Debouncer elevator1ErrorDebounce_= new Debouncer(0.5);
    private final Debouncer elevator2ErrorDebounce_= new Debouncer(0.5);
    
    
    public ManipulatorIOHardware() throws Exception {
        //createArm() ;
                createElevator() ; 
                
                
                //sets the final update frequency to the motors 
                TalonFXFactory.checkError(-2,"set manipulator frequnecy", () ->
                BaseStatusSignal.setUpdateFrequencyForAll(
                50.0, 
                elevator_pos_sig,
                elevator_vel_sig,
                elevator_1_current_sig,
                elevator_2_vol_sig,
                elevator_2_current_sig_
                )
                );
                
            }
            private void createArm() {
                
            }
            private void createElevator() throws Exception {
        elevator_motor_= TalonFXFactory.createTalonFX(
        ManipulatorConstants.Elevator.kMotorFrontCANID,
        ManipulatorConstants.Elevator.kCANBusName,
        ManipulatorConstants.Elevator.kInverted,
        ManipulatorConstants.Elevator.kCurrentLimit,
        ManipulatorConstants.Elevator.kCurrentLimitTime
        );
        elevator_motor_.setPosition(Degrees.of(0)); 
        
        elevator_motor_2= TalonFXFactory.createTalonFX(
        ManipulatorConstants.Elevator.kMotorBackCANID,
        ManipulatorConstants.Elevator.kCANBusName,
        ManipulatorConstants.Elevator.kInverted,
        ManipulatorConstants.Elevator.kCurrentLimit,
        ManipulatorConstants.Elevator.kCurrentLimitTime
        );
        elevator_motor_2.setControl(new Follower(ManipulatorConstants.Elevator.kMotorFrontCANID, false));
        
        //configurations for the elevator 
        Slot0Configs elevator_pids = new Slot0Configs();
        elevator_pids.kP = ManipulatorConstants.Elevator.PID.kP;
        elevator_pids.kI = ManipulatorConstants.Elevator.PID.kI;
        elevator_pids.kD = ManipulatorConstants.Elevator.PID.kD;
        elevator_pids.kV = ManipulatorConstants.Elevator.PID.kV;
        elevator_pids.kA = ManipulatorConstants.Elevator.PID.kA;
        elevator_pids.kG = ManipulatorConstants.Elevator.PID.kG;
        elevator_pids.kS = ManipulatorConstants.Elevator.PID.kS;
        
        MotionMagicConfigs elevatorMotionMagicConfigs = new MotionMagicConfigs();
        elevatorMotionMagicConfigs.MotionMagicCruiseVelocity = ManipulatorConstants.Elevator.MotionMagic.kMaxVelocity.in(RotationsPerSecond) ;
        elevatorMotionMagicConfigs.MotionMagicAcceleration = ManipulatorConstants.Elevator.MotionMagic.kMaxAcceleration.in(RotationsPerSecondPerSecond) ;
        elevatorMotionMagicConfigs.MotionMagicJerk = ManipulatorConstants.Elevator.MotionMagic.kJerk;
         
        private 
        
            {
        }
    }
            // updates all of the inputs from manipulatorIO 
            @Override 
            public class ManipulatorIO {
            public void updateInputs(ManipulatorIOInputs inputs) {
 
            }
    }
}
    

                
                
                
                
                