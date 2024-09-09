package io.netty.handler.codec.spdy;

import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface SpdySettingsFrame extends SpdyFrame {
    public static final int SETTINGS_CLIENT_CERTIFICATE_VECTOR_SIZE = 8;
    public static final int SETTINGS_CURRENT_CWND = 5;
    public static final int SETTINGS_DOWNLOAD_BANDWIDTH = 2;
    public static final int SETTINGS_DOWNLOAD_RETRANS_RATE = 6;
    public static final int SETTINGS_INITIAL_WINDOW_SIZE = 7;
    public static final int SETTINGS_MAX_CONCURRENT_STREAMS = 4;
    public static final int SETTINGS_MINOR_VERSION = 0;
    public static final int SETTINGS_ROUND_TRIP_TIME = 3;
    public static final int SETTINGS_UPLOAD_BANDWIDTH = 1;

    boolean clearPreviouslyPersistedSettings();

    int getValue(int i4);

    Set<Integer> ids();

    boolean isPersistValue(int i4);

    boolean isPersisted(int i4);

    boolean isSet(int i4);

    SpdySettingsFrame removeValue(int i4);

    SpdySettingsFrame setClearPreviouslyPersistedSettings(boolean z3);

    SpdySettingsFrame setPersistValue(int i4, boolean z3);

    SpdySettingsFrame setPersisted(int i4, boolean z3);

    SpdySettingsFrame setValue(int i4, int i5);

    SpdySettingsFrame setValue(int i4, int i5, boolean z3, boolean z4);
}
