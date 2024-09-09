package com.qq.e.comm.plugin.r0;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.qq.e.comm.plugin.fs.e.c;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.f1;
import com.qq.e.comm.plugin.util.n1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i implements c.b {

    /* renamed from: c  reason: collision with root package name */
    private final Activity f45731c;

    /* renamed from: d  reason: collision with root package name */
    private e f45732d;

    /* renamed from: e  reason: collision with root package name */
    private final String f45733e;

    /* renamed from: f  reason: collision with root package name */
    private String[] f45734f;

    /* renamed from: g  reason: collision with root package name */
    private f f45735g;

    /* renamed from: h  reason: collision with root package name */
    private Dialog f45736h;

    /* renamed from: i  reason: collision with root package name */
    private DialogInterface.OnDismissListener f45737i;

    /* renamed from: j  reason: collision with root package name */
    private final com.qq.e.comm.plugin.g0.e f45738j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements View.OnClickListener {
        a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.qq.e.comm.plugin.fs.e.c.a().a(i.this.f45733e, i.this);
            i.this.f();
            com.qq.e.comm.plugin.i.d.a(i.this.f45738j, i.this.f45733e);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements View.OnClickListener {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f45740c;

        b(String str) {
            this.f45740c = str;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.f();
            com.qq.e.comm.plugin.i.d.a(this.f45740c);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements View.OnClickListener {
        c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            i.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements DialogInterface.OnDismissListener {
        d() {
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            if (i.this.f45737i != null) {
                i.this.f45737i.onDismiss(dialogInterface);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class e extends LinearLayout {

        /* renamed from: c  reason: collision with root package name */
        private final i f45744c;

        public e(Context context, i iVar) {
            super(context);
            this.f45744c = iVar;
            setOrientation(1);
        }

        @Override // android.view.View
        protected void onConfigurationChanged(Configuration configuration) {
            super.onConfigurationChanged(configuration);
            this.f45744c.f();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface f {
        void onComplainSuccess();
    }

    public i(View view, com.qq.e.comm.plugin.g0.e eVar) {
        this(com.qq.e.comm.plugin.util.k.a(view), eVar);
    }

    private TextView d() {
        TextView textView = new TextView(this.f45731c);
        textView.setTextColor(-13421773);
        textView.setTextSize(16.0f);
        textView.setGravity(17);
        textView.setHeight(f1.a((Context) this.f45731c, 57));
        textView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        return textView;
    }

    private ShapeDrawable e() {
        float a4 = f1.a((Context) this.f45731c, 12);
        return n1.a(a4, a4, 0.0f, 0.0f, -1, 255);
    }

    private void h() {
        try {
            this.f45734f = com.qq.e.comm.plugin.d0.a.d().f().b("lcpi", "\u4e86\u89e3\u5e7f\u544a\u5e73\u53f0,https://e.qq.com/dev/index.html").split(",");
        } catch (Exception e4) {
            d1.a(e4.getMessage(), e4);
        }
    }

    private void j() {
        TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, 0.0f, 2, 1.0f, 2, 0.0f);
        translateAnimation.setInterpolator(new AccelerateInterpolator());
        translateAnimation.setDuration(200L);
        e eVar = this.f45732d;
        if (eVar != null) {
            eVar.startAnimation(translateAnimation);
        }
    }

    public void f() {
        try {
            if (this.f45736h == null || !this.f45736h.isShowing()) {
                return;
            }
            this.f45736h.dismiss();
        } catch (Throwable th) {
            d1.a(th.getMessage(), th);
        }
    }

    protected void g() {
        e eVar = new e(this.f45731c, this);
        this.f45732d = eVar;
        eVar.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        c();
        b();
        a();
    }

    public void i() {
        if (this.f45731c == null) {
            return;
        }
        Dialog dialog = new Dialog(this.f45731c);
        this.f45736h = dialog;
        dialog.setContentView(this.f45732d);
        this.f45736h.setOnDismissListener(new d());
        Window window = this.f45736h.getWindow();
        if (window == null) {
            return;
        }
        window.setWindowAnimations(0);
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setGravity(80);
        window.setLayout(-1, -2);
        try {
            this.f45736h.show();
            j();
        } catch (Throwable th) {
            d1.a(th.getMessage(), th);
        }
    }

    public i(Context context, com.qq.e.comm.plugin.g0.e eVar) {
        this(com.qq.e.comm.plugin.util.k.a(context), eVar);
    }

    private void a() {
        View a4 = a(f1.a((Context) this.f45731c, 8));
        a4.setBackgroundColor(-526345);
        this.f45732d.addView(a4);
        TextView d4 = d();
        d4.setText("\u53d6\u6d88");
        d4.setBackgroundColor(-1);
        this.f45732d.addView(d4);
        d4.setOnClickListener(new c());
    }

    private void b() {
        TextView d4 = d();
        d4.setText("\u6295\u8bc9\u6b64\u5e7f\u544a");
        String[] strArr = this.f45734f;
        if (strArr != null && strArr.length >= 2) {
            d4.setBackgroundColor(-1);
        } else {
            d4.setBackgroundDrawable(e());
        }
        this.f45732d.addView(d4);
        d4.setOnClickListener(new a());
    }

    private void c() {
        String[] strArr = this.f45734f;
        if (strArr == null) {
            return;
        }
        int length = strArr.length;
        for (int i4 = 1; i4 < length; i4 += 2) {
            String[] strArr2 = this.f45734f;
            String str = strArr2[i4 - 1];
            String str2 = strArr2[i4];
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                TextView d4 = d();
                if (i4 == 1) {
                    d4.setBackgroundDrawable(e());
                } else {
                    d4.setBackgroundColor(-1);
                }
                d4.setText(str);
                d4.setOnClickListener(new b(str2));
                this.f45732d.addView(d4);
                this.f45732d.addView(a(2));
            }
        }
    }

    public i(Activity activity, com.qq.e.comm.plugin.g0.e eVar) {
        this.f45731c = activity;
        this.f45738j = eVar;
        this.f45733e = eVar.y();
        if (this.f45731c == null) {
            return;
        }
        h();
        g();
    }

    private View a(int i4) {
        View view = new View(this.f45731c);
        view.setBackgroundColor(-1513240);
        view.setLayoutParams(new LinearLayout.LayoutParams(-1, i4));
        return view;
    }

    public void a(f fVar) {
        this.f45735g = fVar;
    }

    @Override // com.qq.e.comm.plugin.fs.e.c.b
    public void a(String str, int i4, Object obj) {
        f fVar = this.f45735g;
        if (fVar != null && i4 == 10016) {
            fVar.onComplainSuccess();
        }
    }

    public void a(DialogInterface.OnDismissListener onDismissListener) {
        this.f45737i = onDismissListener;
    }
}
