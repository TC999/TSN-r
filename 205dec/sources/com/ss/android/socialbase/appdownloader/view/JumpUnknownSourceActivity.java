package com.ss.android.socialbase.appdownloader.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Window;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.appdownloader.a;
import com.ss.android.socialbase.appdownloader.bl;
import com.ss.android.socialbase.appdownloader.bl.j;
import com.ss.android.socialbase.appdownloader.bl.r;
import com.ss.android.socialbase.appdownloader.p;
import com.ss.android.socialbase.appdownloader.q;
import com.ss.android.socialbase.appdownloader.s;
import com.stub.StubApp;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class JumpUnknownSourceActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private Intent f49244a;
    @Nullable
    private Intent bl;

    /* renamed from: n  reason: collision with root package name */
    private JSONObject f49245n;
    private r ok;

    /* renamed from: s  reason: collision with root package name */
    private int f49246s;

    static {
        StubApp.interface11(22968);
    }

    @Override // android.app.Activity
    protected native void onCreate(@Nullable Bundle bundle);

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
        p.ok().ok(this);
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        this.f49244a = intent;
        if (intent != null) {
            this.bl = (Intent) intent.getParcelableExtra("intent");
            this.f49246s = intent.getIntExtra("id", -1);
            try {
                this.f49245n = new JSONObject(intent.getStringExtra("config"));
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        if (this.f49245n == null) {
            bl.ok((Activity) this);
            return;
        }
        a();
        r rVar = this.ok;
        if (rVar != null && !rVar.a()) {
            this.ok.ok();
        } else if (this.ok == null) {
            finish();
        }
    }

    private void a() {
        if (this.ok != null || this.f49244a == null) {
            return;
        }
        try {
            com.ss.android.socialbase.appdownloader.bl.bl ok = s.k().ok();
            j ok2 = ok != null ? ok.ok(this) : null;
            if (ok2 == null) {
                ok2 = new com.ss.android.socialbase.appdownloader.s.ok(this);
            }
            int ok3 = q.ok(this, "tt_appdownloader_tip");
            int ok4 = q.ok(this, "tt_appdownloader_label_ok");
            int ok5 = q.ok(this, "tt_appdownloader_label_cancel");
            String optString = this.f49245n.optString("jump_unknown_source_tips");
            if (TextUtils.isEmpty(optString)) {
                optString = getString(q.ok(this, "tt_appdownloader_jump_unknown_source_tips"));
            }
            ok2.ok(ok3).ok(optString).ok(ok4, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                    if (a.ok(jumpUnknownSourceActivity, jumpUnknownSourceActivity.bl, JumpUnknownSourceActivity.this.f49246s, JumpUnknownSourceActivity.this.f49245n)) {
                        a.bl(JumpUnknownSourceActivity.this.f49246s, JumpUnknownSourceActivity.this.f49245n);
                    } else {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity2 = JumpUnknownSourceActivity.this;
                        a.ok((Context) jumpUnknownSourceActivity2, jumpUnknownSourceActivity2.bl, true);
                    }
                    a.ok(JumpUnknownSourceActivity.this.f49246s, JumpUnknownSourceActivity.this.f49245n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).a(ok5, new DialogInterface.OnClickListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.2
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    if (JumpUnknownSourceActivity.this.bl != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        a.ok((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.bl, true);
                    }
                    a.a(JumpUnknownSourceActivity.this.f49246s, JumpUnknownSourceActivity.this.f49245n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).ok(new DialogInterface.OnCancelListener() { // from class: com.ss.android.socialbase.appdownloader.view.JumpUnknownSourceActivity.1
                @Override // android.content.DialogInterface.OnCancelListener
                public void onCancel(DialogInterface dialogInterface) {
                    if (JumpUnknownSourceActivity.this.bl != null) {
                        JumpUnknownSourceActivity jumpUnknownSourceActivity = JumpUnknownSourceActivity.this;
                        a.ok((Context) jumpUnknownSourceActivity, jumpUnknownSourceActivity.bl, true);
                    }
                    a.a(JumpUnknownSourceActivity.this.f49246s, JumpUnknownSourceActivity.this.f49245n);
                    JumpUnknownSourceActivity.this.finish();
                }
            }).ok(false);
            this.ok = ok2.ok();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private void ok() {
        Window window = getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.alpha = 0.0f;
        window.setAttributes(attributes);
    }
}
