package com.bytedance.sdk.openadsdk.c.c;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.bytedance.sdk.openadsdk.core.eq;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.core.xv.ux;
import com.bytedance.sdk.openadsdk.ys.w.xv.sr;
import com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver;
import com.volcengine.mobsecBiz.metasec.ml.a;
import com.volcengine.mobsecBiz.metasec.ml.d;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f31643c = null;

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f31644f = "";
    private volatile int ev;

    /* renamed from: r  reason: collision with root package name */
    private final AtomicBoolean f31645r = new AtomicBoolean(false);
    private final String sr;
    private volatile String ux;

    /* renamed from: w  reason: collision with root package name */
    private com.volcengine.mobsecBiz.metasec.ml.c f31646w;
    private volatile boolean xv;

    private c(String str, sr srVar) {
        this.ev = 99999;
        if (srVar != null) {
            if (srVar.xv() && srVar.sr() && srVar.ux()) {
                if (!srVar.w()) {
                    this.ev = MediaPlayer.MEDIA_PLAYER_OPTION_RTC_STAT_INFO;
                }
            } else {
                this.ev = MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET;
            }
            if (eq.f33190w >= 4600 && !srVar.f()) {
                this.ev = MediaPlayer.MEDIA_PLAYER_OPTION_HTTP_AUTO_RANGE_OFFSET;
            }
        }
        this.ux = null;
        this.sr = str;
        this.xv = xv();
    }

    public static c c(String str, sr srVar) {
        if (f31643c == null) {
            synchronized (c.class) {
                if (f31643c == null) {
                    f31643c = new c(str, srVar);
                }
            }
        }
        return f31643c;
    }

    private void sr() {
        if (this.f31646w == null) {
            this.f31646w = d.a("1371");
        }
    }

    public void w(String str) {
        if (this.xv) {
            sr();
            com.volcengine.mobsecBiz.metasec.ml.c cVar = this.f31646w;
            if (cVar != null) {
                cVar.c(str);
            }
        }
    }

    private boolean xv() {
        try {
            Context context = ls.getContext();
            a.C1073a c1073a = new a.C1073a("1371", this.sr, "THYFfhd167Y/Etj/JFI+OYhGnAsIhCvIXKQbbKuslfRMO6XQmCuZImqOyljyF6dQ900Hy8ecQzUcHu72ks7Xvvncqt7BZjf4VSth/OzZbJlDJqtayy2lcb5mqCQUzE5fIvFXAZkyxl+SRzGnzUojBcyqITZ3bGRvteMi+qu/15oKM3BWY0IDJ9Ry5FUGfzt+FyCqvZI8PFQNAzvZXcWHlJoRXydZUjUbtEy/AFUvusIO1HDx", this.ev);
            c1073a.b(new PglITokenObserver() { // from class: com.bytedance.sdk.openadsdk.c.c.c.1
                @Override // com.volcengine.mobsecBiz.metasec.listener.PglITokenObserver
                public void onTokenLoaded(String str) {
                    String unused = c.f31644f = str;
                    if (TextUtils.isEmpty(str)) {
                        return;
                    }
                    ux.c().ck(str);
                }
            });
            d.b(context, c1073a.g(this.ux).f(1).h());
            d.c("1371");
            sr();
            return true;
        } catch (Throwable th) {
            com.bytedance.sdk.component.utils.a.w("MSSdkImpl", "appid \u4e3a\u7a7a\uff0c\u521d\u59cb\u5316\u5931\u8d25\uff01", th);
            return false;
        }
    }

    public static String w() {
        if (TextUtils.isEmpty(f31644f)) {
            f31644f = ux.c().ls();
        }
        return f31644f;
    }

    public static c c() {
        return f31643c;
    }

    public void c(String str) {
        if (this.xv) {
            sr();
            if (TextUtils.isEmpty(str) || str.equals(this.ux) || this.f31646w == null) {
                return;
            }
            this.ux = str;
            this.f31646w.w(str);
        }
    }

    public Map<String, String> c(String str, byte[] bArr) {
        if (!this.xv) {
            return new HashMap();
        }
        sr();
        com.volcengine.mobsecBiz.metasec.ml.c cVar = this.f31646w;
        if (cVar != null) {
            return cVar.c(str, bArr);
        }
        return new HashMap();
    }
}
