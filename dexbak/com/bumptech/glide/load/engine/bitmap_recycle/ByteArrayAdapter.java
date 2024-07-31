package com.bumptech.glide.load.engine.bitmap_recycle;

/* renamed from: com.bumptech.glide.load.engine.bitmap_recycle.g */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class ByteArrayAdapter implements ArrayAdapterInterface<byte[]> {

    /* renamed from: a */
    private static final String f13562a = "ByteArrayPool";

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    /* renamed from: a */
    public int mo45400a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    /* renamed from: c */
    public int mo45399b(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    /* renamed from: d */
    public byte[] newArray(int i) {
        return new byte[i];
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.ArrayAdapterInterface
    public String getTag() {
        return f13562a;
    }
}
