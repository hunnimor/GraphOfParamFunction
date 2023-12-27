import java.awt.Color
import java.awt.Font
import java.awt.Graphics
import javax.swing.JPanel

class ParametricFunctionPlot(
    private val parametricFunction: ParametricFunction,
    private val xMin: Double,
    private val xMax: Double,
    private val yMin: Double,
    private val yMax: Double
) : JPanel() {

    override fun paintComponent(g: Graphics) {
        // масштаб
        val xScale = width / (xMax - xMin)
        val yScale = height / (yMax - yMin)

        drawCoordinateAxes(g, width, height, xScale, yScale)

        // рисование фунции
        g.color = Color.RED
        val tStep = 0.01

        var t = xMin
        while (t <= xMax) {
            //val point = Pair(parametricFunction.x, parametricFunction.y)
            val x = ((parametricFunction.x(t) - xMin) * xScale).toInt()
            val y = (height - (parametricFunction.y(t) - yMin) * yScale).toInt()

            g.drawLine(x, y, x, y)

            t += tStep
        }
    }

    private fun drawCoordinateAxes(g: Graphics, width: Int, height: Int, xScale: Double, yScale: Double) {
        g.color = Color.BLACK
        g.font = Font("Arial", Font.PLAIN, 10)

        // горизонтальная ось
        val xAxisPosition = ((0 - xMin) * xScale).toInt()
        g.drawLine(xAxisPosition, 0, xAxisPosition, height)

        // вертикальная
        val yAxisPosition = (height - (0 - yMin) * yScale).toInt()
        g.drawLine(0, yAxisPosition, width, yAxisPosition)

        // деления и координаты на горизонтальной оси
        var xTick = xMin
        var xPosition = 0
        while (xTick <= xMax) {
            g.drawLine(xPosition, yAxisPosition - 5, xPosition, yAxisPosition + 5)
            g.drawString(xTick.toString(), xPosition - 10, yAxisPosition + 20)
            xTick += 1.0
            xPosition += xScale.toInt()
        }

        // деление и координаты на вертикальной оси
        var yTick = yMin
        var yPosition = height
        while (yTick <= yMax) {
            g.drawLine(xAxisPosition - 5, yPosition, xAxisPosition + 5, yPosition)
            g.drawString(yTick.toString(), xAxisPosition - 30, yPosition + 5)
            yTick += 1.0
            yPosition -= yScale.toInt()
        }
    }
}