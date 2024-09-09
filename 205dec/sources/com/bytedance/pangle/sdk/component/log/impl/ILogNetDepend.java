package com.bytedance.pangle.sdk.component.log.impl;

import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import com.bytedance.pangle.sdk.component.log.impl.net.IPostExecutor;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface ILogNetDepend {
    JSONObject buildAdEventV3Body(List<AdLogEventFace> list, boolean z3, boolean z4);

    JSONObject buildAndEncryptV1Body(List<AdLogEventFace> list, boolean z3);

    JSONObject encryptBodyWithCBC(JSONObject jSONObject);

    byte[] encryptV3Body(JSONObject jSONObject);

    int getAdEventUploadBatch();

    long getAdEventUploadInterval();

    String getAppLogUrl();

    String getETAppLogUrl();

    JSONObject getExtraJson();

    String getStatsLogUrl();

    boolean isPlugin();

    boolean isReportEt();

    void processResult(int i4, List<AdLogEventFace> list);

    IPostExecutor providerPostExecutor();
}
