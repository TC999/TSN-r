package com.bytedance.msdk.xv.xv;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.msdk.f.wv;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends c {
    private static final SimpleDateFormat sr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    public w(String str, JSONObject jSONObject) {
        super(str, jSONObject);
    }

    public static w c(Context context, com.bytedance.msdk.xv.sr srVar, JSONObject jSONObject) {
        return new w(UUID.randomUUID().toString(), w(context, srVar, jSONObject));
    }

    private static JSONObject w(Context context, com.bytedance.msdk.xv.sr srVar, JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.putOpt("event", srVar.f28497c);
            jSONObject2.putOpt(EventMonitor.V3_PARAMS, jSONObject);
            jSONObject2.putOpt("nt", Integer.valueOf(com.bytedance.msdk.xv.ux.c(context)));
            jSONObject2.putOpt("datetime", sr.format(new Date()));
        } catch (Exception e4) {
            try {
                JSONObject optJSONObject = jSONObject2.optJSONObject(EventMonitor.V3_PARAMS);
                if (optJSONObject != null) {
                    String optString = optJSONObject.optString(EventMonitor.EVENT_EXTRA);
                    if (!TextUtils.isEmpty(optString)) {
                        JSONObject jSONObject3 = new JSONObject(optString);
                        jSONObject3.putOpt("v3_err_msg", e4.toString());
                        optJSONObject.putOpt(EventMonitor.EVENT_EXTRA, jSONObject3.toString());
                    }
                }
                if (srVar != null) {
                    JSONObject jSONObject4 = new JSONObject();
                    jSONObject4.putOpt("v3_eventId", srVar.f28503q.get("event_id"));
                    jSONObject4.putOpt("v3_err_msg", e4.toString());
                    wv.c(jSONObject4);
                }
            } catch (Throwable unused) {
            }
        }
        return jSONObject2;
    }

    @Override // com.bytedance.msdk.xv.xv.c
    public String toString() {
        return "AdEventV3{localId='" + this.f28591c + "', event=" + this.f28592w + '}';
    }
}
