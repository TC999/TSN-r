package com.baidu.mobads.sdk.internal;

import android.content.Context;
import com.baidu.mobads.sdk.internal.InterfaceC2725v;
import com.clj.fastble.BleManager;
import io.netty.handler.codec.http.HttpHeaders;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Observable;

/* renamed from: com.baidu.mobads.sdk.internal.am */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class RunnableC2593am extends Observable implements InterfaceC2725v, Runnable {

    /* renamed from: i */
    protected static final int f8566i = 10240;

    /* renamed from: j */
    protected static final int f8567j = 10240;

    /* renamed from: k */
    public static final String f8568k = ".tmp";

    /* renamed from: m */
    private static final String f8569m = "FileDownloader";

    /* renamed from: a */
    protected Context f8570a;

    /* renamed from: b */
    protected URL f8571b;

    /* renamed from: c */
    protected String f8572c;

    /* renamed from: d */
    protected String f8573d;

    /* renamed from: e */
    protected int f8574e;

    /* renamed from: f */
    protected InterfaceC2725v.EnumC2726a f8575f;

    /* renamed from: g */
    protected int f8576g;

    /* renamed from: h */
    protected int f8577h;

    /* renamed from: l */
    protected byte[] f8578l;

    /* renamed from: n */
    private boolean f8579n;

    public RunnableC2593am(Context context, URL url, String str, String str2, boolean z) {
        this.f8570a = context;
        this.f8571b = url;
        this.f8572c = str;
        this.f8579n = z;
        if (str2 != null && str2.trim().length() > 0) {
            this.f8573d = str2;
        } else {
            String file = url.getFile();
            this.f8573d = file.substring(file.lastIndexOf(47) + 1);
        }
        this.f8574e = -1;
        this.f8575f = InterfaceC2725v.EnumC2726a.DOWNLOADING;
        this.f8576g = 0;
        this.f8577h = 0;
    }

    /* renamed from: s */
    private void m51016s() {
        m51022a(InterfaceC2725v.EnumC2726a.ERROR);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    /* renamed from: a */
    public void mo50316a() {
        m51022a(InterfaceC2725v.EnumC2726a.DOWNLOADING);
        m51019p();
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    /* renamed from: a */
    public void mo50315a(boolean z) {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    @Deprecated
    /* renamed from: b */
    public void mo50314b() {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    @Deprecated
    /* renamed from: c */
    public void mo50313c() {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    @Deprecated
    /* renamed from: d */
    public void mo50312d() {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    /* renamed from: e */
    public String mo50311e() {
        return this.f8571b.toString();
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    @Deprecated
    /* renamed from: f */
    public String mo50310f() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    /* renamed from: g */
    public String mo50309g() {
        return this.f8572c + this.f8573d;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    @Deprecated
    /* renamed from: h */
    public String mo50308h() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    @Deprecated
    /* renamed from: i */
    public String mo50307i() {
        return null;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    /* renamed from: j */
    public int mo50306j() {
        return this.f8574e;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    /* renamed from: k */
    public float mo50305k() {
        return Math.abs((this.f8576g / this.f8574e) * 100.0f);
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    /* renamed from: l */
    public InterfaceC2725v.EnumC2726a mo50304l() {
        return this.f8575f;
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    /* renamed from: m */
    public void mo50303m() {
    }

    @Override // com.baidu.mobads.sdk.internal.InterfaceC2725v
    /* renamed from: n */
    public boolean mo50302n() {
        return false;
    }

    /* renamed from: o */
    public byte[] m51020o() {
        return this.f8578l;
    }

    /* renamed from: p */
    protected void m51019p() {
        C2614bb.m50841a().m50837a(this);
    }

    /* renamed from: q */
    protected void m51018q() {
        setChanged();
        notifyObservers();
    }

    /* renamed from: r */
    protected void m51017r() {
        C2631bq.m50755a(this.f8572c + this.f8573d + ".tmp", this.f8572c + this.f8573d);
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
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.mobads.sdk.internal.RunnableC2593am.run():void");
    }

    /* renamed from: a */
    protected void m51022a(InterfaceC2725v.EnumC2726a enumC2726a) {
        this.f8575f = enumC2726a;
        m51018q();
    }

    /* renamed from: a */
    protected void m51023a(int i, float f) {
        this.f8576g += i;
        m51018q();
    }

    /* renamed from: a */
    private HttpURLConnection m51021a(HttpURLConnection httpURLConnection) {
        while (true) {
            try {
                int responseCode = httpURLConnection.getResponseCode();
                if (responseCode != 302 && responseCode != 301) {
                    return httpURLConnection;
                }
                URL url = new URL(httpURLConnection.getHeaderField(HttpHeaders.Names.LOCATION));
                this.f8571b = url;
                HttpURLConnection httpURLConnection2 = (HttpURLConnection) url.openConnection();
                try {
                    httpURLConnection2.setConnectTimeout(BleManager.f22896l);
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
