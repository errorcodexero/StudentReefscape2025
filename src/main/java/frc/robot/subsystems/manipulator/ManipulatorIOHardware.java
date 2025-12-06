package frc.robot.subsystems.manipulator;
import static edu.wpi.first.units.Units.*;
import com.ctre.phoenix6.hardware.TalonFX;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.simulation.DutyCycleEncoderSim;


public class ManipulatorIOHardware implements ManipulatorIO  {
    private TalonFX arm_motor_;
    private TalonFX elevator_motor;
    private TalonFX elevator_motor_2; 
    private DutyCycleEncoder encoder_;

    private DCMotorSim arm_Sim;
    private DCMotorSim elevator_Sim;
    private DutyCycleEncoderSim arm_encoder_sim;
    private boolean encoder_motor_Synced;
}
