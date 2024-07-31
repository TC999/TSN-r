package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* renamed from: com.baidu.mobads.sdk.internal.o */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class RunnableC2718o implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IOAdEvent f9101a;

    /* renamed from: b */
    final /* synthetic */ C2717n f9102b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2718o(C2717n c2717n, IOAdEvent iOAdEvent) {
        this.f9102b = c2717n;
        this.f9101a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        IOAdEvent iOAdEvent = this.f9101a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f9101a.getType();
        if (C2736x.f9293ap.equals(type)) {
            List<CpuChannelResponse> m50359a = C2715l.m50359a((JSONArray) this.f9101a.getData().get("cpuChannelList"));
            cpuChannelListListener3 = this.f9102b.f9100a.f9097q;
            if (cpuChannelListListener3 != null) {
                cpuChannelListListener4 = this.f9102b.f9100a.f9097q;
                cpuChannelListListener4.onChannelListLoaded(m50359a);
            }
        } else if (C2736x.f9294aq.equals(type)) {
            Map<String, Object> data = this.f9101a.getData();
            int i = 0;
            if (data != null) {
                str = (String) data.get("error_message");
                int i2 = data.get("error_code");
                if (i2 == null) {
                    i2 = 0;
                }
                i = ((Integer) i2).intValue();
            } else {
                str = "";
            }
            cpuChannelListListener = this.f9102b.f9100a.f9097q;
            if (cpuChannelListListener != null) {
                cpuChannelListListener2 = this.f9102b.f9100a.f9097q;
                cpuChannelListListener2.onChannelListError(str, i);
            }
        }
    }
}
