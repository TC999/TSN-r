package com.kwad.library.solder.lib;

import android.content.Context;
import com.kwad.library.solder.lib.ext.C9635d;
import com.kwad.library.solder.lib.ext.PluginError;
import com.kwad.library.solder.lib.p362c.C9617b;
import com.kwad.library.solder.lib.p363d.C9621c;
import com.kwad.sdk.utils.C11122q;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import p011a.R8$$SyntheticClass;

/* renamed from: com.kwad.library.solder.lib.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9644h extends C9643g {
    public C9644h(String str) {
        super(str);
    }

    /* renamed from: a */
    private Set<File> m28117a(Context context, File file, File file2) {
        String[] list;
        R8$$SyntheticClass.m60055a(file2);
        HashSet hashSet = new HashSet();
        if (file2.exists() && (list = file2.list()) != null && list.length > 0) {
            for (String str : list) {
                hashSet.add(new File(file2.getAbsolutePath() + File.separator + str));
            }
            return hashSet;
        }
        File file3 = new File(file2.getParentFile(), this.aiX.m28153xD());
        C11122q.m23736X(file3);
        for (String str2 : C9621c.m28185b(file, file3)) {
            File m28186a = C9621c.m28186a(file3, str2, file2);
            if (m28186a != null) {
                hashSet.add(m28186a);
            }
        }
        C11122q.m23742R(file3);
        return hashSet;
    }

    /* JADX WARN: Code restructure failed: missing block: B:22:0x008f, code lost:
        if (r3 == false) goto L21;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x00af, code lost:
        throw new com.kwad.library.solder.lib.ext.PluginError.LoadError(new java.lang.Exception(r2 + " not found"), 4001);
     */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m28116c(java.util.Set<java.io.File> r9) {
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
            java.lang.String r6 = com.kwad.sdk.utils.C11010ad.m24145ab(r5)
            java.lang.String r7 = r5.getName()
            boolean r7 = r7.equals(r2)
            if (r7 == 0) goto L3d
            r3 = 1
            boolean r4 = android.text.TextUtils.equals(r6, r1)
            if (r4 == 0) goto L5f
            goto L8f
        L5f:
            m28115d(r9)
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
        throw new UnsupportedOperationException("Method not decompiled: com.kwad.library.solder.lib.C9644h.m28116c(java.util.Set):void");
    }

    /* renamed from: d */
    private static void m28115d(Set<File> set) {
        for (File file : set) {
            C11122q.m23742R(file);
        }
    }

    /* renamed from: f */
    private File m28114f(File file) {
        File file2 = new File(file.getParentFile(), this.aiX.m28154xC());
        C11122q.m23736X(file2);
        return file2;
    }

    @Override // com.kwad.library.solder.lib.C9643g, com.kwad.library.solder.lib.p360a.AbstractC9604a
    /* renamed from: g */
    public void mo28113g(Context context, String str) {
        ClassLoader classLoader;
        super.mo28113g(context, str);
        getId();
        File file = new File(str);
        try {
            File m28114f = m28114f(file);
            this.ajs = m28114f;
            try {
                try {
                    m28116c(m28117a(context, file, m28114f));
                    C9617b c9617b = this.ajy;
                    if (c9617b == null || (classLoader = c9617b.ako) == null) {
                        classLoader = getClass().getClassLoader();
                    }
                    synchronized (Runtime.getRuntime()) {
                        C9635d.m28139c(classLoader, this.ajs);
                    }
                } catch (PluginError.LoadError e) {
                    C11122q.m23742R(file);
                    throw e;
                }
            } catch (IOException e2) {
                throw new PluginError.LoadError(e2, 4004);
            }
        } catch (IOException e3) {
            throw new PluginError.LoadError(e3, 4003);
        }
    }
}
