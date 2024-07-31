package com.p521ss.android.socialbase.downloader.network.p553ok;

import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.network.ok.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12630ok {

    /* renamed from: a */
    private final Map<String, C12629bl> f35594a;

    /* renamed from: bl */
    private final Map<String, C12633s> f35595bl;

    /* renamed from: ok */
    protected int f35596ok;

    /* renamed from: com.ss.android.socialbase.downloader.network.ok.ok$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static final class C12632ok {

        /* renamed from: ok */
        private static final C12630ok f35597ok = new C12630ok();
    }

    /* renamed from: a */
    public C12633s m16925a(String str, List<C12601bl> list) {
        C12633s remove;
        synchronized (this.f35595bl) {
            remove = this.f35595bl.remove(str);
        }
        if (remove != null) {
            if (C12713kf.m16535ok(remove.m16915kf(), list)) {
                try {
                    remove.m16914n();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (remove.m16911p() && remove.m16916h()) {
                    return remove;
                }
            }
            try {
                remove.mo16908s();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m16921ok(String str, C12629bl c12629bl) {
        synchronized (this.f35594a) {
            this.f35594a.put(str, c12629bl);
        }
    }

    private C12630ok() {
        this.f35594a = new HashMap();
        this.f35595bl = new LinkedHashMap(3);
        this.f35596ok = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m16923ok(int i) {
        this.f35596ok = i;
    }

    /* renamed from: ok */
    public C12629bl m16920ok(String str, List<C12601bl> list) {
        C12629bl remove;
        synchronized (this.f35594a) {
            remove = this.f35594a.remove(str);
        }
        if (remove != null) {
            if (C12713kf.m16535ok(remove.m16928p(), list)) {
                try {
                    remove.m16926s();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (remove.m16933kf() && remove.m16932n()) {
                    return remove;
                }
            }
            try {
                remove.mo16917bl();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: ok */
    public boolean m16922ok(String str) {
        C12629bl c12629bl = this.f35594a.get(str);
        if (c12629bl != null) {
            if (c12629bl.m16934h()) {
                return true;
            }
            return c12629bl.m16933kf() && c12629bl.m16932n();
        }
        return false;
    }

    /* renamed from: ok */
    public static C12630ok m16924ok() {
        return C12632ok.f35597ok;
    }
}
