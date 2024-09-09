package com.kwad.library.solder.lib;

import android.content.Context;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.sdk.utils.q;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class h extends g {
    public h(String str) {
        super(str);
    }

    private Set<File> a(Context context, File file, File file2) {
        String[] list;
        a.a.a(file2);
        HashSet hashSet = new HashSet();
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            for (String str : list) {
                hashSet.add(new File(file2.getAbsolutePath() + File.separator + str));
            }
            return hashSet;
        }
        File file3 = new File(file2.getParentFile(), this.aiX.xD());
        q.X(file3);
        for (String str2 : com.kwad.library.solder.lib.d.c.b(file, file3)) {
            File a4 = com.kwad.library.solder.lib.d.c.a(file3, str2, file2);
            if (a4 != null) {
                hashSet.add(a4);
            }
        }
        q.R(file3);
        return hashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
        if (r3 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00af, code lost:
        throw new com.kwad.library.solder.lib.ext.PluginError.LoadError(new java.lang.Exception(r2 + " not found"), 4001);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void c(java.util.Set<java.io.File> r9) {
        /*
            r8 = this;
            com.kwad.library.solder.lib.c.b r0 = r8.ajy
            if (r0 == 0) goto Lb0
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.akl
            int r0 = r0.size()
            if (r0 <= 0) goto Lb0
            if (r9 == 0) goto Lb0
            com.kwad.library.solder.lib.c.b r0 = r8.ajy
            java.util.HashMap<java.lang.String, java.lang.String> r0 = r0.akl
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L1a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto Lb0
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getKey()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.Object r1 = r1.getValue()
            java.lang.String r1 = (java.lang.String) r1
            boolean r3 = android.text.TextUtils.isEmpty(r1)
            if (r3 != 0) goto L1a
            r3 = 0
            java.util.Iterator r4 = r9.iterator()
        L3d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L8f
            java.lang.Object r5 = r4.next()
            java.io.File r5 = (java.io.File) r5
            java.lang.String r6 = com.kwad.sdk.utils.ad.ab(r5)
            java.lang.String r7 = r5.getName()
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L3d
            r3 = 1
            boolean r4 = android.text.TextUtils.equals(r6, r1)
            if (r4 == 0) goto L5f
            goto L8f
        L5f:
            d(r9)
            com.kwad.library.solder.lib.ext.PluginError$LoadError r9 = new com.kwad.library.solder.lib.ext.PluginError$LoadError
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = r5.getName()
            r2.append(r3)
            java.lang.String r3 = " Md5 check error,find "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r3 = ",except "
            r2.append(r3)
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            r1 = 4008(0xfa8, float:5.616E-42)
            r9.<init>(r0, r1)
            throw r9
        L8f:
            if (r3 == 0) goto L92
            goto L1a
        L92:
            com.kwad.library.solder.lib.ext.PluginError$LoadError r9 = new com.kwad.library.solder.lib.ext.PluginError$LoadError
            java.lang.Exception r0 = new java.lang.Exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r2)
            java.lang.String r2 = " not found"
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            r1 = 4001(0xfa1, float:5.607E-42)
            r9.<init>(r0, r1)
            throw r9
        Lb0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.library.solder.lib.h.c(java.util.Set):void");
    }

    private static void d(Set<File> set) {
        for (File file : set) {
            q.R(file);
        }
    }

    private File f(File file) {
        File file2 = new File(file.getParentFile(), this.aiX.xC());
        q.X(file2);
        return file2;
    }

    @Override // com.kwad.library.solder.lib.g, com.kwad.library.solder.lib.a.a
    public void g(Context context, String str) {
        ClassLoader classLoader;
        super.g(context, str);
        getId();
        File file = new File(str);
        try {
            File f4 = f(file);
            this.ajs = f4;
            try {
                try {
                    c(a(context, file, f4));
                    com.kwad.library.solder.lib.c.b bVar = this.ajy;
                    if (bVar == null || (classLoader = bVar.ako) == null) {
                        classLoader = getClass().getClassLoader();
                    }
                    synchronized (Runtime.getRuntime()) {
                        com.kwad.library.solder.lib.ext.d.c(classLoader, this.ajs);
                    }
                } catch (PluginError.LoadError e4) {
                    q.R(file);
                    throw e4;
                }
            } catch (IOException e5) {
                throw new PluginError.LoadError(e5, 4004);
            }
        } catch (IOException e6) {
            throw new PluginError.LoadError(e6, 4003);
        }
    }
}
