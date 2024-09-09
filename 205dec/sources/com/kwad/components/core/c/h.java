package com.kwad.components.core.c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h implements i, Comparable<h> {
    private final String IZ;
    private final String Jj;
    private final String Jk;
    private final String Jl;
    private final long Jm;
    private final long createTime;
    private final int ecpm;

    private h(String str, String str2, String str3, int i4, String str4, long j4, long j5) {
        this.Jj = str;
        this.IZ = str2;
        this.Jk = str3;
        this.ecpm = i4;
        this.Jl = str4;
        this.createTime = j4;
        this.Jm = j5;
    }

    public static List<h> a(e eVar, AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long currentTimeMillis = System.currentTimeMillis();
        long mC = (currentTimeMillis / 1000) + eVar.mC();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            arrayList.add(new h(String.valueOf(com.kwad.sdk.core.response.b.e.ea(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData, defaultAdScene, Collections.singletonList(next)).getResponseJson(), com.kwad.sdk.core.response.b.e.ee(next), adResultData.getDefaultAdScene().toJson().toString(), currentTimeMillis + size, mC));
            size--;
            it = it;
            defaultAdScene = defaultAdScene;
        }
        return arrayList;
    }

    @SuppressLint({"Range"})
    private static synchronized h c(@NonNull Cursor cursor) {
        h hVar;
        synchronized (h.class) {
            hVar = new h(cursor.getString(cursor.getColumnIndex("creativeId")), cursor.getString(cursor.getColumnIndex("posId")), cursor.getString(cursor.getColumnIndex("adJson")), cursor.getInt(cursor.getColumnIndex("ecpm")), cursor.getString(cursor.getColumnIndex("adSenseJson")), cursor.getLong(cursor.getColumnIndex("createTime")), cursor.getLong(cursor.getColumnIndex("expireTime")));
        }
        return hVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(h hVar) {
        if (hVar.mI() == mI()) {
            return (int) (hVar.mJ() - mJ());
        }
        return hVar.mI() - mI();
    }

    public static AdResultData j(List<h> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultData = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        SceneImpl sceneImpl = null;
        for (h hVar : list) {
            adResultData = c(hVar);
            if (adResultData != null) {
                if (sceneImpl == null) {
                    sceneImpl = adResultData.getDefaultAdScene();
                }
                arrayList.addAll(adResultData.getProceedTemplateList());
            }
        }
        AdResultData adResultData2 = new AdResultData(adResultData, sceneImpl, arrayList);
        adResultData2.setAdSource("cache");
        return adResultData2;
    }

    private String mH() {
        return this.Jk;
    }

    private int mI() {
        return this.ecpm;
    }

    private long mJ() {
        return this.createTime;
    }

    private String mL() {
        return this.Jl;
    }

    @Override // com.kwad.components.core.c.i
    public final ContentValues mD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.Jj);
        contentValues.put("posId", this.IZ);
        contentValues.put("adJson", this.Jk);
        contentValues.put("ecpm", Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.Jl);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.Jm));
        contentValues.put("playAgainJson", (String) null);
        return contentValues;
    }

    public final String mG() {
        return this.IZ;
    }

    public final long mK() {
        return this.Jm;
    }

    public final String mM() {
        return this.Jj;
    }

    @Nullable
    private static AdResultData c(h hVar) {
        if (hVar == null) {
            return null;
        }
        if (hVar.mH() != null && hVar.mL() != null) {
            try {
                String mL = hVar.mL();
                SceneImpl sceneImpl = new SceneImpl();
                sceneImpl.parseJson(new JSONObject(mL));
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(hVar.mH(), sceneImpl);
                for (AdTemplate adTemplate : createFromResponseJson.getProceedTemplateList()) {
                    adTemplate.fromCache = true;
                }
                return createFromResponseJson;
            } catch (JSONException e4) {
                com.kwad.sdk.core.e.c.printStackTraceOnly(e4);
                return null;
            }
        }
        com.kwad.sdk.core.e.c.w("CachedAd", "createAdResultData cachedAd data illegal");
        return null;
    }

    public static List<h> a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(c(cursor));
            } catch (Exception e4) {
                com.kwad.sdk.core.e.c.printStackTrace(e4);
            }
        }
        return arrayList;
    }
}
