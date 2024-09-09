package com.qq.e.comm.plugin.edgeanalytics.h.a;

import android.content.Context;
import android.text.TextUtils;
import com.qq.e.comm.plugin.n0.e;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.d2;
import com.qq.e.comm.plugin.util.j0;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private final ExecutorService f43008a;

    /* renamed from: c  reason: collision with root package name */
    private HashSet<Integer> f43010c;

    /* renamed from: d  reason: collision with root package name */
    private HashSet<Integer> f43011d;

    /* renamed from: b  reason: collision with root package name */
    private final Context f43009b = com.qq.e.comm.plugin.d0.a.d().a();

    /* renamed from: e  reason: collision with root package name */
    private final Map<String, JSONObject> f43012e = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ e f43013c;

        a(e eVar) {
            this.f43013c = eVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.edgeanalytics.h.a.a.a(b.this.f43009b).b(this.f43013c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.edgeanalytics.h.a.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0813b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int[] f43015c;

        RunnableC0813b(int[] iArr) {
            this.f43015c = iArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.edgeanalytics.h.a.a.a(b.this.f43009b).a(this.f43015c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.edgeanalytics.h.c.a.a();
            com.qq.e.comm.plugin.edgeanalytics.h.a.a.a(com.qq.e.comm.plugin.d0.a.d().a()).a((int[]) null);
        }
    }

    public b(ExecutorService executorService) {
        this.f43008a = executorService;
        c();
        b();
        if (com.qq.e.comm.plugin.edgeanalytics.h.c.a.a("hasp", false)) {
            return;
        }
        com.qq.e.comm.plugin.edgeanalytics.h.c.a.b("hasp", true);
    }

    private void b() {
        if (System.currentTimeMillis() - com.qq.e.comm.plugin.edgeanalytics.h.c.a.a("lddtime", 0L) < 86400000) {
            return;
        }
        String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("emded", "");
        try {
            if (TextUtils.isEmpty(b4)) {
                return;
            }
            String[] split = b4.split(",");
            int[] iArr = new int[split.length];
            for (int i4 = 0; i4 < split.length; i4++) {
                iArr[i4] = Integer.parseInt(split[i4]);
            }
            com.qq.e.comm.plugin.edgeanalytics.h.c.a.b("lddtime", System.currentTimeMillis());
            a(iArr);
        } catch (Exception e4) {
            d1.a(e4.getMessage(), e4);
        }
    }

    private void c() {
        this.f43010c = a(com.qq.e.comm.plugin.d0.a.d().f().b("eeiwlst", ""));
        this.f43011d = a(com.qq.e.comm.plugin.d0.a.d().f().b("eeiblst", ""));
    }

    private HashSet<Integer> a(String str) {
        String[] split;
        HashSet<Integer> hashSet = new HashSet<>();
        if (TextUtils.isEmpty(str)) {
            return hashSet;
        }
        try {
            split = str.split(",");
        } catch (Exception e4) {
            d1.a(e4.getMessage(), e4);
        }
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                hashSet.add(Integer.valueOf(Integer.parseInt(str2)));
            }
            return hashSet;
        }
        return hashSet;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f43012e.remove(str);
        com.qq.e.comm.plugin.edgeanalytics.h.c.a.a(str);
    }

    public void a(e eVar, boolean z3) {
        if ((!z3 || this.f43011d.contains(Integer.valueOf(eVar.c()))) && !this.f43010c.contains(Integer.valueOf(eVar.c()))) {
            return;
        }
        this.f43008a.submit(new a(eVar));
    }

    private void a(int[] iArr) {
        this.f43008a.submit(new RunnableC0813b(iArr));
    }

    private String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return com.qq.e.comm.plugin.edgeanalytics.h.c.a.a(str, (String) null);
    }

    public void a(String str, JSONObject jSONObject) {
        this.f43012e.put(str, jSONObject);
    }

    public JSONObject a(String str, String str2, boolean z3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = this.f43012e.get(str);
        if (jSONObject == null) {
            String b4 = b(str);
            if (!TextUtils.isEmpty(b4)) {
                jSONObject = new j0(b4).a();
            }
        }
        if (jSONObject == null) {
            return null;
        }
        if (!z3 || (!TextUtils.isEmpty(str2) && str2.equals(jSONObject.optString("ph")))) {
            return jSONObject;
        }
        c(str);
        return null;
    }

    public boolean a(JSONObject jSONObject, int i4) {
        if (jSONObject == null) {
            return false;
        }
        int optInt = jSONObject.optInt("iv", 0);
        if (optInt != 0) {
            i4 = optInt;
        }
        long optLong = jSONObject.optLong("ts", 0L);
        return i4 > 0 ? optLong + (((long) i4) * 1000) > System.currentTimeMillis() : d2.a(i4 + 1) < optLong;
    }

    public static void a() {
        if (com.qq.e.comm.plugin.edgeanalytics.h.c.a.a("hasp", false)) {
            d0.f46406b.submit(new c());
        }
    }
}
