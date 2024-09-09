package com.bytedance.pangle.res.a;

import java.io.IOException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class g extends f {
    public g(i iVar) {
        super(iVar);
    }

    public final int[] a(int i4) {
        int[] iArr = new int[i4];
        for (int i5 = 0; i5 < i4; i5++) {
            iArr[i5] = readInt();
        }
        return iArr;
    }

    public final void b() {
        byte readByte = readByte();
        if (readByte != 0) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (byte) 0, Byte.valueOf(readByte)));
        }
    }

    @Override // com.bytedance.pangle.res.a.f, java.io.DataInput
    public final int skipBytes(int i4) {
        int i5 = 0;
        while (i5 < i4) {
            int skipBytes = super.skipBytes(i4 - i5);
            if (skipBytes <= 0) {
                break;
            }
            i5 += skipBytes;
        }
        return i5;
    }

    public final void a() {
        short readShort = readShort();
        if (readShort != 8) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", (short) 8, Short.valueOf(readShort)));
        }
    }

    public final void b(int i4) {
        int readInt;
        while (true) {
            readInt = readInt();
            if (readInt != i4 && readInt >= 1835009) {
                break;
            }
            i4 = -1;
        }
        if (readInt != 1835009) {
            throw new IOException(String.format("Expected: 0x%08x, got: 0x%08x", 1835009, Integer.valueOf(readInt)));
        }
    }
}
