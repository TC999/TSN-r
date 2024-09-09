package com.qq.e.comm.plugin.dysi;

import com.qq.e.comm.plugin.o0.h.f;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public interface IGDTBiz {
    public static final String KEY_GDTBIZ = "GDTBiz";

    boolean isTimerTickEnable();

    void onDialogDismiss(int i4);

    void onDialogShow(int i4);

    void onLandingPageClose();

    void onLandingPageOpen();

    void onPlayStateChange(f.t tVar, int i4);

    void onReward(int i4);

    void onTimerTick(long j4);
}
