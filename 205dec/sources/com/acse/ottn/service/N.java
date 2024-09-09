package com.acse.ottn.service;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.service.Y;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.ra;
import com.acse.ottn.util.va;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class N implements View.OnTouchListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ RelativeLayout f6374a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ float f6375b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ float f6376c;

    /* renamed from: d  reason: collision with root package name */
    final /* synthetic */ Y.a f6377d;

    /* renamed from: e  reason: collision with root package name */
    final /* synthetic */ AccessiblityModel f6378e;

    /* renamed from: f  reason: collision with root package name */
    final /* synthetic */ Context f6379f;

    /* renamed from: g  reason: collision with root package name */
    final /* synthetic */ Y f6380g;

    /* JADX INFO: Access modifiers changed from: package-private */
    public N(Y y3, RelativeLayout relativeLayout, float f4, float f5, Y.a aVar, AccessiblityModel accessiblityModel, Context context) {
        this.f6380g = y3;
        this.f6374a = relativeLayout;
        this.f6375b = f4;
        this.f6376c = f5;
        this.f6377d = aVar;
        this.f6378e = accessiblityModel;
        this.f6379f = context;
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        String str;
        RelativeLayout relativeLayout;
        int b4;
        int i4;
        Y.c();
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f6380g.f6418d = motionEvent.getX();
            this.f6380g.f6419e = motionEvent.getY();
        } else if (action == 1) {
            Y.b(4000, this.f6377d);
            if (this.f6380g.f6419e - motionEvent.getY() > 100.0f) {
                relativeLayout = this.f6374a;
                b4 = -((int) this.f6376c);
                i4 = 300;
            } else if (motionEvent.getX() - this.f6380g.f6418d <= C1419ba.a().b("screenWidth") / 3) {
                this.f6374a.scrollTo(0, 0);
                if (Math.abs(this.f6380g.f6419e - motionEvent.getY()) < 100.0f && Math.abs(this.f6380g.f6418d - motionEvent.getX()) < 100.0f) {
                    str = Y.f6415a;
                    ra.c(str, "\u70b9\u51fb\u4e86");
                    if (this.f6378e == null) {
                        return false;
                    }
                    Y.c();
                    Y.a(this.f6377d);
                    this.f6380g.a(this.f6379f, this.f6378e, this.f6377d);
                }
                return false;
            } else {
                relativeLayout = this.f6374a;
                b4 = C1419ba.a().b("screenWidth");
                i4 = (int) this.f6375b;
            }
            relativeLayout.scrollTo(b4, i4);
            va.a().a("close_coupon_window");
            Y.a(this.f6377d);
        } else if (action == 2) {
            if (Math.abs(motionEvent.getX() - this.f6380g.f6418d) > Math.abs(motionEvent.getY() - this.f6380g.f6419e)) {
                if (motionEvent.getX() - this.f6380g.f6418d < 0.0f) {
                    return false;
                }
                this.f6374a.scrollTo(-((int) (motionEvent.getX() - this.f6380g.f6418d)), -((int) this.f6375b));
            } else if (motionEvent.getY() - this.f6380g.f6419e > 0.0f) {
                return false;
            } else {
                this.f6374a.scrollTo(-((int) this.f6376c), -((int) (motionEvent.getY() - this.f6380g.f6419e)));
            }
        }
        return true;
    }
}
