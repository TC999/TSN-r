package com.tencent.mm.opensdk.diffdev.a;

import android.os.AsyncTask;
import com.tencent.mm.opensdk.diffdev.OAuthErrCode;
import com.tencent.mm.opensdk.diffdev.OAuthListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class c extends AsyncTask<Void, Void, a> {

    /* renamed from: a  reason: collision with root package name */
    private String f51599a;

    /* renamed from: b  reason: collision with root package name */
    private String f51600b;

    /* renamed from: c  reason: collision with root package name */
    private OAuthListener f51601c;

    /* renamed from: d  reason: collision with root package name */
    private int f51602d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    static class a {

        /* renamed from: a  reason: collision with root package name */
        public OAuthErrCode f51603a;

        /* renamed from: b  reason: collision with root package name */
        public String f51604b;

        /* renamed from: c  reason: collision with root package name */
        public int f51605c;

        a() {
        }
    }

    public c(String str, OAuthListener oAuthListener) {
        this.f51599a = str;
        this.f51601c = oAuthListener;
        this.f51600b = String.format("https://long.open.weixin.qq.com/connect/l/qrconnect?f=json&uuid=%s", str);
    }

    /* JADX WARN: Removed duplicated region for block: B:44:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x0168 A[SYNTHETIC] */
    @Override // android.os.AsyncTask
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected com.tencent.mm.opensdk.diffdev.a.c.a doInBackground(java.lang.Void[] r14) {
        /*
            Method dump skipped, instructions count: 426
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.opensdk.diffdev.a.c.doInBackground(java.lang.Object[]):java.lang.Object");
    }

    @Override // android.os.AsyncTask
    protected void onPostExecute(a aVar) {
        a aVar2 = aVar;
        this.f51601c.onAuthFinish(aVar2.f51603a, aVar2.f51604b);
    }
}
