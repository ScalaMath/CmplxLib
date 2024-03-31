package io.github.scalamath.cmplxlib

import io.github.scalamath.DoubleEqualsApprox
import io.github.scalamath.vecmatlib.Vec3d

/**
 * A 3D complex vector.
 *
 * @constructor Constructs a 3D vector from the three given components.
 * @param x The vector's x component.
 * @param y The vector's y component.
 * @param z The vector's z component.
 */
case class Vec3c(x: Complex, y: Complex, z: Complex) {

  /**
   * Constructs a 3D vector from the given components.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   */
  def this(xy: Vec2c, z: Complex) = this(xy.x, xy.y, z)

  /**
   * Returns a 2D vector composed of the x and the y components of this vector.
   *
   * @return A 2D vector composed of the x and the y components of this vector.
   */
  def xy: Vec2c = Vec2c(this.x, this.y)

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @param z The z component to add.
   * @return The sum between this vector and the given values.
   */
  def +(x: Complex, y: Complex, z: Complex): Vec3c = Vec3c(this.x + x, this.y + y, this.z + z)

  /**
   * Adds the given values to the components of this vector and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param x The x component to add.
   * @param y The y component to add.
   * @param z The z component to add.
   * @return The sum between this vector and the given values.
   */
  def plus(x: Complex, y: Complex, z: Complex): Vec3c = this + (x, y, z)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def +(v: Vec3c): Vec3c = this + (v.x, v.y, v.z)

  /**
   * Adds the given vector to this one and returns the result.
   *
   * This method can be used in place of the `+` operator for better interoperability with Java.
   *
   * @param v The vector to add.
   * @return The sum between this vector and the given one.
   */
  def plus(v: Vec3c): Vec3c = this + v

  /**
   * Returns this same vector.
   *
   * The unary `+` operator does nothing, but can sometimes make the code more readable.
   *
   * @return This same vector.
   */
  def unary_+ : Vec3c = this

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @param z The z component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def -(x: Complex, y: Complex, z: Complex): Vec3c = Vec3c(this.x - x, this.y - y, this.z - z)

  /**
   * Subtracts the given values from each component of this vector and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param x The x component to subtract.
   * @param y The y component to subtract.
   * @param z The z component to subtract.
   * @return The subtraction between this vector and the given values.
   */
  def minus(x: Complex, y: Complex, z: Complex): Vec3c = this - (x, y, z)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def -(v: Vec3c): Vec3c = this - (v.x, v.y, v.z)

  /**
   * Subtracts the given vector from this one and returns the result.
   *
   * This method can be used in place of the `-` operator for better interoperability with Java.
   *
   * @param v The vector to subtract.
   * @return The subtraction between this vector and the given one.
   */
  def minus(v: Vec3c): Vec3c = this - v

  /**
   * Returns the additive inverse of this vector.
   *
   * @return The additive inverse of this vector.
   */
  def unary_- : Vec3c = Vec3c(-this.x, -this.y, -this.z)

  /**
   * Returns the additive inverse of this vector.
   *
   * This method can be used in place of the unary `-` operator for better interoperability with Java.
   *
   * @return The additive inverse of this vector.
   */
  def negated: Vec3c = -this

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * @param x Value to multiply the x component by.
   * @param y Value to multiply the y component by.
   * @param z Value to multiply the z component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def *(x: Complex, y: Complex, z: Complex): Vec3c = Vec3c(this.x * x, this.y * y, this.z * z)

  /**
   * Multiplies each component of this vector by the given values and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param x The value to multiply the x component by.
   * @param y The value to multiply the y component by.
   * @param z The value to multiply the z component by.
   * @return The component-wise multiplication between this vector and the given values.
   */
  def multiply(x: Complex, y: Complex, z: Complex): Vec3c = this * (x, y, z)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def *(v: Vec3c): Vec3c = this * (v.x, v.y, v.z)

  /**
   * Multiplies each component of this vector by the components of the given ones and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param v The vector to multiply this one by.
   * @return The component-wise multiplication between this vector and the one.
   */
  def multiply(v: Vec3c): Vec3c = this * v

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def *(k: Complex): Vec3c = this * (k, k, k)

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def multipliedBy(k: Complex): Vec3c = this * k

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def *(k: Double): Vec3c = Vec3c(this.x * k, this.y * k, this.z * k)

  /**
   * Multiplies this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `*` operator for better interoperability with Java.
   *
   * @param k The scalar to multiply this vector by.
   * @return The product between this vector and the given scalar.
   */
  def multipliedBy(k: Double): Vec3c = this * k

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @param z The value to divide the z component by.
   * @return The component-wise division between this vector and the given values.
   */
  def /(x: Complex, y: Complex, z: Complex): Vec3c = Vec3c(this.x / x, this.y / y, this.z / z)

  /**
   * Divides each component of this vector by the given values and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param x The value to divide the x component by.
   * @param y The value to divide the y component by.
   * @param z The value to divide the z component by.
   * @return The component-wise division between this vector and the given values.
   */
  def divide(x: Complex, y: Complex, z: Complex): Vec3c = this / (x, y, z)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def /(v: Vec3c): Vec3c = this / (v.x, v.y, v.z)

  /**
   * Divides each component of this vector by the components of the given ones and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param v The vector to divide this one by.
   * @return The component-wise division between this vector and the one.
   */
  def divide(v: Vec3c): Vec3c = this / v

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def /(k: Complex): Vec3c = this / (k, k, k)

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def dividedBy(k: Complex): Vec3c = this / k

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def /(k: Double): Vec3c = Vec3c(this.x / k, this.y / k, this.z / k)

  /**
   * Divides this vector by the given scalar and returns the result.
   *
   * This method can be used in place of the `/` operator for better interoperability with Java.
   *
   * @param k The scalar to divide this vector by.
   * @return The division between this vector and the given scalar.
   */
  def dividedBy(k: Double): Vec3c = this / k

  /**
   * Returns the inverse of this vector with respect to component-wise multiplication.
   *
   * @return The inverse of this vector.
   * @see [[Complex.inverse]]
   */
  def inverse: Vec3c = Vec3c(this.x.inverse, this.y.inverse, this.z.inverse)

  /**
   * Returns the conjugate of this complex vector.
   *
   * @return The conjugate of this complex vector.
   * @see [[Complex.conjugate]]
   */
  def conjugate: Vec3c = Vec3c(this.x.conjugate, this.y.conjugate, this.z.conjugate)

  /**
   * Returns the dot product, or scalar product, between this vector and the given values.
   *
   * @param x The x component of the vector to multiply this one by.
   * @param y The y component of the vector to multiply this one by.
   * @param z The z component of the vector to multiply this one by.
   * @return The dot product between this vector and the given values.
   */
  def dot(x: Complex, y: Complex, z: Complex): Complex = this.x * x.conjugate + this.y * y.conjugate + this.z * z.conjugate

  /**
   * Returns the dot product, or scalar product, between this vector and the given one.
   *
   * @param v The second vector.
   * @return The dot product between this vector and the given one.
   */
  def dot(v: Vec3c): Complex = this.dot(v.x, v.y, v.z)

  /**
   * Returns the cross product, or vector product, between this vector and the vector defined by the given components.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The cross product between this vector and the vector defined by the given components.
   */
  def cross(x: Complex, y: Complex, z: Complex): Vec3c = Vec3c(this.y * z - this.z * y, x * this.z - z * this.x, this.x * y - this.y * x)

  /**
   * Returns the cross product, or vector product, between this vector and the given one.
   *
   * @param v The second vector.
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec3c): Vec3c = this.cross(v.x, v.y, v.z)

  /**
   * Returns the cross product, or vector product, between this vector and the given one.
   *
   * Since the cross product is only defined in three dimensions, the given vector is considered to be laying on the xy plane, i.e. its z component is considered to be zero.
   *
   * @param v The second vector.
   * @return The cross product between this vector and the given one.
   */
  def cross(v: Vec2c): Vec3c = this.cross(v.x, v.y, 0.0)

  /**
   * Returns the squared length, or magnitude, or modulus, of this vector.
   *
   * When comparing vectors by their length, it is more efficient to compare them by their squared length, since computing it does not require computing a square root.
   *
   * @return The squared length of this vector.
   * @see [[length]]
   */
  def lengthSquared: Double = this.x.squaredModulus + this.y.squaredModulus + this.z.squaredModulus

  /**
   * Returns the length, or magnitude, or modulus, of this vector.
   *
   * @return The length of this vector.
   * @see [[lengthSquared]]
   */
  def length: Double = math.sqrt(this.lengthSquared)

  /**
   * Returns the result of scaling this vector to unit length.
   * Equivalent to `v / v.length`.
   *
   * The resulting vector has the same direction as this one, but a length of `1.0`.
   *
   * @return The result of scaling this vector to unit length.
   * @see [[isNormalized]]
   */
  def normalized: Vec3c = this / this.length

  /**
   * Checks if this vector is a unit vector by checking if its length is approximately equal to `1.0`.
   *
   * @return True if this vector is a unit vector, otherwise false.
   * @see [[normalized]]
   */
  def isNormalized: Boolean = this.lengthSquared ~= 1.0

  /**
   * Returns a vector with the same direction as this one and a length not longer than the given limit.
   * Returns this same vector if its length is smaller than the given limit.
   *
   * @param limit The maximum length of the resulting vector.
   * @return A vector with the same direction as this one and a length not longer than the given limit.
   */
  def limitLength(limit: Double): Vec3c = {
    val length = this.length
    if(length > 0.0 && limit < length) {
      this / length * limit
    } else {
      this
    }
  }

  /**
   * Returns a vector whose components are the modulus, or the absolute value, of the components of this vector.
   *
   * Not to be confused with the [[length]] of the vector.
   *
   * @return A vector whose components are the modulus of the components of this vector.
   * @see [[Complex.modulus]]
   */
  def abs: Vec3d = Vec3d(this.x.modulus, this.y.modulus, this.z.modulus)

  /**
   * Returns a vector moved toward the given one by the given delta without going past the final value.
   *
   * @param to The final value of the vector.
   * @param delta The fixed delta by which this vector is moved.
   * @return A vector moved toward the given one by the given delta.
   */
  def moveToward(to: Vec3c, delta: Double): Vec3c = {
    val vd = to - this
    val length = vd.length
    if(length <= delta) {
      to
    } else {
      this + vd / length * delta
    }
  }

  /**
   * Computes the linear interpolation between this vector and the given one by the given weight and returns the result.
   *
   * The given weight must be in the `[0.0, 1.0]` range, representing the amount of interpolation.
   *
   * @param to The second vector.
   * @param weight The weight of the interpolation between `0.0` and `1.0`.
   * @return The result of linearly interpolating between this vector and the given one.
   */
  def lerp(to: Vec3c, weight: Double): Vec3c = this + (to - this) * weight

  /**
   * Computes the normalized vector pointing from this one to the given one and returns the result.
   *
   * This method is equivalent to `(b - a).normalized`.
   *
   * @param v The second vector.
   * @return The normalized vector pointing from this one to the given one.
   */
  def directionTo(v: Vec3c): Vec3c = (v - this).normalized

  /**
   * Computes the normalized vector pointing from this one to the one with the given components and returns the result.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The normalized vector pointing from this one to the one with the given components.
   */
  def directionTo(x: Complex, y: Complex, z: Complex): Vec3c = this.directionTo(Vec3c(x, y, z))

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`.
   *
   * @param v The second vector.
   * @return The squared distance between this vector and the given one.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(v: Vec3c): Double = (v - this).lengthSquared

  /**
   * Returns the squared distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).lengthSquared`.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The squared distance between this vector and the one with the given components.
   * @see [[lengthSquared]]
   */
  def distanceSquaredTo(x: Complex, y: Complex, z: Complex): Double = this.distanceSquaredTo(Vec3c(x, y, z))

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`.
   *
   * @param v The second vector.
   * @return The squared between this vector and the given one.
   * @see [[length]]
   */
  def distanceTo(v: Vec3c): Double = (v - this).length

  /**
   * Returns the distance between the point represented by this vector and the point represented by the given one.
   *
   * This method is equivalent to `(b - a).length`.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The squared between this vector and the one with the given components.
   * @see [[length]]
   */
  def distanceTo(x: Complex, y: Complex, z: Complex): Double = this.distanceTo(Vec3c(x, y, z))

  /**
   * Returns the angle in radians between this vector and the given one.
   *
   * @param v The second vector.
   * @return The angle in radians between this vector and the given one.
   */
  def angleTo(v: Vec3c): Double = math.acos(this.dot(v).real / (this.length * v.length))

  /**
   * Returns the angle in radians between this vector and the one with the given components.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The angle in radians between this vector and the one with the given components.
   */
  def angleTo(x: Complex, y: Complex, z: Complex): Double = this.angleTo(Vec3c(x, y, z))

  /**
   * Projects this vector on the given one and returns the result.
   *
   * @param v The second vector.
   * @return The projection of this vector on the given one.
   */
  def project(v: Vec3c): Vec3c = v * (this.dot(v) / v.lengthSquared)

  /**
   * Projects this vector on the one with the given components and returns the result.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The projection of this vector on the one with the given components.
   */
  def project(x: Complex, y: Complex, z: Complex): Vec3c = this.project(Vec3c(x, y, z))

  /**
   * Reflects this vector by the given normal and returns the result.
   *
   * @param n The reflection normal.
   * @return The reflection of this vector by the given normal.
   */
  def reflect(n: Vec3c): Vec3c = this - (n * (this.dot(n) * 2.0))

  /**
   * Reflects this vector by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the reflection normal.
   * @param y The y component of the reflection normal.
   * @param z The z component of the reflection normal.
   * @return The reflection of this vector by the normal defined by the given components.
   */
  def reflect(x: Complex, y: Complex, z: Complex): Vec3c = this.reflect(Vec3c(x, y, z))

  /**
   * "Bounces" this vector on a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return A vector "bounced off" from a plane defined by the given normal.
   */
  def bounce(n: Vec3c): Vec3c = -this.reflect(n)

  /**
   * "Bounces" this vector on a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @param z The z component of the plane's normal.
   * @return A vector "bounced off" from a plane defined by the normal defined by the given components.
   */
  def bounce(x: Complex, y: Complex, z: Complex): Vec3c = this.bounce(Vec3c(x, y, z))

  /**
   * Slides this vector along a plane defined by the given normal and returns the result.
   *
   * @param n The normal of the plane.
   * @return The result of sliding this vector along a plane defined by the given normal.
   */
  def slide(n: Vec3c): Vec3c = this - (n * this.dot(n))

  /**
   * Slides this vector along a plane defined by the normal defined by the given components and returns the result.
   *
   * @param x The x component of the plane's normal.
   * @param y The y component of the plane's normal.
   * @param z The z component of the plane's normal.
   * @return The result of sliding this vector along a plane defined by the normal defined by the given components.
   */
  def slide(x: Complex, y: Complex, z: Complex): Vec3c = this.slide(Vec3c(x, y, z))

  /**
   * Returns the outer product between this vector and the given values.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @return The outer product between this vector and the given values.
   */
  def outer(x: Complex, y: Complex, z: Complex): Mat3c = Mat3c(
    this.x * x, this.x * y, this.x * z,
    this.y * x, this.y * y, this.y * z,
    this.z * x, this.z * y, this.z * z
  )

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec3c): Mat3c = this.outer(v.x, v.y, v.z)

  /**
   * Returns the outer product between this vector and the given values.
   *
   * @param x The x component of the second vector.
   * @param y The y component of the second vector.
   * @param z The z component of the second vector.
   * @param w The w component of the second vector.
   * @return The outer product between this vector and the given values.
   */
  def outer(x: Complex, y: Complex, z: Complex, w: Complex): Mat3x4c = Mat3x4c(
    this.x * x, this.x * y, this.x * z, this.x * w,
    this.y * x, this.y * y, this.y * z, this.y * w,
    this.z * x, this.z * y, this.z * z, this.z * w
  )

  /**
   * Returns the outer product between this vector and the given one.
   *
   * @param v The second vector.
   * @return The outer product between this vector and the given one.
   */
  def outer(v: Vec4c): Mat3x4c = this.outer(v.x, v.y, v.z, v.w)

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def ==(x: Complex, y: Complex, z: Complex): Boolean = this.x == x && this.y == y && this.z == z

  /**
   * Checks if the components of this vector are equal to the given ones.
   *
   * This method can be used in place of the `==` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return True if the components of this vector are equal to the given ones, otherwise false.
   */
  def equals(x: Complex, y: Complex, z: Complex): Boolean = this == (x, y, z)

  /**
   * Checks if the components of this vector are approximately equal to the given ones using an internal epsilon.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return True if the components of this vector are approximately equal to the given ones, otherwise false.
   */
  def ~=(x: Complex, y: Complex, z: Complex): Boolean = (this.x ~= x) && (this.y ~= y) && (this.z ~= z)

  /**
   * Checks if the components of this vector are approximately equal to the given ones using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param x The x component.
   * @param y The y component.
   * @param z The z component.
   * @return True if the components of this vector are approximately equal to the given ones, otherwise false.
   */
  def equalsApprox(x: Complex, y: Complex, z: Complex): Boolean = this ~= (x, y, z)

  /**
   * Checks if this vector is approximately equal to the given one using an internal epsilon.
   *
   * @param v The second vector.
   * @return True if this vector is approximately equal to the given one, otherwise false.
   */
  def ~=(v: Vec3c): Boolean = this ~= (v.x, v.y, v.z)

  /**
   * Checks if this vector is approximately equal to the given one using an internal epsilon.
   *
   * This method can be used in place of the `~=` operator for better interoperability with Java.
   *
   * @param v The second vector.
   * @return True if this vector is approximately equal to the given one, otherwise false.
   */
  def equalsApprox(v: Vec3c): Boolean = this ~= v

  /**
   * Returns the component of this vector at the given index.
   * `0` for `x`, `1` for `y`, `2` for `z`.
   *
   * @param i The index of the requested component. Must be either 0, 1, or 2.
   * @return The component of this vector at the given index.
   * @throws MatchError If the given index is out of bounds.
   */
  def apply(i: Int): Complex = i match {
    case 0 => this.x
    case 1 => this.y
    case 2 => this.z
  }

  /**
   * Returns a vector whose components are the real part of the components of this vector.
   *
   * @return A vector whose components are the real part of the components of this vector.
   */
  def real: Vec3d = Vec3d(this.x.real, this.y.real, this.z.real)

  /**
   * Returns a vector whose components are the imaginary part of the components of this vector.
   *
   * @return A vector whose components are the imaginary part of the components of this vector.
   */
  def imaginary: Vec3d = Vec3d(this.x.imaginary, this.y.imaginary, this.z.imaginary)
}

/**
 * Constants, factory methods, and implicits for vectors.
 */
object Vec3c {

  /** Shorthand for `Vec3c(0.0, 0.0, 0.0)` */
  val Zero: Vec3c = Vec3c(0.0, 0.0, 0.0)

  /**
   * Constructs a 3D vector from the given components.
   *
   * @param xy The vector's x and y components.
   * @param z The vector's z component.
   * @return A 3D vector constructed from the given components.
   */
  def apply(xy: Vec2c, z: Complex) = new Vec3c(xy, z)

  /**
   * Allows to use the `*` and `/` operators with a scalar as `1.0 * vector`.
   *
   * @param self The scalar value.
   */
  implicit class ComplexExtender(val self: Complex) extends AnyVal {

    /**
     * Multiplies the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the given vector.
     */
    def *(v: Vec3c): Vec3c = v * self

    /**
     * Multiplies the [[Vec3c.inverse]] of the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the inverse of the given vector.
     */
    def /(v: Vec3c): Vec3c = v.inverse * self
  }

  /**
   * Allows to use the `*` and `/` operators with a scalar as `1.0 * vector`.
   *
   * @param self The scalar value.
   */
  implicit class RealExtender(val self: Double) extends AnyVal {

    /**
     * Multiplies the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the given vector.
     */
    def *(v: Vec3c): Vec3c = v * self

    /**
     * Multiplies the [[Vec3c.inverse]] of the given vector by this scalar and returns the result.
     *
     * @param v The vector to multiply.
     * @return The product between this scalar and the inverse of the given vector.
     */
    def /(v: Vec3c): Vec3c = v.inverse * self
  }

  /**
   * Implicit conversion from [[Vec3d]] to [[Vec3c]].
   */
  implicit val vec3dToVec3c: Vec3d => Vec3c = v => Vec3c(v.x, v.y, v.z)
}
