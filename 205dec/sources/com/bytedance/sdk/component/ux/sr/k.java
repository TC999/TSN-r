package com.bytedance.sdk.component.ux.sr;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k extends c {
    @Override // com.bytedance.sdk.component.ux.sr.gd
    public String c() {
        return "net_request";
    }

    @Override // com.bytedance.sdk.component.ux.sr.gd
    public void c(final com.bytedance.sdk.component.ux.xv.xv xvVar) {
        final com.bytedance.sdk.component.ux.xv.f u3 = xvVar.u();
        com.bytedance.sdk.component.ux.sr sr = u3.sr();
        xvVar.c(false);
        try {
            com.bytedance.sdk.component.ux.f call = sr.call(new com.bytedance.sdk.component.ux.w.xv(xvVar.w(), xvVar.t(), xvVar.ys(), xvVar.j()));
            int w3 = call.w();
            xvVar.c(call.c());
            if (call.w() == 200) {
                final byte[] bArr = (byte[]) call.xv();
                xvVar.c(new w(bArr, call));
                final String f4 = xvVar.f();
                final com.bytedance.sdk.component.ux.w i4 = xvVar.i();
                if (i4.xv()) {
                    u3.w(xvVar.i()).c(f4, bArr);
                }
                u3.f().submit(new Runnable() { // from class: com.bytedance.sdk.component.ux.sr.k.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (i4.sr()) {
                            u3.xv(xvVar.i()).c(f4, bArr);
                        }
                    }
                });
                return;
            }
            u3.ev().c(String.valueOf(call));
            Object xv = call.xv();
            c(w3, call.sr(), xv instanceof Throwable ? (Throwable) xv : null, xvVar);
        } catch (Throwable th) {
            c(1004, "net request failed!", th, xvVar);
        }
    }

    private void c(int i4, String str, Throwable th, com.bytedance.sdk.component.ux.xv.xv xvVar) {
        xvVar.c(new ev(i4, str, th));
    }
}
