package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;

/* renamed from: com.baidu.mobads.sdk.internal.da */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
class RunnableC2683da implements Runnable {

    /* renamed from: a */
    final /* synthetic */ IOAdEvent f8924a;

    /* renamed from: b */
    final /* synthetic */ C2681cz f8925b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC2683da(C2681cz c2681cz, IOAdEvent iOAdEvent) {
        this.f8925b = c2681cz;
        this.f8924a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        CPUDramaListener cPUDramaListener;
        String str;
        CPUDramaListener cPUDramaListener2;
        CPUDramaListener cPUDramaListener3;
        IOAdEvent iOAdEvent = this.f8924a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f8924a.getType();
        cPUDramaListener = this.f8925b.f8923a.f8922s;
        if (cPUDramaListener == null) {
            return;
        }
        if ("onContentLoaded".equals(type)) {
            cPUDramaListener3 = this.f8925b.f8923a.f8922s;
            cPUDramaListener3.onContentLoaded();
        } else if ("onContentFailed".equals(type)) {
            HashMap hashMap = (HashMap) this.f8924a.getData();
            int i = 0;
            if (hashMap != null) {
                str = (String) hashMap.get("error_message");
                int i2 = hashMap.get("error_code");
                if (i2 == null) {
                    i2 = 0;
                }
                i = ((Integer) i2).intValue();
            } else {
                str = "";
            }
            cPUDramaListener2 = this.f8925b.f8923a.f8922s;
            cPUDramaListener2.onContentFailed(i, str);
        } else if (C2736x.f9295ar.equals(type)) {
            this.f8925b.f8923a.m50570l(this.f8924a);
        } else if (C2736x.f9296as.equals(type)) {
            this.f8925b.f8923a.m50569m(this.f8924a);
        }
    }
}
