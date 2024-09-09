package com.bytedance.msdk.xv.xv;

import android.os.Handler;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.sr.f;
import com.bytedance.msdk.f.wv;
import com.bytedance.msdk.xv.ev;
import com.bytedance.pangle.sdk.component.log.impl.AdLogManager;
import com.bytedance.pangle.sdk.component.log.impl.core.IUploadResult;
import com.bytedance.pangle.sdk.component.log.impl.core.IUploader;
import com.bytedance.pangle.sdk.component.log.impl.core.monitor.EventMonitor;
import com.bytedance.pangle.sdk.component.log.impl.core.thread.AdEventResCompose;
import com.bytedance.pangle.sdk.component.log.impl.core.thread.AdEventUploadResult;
import com.bytedance.pangle.sdk.component.log.impl.event.AdLogEventFace;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv implements IUploader {

    /* renamed from: w  reason: collision with root package name */
    private static final Handler f28595w = new Handler(f.w());
    private static final Runnable xv = new Runnable() { // from class: com.bytedance.msdk.xv.xv.xv.2
        @Override // java.lang.Runnable
        public void run() {
            com.bytedance.msdk.adapter.sr.xv.c("TMe", "--==--- upload event routine");
            AdLogManager.flushMemoryAndDB();
            xv.w();
        }
    };

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.msdk.xv.w.c<com.bytedance.msdk.xv.c> f28596c;

    /* JADX INFO: Access modifiers changed from: private */
    public static void w() {
        Handler handler = f28595w;
        handler.removeCallbacksAndMessages(null);
        handler.postDelayed(xv, com.bytedance.msdk.core.c.w().q());
    }

    @Override // com.bytedance.pangle.sdk.component.log.impl.core.IUploader
    public void upload(final List<AdLogEventFace> list, @Nullable final IUploadResult iUploadResult) {
        if (list != null && list.size() > 0) {
            long currentTimeMillis = System.currentTimeMillis();
            final ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = null;
            int i4 = 0;
            for (AdLogEventFace adLogEventFace : list) {
                JSONObject event = adLogEventFace.getEvent();
                byte priority = adLogEventFace.getPriority();
                byte adType = adLogEventFace.getAdType();
                if (priority == 2 && adType == 3) {
                    w(event, list.size(), currentTimeMillis, i4, jSONObject);
                    arrayList.add(new ev(adLogEventFace.getLocalId(), event));
                } else if (priority == 2 && adType == 0) {
                    c(event, list.size(), currentTimeMillis, i4, jSONObject);
                    arrayList.add(new com.bytedance.msdk.xv.c(adLogEventFace.getLocalId(), event));
                } else {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.putOpt("not_v1v3", event);
                        jSONObject2.putOpt("batchId", Long.valueOf(currentTimeMillis));
                        jSONObject2.putOpt("batchIndex", Integer.valueOf(i4));
                        wv.c(jSONObject2);
                    } catch (Throwable unused) {
                    }
                }
                i4++;
                jSONObject = event;
            }
            if (arrayList.size() > 0) {
                f.r().execute(new Runnable() { // from class: com.bytedance.msdk.xv.xv.xv.1
                    @Override // java.lang.Runnable
                    public void run() {
                        com.bytedance.msdk.xv.f c4 = xv.this.c(arrayList);
                        if (iUploadResult == null || c4 == null) {
                            return;
                        }
                        AdEventUploadResult adEventUploadResult = new AdEventUploadResult(c4.f28484c, c4.f28485w, c4.xv, c4.sr, "");
                        ArrayList arrayList2 = new ArrayList();
                        arrayList2.add(new AdEventResCompose(adEventUploadResult, list));
                        iUploadResult.onResult(arrayList2);
                        if (c4.f28484c) {
                            xv.w();
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

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.msdk.xv.f c(List<com.bytedance.msdk.xv.c> list) {
        try {
            if (this.f28596c == null) {
                this.f28596c = com.bytedance.msdk.core.c.c();
            }
        } catch (Exception unused) {
        }
        com.bytedance.msdk.xv.w.c<com.bytedance.msdk.xv.c> cVar = this.f28596c;
        if (cVar == null) {
            return null;
        }
        return cVar.c(list);
    }
}
