package com.github.mikephil.charting.matrix;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class Vector3 {

    /* renamed from: x */
    public float f23773x;

    /* renamed from: y */
    public float f23774y;

    /* renamed from: z */
    public float f23775z;
    public static final Vector3 ZERO = new Vector3(0.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_X = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_Y = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 UNIT_Z = new Vector3(0.0f, 0.0f, 1.0f);

    public Vector3() {
    }

    public final void add(Vector3 vector3) {
        this.f23773x += vector3.f23773x;
        this.f23774y += vector3.f23774y;
        this.f23775z += vector3.f23775z;
    }

    public final Vector3 cross(Vector3 vector3) {
        float f = this.f23774y;
        float f2 = vector3.f23775z;
        float f3 = this.f23775z;
        float f4 = vector3.f23774y;
        float f5 = (f * f2) - (f3 * f4);
        float f6 = vector3.f23773x;
        float f7 = this.f23773x;
        return new Vector3(f5, (f3 * f6) - (f2 * f7), (f7 * f4) - (f * f6));
    }

    public final float distance2(Vector3 vector3) {
        float f = this.f23773x - vector3.f23773x;
        float f2 = this.f23774y - vector3.f23774y;
        float f3 = this.f23775z - vector3.f23775z;
        return (f * f) + (f2 * f2) + (f3 * f3);
    }

    public final void divide(float f) {
        if (f != 0.0f) {
            this.f23773x /= f;
            this.f23774y /= f;
            this.f23775z /= f;
        }
    }

    public final float dot(Vector3 vector3) {
        return (this.f23773x * vector3.f23773x) + (this.f23774y * vector3.f23774y) + (this.f23775z * vector3.f23775z);
    }

    public final float length() {
        return (float) Math.sqrt(length2());
    }

    public final float length2() {
        float f = this.f23773x;
        float f2 = this.f23774y;
        float f3 = (f * f) + (f2 * f2);
        float f4 = this.f23775z;
        return f3 + (f4 * f4);
    }

    public final void multiply(float f) {
        this.f23773x *= f;
        this.f23774y *= f;
        this.f23775z *= f;
    }

    public final float normalize() {
        float length = length();
        if (length != 0.0f) {
            this.f23773x /= length;
            this.f23774y /= length;
            this.f23775z /= length;
        }
        return length;
    }

    public final boolean pointsInSameDirection(Vector3 vector3) {
        return dot(vector3) > 0.0f;
    }

    public final void set(Vector3 vector3) {
        this.f23773x = vector3.f23773x;
        this.f23774y = vector3.f23774y;
        this.f23775z = vector3.f23775z;
    }

    public final void subtract(Vector3 vector3) {
        this.f23773x -= vector3.f23773x;
        this.f23774y -= vector3.f23774y;
        this.f23775z -= vector3.f23775z;
    }

    public final void subtractMultiple(Vector3 vector3, float f) {
        this.f23773x -= vector3.f23773x * f;
        this.f23774y -= vector3.f23774y * f;
        this.f23775z -= vector3.f23775z * f;
    }

    public final void zero() {
        set(0.0f, 0.0f, 0.0f);
    }

    public Vector3(float[] fArr) {
        set(fArr[0], fArr[1], fArr[2]);
    }

    public Vector3(float f, float f2, float f3) {
        set(f, f2, f3);
    }

    public final void add(float f, float f2, float f3) {
        this.f23773x += f;
        this.f23774y += f2;
        this.f23775z += f3;
    }

    public final void multiply(Vector3 vector3) {
        this.f23773x *= vector3.f23773x;
        this.f23774y *= vector3.f23774y;
        this.f23775z *= vector3.f23775z;
    }

    public final void set(float f, float f2, float f3) {
        this.f23773x = f;
        this.f23774y = f2;
        this.f23775z = f3;
    }

    public Vector3(Vector3 vector3) {
        set(vector3);
    }
}
