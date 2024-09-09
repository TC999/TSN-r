package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.e.d.a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class x implements com.kwad.sdk.core.webview.c.a {
    protected final com.kwad.sdk.core.webview.b Wf;
    private int Wr;
    private boolean Ws;
    private final boolean Wt;
    private boolean Wu;
    private List<com.kwad.components.core.e.d.c> Wv;
    private boolean Ww;
    @Nullable
    private com.kwad.sdk.core.webview.d.a.a cR;
    @Nullable
    private DialogInterface.OnDismissListener xB;

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z3, int i4, boolean z4, boolean z5) {
        this.Ws = false;
        this.Wv = new ArrayList();
        this.Ws = z3;
        this.Wf = bVar;
        this.Wr = i4;
        if (cVar != null) {
            cVar.as(1);
            this.Wv.add(cVar);
        }
        this.cR = aVar;
        this.Wt = z4;
        this.Ww = z5;
    }

    private static boolean aA(AdTemplate adTemplate) {
        return com.kwad.sdk.core.response.b.e.dL(adTemplate) == 13;
    }

    @Nullable
    protected final com.kwad.components.core.e.d.c J(long j4) {
        List<com.kwad.components.core.e.d.c> list = this.Wv;
        if (list == null) {
            return null;
        }
        if (j4 < 0 && list.size() == 1) {
            return this.Wv.get(0);
        }
        for (com.kwad.components.core.e.d.c cVar : this.Wv) {
            if (com.kwad.sdk.core.response.b.e.ea(cVar.oc()) == j4) {
                return cVar;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void K(int i4) {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void jh() {
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.cR = null;
    }

    static /* synthetic */ boolean a(x xVar, com.kwad.sdk.core.webview.d.b.a aVar) {
        return b(aVar);
    }

    private static boolean b(com.kwad.sdk.core.webview.d.b.a aVar) {
        return aVar.XC == 1;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        final com.kwad.sdk.core.webview.d.b.a aVar = new com.kwad.sdk.core.webview.d.b.a();
        try {
            aVar.parseJson(new JSONObject(str));
        } catch (JSONException e4) {
            com.kwad.sdk.core.e.c.printStackTrace(e4);
        }
        if (this.Wf.GN() && aVar.adTemplate == null) {
            cVar.onError(-1, "native adTemplate is null");
            return;
        }
        if (this.Wf.aDL && !aVar.aEN) {
            bn.runOnUiThread(new com.kwad.sdk.utils.ay() { // from class: com.kwad.components.core.webview.jshandler.x.1
                @Override // com.kwad.sdk.utils.ay
                public final void doTask() {
                    TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
                    com.kwad.sdk.core.webview.b bVar = x.this.Wf;
                    if (bVar.aDM) {
                        com.kwad.sdk.core.webview.d.b.a aVar2 = aVar;
                        AdTemplate adTemplate = aVar2.adTemplate;
                        if (adTemplate != null) {
                            x.this.Wv.add(new com.kwad.components.core.e.d.c(adTemplate));
                        } else if (aVar2.creativeId >= 0) {
                            List<AdTemplate> GM = bVar.GM();
                            com.kwad.sdk.core.webview.d.b.a aVar3 = aVar;
                            adTemplate = com.kwad.sdk.core.response.b.e.a(GM, aVar3.creativeId, aVar3.adStyle);
                        } else {
                            adTemplate = bVar.getAdTemplate();
                            aVar.creativeId = com.kwad.sdk.core.response.b.e.ea(adTemplate);
                            aVar.adStyle = com.kwad.sdk.core.response.b.e.dL(adTemplate);
                        }
                        com.kwad.components.core.e.d.c J = x.this.J(aVar.creativeId);
                        if (x.this.xB != null && J != null) {
                            J.setOnDismissListener(x.this.xB);
                        }
                        String str2 = null;
                        if (!TextUtils.isEmpty(aVar.KS)) {
                            try {
                                str2 = com.kwad.components.core.e.b.a.t(Long.parseLong(aVar.KS));
                            } catch (Exception unused) {
                                str2 = aVar.KS;
                            }
                        } else if (adTemplate != null && (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) != null) {
                            str2 = tKAdLiveShopItemInfo.itemId;
                        }
                        x.this.K(com.kwad.components.core.e.d.a.a(x.this.a(new a.C0631a(x.this.Wf.OE.getContext()).aq(adTemplate).b(J).af(str2).ao(x.a(x.this, aVar)).ap(x.this.Ws).c(x.this.Wf.mReportExtData).an(aVar.XC).al(aVar.aEM).am(aVar.kl).aq(x.this.Wt || aVar.KE).ar(x.this.Wr).al(x.this.Ww).as(x.this.Wu).aw(true).a(new a.b() { // from class: com.kwad.components.core.webview.jshandler.x.1.1
                            @Override // com.kwad.components.core.e.d.a.b
                            public final void onAdClicked() {
                                x.this.jh();
                                if (x.this.cR != null) {
                                    AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                                    if (aVar.aEO) {
                                        return;
                                    }
                                    x.this.cR.a(aVar);
                                }
                            }
                        }), aVar, adTemplate)));
                    }
                }
            });
        } else if (this.cR != null) {
            bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.x.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (x.this.cR == null || aVar.aEO) {
                        return;
                    }
                    x.this.cR.a(aVar);
                }
            });
        }
        cVar.a(null);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.xB = onDismissListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a.C0631a a(a.C0631a c0631a, com.kwad.sdk.core.webview.d.b.a aVar, AdTemplate adTemplate) {
        com.kwad.sdk.core.webview.d.b.c cVar;
        int i4;
        com.kwad.sdk.core.webview.d.b.c cVar2 = aVar.XD;
        if (cVar2 != null && !TextUtils.isEmpty(cVar2.KG)) {
            c0631a.ag(aVar.XD.KG);
        }
        com.kwad.sdk.core.webview.d.b.c cVar3 = aVar.XD;
        if (cVar3 != null && (i4 = cVar3.aEP) != 0) {
            c0631a.ap(i4);
        }
        if (aA(adTemplate) && (cVar = aVar.XD) != null && cVar.aEQ != null) {
            ac.a aVar2 = new ac.a();
            com.kwad.sdk.core.webview.d.b.b bVar = aVar.XD.aEQ;
            aVar2.g((float) bVar.f38656x, (float) bVar.f38657y);
            com.kwad.sdk.core.webview.d.b.b bVar2 = aVar.XD.aEQ;
            aVar2.f((float) bVar2.f38656x, (float) bVar2.f38657y);
            com.kwad.sdk.core.webview.d.b.b bVar3 = aVar.XD.aEQ;
            aVar2.z(bVar3.width, bVar3.height);
            c0631a.d(aVar2);
        } else {
            com.kwad.sdk.widget.e eVar = this.Wf.aDJ;
            if (eVar != null) {
                c0631a.d(eVar.getTouchCoords());
            }
        }
        c0631a.a(null, null, null);
        return c0631a;
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, cVar, aVar, false, 0, false, false);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, boolean z3) {
        this(bVar, cVar, aVar, false, 0, false, false);
        this.Wu = true;
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, int i4, boolean z3) {
        this(bVar, cVar, null, false, 2, z3, false);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable com.kwad.components.core.e.d.c cVar, @Nullable com.kwad.sdk.core.webview.d.a.a aVar, int i4) {
        this(bVar, cVar, aVar, false, 1, false, false);
    }

    public x(@NonNull com.kwad.sdk.core.webview.b bVar, @Nullable List<com.kwad.components.core.e.d.c> list, @Nullable com.kwad.sdk.core.webview.d.a.a aVar) {
        this(bVar, null, aVar, false, 0, false, false);
        if (list != null) {
            this.Wv.addAll(list);
        }
    }
}
