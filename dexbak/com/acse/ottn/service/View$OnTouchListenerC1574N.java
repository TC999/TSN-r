package com.acse.ottn.service;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.C1586Y;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.C1703va;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.acse.ottn.service.N */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class View$OnTouchListenerC1574N implements View.OnTouchListener {

    /* renamed from: a */
    final /* synthetic */ RelativeLayout f3002a;

    /* renamed from: b */
    final /* synthetic */ float f3003b;

    /* renamed from: c */
    final /* synthetic */ float f3004c;

    /* renamed from: d */
    final /* synthetic */ C1586Y.InterfaceC1587a f3005d;

    /* renamed from: e */
    final /* synthetic */ AccessiblityModel f3006e;

    /* renamed from: f */
    final /* synthetic */ Context f3007f;

    /* renamed from: g */
    final /* synthetic */ C1586Y f3008g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public View$OnTouchListenerC1574N(C1586Y c1586y, RelativeLayout relativeLayout, float f, float f2, C1586Y.InterfaceC1587a interfaceC1587a, AccessiblityModel accessiblityModel, Context context) {
        this.f3008g = c1586y;
        this.f3002a = relativeLayout;
        this.f3003b = f;
        this.f3004c = f2;
        this.f3005d = interfaceC1587a;
        this.f3006e = accessiblityModel;
        this.f3007f = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String str;
        RelativeLayout relativeLayout;
        int m56090b;
        int i;
        C1586Y.m56378c();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f3008g.f3044d = motionEvent.getX();
            this.f3008g.f3045e = motionEvent.getY();
        } else if (action == 1) {
            C1586Y.m56382b(4000, this.f3005d);
            if (this.f3008g.f3045e - motionEvent.getY() > 100.0f) {
                relativeLayout = this.f3002a;
                m56090b = -((int) this.f3004c);
                i = 300;
            } else if (motionEvent.getX() - this.f3008g.f3044d <= C1661ba.m56097a().m56090b("screenWidth") / 3) {
                this.f3002a.scrollTo(0, 0);
                if (Math.abs(this.f3008g.f3045e - motionEvent.getY()) < 100.0f && Math.abs(this.f3008g.f3044d - motionEvent.getX()) < 100.0f) {
                    str = C1586Y.f3041a;
                    C1694ra.m55914c(str, "点击了");
                    if (this.f3006e == null) {
                        return false;
                    }
                    C1586Y.m56378c();
                    C1586Y.m56387a(this.f3005d);
                    this.f3008g.m56391a(this.f3007f, this.f3006e, this.f3005d);
                }
                return false;
            } else {
                relativeLayout = this.f3002a;
                m56090b = C1661ba.m56097a().m56090b("screenWidth");
                i = (int) this.f3003b;
            }
            relativeLayout.scrollTo(m56090b, i);
            C1703va.m55903a().m55901a("close_coupon_window");
            C1586Y.m56387a(this.f3005d);
        } else if (action == 2) {
            if (Math.abs(motionEvent.getX() - this.f3008g.f3044d) > Math.abs(motionEvent.getY() - this.f3008g.f3045e)) {
                if (motionEvent.getX() - this.f3008g.f3044d < 0.0f) {
                    return false;
                }
                this.f3002a.scrollTo(-((int) (motionEvent.getX() - this.f3008g.f3044d)), -((int) this.f3003b));
            } else if (motionEvent.getY() - this.f3008g.f3045e > 0.0f) {
                return false;
            } else {
                this.f3002a.scrollTo(-((int) this.f3004c), -((int) (motionEvent.getY() - this.f3008g.f3045e)));
            }
        }
        return true;
    }
}
