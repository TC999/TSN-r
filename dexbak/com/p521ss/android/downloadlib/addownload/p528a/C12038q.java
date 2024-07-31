package com.p521ss.android.downloadlib.addownload.p528a;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.p521ss.android.downloadad.api.p526ok.C11998a;
import com.p521ss.android.downloadlib.C12265s;
import com.p521ss.android.downloadlib.addownload.C12128r;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.a.q */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12038q {

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.ss.android.downloadlib.addownload.a.q$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12041ok {

        /* renamed from: ok */
        private static C12038q f34094ok = new C12038q();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bl */
    public SharedPreferences m19279bl() {
        return C12128r.getContext().getSharedPreferences("sp_ad_download_event", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: a */
    public ConcurrentHashMap<Long, C11998a> m19280a() {
        ConcurrentHashMap<Long, C11998a> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = m19279bl().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long longValue = Long.valueOf(entry.getKey()).longValue();
                    C11998a m19523a = C11998a.m19523a(new JSONObject(String.valueOf(entry.getValue())));
                    if (longValue > 0 && m19523a != null) {
                        concurrentHashMap.put(Long.valueOf(longValue), m19523a);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }

    private C12038q() {
    }

    /* renamed from: ok */
    public static C12038q m19278ok() {
        return C12041ok.f34094ok;
    }

    /* renamed from: ok */
    public void m19277ok(C11998a c11998a) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(c11998a);
        m19275ok((Collection<C11998a>) arrayList);
    }

    /* renamed from: ok */
    public synchronized void m19275ok(final Collection<C11998a> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                C12265s.m18554ok().m18551ok(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.q.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor edit = C12038q.this.m19279bl().edit();
                        for (C11998a c11998a : collection) {
                            if (c11998a != null && c11998a.mo19309a() != 0) {
                                edit.putString(String.valueOf(c11998a.mo19309a()), c11998a.m19490ju().toString());
                            }
                        }
                        edit.apply();
                    }
                }, true);
            }
        }
    }

    /* renamed from: ok */
    public void m19274ok(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        C12265s.m18554ok().m18551ok(new Runnable() { // from class: com.ss.android.downloadlib.addownload.a.q.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = C12038q.this.m19279bl().edit();
                for (String str : list) {
                    edit.remove(str);
                }
                edit.apply();
            }
        }, true);
    }
}
