package com.tencent.open.utils;

import androidx.core.view.MotionEventCompat;
import kotlin.UByte;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.o */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C13073o implements Cloneable {

    /* renamed from: a */
    private int f37457a;

    public C13073o(byte[] bArr) {
        this(bArr, 0);
    }

    /* renamed from: a */
    public byte[] m14913a() {
        int i = this.f37457a;
        return new byte[]{(byte) (i & 255), (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    /* renamed from: b */
    public int m14912b() {
        return this.f37457a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof C13073o) && this.f37457a == ((C13073o) obj).m14912b();
    }

    public int hashCode() {
        return this.f37457a;
    }

    public C13073o(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.f37457a = i2;
        this.f37457a = i2 + (bArr[i] & UByte.f41242c);
    }

    public C13073o(int i) {
        this.f37457a = i;
    }
}
