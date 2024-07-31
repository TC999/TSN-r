package com.kwad.sdk.utils;

/* renamed from: com.kwad.sdk.utils.bd */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C11049bd {
    private final int mHeight;
    private final int mWidth;

    public C11049bd(int i, int i2) {
        this.mWidth = i;
        this.mHeight = i2;
    }

    /* renamed from: MG */
    public final float m23952MG() {
        return this.mWidth;
    }

    /* renamed from: MH */
    public final float m23951MH() {
        return this.mHeight;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof C11049bd) {
            C11049bd c11049bd = (C11049bd) obj;
            if (this.mWidth == c11049bd.mWidth && this.mHeight == c11049bd.mHeight) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int hashCode() {
        int i = this.mHeight;
        int i2 = this.mWidth;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public final String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
