package com.bytedance.msdk.core.a;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bytedance.msdk.adapter.util.TTLogUtil;
import com.bytedance.msdk.api.sr.c.r.f;
import com.bytedance.msdk.api.sr.c.r.gd;
import com.bytedance.msdk.api.sr.c.r.p;
import com.bytedance.msdk.api.sr.c.r.r;
import com.bytedance.msdk.api.sr.c.r.xv;
import com.bytedance.msdk.api.sr.c.w;
import com.bytedance.msdk.c.ux;
import com.bytedance.msdk.core.gd.a;
import com.bytedance.msdk.core.gd.bk;
import com.bytedance.msdk.core.gd.k;
import com.bytedance.msdk.core.p.sr;
import com.bytedance.msdk.f.fp;
import com.bytedance.msdk.f.fz;
import com.bytedance.msdk.f.i;
import com.bytedance.sdk.openadsdk.TTDislikeDialogAbstract;
import com.bytedance.sdk.openadsdk.ys.w.w.ev;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c implements com.bytedance.msdk.api.sr.c.r.c, gd, w {

    /* renamed from: c  reason: collision with root package name */
    private ux f27689c;

    /* renamed from: f  reason: collision with root package name */
    private boolean f27690f = false;

    /* renamed from: r  reason: collision with root package name */
    private w f27691r;
    private InterfaceC0408c sr;
    private gd ux;

    /* renamed from: w  reason: collision with root package name */
    private com.bytedance.msdk.api.c.w f27692w;
    private xv xv;

    /* renamed from: com.bytedance.msdk.core.a.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0408c {
        void c();

        void c(com.bytedance.msdk.api.sr.c.r.c cVar);
    }

    public c(ux uxVar, com.bytedance.msdk.api.c.w wVar, InterfaceC0408c interfaceC0408c) {
        this.f27689c = uxVar;
        this.f27692w = wVar;
        this.sr = interfaceC0408c;
    }

    private void up() {
        if (this.f27689c.isExpressAd()) {
            this.f27689c.setTTNativeAdListener(new r() { // from class: com.bytedance.msdk.core.a.c.1
                @Override // com.bytedance.msdk.api.sr.c.r.r
                public void c(View view, String str, int i4) {
                    if (c.this.xv instanceof r) {
                        ((r) c.this.xv).c(view, str, i4);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.xv
                public void w() {
                    c.this.f27690f = true;
                    if (c.this.xv != null) {
                        c.this.xv.w();
                    }
                    if (c.this.f27692w != null && c.this.f27689c != null) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(c.this.f27692w.u(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + c.this.f27689c.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(c.this.f27689c.getAdNetworkPlatformId()));
                        bk c4 = bk.c();
                        StringBuilder sb = new StringBuilder();
                        sb.append(c.this.f27692w.u());
                        sb.append("");
                        c4.r(sb.toString());
                        bk c5 = bk.c();
                        c5.w(c.this.f27692w.u() + "");
                        k c6 = k.c();
                        c6.w(c.this.f27692w.u() + "", c.this.f27689c.getAdNetworkSlotId());
                        a c7 = a.c();
                        c7.w(c.this.f27692w.u() + "", c.this.f27689c.getAdNetworkSlotId());
                        com.bytedance.msdk.core.xv.xv.c(c.this.f27689c.getAdnName(), c.this.f27692w.u(), c.this.f27689c.getAdNetworkSlotId());
                    }
                    c.this.sr.c(c.this);
                    String str = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = -1;
                    if (i.c(c.this.f27689c)) {
                        str = i.w(Thread.currentThread().getStackTrace());
                        j4 = System.currentTimeMillis() - currentTimeMillis;
                    }
                    String str2 = str;
                    long j5 = j4;
                    boolean isShowListenRepeatOnce = c.this.f27689c.isShowListenRepeatOnce();
                    if (!isShowListenRepeatOnce) {
                        com.bytedance.msdk.core.w.c.r(c.this.f27692w.u());
                        com.bytedance.msdk.core.w.c.xv(c.this.f27692w.u());
                        sr.c(1, c.this.f27692w.u(), c.this.f27689c.getAdType(), c.this.f27689c.getCpm());
                    }
                    com.bytedance.msdk.xv.r.c(c.this.f27689c, c.this.f27692w, 0, str2, j5, isShowListenRepeatOnce);
                    com.bytedance.msdk.core.r.r.c(c.this.f27692w != null ? c.this.f27692w.u() : "", c.this.f27689c);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.r
                public void c(float f4, float f5) {
                    if (c.this.xv instanceof r) {
                        ((r) c.this.xv).c(f4, f5);
                    }
                }

                @Override // com.bytedance.msdk.api.sr.c.r.xv
                public void c() {
                    if (c.this.xv != null) {
                        c.this.xv.c();
                    }
                    String str = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = -1;
                    if (i.c(c.this.f27689c)) {
                        str = i.w(Thread.currentThread().getStackTrace());
                        j4 = System.currentTimeMillis() - currentTimeMillis;
                    }
                    com.bytedance.msdk.core.w.c.ux(c.this.f27692w.u());
                    com.bytedance.msdk.xv.r.w(c.this.f27689c, c.this.f27692w, 0, str, j4, c.this.f27689c.isClickListenRepeatOnce());
                }
            });
        } else {
            this.f27689c.setTTNativeAdListener(new xv() { // from class: com.bytedance.msdk.core.a.c.2
                @Override // com.bytedance.msdk.api.sr.c.r.xv
                public void c() {
                    if (c.this.xv != null) {
                        c.this.xv.c();
                    }
                    String str = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = -1;
                    if (i.c(c.this.f27689c)) {
                        str = i.w(Thread.currentThread().getStackTrace());
                        j4 = System.currentTimeMillis() - currentTimeMillis;
                    }
                    com.bytedance.msdk.core.w.c.ux(c.this.f27692w.u());
                    com.bytedance.msdk.xv.r.w(c.this.f27689c, c.this.f27692w, 0, str, j4, c.this.f27689c.isClickListenRepeatOnce());
                }

                @Override // com.bytedance.msdk.api.sr.c.r.xv
                public void w() {
                    c.this.f27690f = true;
                    if (c.this.xv != null) {
                        c.this.xv.w();
                    }
                    if (c.this.f27692w != null && c.this.f27689c != null) {
                        com.bytedance.msdk.adapter.sr.xv.c("TTMediationSDK", com.bytedance.msdk.adapter.sr.ux.c(c.this.f27692w.u(), TTLogUtil.TAG_EVENT_SHOW_LISTEN) + "adSlotId\uff1a" + c.this.f27689c.getAdNetworkSlotId() + "\uff0c\u5e7f\u544a\u7c7b\u578b\uff1a" + com.bytedance.msdk.c.c.c(c.this.f27689c.getAdNetworkPlatformId()));
                        bk c4 = bk.c();
                        StringBuilder sb = new StringBuilder();
                        sb.append(c.this.f27692w.u());
                        sb.append("");
                        c4.r(sb.toString());
                        bk c5 = bk.c();
                        c5.w(c.this.f27692w.u() + "");
                        k c6 = k.c();
                        c6.w(c.this.f27692w.u() + "", c.this.f27689c.getAdNetworkSlotId());
                        a c7 = a.c();
                        c7.w(c.this.f27692w.u() + "", c.this.f27689c.getAdNetworkSlotId());
                        com.bytedance.msdk.core.xv.xv.c(c.this.f27689c.getAdnName(), c.this.f27692w.u(), c.this.f27689c.getAdNetworkSlotId());
                    }
                    c.this.sr.c(c.this);
                    String str = null;
                    long currentTimeMillis = System.currentTimeMillis();
                    long j4 = -1;
                    if (i.c(c.this.f27689c)) {
                        str = i.w(Thread.currentThread().getStackTrace());
                        j4 = System.currentTimeMillis() - currentTimeMillis;
                    }
                    String str2 = str;
                    long j5 = j4;
                    boolean isShowListenRepeatOnce = c.this.f27689c.isShowListenRepeatOnce();
                    if (!isShowListenRepeatOnce) {
                        com.bytedance.msdk.core.w.c.r(c.this.f27692w.u());
                        com.bytedance.msdk.core.w.c.xv(c.this.f27692w.u());
                        sr.c(1, c.this.f27692w.u(), c.this.f27689c.getAdType(), c.this.f27689c.getCpm());
                    }
                    com.bytedance.msdk.xv.r.c(c.this.f27689c, c.this.f27692w, 0, str2, j5, isShowListenRepeatOnce);
                    com.bytedance.msdk.core.r.r.c(c.this.f27692w != null ? c.this.f27692w.u() : "", c.this.f27689c);
                }
            });
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public View a() {
        com.bytedance.msdk.xv.r.c(this.f27692w, fp.c(this.f27689c));
        ux uxVar = this.f27689c;
        if (uxVar != null && uxVar.isExpressAd()) {
            InterfaceC0408c interfaceC0408c = this.sr;
            if (interfaceC0408c != null) {
                interfaceC0408c.c();
            }
            ux uxVar2 = this.f27689c;
            com.bytedance.msdk.xv.r.c(uxVar2, this.f27692w, uxVar2.isShowRepeatOnce(), 0);
            return this.f27689c.getAdView();
        }
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(this.f27689c);
        com.bytedance.msdk.xv.r.c(arrayList, this.f27692w, 0);
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void ba() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.resumeAppDownload();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public double bk() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getStarRating();
        }
        return 0.0d;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public Map<String, Object> bw() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getExtraMsg();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public boolean ck() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.hasDislike();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public int eq() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getDownloadStatus();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public String ev() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getImageUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public String f() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getAdDescription();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public String fp() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getAdNetworkSlotId();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public int fz() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getImageMode();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void gb() {
        if (this.f27689c != null) {
            up();
            this.f27689c.render();
            c(this.f27689c);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public int gd() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getImageWidth();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.c.xv
    public ev getDislikeDialog(Activity activity) {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getDislikeDialog(activity);
        }
        return null;
    }

    @Override // com.bytedance.msdk.c.xv
    public com.bytedance.sdk.openadsdk.ys.w.w.sr getDislikeInfo() {
        ux uxVar = this.f27689c;
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

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public Map<String, Object> i() {
        ux uxVar = this.f27689c;
        Map<String, Object> mediaExtraInfo = uxVar != null ? uxVar.getMediaExtraInfo() : null;
        if (mediaExtraInfo == null) {
            com.bytedance.msdk.api.c.w wVar = this.f27692w;
            mediaExtraInfo = com.bytedance.msdk.core.r.ux.f(wVar != null ? wVar.u() : "");
        }
        if (this.f27690f && fz.c()) {
            String c4 = fz.c(fp.c(this.f27692w, this.f27689c, true));
            if (!TextUtils.isEmpty(c4)) {
                mediaExtraInfo.put("get_show_ecpm_info", c4);
            }
        }
        return mediaExtraInfo;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    @Nullable
    public com.bytedance.msdk.api.xv ia() {
        if (this.f27689c == null || !this.f27690f || fz.c()) {
            return null;
        }
        return fp.c(this.f27692w, this.f27689c, true);
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public int j() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getVideoHeight();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public String k() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getActionText();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public boolean ls() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.canAdReuse();
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

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void me() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.onPause();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public boolean n() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.isExpressAd();
        }
        return false;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public int p() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getImageHeight();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    @Nullable
    public f pr() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getGMNativeCustomVideoReporter();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public int q() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getVideoWidth();
        }
        return 0;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public String r() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getIconUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    @Nullable
    public com.bytedance.msdk.api.xv s() {
        if (this.f27689c != null && com.bytedance.msdk.core.c.w().fz()) {
            return fp.c(this.f27692w, this.f27689c, false);
        }
        return null;
    }

    @Override // com.bytedance.msdk.c.xv
    public void setDislikeCallback(Activity activity, com.bytedance.sdk.openadsdk.s.c.w.c.c cVar) {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.setDislikeCallback(activity, cVar);
        }
    }

    @Override // com.bytedance.msdk.c.xv
    public void setDislikeDialog(Dialog dialog) {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.setDislikeDialog(dialog);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public List<String> t() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getImages();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public int u() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getInteractionType();
        }
        return -1;
    }

    @Override // com.bytedance.msdk.c.xv
    public void uploadDislikeEvent(String str) {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.uploadDislikeEvent(str);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public String ux() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getAdTitle();
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

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void wv() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.onResume();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public String wx() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getVideoUrl();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.gd
    public void x() {
        gd gdVar = this.ux;
        if (gdVar != null) {
            gdVar.x();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void xk() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            try {
                uxVar.onDestroy();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void y() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.cancelDownload();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public String ys() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getSource();
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public com.bytedance.msdk.api.sr.c.r.w yu() {
        ux uxVar = this.f27689c;
        if (uxVar == null || !uxVar.hasAppInfo()) {
            return null;
        }
        com.bytedance.msdk.api.sr.c.r.w wVar = new com.bytedance.msdk.api.sr.c.r.w();
        wVar.w(this.f27689c.getAppName());
        wVar.xv(this.f27689c.getAuthorName());
        wVar.c(this.f27689c.getPackageSizeBytes());
        wVar.sr(this.f27689c.getPermissionsUrl());
        wVar.ux(this.f27689c.getPrivacyAgreement());
        wVar.f(this.f27689c.getVersionName());
        wVar.c(this.f27689c.getPermissionsMap());
        wVar.w(this.f27689c.getAppInfoExtra());
        wVar.c(this.f27689c.getFunctionDescUrl());
        return wVar;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void z() {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.pauseAppDownload();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public ux sr() {
        return this.f27689c;
    }

    public void w(boolean z3) {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.setHasShown(z3);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public boolean xv() {
        com.bytedance.msdk.api.c.w wVar;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.f27689c);
        com.bytedance.msdk.xv.r.c(arrayList, (List<ux>) null, (List<ux>) null, this.f27692w, fp.c(this.f27689c), 0);
        ux uxVar = this.f27689c;
        if (uxVar == null || (wVar = this.f27692w) == null) {
            return false;
        }
        return uxVar.isReady(wVar.u());
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void c(boolean z3) {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.setUseCustomVideo(z3);
        }
    }

    @Override // com.bytedance.msdk.c.xv
    public ev getDislikeDialog(TTDislikeDialogAbstract tTDislikeDialogAbstract) {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            return uxVar.getDislikeDialog(tTDislikeDialogAbstract);
        }
        return null;
    }

    @Override // com.bytedance.msdk.api.sr.c.w
    public void w() {
        w wVar = this.f27691r;
        if (wVar != null) {
            wVar.w();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void c(com.bytedance.msdk.api.sr.c.sr srVar) {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.setGmShakeViewListener(srVar);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w
    public void w(long j4, long j5, String str, String str2) {
        w wVar = this.f27691r;
        if (wVar != null) {
            wVar.w(j4, j5, str, str2);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void c(p pVar) {
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.setGMVideoRewardListener(pVar);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void c(xv xvVar) {
        this.xv = xvVar;
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void c(gd gdVar) {
        this.ux = gdVar;
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.setTTVideoListener(this);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void c(w wVar) {
        this.f27691r = wVar;
        ux uxVar = this.f27689c;
        if (uxVar != null) {
            uxVar.setTTAdAppDownloadListener(this);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.r.c
    public void c(@NonNull Activity activity, @NonNull ViewGroup viewGroup, @NonNull List<View> list, @Nullable List<View> list2, @Nullable List<View> list3, com.bytedance.msdk.api.sr.c.r.k kVar) {
        com.bytedance.msdk.xv.r.c(this.f27692w, fp.c(this.f27689c));
        if (this.f27689c != null) {
            up();
            this.f27689c.registerViewForInteraction(activity, viewGroup, list, list2, list3, kVar);
            InterfaceC0408c interfaceC0408c = this.sr;
            if (interfaceC0408c != null) {
                interfaceC0408c.c();
            }
            c(this.f27689c);
            ux uxVar = this.f27689c;
            com.bytedance.msdk.xv.r.c(uxVar, this.f27692w, uxVar.isShowRepeatOnce(), 0);
            return;
        }
        com.bytedance.msdk.xv.r.c((List<ux>) null, this.f27692w, 0);
    }

    @Override // com.bytedance.msdk.api.sr.c.r.gd
    public void c(com.bytedance.msdk.api.c cVar) {
        String str;
        long j4;
        long currentTimeMillis = System.currentTimeMillis();
        if (i.c(this.f27689c)) {
            str = i.w(Thread.currentThread().getStackTrace());
            j4 = System.currentTimeMillis() - currentTimeMillis;
        } else {
            str = null;
            j4 = -1;
        }
        com.bytedance.msdk.xv.r.c(this.f27689c, this.f27692w, (com.bytedance.msdk.api.c) null, 2, 0, str, j4);
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
            com.bytedance.msdk.xv.r.c(uxVar, this.f27692w, i.c(Thread.currentThread().getStackTrace()), 2);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w
    public void c() {
        w wVar = this.f27691r;
        if (wVar != null) {
            wVar.c();
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w
    public void c(long j4, long j5, int i4, int i5) {
        w wVar = this.f27691r;
        if (wVar != null) {
            wVar.c(j4, j5, i4, i5);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w
    public void c(long j4, long j5, String str, String str2) {
        w wVar = this.f27691r;
        if (wVar != null) {
            wVar.c(j4, j5, str, str2);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w
    public void c(long j4, String str, String str2) {
        w wVar = this.f27691r;
        if (wVar != null) {
            wVar.c(j4, str, str2);
        }
    }

    @Override // com.bytedance.msdk.api.sr.c.w
    public void c(String str, String str2) {
        w wVar = this.f27691r;
        if (wVar != null) {
            wVar.c(str, str2);
        }
    }
}
