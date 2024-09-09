package com.kuaishou.weapon.p0;

import android.os.Process;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class di {
    public static String a() {
        try {
            return b(String.format(" lsof -p %1$s ", Integer.valueOf(Process.myPid())));
        } catch (Exception unused) {
            return null;
        }
    }

    private static String b(String str) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
            ArrayList arrayList = new ArrayList();
            do {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.contains("TCP") && !readLine.contains(":443")) {
                    arrayList.add(readLine);
                }
            } while (arrayList.size() <= 5);
            bufferedReader.close();
            if (arrayList.size() > 0) {
                return arrayList.toString();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
        if (r3 == null) goto L30;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.Set c() {
        /*
            r0 = 0
            java.util.HashSet r1 = new java.util.HashSet     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            r1.<init>()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.lang.String r2 = " netstat -nap "
            java.lang.Runtime r3 = java.lang.Runtime.getRuntime()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.lang.Process r2 = r3.exec(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            java.io.InputStream r2 = r2.getInputStream()     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            r4.<init>(r2)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L50 java.lang.Exception -> L59
        L1e:
            java.lang.String r2 = r3.readLine()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r2 == 0) goto L40
            java.lang.String r4 = "tcp"
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r4 == 0) goto L1e
            java.lang.String r4 = "ESTABLISHED"
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r4 == 0) goto L1e
            java.lang.String r4 = ":5555 "
            boolean r4 = r2.contains(r4)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r4 == 0) goto L1e
            r1.add(r2)     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            goto L1e
        L40:
            int r2 = r1.size()     // Catch: java.lang.Throwable -> L4e java.lang.Exception -> L5a
            if (r2 <= 0) goto L4a
            r3.close()     // Catch: java.lang.Exception -> L49
        L49:
            return r1
        L4a:
            r3.close()     // Catch: java.lang.Exception -> L5d
            goto L5d
        L4e:
            r0 = move-exception
            goto L53
        L50:
            r1 = move-exception
            r3 = r0
            r0 = r1
        L53:
            if (r3 == 0) goto L58
            r3.close()     // Catch: java.lang.Exception -> L58
        L58:
            throw r0
        L59:
            r3 = r0
        L5a:
            if (r3 == 0) goto L5d
            goto L4a
        L5d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kuaishou.weapon.p0.di.c():java.util.Set");
    }

    public static int d() {
        String readLine;
        BufferedReader bufferedReader = null;
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -apn | grep scrcpy ").getInputStream()));
            do {
                try {
                    readLine = bufferedReader2.readLine();
                    if (readLine == null) {
                        try {
                            bufferedReader2.close();
                        } catch (Exception unused) {
                        }
                        return 0;
                    }
                } catch (Exception unused2) {
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused3) {
                        }
                    }
                    return 0;
                } catch (Throwable th) {
                    th = th;
                    bufferedReader = bufferedReader2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception unused4) {
                        }
                    }
                    throw th;
                }
            } while (!readLine.contains("scrcpy"));
            try {
                bufferedReader2.close();
                return 1;
            } catch (Exception unused5) {
                return 1;
            }
        } catch (Exception unused6) {
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static JSONObject e() {
        BufferedReader bufferedReader;
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(" netstat -an ").getInputStream()));
        } catch (Exception unused) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                } else if (readLine.contains(TTPathConst.sSeparator) || readLine.contains("@")) {
                    if (readLine.contains(TTPathConst.sSeparator)) {
                        readLine = readLine.substring(readLine.indexOf(TTPathConst.sSeparator));
                    } else if (readLine.contains("@")) {
                        readLine = readLine.substring(readLine.indexOf("@"));
                    }
                    if (readLine.contains("/ddy")) {
                        jSONObject.put("0", readLine);
                    } else if (readLine.contains("scrcpy")) {
                        jSONObject.put("1", readLine);
                    } else if (readLine.contains("supersu")) {
                        jSONObject.put("2", readLine);
                    } else if (readLine.contains("/adbd")) {
                        jSONObject.put("3", readLine);
                    }
                }
            }
            if (jSONObject.length() > 0) {
                try {
                    bufferedReader.close();
                } catch (Exception unused2) {
                }
                return jSONObject;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused3) {
            }
            return null;
        } catch (Exception unused4) {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception unused5) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused6) {
                }
            }
            throw th;
        }
    }

    public static String a(String str) {
        BufferedReader bufferedReader;
        String str2 = "";
        BufferedReader bufferedReader2 = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(str).getInputStream()));
        } catch (Exception unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                str2 = "" + readLine;
            }
            try {
                bufferedReader.close();
            } catch (Exception unused2) {
            }
            return str2;
        } catch (Exception unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused4) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    public static String b() {
        try {
            String a4 = a(" pidof adbd ");
            if (TextUtils.isEmpty(a4)) {
                return null;
            }
            return a4.length() > 10 ? a4.substring(0, 10) : a4;
        } catch (Exception unused) {
            return null;
        }
    }
}
