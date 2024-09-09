package com.bytedance.sdk.openadsdk.core.p.w;

import com.bytedance.sdk.openadsdk.core.p.w.w;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ux implements c {

    /* renamed from: c  reason: collision with root package name */
    private final ConcurrentHashMap<Integer, c> f34261c = new ConcurrentHashMap<>();

    public void c(c cVar) {
        if (cVar != null) {
            this.f34261c.put(Integer.valueOf(cVar.hashCode()), cVar);
        }
    }

    public void w() {
        if (this.f34261c.isEmpty()) {
            return;
        }
        this.f34261c.clear();
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
    public void xv(long j4, long j5, String str, String str2) {
        Iterator<Map.Entry<Integer, c>> it = this.f34261c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new w.c().c(next.getValue()).c("onDownloadFailed").c(j4).w(j5).w(str).xv(str2).c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
    public void c() {
        Iterator<Map.Entry<Integer, c>> it = this.f34261c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new w.c().c(next.getValue()).c("onIdle").c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
    public void w(long j4, long j5, String str, String str2) {
        Iterator<Map.Entry<Integer, c>> it = this.f34261c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new w.c().c(next.getValue()).c("onDownloadPaused").c(j4).w(j5).w(str).xv(str2).c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
    public void c(long j4, long j5, String str, String str2) {
        Iterator<Map.Entry<Integer, c>> it = this.f34261c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new w.c().c(next.getValue()).c("onDownloadActive").c(j4).w(j5).w(str).xv(str2).c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
    public void c(String str, String str2) {
        Iterator<Map.Entry<Integer, c>> it = this.f34261c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                next.getValue().c(str, str2);
                new w.c().c(next.getValue()).c("onInstalled").w(str).xv(str2).c();
            }
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.p.w.c
    public void c(long j4, String str, String str2) {
        Iterator<Map.Entry<Integer, c>> it = this.f34261c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, c> next = it.next();
            if (next == null) {
                it.remove();
            } else {
                new w.c().c(next.getValue()).c("onDownloadFinished").c(j4).w(str).xv(str2).c();
            }
        }
    }
}
