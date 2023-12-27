fun main() {
    val parametricFunction = ParametricFunction(
        //x = Math::cos,   // x(t) = cos(t)
        x = { t -> Math.sin(5*t) * Math.cos(t) },
        //y = Math::sin    // y(t) = sin(t)
        y = { t -> Math.sin(5*t) * Math.sin(t) }
    )
    Window(parametricFunction, -5.0, 5.0, -5.0, 5.0)
}
