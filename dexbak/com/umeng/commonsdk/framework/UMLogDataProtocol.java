package com.umeng.commonsdk.framework;

import org.json.JSONObject;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface UMLogDataProtocol {

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum UMBusinessType {
        U_APP,
        U_INTERNAL,
        U_ZeroEnv,
        U_Silent
    }

    void removeCacheData(Object obj);

    JSONObject setupReportData(long j);

    void workEvent(Object obj, int i);
}
