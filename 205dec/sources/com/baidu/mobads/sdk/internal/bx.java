package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.cb;
import com.baidu.mobads.sdk.internal.ck;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class bx extends Thread {

    /* renamed from: b  reason: collision with root package name */
    private static final String f12561b = "ApkDownloadThread";

    /* renamed from: c  reason: collision with root package name */
    private static final int f12562c = 900000;

    /* renamed from: h  reason: collision with root package name */
    private static volatile bx f12563h;

    /* renamed from: d  reason: collision with root package name */
    private volatile String f12565d;

    /* renamed from: e  reason: collision with root package name */
    private String f12566e;

    /* renamed from: f  reason: collision with root package name */
    private double f12567f;

    /* renamed from: g  reason: collision with root package name */
    private Handler f12568g;

    /* renamed from: i  reason: collision with root package name */
    private final Context f12569i;

    /* renamed from: k  reason: collision with root package name */
    private final bz f12571k;

    /* renamed from: j  reason: collision with root package name */
    private ck f12570j = null;

    /* renamed from: l  reason: collision with root package name */
    private bv f12572l = bv.a();

    /* renamed from: a  reason: collision with root package name */
    ck.a f12564a = new by(this);

    private bx(Context context, bz bzVar, String str, Handler handler) {
        this.f12566e = null;
        this.f12569i = context;
        this.f12571k = bzVar;
        a(bzVar.c());
        this.f12568g = handler;
        this.f12566e = str;
    }

    private boolean b() {
        double d4;
        try {
            try {
                this.f12570j = new ck(this.f12569i, new URL(this.f12565d), this.f12571k, this.f12564a);
            } catch (MalformedURLException unused) {
                this.f12570j = new ck(this.f12569i, this.f12565d, this.f12571k, this.f12564a);
            }
            if (cb.f12604q != null) {
                d4 = cb.f12604q.f12520b;
            } else if (cb.f12603p == null) {
                d4 = 0.0d;
            } else if (cb.f12603p.f12520b > 0.0d) {
                d4 = cb.f12603p.f12520b;
            } else {
                d4 = cb.f12603p.f12520b;
            }
            this.f12572l.a(f12561b, "isNewApkAvailable: local apk version is: " + d4 + ", remote apk version: " + this.f12571k.b());
            if (d4 > 0.0d) {
                if (this.f12571k.b() > 0.0d) {
                    this.f12572l.a(f12561b, "remote not null, local apk version is null, force upgrade");
                    this.f12567f = this.f12571k.b();
                    return true;
                }
                this.f12572l.a(f12561b, "remote is null, local apk version is null, do not upgrade");
                return false;
            } else if (this.f12571k.b() <= 0.0d) {
                this.f12572l.a(f12561b, "remote apk version is: null, local apk version is: " + d4 + ", do not upgrade");
                return false;
            } else if (this.f12571k.b() > d4) {
                this.f12567f = this.f12571k.b();
                return true;
            } else {
                return false;
            }
        } catch (Exception e4) {
            String str = "parse apk failed, error:" + e4.toString();
            this.f12572l.a(f12561b, str);
            throw new cb.a(str);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (b()) {
                try {
                    a();
                    this.f12572l.a(f12561b, "download apk successfully, downloader exit");
                    f12563h = null;
                } catch (IOException e4) {
                    bv bvVar = this.f12572l;
                    bvVar.a(f12561b, "create File or HTTP Get failed, exception: " + e4.getMessage());
                }
                this.f12572l.a(f12561b, "no newer apk, downloader exit");
                f12563h = null;
            }
        } catch (Throwable unused) {
        }
    }

    public static bx a(Context context, bz bzVar, String str, Handler handler) {
        if (f12563h == null) {
            f12563h = new bx(context, bzVar, str, handler);
        }
        return f12563h;
    }

    public void a(String str) {
        this.f12565d = str;
        interrupt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, bz bzVar, String str2) {
        if (str.equals("OK") || str.equals("ERROR")) {
            Message obtainMessage = this.f12568g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable("APK_INFO", bzVar);
            bundle.putString("CODE", str);
            obtainMessage.setData(bundle);
            this.f12568g.sendMessage(obtainMessage);
        }
    }

    private String a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f12566e + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f12570j.a(this.f12566e, str);
            return str2;
        } catch (IOException e4) {
            file.delete();
            throw e4;
        }
    }
}
