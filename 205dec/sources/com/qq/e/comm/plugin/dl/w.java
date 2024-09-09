package com.qq.e.comm.plugin.dl;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.m1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.dl.l.h;
import org.json.JSONObject;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class w extends com.qq.e.dl.l.a<c> implements com.qq.e.comm.plugin.apkmanager.w.a {
    private static final int A = Color.parseColor("#3185FC");

    /* renamed from: x  reason: collision with root package name */
    private com.qq.e.comm.plugin.g0.c f42622x;

    /* renamed from: y  reason: collision with root package name */
    private String f42623y;

    /* renamed from: z  reason: collision with root package name */
    private com.qq.e.dl.l.m.b.b f42624z;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f42625c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f42626d;

        a(int i4, int i5) {
            this.f42625c = i4;
            this.f42626d = i5;
        }

        @Override // java.lang.Runnable
        public void run() {
            w.this.c(this.f42625c, this.f42626d);
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements h.e {
        @Override // com.qq.e.dl.l.h.e
        public com.qq.e.dl.l.h a(com.qq.e.dl.a aVar) {
            return new w(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c extends LinearLayout implements com.qq.e.dl.l.e<w> {

        /* renamed from: c  reason: collision with root package name */
        final ImageView f42628c;

        /* renamed from: d  reason: collision with root package name */
        final TextView f42629d;

        /* renamed from: e  reason: collision with root package name */
        private w f42630e;

        public c(Context context, TextView textView) {
            super(context);
            setGravity(17);
            this.f42628c = new ImageView(context);
            int a4 = f1.a(context, 16);
            addView(this.f42628c, a4, a4);
            this.f42629d = textView;
            textView.setTextSize(1, 13.0f);
            this.f42629d.setTextColor(w.A);
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(-2, -2);
            marginLayoutParams.leftMargin = f1.a(context, 4);
            addView(this.f42629d, marginLayoutParams);
        }

        @Override // android.widget.LinearLayout, android.view.View
        protected void onDraw(Canvas canvas) {
            int i4;
            com.qq.e.dl.l.i.d g4 = this.f42630e.g();
            int i5 = 0;
            if (g4 != null) {
                i5 = getWidth();
                i4 = getHeight();
                g4.a(canvas, i5, i4);
            } else {
                i4 = 0;
            }
            super.onDraw(canvas);
            if (g4 != null) {
                g4.b(canvas, i5, i4);
            }
        }

        @Override // android.view.View
        protected void onVisibilityChanged(View view, int i4) {
            this.f42630e.a(view, i4);
        }

        @Override // com.qq.e.dl.l.e
        public void a(w wVar) {
            this.f42630e = wVar;
        }
    }

    w(com.qq.e.dl.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(int r2, int r3) {
        /*
            r1 = this;
            if (r2 == 0) goto L58
            r0 = 1
            if (r2 == r0) goto L51
            r0 = 4
            if (r2 == r0) goto L2c
            r0 = 8
            if (r2 == r0) goto L25
            r0 = 16
            if (r2 == r0) goto L58
            r0 = 32
            if (r2 == r0) goto L1e
            r0 = 64
            if (r2 == r0) goto L58
            r0 = 128(0x80, float:1.8E-43)
            if (r2 == r0) goto L2c
            r2 = 0
            goto L5e
        L1e:
            com.qq.e.comm.plugin.g0.c r2 = r1.f42622x
            java.lang.String r2 = r2.b()
            goto L5e
        L25:
            com.qq.e.comm.plugin.g0.c r2 = r1.f42622x
            java.lang.String r2 = r2.a()
            goto L5e
        L2c:
            r2 = 100
            if (r3 <= r2) goto L33
            r3 = 100
            goto L36
        L33:
            if (r3 >= 0) goto L36
            r3 = 0
        L36:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            com.qq.e.comm.plugin.g0.c r0 = r1.f42622x
            java.lang.String r0 = r0.c()
            r2.append(r0)
            r2.append(r3)
            java.lang.String r3 = "%"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            goto L5e
        L51:
            com.qq.e.comm.plugin.g0.c r2 = r1.f42622x
            java.lang.String r2 = r2.e()
            goto L5e
        L58:
            com.qq.e.comm.plugin.g0.c r2 = r1.f42622x
            java.lang.String r2 = r2.d()
        L5e:
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L6d
            T extends android.view.View & com.qq.e.dl.l.e r3 = r1.f47039w
            com.qq.e.comm.plugin.dl.w$c r3 = (com.qq.e.comm.plugin.dl.w.c) r3
            android.widget.TextView r3 = r3.f42629d
            r3.setText(r2)
        L6d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.dl.w.c(int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.a
    /* renamed from: b */
    public c a(com.qq.e.dl.a aVar) {
        this.f42624z = new com.qq.e.dl.l.m.b.b(aVar);
        return new c(aVar.b(), (TextView) this.f42624z.m());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public void u() {
        super.u();
        com.qq.e.dl.l.i.b bVar = this.f47079q;
        if (bVar == null || !bVar.a() || m() == null) {
            return;
        }
        m().setWillNotDraw(false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.h
    public boolean a(String str, com.qq.e.dl.k.g gVar) {
        char c4;
        int hashCode = str.hashCode();
        if (hashCode != -1169023802) {
            if (hashCode == -737956838 && str.equals("iconSize")) {
                c4 = 1;
            }
            c4 = '\uffff';
        } else {
            if (str.equals("adModel")) {
                c4 = 0;
            }
            c4 = '\uffff';
        }
        if (c4 == 0) {
            com.qq.e.comm.plugin.g0.e eVar = (com.qq.e.comm.plugin.g0.e) gVar.c(new JSONObject[0]);
            Pair<String, String> a4 = a(eVar);
            ((c) this.f47039w).f42628c.setImageBitmap(m1.a((String) a4.first));
            ((c) this.f47039w).f42629d.setText((CharSequence) a4.second);
            a(eVar, (String) a4.second);
            return true;
        } else if (c4 != 1) {
            return super.a(str, gVar) || this.f42624z.a(str, gVar);
        } else {
            ViewGroup.LayoutParams layoutParams = ((c) this.f47039w).f42628c.getLayoutParams();
            layoutParams.width = gVar.a(new JSONObject[0]);
            layoutParams.height = gVar.a(new JSONObject[0]);
            ((c) this.f47039w).f42628c.setLayoutParams(layoutParams);
            return true;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:56:0x00ea, code lost:
        if (com.qq.e.comm.plugin.apkmanager.w.d.f(r9.q().j()) == false) goto L12;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private android.util.Pair<java.lang.String, java.lang.String> a(com.qq.e.comm.plugin.g0.e r9) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.dl.w.a(com.qq.e.comm.plugin.g0.e):android.util.Pair");
    }

    private void a(com.qq.e.comm.plugin.g0.e eVar, String str) {
        if (!eVar.X0() || eVar.q() == null) {
            return;
        }
        com.qq.e.comm.plugin.g0.b q3 = eVar.q();
        String e4 = q3.e();
        this.f42623y = e4;
        if (TextUtils.isEmpty(e4)) {
            return;
        }
        com.qq.e.comm.plugin.g0.c s3 = eVar.s();
        this.f42622x = s3;
        s3.a(str);
        c(q3.j(), com.qq.e.comm.plugin.apkmanager.k.e().a(this.f42623y));
        com.qq.e.comm.plugin.apkmanager.k.e().a(this.f42623y, this);
    }

    @Override // com.qq.e.comm.plugin.apkmanager.w.a
    public void a(String str, int i4, int i5, long j4) {
        if (this.f42623y.equals(str)) {
            p0.d(new a(i4, i5));
        }
    }
}
