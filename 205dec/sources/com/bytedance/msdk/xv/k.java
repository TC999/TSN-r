package com.bytedance.msdk.xv;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.msdk.f.wv;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k implements com.bytedance.sdk.component.r.c.k {

    /* renamed from: w  reason: collision with root package name */
    private static final Handler f28488w = new Handler(com.bytedance.msdk.adapter.sr.f.w());
    private static final Runnable xv = new Runnable() { // from class: com.bytedance.msdk.xv.k.2
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==--- upload event routine");
            com.bytedance.sdk.component.r.w.c.f("csj_mediation");
            k.w();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.msdk.xv.w.c<c> f28489c;

    /* JADX INFO: Access modifiers changed from: private */
    public static void w() {
        Handler handler = f28488w;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(xv, com.bytedance.msdk.core.c.w().q());
    }

    private void w(JSONObject jSONObject, int i4, long j4, int i5, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(EventMonitor.V3_PARAMS);
                if (optJSONObject != null) {
                    c(optJSONObject, i4, j4, i5, jSONObject2 != null ? jSONObject2.optJSONObject(EventMonitor.V3_PARAMS) : null);
                }
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.bytedance.sdk.component.r.c.k
    public void c(final List<com.bytedance.sdk.component.r.c.w> list, @Nullable final com.bytedance.sdk.component.r.c.p pVar) {
        if (list != null && list.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            final ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = null;
            int i4 = 0;
            for (com.bytedance.sdk.component.r.c.w wVar : list) {
                JSONObject r3 = wVar.r();
                byte ux = wVar.ux();
                byte sr = wVar.sr();
                if (ux == 2 && sr == 3) {
                    w(r3, list.size(), currentTimeMillis, i4, jSONObject);
                    arrayList.add(new ev(wVar.xv(), r3));
                } else if (ux == 2 && sr == 0) {
                    c(r3, list.size(), currentTimeMillis, i4, jSONObject);
                    arrayList.add(new c(wVar.xv(), r3));
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("not_v1v3", r3);
                        jSONObject2.putOpt("batchId", Long.valueOf(currentTimeMillis));
                        jSONObject2.putOpt("batchIndex", Integer.valueOf(i4));
                        wv.c(jSONObject2);
                    } catch (Throwable unused) {
                    }
                }
                i4++;
                jSONObject = r3;
            }
            if (arrayList.size() > 0) {
                com.bytedance.msdk.adapter.sr.f.r().execute(new Runnable() { // from class: com.bytedance.msdk.xv.k.1
                    @Override // java.lang.Runnable
                    public void run() {
                        f c4 = k.this.c(arrayList);
                        if (pVar == null || c4 == null) {
                            return;
                        }
                        com.bytedance.sdk.component.r.w.w.xv.w wVar2 = new com.bytedance.sdk.component.r.w.w.xv.w(c4.f28484c, c4.f28485w, c4.xv, c4.sr, "");
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new com.bytedance.sdk.component.r.w.w.xv.c(wVar2, list));
                        pVar.c(arrayList2);
                        if (c4.f28484c) {
                            k.w();
                        }
                    }
                });
            }
        }
    }

    private void c(JSONObject jSONObject, int i4, long j4, int i5, JSONObject jSONObject2) {
        if (jSONObject != null) {
            try {
                String optString = jSONObject.optString(EventMonitor.EVENT_EXTRA);
                if (TextUtils.isEmpty(optString)) {
                    return;
                }
                JSONObject jSONObject3 = new JSONObject(optString);
                jSONObject3.putOpt("size", Integer.valueOf(i4));
                jSONObject3.putOpt("batchId", Long.valueOf(j4));
                jSONObject3.putOpt("batchIndex", Integer.valueOf(i5));
                jSONObject3.putOpt("preEventId", jSONObject2 != null ? jSONObject2.optString("event_id") : "-1");
                jSONObject.put(EventMonitor.EVENT_EXTRA, jSONObject3.toString());
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public f c(List<c> list) {
        try {
            if (this.f28489c == null) {
                this.f28489c = com.bytedance.msdk.core.c.c();
            }
        } catch (Exception unused) {
        }
        com.bytedance.msdk.xv.w.c<c> cVar = this.f28489c;
        if (cVar == null) {
            return null;
        }
        return cVar.c(list);
    }
}
