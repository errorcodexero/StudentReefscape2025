package frc.robot.subsystems.grabber;

import static edu.wpi.first.units.Units.*;

import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusCode;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.configs.MotionMagicConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.MotionMagicVelocityVoltage;
import com.ctre.phoenix6.controls.MotionMagicVoltage;
import com.ctre.phoenix6.controls.VoltageOut;

import edu.wpi.first.math.filter.Debouncer;
import edu.wpi.first.math.filter.MedianFilter;
import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import edu.wpi.first.units.measure.Current;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.sysid.SysIdRoutineLog;

import frc.robot.subsystems.grabber.GrabberConstants.Grabber;

public class GrabberIOHardware implements GrabberIO{
    private TalonFX grabber_motor_;
    private Voltage voltage_;
    private DigitalInput algaesensor1;
    private DigitalInput algaesensor2;
    private DigitalInput coralsensor;
    private Current current_;

    public StatusSignal <AngularVelocity> grabber_positionvelocity_signal;
    public StatusSignal <Angle> grabber_position_signal;
    public StatusSignal <Voltage> grabber_voltage_signal;
    public StatusSignal <Current> grabber_current_signal;

    public GrabberIOHardware() throws Exception{
        grabber_motor_ = new TalonFX(GrabberConstants.Grabber.kMotorCANID);
        grabber_positionvelocity_signal= grabber_motor_.getVelocity();
        grabber_position_signal= grabber_motor_.getPosition();
        grabber_voltage_signal= grabber_motor_.getMotorVoltage();
        grabber_current_signal= grabber_motor_.getSupplyCurrent();


        Slot0Configs grabber_pids= new Slot0Configs();
        grabber_pids.kP= GrabberConstants.Grabber.PID.kP;
        grabber_pids.kA= GrabberConstants.Grabber.PID.kA;
        grabber_pids.kD= GrabberConstants.Grabber.PID.kD;
        grabber_pids.kG= GrabberConstants.Grabber.PID.kG;
        grabber_pids.kI= GrabberConstants.Grabber.PID.kI;
        grabber_pids.kS= GrabberConstants.Grabber.PID.kS;
        grabber_pids.kV= GrabberConstants.Grabber.PID.kV;

    }
}
