package com.ss.android.downloadlib.addownload.ok;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.R;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private TextView f48564a;
    private TextView bl;

    /* renamed from: h  reason: collision with root package name */
    private boolean f48565h;

    /* renamed from: j  reason: collision with root package name */
    private String f48566j;

    /* renamed from: k  reason: collision with root package name */
    private String f48567k;
    private bl kf;

    /* renamed from: n  reason: collision with root package name */
    private s f48568n;
    private TextView ok;

    /* renamed from: p  reason: collision with root package name */
    private boolean f48569p;

    /* renamed from: q  reason: collision with root package name */
    private Activity f48570q;

    /* renamed from: r  reason: collision with root package name */
    private String f48571r;

    /* renamed from: s  reason: collision with root package name */
    private TextView f48572s;

    /* renamed from: z  reason: collision with root package name */
    private String f48573z;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class ok {

        /* renamed from: a  reason: collision with root package name */
        private String f48574a;
        private String bl;

        /* renamed from: h  reason: collision with root package name */
        private s f48575h;
        private boolean kf;

        /* renamed from: n  reason: collision with root package name */
        private String f48576n;
        private Activity ok;

        /* renamed from: p  reason: collision with root package name */
        private bl f48577p;

        /* renamed from: s  reason: collision with root package name */
        private String f48578s;

        public ok(Activity activity) {
            this.ok = activity;
        }

        public ok a(String str) {
            this.bl = str;
            return this;
        }

        public ok bl(String str) {
            this.f48578s = str;
            return this;
        }

        public ok ok(String str) {
            this.f48574a = str;
            return this;
        }

        public ok s(String str) {
            this.f48576n = str;
            return this;
        }

        public ok ok(boolean z3) {
            this.kf = z3;
            return this;
        }

        public ok ok(s sVar) {
            this.f48575h = sVar;
            return this;
        }

        public ok ok(bl blVar) {
            this.f48577p = blVar;
            return this;
        }

        public n ok() {
            return new n(this.ok, this.f48574a, this.bl, this.f48578s, this.f48576n, this.kf, this.f48575h, this.f48577p);
        }
    }

    public n(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z3, @NonNull s sVar, bl blVar) {
        super(activity, R.style.ttdownloader_translucent_dialog);
        this.f48570q = activity;
        this.f48568n = sVar;
        this.f48567k = str;
        this.f48571r = str2;
        this.f48566j = str3;
        this.f48573z = str4;
        this.kf = blVar;
        setCanceledOnTouchOutside(z3);
        s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.f48569p = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void kf() {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f48565h = true;
        dismiss();
    }

    private void s() {
        setContentView(LayoutInflater.from(StubApp.getOrigApplicationContext(this.f48570q.getApplicationContext())).inflate(ok(), (ViewGroup) null));
        this.ok = (TextView) findViewById(a());
        this.f48564a = (TextView) findViewById(bl());
        this.bl = (TextView) findViewById(R.id.message_tv);
        this.f48572s = (TextView) findViewById(R.id.delete_tv);
        if (!TextUtils.isEmpty(this.f48571r)) {
            this.ok.setText(this.f48571r);
        }
        if (!TextUtils.isEmpty(this.f48566j)) {
            this.f48564a.setText(this.f48566j);
        }
        if (!TextUtils.isEmpty(this.f48573z)) {
            this.f48572s.setText(this.f48573z);
        } else {
            this.f48572s.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f48567k)) {
            this.bl.setText(this.f48567k);
        }
        this.ok.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ok.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.n();
            }
        });
        this.f48564a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ok.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.kf();
            }
        });
        this.f48572s.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ok.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                n.this.delete();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f48570q.isFinishing()) {
            this.f48570q.finish();
        }
        if (this.f48565h) {
            this.f48568n.ok();
        } else if (this.f48569p) {
            this.kf.delete();
        } else {
            this.f48568n.a();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public int a() {
        return R.id.confirm_tv;
    }

    public int bl() {
        return R.id.cancel_tv;
    }

    public int ok() {
        return R.layout.ttdownloader_dialog_select_operation;
    }
}
