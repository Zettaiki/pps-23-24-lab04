package tasks.adts

package u04lab

import scala.compiletime.ops.int
import u02.Values.s
import u04.typeclasses.HigherKindedTypes.s
import scala.compiletime.ops.string

/*  Exercise 1: 
 *  Complete the implementation of ComplexADT trait below, so that it passes
 *  the test in ComplexTest.
 */

object Ex1ComplexNumbers:

  trait ComplexADT:
    type Complex
    def complex(re: Double, im: Double): Complex
    extension (complex: Complex)
      def re(): Double
      def im(): Double
      def sum(other: Complex): Complex
      def subtract(other: Complex): Complex
      def asString(): String

  object BasicComplexADT extends ComplexADT:

    // Change assignment below: should probably define a case class and use it?
    case class BasicComplex(re: Double, im: Double)
    type Complex = BasicComplex
    def complex(re: Double, im: Double): Complex = BasicComplex(re, im)
    extension (complex: Complex)
      def re(): Double = complex.re
      def im(): Double = complex.im
      def sum(other: Complex): Complex = BasicComplex(complex.re() + other.re(), complex.im() + other.im())
      def subtract(other: Complex): Complex = BasicComplex(complex.re() - other.re(), complex.im() - other.im())
      def asString(): String = complex match
        case complex if (re == 0 & im == 0) => s"$re"
        case complex if (re == 0) => s"$im"+"i"
        case complex if (im == 0) => s"$re"
        case complex if (re != 0 & im > 0) => s"$re + $im"+"i"
        case complex if (re != 0 & im < 0) => s"$re - ${-1*im}"+"i"
