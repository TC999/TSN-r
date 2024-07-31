package com.umeng.commonsdk.statistics.internal;

/* renamed from: com.umeng.commonsdk.statistics.internal.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface IRequestStat {
    void onRequestEnd();

    void onRequestFailed();

    void onRequestStart();

    void onRequestSucceed(boolean z);
}
