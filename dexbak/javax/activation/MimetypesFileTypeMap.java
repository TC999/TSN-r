package javax.activation;

import com.sun.activation.registries.C12724f;
import com.sun.activation.registries.LogSupport;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class MimetypesFileTypeMap extends FileTypeMap {
    private static final int PROG = 0;
    private static C12724f defDB = null;
    private static String defaultType = "application/octet-stream";

    /* renamed from: DB */
    private C12724f[] f40785DB;

    public MimetypesFileTypeMap() {
        Vector vector = new Vector(5);
        vector.addElement(null);
        LogSupport.m16476b("MimetypesFileTypeMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                C12724f loadFile = loadFile(property + File.separator + ".mime.types");
                if (loadFile != null) {
                    vector.addElement(loadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        LogSupport.m16476b("MimetypesFileTypeMap: load SYS");
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(System.getProperty("java.home")));
            String str = File.separator;
            sb.append(str);
            sb.append("lib");
            sb.append(str);
            sb.append("mime.types");
            C12724f loadFile2 = loadFile(sb.toString());
            if (loadFile2 != null) {
                vector.addElement(loadFile2);
            }
        } catch (SecurityException unused2) {
        }
        LogSupport.m16476b("MimetypesFileTypeMap: load JAR");
        loadAllResources(vector, "mime.types");
        LogSupport.m16476b("MimetypesFileTypeMap: load DEF");
        synchronized (MimetypesFileTypeMap.class) {
            if (defDB == null) {
                defDB = loadResource("/mimetypes.default");
            }
        }
        C12724f c12724f = defDB;
        if (c12724f != null) {
            vector.addElement(c12724f);
        }
        C12724f[] c12724fArr = new C12724f[vector.size()];
        this.f40785DB = c12724fArr;
        vector.copyInto(c12724fArr);
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ce, code lost:
        if (r5 != null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadAllResources(java.util.Vector r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 284
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadAllResources(java.util.Vector, java.lang.String):void");
    }

    private C12724f loadFile(String str) {
        try {
            return new C12724f(str);
        } catch (IOException unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0044, code lost:
        if (r2 != null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0081, code lost:
        if (r2 != null) goto L20;
     */
    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0086: MOVE  (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]), block:B:38:0x0086 */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0089 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.sun.activation.registries.C12724f loadResource(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "MimetypesFileTypeMap: can't load "
            r1 = 0
            java.lang.Class r2 = r6.getClass()     // Catch: java.lang.Throwable -> L4e java.lang.SecurityException -> L50 java.io.IOException -> L6a
            java.io.InputStream r2 = javax.activation.SecuritySupport.getResourceAsStream(r2, r7)     // Catch: java.lang.Throwable -> L4e java.lang.SecurityException -> L50 java.io.IOException -> L6a
            if (r2 == 0) goto L2d
            com.sun.activation.registries.f r3 = new com.sun.activation.registries.f     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            r3.<init>(r2)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            boolean r4 = com.sun.activation.registries.LogSupport.m16477a()     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            if (r4 == 0) goto L29
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            java.lang.String r5 = "MimetypesFileTypeMap: successfully loaded mime types file: "
            r4.<init>(r5)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            r4.append(r7)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            java.lang.String r4 = r4.toString()     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            com.sun.activation.registries.LogSupport.m16476b(r4)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
        L29:
            r2.close()     // Catch: java.io.IOException -> L2c
        L2c:
            return r3
        L2d:
            boolean r3 = com.sun.activation.registries.LogSupport.m16477a()     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            if (r3 == 0) goto L44
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            java.lang.String r4 = "MimetypesFileTypeMap: not loading mime types file: "
            r3.<init>(r4)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            r3.append(r7)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            java.lang.String r3 = r3.toString()     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            com.sun.activation.registries.LogSupport.m16476b(r3)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
        L44:
            if (r2 == 0) goto L84
        L46:
            r2.close()     // Catch: java.io.IOException -> L84
            goto L84
        L4a:
            r3 = move-exception
            goto L52
        L4c:
            r3 = move-exception
            goto L6c
        L4e:
            r7 = move-exception
            goto L87
        L50:
            r3 = move-exception
            r2 = r1
        L52:
            boolean r4 = com.sun.activation.registries.LogSupport.m16477a()     // Catch: java.lang.Throwable -> L85
            if (r4 == 0) goto L67
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L85
            r4.append(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L85
            com.sun.activation.registries.LogSupport.m16475c(r7, r3)     // Catch: java.lang.Throwable -> L85
        L67:
            if (r2 == 0) goto L84
            goto L46
        L6a:
            r3 = move-exception
            r2 = r1
        L6c:
            boolean r4 = com.sun.activation.registries.LogSupport.m16477a()     // Catch: java.lang.Throwable -> L85
            if (r4 == 0) goto L81
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L85
            r4.append(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L85
            com.sun.activation.registries.LogSupport.m16475c(r7, r3)     // Catch: java.lang.Throwable -> L85
        L81:
            if (r2 == 0) goto L84
            goto L46
        L84:
            return r1
        L85:
            r7 = move-exception
            r1 = r2
        L87:
            if (r1 == 0) goto L8c
            r1.close()     // Catch: java.io.IOException -> L8c
        L8c:
            goto L8e
        L8d:
            throw r7
        L8e:
            goto L8d
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MimetypesFileTypeMap.loadResource(java.lang.String):com.sun.activation.registries.f");
    }

    public synchronized void addMimeTypes(String str) {
        C12724f[] c12724fArr = this.f40785DB;
        if (c12724fArr[0] == null) {
            c12724fArr[0] = new C12724f();
        }
        this.f40785DB[0].m16449a(str);
    }

    @Override // javax.activation.FileTypeMap
    public String getContentType(File file) {
        return getContentType(file.getName());
    }

    @Override // javax.activation.FileTypeMap
    public synchronized String getContentType(String str) {
        String m16448b;
        int lastIndexOf = str.lastIndexOf(".");
        if (lastIndexOf < 0) {
            return defaultType;
        }
        String substring = str.substring(lastIndexOf + 1);
        if (substring.length() == 0) {
            return defaultType;
        }
        int i = 0;
        while (true) {
            C12724f[] c12724fArr = this.f40785DB;
            if (i >= c12724fArr.length) {
                return defaultType;
            }
            if (c12724fArr[i] != null && (m16448b = c12724fArr[i].m16448b(substring)) != null) {
                return m16448b;
            }
            i++;
        }
    }

    public MimetypesFileTypeMap(String str) throws IOException {
        this();
        this.f40785DB[0] = new C12724f(str);
    }

    public MimetypesFileTypeMap(InputStream inputStream) {
        this();
        try {
            this.f40785DB[0] = new C12724f(inputStream);
        } catch (IOException unused) {
        }
    }
}
