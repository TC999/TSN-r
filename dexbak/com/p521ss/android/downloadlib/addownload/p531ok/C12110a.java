package com.p521ss.android.downloadlib.addownload.p531ok;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.downloadlib.addownload.C12128r;
import com.p521ss.android.downloadlib.addownload.p528a.C12036ok;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;

/* renamed from: com.ss.android.downloadlib.addownload.ok.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class C12110a {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m19043a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        C12128r.getContext().getSharedPreferences(str, 0).edit().putString(str2, "").apply();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @NonNull
    /* renamed from: ok */
    public CopyOnWriteArrayList<C12036ok> m19042ok(String str, String str2) {
        CopyOnWriteArrayList<C12036ok> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        try {
            String string = C12128r.getContext().getSharedPreferences(str, 0).getString(str2, "");
            if (!TextUtils.isEmpty(string)) {
                JSONObject jSONObject = new JSONObject(string);
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    C12036ok m19283ok = C12036ok.m19283ok(jSONObject.optJSONObject(keys.next()));
                    if (m19283ok != null) {
                        copyOnWriteArrayList.add(m19283ok);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return copyOnWriteArrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m19041ok(String str, String str2, CopyOnWriteArrayList<C12036ok> copyOnWriteArrayList) {
        if (copyOnWriteArrayList == null) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            Iterator<C12036ok> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                C12036ok next = it.next();
                if (next != null) {
                    jSONObject.put(String.valueOf(next.f34081a), next.m19284ok());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        C12128r.getContext().getSharedPreferences(str, 0).edit().putString(str2, jSONObject.toString()).apply();
    }
}
