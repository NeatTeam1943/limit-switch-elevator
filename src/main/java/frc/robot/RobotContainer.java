// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.Trigger;
import frc.robot.commands.Elevate;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Lift.Target;

public class RobotContainer {
  private Lift m_lift;
  private XboxController m_controller;

  private Trigger aTrigger;
  private Trigger bTrigger;

  public RobotContainer() {
    m_controller = new XboxController(0);

    aTrigger = new Trigger(m_controller::getAButton);
    bTrigger = new Trigger(m_controller::getBButton);
    
    m_lift = new Lift();

    configureButtonBindings();
  }

  private void configureButtonBindings() {
    aTrigger.toggleWhenActive(new Elevate(m_lift, Target.TOP));
    bTrigger.toggleWhenActive(new Elevate(m_lift, Target.BOTTOM));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
