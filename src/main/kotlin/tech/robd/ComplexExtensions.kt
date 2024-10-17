package tech.robd

import space.kscience.kmath.complex.Complex
import space.kscience.kmath.complex.ComplexField
import space.kscience.kmath.complex.ComplexField.div
import space.kscience.kmath.complex.ComplexField.plus
import space.kscience.kmath.complex.ComplexField.minus
import space.kscience.kmath.complex.ComplexField.times
import java.math.BigDecimal
import java.math.BigInteger

// `.j` extension for creating a Complex number with only an imaginary component.
val Int?.j: Complex
    get() = if (this == null) throw IllegalArgumentException("Invalid data for creating an Imaginary Number") else Complex(0.0, this.toDouble())

val Double?.j: Complex

    get() = if (this == null) throw IllegalArgumentException("Invalid data for creating an Imaginary Number") else Complex(0.0, this)

val Long?.j: Complex

    get() = if (this == null) throw IllegalArgumentException("Invalid data for creating an Imaginary Number") else Complex(0.0, this.toDouble())

val Float?.j: Complex

    get() = if (this == null) throw IllegalArgumentException("Invalid data for creating an Imaginary Number") else Complex(0.0, this.toDouble())

val BigInteger?.j: Complex
    get() = if (this == null) throw IllegalArgumentException("Invalid data for creating an Imaginary Number") else Complex(0.0, this.toDouble())


val BigDecimal?.j: Complex
    get() = if (this == null) throw IllegalArgumentException("Invalid data for creating an Imaginary Number") else Complex(0.0, this.toDouble())


// `plusJ` infix functions for creating a Complex number with real and imaginary components.
infix fun Int?.plusJ(imaginary: Int?): Complex{
    val real = this?.toDouble() ?: throw IllegalArgumentException("Invalid data for creating an Imaginary Number")
    val imag = imaginary?.toDouble() ?: throw IllegalArgumentException("Invalid data for creating an Imaginary Number")
    return Complex(real, imag)
}

infix fun Double?.plusJ(imaginary: Double?): Complex {
    return Complex(
        this ?: throw IllegalArgumentException("Invalid data for creating an Imaginary Number"),
        imaginary ?: throw IllegalArgumentException("Invalid data for creating an Imaginary Number")
    )
}

infix fun Long?.plusJ(imaginary: Long?): Complex{
    return Complex(
        this ?: throw IllegalArgumentException("Invalid data for creating an Imaginary Number"),
        imaginary ?: throw IllegalArgumentException("Invalid data for creating an Imaginary Number")
    )
}

infix fun Float?.plusJ(imaginary: Float?): Complex{
    return Complex(
        this?.toDouble() ?: throw IllegalArgumentException("Invalid data for creating an Imaginary Number"),
        imaginary?.toDouble() ?: throw IllegalArgumentException("Invalid data for creating an Imaginary Number")
    )
}

infix fun BigInteger?.plusJ(imaginary: BigInteger?): Complex{
    return Complex(
        this ?:throw IllegalArgumentException("Invalid data for creating an Imaginary Number"),
        imaginary ?:throw IllegalArgumentException("Invalid data for creating an Imaginary Number")
    )
}
infix fun BigDecimal?.plusJ(imaginary: BigDecimal?): Complex{
    return Complex(
        this ?:throw IllegalArgumentException("Invalid data for creating an Imaginary Number"),
        imaginary ?:throw IllegalArgumentException("Invalid data for creating an Imaginary Number")
    )
}


// Overloads for `+`
// Overloads for `+` to enable operations like `Int + Complex`.
operator fun Int.plus(complex: Complex) = Complex(this.toDouble(), 0.0) + complex
operator fun Long.plus(complex: Complex) = Complex(this.toDouble(), 0.0) + complex
operator fun Double.plus(complex: Complex) = Complex(this.toDouble(), 0.0) + complex
operator fun Float.plus(complex: Complex) = Complex(this.toDouble(), 0.0) + complex
operator fun BigInteger.plus(complex: Complex) = Complex(this.toDouble(), 0.0 ) + complex
operator fun BigDecimal.plus(complex: Complex) = Complex(this.toDouble(), 0.0 ) + complex
// Overload for `Complex + Double` to handle cases like `9.0.j + 11.0` which is not likely to be done but 9.0.j + existingComplexNumber might happen more
operator fun Complex.plus(real: Int): Complex = this + Complex(real, 0.0)
operator fun Complex.plus(real: Double): Complex = this + Complex(real, 0.0)
operator fun Complex.plus(real: Long): Complex = this + Complex(real.toDouble(), 0.0)
operator fun Complex.plus(real: Float): Complex = this + Complex(real.toDouble(), 0.0)
operator fun Complex.plus(real: BigInteger): Complex = this + Complex(real.toDouble(), 0.0)
operator fun Complex.plus(real: BigDecimal): Complex = this + Complex(real.toDouble(), 0.0)

