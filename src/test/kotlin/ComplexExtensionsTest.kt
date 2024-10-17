package tech.robd

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.doubles.plusOrMinus
import io.kotest.matchers.shouldBe
import space.kscience.kmath.complex.Complex
import space.kscience.kmath.complex.ComplexField
import java.math.BigDecimal

class ComplexExtensionsTest : StringSpec({
    "Int.j should create a complex number with the correct imaginary component" {
        1.j shouldBe Complex(0.0, 1.0)
    }

    "Int.j should throw an exception when the Int is null" {
        val nullInt: Int? = null
        shouldThrow<IllegalArgumentException> {
            nullInt.j
        }
    }

    "Double.j should create a complex number with the correct imaginary component" {
        1.0.j shouldBe Complex(0.0, 1.0)
    }

    "Double.j should throw an exception when the Double is null" {
        val nullDouble: Double? = null
        shouldThrow<IllegalArgumentException> {
            nullDouble.j
        }
    }

    "Long.j should create a complex number with the correct imaginary component" {
        1L.j shouldBe Complex(0.0, 1.0)
    }

    "Long.j should throw an exception when the Long is null" {
        val nullLong: Long? = null
        shouldThrow<IllegalArgumentException> {
            nullLong.j
        }
    }

    "Float.j should create a complex number with the correct imaginary component" {
        1.0f.j shouldBe Complex(0.0, 1.0)
    }

    "Float.j should throw an exception when the Float is null" {
        val nullFloat: Float? = null
        shouldThrow<IllegalArgumentException> {
            nullFloat.j
        }
    }

    "BigDecimal.j should create a complex number with the correct imaginary component" {
        BigDecimal("1.0").j shouldBe Complex(0.0, 1.0)
    }

    "BigDecimal.j should throw an exception when the BigDecimal is null" {
        val nullBigDecimal: BigDecimal? = null
        shouldThrow<IllegalArgumentException> {
            nullBigDecimal.j
        }
    }

    "Int.plusJ should create a complex number with the correct real and imaginary components" {
        1 plusJ 2 shouldBe Complex(1.0, 2.0)
    }

    "Double.plusJ should create a complex number with the correct real and imaginary components" {
        1.0 plusJ 2.0 shouldBe Complex(1.0, 2.0)
    }

    "Long.plusJ should create a complex number with the correct real and imaginary components" {
        1L plusJ 2L shouldBe Complex(1.0, 2.0)
    }

    "Float.plusJ should create a complex number with the correct real and imaginary components" {
        1.0f plusJ 2.0f shouldBe Complex(1.0, 2.0)
    }

    "BigDecimal.plusJ should create a complex number with the correct real and imaginary components" {
        BigDecimal("1.0") plusJ BigDecimal("2.0") shouldBe Complex(1.0, 2.0)
    }

    "Int.plusJ should throw an exception when the Int is null" {
        val nullInt: Int? = null
        shouldThrow<IllegalArgumentException> {
            nullInt plusJ 2
        }
    }

    "Double.plusJ should throw an exception when the Double is null" {
        val nullDouble: Double? = null
        shouldThrow<IllegalArgumentException> {
            1.0 plusJ nullDouble
        }
    }

    "Long.plusJ should throw an exception when the Long is null" {
        val nullLong: Long? = null
        shouldThrow<IllegalArgumentException> {
            1L plusJ nullLong
        }
    }

    "Float.plusJ should throw an exception when the Float is null" {
        val nullFloat: Float? = null
        shouldThrow<IllegalArgumentException> {
            1.0f plusJ nullFloat
        }
    }

    "BigDecimal.plusJ should throw an exception when the BigDecimal is null" {
        val nullBigDecimal: BigDecimal? = null
        shouldThrow<IllegalArgumentException> {
            BigDecimal("1.0") plusJ nullBigDecimal
        }
    }

    "Int.plus should add the Int to the real component of the complex number" {
        1 + Complex(2.0, 3.0) shouldBe Complex(3.0, 3.0)
    }

    "Double.plus should add the Double to the real component of the complex number" {
        1.0 + Complex(2.0, 3.0) shouldBe Complex(3.0, 3.0)
    }

    "Double.plus should add the Double to the real component of the complex number in inverse order" {
        Complex(2.0, 3.0) + 1.0 shouldBe Complex(3.0, 3.0)
    }

    "Long.plus should add the Long to the real component of the complex number" {
        1L + Complex(2.0, 3.0) shouldBe Complex(3.0, 3.0)
    }

    "Float.plus should add the Float to the real component of the complex number" {
        1.0f + Complex(2.0, 3.0) shouldBe Complex(3.0, 3.0)
    }

    "BigDecimal.plus should add the BigDecimal to the real component of the complex number" {
        BigDecimal("1.0") + Complex(2.0, 3.0) shouldBe Complex(3.0, 3.0)
    }

    "Int.minus should subtract the complex number from the Int" {
        1 - Complex(2.0, 3.0) shouldBe Complex(-1.0, -3.0)
    }

    "Double.minus should subtract the complex number from the Double" {
        1.0 - Complex(2.0, 3.0) shouldBe Complex(-1.0, -3.0)
    }

    "Long.minus should subtract the complex number from the Long" {
        1L - Complex(2.0, 3.0) shouldBe Complex(-1.0, -3.0)
    }

    "Float.minus should subtract the complex number from the Float" {
        1.0f - Complex(2.0, 3.0) shouldBe Complex(-1.0, -3.0)
    }

    "BigDecimal.minus should subtract the complex number from the BigDecimal" {
        BigDecimal("1.0") - Complex(2.0, 3.0) shouldBe Complex(-1.0, -3.0)
    }

    "Complex.plus should add two complex numbers correctly" {
        val z1 = Complex(2.0, 3.0)
        val z2 = Complex(4.0, 5.0)
        val expected = Complex(6.0, 8.0)  // (2 + 4) + (3 + 5)j
        (z1 + z2) shouldBe expected
    }

    "Complex.minus should subtract two complex numbers correctly" {
        val z1 = Complex(2.0, 3.0)
        val z2 = Complex(4.0, 5.0)
        val expected = Complex(-2.0, -2.0) // (2 - 4) + (3 - 5)j
        (z1 - z2) shouldBe expected
    }

    "Complex.times should multiply two complex numbers correctly" {
        val z1 = Complex(2.0, 3.0)
        val z2 = Complex(4.0, 5.0)
        val expected = Complex(-7.0, 22.0) // (2*4 - 3*5) + (2*5 + 3*4)j
        (z1 * z2) shouldBe expected
    }

   // Test to check if division of complex numbers is correct, with tolerance for rounding errors
    "Complex.div should divide two complex numbers correctly" {
        val z1 = Complex(2.0, 3.0)
        val z2 = Complex(4.0, 5.0)
        val expected = Complex(0.5609756097560976, 0.04878048780487805)

        val result = z1 / z2

        // Use tolerance for floating-point comparisons
        result.re shouldBe (expected.re plusOrMinus 1e-6)
        result.im shouldBe (expected.im plusOrMinus 1e-6)
    }


    "Int.times should multiply the complex number by the Int in inverse order" {
        Complex(2.0, 3.0) * 2 shouldBe Complex(4.0, 6.0)
    }

    "Double.times should multiply the complex number by the Double in inverse order" {
        Complex(2.0, 3.0) * 2.0 shouldBe Complex(4.0, 6.0)
    }

    "Long.times should multiply the complex number by the Long in inverse order" {
        Complex(2.0, 3.0) * 2L shouldBe Complex(4.0, 6.0)
    }

    "Float.times should multiply the complex number by the Float in inverse order" {
        Complex(2.0, 3.0) * 2.0f shouldBe Complex(4.0, 6.0)
    }

    "BigDecimal.times should multiply the complex number by the BigDecimal in inverse order" {
        Complex(2.0, 3.0) * BigDecimal("2.0") shouldBe Complex(4.0, 6.0)
    }

    "Int.div should divide the complex number by the Int in inverse order" {
        Complex(4.0, 6.0) / 2 shouldBe Complex(2.0, 3.0)
    }

    "Double.div should divide the complex number by the Double in inverse order" {
        Complex(4.0, 6.0) / 2.0 shouldBe Complex(2.0, 3.0)
    }

    "Long.div should divide the complex number by the Long in inverse order" {
        Complex(4.0, 6.0) / 2L shouldBe Complex(2.0, 3.0)
    }

    "Float.div should divide the complex number by the Float in inverse order" {
        Complex(4.0, 6.0) / 2.0f shouldBe Complex(2.0, 3.0)
    }

    "BigDecimal.div should divide the complex number by the BigDecimal in inverse order" {
        Complex(4.0, 6.0) / BigDecimal("2.0") shouldBe Complex(2.0, 3.0)
    }

    "Complex.plus should add a real number to the real component of the complex number" {
        Complex(2.0, 3.0) + 1 shouldBe Complex(3.0, 3.0)
        Complex(2.0, 3.0) + 1.0 shouldBe Complex(3.0, 3.0)
        Complex(2.0, 3.0) + 1L shouldBe Complex(3.0, 3.0)
        Complex(2.0, 3.0) + 1.0f shouldBe Complex(3.0, 3.0)
        Complex(2.0, 3.0) + BigDecimal("1.0") shouldBe Complex(3.0, 3.0)
    }

    "Complex.minus should subtract a real number from the real component of the complex number" {
        Complex(2.0, 3.0) - 1 shouldBe Complex(1.0, 3.0)
        Complex(2.0, 3.0) - 1.0 shouldBe Complex(1.0, 3.0)
        Complex(2.0, 3.0) - 1L shouldBe Complex(1.0, 3.0)
        Complex(2.0, 3.0) - 1.0f shouldBe Complex(1.0, 3.0)
        Complex(2.0, 3.0) - BigDecimal("1.0") shouldBe Complex(1.0, 3.0)
    }

    "Complex.times should multiply the complex number by a real number" {
        Complex(2.0, 3.0) * 2 shouldBe Complex(4.0, 6.0)
        Complex(2.0, 3.0) * 2.0 shouldBe Complex(4.0, 6.0)
        Complex(2.0, 3.0) * 2L shouldBe Complex(4.0, 6.0)
        Complex(2.0, 3.0) * 2.0f shouldBe Complex(4.0, 6.0)
        Complex(2.0, 3.0) * BigDecimal("2.0") shouldBe Complex(4.0, 6.0)
    }

    "Complex.div should divide the complex number by a real number" {
        Complex(4.0, 6.0) / 2 shouldBe Complex(2.0, 3.0)
        Complex(4.0, 6.0) / 2.0 shouldBe Complex(2.0, 3.0)
        Complex(4.0, 6.0) / 2L shouldBe Complex(2.0, 3.0)
        Complex(4.0, 6.0) / 2.0f shouldBe Complex(2.0, 3.0)
        Complex(4.0, 6.0) / BigDecimal("2.0") shouldBe Complex(2.0, 3.0)
    }
})


