package com.bytedance.sdk.openadsdk.core.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.res.layout.TTViewStub;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fp {

    /* renamed from: c  reason: collision with root package name */
    private View f35417c;
    private TTViewStub ev;

    /* renamed from: f  reason: collision with root package name */
    private boolean f35418f = false;
    private View gd;

    /* renamed from: r  reason: collision with root package name */
    private com.bykv.vk.openvk.component.video.api.xv.xv f35419r;
    private com.bytedance.sdk.openadsdk.core.video.nativevideo.c sr;
    private w ux;

    /* renamed from: w  reason: collision with root package name */
    private TextView f35420w;
    private Context xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        PAUSE_VIDEO,
        RELEASE_VIDEO,
        START_VIDEO
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface w {
        void a();

        boolean p();
    }

    private void sr() {
        View view = this.f35417c;
        if (view != null) {
            view.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xv() {
        if (this.xv == null) {
            return;
        }
        sr();
    }

    private void w() {
        this.f35419r = null;
    }

    public void c(Context context, View view) {
        if (context == null || !(view instanceof ViewGroup)) {
            return;
        }
        this.gd = view;
        this.xv = StubApp.getOrigApplicationContext(ls.getContext().getApplicationContext());
        try {
            this.ev = new TTViewStub(context, new com.bytedance.sdk.openadsdk.res.layout.video.ev());
        } catch (Throwable unused) {
        }
    }

    private void c(Context context, View view, boolean z3) {
        TTViewStub tTViewStub;
        if (context == null || view == null || (tTViewStub = this.ev) == null || tTViewStub.getParent() == null || this.f35417c != null) {
            return;
        }
        this.ev.c();
        this.f35417c = view.findViewById(2114387873);
        this.f35420w = (TextView) view.findViewById(2114387820);
        View findViewById = view.findViewById(2114387883);
        if (z3) {
            findViewById.setClickable(true);
            findViewById.setOnClickListener(new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.widget.fp.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    fp.this.xv();
                    if (fp.this.sr != null) {
                        fp.this.sr.c(c.START_VIDEO, (String) null);
                    }
                }
            });
            return;
        }
        findViewById.setOnClickListener(null);
        findViewById.setClickable(false);
    }

    public void c(com.bytedance.sdk.openadsdk.core.video.nativevideo.c cVar, w wVar) {
        this.ux = wVar;
        this.sr = cVar;
    }

    public boolean c(int i4, com.bykv.vk.openvk.component.video.api.xv.xv xvVar, boolean z3) {
        Context context = this.xv;
        if (context != null && xvVar != null) {
            try {
                c(context, this.gd, z3);
                this.f35419r = xvVar;
                if (i4 == 1 || i4 == 2) {
                    return c(i4);
                }
                return true;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return true;
    }

    private boolean c(int i4) {
        w wVar;
        if (c() || this.f35418f) {
            return true;
        }
        if (this.sr != null && (wVar = this.ux) != null) {
            if (wVar.p()) {
                this.sr.ux(null, null);
            }
            this.sr.c(c.PAUSE_VIDEO, (String) null);
        }
        c(this.f35419r, true);
        return false;
    }

    public void c(boolean z3) {
        if (z3) {
            w();
        }
        sr();
    }

    public boolean c() {
        View view = this.f35417c;
        return view != null && view.getVisibility() == 0;
    }

    private void c(com.bykv.vk.openvk.component.video.api.xv.xv xvVar, boolean z3) {
        View view;
        String str;
        View view2;
        if (xvVar == null || (view = this.f35417c) == null || this.xv == null || view.getVisibility() == 0) {
            return;
        }
        w wVar = this.ux;
        if (wVar != null) {
            wVar.a();
        }
        double ux = xvVar.ux();
        Double.isNaN(ux);
        int ceil = (int) Math.ceil((ux * 1.0d) / 1048576.0d);
        if (z3) {
            str = i.c(this.xv, "tt_video_without_wifi_tips") + ceil + i.c(this.xv, "tt_video_bytesize_MB") + i.c(this.xv, "tt_video_bytesize");
        } else {
            str = i.c(this.xv, "tt_video_without_wifi_tips") + i.c(this.xv, "tt_video_bytesize");
        }
        xk.c(this.f35417c, 0);
        xk.c(this.f35420w, str);
        if (!xk.sr(this.f35417c) || (view2 = this.f35417c) == null) {
            return;
        }
        view2.bringToFront();
    }
}
