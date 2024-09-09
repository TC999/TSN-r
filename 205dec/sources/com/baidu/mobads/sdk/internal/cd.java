package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.cb;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class cd extends Handler {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ cb f12616a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public cd(cb cbVar, Looper looper) {
        super(looper);
        this.f12616a = cbVar;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        bv bvVar;
        boolean z3;
        Context context;
        bv bvVar2;
        boolean z4;
        boolean p3;
        String string = message.getData().getString("CODE");
        bz bzVar = (bz) message.getData().getParcelable("APK_INFO");
        if ("OK".equals(string)) {
            String e4 = bzVar.e();
            context = this.f12616a.f12612y;
            bu buVar = new bu(e4, context, bzVar);
            try {
                try {
                    cb cbVar = this.f12616a;
                    if (cbVar.f12609u != cb.f12607t) {
                        cbVar.a(buVar);
                        buVar.a(cb.f());
                        this.f12616a.a(true);
                    } else {
                        buVar.a();
                        buVar.a(cb.f());
                        if (cb.f12603p != null) {
                            cb.f12603p.f12520b = bzVar.b();
                        }
                        this.f12616a.l();
                        z4 = this.f12616a.A;
                        if (z4) {
                            this.f12616a.A = false;
                            cb cbVar2 = this.f12616a;
                            p3 = cbVar2.p();
                            cbVar2.a(p3, "load remote file just downloaded");
                        }
                    }
                } catch (cb.a e5) {
                    this.f12616a.a(false);
                    bvVar2 = this.f12616a.f12613z;
                    bvVar2.a("ApkLoader", "download apk file failed: " + e5.toString());
                }
                return;
            } finally {
                buVar.delete();
            }
        }
        bvVar = this.f12616a.f12613z;
        bvVar.a("ApkLoader", "mOnApkDownloadCompleted: download failed, code: " + string);
        this.f12616a.a(false);
        z3 = this.f12616a.A;
        if (z3) {
            this.f12616a.A = false;
            this.f12616a.a(false, "Refused to download remote for version...");
        }
    }
}
