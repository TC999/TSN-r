package com.kwad.sdk.core.webview;

import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdResultData;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10485c;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.utils.C11012af;
import com.kwad.sdk.utils.C11053bg;
import com.kwad.sdk.widget.InterfaceC11147e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.kwad.sdk.core.webview.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C10605b {

    /* renamed from: NY */
    public WebView f29620NY;

    /* renamed from: OE */
    public ViewGroup f29621OE;
    public InterfaceC11147e aDJ;
    @Nullable
    public C11012af aDK;
    public boolean aDL = true;
    public boolean aDM = true;
    private List<AdTemplate> aDN = null;
    private AdResultData mAdResultData;
    @Nullable
    public JSONObject mReportExtData;
    public int mScreenOrientation;

    /* renamed from: GM */
    public final List<AdTemplate> m25326GM() {
        List<AdTemplate> list = this.aDN;
        if (list != null && list.size() > 0) {
            return this.aDN;
        }
        return this.mAdResultData.getAdTemplateList();
    }

    /* renamed from: GN */
    public final boolean m25325GN() {
        return m25326GM() == null || m25326GM().size() == 0;
    }

    /* renamed from: cV */
    public final AdTemplate m25324cV(String str) {
        if (TextUtils.isEmpty(str)) {
            return getAdTemplate();
        }
        for (AdTemplate adTemplate : m25326GM()) {
            if (C11053bg.isEquals(str, String.valueOf(C10487e.m25631ea(adTemplate)))) {
                return adTemplate;
            }
        }
        return null;
    }

    /* renamed from: d */
    public final void m25323d(AdResultData adResultData) {
        this.mAdResultData = adResultData;
    }

    public final AdTemplate getAdTemplate() {
        List<AdTemplate> list = this.aDN;
        if (list != null && list.size() > 0) {
            return this.aDN.get(0);
        }
        return C10485c.m25661n(this.mAdResultData);
    }

    /* renamed from: hk */
    public final AdResultData m25322hk() {
        AdResultData adResultData = this.mAdResultData;
        if (adResultData != null) {
            return adResultData;
        }
        if (this.aDN != null) {
            AdResultData adResultData2 = new AdResultData();
            adResultData2.setAdTemplateList(this.aDN);
            return adResultData2;
        }
        return null;
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        if (adTemplate == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        this.aDN = arrayList;
        arrayList.add(adTemplate);
    }

    public final void setAdTemplateList(List<AdTemplate> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (AdTemplate adTemplate : list) {
            arrayList.add(adTemplate);
        }
        this.aDN = arrayList;
    }
}
