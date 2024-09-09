package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import com.kuaishou.weapon.p0.jni.Engine;
import java.util.HashSet;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class ax {

    /* renamed from: a  reason: collision with root package name */
    private JSONObject f38045a;

    public ax(Context context) {
        if (Engine.loadSuccess) {
            try {
                String pqr = Engine.getInstance(context).pqr(Integer.valueOf(ck.f38171g).intValue(), 1, 0, "");
                if (TextUtils.isEmpty(pqr)) {
                    return;
                }
                this.f38045a = new JSONObject(pqr);
            } catch (Throwable unused) {
            }
        }
    }

    public String a(String str) {
        JSONObject jSONObject = this.f38045a;
        if (jSONObject != null) {
            try {
                return jSONObject.optString(str, null);
            } catch (Exception unused) {
            }
        }
        return null;
    }

    public Set b(int i4) {
        HashSet hashSet = new HashSet();
        if (i4 == 1) {
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

    public Set a(Context context, String str, int i4) {
        JSONObject jSONObject = this.f38045a;
        if (jSONObject != null) {
            try {
                String string = jSONObject.getString(str);
                Set a4 = a(i4);
                if (TextUtils.isEmpty(string) || string.length() <= 3) {
                    return null;
                }
                JSONArray jSONArray = new JSONArray(string);
                HashSet hashSet = new HashSet();
                for (int i5 = 0; i5 < jSONArray.length(); i5++) {
                    String string2 = jSONArray.getString(i5);
                    if (!string2.contains("azeroth") && !string2.contains("OkHttp") && !string2.contains("retrofit")) {
                        int i6 = 0;
                        do {
                            if (!string2.contains(" ")) {
                                break;
                            }
                            string2 = string2.replace(" ", "");
                            i6++;
                        } while (i6 <= 200);
                        String replace = string2.replace("\n", "").replace("\t", "").replace("\u200b", "");
                        if (replace.startsWith(":")) {
                            replace = replace.substring(1);
                        }
                        String substring = replace.length() > 10 ? replace.substring(0, 10) : replace;
                        if (replace.contains("ridge")) {
                            hashSet.add(replace);
                        }
                        String packageName = context.getPackageName();
                        if (!replace.contains(packageName) && !packageName.contains(replace) && !a4.contains(substring) && !b(i4).contains(substring)) {
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

    public Set a(int i4) {
        HashSet hashSet = new HashSet();
        if (i4 == 1) {
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
