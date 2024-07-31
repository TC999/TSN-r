package com.kwad.components.core.webview.jshandler;

import android.content.DialogInterface;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p291b.C8596a;
import com.kwad.components.core.p289e.p293d.C8615a;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.model.TKAdLiveShopItemInfo;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;
import com.kwad.sdk.core.webview.p423d.p424a.InterfaceC10635a;
import com.kwad.sdk.core.webview.p423d.p425b.C10640a;
import com.kwad.sdk.core.webview.p423d.p425b.C10641b;
import com.kwad.sdk.core.webview.p423d.p425b.C10642c;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11008ac;
import com.kwad.sdk.utils.C11064bn;
import com.kwad.sdk.widget.InterfaceC11147e;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.kwad.components.core.webview.jshandler.x */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9185x implements InterfaceC10625a {

    /* renamed from: Wf */
    protected final C10605b f29270Wf;

    /* renamed from: Wr */
    private int f29271Wr;

    /* renamed from: Ws */
    private boolean f29272Ws;

    /* renamed from: Wt */
    private final boolean f29273Wt;

    /* renamed from: Wu */
    private boolean f29274Wu;

    /* renamed from: Wv */
    private List<C8619c> f29275Wv;

    /* renamed from: Ww */
    private boolean f29276Ww;
    @Nullable

    /* renamed from: cR */
    private InterfaceC10635a f29277cR;
    @Nullable

    /* renamed from: xB */
    private DialogInterface.OnDismissListener f29278xB;

    public C9185x(@NonNull C10605b c10605b, @Nullable C8619c c8619c, @Nullable InterfaceC10635a interfaceC10635a, boolean z, int i, boolean z2, boolean z3) {
        this.f29272Ws = false;
        this.f29275Wv = new ArrayList();
        this.f29272Ws = z;
        this.f29270Wf = c10605b;
        this.f29271Wr = i;
        if (c8619c != null) {
            c8619c.m30152as(1);
            this.f29275Wv.add(c8619c);
        }
        this.f29277cR = interfaceC10635a;
        this.f29273Wt = z2;
        this.f29276Ww = z3;
    }

    /* renamed from: aA */
    private static boolean m29204aA(AdTemplate adTemplate) {
        return C10487e.m25646dL(adTemplate) == 13;
    }

    @Nullable
    /* renamed from: J */
    protected final C8619c m29209J(long j) {
        List<C8619c> list = this.f29275Wv;
        if (list == null) {
            return null;
        }
        if (j < 0 && list.size() == 1) {
            return this.f29275Wv.get(0);
        }
        for (C8619c c8619c : this.f29275Wv) {
            if (C10487e.m25631ea(c8619c.m30137oc()) == j) {
                return c8619c;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: K */
    public void mo29208K(int i) {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "clickAction";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: jh */
    public void mo29195jh() {
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29277cR = null;
    }

    /* renamed from: a */
    static /* synthetic */ boolean m29205a(C9185x c9185x, C10640a c10640a) {
        return m29202b(c10640a);
    }

    /* renamed from: b */
    private static boolean m29202b(C10640a c10640a) {
        return c10640a.f29644XC == 1;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        final C10640a c10640a = new C10640a();
        try {
            c10640a.parseJson(new JSONObject(str));
        } catch (JSONException e) {
            C10331c.printStackTrace(e);
        }
        if (this.f29270Wf.m25325GN() && c10640a.adTemplate == null) {
            interfaceC10627c.onError(-1, "native adTemplate is null");
            return;
        }
        if (this.f29270Wf.aDL && !c10640a.aEN) {
            C11064bn.runOnUiThread(new AbstractRunnableC11033ay() { // from class: com.kwad.components.core.webview.jshandler.x.1
                @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
                public final void doTask() {
                    TKAdLiveShopItemInfo tKAdLiveShopItemInfo;
                    C10605b c10605b = C9185x.this.f29270Wf;
                    if (c10605b.aDM) {
                        C10640a c10640a2 = c10640a;
                        AdTemplate adTemplate = c10640a2.adTemplate;
                        if (adTemplate != null) {
                            C9185x.this.f29275Wv.add(new C8619c(adTemplate));
                        } else if (c10640a2.creativeId >= 0) {
                            List<AdTemplate> m25326GM = c10605b.m25326GM();
                            C10640a c10640a3 = c10640a;
                            adTemplate = C10487e.m25652a(m25326GM, c10640a3.creativeId, c10640a3.adStyle);
                        } else {
                            adTemplate = c10605b.getAdTemplate();
                            c10640a.creativeId = C10487e.m25631ea(adTemplate);
                            c10640a.adStyle = C10487e.m25646dL(adTemplate);
                        }
                        C8619c m29209J = C9185x.this.m29209J(c10640a.creativeId);
                        if (C9185x.this.f29278xB != null && m29209J != null) {
                            m29209J.setOnDismissListener(C9185x.this.f29278xB);
                        }
                        String str2 = null;
                        if (!TextUtils.isEmpty(c10640a.f29641KS)) {
                            try {
                                str2 = C8596a.m30285t(Long.parseLong(c10640a.f29641KS));
                            } catch (Exception unused) {
                                str2 = c10640a.f29641KS;
                            }
                        } else if (adTemplate != null && (tKAdLiveShopItemInfo = adTemplate.tkLiveShopItemInfo) != null) {
                            str2 = tKAdLiveShopItemInfo.itemId;
                        }
                        C9185x.this.mo29208K(C8615a.m30233a(C9185x.this.mo29207a(new C8615a.C8616a(C9185x.this.f29270Wf.f29621OE.getContext()).m30198aq(adTemplate).m30189b(m29209J).m30213af(str2).m30202ao(C9185x.m29205a(C9185x.this, c10640a)).m30200ap(C9185x.this.f29272Ws).m30188c(C9185x.this.f29270Wf.mReportExtData).m30205an(c10640a.f29644XC).m30209al(c10640a.aEM).m30207am(c10640a.f29646kl).m30197aq(C9185x.this.f29273Wt || c10640a.f29640KE).m30196ar(C9185x.this.f29271Wr).m30208al(C9185x.this.f29276Ww).m30194as(C9185x.this.f29274Wu).m30190aw(true).m30216a(new C8615a.InterfaceC8617b() { // from class: com.kwad.components.core.webview.jshandler.x.1.1
                            @Override // com.kwad.components.core.p289e.p293d.C8615a.InterfaceC8617b
                            public final void onAdClicked() {
                                C9185x.this.mo29195jh();
                                if (C9185x.this.f29277cR != null) {
                                    C91861 c91861 = C91861.this;
                                    if (c10640a.aEO) {
                                        return;
                                    }
                                    C9185x.this.f29277cR.mo25245a(c10640a);
                                }
                            }
                        }), c10640a, adTemplate)));
                    }
                }
            });
        } else if (this.f29277cR != null) {
            C11064bn.postOnUiThread(new Runnable() { // from class: com.kwad.components.core.webview.jshandler.x.2
                @Override // java.lang.Runnable
                public final void run() {
                    if (C9185x.this.f29277cR == null || c10640a.aEO) {
                        return;
                    }
                    C9185x.this.f29277cR.mo25245a(c10640a);
                }
            });
        }
        interfaceC10627c.mo25251a(null);
    }

    public C9185x(@NonNull C10605b c10605b, @Nullable C8619c c8619c, @Nullable InterfaceC10635a interfaceC10635a, @Nullable DialogInterface.OnDismissListener onDismissListener) {
        this(c10605b, c8619c, interfaceC10635a, false, 0, false, false);
        this.f29278xB = onDismissListener;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: a */
    public C8615a.C8616a mo29207a(C8615a.C8616a c8616a, C10640a c10640a, AdTemplate adTemplate) {
        C10642c c10642c;
        int i;
        C10642c c10642c2 = c10640a.f29645XD;
        if (c10642c2 != null && !TextUtils.isEmpty(c10642c2.f29649KG)) {
            c8616a.m30212ag(c10640a.f29645XD.f29649KG);
        }
        C10642c c10642c3 = c10640a.f29645XD;
        if (c10642c3 != null && (i = c10642c3.aEP) != 0) {
            c8616a.m30201ap(i);
        }
        if (m29204aA(adTemplate) && (c10642c = c10640a.f29645XD) != null && c10642c.aEQ != null) {
            C11008ac.C11009a c11009a = new C11008ac.C11009a();
            C10641b c10641b = c10640a.f29645XD.aEQ;
            c11009a.m24147g((float) c10641b.f29647x, (float) c10641b.f29648y);
            C10641b c10641b2 = c10640a.f29645XD.aEQ;
            c11009a.m24148f((float) c10641b2.f29647x, (float) c10641b2.f29648y);
            C10641b c10641b3 = c10640a.f29645XD.aEQ;
            c11009a.m24146z(c10641b3.width, c10641b3.height);
            c8616a.m30185d(c11009a);
        } else {
            InterfaceC11147e interfaceC11147e = this.f29270Wf.aDJ;
            if (interfaceC11147e != null) {
                c8616a.m30185d(interfaceC11147e.getTouchCoords());
            }
        }
        c8616a.m30215a(null, null, null);
        return c8616a;
    }

    public C9185x(@NonNull C10605b c10605b, @Nullable C8619c c8619c, @Nullable InterfaceC10635a interfaceC10635a) {
        this(c10605b, c8619c, interfaceC10635a, false, 0, false, false);
    }

    public C9185x(@NonNull C10605b c10605b, @Nullable C8619c c8619c, @Nullable InterfaceC10635a interfaceC10635a, boolean z) {
        this(c10605b, c8619c, interfaceC10635a, false, 0, false, false);
        this.f29274Wu = true;
    }

    public C9185x(@NonNull C10605b c10605b, @Nullable C8619c c8619c, @Nullable InterfaceC10635a interfaceC10635a, int i, boolean z) {
        this(c10605b, c8619c, null, false, 2, z, false);
    }

    public C9185x(@NonNull C10605b c10605b, @Nullable C8619c c8619c, @Nullable InterfaceC10635a interfaceC10635a, int i) {
        this(c10605b, c8619c, interfaceC10635a, false, 1, false, false);
    }

    public C9185x(@NonNull C10605b c10605b, @Nullable List<C8619c> list, @Nullable InterfaceC10635a interfaceC10635a) {
        this(c10605b, null, interfaceC10635a, false, 0, false, false);
        if (list != null) {
            this.f29275Wv.addAll(list);
        }
    }
}
