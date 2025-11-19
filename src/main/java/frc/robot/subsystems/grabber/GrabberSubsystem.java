package frc.robot.subsystems.grabber;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static edu.wpi.first.units.Units.Milliseconds;
import static edu.wpi.first.units.Units.Rotations;
import static edu.wpi.first.units.Units.Seconds;
import static edu.wpi.first.units.Units.Volts;

import org.littletonrobotics.junction.Logger;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.Time;
import edu.wpi.first.units.measure.Voltage;
import edu.wpi.first.wpilibj.Alert;
import edu.wpi.first.wpilibj.Alert.AlertType;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.sysid.SysIdRoutine;
import frc.robot.subsystems.grabber.GrabberIO.GrabberIOInputs;


public class GrabberSubsystem extends SubsystemBase{
    public enum GrabberStates{
        Collecting,
        Stationary,
        Ejecting,
        Grabbing
    }
    private final GrabberIO io_;
    //Figure out grabber target rotation
    //Using 1 as a placeholder for now
    private Angle target_grabber= Rotations.of(1);
    private final GrabberIOInputs inputs_;
    private GrabberStates states;
    public int ejectswitch;

    //Constructor
    public GrabberSubsystem(GrabberIO io){
        io= io_;
        ejectswitch=0;
        inputs_= new GrabberIOInputs();
        target_grabber= Rotations.zero();
        states= GrabberStates.Stationary;
    }


    @Override

    public void periodic(){
        io_.updateInputs(inputs_);
        Logger.processInputs("Grabber", inputs_);
        Logger.recordOutput("Grabber/angle/target", target_grabber);
        if(states== GrabberStates.Stationary){
            if(hasCoralBool()==false){
                collectCoral();
                states=GrabberStates.Collecting;
            }
        } else if(states==GrabberStates.Collecting){
            AlignCoral();
            states=GrabberStates.Ejecting;
        } else if(states== GrabberStates.Ejecting){
            ejectCoral();
            if(ejectswitch==1){
                ejectAlgae();
                states=GrabberStates.Stationary;
            }
            states= GrabberStates.Grabbing;
        } else if(states== GrabberStates.Grabbing){
            grabAlgae();
            ejectswitch=1;
            states= GrabberStates.Ejecting;
        }
    }
    

    //Subsystem Methods 

    public boolean hasAlgaeBool(){
        if(inputs_.algaeSensor1|| inputs_.algaeSensor2){
            inputs_.hasAlgae= true;
            return true;
        }
        return false;
    }
//ask "not"
//Ask grabber angle
    public boolean hasCoralBool(){
        if(inputs_.coralSensor){
            inputs_.hasCoral= true;
            return true;
        }
        return false;
    }

    public Command grabAlgae(){
        return runOnce(() -> {
            if(hasAlgaeBool()==false){
                io_.setGrabberVoltage(Volts.of(1));
                if(hasAlgaeBool()==true){
                    io_.setGrabberVoltage(Volts.zero());
                }
            }
        });
    }

    public Command collectCoral(){
        return runOnce(() -> {
            if(hasCoralBool()==false){
                io_.setGrabberVoltage(Volts.of(1));
                if(hasCoralBool()==true){
                    io_.setGrabberVoltage(Volts.zero());
                }
            }
        });
    }

    public Command ejectCoral(){
        return runOnce(() -> {
            if(hasCoralBool()==true || hasCoralBool()==false){
                io_.setGrabberVoltage(Volts.of(1.2));
                if(hasCoralBool()==false){
                    io_.setGrabberVoltage(Volts.zero());
                }
            }
        });
    }

    public Command AlignCoral(){
        return runOnce(() -> {
            if(hasCoralBool()==true){
                io_.setGrabberVoltage(Volts.of(-1));
                if(hasCoralBool()==false){
                    io_.setGrabberVoltage(Volts.zero());
                }
            }
        });
    }

    public Command ejectAlgae(){
        return runOnce(() ->{
            if(hasAlgaeBool()==true){
                io_.setGrabberVoltage(Volts.of(-1));
                if(hasAlgaeBool()==false){
                    io_.setGrabberVoltage(Volts.zero());
                }
            }
        });
    }
}