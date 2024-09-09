package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.col.p0003l.s3;
import com.amap.api.col.p0003l.t3;
import com.amap.api.col.p0003l.w3;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.a;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private static int f10801a;

    /* renamed from: b  reason: collision with root package name */
    private a f10802b;

    /* renamed from: c  reason: collision with root package name */
    private s3 f10803c;

    /* renamed from: d  reason: collision with root package name */
    private s3[] f10804d = new s3[32];

    /* renamed from: e  reason: collision with root package name */
    private int f10805e = -1;

    /* renamed from: f  reason: collision with root package name */
    private t3 f10806f;

    private void a(s3 s3Var) {
        try {
            a aVar = this.f10802b;
            if (aVar != null) {
                aVar.h();
                this.f10802b = null;
            }
            a c4 = c(s3Var);
            this.f10802b = c4;
            if (c4 != null) {
                this.f10803c = s3Var;
                c4.d(this);
                this.f10802b.b();
                this.f10802b.e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void b(s3 s3Var) {
        try {
            f10801a++;
            a(s3Var);
            int i4 = (this.f10805e + 1) % 32;
            this.f10805e = i4;
            this.f10804d[i4] = s3Var;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private a c(s3 s3Var) {
        try {
            if (s3Var.f8933a != 1) {
                return null;
            }
            if (this.f10806f == null) {
                this.f10806f = new t3();
            }
            return this.f10806f;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void closeScr() {
        try {
            if (a((Bundle) null)) {
                return;
            }
            a aVar = this.f10802b;
            if (aVar != null) {
                aVar.h();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            a aVar = this.f10802b;
            if (aVar != null) {
                aVar.c(view);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        try {
            super.onConfigurationChanged(configuration);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        try {
            super.onCreate(bundle);
            getWindow().setSoftInputMode(32);
            getWindow().setFormat(-3);
            requestWindowFeature(1);
            w3.f(StubApp.getOrigApplicationContext(getApplicationContext()));
            this.f10805e = -1;
            f10801a = 0;
            b(new s3());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            a aVar = this.f10802b;
            if (aVar != null) {
                aVar.h();
                this.f10802b = null;
            }
            this.f10803c = null;
            this.f10804d = null;
            t3 t3Var = this.f10806f;
            if (t3Var != null) {
                t3Var.h();
                this.f10806f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i4, KeyEvent keyEvent) {
        if (i4 == 4) {
            try {
                a aVar = this.f10802b;
                if (aVar != null && !aVar.f()) {
                    return true;
                }
                if (a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (f10801a == 1) {
                        finish();
                    }
                    return false;
                }
                this.f10805e = -1;
                f10801a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i4, keyEvent);
    }

    @Override // android.app.Activity
    protected void onPause() {
        try {
            super.onPause();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.offlineservice.AMapPermissionActivity, android.app.Activity
    public void onResume() {
        try {
            super.onResume();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onStart() {
        try {
            super.onStart();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onStop() {
        try {
            super.onStop();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void showScr() {
        try {
            setContentView(this.f10802b.g());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (a(bundle)) {
                return;
            }
            a aVar = this.f10802b;
            if (aVar != null) {
                aVar.h();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(Bundle bundle) {
        try {
            int i4 = f10801a;
            if ((i4 != 1 || this.f10802b == null) && i4 > 1) {
                f10801a = i4 - 1;
                int i5 = ((this.f10805e - 1) + 32) % 32;
                this.f10805e = i5;
                s3 s3Var = this.f10804d[i5];
                s3Var.f8934b = bundle;
                a(s3Var);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
