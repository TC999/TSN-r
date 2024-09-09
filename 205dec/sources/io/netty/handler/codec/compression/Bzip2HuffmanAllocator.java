package io.netty.handler.codec.compression;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class Bzip2HuffmanAllocator {
    private Bzip2HuffmanAllocator() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void allocateHuffmanCodeLengths(int[] iArr, int i4) {
        int length = iArr.length;
        if (length != 1) {
            if (length != 2) {
                setExtendedParentPointers(iArr);
                int findNodesToRelocate = findNodesToRelocate(iArr, i4);
                if (iArr[0] % iArr.length >= findNodesToRelocate) {
                    allocateNodeLengths(iArr);
                    return;
                } else {
                    allocateNodeLengthsWithRelocation(iArr, findNodesToRelocate, i4 - (32 - Integer.numberOfLeadingZeros(findNodesToRelocate - 1)));
                    return;
                }
            }
            iArr[1] = 1;
        }
        iArr[0] = 1;
    }

    private static void allocateNodeLengths(int[] iArr) {
        int i4 = 2;
        int length = iArr.length - 2;
        int i5 = 1;
        int length2 = iArr.length - 1;
        while (i4 > 0) {
            int first = first(iArr, length - 1, 0);
            int i6 = length - first;
            int i7 = i4 - i6;
            while (i7 > 0) {
                iArr[length2] = i5;
                i7--;
                length2--;
            }
            i4 = i6 << 1;
            i5++;
            length = first;
        }
    }

    private static void allocateNodeLengthsWithRelocation(int[] iArr, int i4, int i5) {
        int length = iArr.length - 2;
        int length2 = iArr.length - 1;
        int i6 = i5 != 1 ? 1 : 2;
        int i7 = i5 == 1 ? i4 - 2 : i4;
        int i8 = i6 << 1;
        while (i8 > 0) {
            int first = length <= i4 ? length : first(iArr, length - 1, i4);
            int i9 = 0;
            if (i6 >= i5) {
                i9 = Math.min(i7, 1 << (i6 - i5));
            } else if (i6 == i5 - 1) {
                if (iArr[first] == length) {
                    first++;
                }
                i9 = 1;
            }
            int i10 = (length - first) + i9;
            int i11 = i8 - i10;
            while (i11 > 0) {
                iArr[length2] = i6;
                i11--;
                length2--;
            }
            i7 -= i9;
            i8 = i10 << 1;
            i6++;
            length = first;
        }
    }

    private static int findNodesToRelocate(int[] iArr, int i4) {
        int length = iArr.length - 2;
        for (int i5 = 1; i5 < i4 - 1 && length > 1; i5++) {
            length = first(iArr, length - 1, 0);
        }
        return length;
    }

    private static int first(int[] iArr, int i4, int i5) {
        int length = iArr.length;
        int length2 = iArr.length - 2;
        int i6 = i4;
        while (i6 >= i5 && iArr[i6] % length > i4) {
            length2 = i6;
            i6 -= (i4 - i6) + 1;
        }
        int max = Math.max(i5 - 1, i6);
        while (length2 > max + 1) {
            int i7 = (max + length2) >>> 1;
            if (iArr[i7] % length > i4) {
                length2 = i7;
            } else {
                max = i7;
            }
        }
        return length2;
    }

    private static void setExtendedParentPointers(int[] iArr) {
        int i4;
        int i5;
        int length = iArr.length;
        int i6 = 0;
        iArr[0] = iArr[0] + iArr[1];
        int i7 = 2;
        for (int i8 = 1; i8 < length - 1; i8++) {
            if (i7 < length && iArr[i6] >= iArr[i7]) {
                i4 = iArr[i7];
                i7++;
            } else {
                i4 = iArr[i6];
                iArr[i6] = i8;
                i6++;
            }
            if (i7 < length && (i6 >= i8 || iArr[i6] >= iArr[i7])) {
                i5 = i4 + iArr[i7];
                i7++;
            } else {
                i5 = i4 + iArr[i6];
                iArr[i6] = i8 + length;
                i6++;
            }
            iArr[i8] = i5;
        }
    }
}
