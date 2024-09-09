package com.ss.android.downloadlib.addownload.ok;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.r;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        r.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.a.ok> ok(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.a.ok> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = r.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    com.ss.android.downloadlib.addownload.a.ok ok = com.ss.android.downloadlib.addownload.a.ok.ok(jSONObject.optJSONObject(keys.next()));
                    if (ok != null) {
                        copyOnWriteArrayList.add(ok);
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.a.ok> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<com.ss.android.downloadlib.addownload.a.ok> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.a.ok next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.f48374a), next.ok());
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        r.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
