package com.bykv.vk.component.ttvideo.utils;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class Error {
    public static final int AUDIO_HARDWARE_DECODER_WRITE_ERROR = -499978;
    public static final int BUFFERING_TIME_OUT_ERROR = -499982;
    public static final String DataLoaderPreload = "kTTVideoErrorDomainDataLoaderPreload";
    public static final int ERROR_TYPE_CDN = 1003;
    public static final int ERROR_TYPE_PLAYER = 1002;
    public static final int OPEN_TIME_OUT_ERROR = -1414092869;
    public static final int PlayerStateIllegal = -9992;
    public static final int PreloadInvalidParameter = -100001;
    public static final int PreloadMDLStateError = -100002;
    public static final int PreloadSameKeyError = -100003;
    public static final int PreloadTrackEmptyError = -100004;
    public static final int TCP_READ_NETWORK_TIMEOUT = -499793;
    public static final int VIDEO_HARDWARE_DECODER_WRITE_ERROR = -499977;
    public static final String VideoOSPlayer = "kTTVideoErrorDomainVideoOSPlayer";
    public static final String VideoOwnPlayer = "kTTVideoErrorDomainVideoOwnPlayer";

    /* renamed from: a  reason: collision with root package name */
    public int f24911a;

    /* renamed from: b  reason: collision with root package name */
    public int f24912b;

    /* renamed from: c  reason: collision with root package name */
    public String f24913c;

    /* renamed from: d  reason: collision with root package name */
    public String f24914d;

    /* renamed from: e  reason: collision with root package name */
    public Map f24915e;

    public Error(String str, int i4) {
        this(str, i4, 0);
    }

    public Error(String str, int i4, int i5) {
        this(str, i4, i5, null);
    }

    public Error(String str, int i4, int i5, String str2) {
        this.f24913c = str;
        this.f24911a = i4;
        this.f24912b = i5;
        this.f24914d = str2;
        this.f24915e = new HashMap();
    }

    public Error(String str, int i4, String str2) {
        this(str, i4, 0, str2);
    }

    public int getCode() {
        return this.f24911a;
    }

    public String getDescription() {
        return this.f24914d;
    }

    public String getDomain() {
        return this.f24913c;
    }

    public int getInternalCode() {
        return this.f24912b;
    }

    public Map getParameters() {
        return this.f24915e;
    }

    public int getType() {
        return (this.f24913c.equals(VideoOwnPlayer) && needRestartPlayer()) ? 1002 : 1003;
    }

    public boolean needFallbackOS() {
        int i4 = this.f24911a;
        return i4 == -499978 || i4 == -499977;
    }

    public boolean needRestartPlayer() {
        int i4 = this.f24911a;
        return i4 == -499999 || i4 == -499997 || i4 == -499996 || i4 == -499992 || i4 == -499991 || i4 == -499990 || i4 == -499989 || i4 == -2139062143;
    }

    public boolean notNeedRetry() {
        int i4 = this.f24911a;
        return i4 == -499982 || i4 == -499793 || i4 == -1414092869;
    }

    public String toString() {
        Object[] objArr = new Object[4];
        objArr[0] = this.f24913c;
        objArr[1] = Integer.valueOf(this.f24911a);
        objArr[2] = Integer.valueOf(this.f24912b);
        String str = this.f24914d;
        if (str == null) {
            str = "";
        }
        objArr[3] = str;
        return String.format("domain:%s, code:%d, internalCode:%d, description:%s", objArr);
    }
}
