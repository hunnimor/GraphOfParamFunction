import java.awt.BorderLayout
import java.awt.Dimension
import javax.swing.JFrame


class Window(
    private val parametricFunction: ParametricFunction,
    xMin: Double,
    xMax: Double,
    yMin: Double,
    yMax: Double
) : JFrame() {

    init {
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        isResizable = false
        preferredSize = Dimension(600, 600)

        val plot = ParametricFunctionPlot(parametricFunction, xMin, xMax, yMin, yMax)
        add(plot, BorderLayout.CENTER)

        pack()
        isVisible = true
    }
}