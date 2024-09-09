package com.google.zxing.datamatrix.decoder;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.google.zxing.FormatException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class Version {
    private static final Version[] VERSIONS = buildVersions();
    private final int dataRegionSizeColumns;
    private final int dataRegionSizeRows;
    private final ECBlocks ecBlocks;
    private final int symbolSizeColumns;
    private final int symbolSizeRows;
    private final int totalCodewords;
    private final int versionNumber;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class ECB {
        private final int count;
        private final int dataCodewords;

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getCount() {
            return this.count;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getDataCodewords() {
            return this.dataCodewords;
        }

        private ECB(int i4, int i5) {
            this.count = i4;
            this.dataCodewords = i5;
        }
    }

    private Version(int i4, int i5, int i6, int i7, int i8, ECBlocks eCBlocks) {
        ECB[] eCBlocks2;
        this.versionNumber = i4;
        this.symbolSizeRows = i5;
        this.symbolSizeColumns = i6;
        this.dataRegionSizeRows = i7;
        this.dataRegionSizeColumns = i8;
        this.ecBlocks = eCBlocks;
        int eCCodewords = eCBlocks.getECCodewords();
        int i9 = 0;
        for (ECB ecb : eCBlocks.getECBlocks()) {
            i9 += ecb.getCount() * (ecb.getDataCodewords() + eCCodewords);
        }
        this.totalCodewords = i9;
    }

    private static Version[] buildVersions() {
        return new Version[]{new Version(1, 10, 10, 8, 8, new ECBlocks(5, new ECB(1, 3))), new Version(2, 12, 12, 10, 10, new ECBlocks(7, new ECB(1, 5))), new Version(3, 14, 14, 12, 12, new ECBlocks(10, new ECB(1, 8))), new Version(4, 16, 16, 14, 14, new ECBlocks(12, new ECB(1, 12))), new Version(5, 18, 18, 16, 16, new ECBlocks(14, new ECB(1, 18))), new Version(6, 20, 20, 18, 18, new ECBlocks(18, new ECB(1, 22))), new Version(7, 22, 22, 20, 20, new ECBlocks(20, new ECB(1, 30))), new Version(8, 24, 24, 22, 22, new ECBlocks(24, new ECB(1, 36))), new Version(9, 26, 26, 24, 24, new ECBlocks(28, new ECB(1, 44))), new Version(10, 32, 32, 14, 14, new ECBlocks(36, new ECB(1, 62))), new Version(11, 36, 36, 16, 16, new ECBlocks(42, new ECB(1, 86))), new Version(12, 40, 40, 18, 18, new ECBlocks(48, new ECB(1, 114))), new Version(13, 44, 44, 20, 20, new ECBlocks(56, new ECB(1, 144))), new Version(14, 48, 48, 22, 22, new ECBlocks(68, new ECB(1, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE))), new Version(15, 52, 52, 24, 24, new ECBlocks(42, new ECB(2, 102))), new Version(16, 64, 64, 14, 14, new ECBlocks(56, new ECB(2, 140))), new Version(17, 72, 72, 16, 16, new ECBlocks(36, new ECB(4, 92))), new Version(18, 80, 80, 18, 18, new ECBlocks(48, new ECB(4, 114))), new Version(19, 88, 88, 20, 20, new ECBlocks(56, new ECB(4, 144))), new Version(20, 96, 96, 22, 22, new ECBlocks(68, new ECB(4, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_BITRATE))), new Version(21, 104, 104, 24, 24, new ECBlocks(56, new ECB(6, 136))), new Version(22, 120, 120, 18, 18, new ECBlocks(68, new ECB(6, MediaPlayer.MEDIA_PLAYER_OPTION_ABR_AVERAGE_PLAY_SPEED))), new Version(23, 132, 132, 20, 20, new ECBlocks(62, new ECB(8, 163))), new Version(24, 144, 144, 22, 22, new ECBlocks(62, new ECB(8, MediaPlayer.MEDIA_PLAYER_OPTION_GET_AUDIO_DEVICE_OPEN_TIME), new ECB(2, MediaPlayer.MEDIA_PLAYER_OPTION_GET_VIDEO_DEVICE_OPEN_TIME))), new Version(25, 8, 18, 6, 16, new ECBlocks(7, new ECB(1, 5))), new Version(26, 8, 32, 6, 14, new ECBlocks(11, new ECB(1, 10))), new Version(27, 12, 26, 10, 24, new ECBlocks(14, new ECB(1, 16))), new Version(28, 12, 36, 10, 16, new ECBlocks(18, new ECB(1, 22))), new Version(29, 16, 36, 14, 16, new ECBlocks(24, new ECB(1, 32))), new Version(30, 16, 48, 14, 22, new ECBlocks(28, new ECB(1, 49)))};
    }

    public static Version getVersionForDimensions(int i4, int i5) throws FormatException {
        Version[] versionArr;
        if ((i4 & 1) == 0 && (i5 & 1) == 0) {
            for (Version version : VERSIONS) {
                if (version.symbolSizeRows == i4 && version.symbolSizeColumns == i5) {
                    return version;
                }
            }
            throw FormatException.getFormatInstance();
        }
        throw FormatException.getFormatInstance();
    }

    public int getDataRegionSizeColumns() {
        return this.dataRegionSizeColumns;
    }

    public int getDataRegionSizeRows() {
        return this.dataRegionSizeRows;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public ECBlocks getECBlocks() {
        return this.ecBlocks;
    }

    public int getSymbolSizeColumns() {
        return this.symbolSizeColumns;
    }

    public int getSymbolSizeRows() {
        return this.symbolSizeRows;
    }

    public int getTotalCodewords() {
        return this.totalCodewords;
    }

    public int getVersionNumber() {
        return this.versionNumber;
    }

    public String toString() {
        return String.valueOf(this.versionNumber);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static final class ECBlocks {
        private final ECB[] ecBlocks;
        private final int ecCodewords;

        /* JADX INFO: Access modifiers changed from: package-private */
        public ECB[] getECBlocks() {
            return this.ecBlocks;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public int getECCodewords() {
            return this.ecCodewords;
        }

        private ECBlocks(int i4, ECB ecb) {
            this.ecCodewords = i4;
            this.ecBlocks = new ECB[]{ecb};
        }

        private ECBlocks(int i4, ECB ecb, ECB ecb2) {
            this.ecCodewords = i4;
            this.ecBlocks = new ECB[]{ecb, ecb2};
        }
    }
}
