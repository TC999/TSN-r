package com.bykv.vk.component.ttvideo.player;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class C {
    public static final int ENCODING_AC3 = 5;
    public static final int ENCODING_DOLBY_TRUEHD = 14;
    public static final int ENCODING_DTS = 7;
    public static final int ENCODING_DTS_HD = 8;
    public static final int ENCODING_E_AC3 = 6;
    public static final int ENCODING_INVALID = 0;
    public static final int ENCODING_PCM_16BIT = 2;
    public static final int ENCODING_PCM_24BIT = Integer.MIN_VALUE;
    public static final int ENCODING_PCM_32BIT = 1073741824;
    public static final int ENCODING_PCM_8BIT = 3;
    public static final int ENCODING_PCM_A_LAW = 536870912;
    public static final int ENCODING_PCM_FLOAT = 4;
    public static final int ENCODING_PCM_MU_LAW = 268435456;
    public static final int INDEX_UNSET = -1;
    public static final int LENGTH_UNSET = -1;
    public static final long MICROS_PER_SECOND = 1000000;
    public static final long NANOS_PER_SECOND = 1000000000;
    public static final int PERCENTAGE_UNSET = -1;
    public static final int POSITION_UNSET = -1;
    public static final long TIME_UNSET = -9223372036854775807L;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface Encoding {
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public @interface PcmEncoding {
    }

    private C() {
    }
}
