package com.bytedance.sdk.openadsdk.tools;

import com.bytedance.sdk.component.gd.p;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.api.TTILog;
import com.bytedance.sdk.openadsdk.n.f;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public final class c implements TTILog {

    /* renamed from: c  reason: collision with root package name */
    private final TTILog f36291c;

    /* renamed from: w  reason: collision with root package name */
    private w f36292w = new w();

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.bytedance.sdk.openadsdk.tools.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public interface InterfaceC0533c {
        void c(String str, String str2);
    }

    public c(TTILog tTILog) {
        this.f36291c = tTILog;
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void d(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            c(str, str2, new InterfaceC0533c() { // from class: com.bytedance.sdk.openadsdk.tools.c.2
                @Override // com.bytedance.sdk.openadsdk.tools.c.InterfaceC0533c
                public void c(String str3, String str4) {
                    c.this.f36291c.d(str3, str4);
                }
            });
        } else {
            this.f36291c.d(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void e(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            c(str, str2, new InterfaceC0533c() { // from class: com.bytedance.sdk.openadsdk.tools.c.5
                @Override // com.bytedance.sdk.openadsdk.tools.c.InterfaceC0533c
                public void c(String str3, String str4) {
                    c.this.f36291c.e(str3, str4);
                }
            });
        } else {
            this.f36291c.e(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void flush() {
        this.f36291c.flush();
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void forceLogSharding() {
        this.f36291c.forceLogSharding();
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void i(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            c(str, str2, new InterfaceC0533c() { // from class: com.bytedance.sdk.openadsdk.tools.c.3
                @Override // com.bytedance.sdk.openadsdk.tools.c.InterfaceC0533c
                public void c(String str3, String str4) {
                    c.this.f36291c.i(str3, str4);
                }
            });
        } else {
            this.f36291c.i(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void v(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            c(str, str2, new InterfaceC0533c() { // from class: com.bytedance.sdk.openadsdk.tools.c.1
                @Override // com.bytedance.sdk.openadsdk.tools.c.InterfaceC0533c
                public void c(String str3, String str4) {
                    c.this.f36291c.v(str3, str4);
                }
            });
        } else {
            this.f36291c.v(str, str2);
        }
    }

    private void c(final String str, final String str2, final InterfaceC0533c interfaceC0533c) {
        try {
            if (f.c()) {
                f.w(new p("log-big-str") { // from class: com.bytedance.sdk.openadsdk.tools.c.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.f36292w.c(str, str2, interfaceC0533c);
                    }
                });
            } else {
                this.f36292w.c(str, str2, interfaceC0533c);
            }
        } catch (Throwable th) {
            a.w("", "print big Str failed!", th);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void w(String str, String str2) {
        if (str2 != null && str2.length() > 4096) {
            c(str, str2, new InterfaceC0533c() { // from class: com.bytedance.sdk.openadsdk.tools.c.4
                @Override // com.bytedance.sdk.openadsdk.tools.c.InterfaceC0533c
                public void c(String str3, String str4) {
                    c.this.f36291c.w(str3, str4);
                }
            });
        } else {
            this.f36291c.w(str, str2);
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void e(String str, String str2, Throwable th) {
        this.f36291c.e(str, str2, th);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6241084.dex */
    public class w {
        private w() {
        }

        void c(String str, String str2, InterfaceC0533c interfaceC0533c) {
            String hexString = Integer.toHexString(str2.hashCode());
            int i4 = 0;
            while (i4 < str2.length()) {
                int min = Math.min(i4 + 4096, str2.length());
                interfaceC0533c.c(c(str, hexString, i4, min), str2.substring(i4, min));
                i4 = min;
            }
        }

        private String c(String str, String str2, int i4, int i5) {
            return str + "_" + i4 + "_" + i5 + "_" + str2;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void e(String str, Throwable th) {
        this.f36291c.e(str, th);
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void w(String str, Throwable th) {
        this.f36291c.w(str, th);
    }

    @Override // com.bytedance.sdk.openadsdk.api.TTILog
    public void w(String str, String str2, Throwable th) {
        this.f36291c.w(str, str2, th);
    }
}
