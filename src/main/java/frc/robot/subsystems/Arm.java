// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Arm extends SubsystemBase {
  /** Creates a new Arm. */
  private static AbsoluteEncoder encoder;
  private static CANSparkMax ArmMotor;
  private static PIDController pid;
  private int kP, kI, kD;
  private static int upPoint;
  private static int downPoint;

  public Arm() {
    ArmMotor = new CANSparkMax(0, MotorType.kBrushless);
    encoder.setPositionConversionFactor(2*Math.PI);
    pid = new PIDController(kP, kI, kD);
    kP = 0;
    kI = 0;
    kD = 0;
    upPoint = 100;
    downPoint = 0;
  }

  public static void moveUp() {
    ArmMotor.setVoltage(pid.calculate(encoder.getPosition(), upPoint));
  }
  public static void stop() {
    ArmMotor.setVoltage(0);
  }

  public static void moveDown(){
    ArmMotor.setVoltage(pid.calculate(encoder.getPosition(), downPoint));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
