// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

/*  Imports  */
//    REV Imports
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkBase.IdleMode;
import com.revrobotics.CANSparkLowLevel.MotorType;
//    WPI Imports
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//    Robot Imports
import frc.robot.Constants;

public class Drivebase extends SubsystemBase {
  /*    Creating Motors */
  //      Left Motors
  private CANSparkMax leftDrive1;
  private CANSparkMax leftDrive2;

  //      Right Motors
  private CANSparkMax rightDrive1;
  private CANSparkMax rightDrive2;

  /** Creates a new Drivebase. */
  public Drivebase() {
    /*    Initializing Motors */
    //      Left Motors 
    leftDrive1 = new CANSparkMax(Constants.DriveConstants.leftDrive1_ID, MotorType.kBrushed);
    leftDrive2 = new CANSparkMax(Constants.DriveConstants.leftDrive2_ID, MotorType.kBrushed);
    //      Right Motors
    rightDrive1 = new CANSparkMax(Constants.DriveConstants.rightDrive1_ID, MotorType.kBrushed);
    rightDrive2 = new CANSparkMax(Constants.DriveConstants.rightDrive2_ID, MotorType.kBrushed);

    //    Make Motors Follow One-Another
    leftDrive2.follow(leftDrive1);
    rightDrive2.follow(rightDrive1);

    /*    Inverts left motors */
    //      Makes Left motors spin in the same direction as right motors
    leftDrive1.setInverted(true);

    /*    Set Motor Idle Mode */
    //      Makes motors default mode to brake
    leftDrive1.setIdleMode(IdleMode.kBrake);
    rightDrive1.setIdleMode(IdleMode.kBrake);
  }
  //      Makes Motors spin forward
  public void forward(){
    leftDrive1.set(1);
    rightDrive1.set(1);
  }
  //      Makes Motors spin backward
  public void backward(){
    leftDrive1.set(-1);
    rightDrive1.set(-1);
  }
  //      Makes Motors spin at adjustable speeds
  public void drive(double left, double right){
    leftDrive1.set(left);
    rightDrive1.set(right);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
  
}
