package com.bytedance.msdk.core.ev;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.sr.xv;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.c.w;
import com.bytedance.msdk.api.sr.c.r.gd;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.gd.a;
import com.bytedance.msdk.core.gd.bk;
import com.bytedance.msdk.core.gd.k;
import com.bytedance.msdk.core.p.sr;
import com.bytedance.msdk.f.fp;
import com.bytedance.msdk.f.fz;
import com.bytedance.msdk.f.i;
import com.bytedance.msdk.xv.r;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements gd, com.bytedance.msdk.api.sr.c.xv.c {

    /* renamed from: c  reason: collision with root package name */
    private ux f27920c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27921f = false;
    private InterfaceC0416c sr;
    private gd ux;

    /* renamed from: w  reason: collision with root package name */
    private w f27922w;
    private com.bytedance.msdk.api.sr.c.xv.w xv;

    /* renamed from: com.bytedance.msdk.core.ev.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0416c {
        void c();

        void c(com.bytedance.msdk.api.sr.c.xv.c cVar);
    }

    public c(ux uxVar, w wVar, InterfaceC0416c interfaceC0416c) {
        this.f27920c = uxVar;
        this.f27922w = wVar;
        this.sr = interfaceC0416c;
    }

    private void eq() {
        if (this.f27920c.isExpressAd()) {
            this.f27920c.setGMDrawAdListener(new com.bytedance.msdk.api.sr.c.xv.ux() { // from class: com.bytedance.msdk.core.ev.c.1
                @Override // com.bytedance.msdk.api.sr.c.xv.ux
                public void c(View view, String str, int i4) {
                    if (c.this.xv instanceof com.bytedance.msdk.api.sr.c.xv.ux) {
                        ((com.bytedance.msdk.api.sr.c.xv.ux) c.this.xv).c(view, str, i4);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.xv.w
                public void w() {
                    c.this.f27921f = true;
                    if (c.this.xv != null) {
                        c.this.xv.w();
                    }
                    if (c.this.f27922w != null && c.this.f27920c != null) {
                        xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(c.this.f27922w.u(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + c.this.f27920c.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(c.this.f27920c.getAdNetworkPlatformId()));
                        bk c4 = bk.c();
                        StringBuilder sb = new StringBuilder();
                        sb.append(c.this.f27922w.u());
                        sb.append("");
                        c4.r(sb.toString());
                        bk c5 = bk.c();
                        c5.w(c.this.f27922w.u() + "");
                        k c6 = k.c();
                        c6.w(c.this.f27922w.u() + "", c.this.f27920c.getAdNetworkSlotId());
                        a c7 = a.c();
                        c7.w(c.this.f27922w.u() + "", c.this.f27920c.getAdNetworkSlotId());
                        com.bytedance.msdk.core.xv.xv.c(c.this.f27920c.getAdnName(), c.this.f27922w.u(), c.this.f27920c.getAdNetworkSlotId());
                    }
                    c.this.sr.c(c.this);
                    String str = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = -1;
                    if (i.c(c.this.f27920c)) {
                        str = i.w(Thread.currentThread().getStackTrace());
                        j4 = System.currentTimeMillis() - currentTimeMillis;
                    }
                    String str2 = str;
                    long j5 = j4;
                    boolean isShowListenRepeatOnce = c.this.f27920c.isShowListenRepeatOnce();
                    if (!isShowListenRepeatOnce) {
                        com.bytedance.msdk.core.w.c.r(c.this.f27922w.u());
                        com.bytedance.msdk.core.w.c.xv(c.this.f27922w.u());
                        sr.c(1, c.this.f27922w.u(), c.this.f27920c.getAdType(), c.this.f27920c.getCpm());
                    }
                    r.c(c.this.f27920c, c.this.f27922w, 0, str2, j5, isShowListenRepeatOnce);
                    com.bytedance.msdk.core.r.r.c(c.this.f27922w != null ? c.this.f27922w.u() : "", c.this.f27920c);
                }

                @Override // com.bytedance.msdk.api.sr.c.xv.ux
                public void c(float f4, float f5) {
                    if (c.this.xv instanceof com.bytedance.msdk.api.sr.c.xv.ux) {
                        ((com.bytedance.msdk.api.sr.c.xv.ux) c.this.xv).c(f4, f5);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.xv.w
                public void c() {
                    if (c.this.xv != null) {
                        c.this.xv.c();
                    }
                    String str = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = -1;
                    if (i.c(c.this.f27920c)) {
                        str = i.w(Thread.currentThread().getStackTrace());
                        j4 = System.currentTimeMillis() - currentTimeMillis;
                    }
                    com.bytedance.msdk.core.w.c.ux(c.this.f27922w.u());
                    r.w(c.this.f27920c, c.this.f27922w, 0, str, j4, c.this.f27920c.isClickListenRepeatOnce());
                }
            });
        } else {
            this.f27920c.setGMDrawAdListener(new com.bytedance.msdk.api.sr.c.xv.w() { // from class: com.bytedance.msdk.core.ev.c.2
                @Override // com.bytedance.msdk.api.sr.c.xv.w
                public void c() {
                    if (c.this.xv != null) {
                        c.this.xv.c();
                    }
                    String str = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = -1;
                    if (i.c(c.this.f27920c)) {
                        str = i.w(Thread.currentThread().getStackTrace());
                        j4 = System.currentTimeMillis() - currentTimeMillis;
                    }
                    com.bytedance.msdk.core.w.c.ux(c.this.f27922w.u());
                    r.w(c.this.f27920c, c.this.f27922w, 0, str, j4, c.this.f27920c.isClickListenRepeatOnce());
                }

                @Override // com.bytedance.msdk.api.sr.c.xv.w
                public void w() {
                    c.this.f27921f = true;
                    if (c.this.xv != null) {
                        c.this.xv.w();
                    }
                    if (c.this.f27922w != null && c.this.f27920c != null) {
                        xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(c.this.f27922w.u(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + c.this.f27920c.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(c.this.f27920c.getAdNetworkPlatformId()));
                        bk c4 = bk.c();
                        StringBuilder sb = new StringBuilder();
                        sb.append(c.this.f27922w.u());
                        sb.append("");
                        c4.r(sb.toString());
                        bk c5 = bk.c();
                        c5.w(c.this.f27922w.u() + "");
                        k c6 = k.c();
                        c6.w(c.this.f27922w.u() + "", c.this.f27920c.getAdNetworkSlotId());
                        a c7 = a.c();
                        c7.w(c.this.f27922w.u() + "", c.this.f27920c.getAdNetworkSlotId());
                        com.bytedance.msdk.core.xv.xv.c(c.this.f27920c.getAdnName(), c.this.f27922w.u(), c.this.f27920c.getAdNetworkSlotId());
                    }
                    c.this.sr.c(c.this);
                    String str = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = -1;
                    if (i.c(c.this.f27920c)) {
                        str = i.w(Thread.currentThread().getStackTrace());
                        j4 = System.currentTimeMillis() - currentTimeMillis;
                    }
                    String str2 = str;
                    long j5 = j4;
                    boolean isShowListenRepeatOnce = c.this.f27920c.isShowListenRepeatOnce();
                    if (!isShowListenRepeatOnce) {
                        com.bytedance.msdk.core.w.c.r(c.this.f27922w.u());
                        com.bytedance.msdk.core.w.c.xv(c.this.f27922w.u());
                        sr.c(1, c.this.f27922w.u(), c.this.f27920c.getAdType(), c.this.f27920c.getCpm());
                    }
                    r.c(c.this.f27920c, c.this.f27922w, 0, str2, j5, isShowListenRepeatOnce);
                    com.bytedance.msdk.core.r.r.c(c.this.f27922w != null ? c.this.f27922w.u() : "", c.this.f27920c);
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public List<String> a() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getImages();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public com.bytedance.msdk.api.sr.c.r.w ba() {
        ux uxVar = this.f27920c;
        if (uxVar == null || !uxVar.hasAppInfo()) {
            return null;
        }
        com.bytedance.msdk.api.sr.c.r.w wVar = new com.bytedance.msdk.api.sr.c.r.w();
        wVar.w(this.f27920c.getAppName());
        wVar.xv(this.f27920c.getAuthorName());
        wVar.c(this.f27920c.getPackageSizeBytes());
        wVar.sr(this.f27920c.getPermissionsUrl());
        wVar.ux(this.f27920c.getPrivacyAgreement());
        wVar.f(this.f27920c.getVersionName());
        wVar.c(this.f27920c.getPermissionsMap());
        wVar.w(this.f27920c.getAppInfoExtra());
        wVar.c(this.f27920c.getFunctionDescUrl());
        return wVar;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public String bk() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getSource();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public void ck() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            uxVar.onResume();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public int ev() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getImageHeight();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public String f() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getImageUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    @Nullable
    public com.bytedance.msdk.api.xv fp() {
        if (this.f27920c != null && com.bytedance.msdk.core.c.w().fz()) {
            return fp.c(this.f27922w, this.f27920c, false);
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public Map<String, Object> fz() {
        ux uxVar = this.f27920c;
        Map<String, Object> mediaExtraInfo = uxVar != null ? uxVar.getMediaExtraInfo() : null;
        if (mediaExtraInfo == null) {
            w wVar = this.f27922w;
            mediaExtraInfo = com.bytedance.msdk.core.r.ux.f(wVar != null ? wVar.u() : "");
        }
        if (this.f27921f && fz.c()) {
            String c4 = fz.c(fp.c(this.f27922w, this.f27920c, true));
            if (!TextUtils.isEmpty(c4)) {
                mediaExtraInfo.put("get_show_ecpm_info", c4);
            }
        }
        return mediaExtraInfo;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public boolean gb() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.hasDislike();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public String gd() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getActionText();
        }
        return null;
    }

    @Override // com.bytedance.msdk.c.xv
    public ev getDislikeDialog(Activity activity) {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getDislikeDialog(activity);
        }
        return null;
    }

    @Override // com.bytedance.msdk.c.xv
    public com.bytedance.sdk.openadsdk.ys.w.w.sr getDislikeInfo() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getDislikeInfo();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.gd
    public void gw() {
        gd gdVar = this.ux;
        if (gdVar != null) {
            gdVar.gw();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public int i() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public int ia() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getImageMode();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public void j() {
        if (this.f27920c != null) {
            eq();
            this.f27920c.render();
            c(this.f27920c);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public double k() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getStarRating();
        }
        return 0.0d;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public boolean ls() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.isExpressAd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.gd
    public void m() {
        gd gdVar = this.ux;
        if (gdVar != null) {
            gdVar.m();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public void n() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            uxVar.onPause();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public View p() {
        r.c(this.f27922w, fp.c(this.f27920c));
        ux uxVar = this.f27920c;
        if (uxVar != null && uxVar.isExpressAd()) {
            InterfaceC0416c interfaceC0416c = this.sr;
            if (interfaceC0416c != null) {
                interfaceC0416c.c();
            }
            ux uxVar2 = this.f27920c;
            r.c(uxVar2, this.f27922w, uxVar2.isShowRepeatOnce(), 0);
            return this.f27920c.getAdView();
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.f27920c);
        r.c(arrayList, this.f27922w, 0);
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public boolean q() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.canAdReuse();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public int r() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getImageWidth();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public int s() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getInteractionType();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.c.xv
    public void setDislikeCallback(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            uxVar.setDislikeCallback(activity, cVar);
        }
    }

    @Override // com.bytedance.msdk.c.xv
    public void setDislikeDialog(Dialog dialog) {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            uxVar.setDislikeDialog(dialog);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public String t() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getAdNetworkSlotId();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public int u() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.c.xv
    public void uploadDislikeEvent(String str) {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            uxVar.uploadDislikeEvent(str);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public String ux() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getIconUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.gd
    public void vc() {
        gd gdVar = this.ux;
        if (gdVar != null) {
            gdVar.vc();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.gd
    public void x() {
        gd gdVar = this.ux;
        if (gdVar != null) {
            gdVar.x();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public Map<String, Object> y() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getExtraMsg();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    @Nullable
    public com.bytedance.msdk.api.xv ys() {
        if (this.f27920c == null || !this.f27921f || fz.c()) {
            return null;
        }
        return fp.c(this.f27922w, this.f27920c, true);
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public void z() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            try {
                uxVar.onDestroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public String sr() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getAdDescription();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public ux w() {
        return this.f27920c;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public String xv() {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getAdTitle();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public void c(boolean z3) {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            uxVar.setUseCustomVideo(z3);
        }
    }

    @Override // com.bytedance.msdk.c.xv
    public ev getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            return uxVar.getDislikeDialog(tTDislikeDialogAbstract);
        }
        return null;
    }

    public void w(boolean z3) {
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            uxVar.setHasShown(z3);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public boolean c() {
        w wVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f27920c);
        r.c(arrayList, (List<ux>) null, (List<ux>) null, this.f27922w, fp.c(this.f27920c), 0);
        ux uxVar = this.f27920c;
        if (uxVar == null || (wVar = this.f27922w) == null) {
            return false;
        }
        return uxVar.isReady(wVar.u());
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public void c(com.bytedance.msdk.api.sr.c.xv.w wVar) {
        this.xv = wVar;
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public void c(gd gdVar) {
        this.ux = gdVar;
        ux uxVar = this.f27920c;
        if (uxVar != null) {
            uxVar.setTTVideoListener(this);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.xv.c
    public void c(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, com.bytedance.msdk.api.sr.c.r.k kVar) {
        r.c(this.f27922w, fp.c(this.f27920c));
        if (this.f27920c != null) {
            eq();
            this.f27920c.registerViewForInteraction(activity, viewGroup, list, list2, null, kVar);
            InterfaceC0416c interfaceC0416c = this.sr;
            if (interfaceC0416c != null) {
                interfaceC0416c.c();
            }
            c(this.f27920c);
            ux uxVar = this.f27920c;
            r.c(uxVar, this.f27922w, uxVar.isShowRepeatOnce(), 0);
            return;
        }
        r.c((List<ux>) null, this.f27922w, 0);
    }

    @Override // com.bytedance.msdk.api.sr.c.r.gd
    public void c(com.bytedance.msdk.api.c cVar) {
        String str;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        if (i.c(this.f27920c)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j4 = -1;
        }
        r.c(this.f27920c, this.f27922w, (com.bytedance.msdk.api.c) null, 2, 0, str, j4);
        gd gdVar = this.ux;
        if (gdVar != null) {
            gdVar.c(cVar);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.gd
    public void c(long j4, long j5) {
        gd gdVar = this.ux;
        if (gdVar != null) {
            gdVar.c(j4, j5);
        }
    }

    public void c(ux uxVar) {
        if (com.bytedance.msdk.core.c.w().ck()) {
            r.c(uxVar, this.f27922w, i.c(Thread.currentThread().getStackTrace()), 2);
        }
    }
}
