package com.google.zxing.datamatrix.encoder;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.Dimension;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class SymbolInfo {
    static final SymbolInfo[] PROD_SYMBOLS;
    private static SymbolInfo[] symbols;
    private final int dataCapacity;
    private final int dataRegions;
    private final int errorCodewords;
    public final int matrixHeight;
    public final int matrixWidth;
    private final boolean rectangular;
    private final int rsBlockData;
    private final int rsBlockError;

    static {
        SymbolInfo[] symbolInfoArr = {new SymbolInfo(false, 3, 5, 8, 8, 1), new SymbolInfo(false, 5, 7, 10, 10, 1), new SymbolInfo(true, 5, 7, 16, 6, 1), new SymbolInfo(false, 8, 10, 12, 12, 1), new SymbolInfo(true, 10, 11, 14, 6, 2), new SymbolInfo(false, 12, 12, 14, 14, 1), new SymbolInfo(true, 16, 14, 24, 10, 1), new SymbolInfo(false, 18, 14, 16, 16, 1), new SymbolInfo(false, 22, 18, 18, 18, 1), new SymbolInfo(true, 22, 18, 16, 10, 2), new SymbolInfo(false, 30, 20, 20, 20, 1), new SymbolInfo(true, 32, 24, 16, 14, 2), new SymbolInfo(false, 36, 24, 22, 22, 1), new SymbolInfo(false, 44, 28, 24, 24, 1), new SymbolInfo(true, 49, 28, 22, 14, 2), new SymbolInfo(false, 62, 36, 14, 14, 4), new SymbolInfo(false, 86, 42, 16, 16, 4), new SymbolInfo(false, 114, 48, 18, 18, 4), new SymbolInfo(false, 144, 56, 20, 20, 4), new SymbolInfo(false, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 68, 22, 22, 4), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEOCODEC_PIXEL_ALIGN, 112, 14, 14, 16, 140, 56), new SymbolInfo(false, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PTS_SYNCED_SEI_NOTIFICATION, 144, 16, 16, 16, 92, 36), new SymbolInfo(false, MediaPlayer.MEDIA_PLAYER_OPTION_CMAF_HTTP_RES_FINISH_TIME, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new SymbolInfo(false, 696, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_HTTP_REQ_FINSIH_TIME, 22, 22, 16, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE, 68), new SymbolInfo(false, MediaPlayer.MEDIA_PLAYER_OPTION_RTC_EARLY_INIT_RENDER, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_WAIT_START_TIME, 24, 24, 16, 136, 56), new SymbolInfo(false, 1050, 408, 18, 18, 36, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62), new DataMatrixSymbolInfo144()};
        PROD_SYMBOLS = symbolInfoArr;
        symbols = symbolInfoArr;
    }

    public SymbolInfo(boolean z3, int i4, int i5, int i6, int i7, int i8) {
        this(z3, i4, i5, i6, i7, i8, i4, i5);
    }

    private int getHorizontalDataRegions() {
        int i4 = this.dataRegions;
        int i5 = 1;
        if (i4 != 1) {
            i5 = 2;
            if (i4 != 2 && i4 != 4) {
                if (i4 != 16) {
                    if (i4 == 36) {
                        return 6;
                    }
                    throw new IllegalStateException("Cannot handle this number of data regions");
                }
                return 4;
            }
        }
        return i5;
    }

    private int getVerticalDataRegions() {
        int i4 = this.dataRegions;
        if (i4 == 1 || i4 == 2) {
            return 1;
        }
        if (i4 != 4) {
            if (i4 != 16) {
                if (i4 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
            return 4;
        }
        return 2;
    }

    public static SymbolInfo lookup(int i4) {
        return lookup(i4, SymbolShapeHint.FORCE_NONE, true);
    }

    public static void overrideSymbolSet(SymbolInfo[] symbolInfoArr) {
        symbols = symbolInfoArr;
    }

    public int getCodewordCount() {
        return this.dataCapacity + this.errorCodewords;
    }

    public final int getDataCapacity() {
        return this.dataCapacity;
    }

    public int getDataLengthForInterleavedBlock(int i4) {
        return this.rsBlockData;
    }

    public final int getErrorCodewords() {
        return this.errorCodewords;
    }

    public final int getErrorLengthForInterleavedBlock(int i4) {
        return this.rsBlockError;
    }

    public int getInterleavedBlockCount() {
        return this.dataCapacity / this.rsBlockData;
    }

    public final int getSymbolDataHeight() {
        return getVerticalDataRegions() * this.matrixHeight;
    }

    public final int getSymbolDataWidth() {
        return getHorizontalDataRegions() * this.matrixWidth;
    }

    public final int getSymbolHeight() {
        return getSymbolDataHeight() + (getVerticalDataRegions() << 1);
    }

    public final int getSymbolWidth() {
        return getSymbolDataWidth() + (getHorizontalDataRegions() << 1);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.rectangular ? "Rectangular Symbol:" : "Square Symbol:");
        sb.append(" data region ");
        sb.append(this.matrixWidth);
        sb.append('x');
        sb.append(this.matrixHeight);
        sb.append(", symbol size ");
        sb.append(getSymbolWidth());
        sb.append('x');
        sb.append(getSymbolHeight());
        sb.append(", symbol data size ");
        sb.append(getSymbolDataWidth());
        sb.append('x');
        sb.append(getSymbolDataHeight());
        sb.append(", codewords ");
        sb.append(this.dataCapacity);
        sb.append('+');
        sb.append(this.errorCodewords);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public SymbolInfo(boolean z3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        this.rectangular = z3;
        this.dataCapacity = i4;
        this.errorCodewords = i5;
        this.matrixWidth = i6;
        this.matrixHeight = i7;
        this.dataRegions = i8;
        this.rsBlockData = i9;
        this.rsBlockError = i10;
    }

    public static SymbolInfo lookup(int i4, SymbolShapeHint symbolShapeHint) {
        return lookup(i4, symbolShapeHint, true);
    }

    public static SymbolInfo lookup(int i4, boolean z3, boolean z4) {
        return lookup(i4, z3 ? SymbolShapeHint.FORCE_NONE : SymbolShapeHint.FORCE_SQUARE, z4);
    }

    private static SymbolInfo lookup(int i4, SymbolShapeHint symbolShapeHint, boolean z3) {
        return lookup(i4, symbolShapeHint, null, null, z3);
    }

    public static SymbolInfo lookup(int i4, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2, boolean z3) {
        SymbolInfo[] symbolInfoArr;
        for (SymbolInfo symbolInfo : symbols) {
            if (!(symbolShapeHint == SymbolShapeHint.FORCE_SQUARE && symbolInfo.rectangular) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.rectangular) && ((dimension == null || (symbolInfo.getSymbolWidth() >= dimension.getWidth() && symbolInfo.getSymbolHeight() >= dimension.getHeight())) && ((dimension2 == null || (symbolInfo.getSymbolWidth() <= dimension2.getWidth() && symbolInfo.getSymbolHeight() <= dimension2.getHeight())) && i4 <= symbolInfo.dataCapacity)))) {
                return symbolInfo;
            }
        }
        if (z3) {
            throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: " + i4);
        }
        return null;
    }
}
