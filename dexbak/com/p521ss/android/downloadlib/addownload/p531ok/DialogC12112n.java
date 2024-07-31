package com.p521ss.android.downloadlib.addownload.p531ok;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.bytedance.sdk.openadsdk.C6266R;
import com.stub.StubApp;

/* renamed from: com.ss.android.downloadlib.addownload.ok.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class DialogC12112n extends Dialog {

    /* renamed from: a */
    private TextView f34268a;

    /* renamed from: bl */
    private TextView f34269bl;

    /* renamed from: h */
    private boolean f34270h;

    /* renamed from: j */
    private String f34271j;

    /* renamed from: k */
    private String f34272k;

    /* renamed from: kf */
    private InterfaceC12111bl f34273kf;

    /* renamed from: n */
    private InterfaceC12120s f34274n;

    /* renamed from: ok */
    private TextView f34275ok;

    /* renamed from: p */
    private boolean f34276p;

    /* renamed from: q */
    private Activity f34277q;

    /* renamed from: r */
    private String f34278r;

    /* renamed from: s */
    private TextView f34279s;

    /* renamed from: z */
    private String f34280z;

    /* renamed from: com.ss.android.downloadlib.addownload.ok.n$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12116ok {

        /* renamed from: a */
        private String f34284a;

        /* renamed from: bl */
        private String f34285bl;

        /* renamed from: h */
        private InterfaceC12120s f34286h;

        /* renamed from: kf */
        private boolean f34287kf;

        /* renamed from: n */
        private String f34288n;

        /* renamed from: ok */
        private Activity f34289ok;

        /* renamed from: p */
        private InterfaceC12111bl f34290p;

        /* renamed from: s */
        private String f34291s;

        public C12116ok(Activity activity) {
            this.f34289ok = activity;
        }

        /* renamed from: a */
        public C12116ok m19031a(String str) {
            this.f34285bl = str;
            return this;
        }

        /* renamed from: bl */
        public C12116ok m19030bl(String str) {
            this.f34291s = str;
            return this;
        }

        /* renamed from: ok */
        public C12116ok m19026ok(String str) {
            this.f34284a = str;
            return this;
        }

        /* renamed from: s */
        public C12116ok m19024s(String str) {
            this.f34288n = str;
            return this;
        }

        /* renamed from: ok */
        public C12116ok m19025ok(boolean z) {
            this.f34287kf = z;
            return this;
        }

        /* renamed from: ok */
        public C12116ok m19027ok(InterfaceC12120s interfaceC12120s) {
            this.f34286h = interfaceC12120s;
            return this;
        }

        /* renamed from: ok */
        public C12116ok m19028ok(InterfaceC12111bl interfaceC12111bl) {
            this.f34290p = interfaceC12111bl;
            return this;
        }

        /* renamed from: ok */
        public DialogC12112n m19029ok() {
            return new DialogC12112n(this.f34289ok, this.f34284a, this.f34285bl, this.f34291s, this.f34288n, this.f34287kf, this.f34286h, this.f34290p);
        }
    }

    public DialogC12112n(@NonNull Activity activity, String str, String str2, String str3, String str4, boolean z, @NonNull InterfaceC12120s interfaceC12120s, InterfaceC12111bl interfaceC12111bl) {
        super(activity, C6266R.C6272style.ttdownloader_translucent_dialog);
        this.f34277q = activity;
        this.f34274n = interfaceC12120s;
        this.f34272k = str;
        this.f34278r = str2;
        this.f34271j = str3;
        this.f34280z = str4;
        this.f34273kf = interfaceC12111bl;
        setCanceledOnTouchOutside(z);
        m19032s();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete() {
        this.f34276p = true;
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: kf */
    public void m19036kf() {
        dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m19035n() {
        this.f34270h = true;
        dismiss();
    }

    /* renamed from: s */
    private void m19032s() {
        setContentView(LayoutInflater.from(StubApp.getOrigApplicationContext(this.f34277q.getApplicationContext())).inflate(m19034ok(), (ViewGroup) null));
        this.f34275ok = (TextView) findViewById(m19040a());
        this.f34268a = (TextView) findViewById(m19038bl());
        this.f34269bl = (TextView) findViewById(C6266R.C6269id.message_tv);
        this.f34279s = (TextView) findViewById(C6266R.C6269id.delete_tv);
        if (!TextUtils.isEmpty(this.f34278r)) {
            this.f34275ok.setText(this.f34278r);
        }
        if (!TextUtils.isEmpty(this.f34271j)) {
            this.f34268a.setText(this.f34271j);
        }
        if (!TextUtils.isEmpty(this.f34280z)) {
            this.f34279s.setText(this.f34280z);
        } else {
            this.f34279s.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f34272k)) {
            this.f34269bl.setText(this.f34272k);
        }
        this.f34275ok.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ok.n.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC12112n.this.m19035n();
            }
        });
        this.f34268a.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ok.n.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC12112n.this.m19036kf();
            }
        });
        this.f34279s.setOnClickListener(new View.OnClickListener() { // from class: com.ss.android.downloadlib.addownload.ok.n.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                DialogC12112n.this.delete();
            }
        });
    }

    @Override // android.app.Dialog, android.content.DialogInterface
    public void dismiss() {
        super.dismiss();
        if (!this.f34277q.isFinishing()) {
            this.f34277q.finish();
        }
        if (this.f34270h) {
            this.f34274n.mo18870ok();
        } else if (this.f34276p) {
            this.f34273kf.delete();
        } else {
            this.f34274n.mo18871a();
        }
    }

    @Override // android.app.Dialog, android.view.Window.Callback
    public boolean dispatchKeyEvent(@NonNull KeyEvent keyEvent) {
        if (keyEvent.getKeyCode() == 4) {
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    /* renamed from: a */
    public int m19040a() {
        return C6266R.C6269id.confirm_tv;
    }

    /* renamed from: bl */
    public int m19038bl() {
        return C6266R.C6269id.cancel_tv;
    }

    /* renamed from: ok */
    public int m19034ok() {
        return C6266R.C6270layout.ttdownloader_dialog_select_operation;
    }
}
