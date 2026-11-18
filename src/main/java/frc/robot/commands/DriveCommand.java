package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.subsystems.Drivetrain;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Subsystem;

import java.util.HashSet;
import java.util.function.DoubleSupplier;

/** An example command that uses an example subsystem. */
public class DriveCommand extends Command {
  @SuppressWarnings("PMD.UnusedPrivateField")
  Drivetrain drivetrain;
  DoubleSupplier xSupplier, ySupplier, rotSupplier;

  /**
   * Creates a new ExampleCommand.
   *
   * @param subsystem The subsystem used by this command.
   */
  public DriveCommand(Drivetrain drivetrain, DoubleSupplier xSupplier, DoubleSupplier ySupplier, DoubleSupplier rotSupplier) {
        this.drivetrain = drivetrain;
        this.xSupplier = xSupplier;
        this.ySupplier = ySupplier;
        this.rotSupplier = rotSupplier;
        addRequirements(drivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    drivetrain.drive.driveFieldOriented(new ChassisSpeeds());
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}


    
    @Override
    public HashSet<Subsystem> getRequirements(){
        HashSet<Subsystem> req = new HashSet<>();
        req.add (drivetrain);
        return req;
       
    
    }
}
