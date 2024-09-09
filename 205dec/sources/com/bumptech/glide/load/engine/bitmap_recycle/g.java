package com.bumptech.glide.load.engine.bitmap_recycle;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: ByteArrayAdapter.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public final class g implements a<byte[]> {

    /* renamed from: a  reason: collision with root package name */
    private static final String f16885a = "ByteArrayPool";

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public int a() {
        return 1;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* renamed from: c */
    public int b(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    /* renamed from: d */
    public byte[] newArray(int i4) {
        return new byte[i4];
    }

    @Override // com.bumptech.glide.load.engine.bitmap_recycle.a
    public String getTag() {
        return "ByteArrayPool";
    }
}
