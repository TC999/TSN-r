package com.qq.e.comm.plugin.b;

import android.text.TextUtils;
import com.qq.e.comm.compliance.DownloadConfirmListener;
import com.qq.e.comm.plugin.util.d1;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private ConcurrentHashMap<String, WeakReference<DownloadConfirmListener>> f42012a;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class b {

        /* renamed from: a  reason: collision with root package name */
        private static j f42013a = new j();
    }

    public static j b() {
        return b.f42013a;
    }

    public DownloadConfirmListener a(String str) {
        WeakReference<DownloadConfirmListener> weakReference;
        if (TextUtils.isEmpty(str) || (weakReference = this.f42012a.get(str)) == null) {
            return null;
        }
        return weakReference.get();
    }

    private j() {
        this.f42012a = new ConcurrentHashMap<>();
    }

    public void a(String str, DownloadConfirmListener downloadConfirmListener) {
        d1.a("ApkDownloadComplianceHelper setConfirmListener traceId:" + str, new Object[0]);
        a();
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f42012a.put(str, new WeakReference<>(downloadConfirmListener));
    }

    private void a() {
        Iterator<Map.Entry<String, WeakReference<DownloadConfirmListener>>> it = this.f42012a.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, WeakReference<DownloadConfirmListener>> next = it.next();
            WeakReference<DownloadConfirmListener> value = next.getValue();
            if (value == null || value.get() == null) {
                d1.a("ApkDownloadComplianceHelper DownloadConfirmListener clean traceId:" + next.getKey(), new Object[0]);
                it.remove();
            }
        }
    }
}
