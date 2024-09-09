package com.kwad.sdk.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class bd {
    private final int mHeight;
    private final int mWidth;

    public bd(int i4, int i5) {
        this.mWidth = i4;
        this.mHeight = i5;
    }

    public final float MG() {
        return this.mWidth;
    }

    public final float MH() {
        return this.mHeight;
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof bd) {
            bd bdVar = (bd) obj;
            if (this.mWidth == bdVar.mWidth && this.mHeight == bdVar.mHeight) {
                return true;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.mHeight;
    }

    public final int hashCode() {
        int i4 = this.mHeight;
        int i5 = this.mWidth;
        return i4 ^ ((i5 >>> 16) | (i5 << 16));
    }

    public final String toString() {
        return this.mWidth + "x" + this.mHeight;
    }
}
