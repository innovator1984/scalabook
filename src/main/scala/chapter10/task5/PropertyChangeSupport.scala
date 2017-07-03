package chapter10.task5

import java.beans.{PropertyChangeSupport => JavaPropertyChangeSupport,
  PropertyChangeListener=>JavaPropertyChangeListener}
import java.awt.Point

/**
  * Упражнение 5 из главы 10
  */
trait PropertyChangeSupport extends Point{

  private val pcs = new JavaPropertyChangeSupport(this)
  def addPropertyChangeListener(listener: JavaPropertyChangeListener): Unit = this.pcs.addPropertyChangeListener(listener)
  def removePropertyChangeListener(listener: JavaPropertyChangeListener): Unit = this.pcs.removePropertyChangeListener(listener)

  override def setLocation(x: Double, y: Double): Unit = {
    this.pcs.firePropertyChange("x", getX, x)
    this.pcs.firePropertyChange("y", getY, y)
    super.setLocation(x, y)
  }


}
