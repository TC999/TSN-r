package javax.activation;

import com.sun.activation.registries.b;
import com.sun.activation.registries.c;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class MailcapCommandMap extends CommandMap {
    private static final int PROG = 0;
    private static c defDB;
    private c[] DB;

    public MailcapCommandMap() {
        ArrayList arrayList = new ArrayList(5);
        arrayList.add(null);
        b.b("MailcapCommandMap: load HOME");
        try {
            String property = System.getProperty("user.home");
            if (property != null) {
                c loadFile = loadFile(property + File.separator + ".mailcap");
                if (loadFile != null) {
                    arrayList.add(loadFile);
                }
            }
        } catch (SecurityException unused) {
        }
        b.b("MailcapCommandMap: load SYS");
        try {
            StringBuilder sb = new StringBuilder(String.valueOf(System.getProperty("java.home")));
            String str = File.separator;
            sb.append(str);
            sb.append("lib");
            sb.append(str);
            sb.append("mailcap");
            c loadFile2 = loadFile(sb.toString());
            if (loadFile2 != null) {
                arrayList.add(loadFile2);
            }
        } catch (SecurityException unused2) {
        }
        b.b("MailcapCommandMap: load JAR");
        loadAllResources(arrayList, "mailcap");
        b.b("MailcapCommandMap: load DEF");
        synchronized (MailcapCommandMap.class) {
            if (defDB == null) {
                defDB = loadResource("mailcap.default");
            }
        }
        c cVar = defDB;
        if (cVar != null) {
            arrayList.add(cVar);
        }
        c[] cVarArr = new c[arrayList.size()];
        this.DB = cVarArr;
        this.DB = (c[]) arrayList.toArray(cVarArr);
    }

    private void appendCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            for (String str2 : (List) map.get(str)) {
                list.add(new CommandInfo(str, str2));
            }
        }
    }

    private void appendPrefCmdsToList(Map map, List list) {
        for (String str : map.keySet()) {
            if (!checkForVerb(list, str)) {
                list.add(new CommandInfo(str, (String) ((List) map.get(str)).get(0)));
            }
        }
    }

    private boolean checkForVerb(List list, String str) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((CommandInfo) it.next()).getCommandName().equals(str)) {
                return true;
            }
        }
        return false;
    }

    private DataContentHandler getDataContentHandler(String str) {
        Class<?> cls;
        if (b.a()) {
            b.b("    got content-handler");
        }
        if (b.a()) {
            b.b("      class " + str);
        }
        try {
            ClassLoader contextClassLoader = SecuritySupport.getContextClassLoader();
            if (contextClassLoader == null) {
                contextClassLoader = getClass().getClassLoader();
            }
            try {
                cls = contextClassLoader.loadClass(str);
            } catch (Exception unused) {
                cls = Class.forName(str);
            }
            if (cls != null) {
                return (DataContentHandler) cls.newInstance();
            }
            return null;
        } catch (ClassNotFoundException e4) {
            if (b.a()) {
                b.c("Can't load DCH " + str, e4);
                return null;
            }
            return null;
        } catch (IllegalAccessException e5) {
            if (b.a()) {
                b.c("Can't load DCH " + str, e5);
                return null;
            }
            return null;
        } catch (InstantiationException e6) {
            if (b.a()) {
                b.c("Can't load DCH " + str, e6);
                return null;
            }
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x00ce, code lost:
        if (r5 != null) goto L46;
     */
    /* JADX WARN: Removed duplicated region for block: B:103:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00e0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void loadAllResources(java.util.List r10, java.lang.String r11) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadAllResources(java.util.List, java.lang.String):void");
    }

    private c loadFile(String str) {
        try {
            return new c(str);
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
    private com.sun.activation.registries.c loadResource(java.lang.String r7) {
        /*
            r6 = this;
            java.lang.String r0 = "MailcapCommandMap: can't load "
            r1 = 0
            java.lang.Class r2 = r6.getClass()     // Catch: java.lang.Throwable -> L4e java.lang.SecurityException -> L50 java.io.IOException -> L6a
            java.io.InputStream r2 = javax.activation.SecuritySupport.getResourceAsStream(r2, r7)     // Catch: java.lang.Throwable -> L4e java.lang.SecurityException -> L50 java.io.IOException -> L6a
            if (r2 == 0) goto L2d
            com.sun.activation.registries.c r3 = new com.sun.activation.registries.c     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            r3.<init>(r2)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            boolean r4 = com.sun.activation.registries.b.a()     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            if (r4 == 0) goto L29
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            java.lang.String r5 = "MailcapCommandMap: successfully loaded mailcap file: "
            r4.<init>(r5)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            r4.append(r7)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            java.lang.String r4 = r4.toString()     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            com.sun.activation.registries.b.b(r4)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
        L29:
            r2.close()     // Catch: java.io.IOException -> L2c
        L2c:
            return r3
        L2d:
            boolean r3 = com.sun.activation.registries.b.a()     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            if (r3 == 0) goto L44
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            java.lang.String r4 = "MailcapCommandMap: not loading mailcap file: "
            r3.<init>(r4)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            r3.append(r7)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            java.lang.String r3 = r3.toString()     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
            com.sun.activation.registries.b.b(r3)     // Catch: java.lang.SecurityException -> L4a java.io.IOException -> L4c java.lang.Throwable -> L85
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
            boolean r4 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> L85
            if (r4 == 0) goto L67
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L85
            r4.append(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L85
            com.sun.activation.registries.b.c(r7, r3)     // Catch: java.lang.Throwable -> L85
        L67:
            if (r2 == 0) goto L84
            goto L46
        L6a:
            r3 = move-exception
            r2 = r1
        L6c:
            boolean r4 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> L85
            if (r4 == 0) goto L81
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L85
            r4.<init>(r0)     // Catch: java.lang.Throwable -> L85
            r4.append(r7)     // Catch: java.lang.Throwable -> L85
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L85
            com.sun.activation.registries.b.c(r7, r3)     // Catch: java.lang.Throwable -> L85
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
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.loadResource(java.lang.String):com.sun.activation.registries.c");
    }

    public synchronized void addMailcap(String str) {
        b.b("MailcapCommandMap: add to PROG");
        c[] cVarArr = this.DB;
        if (cVarArr[0] == null) {
            cVarArr[0] = new c();
        }
        this.DB[0].a(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
        r1 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:12:0x0028, code lost:
        r2 = r4.DB;
     */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x002b, code lost:
        if (r1 < r2.length) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
        return null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0032, code lost:
        if (r2[r1] != null) goto L41;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0039, code lost:
        if (com.sun.activation.registries.b.a() == false) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x003b, code lost:
        com.sun.activation.registries.b.b("  search fallback DB #" + r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
        r2 = r4.DB[r1].b(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
        if (r2 == null) goto L55;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
        r2 = (java.util.List) r2.get("content-handler");
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005e, code lost:
        if (r2 == null) goto L54;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
        r2 = getDataContentHandler((java.lang.String) r2.get(0));
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006a, code lost:
        if (r2 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006d, code lost:
        return r2;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x006e, code lost:
        r1 = r1 + 1;
     */
    @Override // javax.activation.CommandMap
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized javax.activation.DataContentHandler createDataContentHandler(java.lang.String r5) {
        /*
            r4 = this;
            monitor-enter(r4)
            boolean r0 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> Lb3
            if (r0 == 0) goto L18
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r1 = "MailcapCommandMap: createDataContentHandler for "
            r0.<init>(r1)     // Catch: java.lang.Throwable -> Lb3
            r0.append(r5)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Throwable -> Lb3
            com.sun.activation.registries.b.b(r0)     // Catch: java.lang.Throwable -> Lb3
        L18:
            if (r5 == 0) goto L20
            java.util.Locale r0 = java.util.Locale.ENGLISH     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r5 = r5.toLowerCase(r0)     // Catch: java.lang.Throwable -> Lb3
        L20:
            r0 = 0
            r1 = 0
        L22:
            com.sun.activation.registries.c[] r2 = r4.DB     // Catch: java.lang.Throwable -> Lb3
            int r3 = r2.length     // Catch: java.lang.Throwable -> Lb3
            if (r1 < r3) goto L71
            r1 = 0
        L28:
            com.sun.activation.registries.c[] r2 = r4.DB     // Catch: java.lang.Throwable -> Lb3
            int r3 = r2.length     // Catch: java.lang.Throwable -> Lb3
            if (r1 < r3) goto L30
            r5 = 0
            monitor-exit(r4)
            return r5
        L30:
            r2 = r2[r1]     // Catch: java.lang.Throwable -> Lb3
            if (r2 != 0) goto L35
            goto L6e
        L35:
            boolean r2 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto L4c
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r3 = "  search fallback DB #"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb3
            r2.append(r1)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb3
            com.sun.activation.registries.b.b(r2)     // Catch: java.lang.Throwable -> Lb3
        L4c:
            com.sun.activation.registries.c[] r2 = r4.DB     // Catch: java.lang.Throwable -> Lb3
            r2 = r2[r1]     // Catch: java.lang.Throwable -> Lb3
            java.util.Map r2 = r2.b(r5)     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto L6e
            java.lang.String r3 = "content-handler"
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> Lb3
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto L6e
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Lb3
            javax.activation.DataContentHandler r2 = r4.getDataContentHandler(r2)     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto L6e
            monitor-exit(r4)
            return r2
        L6e:
            int r1 = r1 + 1
            goto L28
        L71:
            r2 = r2[r1]     // Catch: java.lang.Throwable -> Lb3
            if (r2 != 0) goto L76
            goto Laf
        L76:
            boolean r2 = com.sun.activation.registries.b.a()     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto L8d
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r3 = "  search DB #"
            r2.<init>(r3)     // Catch: java.lang.Throwable -> Lb3
            r2.append(r1)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> Lb3
            com.sun.activation.registries.b.b(r2)     // Catch: java.lang.Throwable -> Lb3
        L8d:
            com.sun.activation.registries.c[] r2 = r4.DB     // Catch: java.lang.Throwable -> Lb3
            r2 = r2[r1]     // Catch: java.lang.Throwable -> Lb3
            java.util.Map r2 = r2.c(r5)     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto Laf
            java.lang.String r3 = "content-handler"
            java.lang.Object r2 = r2.get(r3)     // Catch: java.lang.Throwable -> Lb3
            java.util.List r2 = (java.util.List) r2     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto Laf
            java.lang.Object r2 = r2.get(r0)     // Catch: java.lang.Throwable -> Lb3
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.lang.Throwable -> Lb3
            javax.activation.DataContentHandler r2 = r4.getDataContentHandler(r2)     // Catch: java.lang.Throwable -> Lb3
            if (r2 == 0) goto Laf
            monitor-exit(r4)
            return r2
        Laf:
            int r1 = r1 + 1
            goto L22
        Lb3:
            r5 = move-exception
            monitor-exit(r4)
            goto Lb7
        Lb6:
            throw r5
        Lb7:
            goto Lb6
        */
        throw new UnsupportedOperationException("Method not decompiled: javax.activation.MailcapCommandMap.createDataContentHandler(java.lang.String):javax.activation.DataContentHandler");
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo[] getAllCommands(String str) {
        ArrayList arrayList;
        Map b4;
        Map c4;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            c[] cVarArr = this.DB;
            if (i5 >= cVarArr.length) {
                break;
            }
            if (cVarArr[i5] != null && (c4 = cVarArr[i5].c(str)) != null) {
                appendCmdsToList(c4, arrayList);
            }
            i5++;
        }
        while (true) {
            c[] cVarArr2 = this.DB;
            if (i4 >= cVarArr2.length) {
            } else {
                if (cVarArr2[i4] != null && (b4 = cVarArr2[i4].b(str)) != null) {
                    appendCmdsToList(b4, arrayList);
                }
                i4++;
            }
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo getCommand(String str, String str2) {
        Map b4;
        List list;
        String str3;
        Map c4;
        List list2;
        String str4;
        if (str != null) {
            try {
                str = str.toLowerCase(Locale.ENGLISH);
            } catch (Throwable th) {
                throw th;
            }
        }
        int i4 = 0;
        while (true) {
            c[] cVarArr = this.DB;
            if (i4 >= cVarArr.length) {
                int i5 = 0;
                while (true) {
                    c[] cVarArr2 = this.DB;
                    if (i5 >= cVarArr2.length) {
                        return null;
                    }
                    if (cVarArr2[i5] != null && (b4 = cVarArr2[i5].b(str)) != null && (list = (List) b4.get(str2)) != null && (str3 = (String) list.get(0)) != null) {
                        return new CommandInfo(str2, str3);
                    }
                    i5++;
                }
            } else {
                if (cVarArr[i4] != null && (c4 = cVarArr[i4].c(str)) != null && (list2 = (List) c4.get(str2)) != null && (str4 = (String) list2.get(0)) != null) {
                    return new CommandInfo(str2, str4);
                }
                i4++;
            }
        }
    }

    @Override // javax.activation.CommandMap
    public synchronized String[] getMimeTypes() {
        ArrayList arrayList;
        String[] d4;
        arrayList = new ArrayList();
        int i4 = 0;
        while (true) {
            c[] cVarArr = this.DB;
            if (i4 < cVarArr.length) {
                if (cVarArr[i4] != null && (d4 = cVarArr[i4].d()) != null) {
                    for (int i5 = 0; i5 < d4.length; i5++) {
                        if (!arrayList.contains(d4[i5])) {
                            arrayList.add(d4[i5]);
                        }
                    }
                }
                i4++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public synchronized String[] getNativeCommands(String str) {
        ArrayList arrayList;
        String[] e4;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        int i4 = 0;
        while (true) {
            c[] cVarArr = this.DB;
            if (i4 < cVarArr.length) {
                if (cVarArr[i4] != null && (e4 = cVarArr[i4].e(str)) != null) {
                    for (int i5 = 0; i5 < e4.length; i5++) {
                        if (!arrayList.contains(e4[i5])) {
                            arrayList.add(e4[i5]);
                        }
                    }
                }
                i4++;
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    @Override // javax.activation.CommandMap
    public synchronized CommandInfo[] getPreferredCommands(String str) {
        ArrayList arrayList;
        Map b4;
        Map c4;
        arrayList = new ArrayList();
        if (str != null) {
            str = str.toLowerCase(Locale.ENGLISH);
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            c[] cVarArr = this.DB;
            if (i5 >= cVarArr.length) {
                break;
            }
            if (cVarArr[i5] != null && (c4 = cVarArr[i5].c(str)) != null) {
                appendPrefCmdsToList(c4, arrayList);
            }
            i5++;
        }
        while (true) {
            c[] cVarArr2 = this.DB;
            if (i4 >= cVarArr2.length) {
            } else {
                if (cVarArr2[i4] != null && (b4 = cVarArr2[i4].b(str)) != null) {
                    appendPrefCmdsToList(b4, arrayList);
                }
                i4++;
            }
        }
        return (CommandInfo[]) arrayList.toArray(new CommandInfo[arrayList.size()]);
    }

    public MailcapCommandMap(String str) throws IOException {
        this();
        if (b.a()) {
            b.b("MailcapCommandMap: load PROG from " + str);
        }
        c[] cVarArr = this.DB;
        if (cVarArr[0] == null) {
            cVarArr[0] = new c(str);
        }
    }

    public MailcapCommandMap(InputStream inputStream) {
        this();
        b.b("MailcapCommandMap: load PROG");
        c[] cVarArr = this.DB;
        if (cVarArr[0] == null) {
            try {
                cVarArr[0] = new c(inputStream);
            } catch (IOException unused) {
            }
        }
    }
}
