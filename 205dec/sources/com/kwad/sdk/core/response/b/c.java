package com.kwad.sdk.core.response.b;

import android.text.TextUtils;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    public static <R extends AdResultData, T extends AdTemplate> T a(R r3, String str) {
        if (r3 == null) {
            return null;
        }
        if (TextUtils.isEmpty(str)) {
            Iterator<AdTemplate> it = r3.getAdTemplateList().iterator();
            while (it.hasNext()) {
                T t3 = (T) it.next();
                if (String.valueOf(e.dQ(t3).adBaseInfo.creativeId).equals(str)) {
                    return t3;
                }
            }
        }
        return (T) r3.getFirstAdTemplate();
    }

    public static AdResultData dB(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return null;
        }
        return adTemplate.createAdResultData();
    }

    public static <R extends AdResultData, T extends AdTemplate> T n(R r3) {
        if (r3 == null) {
            return null;
        }
        return (T) r3.getFirstAdTemplate();
    }

    public static <T extends AdResultData> AdResultData a(AdResultData adResultData, AdTemplate adTemplate) {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(adTemplate);
        AdResultData m94clone = adResultData.m94clone();
        m94clone.setAdTemplateList(arrayList);
        return m94clone;
    }
}
