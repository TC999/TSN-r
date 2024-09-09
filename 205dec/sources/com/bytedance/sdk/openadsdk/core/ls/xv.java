package com.bytedance.sdk.openadsdk.core.ls;

import android.content.Context;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bytedance.sdk.openadsdk.ats.ATSApi;
import com.bytedance.sdk.openadsdk.ats.ATSMethod;
import org.json.JSONObject;

@ATSApi("pitaya")
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface xv {
    @ATSMethod(1)
    void c(Context context, EventListener eventListener);

    @ATSMethod(6)
    void c(String str, EventListener eventListener);

    @ATSMethod(5)
    void c(String str, com.bytedance.sdk.component.r.c.w wVar);

    @ATSMethod(4)
    void c(String str, JSONObject jSONObject, EventListener eventListener);

    @ATSMethod(3)
    boolean sr();

    @ATSMethod(2)
    boolean xv();
}
