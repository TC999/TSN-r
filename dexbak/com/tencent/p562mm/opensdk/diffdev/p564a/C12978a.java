package com.tencent.p562mm.opensdk.diffdev.p564a;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import com.tencent.p562mm.opensdk.diffdev.IDiffDevOAuth;
import com.tencent.p562mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p562mm.opensdk.diffdev.OAuthListener;
import com.tencent.p562mm.opensdk.utils.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12978a implements IDiffDevOAuth {

    /* renamed from: c */
    private AsyncTaskC12981b f37181c;

    /* renamed from: a */
    private Handler f37179a = null;

    /* renamed from: b */
    private List<OAuthListener> f37180b = new ArrayList();

    /* renamed from: d */
    private OAuthListener f37182d = new C12979a();

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C12979a implements OAuthListener {

        /* renamed from: com.tencent.mm.opensdk.diffdev.a.a$a$a */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        class RunnableC12980a implements Runnable {
            RunnableC12980a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(C12978a.this.f37180b);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((OAuthListener) it.next()).onQrcodeScanned();
                }
            }
        }

        C12979a() {
        }

        @Override // com.tencent.p562mm.opensdk.diffdev.OAuthListener
        public void onAuthFinish(OAuthErrCode oAuthErrCode, String str) {
            Log.m15265d("MicroMsg.SDK.ListenerWrapper", String.format("onAuthFinish, errCode = %s, authCode = %s", oAuthErrCode.toString(), str));
            C12978a.this.f37181c = null;
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(C12978a.this.f37180b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthFinish(oAuthErrCode, str);
            }
        }

        @Override // com.tencent.p562mm.opensdk.diffdev.OAuthListener
        public void onAuthGotQrcode(String str, byte[] bArr) {
            Log.m15265d("MicroMsg.SDK.ListenerWrapper", "onAuthGotQrcode, qrcodeImgPath = " + str);
            ArrayList arrayList = new ArrayList();
            arrayList.addAll(C12978a.this.f37180b);
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((OAuthListener) it.next()).onAuthGotQrcode(str, bArr);
            }
        }

        @Override // com.tencent.p562mm.opensdk.diffdev.OAuthListener
        public void onQrcodeScanned() {
            Log.m15265d("MicroMsg.SDK.ListenerWrapper", "onQrcodeScanned");
            if (C12978a.this.f37179a != null) {
                C12978a.this.f37179a.post(new RunnableC12980a());
            }
        }
    }

    @Override // com.tencent.p562mm.opensdk.diffdev.IDiffDevOAuth
    public void addListener(OAuthListener oAuthListener) {
        if (this.f37180b.contains(oAuthListener)) {
            return;
        }
        this.f37180b.add(oAuthListener);
    }

    @Override // com.tencent.p562mm.opensdk.diffdev.IDiffDevOAuth
    public boolean auth(String str, String str2, String str3, String str4, String str5, OAuthListener oAuthListener) {
        Log.m15263i("MicroMsg.SDK.DiffDevOAuth", "start auth, appId = " + str);
        if (str != null && str.length() > 0 && str2 != null && str2.length() > 0) {
            if (this.f37179a == null) {
                this.f37179a = new Handler(Looper.getMainLooper());
            }
            if (!this.f37180b.contains(oAuthListener)) {
                this.f37180b.add(oAuthListener);
            }
            if (this.f37181c != null) {
                Log.m15265d("MicroMsg.SDK.DiffDevOAuth", "auth, already running, no need to start auth again");
                return true;
            }
            AsyncTaskC12981b asyncTaskC12981b = new AsyncTaskC12981b(str, str2, str3, str4, str5, this.f37182d);
            this.f37181c = asyncTaskC12981b;
            asyncTaskC12981b.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            return true;
        }
        Log.m15265d("MicroMsg.SDK.DiffDevOAuth", String.format("auth fail, invalid argument, appId = %s, scope = %s", str, str2));
        return false;
    }

    @Override // com.tencent.p562mm.opensdk.diffdev.IDiffDevOAuth
    public void detach() {
        Log.m15263i("MicroMsg.SDK.DiffDevOAuth", "detach");
        this.f37180b.clear();
        stopAuth();
    }

    @Override // com.tencent.p562mm.opensdk.diffdev.IDiffDevOAuth
    public void removeAllListeners() {
        this.f37180b.clear();
    }

    @Override // com.tencent.p562mm.opensdk.diffdev.IDiffDevOAuth
    public void removeListener(OAuthListener oAuthListener) {
        this.f37180b.remove(oAuthListener);
    }

    @Override // com.tencent.p562mm.opensdk.diffdev.IDiffDevOAuth
    public boolean stopAuth() {
        boolean z;
        Log.m15263i("MicroMsg.SDK.DiffDevOAuth", "stopAuth");
        try {
            AsyncTaskC12981b asyncTaskC12981b = this.f37181c;
            z = asyncTaskC12981b == null ? true : asyncTaskC12981b.m15273a();
        } catch (Exception e) {
            Log.m15261w("MicroMsg.SDK.DiffDevOAuth", "stopAuth fail, ex = " + e.getMessage());
            z = false;
        }
        this.f37181c = null;
        return z;
    }
}
