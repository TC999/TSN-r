package com.kwad.sdk.core.response.p409b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.kwad.sdk.core.response.b.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10486d {
    /* renamed from: dC */
    public static long m25660dC(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return m25656dG(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    /* renamed from: dD */
    public static String m25659dD(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : m25656dG(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    /* renamed from: dE */
    public static String m25658dE(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : m25656dG(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    /* renamed from: dF */
    public static boolean m25657dF(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && C10487e.m25649dI(adTemplate)) {
            return m25656dG(adTemplate).slideClick;
        }
        return false;
    }

    @NonNull
    /* renamed from: dG */
    private static AdStyleInfo m25656dG(@NonNull AdTemplate adTemplate) {
        return C10487e.m25641dQ(adTemplate).adStyleInfo;
    }

    /* renamed from: dH */
    public static List<String> m25655dH(@NonNull AdTemplate adTemplate) {
        AdStyleInfo m25656dG = m25656dG(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            for (AdStyleInfo.ExposeTagInfo exposeTagInfo : m25656dG.extraDisplayInfo.exposeTagInfoList) {
                arrayList.add(exposeTagInfo.text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
