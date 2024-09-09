package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.internal.v;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class am extends Observable implements v, Runnable {

    /* renamed from: i  reason: collision with root package name */
    protected static final int f12359i = 10240;

    /* renamed from: j  reason: collision with root package name */
    protected static final int f12360j = 10240;

    /* renamed from: k  reason: collision with root package name */
    public static final String f12361k = ".tmp";

    /* renamed from: m  reason: collision with root package name */
    private static final String f12362m = "FileDownloader";

    /* renamed from: a  reason: collision with root package name */
    protected Context f12363a;

    /* renamed from: b  reason: collision with root package name */
    protected URL f12364b;

    /* renamed from: c  reason: collision with root package name */
    protected String f12365c;

    /* renamed from: d  reason: collision with root package name */
    protected String f12366d;

    /* renamed from: e  reason: collision with root package name */
    protected int f12367e;

    /* renamed from: f  reason: collision with root package name */
    protected v.a f12368f;

    /* renamed from: g  reason: collision with root package name */
    protected int f12369g;

    /* renamed from: h  reason: collision with root package name */
    protected int f12370h;

    /* renamed from: l  reason: collision with root package name */
    protected byte[] f12371l;

    /* renamed from: n  reason: collision with root package name */
    private boolean f12372n;

    public am(Context context, URL url, String str, String str2, boolean z3) {
        this.f12363a = context;
        this.f12364b = url;
        this.f12365c = str;
        this.f12372n = z3;
        if (str2 != null && str2.trim().length() > 0) {
            this.f12366d = str2;
        } else {
            String file = url.getFile();
            this.f12366d = file.substring(file.lastIndexOf(47) + 1);
        }
        this.f12367e = -1;
        this.f12368f = v.a.DOWNLOADING;
        this.f12369g = 0;
        this.f12370h = 0;
    }

    private void s() {
        a(v.a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public void a() {
        a(v.a.DOWNLOADING);
        p();
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public void a(boolean z3) {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public void b() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public void c() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public void d() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public String e() {
        return this.f12364b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public String f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public String g() {
        return this.f12365c + this.f12366d;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public String h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    @Deprecated
    public String i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public int j() {
        return this.f12367e;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public float k() {
        return Math.abs((this.f12369g / this.f12367e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public v.a l() {
        return this.f12368f;
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public void m() {
    }

    @Override // com.baidu.mobads.sdk.internal.v
    public boolean n() {
        return false;
    }

    public byte[] o() {
        return this.f12371l;
    }

    protected void p() {
        be.a().a(this);
    }

    protected void q() {
        setChanged();
        notifyObservers();
    }

    protected void r() {
        bt.a(this.f12365c + this.f12366d + ".tmp", this.f12365c + this.f12366d);
    }

    /* JADX WARN: Removed duplicated region for block: B:120:0x01ee A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01d6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:130:0x01be A[EXC_TOP_SPLITTER, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 526
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.am.run():void");
    }

    protected void a(v.a aVar) {
        this.f12368f = aVar;
        q();
    }

    protected void a(int i4, float f4) {
        this.f12369g += i4;
        q();
    }

    private HttpURLConnection a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField("Location"));
                this.f12364b = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(10000);
                    httpURLConnection2.setInstanceFollowRedirects(false);
                    httpURLConnection2.setRequestProperty("Range", "bytes=0-");
                    httpURLConnection = httpURLConnection2;
                } catch (Exception unused) {
                    return httpURLConnection2;
                }
            } catch (Exception unused2) {
                return httpURLConnection;
            }
        }
    }
}
