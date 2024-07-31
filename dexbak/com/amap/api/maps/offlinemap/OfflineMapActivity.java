package com.amap.api.maps.offlinemap;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import com.amap.api.col.p0463l.OfflineMapPage;
import com.amap.api.col.p0463l.Page;
import com.amap.api.col.p0463l.ServiceUtils;
import com.amap.api.offlineservice.AMapPermissionActivity;
import com.amap.api.offlineservice.ServiceModule;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class OfflineMapActivity extends AMapPermissionActivity implements View.OnClickListener {

    /* renamed from: a */
    private static int f7103a;

    /* renamed from: b */
    private ServiceModule f7104b;

    /* renamed from: c */
    private Page f7105c;

    /* renamed from: d */
    private Page[] f7106d = new Page[32];

    /* renamed from: e */
    private int f7107e = -1;

    /* renamed from: f */
    private OfflineMapPage f7108f;

    /* renamed from: a */
    private void m51997a(Page page) {
        try {
            ServiceModule serviceModule = this.f7104b;
            if (serviceModule != null) {
                serviceModule.mo51962h();
                this.f7104b = null;
            }
            ServiceModule m51995c = m51995c(page);
            this.f7104b = m51995c;
            if (m51995c != null) {
                this.f7105c = page;
                m51995c.m51966d(this);
                this.f7104b.m51968b();
                this.f7104b.mo51965e();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: b */
    private void m51996b(Page page) {
        try {
            f7103a++;
            m51997a(page);
            int i = (this.f7107e + 1) % 32;
            this.f7107e = i;
            this.f7106d[i] = page;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private ServiceModule m51995c(Page page) {
        try {
            if (page.f5221a != 1) {
                return null;
            }
            if (this.f7108f == null) {
                this.f7108f = new OfflineMapPage();
            }
            return this.f7108f;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void closeScr() {
        try {
            if (m51998a((Bundle) null)) {
                return;
            }
            ServiceModule serviceModule = this.f7104b;
            if (serviceModule != null) {
                serviceModule.mo51962h();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            ServiceModule serviceModule = this.f7104b;
            if (serviceModule != null) {
                serviceModule.mo51967c(view);
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
            ServiceUtils.m53595f(StubApp.getOrigApplicationContext(getApplicationContext()));
            this.f7107e = -1;
            f7103a = 0;
            m51996b(new Page());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        try {
            super.onDestroy();
            ServiceModule serviceModule = this.f7104b;
            if (serviceModule != null) {
                serviceModule.mo51962h();
                this.f7104b = null;
            }
            this.f7105c = null;
            this.f7106d = null;
            OfflineMapPage offlineMapPage = this.f7108f;
            if (offlineMapPage != null) {
                offlineMapPage.mo51962h();
                this.f7108f = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            try {
                ServiceModule serviceModule = this.f7104b;
                if (serviceModule != null && !serviceModule.mo51964f()) {
                    return true;
                }
                if (m51998a((Bundle) null)) {
                    return false;
                }
                if (keyEvent == null) {
                    if (f7103a == 1) {
                        finish();
                    }
                    return false;
                }
                this.f7107e = -1;
                f7103a = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return super.onKeyDown(i, keyEvent);
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
            setContentView(this.f7104b.mo51963g());
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void closeScr(Bundle bundle) {
        try {
            if (m51998a(bundle)) {
                return;
            }
            ServiceModule serviceModule = this.f7104b;
            if (serviceModule != null) {
                serviceModule.mo51962h();
            }
            finish();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m51998a(Bundle bundle) {
        try {
            int i = f7103a;
            if ((i != 1 || this.f7104b == null) && i > 1) {
                f7103a = i - 1;
                int i2 = ((this.f7107e - 1) + 32) % 32;
                this.f7107e = i2;
                Page page = this.f7106d[i2];
                page.f5222b = bundle;
                m51997a(page);
                return true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }
}
