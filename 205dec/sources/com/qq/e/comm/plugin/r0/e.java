package com.qq.e.comm.plugin.r0;

import android.app.Dialog;
import android.content.Context;
import android.util.Pair;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.qq.e.comm.plugin.util.m1;
import com.qq.e.comm.plugin.util.y;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e extends Dialog {

    /* renamed from: c  reason: collision with root package name */
    Context f45700c;

    /* renamed from: d  reason: collision with root package name */
    private LinearLayout f45701d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.q0.h f45702e;

    /* renamed from: f  reason: collision with root package name */
    private double f45703f;

    /* renamed from: g  reason: collision with root package name */
    private double f45704g;

    /* renamed from: h  reason: collision with root package name */
    private double f45705h;

    /* renamed from: i  reason: collision with root package name */
    private int f45706i;

    /* renamed from: j  reason: collision with root package name */
    private int f45707j;

    /* renamed from: k  reason: collision with root package name */
    private double f45708k;

    /* renamed from: l  reason: collision with root package name */
    private int f45709l;

    /* renamed from: m  reason: collision with root package name */
    private int f45710m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f45711n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f45712o;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            e.this.cancel();
        }
    }

    public e(Context context) {
        super(context);
        this.f45703f = 0.8d;
        this.f45704g = 1.0d;
        this.f45705h = 0.095d;
        this.f45708k = 0.8d;
        this.f45711n = false;
        this.f45712o = true;
        this.f45700c = context;
    }

    private void a() {
        b();
        c();
        setCanceledOnTouchOutside(this.f45711n);
        setCancelable(this.f45712o);
    }

    private void c() {
        LinearLayout linearLayout = new LinearLayout(this.f45700c);
        this.f45701d = linearLayout;
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
        this.f45701d.setOrientation(1);
        this.f45701d.setBackgroundColor(-1);
        setContentView(this.f45701d);
        com.qq.e.comm.plugin.q0.h a4 = new com.qq.e.comm.plugin.q0.d(this.f45700c).a();
        this.f45702e = a4;
        a4.a().setLayerType(1, null);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        ImageView imageView = new ImageView(this.f45700c);
        imageView.setImageBitmap(m1.a("iVBORw0KGgoAAAANSUhEUgAAAEAAAABACAMAAACdt4HsAAAAbFBMVEUAAAAAAAD////p6eknJyf/\n//8MDAz///////8REREbGxs9PT11dXWlpaX39/f///////////////9qamoZGRksLCxQUFBkZGSL\ni4u/v7/Z2dny8vL///////////////////////////////8d9apUAAAAI3RSTlOAAE3qikd6JQV3\nc2hbVE5AKx4RoYZtY15YUVBORD48MhoKNpZmpn4AAAHhSURBVFjDpZfbloIwDEXPVFsoFwW830H/\n/x+HRMYRIQIr54EHl2eTNiVN8CMoLIPb5WyNsefLLShD6X/9gCJbmg8ts2IsIAwad4cRhIMAslsj\nyhLiOyB/2Q/JduMd4PxmmxxeiPwroLoa1iKNHVpycbowrGslAwr7tCcOPXLJE2ELCZAb1t5DkN8b\nVt4PyAwpjfBFUWpIWR/gbkg7DGhnSPcugN9/ijGo+NSKAe/rP0YYoejI+9AGFOz3GCXPhOIdUFmK\nP8JIRbQKW70B+PzEGK2YT9Q/IBf2fyAX+R8gtJR/TFJKiwgbQEC4CJMUkScgQBPAHhO1b0LAM4CF\nx0T5BYXAAKo/CVpardHReoWWEqpRBCgoANf2P2ZzfGg+e7QJjkIoakDWTcF6RoRP/2zdTURWA5Y9\nZ2hOBPGHRjGvASHlw0EiyH44coYoqX4CEkH2A1RpSwScA5kg+zkPAW71cwuZIPuxra03XOrnBjJB\n9mNTWy84108PmSD74WvrGZaTIBNkP6fBgnIByATZD/aqAeolqDdRnUb1QVIfZfXHpP6ctQVFXdLU\nRVVb1tUXi/pq016u6utd22BoWxx1k6Vt87SNprbVVTfb+nZfP3DoRx790KUf+/SDp3701Q/f6vH/\nFzOPJ4ULw0zxAAAAAElFTkSuQmCC\n"));
        int i4 = this.f45707j;
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i4, i4);
        layoutParams2.gravity = 83;
        imageView.setLayoutParams(layoutParams2);
        FrameLayout frameLayout = new FrameLayout(this.f45700c);
        int i5 = this.f45706i;
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(i5, i5);
        layoutParams3.gravity = 5;
        frameLayout.setLayoutParams(layoutParams3);
        frameLayout.setBackgroundColor(-1);
        frameLayout.addView(imageView);
        this.f45701d.addView(frameLayout);
        this.f45701d.addView(this.f45702e.a(), layoutParams);
        frameLayout.setOnClickListener(new a());
    }

    private void d() {
        try {
            show();
            Window window = getWindow();
            if (window != null) {
                window.setLayout(this.f45709l, this.f45710m);
            }
        } catch (Exception unused) {
        }
    }

    public void b(String str) {
        a();
        a(str);
        d();
    }

    private void b() {
        Pair<Integer, Integer> b4 = y.b();
        double min = Math.min(((Integer) b4.first).intValue(), ((Integer) b4.second).intValue());
        double d4 = this.f45703f;
        Double.isNaN(min);
        int i4 = (int) (min * d4);
        this.f45709l = i4;
        double d5 = i4;
        double d6 = this.f45704g;
        Double.isNaN(d5);
        this.f45710m = (int) (d6 * d5);
        double d7 = this.f45705h;
        Double.isNaN(d5);
        int i5 = (int) (d5 * d7);
        this.f45706i = i5;
        double d8 = i5;
        double d9 = this.f45708k;
        Double.isNaN(d8);
        this.f45707j = (int) (d8 * d9);
    }

    private void a(String str) {
        this.f45702e.loadUrl(str);
    }
}
