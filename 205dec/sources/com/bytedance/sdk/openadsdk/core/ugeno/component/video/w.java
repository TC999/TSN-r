package com.bytedance.sdk.openadsdk.core.ugeno.component.video;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bykv.vk.openvk.component.video.api.xv.xv;
import com.bytedance.adsdk.ugeno.component.b;
import com.bytedance.sdk.openadsdk.core.u.ba;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends b<NativeVideoView> {
    private String au;

    /* renamed from: b  reason: collision with root package name */
    private boolean f34945b;
    private xv bj;
    private me bm;

    /* renamed from: c  reason: collision with root package name */
    private boolean f34946c;
    private String mt;
    private String oo;
    private c wo;

    public w(Context context) {
        super(context);
        this.f34945b = false;
    }

    private void n() {
        if (this.f34946c) {
            if (!TextUtils.isEmpty(this.au)) {
                try {
                    this.bm = com.bytedance.sdk.openadsdk.core.w.c(new JSONObject(this.au));
                    this.au = null;
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }
            me meVar = this.bm;
            if (meVar == null) {
                this.bm = new me();
                this.bj = new xv();
                return;
            }
            xv bk = ng.bk(meVar);
            this.bj = bk;
            if (bk == null) {
                this.bj = new xv();
                return;
            }
            return;
        }
        this.bm = new me();
        this.bj = new xv();
    }

    public boolean ev() {
        Object obj = this.ux;
        if (obj != null && ((NativeVideoView) obj).getNativeVideoController() != null) {
            return ((NativeVideoView) this.ux).getNativeVideoController().fz();
        }
        return this.f34945b;
    }

    public void fz() {
        c((com.bytedance.sdk.openadsdk.core.multipro.w.c) null);
    }

    public void gb() {
        if (ls()) {
            Object obj = this.ux;
            if (obj != null) {
                ((NativeVideoView) obj).ia();
            }
        } else if (j()) {
            i();
        } else {
            u();
        }
    }

    public void i() {
        Object obj = this.ux;
        if (obj != null) {
            ((NativeVideoView) obj).ev();
            if (this.f34946c) {
                ((NativeVideoView) this.ux).c(true, false);
            } else {
                ((NativeVideoView) this.ux).c(this.oo);
            }
        }
    }

    public boolean j() {
        com.bykv.vk.openvk.component.video.api.c ia;
        Object obj = this.ux;
        if (obj == null || ((NativeVideoView) obj).getNativeVideoController() == null || (ia = ((NativeVideoView) this.ux).getNativeVideoController().ia()) == null) {
            return false;
        }
        return ia.bk();
    }

    public boolean ls() {
        com.bykv.vk.openvk.component.video.api.c ia;
        Object obj = this.ux;
        if (obj == null || ((NativeVideoView) obj).getNativeVideoController() == null || (ia = ((NativeVideoView) this.ux).getNativeVideoController().ia()) == null) {
            return false;
        }
        return ia.gd();
    }

    public void q() {
        Object obj = this.ux;
        if (obj != null) {
            ((NativeVideoView) obj).ux();
            ((NativeVideoView) this.ux).c(this.oo);
        }
    }

    public void u() {
        Object obj = this.ux;
        if (obj != null) {
            ((NativeVideoView) obj).ac_();
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    /* renamed from: c */
    public NativeVideoView xv() {
        NativeVideoView nativeVideoView = new NativeVideoView(this.f26040w);
        nativeVideoView.c(this);
        return nativeVideoView;
    }

    public void sr(boolean z3) {
        Object obj = this.ux;
        if (obj != null) {
            ((NativeVideoView) obj).setNeedNativeVideoPlayBtnVisible(z3);
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void w() {
        super.w();
        n();
        this.bj.xv(this.mt);
        xv xvVar = this.bj;
        xvVar.c(this.f26023a + "x" + this.bk);
        this.bj.w(this.oo);
        this.bm.c(this.bj);
        ((NativeVideoView) this.ux).setMaterialMeta(this.bm);
        ((NativeVideoView) this.ux).setIsAutoPlay(true);
        ((NativeVideoView) this.ux).setIsQuiet(this.f34945b);
        ((NativeVideoView) this.ux).setVisibility(0);
        ((NativeVideoView) this.ux).setEnableAutoCheck(false);
        ((NativeVideoView) this.ux).c(this.f26040w, 25, this.oo);
        ((NativeVideoView) this.ux).c(0L, true, false);
        ((NativeVideoView) this.ux).c(this.oo);
        com.bykv.vk.openvk.component.video.api.sr.xv nativeVideoController = ((NativeVideoView) this.ux).getNativeVideoController();
        if (nativeVideoController != null) {
            c cVar = new c();
            this.wo = cVar;
            nativeVideoController.c(cVar);
        }
    }

    public void xv(boolean z3) {
        this.f34945b = z3;
        Object obj = this.ux;
        if (obj == null || ((NativeVideoView) obj).getNativeVideoController() == null) {
            return;
        }
        ((NativeVideoView) this.ux).getNativeVideoController().w(z3);
    }

    public void c(com.bytedance.sdk.openadsdk.core.multipro.w.c cVar) {
        me meVar;
        if (p() != null && (meVar = this.bm) != null) {
            if (meVar.tz() == 0) {
                int optInt = p().optInt("image_mode");
                this.bm.y(optInt);
                this.bm.c(new ba(p()));
                if (optInt == 166) {
                    this.bm.bm(-2);
                    ((NativeVideoView) this.ux).setPlayerType(-2);
                }
            }
        } else {
            ((NativeVideoView) this.ux).setPlayerType(0);
        }
        if (cVar != null) {
            com.bykv.vk.openvk.component.video.api.sr.xv nativeVideoController = ((NativeVideoView) this.ux).getNativeVideoController();
            nativeVideoController.sr(cVar.sr);
            nativeVideoController.w(cVar.ev);
            if (cVar.f33977c) {
                nativeVideoController.w(0L);
            } else {
                nativeVideoController.w(cVar.f33979r);
            }
        }
        ((NativeVideoView) this.ux).sr();
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private class c implements xv.c {

        /* renamed from: c  reason: collision with root package name */
        xv.c f34947c;

        private c() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
        public void c(long j4, int i4) {
            if (w.this.f34946c) {
                if (((b) w.this).ux != null) {
                    ((NativeVideoView) ((b) w.this).ux).setComplete(true);
                }
                if (((b) w.this).ux != null) {
                    ((NativeVideoView) ((b) w.this).ux).c(true, true);
                }
            }
            xv.c cVar = this.f34947c;
            if (cVar != null) {
                cVar.c(j4, i4);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
        public void w(long j4, int i4) {
            xv.c cVar = this.f34947c;
            if (cVar != null) {
                cVar.w(j4, i4);
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
        public void c() {
            xv.c cVar = this.f34947c;
            if (cVar != null) {
                cVar.c();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.sr.xv.c
        public void c(long j4, long j5) {
            xv.c cVar = this.f34947c;
            if (cVar != null) {
                cVar.c(j4, j5);
            }
        }
    }

    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(JSONObject jSONObject) {
        super.c(jSONObject);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.bytedance.adsdk.ugeno.component.b
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -351780179:
                if (str.equals("coverSrc")) {
                    c4 = 0;
                    break;
                }
                break;
            case 114148:
                if (str.equals("src")) {
                    c4 = 1;
                    break;
                }
                break;
            case 3241038:
                if (str.equals("isLp")) {
                    c4 = 2;
                    break;
                }
                break;
            case 3344133:
                if (str.equals("mate")) {
                    c4 = 3;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                this.oo = str2;
                return;
            case 1:
                this.mt = str2;
                return;
            case 2:
                try {
                    boolean booleanValue = Boolean.valueOf(str2).booleanValue();
                    this.f34946c = booleanValue;
                    Object obj = this.ux;
                    if (obj != null) {
                        ((NativeVideoView) obj).setLp(booleanValue);
                        return;
                    }
                    return;
                } catch (Exception unused) {
                    return;
                }
            case 3:
                this.au = str2;
                return;
            default:
                return;
        }
    }

    public void c(Map<String, Object> map) {
        Object obj = this.ux;
        if (obj != null) {
            ((NativeVideoView) obj).setExtraMap(map);
        }
    }
}
