package com.bytedance.pangle.sdk.component.log.impl.net;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface TTPriority {
    public static final int UNKNOWN = -1;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface Priority {
        public static final int MAX_PRIORITY = 10;
        public static final int MIN_PRIORITY = 1;
        public static final int NORM_PRIORITY = 5;
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface ThreadType {
        public static final int AIDL = 3;
        public static final int API = 1;
        public static final int BACKGROUND = 2;
        public static final int LOG_UPLOAD = 4;
    }
}
