package com.tencent.bugly.crashreport.crash.anr;

import com.snail.antifake.deviceid.ShellAdbUtils;
import com.tencent.bugly.proguard.C12820al;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: BUGLY */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class TraceFileHelper {

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static class C12779a {

        /* renamed from: a */
        public long f36372a;

        /* renamed from: b */
        public String f36373b;

        /* renamed from: c */
        public long f36374c;

        /* renamed from: d */
        public Map<String, String[]> f36375d;
    }

    /* compiled from: BUGLY */
    /* renamed from: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12780b {
        /* renamed from: a */
        boolean mo16035a(long j);

        /* renamed from: a */
        boolean mo16034a(long j, long j2, String str);

        /* renamed from: a */
        boolean mo16033a(String str, int i, String str2, String str3);
    }

    /* renamed from: a */
    private static Object[] m16037a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            for (Pattern pattern : patternArr) {
                if (pattern.matcher(readLine).matches()) {
                    return new Object[]{pattern, readLine};
                }
            }
        }
    }

    /* renamed from: b */
    private static String m16036b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + ShellAdbUtils.f33810d);
        }
        return stringBuffer.toString();
    }

    public static C12779a readFirstDumpInfo(String str, final boolean z) {
        if (str == null) {
            C12820al.m15872e("path:%s", str);
            return null;
        }
        final C12779a c12779a = new C12779a();
        readTraceFile(str, new InterfaceC12780b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC12780b
            /* renamed from: a */
            public final boolean mo16033a(String str2, int i, String str3, String str4) {
                C12820al.m15874c("new thread %s", str2);
                C12779a c12779a2 = C12779a.this;
                if (c12779a2.f36375d == null) {
                    c12779a2.f36375d = new HashMap();
                }
                C12779a.this.f36375d.put(str2, new String[]{str3, str4, String.valueOf(i)});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC12780b
            /* renamed from: a */
            public final boolean mo16034a(long j, long j2, String str2) {
                C12820al.m15874c("new process %s", str2);
                C12779a c12779a2 = C12779a.this;
                c12779a2.f36372a = j;
                c12779a2.f36373b = str2;
                c12779a2.f36374c = j2;
                return z;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC12780b
            /* renamed from: a */
            public final boolean mo16035a(long j) {
                C12820al.m15874c("process end %d", Long.valueOf(j));
                return false;
            }
        });
        if (c12779a.f36372a <= 0 || c12779a.f36374c <= 0 || c12779a.f36373b == null) {
            C12820al.m15872e("first dump error %s", c12779a.f36372a + " " + c12779a.f36374c + " " + c12779a.f36373b);
            return null;
        }
        return c12779a;
    }

    public static C12779a readTargetDumpInfo(final String str, String str2, final boolean z) {
        if (str != null && str2 != null) {
            final C12779a c12779a = new C12779a();
            readTraceFile(str2, new InterfaceC12780b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC12780b
                /* renamed from: a */
                public final boolean mo16033a(String str3, int i, String str4, String str5) {
                    C12820al.m15874c("new thread %s", str3);
                    C12779a c12779a2 = C12779a.this;
                    if (c12779a2.f36372a > 0 && c12779a2.f36374c > 0 && c12779a2.f36373b != null) {
                        if (c12779a2.f36375d == null) {
                            c12779a2.f36375d = new HashMap();
                        }
                        C12779a.this.f36375d.put(str3, new String[]{str4, str5, String.valueOf(i)});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC12780b
                /* renamed from: a */
                public final boolean mo16034a(long j, long j2, String str3) {
                    C12820al.m15874c("new process %s", str3);
                    if (str3.equals(str)) {
                        C12779a c12779a2 = C12779a.this;
                        c12779a2.f36372a = j;
                        c12779a2.f36373b = str3;
                        c12779a2.f36374c = j2;
                        return z;
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.InterfaceC12780b
                /* renamed from: a */
                public final boolean mo16035a(long j) {
                    C12820al.m15874c("process end %d", Long.valueOf(j));
                    C12779a c12779a2 = C12779a.this;
                    return c12779a2.f36372a <= 0 || c12779a2.f36374c <= 0 || c12779a2.f36373b == null;
                }
            });
            if (c12779a.f36372a > 0 && c12779a.f36374c > 0 && c12779a.f36373b != null) {
                return c12779a;
            }
        }
        return null;
    }

    public static void readTraceFile(String str, InterfaceC12780b interfaceC12780b) {
        Throwable th;
        if (str == null || interfaceC12780b == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader = null;
        int i = 0;
        try {
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new FileReader(file));
                try {
                    Pattern compile = Pattern.compile("-{5}\\spid\\s\\d+\\sat\\s\\d+-\\d+-\\d+\\s\\d{2}:\\d{2}:\\d{2}\\s-{5}");
                    Pattern compile2 = Pattern.compile("-{5}\\send\\s\\d+\\s-{5}");
                    Pattern compile3 = Pattern.compile("Cmd\\sline:\\s(\\S+)");
                    Pattern compile4 = Pattern.compile("\".+\"\\s(daemon\\s){0,1}prio=\\d+\\stid=\\d+\\s.*");
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
                    while (true) {
                        Pattern[] patternArr = new Pattern[1];
                        patternArr[i] = compile;
                        Object[] m16037a = m16037a(bufferedReader2, patternArr);
                        if (m16037a != null) {
                            Pattern[] patternArr2 = new Pattern[1];
                            patternArr2[i] = compile3;
                            Object[] m16037a2 = m16037a(bufferedReader2, patternArr2);
                            if (m16037a2 == null) {
                                C12820al.m15873d("Failed to find process name.", new Object[i]);
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e) {
                                    if (C12820al.m15877a(e)) {
                                        return;
                                    }
                                    e.printStackTrace();
                                    return;
                                }
                            }
                            String[] split = m16037a[1].toString().split("\\s");
                            long parseLong = Long.parseLong(split[2]);
                            long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                            Matcher matcher = compile3.matcher(m16037a2[1].toString());
                            matcher.find();
                            matcher.group(1);
                            SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                            if (!interfaceC12780b.mo16034a(parseLong, time, matcher.group(1))) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e2) {
                                    if (C12820al.m15877a(e2)) {
                                        return;
                                    }
                                    e2.printStackTrace();
                                    return;
                                }
                            }
                            while (true) {
                                Object[] m16037a3 = m16037a(bufferedReader2, compile4, compile2);
                                if (m16037a3 == null) {
                                    break;
                                } else if (m16037a3[0] == compile4) {
                                    String obj = m16037a3[1].toString();
                                    Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                    matcher2.find();
                                    String group = matcher2.group();
                                    String substring = group.substring(1, group.length() - 1);
                                    obj.contains("NATIVE");
                                    Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                    matcher3.find();
                                    String group2 = matcher3.group();
                                    interfaceC12780b.mo16033a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), m16038a(bufferedReader2), m16036b(bufferedReader2));
                                } else if (!interfaceC12780b.mo16035a(Long.parseLong(m16037a3[1].toString().split("\\s")[2]))) {
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (IOException e3) {
                                        if (C12820al.m15877a(e3)) {
                                            return;
                                        }
                                        e3.printStackTrace();
                                        return;
                                    }
                                }
                            }
                            simpleDateFormat = simpleDateFormat2;
                            i = 0;
                        } else {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e4) {
                                if (C12820al.m15877a(e4)) {
                                    return;
                                }
                                e4.printStackTrace();
                                return;
                            }
                        }
                    }
                } catch (Exception e5) {
                    e = e5;
                    bufferedReader = bufferedReader2;
                    if (!C12820al.m15877a(e)) {
                        e.printStackTrace();
                    }
                    C12820al.m15873d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            if (C12820al.m15877a(e6)) {
                                return;
                            }
                            e6.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e7) {
                            if (!C12820al.m15877a(e7)) {
                                e7.printStackTrace();
                            }
                        }
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    /* renamed from: a */
    private static String m16038a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 3; i++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + ShellAdbUtils.f33810d);
        }
        return stringBuffer.toString();
    }
}
