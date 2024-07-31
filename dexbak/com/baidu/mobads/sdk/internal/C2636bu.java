package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.mobads.sdk.internal.C2640by;
import com.baidu.mobads.sdk.internal.C2654ch;
import com.github.mikephil.charting.utils.Utils;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

/* renamed from: com.baidu.mobads.sdk.internal.bu */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C2636bu extends Thread {

    /* renamed from: b */
    private static final String f8741b = "ApkDownloadThread";

    /* renamed from: c */
    private static final int f8742c = 900000;

    /* renamed from: h */
    private static volatile C2636bu f8743h;

    /* renamed from: d */
    private volatile String f8745d;

    /* renamed from: e */
    private String f8746e;

    /* renamed from: f */
    private double f8747f;

    /* renamed from: g */
    private Handler f8748g;

    /* renamed from: i */
    private final Context f8749i;

    /* renamed from: k */
    private final C2638bw f8751k;

    /* renamed from: j */
    private C2654ch f8750j = null;

    /* renamed from: l */
    private C2634bs f8752l = C2634bs.m50744a();

    /* renamed from: a */
    C2654ch.InterfaceC2655a f8744a = new C2637bv(this);

    private C2636bu(Context context, C2638bw c2638bw, String str, Handler handler) {
        this.f8746e = null;
        this.f8749i = context;
        this.f8751k = c2638bw;
        m50717a(c2638bw.m50712c());
        this.f8748g = handler;
        this.f8746e = str;
    }

    /* renamed from: b */
    private boolean m50715b() {
        double d;
        try {
            try {
                this.f8750j = new C2654ch(this.f8749i, new URL(this.f8745d), this.f8751k, this.f8744a);
            } catch (MalformedURLException unused) {
                this.f8750j = new C2654ch(this.f8749i, this.f8745d, this.f8751k, this.f8744a);
            }
            if (C2640by.f8779q != null) {
                d = C2640by.f8779q.f8701b;
            } else if (C2640by.f8778p == null) {
                d = 0.0d;
            } else if (C2640by.f8778p.f8701b > Utils.DOUBLE_EPSILON) {
                d = C2640by.f8778p.f8701b;
            } else {
                d = C2640by.f8778p.f8701b;
            }
            this.f8752l.m50740a(f8741b, "isNewApkAvailable: local apk version is: " + d + ", remote apk version: " + this.f8751k.m50713b());
            if (d > Utils.DOUBLE_EPSILON) {
                if (this.f8751k.m50713b() > Utils.DOUBLE_EPSILON) {
                    this.f8752l.m50740a(f8741b, "remote not null, local apk version is null, force upgrade");
                    this.f8747f = this.f8751k.m50713b();
                    return true;
                }
                this.f8752l.m50740a(f8741b, "remote is null, local apk version is null, do not upgrade");
                return false;
            } else if (this.f8751k.m50713b() <= Utils.DOUBLE_EPSILON) {
                this.f8752l.m50740a(f8741b, "remote apk version is: null, local apk version is: " + d + ", do not upgrade");
                return false;
            } else if (this.f8751k.m50713b() > d) {
                this.f8747f = this.f8751k.m50713b();
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            String str = "parse apk failed, error:" + e.toString();
            this.f8752l.m50740a(f8741b, str);
            throw new C2640by.C2641a(str);
        }
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public void run() {
        try {
            if (m50715b()) {
                try {
                    m50721a();
                    this.f8752l.m50740a(f8741b, "download apk successfully, downloader exit");
                    f8743h = null;
                } catch (IOException e) {
                    C2634bs c2634bs = this.f8752l;
                    c2634bs.m50740a(f8741b, "create File or HTTP Get failed, exception: " + e.getMessage());
                }
                this.f8752l.m50740a(f8741b, "no newer apk, downloader exit");
                f8743h = null;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public static C2636bu m50720a(Context context, C2638bw c2638bw, String str, Handler handler) {
        if (f8743h == null) {
            f8743h = new C2636bu(context, c2638bw, str, handler);
        }
        return f8743h;
    }

    /* renamed from: a */
    public void m50717a(String str) {
        this.f8745d = str;
        interrupt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m50716a(String str, C2638bw c2638bw, String str2) {
        if (str.equals(C2640by.f8773k) || str.equals(C2640by.f8774l)) {
            Message obtainMessage = this.f8748g.obtainMessage();
            Bundle bundle = new Bundle();
            bundle.putParcelable(C2640by.f8775m, c2638bw);
            bundle.putString(C2640by.f8776n, str);
            obtainMessage.setData(bundle);
            this.f8748g.sendMessage(obtainMessage);
        }
    }

    /* renamed from: a */
    private String m50721a() {
        String str = "__xadsdk__remote__final__" + UUID.randomUUID().toString() + ".jar";
        String str2 = this.f8746e + str;
        File file = new File(str2);
        try {
            file.createNewFile();
            this.f8750j.m50649a(this.f8746e, str);
            return str2;
        } catch (IOException e) {
            file.delete();
            throw e;
        }
    }
}
