package com.kwad.sdk.core.response.b;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdStyleInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    public static long dC(@Nullable AdTemplate adTemplate) {
        if (adTemplate == null) {
            return 0L;
        }
        return dG(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonShowTime;
    }

    public static String dD(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : dG(adTemplate).playDetailInfo.detailTopToolBarInfo.callButtonDescription;
    }

    public static String dE(@Nullable AdTemplate adTemplate) {
        return adTemplate == null ? "" : dG(adTemplate).playEndInfo.endTopToolBarInfo.callButtonDescription;
    }

    public static boolean dF(@Nullable AdTemplate adTemplate) {
        if (adTemplate != null && e.dI(adTemplate)) {
            return dG(adTemplate).slideClick;
        }
        return false;
    }

    @NonNull
    private static AdStyleInfo dG(@NonNull AdTemplate adTemplate) {
        return e.dQ(adTemplate).adStyleInfo;
    }

    public static List<String> dH(@NonNull AdTemplate adTemplate) {
        AdStyleInfo dG = dG(adTemplate);
        ArrayList arrayList = new ArrayList();
        try {
            for (AdStyleInfo.ExposeTagInfo exposeTagInfo : dG.extraDisplayInfo.exposeTagInfoList) {
                arrayList.add(exposeTagInfo.text);
            }
        } catch (Exception unused) {
        }
        return arrayList;
    }
}
