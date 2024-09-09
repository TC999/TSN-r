package com.ss.android.socialbase.downloader.network.c;

import com.ss.android.socialbase.downloader.gd.f;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    protected int f50015c;

    /* renamed from: w  reason: collision with root package name */
    private final Map<String, xv> f50016w;
    private final Map<String, sr> xv;

    /* renamed from: com.ss.android.socialbase.downloader.network.c.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static final class C1018c {

        /* renamed from: c  reason: collision with root package name */
        private static final c f50017c = new c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, xv xvVar) {
        synchronized (this.f50016w) {
            this.f50016w.put(str, xvVar);
        }
    }

    public sr w(String str, List<com.ss.android.socialbase.downloader.model.xv> list) {
        sr remove;
        synchronized (this.xv) {
            remove = this.xv.remove(str);
        }
        if (remove != null) {
            if (f.c(remove.f(), list)) {
                try {
                    remove.ux();
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                if (remove.ev() && remove.r()) {
                    return remove;
                }
            }
            try {
                remove.sr();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private c() {
        this.f50016w = new HashMap();
        this.xv = new LinkedHashMap(3);
        this.f50015c = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(int i4) {
        this.f50015c = i4;
    }

    public xv c(String str, List<com.ss.android.socialbase.downloader.model.xv> list) {
        xv remove;
        synchronized (this.f50016w) {
            remove = this.f50016w.remove(str);
        }
        if (remove != null) {
            if (f.c(remove.ev(), list)) {
                try {
                    remove.sr();
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                if (remove.f() && remove.ux()) {
                    return remove;
                }
            }
            try {
                remove.xv();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public boolean c(String str) {
        xv xvVar = this.f50016w.get(str);
        if (xvVar != null) {
            if (xvVar.r()) {
                return true;
            }
            return xvVar.f() && xvVar.ux();
        }
        return false;
    }

    public static c c() {
        return C1018c.f50017c;
    }
}
