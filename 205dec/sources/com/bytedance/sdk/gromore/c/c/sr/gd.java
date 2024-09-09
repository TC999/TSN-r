package com.bytedance.sdk.gromore.c.c.sr;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd extends com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c {

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.msdk.api.sr.c.r.c f31181c;

    public gd(com.bytedance.msdk.api.sr.c.r.c cVar) {
        this.f31181c = cVar;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public boolean a() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.ck();
        }
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public com.bytedance.sdk.openadsdk.ys.w.w.sr bk() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.getDislikeInfo();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String c() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.ux();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String ev() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.ys();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public double f() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.bk();
        }
        return 0.0d;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public int gd() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.fz();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.sr k() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar == null || cVar.yu() == null) {
            return null;
        }
        return new com.bytedance.sdk.gromore.c.c.c.f(this.f31181c.yu());
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public int p() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.u();
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public List<String> r() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.t();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String sr() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.ev();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String ux() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.k();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String w() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.ux();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public String xv() {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.r();
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public void c(Activity activity, ViewGroup viewGroup, List<View> list, List<View> list2, List<View> list3, com.bytedance.sdk.openadsdk.mediation.ad.c.w.c.sr srVar) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            cVar.c(activity, viewGroup, list, list2, list3, com.bytedance.msdk.api.sr.c.r.k.c(srVar));
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public com.bytedance.sdk.openadsdk.ys.w.w.ev w(Activity activity) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.getDislikeDialog(activity);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.xv c(Activity activity) {
        com.bytedance.msdk.api.sr.c.r.c cVar;
        if (activity == null || (cVar = this.f31181c) == null) {
            return null;
        }
        return new com.bytedance.sdk.gromore.c.c.c.ux(c(activity, cVar));
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public com.bytedance.sdk.openadsdk.ys.w.w.ev w(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            return cVar.getDislikeDialog(tTDislikeDialogAbstract);
        }
        return null;
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.xv c(Activity activity, Map<String, Object> map) {
        com.bytedance.msdk.api.sr.c.r.c cVar;
        if (activity == null || map == null || (cVar = this.f31181c) == null) {
            return null;
        }
        return new com.bytedance.sdk.gromore.c.c.c.ux(c(activity, cVar));
    }

    private com.bytedance.msdk.api.sr.w c(Activity activity, com.bytedance.msdk.api.sr.c.r.c cVar) {
        final com.bytedance.sdk.openadsdk.ys.w.w.ev dislikeDialog = cVar.getDislikeDialog(activity);
        return new com.bytedance.msdk.api.sr.w() { // from class: com.bytedance.sdk.gromore.c.c.sr.gd.1
            @Override // com.bytedance.msdk.api.sr.w
            public void c() {
                com.bytedance.sdk.openadsdk.ys.w.w.ev evVar = dislikeDialog;
                if (evVar != null) {
                    evVar.c();
                }
            }

            @Override // com.bytedance.msdk.api.sr.w
            public void c(final com.bytedance.msdk.api.sr.r rVar) {
                com.bytedance.sdk.openadsdk.ys.w.w.ev evVar = dislikeDialog;
                if (evVar != null) {
                    evVar.c(new com.bytedance.sdk.openadsdk.s.c.w.c.c(null) { // from class: com.bytedance.sdk.gromore.c.c.sr.gd.1.1
                        @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                        public void onCancel() {
                            com.bytedance.msdk.api.sr.r rVar2 = rVar;
                            if (rVar2 != null) {
                                rVar2.c();
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                        public void onSelected(int i4, String str, boolean z3) {
                            com.bytedance.msdk.api.sr.r rVar2 = rVar;
                            if (rVar2 != null) {
                                rVar2.c(i4, str);
                            }
                        }

                        @Override // com.bytedance.sdk.openadsdk.s.c.w.c.c
                        public void onShow() {
                            com.bytedance.msdk.api.sr.r rVar2 = rVar;
                            if (rVar2 != null) {
                                rVar2.w();
                            }
                        }
                    });
                }
            }
        };
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public void c(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        com.bytedance.msdk.api.sr.c.r.c cVar2 = this.f31181c;
        if (cVar2 != null) {
            cVar2.setDislikeCallback(activity, cVar);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.mediation.ad.c.w.w.c
    public void c(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        com.bytedance.msdk.api.sr.c.r.c cVar = this.f31181c;
        if (cVar != null) {
            cVar.setDislikeDialog(tTDislikeDialogAbstract);
        }
    }
}
