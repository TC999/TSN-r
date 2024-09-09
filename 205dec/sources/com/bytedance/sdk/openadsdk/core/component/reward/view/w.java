package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.component.utils.n;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.u.bw;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.res.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends AlertDialog implements n.c {

    /* renamed from: c  reason: collision with root package name */
    public com.bytedance.sdk.openadsdk.core.w.w f32686c;
    private final c ev;

    /* renamed from: f  reason: collision with root package name */
    private TextView f32687f;
    private long gd;

    /* renamed from: p  reason: collision with root package name */
    private boolean f32688p;

    /* renamed from: r  reason: collision with root package name */
    private final String f32689r;
    private TextView sr;
    private TextView ux;

    /* renamed from: w  reason: collision with root package name */
    protected final n f32690w;
    private Context xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Dialog dialog);

        void w(Dialog dialog);
    }

    public w(Context context, me meVar, c cVar) {
        super(context);
        this.f32690w = new n(Looper.getMainLooper(), this);
        this.f32688p = false;
        this.xv = context;
        if (context == null) {
            this.xv = ls.getContext();
        }
        this.f32689r = bw.f(meVar);
        this.ev = cVar;
        if (bw.ux(meVar) == 3) {
            this.f32688p = true;
            this.gd = 5L;
            return;
        }
        this.gd = bw.ev(meVar);
    }

    @Override // android.app.AlertDialog, android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(ux.wx(this.xv));
        setCanceledOnTouchOutside(false);
        c();
        this.f32690w.sendEmptyMessageDelayed(101, 1000L);
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        if (z3) {
            this.f32690w.removeMessages(101);
            this.f32690w.sendEmptyMessageDelayed(101, 1000L);
            return;
        }
        this.f32690w.removeMessages(101);
    }

    @Override // android.app.Dialog
    public void show() {
        super.show();
        xk.c(this.sr, this.f32689r);
    }

    private void c() {
        this.sr = (TextView) findViewById(2114387829);
        this.ux = (TextView) findViewById(2114387637);
        this.f32687f = (TextView) findViewById(2114387836);
        if (this.ev == null) {
            return;
        }
        xk.c((View) this.ux, (View.OnClickListener) this.f32686c, "goLiveListener");
        xk.c(this.f32687f, new View.OnClickListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.view.w.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                w.this.ev.c(w.this);
            }
        }, "cancelTv");
    }

    public void c(com.bytedance.sdk.openadsdk.core.w.w wVar) {
        this.f32686c = wVar;
    }

    @Override // com.bytedance.sdk.component.utils.n.c
    public void c(Message message) {
        c cVar;
        if (message.what == 101) {
            long j4 = this.gd - 1;
            this.gd = j4;
            if (j4 <= 0) {
                if (this.f32688p && (cVar = this.ev) != null) {
                    cVar.w(this);
                }
                c cVar2 = this.ev;
                if (cVar2 != null) {
                    cVar2.c(this);
                    return;
                }
                return;
            }
            if (this.f32688p) {
                xk.c(this.f32687f, i.c(this.xv, "tt_reward_live_dialog_cancel_text"));
            } else {
                xk.c(this.f32687f, String.format(i.c(this.xv, "tt_reward_live_dialog_cancel_count_down_text"), String.valueOf(j4)));
            }
            this.f32690w.sendEmptyMessageDelayed(101, 1000L);
        }
    }
}
