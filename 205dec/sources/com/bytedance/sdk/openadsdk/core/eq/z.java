package com.bytedance.sdk.openadsdk.core.eq;

import android.content.Context;
import android.text.TextUtils;
import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import java.io.File;
import java.io.PrintWriter;
import java.io.StringWriter;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class z {

    /* renamed from: c  reason: collision with root package name */
    private String f33371c;

    private z() {
        w();
    }

    public static z c() {
        return new z();
    }

    private void w() {
        File c4;
        Context context = com.bytedance.sdk.openadsdk.core.ls.getContext();
        if (context == null) {
            return;
        }
        try {
            if ("mounted".equals(com.bytedance.sdk.openadsdk.n.xv.c()) && (c4 = com.bytedance.sdk.openadsdk.api.plugin.w.c(context, "TTCache")) != null) {
                c4.mkdirs();
                this.f33371c = c4.getPath();
            }
            if (TextUtils.isEmpty(this.f33371c)) {
                File file = new File(com.bytedance.sdk.openadsdk.api.plugin.w.c(context), "TTCache");
                file.mkdirs();
                this.f33371c = file.getPath();
            }
        } catch (Throwable unused) {
        }
    }

    private void xv() {
        try {
            com.bytedance.sdk.openadsdk.core.component.splash.p.c(com.bytedance.sdk.openadsdk.core.ls.getContext());
        } catch (Throwable unused) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.component.reward.gd.ux();
        } catch (Throwable unused2) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.z.ux.w();
        } catch (Throwable unused3) {
        }
        try {
            com.bytedance.sdk.component.adexpress.c.w.w.w();
            com.bytedance.sdk.openadsdk.core.ugeno.ux.c.w().f();
        } catch (Throwable unused4) {
        }
        try {
            Bridge u3 = com.bytedance.sdk.openadsdk.core.k.sr().u();
            if (u3 != null) {
                u3.call(7, b.f24740c, Void.class);
            }
        } catch (Throwable unused5) {
        }
        try {
            com.bytedance.sdk.openadsdk.core.xv.sr.c().gd();
        } catch (Throwable unused6) {
        }
    }

    public void c(Thread thread, Throwable th) {
        try {
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            r0 = stringWriter2 != null ? stringWriter2.contains(TTAdConstant.class.getPackage().getName()) : false;
            com.bytedance.sdk.openadsdk.core.ux.sr.c().c(thread, th);
        } catch (Throwable unused) {
        }
        if (r0) {
            w(thread, th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:80:0x010e A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [java.io.OutputStream, java.io.FileOutputStream] */
    /* JADX WARN: Type inference failed for: r2v8 */
    /* JADX WARN: Type inference failed for: r2v9 */
    /* JADX WARN: Type inference failed for: r6v4, types: [java.util.Properties] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void w(java.lang.Thread r19, java.lang.Throwable r20) {
        /*
            Method dump skipped, instructions count: 295
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.eq.z.w(java.lang.Thread, java.lang.Throwable):void");
    }
}
