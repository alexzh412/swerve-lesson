package frc.robot.commands;

import java.util.HashSet;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;

public class DriveCommand extends Command {
    Drivetrain drivetrain;
    DoubleSupplier xSupplier, ySupplier, thetaSupplier; 
    public DriveCommand(Drivetrain drivetrain, DoubleSupplier xSupplier, DoubleSupplier ySupplier, DoubleSupplier thetaSupplier){
        this.drivetrain=drivetrain;
        this.xSupplier=xSupplier;
        this.ySupplier=ySupplier;
        this.thetaSupplier=thetaSupplier;
    }
    @Override
    public void execute(){
        drivetrain.m_swerveDrive.driveFieldOriented(new ChassisSpeeds(
        Constants.MAX_SPEED*xSupplier.getAsDouble(),
        Constants.MAX_SPEED*ySupplier.getAsDouble(),
        Constants.MAX_SPEED*thetaSupplier.getAsDouble()
        ));
    }
    
    @Override
    public HashSet<Subsystem> getRequirements(){
        HashSet<Subsystem> req = new HashSet<>();
        req.add (drivetrain);
        return req;
       
    
    }
}
