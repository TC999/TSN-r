package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.mobads.sdk.internal.C2640by;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.baidu.mobads.sdk.internal.ca */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HandlerC2647ca extends Handler {

    /* renamed from: a */
    final /* synthetic */ C2640by f8797a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2647ca(C2640by c2640by, Looper looper) {
        super(looper);
        this.f8797a = c2640by;
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        C2634bs c2634bs;
        boolean z;
        Context context;
        C2634bs c2634bs2;
        boolean z2;
        boolean m50657p;
        String string = message.getData().getString(C2640by.f8776n);
        C2638bw c2638bw = (C2638bw) message.getData().getParcelable(C2640by.f8775m);
        if (C2640by.f8773k.equals(string)) {
            String m50710e = c2638bw.m50710e();
            context = this.f8797a.f8790y;
            C2632br c2632br = new C2632br(m50710e, context, c2638bw);
            try {
                try {
                    C2640by c2640by = this.f8797a;
                    if (c2640by.f8787u != C2640by.f8782t) {
                        c2640by.m50703a(c2632br);
                        c2632br.m50751a(C2640by.m50669f());
                        this.f8797a.m50692a(true);
                    } else {
                        c2632br.m50754a();
                        c2632br.m50751a(C2640by.m50669f());
                        if (C2640by.f8778p != null) {
                            C2640by.f8778p.f8701b = c2638bw.m50713b();
                        }
                        this.f8797a.m50661l();
                        z2 = this.f8797a.f8784A;
                        if (z2) {
                            this.f8797a.f8784A = false;
                            C2640by c2640by2 = this.f8797a;
                            m50657p = c2640by2.m50657p();
                            c2640by2.m50691a(m50657p, "load remote file just downloaded");
                        }
                    }
                } catch (C2640by.C2641a e) {
                    this.f8797a.m50692a(false);
                    c2634bs2 = this.f8797a.f8791z;
                    c2634bs2.m50740a(C2640by.f8763a, "download apk file failed: " + e.toString());
                }
                return;
            } finally {
                c2632br.delete();
            }
        }
        c2634bs = this.f8797a.f8791z;
        c2634bs.m50740a(C2640by.f8763a, "mOnApkDownloadCompleted: download failed, code: " + string);
        this.f8797a.m50692a(false);
        z = this.f8797a.f8784A;
        if (z) {
            this.f8797a.f8784A = false;
            this.f8797a.m50691a(false, "Refused to download remote for version...");
        }
    }
}
