package frc.robot;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.motorcontrol.Spark;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends TimedRobot {

  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private Spark leftMotor1 = new Spark(0);
  private Spark leftMotor2 = new Spark(1);
  private Spark rightMotor1 = new Spark(2);
  private Spark rightMotor2 = new Spark(3);
  private Spark coletorMotor1 = new Spark(4);
  private Spark shooterMotor1 = new Spark(5);
  private Spark shooterMotor2 = new Spark(6);
  private Spark shooterMotor3 = new Spark(8);
  private VictorSP upMotor1 = new VictorSP(7);
  private VictorSP upMotor2 = new VictorSP(9);
  DigitalInput limitSwitch1 = new DigitalInput(8);
  DigitalInput limitSwitch2 = new DigitalInput(9);
  private Joystick joy1 = new Joystick(0);
  private Joystick joy2 = new Joystick(1);
  double speed1 = -1;
  double turn1 = 0.6;
  double up1 = 1;
  double up2 = 1;
  double Maju = 1;
  double autonomo = 1;

  public void robotInit() {
    leftMotor1.addFollower(leftMotor2);
    rightMotor1.addFollower(rightMotor2);

  }

  public void robotPeriodic() {
    SmartDashboard.putNumber("Nível de Velocidade", speed1 * -10);

  }

  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    System.out.println("Auto selected: " + m_autoSelected);
    autonomo = 1;
  }

  public void autonomousPeriodic() {

    if (autonomo == 1) {
      shooterMotor1.set(-1);
      shooterMotor2.set(-1);
      try {
        Thread.sleep(1000);
      } catch (Exception erro) {
      }

      shooterMotor1.set(-1);
      shooterMotor2.set(-1);
      shooterMotor3.set(-1);
      try {
        Thread.sleep(1500);
      } catch (Exception erro) {
      }
      coletorMotor1.set(1);
      shooterMotor1.set(0);
      shooterMotor2.set(0);
      shooterMotor3.set(0);
      try {
        Thread.sleep(300);
      } catch (Exception erro) {
      }

      coletorMotor1.set(0);
      shooterMotor1.set(0);
      shooterMotor2.set(0);
      shooterMotor3.set(0);

      rightMotor1.set(-0.4);
      leftMotor1.set(0.32);
      coletorMotor1.set(1);
      try {
        Thread.sleep(1500);
      } catch (Exception erro) {
      }

      rightMotor1.set(0.0);
      leftMotor1.set(0.0);
      coletorMotor1.set(1);

      try {
        Thread.sleep(500);
      } catch (Exception erro) {
      }

      rightMotor1.set(0.4);
      leftMotor1.set(-0.32);
      try {
        Thread.sleep(1500);
      } catch (Exception erro) {
      }

      rightMotor1.set(0.0);
      leftMotor1.set(0.0);
      coletorMotor1.set(0.0);
      try {
        Thread.sleep(200);
      } catch (Exception erro) {
      }

      shooterMotor1.set(-1);
      shooterMotor2.set(-1);
      try {
        Thread.sleep(1000);
      } catch (Exception erro) {
      }

      shooterMotor1.set(-1);
      shooterMotor2.set(-1);
      shooterMotor3.set(-1);
      coletorMotor1.set(1);
      try {
        Thread.sleep(1500);
      } catch (Exception erro) {
      }
      coletorMotor1.set(0);
      shooterMotor1.set(0);
      shooterMotor2.set(0);
      shooterMotor3.set(0);
      try {
        Thread.sleep(200);
      } catch (Exception erro) {
      }

      rightMotor1.set(-0.4);
      leftMotor1.set(0.32);
      try {
        Thread.sleep(1500);
      } catch (Exception erro) {
      }
      autonomo = autonomo + 1;
      coletorMotor1.set(0.0);
      rightMotor1.set(0.0);
      leftMotor1.set(0.0);
    }

    else {
      coletorMotor1.set(0.0);
      rightMotor1.set(0.0);
      leftMotor1.set(0.0);
    }

  }

  public void teleopInit() {
    coletorMotor1.set(0);
    leftMotor1.set(0);
    leftMotor2.set(0);
    rightMotor1.set(0);
    rightMotor2.set(0);

  }

  public void teleopPeriodic() {

    double speed = joy1.getRawAxis(1) * speed1;
    double turn = joy1.getRawAxis(2) * turn1;

    double left = -speed + turn;
    double right = -speed - turn;

    leftMotor1.set(-left / 1.35);
    leftMotor2.set(-left / 1.35);
    rightMotor1.set(right);
    rightMotor2.set(right);

    if (joy1.getRawButtonPressed(8)) {
      if (Maju == 1) {
        speed1 = -1;
      } else {
        speed1 = 1;
      }
    }

    if (joy1.getRawButtonPressed(7)) {
      if (Maju == 1) {
        speed1 = -0.4;
      } else {
        speed1 = 0.4;
      }
    }

    if (joy1.getRawButtonPressed(6)) {
      if (Maju == 1) {
        if (speed1 <= -1) {
          speed1 = -1;
        } else {
          speed1 = speed1 - 0.1;
        }
      } else {
        if (speed1 <= 1) {
          speed1 = 1;
        } else {
          speed1 = speed1 + 0.1;
        }
      }

    }

    if (joy1.getRawButtonPressed(5)) {
      if (Maju == 1) {
        if (speed1 >= -0.4) {
          speed1 = -0.4;
        } else {
          speed1 = speed1 + 0.1;
        }

      } else {
        if (speed1 >= 0.4) {
          speed1 = 0.4;
        } else {
          speed1 = speed1 - 0.1;
        }
      }
    }

    if (joy1.getRawButtonPressed(4)) {
      Maju = Maju * -1;
      speed1 = speed1 * -1;

    }

    if (joy2.getRawButton(4)) {

      coletorMotor1.set(1);

    }

    if (joy2.getRawButtonReleased(4)) {
      coletorMotor1.set(0);
    }

    if (joy2.getRawButton(1)) {

      shooterMotor1.set(-1);
      shooterMotor2.set(-1);
      shooterMotor3.set(-1);

    }

    if (joy2.getRawButtonReleased(1)) {
      shooterMotor1.set(0);
      shooterMotor2.set(0);
      shooterMotor3.set(0);
    }

    if (joy2.getRawButton(2)) {

      shooterMotor1.set(-0.3);
      shooterMotor2.set(-0.3);
      shooterMotor3.set(-0.3);
    }

    if (joy2.getRawButtonReleased(2)) {
      shooterMotor1.set(0);
      shooterMotor2.set(0);
      shooterMotor3.set(0);
    }

    if (joy2.getRawButton(3)) {

      shooterMotor1.set(0.3);
      shooterMotor2.set(0.3);
      shooterMotor3.set(0.3);
    }

    if (joy2.getRawButtonReleased(3)) {
      shooterMotor1.set(0);
      shooterMotor2.set(0);
      shooterMotor3.set(0);
    }

    if (joy2.getRawButton(7)) {

      upMotor1.set(up1);
    }

    if (limitSwitch1.get()) {
      up1 = -1;
    } else {
      up1 = 0;
    }

    if (joy2.getRawButtonReleased(7)) {
      upMotor1.set(0);
    }

    if (joy2.getRawButton(8)) {

      upMotor2.set(up2);

    }

    if (limitSwitch2.get()) {
      up2 = 1;
    } else {
      up2 = 0;
    }

    if (joy2.getRawButtonReleased(8)) {
      upMotor2.set(0);
    }

    if (joy2.getRawButtonPressed(5)) {

      upMotor1.set(1);
    }

    if (joy2.getRawButtonReleased(5)) {
      upMotor1.set(0);
    }

    if (joy2.getRawButtonPressed(6)) {

      upMotor2.set(-1);
    }

    if (joy2.getRawButtonReleased(6)) {
      upMotor2.set(0);
    }

  }

  public void disabledInit() {
  }

  public void disabledPeriodic() {
  }

  public void testInit() {
  }

  public void testPeriodic() {
  }

  public void simulationInit() {
  }

  public void simulationPeriodic() {
  }
}