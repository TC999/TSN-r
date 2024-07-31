package com.kwad.sdk.core.response.p409b;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.kwad.sdk.core.response.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10485c {
    /* renamed from: a */
    public static <R extends AdResultData, T extends AdTemplate> T m25663a(R r, String str) {
        if (r == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            Iterator<AdTemplate> it = r.getAdTemplateList().iterator();
            while (it.hasNext()) {
                T t = (T) it.next();
                if (String.valueOf(C10487e.m25641dQ(t).adBaseInfo.creativeId).equals(str)) {
                    return t;
                }
            }
        }
        return (T) r.getFirstAdTemplate();
    }

    /* renamed from: dB */
    public static AdResultData m25662dB(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        return adTemplate.createAdResultData();
    }

    /* renamed from: n */
    public static <R extends AdResultData, T extends AdTemplate> T m25661n(R r) {
        if (r == null) {
            return null;
        }
        return (T) r.getFirstAdTemplate();
    }

    /* renamed from: a */
    public static <T extends AdResultData> AdResultData m25664a(AdResultData adResultData, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(adTemplate);
        AdResultData m60138clone = adResultData.m60138clone();
        m60138clone.setAdTemplateList(arrayList);
        return m60138clone;
    }
}
