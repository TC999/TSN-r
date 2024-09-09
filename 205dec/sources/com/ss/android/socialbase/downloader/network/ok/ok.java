package com.ss.android.socialbase.downloader.network.ok;

import com.ss.android.socialbase.downloader.q.kf;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ok {

    /* renamed from: a  reason: collision with root package name */
    private final Map<String, bl> f50047a;
    private final Map<String, s> bl;
    protected int ok;

    /* renamed from: com.ss.android.socialbase.downloader.network.ok.ok$ok  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static final class C1019ok {
        private static final ok ok = new ok();
    }

    public s a(String str, List<com.ss.android.socialbase.downloader.model.bl> list) {
        s remove;
        synchronized (this.bl) {
            remove = this.bl.remove(str);
        }
        if (remove != null) {
            if (kf.ok(remove.kf(), list)) {
                try {
                    remove.n();
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                if (remove.p() && remove.h()) {
                    return remove;
                }
            }
            try {
                remove.s();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(String str, bl blVar) {
        synchronized (this.f50047a) {
            this.f50047a.put(str, blVar);
        }
    }

    private ok() {
        this.f50047a = new HashMap();
        this.bl = new LinkedHashMap(3);
        this.ok = 3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(int i4) {
        this.ok = i4;
    }

    public bl ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list) {
        bl remove;
        synchronized (this.f50047a) {
            remove = this.f50047a.remove(str);
        }
        if (remove != null) {
            if (kf.ok(remove.p(), list)) {
                try {
                    remove.s();
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                if (remove.kf() && remove.n()) {
                    return remove;
                }
            }
            try {
                remove.bl();
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    public boolean ok(String str) {
        bl blVar = this.f50047a.get(str);
        if (blVar != null) {
            if (blVar.h()) {
                return true;
            }
            return blVar.kf() && blVar.n();
        }
        return false;
    }

    public static ok ok() {
        return C1019ok.ok;
    }
}
