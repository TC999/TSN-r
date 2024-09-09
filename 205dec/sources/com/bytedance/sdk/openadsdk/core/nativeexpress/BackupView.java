package com.bytedance.sdk.openadsdk.core.nativeexpress;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.bytedance.sdk.component.adexpress.theme.ThemeStatusBroadcastReceiver;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import com.bytedance.sdk.openadsdk.core.eq.wv;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.u.ng;
import com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView;
import org.json.JSONException;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public abstract class BackupView extends FrameLayout implements com.bytedance.sdk.component.adexpress.theme.c {

    /* renamed from: a  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.multipro.w.c f33985a;
    private NativeVideoTsView bk;

    /* renamed from: c  reason: collision with root package name */
    protected Context f33986c;
    protected int ev;

    /* renamed from: f  reason: collision with root package name */
    protected int f33987f;
    protected boolean gd;

    /* renamed from: k  reason: collision with root package name */
    protected String f33988k;

    /* renamed from: p  reason: collision with root package name */
    protected boolean f33989p;

    /* renamed from: r  reason: collision with root package name */
    protected int f33990r;
    protected Dialog sr;
    protected String ux;

    /* renamed from: w  reason: collision with root package name */
    protected me f33991w;
    protected com.bytedance.sdk.openadsdk.core.dislike.ui.c xv;

    public BackupView(Context context) {
        super(context);
        this.ux = "embeded_ad";
        this.gd = true;
        this.f33989p = true;
        this.f33985a = new com.bytedance.sdk.openadsdk.core.multipro.w.c();
        c();
    }

    private void c() {
        setTag("tt_express_backup_fl_tag_26");
    }

    private boolean sr() {
        return TextUtils.equals(this.ux, "splash_ad") || TextUtils.equals(this.ux, "cache_splash_ad");
    }

    private boolean w() {
        if (sr()) {
            return xv();
        }
        me meVar = this.f33991w;
        return meVar != null && me.w(meVar);
    }

    private boolean xv() {
        com.bykv.vk.openvk.component.video.api.xv.xv bk;
        me meVar = this.f33991w;
        return (meVar == null || meVar.b() == 1 || (bk = ng.bk(this.f33991w)) == null || TextUtils.isEmpty(bk.a())) ? false : true;
    }

    public void b_(int i4) {
    }

    protected abstract void c(View view, int i4, com.bytedance.sdk.openadsdk.core.u.u uVar);

    /* JADX INFO: Access modifiers changed from: protected */
    public String getDescription() {
        if (TextUtils.isEmpty(this.f33991w.ny())) {
            return !TextUtils.isEmpty(this.f33991w.ju()) ? this.f33991w.ju() : "";
        }
        return this.f33991w.ny();
    }

    public me getMeta() {
        return this.f33991w;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getNameOrSource() {
        me meVar = this.f33991w;
        if (meVar == null) {
            return "";
        }
        if (meVar.ix() == null || TextUtils.isEmpty(this.f33991w.ix().xv())) {
            return !TextUtils.isEmpty(this.f33991w.yh()) ? this.f33991w.yh() : "";
        }
        return this.f33991w.ix().xv();
    }

    public float getRealHeight() {
        return xk.sr(this.f33986c, this.f33990r);
    }

    public float getRealWidth() {
        return xk.sr(this.f33986c, this.f33987f);
    }

    @Override // android.view.View
    public Object getTag() {
        return "tt_express_backup_fl_tag_26";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public String getTitle() {
        if (this.f33991w.ix() != null && !TextUtils.isEmpty(this.f33991w.ix().xv())) {
            return this.f33991w.ix().xv();
        }
        if (TextUtils.isEmpty(this.f33991w.yh())) {
            return !TextUtils.isEmpty(this.f33991w.ny()) ? this.f33991w.ny() : "";
        }
        return this.f33991w.yh();
    }

    public com.bytedance.sdk.openadsdk.core.multipro.w.c getVideoModel() {
        return this.f33985a;
    }

    public void setDislikeInner(com.bytedance.sdk.openadsdk.ys.w.w.ev evVar) {
        if (evVar instanceof com.bytedance.sdk.openadsdk.core.dislike.ui.c) {
            this.xv = (com.bytedance.sdk.openadsdk.core.dislike.ui.c) evVar;
        }
    }

    public void setDislikeOuter(Dialog dialog) {
        this.sr = dialog;
    }

    @Override // android.view.View
    public void setTag(Object obj) {
        super.setTag("tt_express_backup_fl_tag_26");
    }

    public void setThemeChangeReceiver(ThemeStatusBroadcastReceiver themeStatusBroadcastReceiver) {
        if (themeStatusBroadcastReceiver == null) {
            return;
        }
        themeStatusBroadcastReceiver.c(this);
    }

    public void ux() {
        Dialog dialog = this.sr;
        if (dialog != null) {
            dialog.show();
            return;
        }
        com.bytedance.sdk.openadsdk.core.dislike.ui.c cVar = this.xv;
        if (cVar != null) {
            cVar.c();
        } else {
            TTDelegateActivity.c(getContext(), this.f33991w);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view, boolean z3) {
        final com.bytedance.sdk.openadsdk.core.w.w wVar;
        if (view == null) {
            return;
        }
        if (z3) {
            Context context = this.f33986c;
            me meVar = this.f33991w;
            String str = this.ux;
            wVar = new com.bytedance.sdk.openadsdk.core.w.c(context, meVar, str, wv.c(str));
        } else {
            Context context2 = this.f33986c;
            me meVar2 = this.f33991w;
            String str2 = this.ux;
            wVar = new com.bytedance.sdk.openadsdk.core.w.w(context2, meVar2, str2, wv.c(str2));
        }
        view.setOnTouchListener(wVar);
        view.setOnClickListener(wVar);
        xv xvVar = new xv() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.1
            @Override // com.bytedance.sdk.openadsdk.core.nativeexpress.xv
            public void c(View view2, int i4, com.bytedance.sdk.openadsdk.core.u.u uVar) {
                try {
                    uVar.c().put("click_extra_map", ((com.bytedance.sdk.openadsdk.core.w.c.xv.c) wVar.c(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class)).ux());
                } catch (JSONException unused) {
                }
                BackupView.this.c(view2, i4, uVar);
            }
        };
        com.bytedance.sdk.openadsdk.core.w.c.w.c cVar = (com.bytedance.sdk.openadsdk.core.w.c.w.c) wVar.c(com.bytedance.sdk.openadsdk.core.w.c.w.c.class);
        if (cVar != null) {
            cVar.c(xvVar);
            cVar.c(z3 ? 2 : 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void w(int i4) {
        this.f33989p = com.bytedance.sdk.openadsdk.core.ls.w().sr(this.ev);
        int r3 = com.bytedance.sdk.openadsdk.core.ls.w().r(i4);
        if (3 == r3) {
            this.gd = false;
        } else if (1 == r3 && com.bytedance.sdk.component.utils.ys.sr(this.f33986c)) {
            this.gd = true;
        } else if (2 == r3) {
            if (com.bytedance.sdk.component.utils.ys.ux(this.f33986c) || com.bytedance.sdk.component.utils.ys.sr(this.f33986c) || com.bytedance.sdk.component.utils.ys.f(this.f33986c)) {
                this.gd = true;
            }
        } else if (5 == r3) {
            if (com.bytedance.sdk.component.utils.ys.sr(this.f33986c) || com.bytedance.sdk.component.utils.ys.f(this.f33986c)) {
                this.gd = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public View c(final NativeExpressView nativeExpressView) {
        NativeVideoTsView nativeVideoTsView;
        NativeVideoTsView nativeVideoTsView2 = this.bk;
        if (nativeVideoTsView2 != null) {
            return nativeVideoTsView2;
        }
        if (this.f33991w != null && this.f33986c != null) {
            if (w()) {
                try {
                    NativeVideoTsView c4 = c(this.f33986c, this.f33991w, this.ux, true, false);
                    this.bk = c4;
                    c4.setAdCreativeClickListener(new NativeVideoTsView.c() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.2
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.c
                        public void c(View view, int i4) {
                            c expressInteractionListener = nativeExpressView.getExpressInteractionListener();
                            if (expressInteractionListener == null) {
                                return;
                            }
                            expressInteractionListener.c(view, i4);
                        }
                    });
                    this.bk.setVideoCacheUrl(this.f33988k);
                    this.bk.setControllerStatusCallBack(new NativeVideoTsView.xv() { // from class: com.bytedance.sdk.openadsdk.core.nativeexpress.BackupView.3
                        @Override // com.bytedance.sdk.openadsdk.core.video.nativevideo.NativeVideoTsView.xv
                        public void c(boolean z3, long j4, long j5, long j6, boolean z4, boolean z5) {
                            com.bytedance.sdk.openadsdk.core.multipro.w.c cVar = BackupView.this.f33985a;
                            cVar.f33977c = z3;
                            cVar.ux = j4;
                            cVar.f33978f = j5;
                            cVar.f33979r = j6;
                            cVar.sr = z4;
                            cVar.ev = z5;
                        }
                    });
                    this.bk.setIsAutoPlay(this.gd);
                    this.bk.setIsQuiet(this.f33989p);
                } catch (Throwable unused) {
                    this.bk = null;
                }
            }
            if (w() && (nativeVideoTsView = this.bk) != null && nativeVideoTsView.c(0L, true, false)) {
                return this.bk;
            }
        }
        return null;
    }

    protected NativeVideoTsView c(Context context, me meVar, String str, boolean z3, boolean z4) {
        return new NativeVideoTsView(context, meVar, str, z3, z4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(View view) {
        if (ng.bk(this.f33991w) == null || view == null) {
            return;
        }
        boolean z3 = true;
        c(view, (this.f33991w.x() == 1 && this.gd) ? false : false);
    }
}
