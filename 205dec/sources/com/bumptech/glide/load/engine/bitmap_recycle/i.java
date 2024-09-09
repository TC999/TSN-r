package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: IntegerArrayAdapter.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class i implements a<int[]> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f16892a = "IntegerArrayPool";

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public int a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* renamed from: c */
    public int b(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* renamed from: d */
    public int[] newArray(int i4) {
        return new int[i4];
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public String getTag() {
        return "IntegerArrayPool";
    }
}
