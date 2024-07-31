package com.p521ss.android.socialbase.appdownloader.p546ok;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.umeng.ccg.CcgConstant;
import java.util.Iterator;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.ok.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12342bl extends AbstractC12348ok {

    /* renamed from: s */
    private final JSONObject f34807s;

    public C12342bl(Context context, C12534ok c12534ok, String str, JSONObject jSONObject) {
        super(context, c12534ok, str);
        this.f34807s = jSONObject;
    }

    /* renamed from: ok */
    private static void m18111ok(@NonNull Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (keys = jSONObject.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject2.optString(next);
            if (optString != null) {
                m18110ok(jSONObject, next, optString, intent);
            }
        }
    }

    @Override // com.p521ss.android.socialbase.appdownloader.p546ok.InterfaceC12347n
    /* renamed from: a */
    public Intent mo18106a() {
        String optString = this.f34807s.optString(CcgConstant.f38549t);
        String optString2 = this.f34807s.optString("category");
        int optInt = this.f34807s.optInt("flags", 1342210048);
        String optString3 = this.f34807s.optString("path_extra_key");
        String optString4 = this.f34807s.optString("path_data_key");
        JSONObject optJSONObject = this.f34807s.optJSONObject("extra");
        JSONObject optJSONObject2 = this.f34807s.optJSONObject("extra_type");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        Intent intent = new Intent(optString);
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(Uri.parse(String.format(optString4, this.f34809bl)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(optInt);
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.f34809bl);
        }
        m18111ok(intent, optJSONObject, optJSONObject2);
        return intent;
    }

    /* renamed from: ok */
    private static void m18110ok(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case -1325958191:
                if (str2.equals("double")) {
                    c = 0;
                    break;
                }
                break;
            case -891985903:
                if (str2.equals("string")) {
                    c = 1;
                    break;
                }
                break;
            case 104431:
                if (str2.equals(IAdInterListener.AdProdType.PRODUCT_INTERSTITIAL)) {
                    c = 2;
                    break;
                }
                break;
            case 3327612:
                if (str2.equals("long")) {
                    c = 3;
                    break;
                }
                break;
            case 64711720:
                if (str2.equals("boolean")) {
                    c = 4;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                intent.putExtra(str, jSONObject.optDouble(str));
                return;
            case 1:
                intent.putExtra(str, jSONObject.optString(str));
                return;
            case 2:
                intent.putExtra(str, jSONObject.optInt(str));
                return;
            case 3:
                intent.putExtra(str, jSONObject.optLong(str));
                return;
            case 4:
                intent.putExtra(str, jSONObject.optBoolean(str));
                return;
            default:
                return;
        }
    }
}
