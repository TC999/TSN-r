package com.ss.android.downloadlib.addownload.w;

import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class gd {

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class c {

        /* renamed from: c  reason: collision with root package name */
        private static gd f48715c = new gd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SharedPreferences xv() {
        return k.getContext().getSharedPreferences("sp_ad_download_event", 0);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public ConcurrentHashMap<Long, com.ss.android.downloadad.api.c.w> w() {
        ConcurrentHashMap<Long, com.ss.android.downloadad.api.c.w> concurrentHashMap = new ConcurrentHashMap<>();
        Map<String, ?> all = xv().getAll();
        if (all == null) {
            return concurrentHashMap;
        }
        for (Map.Entry<String, ?> entry : all.entrySet()) {
            if (entry.getValue() != null) {
                try {
                    long longValue = Long.valueOf(entry.getKey()).longValue();
                    com.ss.android.downloadad.api.c.w w3 = com.ss.android.downloadad.api.c.w.w(new JSONObject(String.valueOf(entry.getValue())));
                    if (longValue > 0 && w3 != null) {
                        concurrentHashMap.put(Long.valueOf(longValue), w3);
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
        return concurrentHashMap;
    }

    private gd() {
    }

    public static gd c() {
        return c.f48715c;
    }

    public void c(com.ss.android.downloadad.api.c.w wVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(wVar);
        c((Collection<com.ss.android.downloadad.api.c.w>) arrayList);
    }

    public synchronized void c(final Collection<com.ss.android.downloadad.api.c.w> collection) {
        if (collection != null) {
            if (!collection.isEmpty()) {
                com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.addownload.w.gd.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SharedPreferences.Editor edit = gd.this.xv().edit();
                        for (com.ss.android.downloadad.api.c.w wVar : collection) {
                            if (wVar != null && wVar.w() != 0) {
                                edit.putString(String.valueOf(wVar.w()), wVar.ge().toString());
                            }
                        }
                        edit.apply();
                    }
                }, true);
            }
        }
    }

    public void c(final List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        com.ss.android.downloadlib.sr.c().c(new Runnable() { // from class: com.ss.android.downloadlib.addownload.w.gd.2
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = gd.this.xv().edit();
                for (String str : list) {
                    edit.remove(str);
                }
                edit.apply();
            }
        }, true);
    }
}
