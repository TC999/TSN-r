package com.bumptech.glide.load.engine.bitmap_recycle;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.i */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class IntegerArrayAdapter implements ArrayAdapterInterface<int[]> {

    /* renamed from: a */
    private static final String f13569a = "IntegerArrayPool";

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    /* renamed from: a */
    public int mo45400a() {
        return 4;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    /* renamed from: c */
    public int mo45399b(int[] iArr) {
        return iArr.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    /* renamed from: d */
    public int[] newArray(int i) {
        return new int[i];
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public String getTag() {
        return f13569a;
    }
}
