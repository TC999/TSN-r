package com.baidu.mobads.sdk.internal;

import android.text.TextUtils;
import com.baidu.mobads.sdk.api.CPUDramaListener;
import com.baidu.mobads.sdk.api.IOAdEvent;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
class dd implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ IOAdEvent f12744a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ dc f12745b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public dd(dc dcVar, IOAdEvent iOAdEvent) {
        this.f12745b = dcVar;
        this.f12744a = iOAdEvent;
    }

    @Override // java.lang.Runnable
    public void run() {
        CPUDramaListener cPUDramaListener;
        String str;
        CPUDramaListener cPUDramaListener2;
        CPUDramaListener cPUDramaListener3;
        IOAdEvent iOAdEvent = this.f12744a;
        if (iOAdEvent == null || TextUtils.isEmpty(iOAdEvent.getType())) {
            return;
        }
        String type = this.f12744a.getType();
        cPUDramaListener = this.f12745b.f12743a.f12742s;
        if (cPUDramaListener == null) {
            return;
        }
        if ("onContentLoaded".equals(type)) {
            cPUDramaListener3 = this.f12745b.f12743a.f12742s;
            cPUDramaListener3.onContentLoaded();
        } else if ("onContentFailed".equals(type)) {
            HashMap hashMap = (HashMap) this.f12744a.getData();
            int i4 = 0;
            if (hashMap != null) {
                str = (String) hashMap.get("error_message");
                int i5 = hashMap.get("error_code");
                if (i5 == null) {
                    i5 = 0;
                }
                i4 = ((Integer) i5).intValue();
            } else {
                str = "";
            }
            cPUDramaListener2 = this.f12745b.f12743a.f12742s;
            cPUDramaListener2.onContentFailed(i4, str);
        } else if (x.as.equals(type)) {
            this.f12745b.f12743a.l(this.f12744a);
        } else if (x.at.equals(type)) {
            this.f12745b.f12743a.m(this.f12744a);
        }
    }
}
