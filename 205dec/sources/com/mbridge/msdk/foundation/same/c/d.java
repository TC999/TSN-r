package com.mbridge.msdk.foundation.same.c;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.f;
import com.mbridge.msdk.foundation.same.net.k;
import com.mbridge.msdk.foundation.tools.x;
import java.io.File;

/* compiled from: CommonImageTask.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d extends com.mbridge.msdk.foundation.same.e.a {

    /* renamed from: a  reason: collision with root package name */
    private String f39450a;

    /* renamed from: b  reason: collision with root package name */
    private String f39451b;

    /* renamed from: c  reason: collision with root package name */
    private String f39452c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f39453d = false;

    /* renamed from: e  reason: collision with root package name */
    private a f39454e;

    /* compiled from: CommonImageTask.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        void a(String str, String str2);

        void b(String str, String str2);
    }

    public d(String str, String str2, String str3) {
        this.f39450a = str;
        this.f39451b = str2;
        this.f39452c = str3;
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void cancelTask() {
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void pauseTask(boolean z3) {
    }

    @Override // com.mbridge.msdk.foundation.same.e.a
    public final void runTask() {
        if (!this.f39453d) {
            if (TextUtils.isEmpty(this.f39452c)) {
                a(this.f39451b, "save path is null.");
                return;
            }
            File file = new File(this.f39452c);
            if (file.exists() && file.length() > 0) {
                a();
                return;
            } else {
                b();
                return;
            }
        }
        b();
    }

    private void b() {
        try {
            final File file = new File(this.f39452c);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            com.mbridge.msdk.foundation.same.net.g.b.a(file, this.f39451b, new f<Void>() { // from class: com.mbridge.msdk.foundation.same.c.d.1
                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void a(long j4, long j5) {
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void a(k kVar) {
                    x.a("ImageWorker", "download file from [" + d.this.f39451b + "] save to [" + d.this.f39452c + "]");
                    String unused = d.this.f39452c;
                    d.this.a();
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void b() {
                    x.b("ImageWorker", String.format("onFinish size : %s", Long.valueOf(file.length())));
                }

                @Override // com.mbridge.msdk.foundation.same.net.f, com.mbridge.msdk.foundation.same.net.e
                public final void a(com.mbridge.msdk.foundation.same.net.a.a aVar) {
                    d dVar = d.this;
                    String str = dVar.f39451b;
                    dVar.a(str, "load image from http faild because http return code: " + aVar.f39484a + ".image url is " + d.this.f39451b);
                }
            });
        } catch (Exception e4) {
            a(this.f39451b, e4.getMessage());
            if (MBridgeConstans.DEBUG) {
                e4.printStackTrace();
            }
        } catch (OutOfMemoryError e5) {
            a(this.f39451b, e5.getMessage());
        }
    }

    public final void a(boolean z3) {
        this.f39453d = z3;
    }

    public final void a(a aVar) {
        this.f39454e = aVar;
    }

    protected final void a() {
        if (new File(this.f39452c).exists()) {
            String str = this.f39451b;
            String str2 = this.f39452c;
            a aVar = this.f39454e;
            if (aVar != null) {
                aVar.a(str, str2);
                return;
            }
            return;
        }
        String str3 = "load image faild.because file[" + this.f39452c + "] is not exist!";
        x.a("ImageWorker", str3);
        a(this.f39451b, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(String str, String str2) {
        a aVar = this.f39454e;
        if (aVar != null) {
            aVar.b(str, str2);
        }
    }
}
