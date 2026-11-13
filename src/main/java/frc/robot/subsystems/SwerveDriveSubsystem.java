package frc.robot.subsystems;

import java.io.File;
import java.io.IOException;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj.Filesystem;

import swervelib.parser.SwerveParser;
import swervelib.SwerveDrive;

import yams.mechanisms.swerve.utility.SwerveInputStream;

public class SwerveDriveSubsystem extends SubsystemBase
{

  private SwerveDrive drive;

  public SwerveDriveSubsystem()
  {
    try {
      drive = new SwerveParser(new File(Filesystem.getDeployDirectory(), "swerve")).createSwerveDrive(6.7, new Pose2d());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /** Drive with a field relative SwerveInputStream. */
  public Command driveFieldRelative(SwerveInputStream stream)
  {
    return run(() -> drive.setChassisSpeeds(stream.get())).withName("Drive Field Relative");
  }

  /** Zero the gyro heading. Bind this to a button combo for field recovery. */
  public Command zeroGyro()
  {
    return Commands.runOnce(drive::zeroGyro, this).withName("Zero Gyro");
  }

  @Override
  public void periodic()
  {
    drive.updateOdometry();
  }

}
