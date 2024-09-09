package com.github.mikephil.charting.matrix;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class Vector3 {

    /* renamed from: x  reason: collision with root package name */
    public float f37327x;

    /* renamed from: y  reason: collision with root package name */
    public float f37328y;

    /* renamed from: z  reason: collision with root package name */
    public float f37329z;
    public static final Vector3 ZERO = new Vector3(0.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_X = new Vector3(1.0f, 0.0f, 0.0f);
    public static final Vector3 UNIT_Y = new Vector3(0.0f, 1.0f, 0.0f);
    public static final Vector3 UNIT_Z = new Vector3(0.0f, 0.0f, 1.0f);

    public Vector3() {
    }

    public final void add(Vector3 vector3) {
        this.f37327x += vector3.f37327x;
        this.f37328y += vector3.f37328y;
        this.f37329z += vector3.f37329z;
    }

    public final Vector3 cross(Vector3 vector3) {
        float f4 = this.f37328y;
        float f5 = vector3.f37329z;
        float f6 = this.f37329z;
        float f7 = vector3.f37328y;
        float f8 = (f4 * f5) - (f6 * f7);
        float f9 = vector3.f37327x;
        float f10 = this.f37327x;
        return new Vector3(f8, (f6 * f9) - (f5 * f10), (f10 * f7) - (f4 * f9));
    }

    public final float distance2(Vector3 vector3) {
        float f4 = this.f37327x - vector3.f37327x;
        float f5 = this.f37328y - vector3.f37328y;
        float f6 = this.f37329z - vector3.f37329z;
        return (f4 * f4) + (f5 * f5) + (f6 * f6);
    }

    public final void divide(float f4) {
        if (f4 != 0.0f) {
            this.f37327x /= f4;
            this.f37328y /= f4;
            this.f37329z /= f4;
        }
    }

    public final float dot(Vector3 vector3) {
        return (this.f37327x * vector3.f37327x) + (this.f37328y * vector3.f37328y) + (this.f37329z * vector3.f37329z);
    }

    public final float length() {
        return (float) Math.sqrt(length2());
    }

    public final float length2() {
        float f4 = this.f37327x;
        float f5 = this.f37328y;
        float f6 = (f4 * f4) + (f5 * f5);
        float f7 = this.f37329z;
        return f6 + (f7 * f7);
    }

    public final void multiply(float f4) {
        this.f37327x *= f4;
        this.f37328y *= f4;
        this.f37329z *= f4;
    }

    public final float normalize() {
        float length = length();
        if (length != 0.0f) {
            this.f37327x /= length;
            this.f37328y /= length;
            this.f37329z /= length;
        }
        return length;
    }

    public final boolean pointsInSameDirection(Vector3 vector3) {
        return dot(vector3) > 0.0f;
    }

    public final void set(Vector3 vector3) {
        this.f37327x = vector3.f37327x;
        this.f37328y = vector3.f37328y;
        this.f37329z = vector3.f37329z;
    }

    public final void subtract(Vector3 vector3) {
        this.f37327x -= vector3.f37327x;
        this.f37328y -= vector3.f37328y;
        this.f37329z -= vector3.f37329z;
    }

    public final void subtractMultiple(Vector3 vector3, float f4) {
        this.f37327x -= vector3.f37327x * f4;
        this.f37328y -= vector3.f37328y * f4;
        this.f37329z -= vector3.f37329z * f4;
    }

    public final void zero() {
        set(0.0f, 0.0f, 0.0f);
    }

    public Vector3(float[] fArr) {
        set(fArr[0], fArr[1], fArr[2]);
    }

    public Vector3(float f4, float f5, float f6) {
        set(f4, f5, f6);
    }

    public final void add(float f4, float f5, float f6) {
        this.f37327x += f4;
        this.f37328y += f5;
        this.f37329z += f6;
    }

    public final void multiply(Vector3 vector3) {
        this.f37327x *= vector3.f37327x;
        this.f37328y *= vector3.f37328y;
        this.f37329z *= vector3.f37329z;
    }

    public final void set(float f4, float f5, float f6) {
        this.f37327x = f4;
        this.f37328y = f5;
        this.f37329z = f6;
    }

    public Vector3(Vector3 vector3) {
        set(vector3);
    }
}
