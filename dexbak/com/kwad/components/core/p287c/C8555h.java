package com.kwad.components.core.p287c;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.internal.api.SceneImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.c.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8555h implements InterfaceC8556i, Comparable<C8555h> {

    /* renamed from: IZ */
    private final String f28104IZ;

    /* renamed from: Jj */
    private final String f28105Jj;

    /* renamed from: Jk */
    private final String f28106Jk;

    /* renamed from: Jl */
    private final String f28107Jl;

    /* renamed from: Jm */
    private final long f28108Jm;
    private final long createTime;
    private final int ecpm;

    private C8555h(String str, String str2, String str3, int i, String str4, long j, long j2) {
        this.f28105Jj = str;
        this.f28104IZ = str2;
        this.f28106Jk = str3;
        this.ecpm = i;
        this.f28107Jl = str4;
        this.createTime = j;
        this.f28108Jm = j2;
    }

    /* renamed from: a */
    public static List<C8555h> m30371a(C8551e c8551e, AdResultData adResultData) {
        List<AdTemplate> proceedTemplateList = adResultData.getProceedTemplateList();
        int size = proceedTemplateList.size();
        long currentTimeMillis = System.currentTimeMillis();
        long m30383mC = (currentTimeMillis / 1000) + c8551e.m30383mC();
        ArrayList arrayList = new ArrayList();
        SceneImpl defaultAdScene = adResultData.getDefaultAdScene();
        Iterator<AdTemplate> it = proceedTemplateList.iterator();
        while (it.hasNext()) {
            AdTemplate next = it.next();
            arrayList.add(new C8555h(String.valueOf(C10487e.m25631ea(next)), String.valueOf(adResultData.getPosId()), new AdResultData(adResultData, defaultAdScene, Collections.singletonList(next)).getResponseJson(), C10487e.m25627ee(next), adResultData.getDefaultAdScene().toJson().toString(), currentTimeMillis + size, m30383mC));
            size--;
            it = it;
            defaultAdScene = defaultAdScene;
        }
        return arrayList;
    }

    @SuppressLint({"Range"})
    /* renamed from: c */
    private static synchronized C8555h m30370c(@NonNull Cursor cursor) {
        C8555h c8555h;
        synchronized (C8555h.class) {
            c8555h = new C8555h(cursor.getString(cursor.getColumnIndex("creativeId")), cursor.getString(cursor.getColumnIndex("posId")), cursor.getString(cursor.getColumnIndex("adJson")), cursor.getInt(cursor.getColumnIndex("ecpm")), cursor.getString(cursor.getColumnIndex("adSenseJson")), cursor.getLong(cursor.getColumnIndex("createTime")), cursor.getLong(cursor.getColumnIndex("expireTime")));
        }
        return c8555h;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* renamed from: d */
    public int compareTo(C8555h c8555h) {
        if (c8555h.m30364mI() == m30364mI()) {
            return (int) (c8555h.m30363mJ() - m30363mJ());
        }
        return c8555h.m30364mI() - m30364mI();
    }

    /* renamed from: j */
    public static AdResultData m30367j(List<C8555h> list) {
        ArrayList arrayList = new ArrayList();
        AdResultData adResultData = null;
        if (list == null || list.size() == 0) {
            return null;
        }
        SceneImpl sceneImpl = null;
        for (C8555h c8555h : list) {
            adResultData = m30369c(c8555h);
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

    /* renamed from: mH */
    private String m30365mH() {
        return this.f28106Jk;
    }

    /* renamed from: mI */
    private int m30364mI() {
        return this.ecpm;
    }

    /* renamed from: mJ */
    private long m30363mJ() {
        return this.createTime;
    }

    /* renamed from: mL */
    private String m30361mL() {
        return this.f28107Jl;
    }

    @Override // com.kwad.components.core.p287c.InterfaceC8556i
    /* renamed from: mD */
    public final ContentValues mo30359mD() {
        ContentValues contentValues = new ContentValues();
        contentValues.put("creativeId", this.f28105Jj);
        contentValues.put("posId", this.f28104IZ);
        contentValues.put("adJson", this.f28106Jk);
        contentValues.put("ecpm", Integer.valueOf(this.ecpm));
        contentValues.put("adSenseJson", this.f28107Jl);
        contentValues.put("createTime", Long.valueOf(this.createTime));
        contentValues.put("expireTime", Long.valueOf(this.f28108Jm));
        contentValues.put("playAgainJson", (String) null);
        return contentValues;
    }

    /* renamed from: mG */
    public final String m30366mG() {
        return this.f28104IZ;
    }

    /* renamed from: mK */
    public final long m30362mK() {
        return this.f28108Jm;
    }

    /* renamed from: mM */
    public final String m30360mM() {
        return this.f28105Jj;
    }

    @Nullable
    /* renamed from: c */
    private static AdResultData m30369c(C8555h c8555h) {
        if (c8555h == null) {
            return null;
        }
        if (c8555h.m30365mH() != null && c8555h.m30361mL() != null) {
            try {
                String m30361mL = c8555h.m30361mL();
                SceneImpl sceneImpl = new SceneImpl();
                sceneImpl.parseJson(new JSONObject(m30361mL));
                AdResultData createFromResponseJson = AdResultData.createFromResponseJson(c8555h.m30365mH(), sceneImpl);
                for (AdTemplate adTemplate : createFromResponseJson.getProceedTemplateList()) {
                    adTemplate.fromCache = true;
                }
                return createFromResponseJson;
            } catch (JSONException e) {
                C10331c.printStackTraceOnly(e);
                return null;
            }
        }
        C10331c.m26246w("CachedAd", "createAdResultData cachedAd data illegal");
        return null;
    }

    /* renamed from: a */
    public static List<C8555h> m30372a(Cursor cursor) {
        if (cursor == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            try {
                arrayList.add(m30370c(cursor));
            } catch (Exception e) {
                C10331c.printStackTrace(e);
            }
        }
        return arrayList;
    }
}
