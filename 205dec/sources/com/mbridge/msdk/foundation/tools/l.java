package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.FastKV;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: InstallAppManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class l {

    /* renamed from: b  reason: collision with root package name */
    private static l f39862b;

    /* renamed from: a  reason: collision with root package name */
    private Context f39863a;

    /* renamed from: c  reason: collision with root package name */
    private SharedPreferences f39864c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f39865d;

    /* renamed from: e  reason: collision with root package name */
    private FastKV f39866e = null;

    private l(Context context) {
        this.f39865d = false;
        this.f39863a = context;
        this.f39865d = com.mbridge.msdk.foundation.controller.b.a().d();
    }

    public static l a(Context context) {
        if (f39862b == null) {
            synchronized (l.class) {
                if (f39862b == null) {
                    f39862b = new l(context);
                }
            }
        }
        return f39862b;
    }

    public final CopyOnWriteArraySet<com.mbridge.msdk.foundation.entity.i> a(String str) {
        CopyOnWriteArraySet<com.mbridge.msdk.foundation.entity.i> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
        String str2 = null;
        if (this.f39865d && this.f39866e == null) {
            try {
                this.f39866e = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "installed").build();
            } catch (Exception unused) {
                this.f39866e = null;
            }
        }
        FastKV fastKV = this.f39866e;
        int i4 = 0;
        if (fastKV != null) {
            try {
                str2 = fastKV.getString(str + "_installed", "");
            } catch (Exception unused2) {
            }
            try {
                if (!TextUtils.isEmpty(str2)) {
                    JSONArray jSONArray = new JSONArray(str2);
                    while (i4 < jSONArray.length()) {
                        com.mbridge.msdk.foundation.entity.i iVar = new com.mbridge.msdk.foundation.entity.i();
                        JSONObject jSONObject = jSONArray.getJSONObject(i4);
                        iVar.a(jSONObject.optString("campaignId"));
                        iVar.b(jSONObject.optString("packageName"));
                        copyOnWriteArraySet.add(iVar);
                        i4++;
                    }
                }
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        } else {
            Context context = this.f39863a;
            if (context != null) {
                try {
                    SharedPreferences sharedPreferences = context.getSharedPreferences("installed", 0);
                    this.f39864c = sharedPreferences;
                    if (sharedPreferences != null) {
                        String string = sharedPreferences.getString(str + "_installed", "");
                        if (!TextUtils.isEmpty(string)) {
                            JSONArray jSONArray2 = new JSONArray(string);
                            while (i4 < jSONArray2.length()) {
                                com.mbridge.msdk.foundation.entity.i iVar2 = new com.mbridge.msdk.foundation.entity.i();
                                JSONObject jSONObject2 = jSONArray2.getJSONObject(i4);
                                iVar2.a(jSONObject2.optString("campaignId"));
                                iVar2.b(jSONObject2.optString("packageName"));
                                copyOnWriteArraySet.add(iVar2);
                                i4++;
                            }
                        }
                    }
                } catch (JSONException e5) {
                    e5.printStackTrace();
                }
            }
        }
        return copyOnWriteArraySet;
    }

    public final void a(Set<com.mbridge.msdk.foundation.entity.i> set) {
        SharedPreferences.Editor edit;
        if (set == null || set.size() < 0) {
            return;
        }
        if (this.f39865d && this.f39866e == null) {
            try {
                this.f39866e = new FastKV.Builder(com.mbridge.msdk.foundation.same.b.e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "installed").build();
            } catch (Exception unused) {
                this.f39866e = null;
            }
        }
        if (this.f39866e != null) {
            try {
                String a4 = com.mbridge.msdk.foundation.entity.i.a(set);
                try {
                    FastKV fastKV = this.f39866e;
                    fastKV.putString(com.mbridge.msdk.foundation.controller.a.f().k() + "_installed", a4);
                    return;
                } catch (Exception unused2) {
                    return;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        try {
            String a5 = com.mbridge.msdk.foundation.entity.i.a(set);
            Context context = this.f39863a;
            if (context != null) {
                SharedPreferences sharedPreferences = context.getSharedPreferences("installed", 0);
                this.f39864c = sharedPreferences;
                if (sharedPreferences == null || (edit = sharedPreferences.edit()) == null) {
                    return;
                }
                edit.putString(com.mbridge.msdk.foundation.controller.a.f().k() + "_installed", a5);
                edit.apply();
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }
}