// Overloads for `-`
// Overloads for `-` to enable operations like ` Double - Complex`.
operator fun Int.minus(complex: Complex) = Complex(this.toDouble(), 0.0) - complex
operator fun Double.minus(complex: Complex) = Complex(this.toDouble(), 0.0)- complex
operator fun Long.minus(complex: Complex) = Complex(this.toDouble(), 0.0) - complex
operator fun Float.minus(complex: Complex) = Complex(this.toDouble(), 0.0) - complex
operator fun BigInteger.minus(complex: Complex) = Complex(this.toDouble(), 0.0 ) - complex
operator fun BigDecimal.minus(complex: Complex) = Complex(this.toDouble(), 0.0 ) - complex
// Overloads for `-` to enable operations like `Complex - Double`.
operator fun Complex.minus(real: Int): Complex = this - Complex(real, 0.0)
operator fun Complex.minus(real: Double): Complex = this - Complex(real, 0.0)
operator fun Complex.minus(real: Long): Complex = this - Complex(real.toDouble(), 0.0)
operator fun Complex.minus(real: Float): Complex = this - Complex(real.toDouble(), 0.0)
operator fun Complex.minus(real: BigInteger): Complex = this - Complex(real.toDouble(), 0.0)
operator fun Complex.minus(real: BigDecimal): Complex = this - Complex(real.toDouble(), 0.0)

// Overloads for `*`
// Overloads for `*` to enable operations like ` Double * Complex`.
operator fun Int.times(complex: Complex): Complex = Complex(this.toDouble(), 0.0) * complex
operator fun Double.times(complex: Complex): Complex = Complex(this.toDouble(), 0.0) + complex
operator fun Long.times(complex: Complex): Complex = Complex(this.toDouble(), 0.0) + complex
operator fun Float.times(complex: Complex): Complex = Complex(this.toDouble(), 0.0) + complex
operator fun BigInteger.times(complex: Complex): Complex = Complex(this.toDouble(), 0.0 ) + complex
operator fun BigDecimal.times(complex: Complex): Complex = Complex(this.toDouble(), 0.0 ) + complex
// Overloads for `*` to enable operations like `Complex * Double`.
operator fun Complex.times(real: Int): Complex = this * Complex(real, 0.0)
operator fun Complex.times(real: Double): Complex = this * Complex(real, 0.0)
operator fun Complex.times(real: Long): Complex = this * Complex(real.toDouble(), 0.0)
operator fun Complex.times(real: Float): Complex = this * Complex(real.toDouble(), 0.0)
operator fun Complex.times(real: BigInteger): Complex = this * Complex(real.toDouble(), 0.0)
operator fun Complex.times(real: BigDecimal): Complex = this * Complex(real.toDouble(), 0.0)

// Overloads for `/`
// Overloads for `/` to enable operations like `Int / Complex`, `Double / Complex`, etc.
operator fun Int.div(complex: Complex) : Complex = Complex(this.toDouble(), 0.0) / complex
operator fun Double.div(complex: Complex): Complex  = Complex(this.toDouble(), 0.0) / complex
operator fun Long.div(complex: Complex) : Complex = Complex(this.toDouble(), 0.0) / complex
operator fun Float.div(complex: Complex) : Complex = Complex(this.toDouble(), 0.0) / complex
operator fun BigInteger.div(complex: Complex): Complex  = Complex(this.toDouble(), 0.0) / complex
operator fun BigDecimal.div(complex: Complex): Complex  = Complex(this.toDouble(), 0.0) / complex
// Overloads for `/` to enable operations like `Complex / Double`.
operator fun Complex.div(real: Int): Complex = this / Complex(real, 0.0)
operator fun Complex.div(real: Double): Complex = this / Complex(real, 0.0)
operator fun Complex.div(real: Long): Complex = this / Complex(real.toDouble(), 0.0)
operator fun Complex.div(real: Float): Complex = this / Complex(real.toDouble(), 0.0)
operator fun Complex.div(real: BigInteger): Complex = this / Complex(real.toDouble(), 0.0)
operator fun Complex.div(real: BigDecimal): Complex = this / Complex(real.toDouble(), 0.0)

operator fun Complex.times(other: Complex): Complex = ComplexField.run { multiply(this@times, other) }
operator fun Complex.plus(other: Complex): Complex = ComplexField.run { add(this@plus, other) }
operator fun Complex.div(other: Complex): Complex = ComplexField.run { divide(this@div, other) }
operator fun Complex.minus(other: Complex): Complex = ComplexField.run { add(this@minus, -other) }
