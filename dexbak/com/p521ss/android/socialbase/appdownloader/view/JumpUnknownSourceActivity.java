package com.p521ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.p521ss.android.socialbase.appdownloader.C12284a;
import com.p521ss.android.socialbase.appdownloader.C12293bl;
import com.p521ss.android.socialbase.appdownloader.C12354p;
import com.p521ss.android.socialbase.appdownloader.C12360q;
import com.p521ss.android.socialbase.appdownloader.C12361s;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12297bl;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12299j;
import com.p521ss.android.socialbase.appdownloader.p542bl.InterfaceC12306r;
import com.p521ss.android.socialbase.appdownloader.p547s.C12371ok;
import com.stub.StubApp;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class JumpUnknownSourceActivity extends Activity {

    /* renamed from: a */
    private Intent f34882a;
    @Nullable

    /* renamed from: bl */
    private Intent f34883bl;

    /* renamed from: n */
    private JSONObject f34884n;

    /* renamed from: ok */
    private InterfaceC12306r f34885ok;

    /* renamed from: s */
    private int f34886s;

    static {
        StubApp.interface11(22968);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        C12354p.m18098ok().m18093ok(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.f34882a = intent;
        if (intent != null) {
            this.f34883bl = (Intent) intent.getParcelableExtra("intent");
            this.f34886s = intent.getIntExtra("id", -1);
            try {
                this.f34884n = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.f34884n == null) {
            C12293bl.m18426ok((Activity) this);
            return;
        }
        m18011a();
        InterfaceC12306r interfaceC12306r = this.f34885ok;
        if (interfaceC12306r != null && !interfaceC12306r.mo18017a()) {
            this.f34885ok.mo18016ok();
        } else if (this.f34885ok == null) {
            finish();
        }
    }

    /* renamed from: a */
    private void m18011a() {
        if (this.f34885ok != null || this.f34882a == null) {
            return;
        }
        try {
            InterfaceC12297bl m18065ok = C12361s.m18068k().m18065ok();
            InterfaceC12299j mo18390ok = m18065ok != null ? m18065ok.mo18390ok(this) : null;
            if (mo18390ok == null) {
                mo18390ok = new C12371ok(this);
            }
            int m18083ok = C12360q.m18083ok(this, "tt_appdownloader_tip");
            int m18083ok2 = C12360q.m18083ok(this, "tt_appdownloader_label_ok");
            int m18083ok3 = C12360q.m18083ok(this, "tt_appdownloader_label_cancel");
            String optString = this.f34884n.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(optString)) {
                optString = getString(C12360q.m18083ok(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            mo18390ok.mo18021ok(m18083ok).mo18018ok(optString).mo18020ok(m18083ok2, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (C12284a.m18468ok(jumpUnknownSourceActivity, jumpUnknownSourceActivity.f34883bl, JumpUnknownSourceActivity.this.f34886s, JumpUnknownSourceActivity.this.f34884n)) {
                        C12284a.m18476bl(JumpUnknownSourceActivity.this.f34886s, JumpUnknownSourceActivity.this.f34884n);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        C12284a.m18465ok((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.f34883bl, true);
                    }
                    C12284a.m18472ok(JumpUnknownSourceActivity.this.f34886s, JumpUnknownSourceActivity.this.f34884n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).mo18023a(m18083ok3, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i) {
                    if (JumpUnknownSourceActivity.this.f34883bl != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        C12284a.m18465ok((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f34883bl, true);
                    }
                    C12284a.m18482a(JumpUnknownSourceActivity.this.f34886s, JumpUnknownSourceActivity.this.f34884n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).mo18019ok(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.f34883bl != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        C12284a.m18465ok((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.f34883bl, true);
                    }
                    C12284a.m18482a(JumpUnknownSourceActivity.this.f34886s, JumpUnknownSourceActivity.this.f34884n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).mo18401ok(false);
            this.f34885ok = mo18390ok.mo18022ok();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ok */
    private void m18008ok() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }
}
