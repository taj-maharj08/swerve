// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;

  private CommandXboxController m_controller = new CommandXboxController(0);
  private DoubleSupplier m_leftStickSupplier, m_rightStickSupplier;
  private CANSparkMax m_motor1, m_motor2;


  @Override
  public void robotInit() {
    m_motor1 = new CANSparkMax(0, MotorType.kBrushless);
    m_motor2 = new CANSparkMax(1, MotorType.kBrushless);
  }

  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
    configureBindings();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void disabledExit() {}

  @Override
  public void autonomousInit() {}

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void autonomousExit() {}

  @Override
  public void teleopInit() {
  }

  private void configureBindings() {
    m_leftStickSupplier = m_controller::getLeftY;
    m_rightStickSupplier = m_controller::getRightY;
  }

  @Override
  public void teleopPeriodic() {
    m_motor1.set(m_leftStickSupplier.getAsDouble());
    m_motor2.set( m_rightStickSupplier.getAsDouble());
  }

  @Override
  public void teleopExit() {}

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}

  @Override
  public void testExit() {}

}
