package com.bumptech.glide;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public enum MemoryCategory {
    LOW(0.5f),
    NORMAL(1.0f),
    HIGH(1.5f);
    
    private final float multiplier;

    MemoryCategory(float f4) {
        this.multiplier = f4;
    }

    public float getMultiplier() {
        return this.multiplier;
    }
}
