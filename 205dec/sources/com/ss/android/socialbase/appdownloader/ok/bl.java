package com.ss.android.socialbase.appdownloader.ok;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.util.Iterator;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl extends ok {

    /* renamed from: s  reason: collision with root package name */
    private final JSONObject f49162s;

    public bl(Context context, com.ss.android.socialbase.downloader.h.ok okVar, String str, JSONObject jSONObject) {
        super(context, okVar, str);
        this.f49162s = jSONObject;
    }

    private static void ok(@NonNull Intent intent, JSONObject jSONObject, JSONObject jSONObject2) {
        Iterator<String> keys;
        if (jSONObject == null || jSONObject2 == null || jSONObject.length() != jSONObject2.length() || intent == null || (keys = jSONObject.keys()) == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            String optString = jSONObject2.optString(next);
            if (optString != null) {
                ok(jSONObject, next, optString, intent);
            }
        }
    }

    @Override // com.ss.android.socialbase.appdownloader.ok.n
    public Intent a() {
        String optString = this.f49162s.optString("action");
        String optString2 = this.f49162s.optString("category");
        int optInt = this.f49162s.optInt("flags", 1342210048);
        String optString3 = this.f49162s.optString("path_extra_key");
        String optString4 = this.f49162s.optString("path_data_key");
        JSONObject optJSONObject = this.f49162s.optJSONObject("extra");
        JSONObject optJSONObject2 = this.f49162s.optJSONObject("extra_type");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        Intent intent = new Intent(optString);
        if (!TextUtils.isEmpty(optString2)) {
            intent.addCategory(optString2);
        }
        if (!TextUtils.isEmpty(optString4)) {
            try {
                intent.setData(Uri.parse(String.format(optString4, this.bl)));
            } catch (Throwable unused) {
            }
        }
        intent.setFlags(optInt);
        if (!TextUtils.isEmpty(optString3)) {
            intent.putExtra(optString3, this.bl);
        }
        ok(intent, optJSONObject, optJSONObject2);
        return intent;
    }

    private static void ok(JSONObject jSONObject, String str, String str2, Intent intent) {
        str2.hashCode();
        char c4 = '\uffff';
        switch (str2.hashCode()) {
            case -1325958191:
                if (str2.equals("double")) {
                    c4 = 0;
                    break;
                }
                break;
            case -891985903:
                if (str2.equals("string")) {
                    c4 = 1;
                    break;
                }
                break;
            case 104431:
                if (str2.equals("int")) {
                    c4 = 2;
                    break;
                }
                break;
            case 3327612:
                if (str2.equals("long")) {
                    c4 = 3;
                    break;
                }
                break;
            case 64711720:
                if (str2.equals("boolean")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
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
