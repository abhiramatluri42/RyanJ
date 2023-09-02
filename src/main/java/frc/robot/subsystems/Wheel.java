// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Wheel extends SubsystemBase {
  public static CANSparkMax Wheel = new CANSparkMax(0, MotorType.kBrushless);
  /** Creates a new Wheel. */
  public Wheel() {
      
  }

  public static void forward() {
    Wheel.setVoltage(1);
  }

  public void backward() {
    Wheel.setVoltage(-1);
  }

  public void stop() {
    Wheel.setVoltage(0);
  }
  
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
