package com.qq.e.comm.plugin.r0;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l extends FrameLayout implements com.qq.e.comm.plugin.apkmanager.w.a {

    /* renamed from: c  reason: collision with root package name */
    public h f45792c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f45793d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.e f45794e;

    /* renamed from: f  reason: collision with root package name */
    private int f45795f;

    /* renamed from: g  reason: collision with root package name */
    private String f45796g;

    /* renamed from: h  reason: collision with root package name */
    private String f45797h;

    /* renamed from: i  reason: collision with root package name */
    private String f45798i;

    /* renamed from: j  reason: collision with root package name */
    private String f45799j;

    /* renamed from: k  reason: collision with root package name */
    private String f45800k;

    /* renamed from: l  reason: collision with root package name */
    private String f45801l;

    /* renamed from: m  reason: collision with root package name */
    private com.qq.e.comm.plugin.apkmanager.w.a f45802m;

    /* renamed from: n  reason: collision with root package name */
    private c f45803n;

    /* renamed from: o  reason: collision with root package name */
    private int f45804o;

    /* renamed from: p  reason: collision with root package name */
    private int f45805p;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f45806c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f45807d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f45808e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ long f45809f;

        a(int i4, int i5, String str, long j4) {
            this.f45806c = i4;
            this.f45807d = i5;
            this.f45808e = str;
            this.f45809f = j4;
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.a(this.f45806c, this.f45807d);
            if (l.this.f45802m != null) {
                l.this.f45802m.a(this.f45808e, this.f45806c, this.f45807d, this.f45809f);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        com.qq.e.comm.plugin.g0.e f45811a;

        /* renamed from: b  reason: collision with root package name */
        int f45812b;

        /* renamed from: c  reason: collision with root package name */
        int f45813c;

        /* renamed from: e  reason: collision with root package name */
        int f45815e;

        /* renamed from: f  reason: collision with root package name */
        Typeface f45816f;

        /* renamed from: g  reason: collision with root package name */
        int f45817g;

        /* renamed from: h  reason: collision with root package name */
        int f45818h;

        /* renamed from: i  reason: collision with root package name */
        Object[] f45819i;

        /* renamed from: l  reason: collision with root package name */
        String[] f45822l;

        /* renamed from: m  reason: collision with root package name */
        com.qq.e.comm.plugin.apkmanager.w.a f45823m;

        /* renamed from: n  reason: collision with root package name */
        c f45824n;

        /* renamed from: d  reason: collision with root package name */
        int f45814d = 12;

        /* renamed from: j  reason: collision with root package name */
        Integer f45820j = null;

        /* renamed from: k  reason: collision with root package name */
        Integer f45821k = null;

        /* renamed from: o  reason: collision with root package name */
        int f45825o = 100;

        public b a(com.qq.e.comm.plugin.g0.e eVar) {
            this.f45811a = eVar;
            return this;
        }

        public b b(int i4) {
            this.f45825o = i4;
            return this;
        }

        public b c(int i4) {
            this.f45817g = i4;
            return this;
        }

        public b d(int i4) {
            this.f45820j = Integer.valueOf(i4);
            return this;
        }

        public b e(int i4) {
            this.f45818h = i4;
            return this;
        }

        public b f(int i4) {
            this.f45812b = i4;
            return this;
        }

        public b g(int i4) {
            this.f45815e = i4;
            return this;
        }

        public b h(int i4) {
            this.f45813c = i4;
            return this;
        }

        public b a(String[] strArr) {
            if (strArr != null && strArr.length == 5) {
                this.f45822l = strArr;
                return this;
            }
            d1.a("ProgressButton", "setStatusText null or length is not 5");
            return this;
        }

        public b a(int i4) {
            this.f45821k = Integer.valueOf(i4);
            return this;
        }

        public b a(Object[] objArr) {
            this.f45819i = objArr;
            return this;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface c {
        void a(String str, int i4);
    }

    public l(Context context, TextView textView) {
        super(context);
        this.f45796g = "\u6253\u5f00";
        this.f45797h = "\u4e0b\u8f7d";
        this.f45798i = "\u4e0b\u8f7d\u4e2d";
        this.f45799j = "\u7ee7\u7eed\u4e0b\u8f7d";
        this.f45800k = "\u5b89\u88c5";
        this.f45801l = "\u6253\u5f00";
        this.f45793d = textView;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        c cVar = this.f45803n;
        if (cVar != null) {
            cVar.a(this.f45793d.getText().toString(), this.f45804o);
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f45792c.b(i4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(b bVar) {
        if (bVar == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        h hVar = this.f45792c;
        if (hVar == null) {
            h hVar2 = new h(getContext());
            this.f45792c = hVar2;
            hVar2.setLayoutParams(layoutParams);
            addView(this.f45792c);
        } else {
            hVar.setLayoutParams(layoutParams);
        }
        if (bVar.f45813c > 0) {
            layoutParams = new FrameLayout.LayoutParams(bVar.f45813c, -1);
            layoutParams.gravity = 17;
        }
        if (this.f45793d == null) {
            this.f45793d = new TextView(getContext());
        }
        if (this.f45793d.getParent() == null) {
            this.f45793d.setLayoutParams(layoutParams);
            addView(this.f45793d);
        }
        this.f45794e = bVar.f45811a;
        String a4 = a();
        if (!TextUtils.isEmpty(a4)) {
            com.qq.e.comm.plugin.apkmanager.k.e().a(a4, this);
        }
        this.f45795f = bVar.f45818h;
        this.f45802m = bVar.f45823m;
        this.f45803n = bVar.f45824n;
        String[] strArr = bVar.f45822l;
        if (strArr != null && strArr.length == 5) {
            this.f45796g = strArr[0];
            this.f45797h = strArr[0];
            this.f45798i = strArr[1];
            this.f45799j = strArr[2];
            this.f45800k = strArr[3];
            this.f45801l = strArr[4];
        }
        Object[] objArr = bVar.f45819i;
        if (objArr != null) {
            this.f45792c.a(objArr);
        } else {
            Integer num = bVar.f45820j;
            if (num != null) {
                this.f45792c.b(num.intValue());
            }
        }
        Integer num2 = bVar.f45821k;
        if (num2 != null) {
            this.f45792c.setBackgroundColor(num2.intValue());
        }
        this.f45792c.a(bVar.f45812b);
        this.f45792c.c(100);
        h hVar3 = this.f45792c;
        int i4 = bVar.f45825o;
        this.f45805p = i4;
        hVar3.a(i4);
        this.f45793d.setBackgroundDrawable(null);
        this.f45793d.setGravity(17);
        this.f45793d.setTextColor(bVar.f45817g);
        int i5 = bVar.f45815e;
        if (i5 > 0) {
            this.f45793d.setTextSize(0, i5);
        } else {
            this.f45793d.setTextSize(2, bVar.f45814d);
        }
        Typeface typeface = bVar.f45816f;
        if (typeface != null) {
            this.f45793d.setTypeface(typeface);
        }
        com.qq.e.comm.plugin.g0.e eVar = this.f45794e;
        if (eVar != null && eVar.X0()) {
            a(com.qq.e.comm.plugin.apkmanager.k.e().b(a4), -1);
        } else {
            this.f45793d.setText(this.f45796g);
        }
        c cVar = this.f45803n;
        if (cVar != null) {
            cVar.a(this.f45793d.getText().toString(), this.f45804o);
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.w.a
    public void a(String str, int i4, int i5, long j4) {
        String a4 = a();
        if (!TextUtils.isEmpty(a4) && !TextUtils.isEmpty(str)) {
            if (!a4.equals(str)) {
                d1.a("ProgressButton", "onAPKStatusUpdate adInfoPkgName mismatch pkgName");
                return;
            } else {
                p0.a((Runnable) new a(i4, i5, str, j4));
                return;
            }
        }
        d1.a("ProgressButton", "onAPKStatusUpdate adInfoPkgName or pkgName null");
    }

    public void a(int i4) {
        if (i4 == this.f45805p) {
            return;
        }
        this.f45805p = i4;
        h hVar = this.f45792c;
        if (hVar != null) {
            hVar.a(i4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x001c, code lost:
        if (r3 != 128) goto L16;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(int r3, int r4) {
        /*
            r2 = this;
            if (r3 == 0) goto L72
            r0 = 1
            if (r3 == r0) goto L5f
            r0 = 4
            r1 = 100
            if (r3 == r0) goto L45
            r0 = 8
            if (r3 == r0) goto L32
            r0 = 16
            if (r3 == r0) goto L72
            r0 = 32
            if (r3 == r0) goto L1f
            r0 = 64
            if (r3 == r0) goto L72
            r0 = 128(0x80, float:1.8E-43)
            if (r3 == r0) goto L45
            goto L84
        L1f:
            r2.f45805p = r1
            com.qq.e.comm.plugin.r0.h r0 = r2.f45792c
            if (r0 == 0) goto L28
            r0.a(r4)
        L28:
            android.widget.TextView r4 = r2.f45793d
            if (r4 == 0) goto L84
            java.lang.String r0 = r2.f45799j
            r4.setText(r0)
            goto L84
        L32:
            com.qq.e.comm.plugin.r0.h r4 = r2.f45792c
            if (r4 == 0) goto L3b
            int r0 = r2.f45805p
            r4.a(r0)
        L3b:
            android.widget.TextView r4 = r2.f45793d
            if (r4 == 0) goto L84
            java.lang.String r0 = r2.f45800k
            r4.setText(r0)
            goto L84
        L45:
            r2.f45805p = r1
            com.qq.e.comm.plugin.r0.h r0 = r2.f45792c
            if (r0 == 0) goto L4e
            r0.a(r4)
        L4e:
            android.widget.TextView r4 = r2.f45793d
            if (r4 == 0) goto L84
            java.lang.String r0 = r2.f45798i
            r4.setText(r0)
            android.widget.TextView r4 = r2.f45793d
            int r0 = r2.f45795f
            r4.setTextColor(r0)
            goto L84
        L5f:
            com.qq.e.comm.plugin.r0.h r4 = r2.f45792c
            if (r4 == 0) goto L68
            int r0 = r2.f45805p
            r4.a(r0)
        L68:
            android.widget.TextView r4 = r2.f45793d
            if (r4 == 0) goto L84
            java.lang.String r0 = r2.f45801l
            r4.setText(r0)
            goto L84
        L72:
            com.qq.e.comm.plugin.r0.h r4 = r2.f45792c
            if (r4 == 0) goto L7b
            int r0 = r2.f45805p
            r4.a(r0)
        L7b:
            android.widget.TextView r4 = r2.f45793d
            if (r4 == 0) goto L84
            java.lang.String r0 = r2.f45797h
            r4.setText(r0)
        L84:
            r2.f45804o = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.r0.l.a(int, int):void");
    }

    private String a() {
        com.qq.e.comm.plugin.g0.e eVar = this.f45794e;
        return (eVar == null || !eVar.X0() || this.f45794e.q() == null) ? "" : this.f45794e.q().e();
    }
}
