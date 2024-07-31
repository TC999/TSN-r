package com.sun.activation.registries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* renamed from: com.sun.activation.registries.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MailcapFile {

    /* renamed from: d */
    private static boolean f35820d;

    /* renamed from: a */
    private Map f35821a = new HashMap();

    /* renamed from: b */
    private Map f35822b = new HashMap();

    /* renamed from: c */
    private Map f35823c = new HashMap();

    static {
        try {
            f35820d = Boolean.getBoolean("javax.activation.addreverse");
        } catch (Throwable unused) {
        }
    }

    public MailcapFile(String str) throws IOException {
        FileReader fileReader;
        if (LogSupport.m16477a()) {
            LogSupport.m16476b("new MailcapFile: file " + str);
        }
        FileReader fileReader2 = null;
        try {
            fileReader = new FileReader(str);
        } catch (Throwable th) {
            th = th;
        }
        try {
            m16468g(new BufferedReader(fileReader));
            try {
                fileReader.close();
            } catch (IOException unused) {
            }
        } catch (Throwable th2) {
            th = th2;
            fileReader2 = fileReader;
            if (fileReader2 != null) {
                try {
                    fileReader2.close();
                } catch (IOException unused2) {
                }
            }
            throw th;
        }
    }

    /* renamed from: f */
    private Map m16469f(Map map, Map map2) {
        HashMap hashMap = new HashMap(map);
        for (String str : map2.keySet()) {
            List list = (List) hashMap.get(str);
            if (list == null) {
                hashMap.put(str, map2.get(str));
            } else {
                ArrayList arrayList = new ArrayList(list);
                arrayList.addAll((List) map2.get(str));
                hashMap.put(str, arrayList);
            }
        }
        return hashMap;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x005c, code lost:
        m16467h(r1 + r2);
     */
    /* renamed from: g */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m16468g(java.io.Reader r7) throws java.io.IOException {
        /*
            r6 = this;
            java.io.BufferedReader r0 = new java.io.BufferedReader
            r0.<init>(r7)
            r7 = 0
        L6:
            r1 = r7
        L7:
            java.lang.String r2 = r0.readLine()
            if (r2 != 0) goto Le
            return
        Le:
            java.lang.String r2 = r2.trim()
            r3 = 0
            char r4 = r2.charAt(r3)     // Catch: java.lang.Throwable -> L64
            r5 = 35
            if (r4 != r5) goto L1c
            goto L7
        L1c:
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L64
            int r4 = r4 + (-1)
            char r4 = r2.charAt(r4)     // Catch: java.lang.Throwable -> L64
            r5 = 92
            if (r4 != r5) goto L4e
            if (r1 == 0) goto L43
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r4.<init>(r1)     // Catch: java.lang.Throwable -> L64
            int r5 = r2.length()     // Catch: java.lang.Throwable -> L64
            int r5 = r5 + (-1)
            java.lang.String r2 = r2.substring(r3, r5)     // Catch: java.lang.Throwable -> L64
            r4.append(r2)     // Catch: java.lang.Throwable -> L64
            java.lang.String r1 = r4.toString()     // Catch: java.lang.Throwable -> L64
            goto L7
        L43:
            int r4 = r2.length()     // Catch: java.lang.Throwable -> L64
            int r4 = r4 + (-1)
            java.lang.String r1 = r2.substring(r3, r4)     // Catch: java.lang.Throwable -> L64
            goto L7
        L4e:
            if (r1 == 0) goto L60
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L64
            r3.<init>(r1)     // Catch: java.lang.Throwable -> L64
            r3.append(r2)     // Catch: java.lang.Throwable -> L64
            java.lang.String r1 = r3.toString()     // Catch: java.lang.Throwable -> L64
            r6.m16467h(r1)     // Catch: com.sun.activation.registries.MailcapParseException -> L6 java.lang.Throwable -> L64
            goto L6
        L60:
            r6.m16467h(r2)     // Catch: java.lang.Throwable -> L64
            goto L7
        L64:
            goto L7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sun.activation.registries.MailcapFile.m16468g(java.io.Reader):void");
    }

    /* renamed from: i */
    protected static void m16466i(int i, int i2, int i3, int i4, String str) throws MailcapParseException {
        if (LogSupport.m16477a()) {
            LogSupport.m16476b("PARSE ERROR: Encountered a " + MailcapTokenizer.m16456h(i4) + " token (" + str + ") while expecting a " + MailcapTokenizer.m16456h(i) + ", a " + MailcapTokenizer.m16456h(i2) + ", or a " + MailcapTokenizer.m16456h(i3) + " token.");
        }
        throw new MailcapParseException("Encountered a " + MailcapTokenizer.m16456h(i4) + " token (" + str + ") while expecting a " + MailcapTokenizer.m16456h(i) + ", a " + MailcapTokenizer.m16456h(i2) + ", or a " + MailcapTokenizer.m16456h(i3) + " token.");
    }

    /* renamed from: j */
    protected static void m16465j(int i, int i2, int i3, String str) throws MailcapParseException {
        throw new MailcapParseException("Encountered a " + MailcapTokenizer.m16456h(i3) + " token (" + str + ") while expecting a " + MailcapTokenizer.m16456h(i) + " or a " + MailcapTokenizer.m16456h(i2) + " token.");
    }

    /* renamed from: k */
    protected static void m16464k(int i, int i2, String str) throws MailcapParseException {
        throw new MailcapParseException("Encountered a " + MailcapTokenizer.m16456h(i2) + " token (" + str + ") while expecting a " + MailcapTokenizer.m16456h(i) + " token.");
    }

    /* renamed from: a */
    public void m16474a(String str) {
        if (LogSupport.m16477a()) {
            LogSupport.m16476b("appendToMailcap: " + str);
        }
        try {
            m16468g(new StringReader(str));
        } catch (IOException unused) {
        }
    }

    /* renamed from: b */
    public Map m16473b(String str) {
        Map map = (Map) this.f35822b.get(str);
        int indexOf = str.indexOf(47) + 1;
        if (str.substring(indexOf).equals("*")) {
            return map;
        }
        Map map2 = (Map) this.f35822b.get(String.valueOf(str.substring(0, indexOf)) + "*");
        return map2 != null ? map != null ? m16469f(map, map2) : map2 : map;
    }

    /* renamed from: c */
    public Map m16472c(String str) {
        Map map = (Map) this.f35821a.get(str);
        int indexOf = str.indexOf(47) + 1;
        if (str.substring(indexOf).equals("*")) {
            return map;
        }
        Map map2 = (Map) this.f35821a.get(String.valueOf(str.substring(0, indexOf)) + "*");
        return map2 != null ? map != null ? m16469f(map, map2) : map2 : map;
    }

    /* renamed from: d */
    public String[] m16471d() {
        HashSet hashSet = new HashSet(this.f35821a.keySet());
        hashSet.addAll(this.f35822b.keySet());
        hashSet.addAll(this.f35823c.keySet());
        return (String[]) hashSet.toArray(new String[hashSet.size()]);
    }

    /* renamed from: e */
    public String[] m16470e(String str) {
        List list = (List) this.f35823c.get(str.toLowerCase(Locale.ENGLISH));
        if (list != null) {
            return (String[]) list.toArray(new String[list.size()]);
        }
        return null;
    }

    /* renamed from: h */
    protected void m16467h(String str) throws MailcapParseException, IOException {
        String str2;
        int m16455i;
        MailcapTokenizer mailcapTokenizer = new MailcapTokenizer(str);
        mailcapTokenizer.m16452l(false);
        if (LogSupport.m16477a()) {
            LogSupport.m16476b("parse: " + str);
        }
        int m16455i2 = mailcapTokenizer.m16455i();
        if (m16455i2 != 2) {
            m16464k(2, m16455i2, mailcapTokenizer.m16461c());
        }
        String m16461c = mailcapTokenizer.m16461c();
        Locale locale = Locale.ENGLISH;
        String lowerCase = m16461c.toLowerCase(locale);
        int m16455i3 = mailcapTokenizer.m16455i();
        if (m16455i3 != 47 && m16455i3 != 59) {
            m16465j(47, 59, m16455i3, mailcapTokenizer.m16461c());
        }
        if (m16455i3 == 47) {
            int m16455i4 = mailcapTokenizer.m16455i();
            if (m16455i4 != 2) {
                m16464k(2, m16455i4, mailcapTokenizer.m16461c());
            }
            str2 = mailcapTokenizer.m16461c().toLowerCase(locale);
            m16455i3 = mailcapTokenizer.m16455i();
        } else {
            str2 = "*";
        }
        String str3 = String.valueOf(lowerCase) + "/" + str2;
        if (LogSupport.m16477a()) {
            LogSupport.m16476b("  Type: " + str3);
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (m16455i3 != 59) {
            m16464k(59, m16455i3, mailcapTokenizer.m16461c());
        }
        mailcapTokenizer.m16452l(true);
        int m16455i5 = mailcapTokenizer.m16455i();
        mailcapTokenizer.m16452l(false);
        if (m16455i5 != 2 && m16455i5 != 59) {
            m16465j(2, 59, m16455i5, mailcapTokenizer.m16461c());
        }
        if (m16455i5 == 2) {
            List list = (List) this.f35823c.get(str3);
            if (list == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(str);
                this.f35823c.put(str3, arrayList);
            } else {
                list.add(str);
            }
        }
        if (m16455i5 != 59) {
            m16455i5 = mailcapTokenizer.m16455i();
        }
        if (m16455i5 != 59) {
            if (m16455i5 != 5) {
                m16465j(5, 59, m16455i5, mailcapTokenizer.m16461c());
                return;
            }
            return;
        }
        boolean z = false;
        do {
            int m16455i6 = mailcapTokenizer.m16455i();
            if (m16455i6 != 2) {
                m16464k(2, m16455i6, mailcapTokenizer.m16461c());
            }
            String lowerCase2 = mailcapTokenizer.m16461c().toLowerCase(Locale.ENGLISH);
            m16455i = mailcapTokenizer.m16455i();
            if (m16455i != 61 && m16455i != 59 && m16455i != 5) {
                m16466i(61, 59, 5, m16455i, mailcapTokenizer.m16461c());
            }
            if (m16455i == 61) {
                mailcapTokenizer.m16452l(true);
                int m16455i7 = mailcapTokenizer.m16455i();
                mailcapTokenizer.m16452l(false);
                if (m16455i7 != 2) {
                    m16464k(2, m16455i7, mailcapTokenizer.m16461c());
                }
                String m16461c2 = mailcapTokenizer.m16461c();
                if (lowerCase2.startsWith("x-java-")) {
                    String substring = lowerCase2.substring(7);
                    if (substring.equals("fallback-entry") && m16461c2.equalsIgnoreCase("true")) {
                        z = true;
                    } else {
                        if (LogSupport.m16477a()) {
                            LogSupport.m16476b("    Command: " + substring + ", Class: " + m16461c2);
                        }
                        List list2 = (List) linkedHashMap.get(substring);
                        if (list2 == null) {
                            list2 = new ArrayList();
                            linkedHashMap.put(substring, list2);
                        }
                        if (f35820d) {
                            list2.add(0, m16461c2);
                        } else {
                            list2.add(m16461c2);
                        }
                    }
                }
                m16455i = mailcapTokenizer.m16455i();
                continue;
            }
        } while (m16455i == 59);
        Map map = z ? this.f35822b : this.f35821a;
        Map map2 = (Map) map.get(str3);
        if (map2 == null) {
            map.put(str3, linkedHashMap);
            return;
        }
        if (LogSupport.m16477a()) {
            LogSupport.m16476b("Merging commands for type " + str3);
        }
        for (String str4 : map2.keySet()) {
            List list3 = (List) map2.get(str4);
            List<String> list4 = (List) linkedHashMap.get(str4);
            if (list4 != null) {
                for (String str5 : list4) {
                    if (!list3.contains(str5)) {
                        if (f35820d) {
                            list3.add(0, str5);
                        } else {
                            list3.add(str5);
                        }
                    }
                }
            }
        }
        for (String str6 : linkedHashMap.keySet()) {
            if (!map2.containsKey(str6)) {
                map2.put(str6, (List) linkedHashMap.get(str6));
            }
        }
    }

    public MailcapFile(InputStream inputStream) throws IOException {
        if (LogSupport.m16477a()) {
            LogSupport.m16476b("new MailcapFile: InputStream");
        }
        m16468g(new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1")));
    }

    public MailcapFile() {
        if (LogSupport.m16477a()) {
            LogSupport.m16476b("new MailcapFile: default");
        }
    }
}
