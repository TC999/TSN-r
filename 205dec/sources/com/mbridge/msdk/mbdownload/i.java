package com.mbridge.msdk.mbdownload;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.x;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: NotificationRuntimeCache.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f40134a = "com.mbridge.msdk.mbdownload.i";

    /* renamed from: b  reason: collision with root package name */
    private final Context f40135b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f40136c = com.mbridge.msdk.foundation.controller.b.a().d();

    /* renamed from: d  reason: collision with root package name */
    private FastKV f40137d;

    public i(Context context) {
        this.f40135b = context;
    }

    public final void a(int i4) {
        if (this.f40136c && this.f40137d == null) {
            try {
                this.f40137d = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "MB_RUNTIME_CACHE").build();
            } catch (Exception unused) {
                this.f40137d = null;
            }
        }
        FastKV fastKV = this.f40137d;
        if (fastKV != null) {
            try {
                fastKV.putString("" + i4, "");
                return;
            } catch (Exception e4) {
                x.b(f40134a, "addNid error", e4);
                return;
            }
        }
        try {
            SharedPreferences sharedPreferences = this.f40135b.getSharedPreferences("MB_RUNTIME_CACHE", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            synchronized (sharedPreferences) {
                edit.putString("" + i4, "");
                edit.apply();
            }
            String str = f40134a;
            x.b(str, "add nid [" + i4 + "] to runtime cache.");
        } catch (Exception unused2) {
        }
    }

    public final boolean b() {
        if (this.f40136c && this.f40137d == null) {
            try {
                this.f40137d = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "MB_RUNTIME_CACHE").build();
            } catch (Exception unused) {
                this.f40137d = null;
            }
        }
        FastKV fastKV = this.f40137d;
        if (fastKV == null) {
            return this.f40135b.getSharedPreferences("MB_RUNTIME_CACHE", 0).getAll().size() > 0;
        }
        try {
            return fastKV.getAll().size() > 0;
        } catch (Exception unused2) {
            return false;
        }
    }

    public final void b(int i4) {
        try {
            SharedPreferences sharedPreferences = this.f40135b.getSharedPreferences("MB_RUNTIME_CACHE", 0);
            if (sharedPreferences.contains("" + i4)) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove("" + i4);
                edit.apply();
            }
            String str = f40134a;
            x.b(str, "remove nid [" + i4 + "] to runtime cache.");
        } catch (Exception unused) {
        }
    }

    public final List<Integer> a() {
        ArrayList arrayList = new ArrayList();
        Map<String, Object> map = null;
        if (this.f40136c && this.f40137d == null) {
            try {
                this.f40137d = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "MB_RUNTIME_CACHE").build();
            } catch (Exception unused) {
                this.f40137d = null;
            }
        }
        FastKV fastKV = this.f40137d;
        if (fastKV != null) {
            try {
                map = fastKV.getAll();
            } catch (Exception unused2) {
            }
            if (map != null) {
                for (String str : map.keySet()) {
                    try {
                        int parseInt = Integer.parseInt(str);
                        arrayList.add(Integer.valueOf(parseInt));
                        String str2 = f40134a;
                        x.b(str2, "get nid [" + parseInt + "]");
                    } catch (NumberFormatException unused3) {
                    }
                }
            }
            this.f40137d.clear();
        } else {
            try {
                SharedPreferences sharedPreferences = this.f40135b.getSharedPreferences("MB_RUNTIME_CACHE", 0);
                for (String str3 : sharedPreferences.getAll().keySet()) {
                    try {
                        int parseInt2 = Integer.parseInt(str3);
                        arrayList.add(Integer.valueOf(parseInt2));
                        String str4 = f40134a;
                        x.b(str4, "get nid [" + parseInt2 + "]");
                    } catch (NumberFormatException unused4) {
                    }
                }
                sharedPreferences.edit().clear().apply();
            } catch (Exception unused5) {
            }
        }
        return arrayList;
    }
}
