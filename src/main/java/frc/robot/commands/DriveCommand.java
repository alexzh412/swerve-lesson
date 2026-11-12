package frc.robot.commands;

import java.util.HashSet;
import java.util.function.DoubleSupplier;

import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;
import frc.robot.Constants;
import frc.robot.subsystems.SwerveDriveSubsystem;
import swervelib.SwerveInputStream;

public class DriveCommand extends Command {
    SwerveDriveSubsystem swerveDrivetrain;
    SwerveInputStream swerveInputStream; //data values constantly supplied from encoders


    //Constructor
    public DriveCommand(SwerveDriveSubsystem swerveDrivetrain, DoubleSupplier xSupplier, DoubleSupplier ySupplier, DoubleSupplier thetaSupplier){
        this.swerveDrivetrain = swerveDrivetrain;
        this.swerveInputStream = SwerveInputStream.of(swerveDrivetrain.getSwerveDrive(), xSupplier, ySupplier).withControllerRotationAxis(thetaSupplier).deadband(.05);
        addRequirements(swerveDrivetrain);

    }

    @Override
    public void execute(){
       swerveDrivetrain.driveFieldOriented(swerveInputStream.get());
    }

    @Override
    public boolean isFinished(){
        return false; //stops
    }
    
}
