package com.tencent.bugly.crashreport.crash.anr;

import com.tencent.bugly.proguard.al;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class TraceFileHelper {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public long f50796a;

        /* renamed from: b  reason: collision with root package name */
        public String f50797b;

        /* renamed from: c  reason: collision with root package name */
        public long f50798c;

        /* renamed from: d  reason: collision with root package name */
        public Map<String, String[]> f50799d;
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BUGLY */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface b {
        boolean a(long j4);

        boolean a(long j4, long j5, String str);

        boolean a(String str, int i4, String str2, String str3);
    }

    private static Object[] a(BufferedReader bufferedReader, Pattern... patternArr) throws IOException {
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

    private static String b(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine == null || readLine.trim().length() <= 0) {
                break;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }

    public static a readFirstDumpInfo(String str, final boolean z3) {
        if (str == null) {
            al.e("path:%s", str);
            return null;
        }
        final a aVar = new a();
        readTraceFile(str, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.2
            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(String str2, int i4, String str3, String str4) {
                al.c("new thread %s", str2);
                a aVar2 = a.this;
                if (aVar2.f50799d == null) {
                    aVar2.f50799d = new HashMap();
                }
                a.this.f50799d.put(str2, new String[]{str3, str4, String.valueOf(i4)});
                return true;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j4, long j5, String str2) {
                al.c("new process %s", str2);
                a aVar2 = a.this;
                aVar2.f50796a = j4;
                aVar2.f50797b = str2;
                aVar2.f50798c = j5;
                return z3;
            }

            @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
            public final boolean a(long j4) {
                al.c("process end %d", Long.valueOf(j4));
                return false;
            }
        });
        if (aVar.f50796a <= 0 || aVar.f50798c <= 0 || aVar.f50797b == null) {
            al.e("first dump error %s", aVar.f50796a + " " + aVar.f50798c + " " + aVar.f50797b);
            return null;
        }
        return aVar;
    }

    public static a readTargetDumpInfo(final String str, String str2, final boolean z3) {
        if (str != null && str2 != null) {
            final a aVar = new a();
            readTraceFile(str2, new b() { // from class: com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.1
                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(String str3, int i4, String str4, String str5) {
                    al.c("new thread %s", str3);
                    a aVar2 = a.this;
                    if (aVar2.f50796a > 0 && aVar2.f50798c > 0 && aVar2.f50797b != null) {
                        if (aVar2.f50799d == null) {
                            aVar2.f50799d = new HashMap();
                        }
                        a.this.f50799d.put(str3, new String[]{str4, str5, String.valueOf(i4)});
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j4, long j5, String str3) {
                    al.c("new process %s", str3);
                    if (str3.equals(str)) {
                        a aVar2 = a.this;
                        aVar2.f50796a = j4;
                        aVar2.f50797b = str3;
                        aVar2.f50798c = j5;
                        return z3;
                    }
                    return true;
                }

                @Override // com.tencent.bugly.crashreport.crash.anr.TraceFileHelper.b
                public final boolean a(long j4) {
                    al.c("process end %d", Long.valueOf(j4));
                    a aVar2 = a.this;
                    return aVar2.f50796a <= 0 || aVar2.f50798c <= 0 || aVar2.f50797b == null;
                }
            });
            if (aVar.f50796a > 0 && aVar.f50798c > 0 && aVar.f50797b != null) {
                return aVar;
            }
        }
        return null;
    }

    public static void readTraceFile(String str, b bVar) {
        Throwable th;
        if (str == null || bVar == null) {
            return;
        }
        File file = new File(str);
        if (!file.exists()) {
            return;
        }
        file.lastModified();
        file.length();
        BufferedReader bufferedReader = null;
        int i4 = 0;
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
                        patternArr[i4] = compile;
                        Object[] a4 = a(bufferedReader2, patternArr);
                        if (a4 != null) {
                            Pattern[] patternArr2 = new Pattern[1];
                            patternArr2[i4] = compile3;
                            Object[] a5 = a(bufferedReader2, patternArr2);
                            if (a5 == null) {
                                al.d("Failed to find process name.", new Object[i4]);
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e4) {
                                    if (al.a(e4)) {
                                        return;
                                    }
                                    e4.printStackTrace();
                                    return;
                                }
                            }
                            String[] split = a4[1].toString().split("\\s");
                            long parseLong = Long.parseLong(split[2]);
                            long time = simpleDateFormat.parse(split[4] + " " + split[5]).getTime();
                            Matcher matcher = compile3.matcher(a5[1].toString());
                            matcher.find();
                            matcher.group(1);
                            SimpleDateFormat simpleDateFormat2 = simpleDateFormat;
                            if (!bVar.a(parseLong, time, matcher.group(1))) {
                                try {
                                    bufferedReader2.close();
                                    return;
                                } catch (IOException e5) {
                                    if (al.a(e5)) {
                                        return;
                                    }
                                    e5.printStackTrace();
                                    return;
                                }
                            }
                            while (true) {
                                Object[] a6 = a(bufferedReader2, compile4, compile2);
                                if (a6 == null) {
                                    break;
                                } else if (a6[0] == compile4) {
                                    String obj = a6[1].toString();
                                    Matcher matcher2 = Pattern.compile("\".+\"").matcher(obj);
                                    matcher2.find();
                                    String group = matcher2.group();
                                    String substring = group.substring(1, group.length() - 1);
                                    obj.contains("NATIVE");
                                    Matcher matcher3 = Pattern.compile("tid=\\d+").matcher(obj);
                                    matcher3.find();
                                    String group2 = matcher3.group();
                                    bVar.a(substring, Integer.parseInt(group2.substring(group2.indexOf("=") + 1)), a(bufferedReader2), b(bufferedReader2));
                                } else if (!bVar.a(Long.parseLong(a6[1].toString().split("\\s")[2]))) {
                                    try {
                                        bufferedReader2.close();
                                        return;
                                    } catch (IOException e6) {
                                        if (al.a(e6)) {
                                            return;
                                        }
                                        e6.printStackTrace();
                                        return;
                                    }
                                }
                            }
                            simpleDateFormat = simpleDateFormat2;
                            i4 = 0;
                        } else {
                            try {
                                bufferedReader2.close();
                                return;
                            } catch (IOException e7) {
                                if (al.a(e7)) {
                                    return;
                                }
                                e7.printStackTrace();
                                return;
                            }
                        }
                    }
                } catch (Exception e8) {
                    e = e8;
                    bufferedReader = bufferedReader2;
                    if (!al.a(e)) {
                        e.printStackTrace();
                    }
                    al.d("trace open fail:%s : %s", e.getClass().getName(), e.getMessage());
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e9) {
                            if (al.a(e9)) {
                                return;
                            }
                            e9.printStackTrace();
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e10) {
                            if (!al.a(e10)) {
                                e10.printStackTrace();
                            }
                        }
                    }
                    throw th;
                }
            } catch (Exception e11) {
                e = e11;
            }
        } catch (Throwable th3) {
            th = th3;
        }
    }

    private static String a(BufferedReader bufferedReader) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        for (int i4 = 0; i4 < 3; i4++) {
            String readLine = bufferedReader.readLine();
            if (readLine == null) {
                return null;
            }
            stringBuffer.append(readLine + "\n");
        }
        return stringBuffer.toString();
    }
}
