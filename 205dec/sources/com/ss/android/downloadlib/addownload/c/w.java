package com.ss.android.downloadlib.addownload.c;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.ss.android.downloadlib.addownload.k;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
class w {
    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    public CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.w.c> c(String str, String str2) {
        CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.w.c> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = k.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    com.ss.android.downloadlib.addownload.w.c c4 = com.ss.android.downloadlib.addownload.w.c.c(jSONObject.optJSONObject(keys.next()));
                    if (c4 != null) {
                        copyOnWriteArrayList.add(c4);
                    }
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        k.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(String str, String str2, CopyOnWriteArrayList<com.ss.android.downloadlib.addownload.w.c> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<com.ss.android.downloadlib.addownload.w.c> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                com.ss.android.downloadlib.addownload.w.c next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.f48705w), next.c());
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        k.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
