package com.ss.android.downloadlib.addownload.c;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.adhost.R;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private String f48406a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    private TextView f48407c;
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private xv f48408f;
    private Activity gd;

    /* renamed from: k  reason: collision with root package name */
    private String f48409k;

    /* renamed from: p  reason: collision with root package name */
    private String f48410p;

    /* renamed from: r  reason: collision with root package name */
    private boolean f48411r;
    private TextView sr;
    private sr ux;

    /* renamed from: w  reason: collision with root package name */
    private TextView f48412w;
    private TextView xv;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        private Activity f48416c;
        private xv ev;

        /* renamed from: f  reason: collision with root package name */
        private boolean f48417f;

        /* renamed from: r  reason: collision with root package name */
        private sr f48418r;
        private String sr;
        private String ux;

        /* renamed from: w  reason: collision with root package name */
        private String f48419w;
        private String xv;

        public c(Activity activity) {
            this.f48416c = activity;
        }

        public c c(String str) {
            this.f48419w = str;
            return this;
        }

        public c sr(String str) {
            this.ux = str;
            return this;
        }

        public c w(String str) {
            this.xv = str;
            return this;
        }

        public c xv(String str) {
            this.sr = str;
            return this;
        }

        public c c(boolean z3) {
            this.f48417f = z3;
            return this;
        }

        public c c(sr srVar) {
            this.f48418r = srVar;
            return this;
        }

        public c c(xv xvVar) {
            this.ev = xvVar;
            return this;
        }

        public ux c() {
            return new ux(this.f48416c, this.f48419w, this.xv, this.sr, this.ux, this.f48417f, this.f48418r, this.ev);
        }
    }

    public ux(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z3, @NonNull sr srVar, xv xvVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.gd = activity;
        this.ux = srVar;
        this.f48410p = str;
        this.f48409k = str2;
        this.f48406a = str3;
        this.bk = str4;
        this.f48408f = xvVar;
        setCanceledOnTouchOutside(z3);
        sr();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.ev = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        dismiss();
    }

    private void sr() {
        setContentView(LayoutInflater.from(StubApp.getOrigApplicationContext(this.gd.getApplicationContext())).inflate(c(), (ViewGroup) null));
        this.f48407c = (TextView) findViewById(w());
        this.f48412w = (TextView) findViewById(xv());
        this.xv = (TextView) findViewById(R.id.message_tv);
        this.sr = (TextView) findViewById(R.id.delete_tv);
        if (!TextUtils.isEmpty(this.f48409k)) {
            this.f48407c.setText(this.f48409k);
        }
        if (!TextUtils.isEmpty(this.f48406a)) {
            this.f48412w.setText(this.f48406a);
        }
        if (!TextUtils.isEmpty(this.bk)) {
            this.sr.setText(this.bk);
        } else {
            this.sr.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f48410p)) {
            this.xv.setText(this.f48410p);
        }
        this.f48407c.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.c.ux.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ux.this.ux();
            }
        });
        this.f48412w.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.c.ux.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ux.this.f();
            }
        });
        this.sr.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.c.ux.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ux.this.delete();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux() {
        this.f48411r = true;
        dismiss();
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.gd.isFinishing()) {
            this.gd.finish();
        }
        if (this.f48411r) {
            this.ux.c();
        } else if (this.ev) {
            this.f48408f.delete();
        } else {
            this.ux.w();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int c() {
        return R.layout.ttdownloader_dialog_select_operation;
    }

    public int w() {
        return R.id.confirm_tv;
    }

    public int xv() {
        return R.id.cancel_tv;
    }
}
