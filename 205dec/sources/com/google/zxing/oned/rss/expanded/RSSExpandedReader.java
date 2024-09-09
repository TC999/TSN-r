package com.google.zxing.oned.rss.expanded;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;
import com.google.zxing.oned.rss.AbstractRSSReader;
import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;
import com.google.zxing.oned.rss.RSSUtils;
import com.google.zxing.oned.rss.expanded.decoders.AbstractExpandedDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class RSSExpandedReader extends AbstractRSSReader {
    private static final int FINDER_PAT_A = 0;
    private static final int FINDER_PAT_B = 1;
    private static final int FINDER_PAT_C = 2;
    private static final int FINDER_PAT_D = 3;
    private static final int FINDER_PAT_E = 4;
    private static final int FINDER_PAT_F = 5;
    private static final int MAX_PAIRS = 11;
    private final List<ExpandedPair> pairs = new ArrayList(11);
    private final List<ExpandedRow> rows = new ArrayList();
    private final int[] startEnd = new int[2];
    private boolean startFromEven;
    private static final int[] SYMBOL_WIDEST = {7, 5, 4, 3, 1};
    private static final int[] EVEN_TOTAL_SUBSET = {4, 20, 52, 104, 204};
    private static final int[] GSUM = {0, MediaPlayer.MEDIA_PLAYER_OPTION_ALWAYS_DO_AV_SYNC, 1388, 2948, 3988};
    private static final int[][] FINDER_PATTERNS = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    private static final int[][] WEIGHTS = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SHARP, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_CODEC_NAME, 49, 147, 19, 57, MediaPlayer.MEDIA_PLAYER_OPTION_BIT_RATE, 91}, new int[]{62, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEODECODER_FPS, 136, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_SWITCH_COUNT, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME}, new int[]{46, 138, 203, 187, 139, 206, MediaPlayer.MEDIA_PLAYER_OPTION_PRE_DECODE_AUTO_PAUSE, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, MediaPlayer.MEDIA_PLAYER_OPTION_MEDIA_CODEC_REAL_TIME}, new int[]{70, 210, 208, 202, 184, 130, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_PROBE_COUNT, 115}, new int[]{134, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_SPEED, 151, 31, 93, 68, 204, MediaPlayer.MEDIA_PLAYER_OPTION_SLOW_PLAY_TIME}, new int[]{148, 22, 66, 198, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DASH_ABR, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY, 160, 58, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 100, 89}};
    private static final int[][] FINDER_PATTERN_SEQUENCES = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};

    private void adjustOddEvenCounts(int i4) throws NotFoundException {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        int sum = MathUtils.sum(getOddCounts());
        int sum2 = MathUtils.sum(getEvenCounts());
        boolean z7 = true;
        if (sum > 13) {
            z3 = false;
            z4 = true;
        } else {
            z3 = sum < 4;
            z4 = false;
        }
        if (sum2 > 13) {
            z5 = false;
            z6 = true;
        } else {
            z5 = sum2 < 4;
            z6 = false;
        }
        int i5 = (sum + sum2) - i4;
        boolean z8 = (sum & 1) == 1;
        boolean z9 = (sum2 & 1) == 0;
        if (i5 == 1) {
            if (z8) {
                if (z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
                z7 = z3;
                z4 = true;
            } else if (!z9) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z7 = z3;
                z6 = true;
            }
        } else if (i5 == -1) {
            if (z8) {
                if (z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
            } else if (!z9) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z7 = z3;
                z5 = true;
            }
        } else if (i5 != 0) {
            throw NotFoundException.getNotFoundInstance();
        } else {
            if (z8) {
                if (!z9) {
                    throw NotFoundException.getNotFoundInstance();
                }
                if (sum >= sum2) {
                    z7 = z3;
                    z5 = true;
                    z4 = true;
                }
                z6 = true;
            } else if (z9) {
                throw NotFoundException.getNotFoundInstance();
            } else {
                z7 = z3;
            }
        }
        if (z7) {
            if (!z4) {
                AbstractRSSReader.increment(getOddCounts(), getOddRoundingErrors());
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if (z4) {
            AbstractRSSReader.decrement(getOddCounts(), getOddRoundingErrors());
        }
        if (z5) {
            if (!z6) {
                AbstractRSSReader.increment(getEvenCounts(), getOddRoundingErrors());
            } else {
                throw NotFoundException.getNotFoundInstance();
            }
        }
        if (z6) {
            AbstractRSSReader.decrement(getEvenCounts(), getEvenRoundingErrors());
        }
    }

    private boolean checkChecksum() {
        ExpandedPair expandedPair = this.pairs.get(0);
        DataCharacter leftChar = expandedPair.getLeftChar();
        DataCharacter rightChar = expandedPair.getRightChar();
        if (rightChar == null) {
            return false;
        }
        int checksumPortion = rightChar.getChecksumPortion();
        int i4 = 2;
        for (int i5 = 1; i5 < this.pairs.size(); i5++) {
            ExpandedPair expandedPair2 = this.pairs.get(i5);
            checksumPortion += expandedPair2.getLeftChar().getChecksumPortion();
            i4++;
            DataCharacter rightChar2 = expandedPair2.getRightChar();
            if (rightChar2 != null) {
                checksumPortion += rightChar2.getChecksumPortion();
                i4++;
            }
        }
        return ((i4 + (-4)) * 211) + (checksumPortion % 211) == leftChar.getValue();
    }

    private List<ExpandedPair> checkRows(boolean z3) {
        List<ExpandedPair> list = null;
        if (this.rows.size() > 25) {
            this.rows.clear();
            return null;
        }
        this.pairs.clear();
        if (z3) {
            Collections.reverse(this.rows);
        }
        try {
            list = checkRows(new ArrayList(), 0);
        } catch (NotFoundException unused) {
        }
        if (z3) {
            Collections.reverse(this.rows);
        }
        return list;
    }

    static Result constructResult(List<ExpandedPair> list) throws NotFoundException, FormatException {
        String parseInformation = AbstractExpandedDecoder.createDecoder(BitArrayBuilder.buildBitArray(list)).parseInformation();
        ResultPoint[] resultPoints = list.get(0).getFinderPattern().getResultPoints();
        ResultPoint[] resultPoints2 = list.get(list.size() - 1).getFinderPattern().getResultPoints();
        return new Result(parseInformation, null, new ResultPoint[]{resultPoints[0], resultPoints[1], resultPoints2[0], resultPoints2[1]}, BarcodeFormat.RSS_EXPANDED);
    }

    private void findNextPair(BitArray bitArray, List<ExpandedPair> list, int i4) throws NotFoundException {
        int[] decodeFinderCounters = getDecodeFinderCounters();
        decodeFinderCounters[0] = 0;
        decodeFinderCounters[1] = 0;
        decodeFinderCounters[2] = 0;
        decodeFinderCounters[3] = 0;
        int size = bitArray.getSize();
        if (i4 < 0) {
            i4 = list.isEmpty() ? 0 : list.get(list.size() - 1).getFinderPattern().getStartEnd()[1];
        }
        boolean z3 = list.size() % 2 != 0;
        if (this.startFromEven) {
            z3 = !z3;
        }
        boolean z4 = false;
        while (i4 < size) {
            z4 = !bitArray.get(i4);
            if (!z4) {
                break;
            }
            i4++;
        }
        boolean z5 = z4;
        int i5 = 0;
        int i6 = i4;
        while (i4 < size) {
            if (bitArray.get(i4) ^ z5) {
                decodeFinderCounters[i5] = decodeFinderCounters[i5] + 1;
            } else {
                if (i5 == 3) {
                    if (z3) {
                        reverseCounters(decodeFinderCounters);
                    }
                    if (AbstractRSSReader.isFinderPattern(decodeFinderCounters)) {
                        int[] iArr = this.startEnd;
                        iArr[0] = i6;
                        iArr[1] = i4;
                        return;
                    }
                    if (z3) {
                        reverseCounters(decodeFinderCounters);
                    }
                    i6 += decodeFinderCounters[0] + decodeFinderCounters[1];
                    decodeFinderCounters[0] = decodeFinderCounters[2];
                    decodeFinderCounters[1] = decodeFinderCounters[3];
                    decodeFinderCounters[2] = 0;
                    decodeFinderCounters[3] = 0;
                    i5--;
                } else {
                    i5++;
                }
                decodeFinderCounters[i5] = 1;
                z5 = !z5;
            }
            i4++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int getNextSecondBar(BitArray bitArray, int i4) {
        if (bitArray.get(i4)) {
            return bitArray.getNextSet(bitArray.getNextUnset(i4));
        }
        return bitArray.getNextUnset(bitArray.getNextSet(i4));
    }

    private static boolean isNotA1left(FinderPattern finderPattern, boolean z3, boolean z4) {
        return (finderPattern.getValue() == 0 && z3 && z4) ? false : true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0043, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean isPartialRow(java.lang.Iterable<com.google.zxing.oned.rss.expanded.ExpandedPair> r7, java.lang.Iterable<com.google.zxing.oned.rss.expanded.ExpandedRow> r8) {
        /*
            java.util.Iterator r8 = r8.iterator()
        L4:
            boolean r0 = r8.hasNext()
            r1 = 0
            if (r0 == 0) goto L46
            java.lang.Object r0 = r8.next()
            com.google.zxing.oned.rss.expanded.ExpandedRow r0 = (com.google.zxing.oned.rss.expanded.ExpandedRow) r0
            java.util.Iterator r2 = r7.iterator()
        L15:
            boolean r3 = r2.hasNext()
            r4 = 1
            if (r3 == 0) goto L42
            java.lang.Object r3 = r2.next()
            com.google.zxing.oned.rss.expanded.ExpandedPair r3 = (com.google.zxing.oned.rss.expanded.ExpandedPair) r3
            java.util.List r5 = r0.getPairs()
            java.util.Iterator r5 = r5.iterator()
        L2a:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L3e
            java.lang.Object r6 = r5.next()
            com.google.zxing.oned.rss.expanded.ExpandedPair r6 = (com.google.zxing.oned.rss.expanded.ExpandedPair) r6
            boolean r6 = r3.equals(r6)
            if (r6 == 0) goto L2a
            r3 = 1
            goto L3f
        L3e:
            r3 = 0
        L3f:
            if (r3 != 0) goto L15
            goto L43
        L42:
            r1 = 1
        L43:
            if (r1 == 0) goto L4
            return r4
        L46:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.expanded.RSSExpandedReader.isPartialRow(java.lang.Iterable, java.lang.Iterable):boolean");
    }

    private static boolean isValidSequence(List<ExpandedPair> list) {
        int[][] iArr;
        boolean z3;
        for (int[] iArr2 : FINDER_PATTERN_SEQUENCES) {
            if (list.size() <= iArr2.length) {
                int i4 = 0;
                while (true) {
                    if (i4 >= list.size()) {
                        z3 = true;
                        break;
                    } else if (list.get(i4).getFinderPattern().getValue() != iArr2[i4]) {
                        z3 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                if (z3) {
                    return true;
                }
            }
        }
        return false;
    }

    private FinderPattern parseFoundFinderPattern(BitArray bitArray, int i4, boolean z3) {
        int i5;
        int i6;
        int i7;
        if (z3) {
            int i8 = this.startEnd[0] - 1;
            while (i8 >= 0 && !bitArray.get(i8)) {
                i8--;
            }
            int i9 = i8 + 1;
            int[] iArr = this.startEnd;
            i7 = iArr[0] - i9;
            i5 = iArr[1];
            i6 = i9;
        } else {
            int[] iArr2 = this.startEnd;
            int i10 = iArr2[0];
            int nextUnset = bitArray.getNextUnset(iArr2[1] + 1);
            i5 = nextUnset;
            i6 = i10;
            i7 = nextUnset - this.startEnd[1];
        }
        int[] decodeFinderCounters = getDecodeFinderCounters();
        System.arraycopy(decodeFinderCounters, 0, decodeFinderCounters, 1, decodeFinderCounters.length - 1);
        decodeFinderCounters[0] = i7;
        try {
            return new FinderPattern(AbstractRSSReader.parseFinderValue(decodeFinderCounters, FINDER_PATTERNS), new int[]{i6, i5}, i6, i5, i4);
        } catch (NotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:33:0x004c, code lost:
        continue;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void removePartialRows(java.util.List<com.google.zxing.oned.rss.expanded.ExpandedPair> r6, java.util.List<com.google.zxing.oned.rss.expanded.ExpandedRow> r7) {
        /*
            java.util.Iterator r7 = r7.iterator()
        L4:
            boolean r0 = r7.hasNext()
            if (r0 == 0) goto L56
            java.lang.Object r0 = r7.next()
            com.google.zxing.oned.rss.expanded.ExpandedRow r0 = (com.google.zxing.oned.rss.expanded.ExpandedRow) r0
            java.util.List r1 = r0.getPairs()
            int r1 = r1.size()
            int r2 = r6.size()
            if (r1 == r2) goto L4
            java.util.List r0 = r0.getPairs()
            java.util.Iterator r0 = r0.iterator()
        L26:
            boolean r1 = r0.hasNext()
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L4f
            java.lang.Object r1 = r0.next()
            com.google.zxing.oned.rss.expanded.ExpandedPair r1 = (com.google.zxing.oned.rss.expanded.ExpandedPair) r1
            java.util.Iterator r4 = r6.iterator()
        L38:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L4b
            java.lang.Object r5 = r4.next()
            com.google.zxing.oned.rss.expanded.ExpandedPair r5 = (com.google.zxing.oned.rss.expanded.ExpandedPair) r5
            boolean r5 = r1.equals(r5)
            if (r5 == 0) goto L38
            goto L4c
        L4b:
            r3 = 0
        L4c:
            if (r3 != 0) goto L26
            goto L50
        L4f:
            r2 = 1
        L50:
            if (r2 == 0) goto L4
            r7.remove()
            goto L4
        L56:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.expanded.RSSExpandedReader.removePartialRows(java.util.List, java.util.List):void");
    }

    private static void reverseCounters(int[] iArr) {
        int length = iArr.length;
        for (int i4 = 0; i4 < length / 2; i4++) {
            int i5 = iArr[i4];
            int i6 = (length - i4) - 1;
            iArr[i4] = iArr[i6];
            iArr[i6] = i5;
        }
    }

    private void storeRow(int i4, boolean z3) {
        boolean z4 = false;
        int i5 = 0;
        boolean z5 = false;
        while (true) {
            if (i5 >= this.rows.size()) {
                break;
            }
            ExpandedRow expandedRow = this.rows.get(i5);
            if (expandedRow.getRowNumber() > i4) {
                z4 = expandedRow.isEquivalent(this.pairs);
                break;
            } else {
                z5 = expandedRow.isEquivalent(this.pairs);
                i5++;
            }
        }
        if (z4 || z5 || isPartialRow(this.pairs, this.rows)) {
            return;
        }
        this.rows.add(i5, new ExpandedRow(this.pairs, i4, z3));
        removePartialRows(this.pairs, this.rows);
    }

    DataCharacter decodeDataCharacter(BitArray bitArray, FinderPattern finderPattern, boolean z3, boolean z4) throws NotFoundException {
        int[] dataCharacterCounters = getDataCharacterCounters();
        dataCharacterCounters[0] = 0;
        dataCharacterCounters[1] = 0;
        dataCharacterCounters[2] = 0;
        dataCharacterCounters[3] = 0;
        dataCharacterCounters[4] = 0;
        dataCharacterCounters[5] = 0;
        dataCharacterCounters[6] = 0;
        dataCharacterCounters[7] = 0;
        if (z4) {
            OneDReader.recordPatternInReverse(bitArray, finderPattern.getStartEnd()[0], dataCharacterCounters);
        } else {
            OneDReader.recordPattern(bitArray, finderPattern.getStartEnd()[1], dataCharacterCounters);
            int i4 = 0;
            for (int length = dataCharacterCounters.length - 1; i4 < length; length--) {
                int i5 = dataCharacterCounters[i4];
                dataCharacterCounters[i4] = dataCharacterCounters[length];
                dataCharacterCounters[length] = i5;
                i4++;
            }
        }
        float sum = MathUtils.sum(dataCharacterCounters) / 17.0f;
        float f4 = (finderPattern.getStartEnd()[1] - finderPattern.getStartEnd()[0]) / 15.0f;
        if (Math.abs(sum - f4) / f4 <= 0.3f) {
            int[] oddCounts = getOddCounts();
            int[] evenCounts = getEvenCounts();
            float[] oddRoundingErrors = getOddRoundingErrors();
            float[] evenRoundingErrors = getEvenRoundingErrors();
            for (int i6 = 0; i6 < dataCharacterCounters.length; i6++) {
                float f5 = (dataCharacterCounters[i6] * 1.0f) / sum;
                int i7 = (int) (0.5f + f5);
                if (i7 <= 0) {
                    if (f5 < 0.3f) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    i7 = 1;
                } else if (i7 > 8) {
                    if (f5 > 8.7f) {
                        throw NotFoundException.getNotFoundInstance();
                    }
                    i7 = 8;
                }
                int i8 = i6 / 2;
                if ((i6 & 1) == 0) {
                    oddCounts[i8] = i7;
                    oddRoundingErrors[i8] = f5 - i7;
                } else {
                    evenCounts[i8] = i7;
                    evenRoundingErrors[i8] = f5 - i7;
                }
            }
            adjustOddEvenCounts(17);
            int value = (((finderPattern.getValue() * 4) + (z3 ? 0 : 2)) + (!z4 ? 1 : 0)) - 1;
            int i9 = 0;
            int i10 = 0;
            for (int length2 = oddCounts.length - 1; length2 >= 0; length2--) {
                if (isNotA1left(finderPattern, z3, z4)) {
                    i9 += oddCounts[length2] * WEIGHTS[value][length2 * 2];
                }
                i10 += oddCounts[length2];
            }
            int i11 = 0;
            for (int length3 = evenCounts.length - 1; length3 >= 0; length3--) {
                if (isNotA1left(finderPattern, z3, z4)) {
                    i11 += evenCounts[length3] * WEIGHTS[value][(length3 * 2) + 1];
                }
            }
            int i12 = i9 + i11;
            if ((i10 & 1) == 0 && i10 <= 13 && i10 >= 4) {
                int i13 = (13 - i10) / 2;
                int i14 = SYMBOL_WIDEST[i13];
                return new DataCharacter((RSSUtils.getRSSvalue(oddCounts, i14, true) * EVEN_TOTAL_SUBSET[i13]) + RSSUtils.getRSSvalue(evenCounts, 9 - i14, false) + GSUM[i13], i12);
            }
            throw NotFoundException.getNotFoundInstance();
        }
        throw NotFoundException.getNotFoundInstance();
    }

    @Override // com.google.zxing.oned.OneDReader
    public Result decodeRow(int i4, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, FormatException {
        this.pairs.clear();
        this.startFromEven = false;
        try {
            return constructResult(decodeRow2pairs(i4, bitArray));
        } catch (NotFoundException unused) {
            this.pairs.clear();
            this.startFromEven = true;
            return constructResult(decodeRow2pairs(i4, bitArray));
        }
    }

    List<ExpandedPair> decodeRow2pairs(int i4, BitArray bitArray) throws NotFoundException {
        while (true) {
            try {
                this.pairs.add(retrieveNextPair(bitArray, this.pairs, i4));
            } catch (NotFoundException e4) {
                if (this.pairs.isEmpty()) {
                    throw e4;
                }
                if (checkChecksum()) {
                    return this.pairs;
                }
                boolean z3 = !this.rows.isEmpty();
                storeRow(i4, false);
                if (z3) {
                    List<ExpandedPair> checkRows = checkRows(false);
                    if (checkRows != null) {
                        return checkRows;
                    }
                    List<ExpandedPair> checkRows2 = checkRows(true);
                    if (checkRows2 != null) {
                        return checkRows2;
                    }
                }
                throw NotFoundException.getNotFoundInstance();
            }
        }
    }

    List<ExpandedRow> getRows() {
        return this.rows;
    }

    @Override // com.google.zxing.oned.OneDReader, com.google.zxing.Reader
    public void reset() {
        this.pairs.clear();
        this.rows.clear();
    }

    ExpandedPair retrieveNextPair(BitArray bitArray, List<ExpandedPair> list, int i4) throws NotFoundException {
        FinderPattern parseFoundFinderPattern;
        DataCharacter dataCharacter;
        boolean z3 = list.size() % 2 == 0;
        if (this.startFromEven) {
            z3 = !z3;
        }
        int i5 = -1;
        boolean z4 = true;
        do {
            findNextPair(bitArray, list, i5);
            parseFoundFinderPattern = parseFoundFinderPattern(bitArray, i4, z3);
            if (parseFoundFinderPattern == null) {
                i5 = getNextSecondBar(bitArray, this.startEnd[0]);
                continue;
            } else {
                z4 = false;
                continue;
            }
        } while (z4);
        DataCharacter decodeDataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z3, true);
        if (!list.isEmpty() && list.get(list.size() - 1).mustBeLast()) {
            throw NotFoundException.getNotFoundInstance();
        }
        try {
            dataCharacter = decodeDataCharacter(bitArray, parseFoundFinderPattern, z3, false);
        } catch (NotFoundException unused) {
            dataCharacter = null;
        }
        return new ExpandedPair(decodeDataCharacter, dataCharacter, parseFoundFinderPattern, true);
    }

    private List<ExpandedPair> checkRows(List<ExpandedRow> list, int i4) throws NotFoundException {
        while (i4 < this.rows.size()) {
            ExpandedRow expandedRow = this.rows.get(i4);
            this.pairs.clear();
            for (ExpandedRow expandedRow2 : list) {
                this.pairs.addAll(expandedRow2.getPairs());
            }
            this.pairs.addAll(expandedRow.getPairs());
            if (isValidSequence(this.pairs)) {
                if (checkChecksum()) {
                    return this.pairs;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(list);
                arrayList.add(expandedRow);
                try {
                    return checkRows(arrayList, i4 + 1);
                } catch (NotFoundException unused) {
                    continue;
                }
            }
            i4++;
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
