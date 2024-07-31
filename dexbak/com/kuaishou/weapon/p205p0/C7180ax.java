package com.kuaishou.weapon.p205p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p205p0.jni.Engine;
import com.snail.antifake.deviceid.ShellAdbUtils;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.kuaishou.weapon.p0.ax */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7180ax {

    /* renamed from: a */
    private JSONObject f24537a;

    public C7180ax(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(C7227ck.f24675g).intValue(), 1, 0, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f24537a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public String m34313a(String str) {
        JSONObject jSONObject = this.f24537a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    /* renamed from: b */
    public Set m34312b(int i) {
        HashSet hashSet = new HashSet();
        if (i == 1) {
            hashSet.add("AudioTrack");
            hashSet.add("processrea");
            hashSet.add("RemitDatab");
            hashSet.add("BrowserBlo");
            hashSet.add("game_push");
            hashSet.add("Godzilla:I");
            hashSet.add("IndexedDB");
            hashSet.add("ScopeRetry");
            hashSet.add("RobustPatc");
            hashSet.add("FrescoIoBo");
            hashSet.add("key_config");
        }
        return hashSet;
    }

    /* renamed from: a */
    public Set m34314a(Context context, String str, int i) {
        JSONObject jSONObject = this.f24537a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                Set m34315a = m34315a(i);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    String string2 = jSONArray.getString(i2);
                    if (!string2.contains("azeroth") && !string2.contains("OkHttp") && !string2.contains("retrofit")) {
                        int i3 = 0;
                        do {
                            if (!string2.contains(" ")) {
                                break;
                            }
                            string2 = string2.replace(" ", "");
                            i3++;
                        } while (i3 <= 200);
                        String replace = string2.replace(ShellAdbUtils.f33810d, "").replace("\t", "").replace("\u200b", "");
                        if (replace.startsWith(":")) {
                            replace = replace.substring(1);
                        }
                        String substring = replace.length() > 10 ? replace.substring(0, 10) : replace;
                        if (replace.contains("ridge")) {
                            hashSet.add(replace);
                        }
                        String packageName = context.getPackageName();
                        if (!replace.contains(packageName) && !packageName.contains(replace) && !m34315a.contains(substring) && !m34312b(i).contains(substring)) {
                            hashSet.add(replace);
                        }
                    }
                }
                if (hashSet.size() > 0) {
                    return hashSet;
                }
                return null;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: a */
    public Set m34315a(int i) {
        HashSet hashSet = new HashSet();
        if (i == 1) {
            hashSet.add("HeapTaskDa");
            hashSet.add("queued-wor");
            hashSet.add("JDWP");
            hashSet.add("dTi");
            hashSet.add("MessageHan");
            hashSet.add("MediaPrefe");
            hashSet.add("CleanupRef");
            hashSet.add("GeoLocatio");
            hashSet.add("securityai");
            hashSet.add("Connectivi");
            hashSet.add("PatchManag");
            hashSet.add("CronetInte");
            hashSet.add("AegonLogge");
            hashSet.add("Countly");
            hashSet.add("DownloadSt");
            hashSet.add("GoogleApiH");
            hashSet.add("PlatformSe");
            hashSet.add("MemoryInfr");
            hashSet.add("CronetLibr");
            hashSet.add("Dex2OatIni");
            hashSet.add("EncodeApiH");
            hashSet.add("CookieMons");
        }
        return hashSet;
    }
}
