package com.bytedance.pangle.res.p124a;

import java.io.IOException;

/* renamed from: com.bytedance.pangle.res.a.g */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6209g extends AbstractC6208f {
    public C6209g(C6211i c6211i) {
        super(c6211i);
    }

    /* renamed from: a */
    public final int[] m36980a(int i) {
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            iArr[i2] = readInt();
        }
        return iArr;
    }

    /* renamed from: b */
    public final void m36979b() {
        byte readByte = readByte();
        if (readByte != 0) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (byte) 0, Byte.valueOf(readByte)));
        }
    }

    @Override // com.bytedance.pangle.res.p124a.AbstractC6208f, java.io.DataInput
    public final int skipBytes(int i) {
        int i2 = 0;
        while (i2 < i) {
            int skipBytes = super.skipBytes(i - i2);
            if (skipBytes <= 0) {
                break;
            }
            i2 += skipBytes;
        }
        return i2;
    }

    /* renamed from: a */
    public final void m36981a() {
        short readShort = readShort();
        if (readShort != 8) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (short) 8, Short.valueOf(readShort)));
        }
    }

    /* renamed from: b */
    public final void m36978b(int i) {
        int readInt;
        while (true) {
            readInt = readInt();
            if (readInt != i && readInt >= 1835009) {
                break;
            }
            i = -1;
        }
        if (readInt != 1835009) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", 1835009, Integer.valueOf(readInt)));
        }
    }
}
