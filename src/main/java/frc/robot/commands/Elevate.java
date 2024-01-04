package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Lift.Target;

public class Elevate extends CommandBase {
  private Lift m_lift;
  private double speed;
  
  public Elevate(Lift lift, Target target) {
    m_lift = lift;

    speed = target == Target.TOP ? 0.2 : -0.2;

    addRequirements(m_lift);
  }

  @Override
  public void initialize() {
    System.out.println("Elevate initialized");
    System.out.println("Target: " + (speed > 0 ? "top" : "bottom"));
    System.out.println("Speed: " + speed);
    System.out.println();

    m_lift.set(speed);
  }

  @Override
  public void execute() {
  }

  @Override
  public void end(boolean interrupted) {
    System.out.println("Stopped Elevator");
    m_lift.set(0);
  }

  @Override
  public boolean isFinished() {
    return m_lift.isBottomSwitchPressed() || m_lift.isTopSwitchPressed();
  }
}
