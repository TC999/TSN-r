package com.qihoo.bugreport.javacrash;

import android.content.Context;
import android.os.Process;
import com.qihoo.jiagu.a;
import com.qihoo.jiagu.b;
import com.qihoo.jiagu.c;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public class CrashReportDataFactory {

    /* renamed from: a  reason: collision with root package name */
    final Calendar f41408a;

    public native String interface9();

    public CrashReportDataFactory(Context context, Calendar calendar) {
        this.f41408a = calendar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        if (str == null) {
            return null;
        }
        StringBuffer stringBuffer = new StringBuffer();
        String[] split = str.split("\n");
        for (int i4 = 0; i4 < split.length; i4++) {
            if (!split[i4].contains(b.f41424b)) {
                stringBuffer.append(split[i4]).append("\n");
            }
        }
        return stringBuffer.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, ArrayList<String> arrayList) {
        int i4;
        int i5 = 0;
        if (str == null || arrayList == null) {
            return null;
        }
        String[] split = str.split("\n");
        int i6 = 0;
        while (true) {
            i4 = i5;
            if (i6 >= split.length - 1) {
                break;
            }
            i5 = split[i6].replaceAll("\t", "").trim().startsWith("Caused by:") ? i6 : i4;
            i6++;
        }
        for (int i7 = i4 + 1; i7 < split.length; i7++) {
            String trim = split[i7].replaceAll("\t", "").trim();
            if (trim.startsWith("at")) {
                trim = trim.substring(2).trim();
            }
            if (arrayList.contains(trim)) {
                return trim;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HashMap<String, String> a() {
        String readLine;
        HashMap<String, String> hashMap = new HashMap<>();
        int myPid = Process.myPid();
        hashMap.put("ed", Integer.toString(myPid));
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/" + myPid + "/status"))));
            try {
                do {
                    try {
                        readLine = bufferedReader.readLine();
                        if (readLine != null) {
                        }
                        break;
                    } catch (IOException e4) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e5) {
                        }
                    } catch (Throwable th) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                        throw th;
                    }
                } while (!readLine.startsWith("PPid:"));
                break;
                bufferedReader.close();
            } catch (IOException e7) {
            }
            hashMap.put("epd", readLine.substring(readLine.indexOf(":") + 1).replaceFirst("^\\s*", ""));
        } catch (FileNotFoundException e8) {
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String b() {
        try {
            return interface9();
        } catch (Throwable th) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c() {
        int indexOf;
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File("/proc/" + Process.myPid() + "/cmdline"))));
            try {
                String readLine = bufferedReader.readLine();
                try {
                    bufferedReader.close();
                } catch (IOException e4) {
                }
                if (readLine != null && (indexOf = readLine.indexOf("\u0000")) >= 0) {
                    return readLine.substring(0, indexOf);
                }
                return null;
            } catch (IOException e5) {
                try {
                    bufferedReader.close();
                    return null;
                } catch (IOException e6) {
                    return null;
                }
            } catch (Throwable th) {
                try {
                    bufferedReader.close();
                } catch (IOException e7) {
                }
                throw th;
            }
        } catch (FileNotFoundException e8) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public String a(String str, String str2, ArrayList<String> arrayList) {
        StringBuffer stringBuffer = new StringBuffer();
        if (str != null) {
            stringBuffer.append(str);
        }
        if (str2 != null) {
            stringBuffer.append(str2);
        }
        List asList = Arrays.asList(a.f41422a);
        int i4 = 0;
        while (true) {
            int i5 = i4;
            if (i5 < arrayList.size()) {
                String str3 = arrayList.get(i5);
                if (!a(asList, str3)) {
                    stringBuffer.append(str3);
                }
                i4 = i5 + 1;
            } else {
                return c.a(stringBuffer.toString().getBytes());
            }
        }
    }

    private static boolean a(List<String> list, String str) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (str.startsWith(list.get(i4))) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static ArrayList<String> a(Throwable th) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (th != null) {
            for (StackTraceElement stackTraceElement : th.getStackTrace()) {
                arrayList.add(stackTraceElement.toString());
            }
            th = th.getCause();
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(Calendar calendar) {
        return new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH).format(Long.valueOf(calendar.getTimeInMillis()));
    }
}
