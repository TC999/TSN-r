package com.tencent.p562mm.opensdk.diffdev.p564a;

import android.os.AsyncTask;
import com.tencent.p562mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.p562mm.opensdk.diffdev.OAuthListener;

/* renamed from: com.tencent.mm.opensdk.diffdev.a.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
class AsyncTaskC12983c extends AsyncTask<Void, Void, C12984a> {

    /* renamed from: a */
    private String f37197a;

    /* renamed from: b */
    private String f37198b;

    /* renamed from: c */
    private OAuthListener f37199c;

    /* renamed from: d */
    private int f37200d;

    /* renamed from: com.tencent.mm.opensdk.diffdev.a.c$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    static class C12984a {

        /* renamed from: a */
        public OAuthErrCode f37201a;

        /* renamed from: b */
        public String f37202b;

        /* renamed from: c */
        public int f37203c;

        C12984a() {
        }
    }

    public AsyncTaskC12983c(String str, OAuthListener oAuthListener) {
        this.f37197a = str;
        this.f37199c = oAuthListener;
        this.f37198b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.tencent.p562mm.opensdk.diffdev.p564a.AsyncTaskC12983c.C12984a doInBackground(java.lang.Void[] r14) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.p562mm.opensdk.diffdev.p564a.AsyncTaskC12983c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(C12984a c12984a) {
        C12984a c12984a2 = c12984a;
        this.f37199c.onAuthFinish(c12984a2.f37201a, c12984a2.f37202b);
    }
}
