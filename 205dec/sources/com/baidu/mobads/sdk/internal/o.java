package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CpuChannelListManager;
import com.baidu.mobads.sdk.api.CpuChannelResponse;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class o implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f12887a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ n f12888b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public o(n nVar, IOAdEvent iOAdEvent) {
        this.f12888b = nVar;
        this.f12887a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener2;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener3;
        CpuChannelListManager.CpuChannelListListener cpuChannelListListener4;
        IOAdEvent iOAdEvent = this.f12887a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f12887a.getType();
        if (x.aq.equals(type)) {
            List<CpuChannelResponse> a4 = l.a((JSONArray) this.f12887a.getData().get("cpuChannelList"));
            cpuChannelListListener3 = this.f12888b.f12886a.f12883q;
            if (cpuChannelListListener3 != null) {
                cpuChannelListListener4 = this.f12888b.f12886a.f12883q;
                cpuChannelListListener4.onChannelListLoaded(a4);
            }
        } else if (x.ar.equals(type)) {
            Map<String, Object> data = this.f12887a.getData();
            int i4 = 0;
            if (data != null) {
                str = (String) data.get("error_message");
                int i5 = data.get("error_code");
                if (i5 == null) {
                    i5 = 0;
                }
                i4 = ((Integer) i5).intValue();
            } else {
                str = "";
            }
            cpuChannelListListener = this.f12888b.f12886a.f12883q;
            if (cpuChannelListListener != null) {
                cpuChannelListListener2 = this.f12888b.f12886a.f12883q;
                cpuChannelListListener2.onChannelListError(str, i4);
            }
        }
    }
}
