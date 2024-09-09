package com.qq.e.dl.j;

import android.graphics.Bitmap;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.t;
import com.qq.e.dl.b;
import java.io.File;
import java.util.concurrent.ConcurrentHashMap;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46994a = "b";

    /* renamed from: b  reason: collision with root package name */
    private static final ConcurrentHashMap<String, Integer> f46995b = new ConcurrentHashMap<>();

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f46996c = Pattern.compile("(ofs_)(-?[0-9]{1,2})(_.*)");

    /* compiled from: A */
    /* renamed from: com.qq.e.dl.j.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface InterfaceC0917b {
        void a(int i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x006f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void a(com.qq.e.dl.b r8, java.lang.String r9, com.qq.e.dl.j.b.InterfaceC0917b r10) {
        /*
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Integer> r0 = com.qq.e.dl.j.b.f46995b
            java.lang.Object r0 = r0.get(r9)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L12
            int r8 = r0.intValue()
            r10.a(r8)
            return
        L12:
            java.util.regex.Pattern r0 = com.qq.e.dl.j.b.f46996c
            java.util.regex.Matcher r0 = r0.matcher(r9)
            r1 = 1
            r2 = 0
            boolean r3 = r0.find()     // Catch: java.lang.Throwable -> L56
            if (r3 == 0) goto L53
            r3 = 2
            java.lang.String r4 = r0.group(r3)     // Catch: java.lang.Throwable -> L56
            r4.getClass()     // Catch: java.lang.Throwable -> L56
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Throwable -> L56
            int r4 = java.lang.Integer.parseInt(r4)     // Catch: java.lang.Throwable -> L56
            r5 = 3
            java.lang.String r0 = r0.group(r5)     // Catch: java.lang.Throwable -> L50
            r0.getClass()     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = (java.lang.String) r0     // Catch: java.lang.Throwable -> L50
            java.lang.String r0 = r0.substring(r1)     // Catch: java.lang.Throwable -> L50
            java.lang.String r5 = com.qq.e.dl.j.b.f46994a     // Catch: java.lang.Throwable -> L4e
            java.lang.String r6 = "offset = %s  imageUrl = %s"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L4e
            java.lang.Integer r7 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Throwable -> L4e
            r3[r2] = r7     // Catch: java.lang.Throwable -> L4e
            r3[r1] = r0     // Catch: java.lang.Throwable -> L4e
            com.qq.e.comm.plugin.util.d1.a(r5, r6, r3)     // Catch: java.lang.Throwable -> L4e
            goto L61
        L4e:
            r3 = move-exception
            goto L5a
        L50:
            r0 = move-exception
            r3 = r0
            goto L59
        L53:
            r0 = r9
            r4 = 0
            goto L61
        L56:
            r0 = move-exception
            r3 = r0
            r4 = 0
        L59:
            r0 = r9
        L5a:
            java.lang.String r5 = com.qq.e.dl.j.b.f46994a
            java.lang.String r6 = "ColorUrl exception"
            com.qq.e.comm.plugin.util.d1.a(r5, r6, r3)
        L61:
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L6f
            java.lang.String r8 = com.qq.e.dl.j.b.f46994a
            java.lang.String r9 = " Invalid imageUrl"
            com.qq.e.comm.plugin.util.d1.b(r8, r9)
            return
        L6f:
            java.lang.String r3 = com.qq.e.dl.j.b.f46994a
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r0
            java.lang.String r2 = "Load image , url = %s"
            com.qq.e.comm.plugin.util.d1.a(r3, r2, r1)
            com.qq.e.dl.j.b$a r1 = new com.qq.e.dl.j.b$a
            r1.<init>(r9, r4, r10)
            r8.a(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.qq.e.dl.j.b.a(com.qq.e.dl.b, java.lang.String, com.qq.e.dl.j.b$b):void");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a implements b.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f46997a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f46998b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InterfaceC0917b f46999c;

        /* compiled from: A */
        /* renamed from: com.qq.e.dl.j.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0916a implements Runnable {

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Integer f47000c;

            RunnableC0916a(Integer num) {
                this.f47000c = num;
            }

            @Override // java.lang.Runnable
            public void run() {
                a.this.f46999c.a(this.f47000c.intValue());
            }
        }

        a(String str, int i4, InterfaceC0917b interfaceC0917b) {
            this.f46997a = str;
            this.f46998b = i4;
            this.f46999c = interfaceC0917b;
        }

        @Override // com.qq.e.dl.b.a
        public void a(File file, Object obj) {
            Integer num = (Integer) b.f46995b.get(this.f46997a);
            if (num != null) {
                d1.a(b.f46994a, "use cache color");
            } else {
                Bitmap b4 = file != null ? t.b(file, null) : null;
                if (b4 == null) {
                    return;
                }
                num = Integer.valueOf(com.qq.e.lib.d.c.a(b4, this.f46998b));
                b.f46995b.put(this.f46997a, num);
            }
            p0.a((Runnable) new RunnableC0916a(num));
        }

        @Override // com.qq.e.dl.b.a
        public void a(Object obj, int i4, Exception exc) {
            d1.a(b.f46994a, "onFailed errorCode = %s", Integer.valueOf(i4));
        }
    }
}
