package com.umeng.commonsdk.statistics.internal;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: IRequestStat.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public interface b {
    void onRequestEnd();

    void onRequestFailed();

    void onRequestStart();

    void onRequestSucceed(boolean z3);
}
