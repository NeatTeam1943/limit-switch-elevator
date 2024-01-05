package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Lift extends SubsystemBase {
  public enum Target {
    TOP(-0.2),
    BOTTOM(0.2);

    private double m_speed;

    private Target(double speed) {
      m_speed = speed;
    }

    public double getSpeed() {
      return m_speed;
    }
  }

  private CANSparkMax m_motor;
  private DigitalInput m_topSwitch, m_bottomSwitch;

  public Lift() {
    m_motor = new CANSparkMax(1, CANSparkMax.MotorType.kBrushless);

    m_topSwitch = new DigitalInput(0);
    m_bottomSwitch = new DigitalInput(1);
  }

  public void set(double speed) {
    m_motor.set(speed);
  }

  public boolean isTopSwitchPressed() {
    return m_topSwitch.get();
  }

  public boolean isBottomSwitchPressed() {
    return m_bottomSwitch.get();
  }
}
