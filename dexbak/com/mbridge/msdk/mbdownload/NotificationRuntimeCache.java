package com.mbridge.msdk.mbdownload;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.controller.SDKController;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDir;
import com.mbridge.msdk.foundation.same.p475b.MBridgeDirManager;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.mbridge.msdk.mbdownload.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class NotificationRuntimeCache {

    /* renamed from: a */
    private static final String f31362a = "com.mbridge.msdk.mbdownload.i";

    /* renamed from: b */
    private final Context f31363b;

    /* renamed from: c */
    private final boolean f31364c = SDKController.m22827a().m22818d();

    /* renamed from: d */
    private FastKV f31365d;

    public NotificationRuntimeCache(Context context) {
        this.f31363b = context;
    }

    /* renamed from: a */
    public final void m21593a(int i) {
        if (this.f31364c && this.f31365d == null) {
            try {
                this.f31365d = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "MB_RUNTIME_CACHE").build();
            } catch (Exception unused) {
                this.f31365d = null;
            }
        }
        FastKV fastKV = this.f31365d;
        if (fastKV != null) {
            try {
                fastKV.putString("" + i, "");
                return;
            } catch (Exception e) {
                SameLogTool.m21735b(f31362a, "addNid error", e);
                return;
            }
        }
        try {
            SharedPreferences sharedPreferences = this.f31363b.getSharedPreferences("MB_RUNTIME_CACHE", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            synchronized (sharedPreferences) {
                edit.putString("" + i, "");
                edit.apply();
            }
            String str = f31362a;
            SameLogTool.m21736b(str, "add nid [" + i + "] to runtime cache.");
        } catch (Exception unused2) {
        }
    }

    /* renamed from: b */
    public final boolean m21592b() {
        if (this.f31364c && this.f31365d == null) {
            try {
                this.f31365d = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "MB_RUNTIME_CACHE").build();
            } catch (Exception unused) {
                this.f31365d = null;
            }
        }
        FastKV fastKV = this.f31365d;
        if (fastKV == null) {
            return this.f31363b.getSharedPreferences("MB_RUNTIME_CACHE", 0).getAll().size() > 0;
        }
        try {
            return fastKV.getAll().size() > 0;
        } catch (Exception unused2) {
            return false;
        }
    }

    /* renamed from: b */
    public final void m21591b(int i) {
        try {
            SharedPreferences sharedPreferences = this.f31363b.getSharedPreferences("MB_RUNTIME_CACHE", 0);
            if (sharedPreferences.contains("" + i)) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.remove("" + i);
                edit.apply();
            }
            String str = f31362a;
            SameLogTool.m21736b(str, "remove nid [" + i + "] to runtime cache.");
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public final List<Integer> m21594a() {
        ArrayList arrayList = new ArrayList();
        Map<String, Object> map = null;
        if (this.f31364c && this.f31365d == null) {
            try {
                this.f31365d = new FastKV.Builder(MBridgeDirManager.m22347b(MBridgeDir.MBRIDGE_700_CONFIG), "MB_RUNTIME_CACHE").build();
            } catch (Exception unused) {
                this.f31365d = null;
            }
        }
        FastKV fastKV = this.f31365d;
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
                        String str2 = f31362a;
                        SameLogTool.m21736b(str2, "get nid [" + parseInt + "]");
                    } catch (NumberFormatException unused3) {
                    }
                }
            }
            this.f31365d.clear();
        } else {
            try {
                SharedPreferences sharedPreferences = this.f31363b.getSharedPreferences("MB_RUNTIME_CACHE", 0);
                for (String str3 : sharedPreferences.getAll().keySet()) {
                    try {
                        int parseInt2 = Integer.parseInt(str3);
                        arrayList.add(Integer.valueOf(parseInt2));
                        String str4 = f31362a;
                        SameLogTool.m21736b(str4, "get nid [" + parseInt2 + "]");
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
