package com.mbridge.msdk.thrid.okio;

import java.util.AbstractList;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class Options extends AbstractList<ByteString> implements RandomAccess {
    final ByteString[] byteStrings;
    final int[] trie;

    private Options(ByteString[] byteStringArr, int[] iArr) {
        this.byteStrings = byteStringArr;
        this.trie = iArr;
    }

    private static void buildTrieRecursive(long j4, Buffer buffer, int i4, List<ByteString> list, int i5, int i6, List<Integer> list2) {
        int i7;
        int i8;
        int i9;
        Buffer buffer2;
        int i10 = i5;
        if (i10 < i6) {
            for (int i11 = i10; i11 < i6; i11++) {
                if (list.get(i11).size() < i4) {
                    throw new AssertionError();
                }
            }
            ByteString byteString = list.get(i5);
            ByteString byteString2 = list.get(i6 - 1);
            int i12 = -1;
            if (i4 == byteString.size()) {
                i12 = list2.get(i10).intValue();
                i10++;
                byteString = list.get(i10);
            }
            int i13 = i10;
            if (byteString.getByte(i4) != byteString2.getByte(i4)) {
                int i14 = 1;
                for (int i15 = i13 + 1; i15 < i6; i15++) {
                    if (list.get(i15 - 1).getByte(i4) != list.get(i15).getByte(i4)) {
                        i14++;
                    }
                }
                long intCount = j4 + intCount(buffer) + 2 + (i14 * 2);
                buffer.writeInt(i14);
                buffer.writeInt(i12);
                for (int i16 = i13; i16 < i6; i16++) {
                    byte b4 = list.get(i16).getByte(i4);
                    if (i16 == i13 || b4 != list.get(i16 - 1).getByte(i4)) {
                        buffer.writeInt(b4 & 255);
                    }
                }
                Buffer buffer3 = new Buffer();
                int i17 = i13;
                while (i17 < i6) {
                    byte b5 = list.get(i17).getByte(i4);
                    int i18 = i17 + 1;
                    int i19 = i18;
                    while (true) {
                        if (i19 >= i6) {
                            i8 = i6;
                            break;
                        } else if (b5 != list.get(i19).getByte(i4)) {
                            i8 = i19;
                            break;
                        } else {
                            i19++;
                        }
                    }
                    if (i18 == i8 && i4 + 1 == list.get(i17).size()) {
                        buffer.writeInt(list2.get(i17).intValue());
                        i9 = i8;
                        buffer2 = buffer3;
                    } else {
                        buffer.writeInt((int) ((intCount(buffer3) + intCount) * (-1)));
                        i9 = i8;
                        buffer2 = buffer3;
                        buildTrieRecursive(intCount, buffer3, i4 + 1, list, i17, i8, list2);
                    }
                    buffer3 = buffer2;
                    i17 = i9;
                }
                Buffer buffer4 = buffer3;
                buffer.write(buffer4, buffer4.size());
                return;
            }
            int i20 = 0;
            int min = Math.min(byteString.size(), byteString2.size());
            for (int i21 = i4; i21 < min && byteString.getByte(i21) == byteString2.getByte(i21); i21++) {
                i20++;
            }
            long intCount2 = 1 + j4 + intCount(buffer) + 2 + i20;
            buffer.writeInt(-i20);
            buffer.writeInt(i12);
            int i22 = i4;
            while (true) {
                i7 = i4 + i20;
                if (i22 >= i7) {
                    break;
                }
                buffer.writeInt(byteString.getByte(i22) & 255);
                i22++;
            }
            if (i13 + 1 == i6) {
                if (i7 == list.get(i13).size()) {
                    buffer.writeInt(list2.get(i13).intValue());
                    return;
                }
                throw new AssertionError();
            }
            Buffer buffer5 = new Buffer();
            buffer.writeInt((int) ((intCount(buffer5) + intCount2) * (-1)));
            buildTrieRecursive(intCount2, buffer5, i7, list, i13, i6, list2);
            buffer.write(buffer5, buffer5.size());
            return;
        }
        throw new AssertionError();
    }

    private static int intCount(Buffer buffer) {
        return (int) (buffer.size() / 4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:51:0x00bc, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.mbridge.msdk.thrid.okio.Options of(com.mbridge.msdk.thrid.okio.ByteString... r10) {
        /*
            Method dump skipped, instructions count: 266
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okio.Options.of(com.mbridge.msdk.thrid.okio.ByteString[]):com.mbridge.msdk.thrid.okio.Options");
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.byteStrings.length;
    }

    @Override // java.util.AbstractList, java.util.List
    public ByteString get(int i4) {
        return this.byteStrings[i4];
    }
}
