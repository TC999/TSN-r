package com.bytedance.sdk.component.utils;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class t {
    private static volatile t xv;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, String> f30225c;
    private Context sr;

    /* renamed from: w  reason: collision with root package name */
    private volatile boolean f30226w = false;

    private t(Context context) {
        if (context != null && this.sr == null) {
            this.sr = StubApp.getOrigApplicationContext(context.getApplicationContext());
            c();
        }
        this.sr = context;
    }

    private void f(String str) {
        String trim = str.trim();
        if (trim.isEmpty()) {
            return;
        }
        if (trim.charAt(0) == '#') {
            return;
        }
        String replaceAll = trim.replaceAll("\\s*#.*", "");
        if (replaceAll.indexOf(61) > 0) {
            Matcher matcher = Pattern.compile("\\btype=(\"\\p{Graph}+?/\\p{Graph}+?\"|\\p{Graph}+/\\p{Graph}+\\b)").matcher(replaceAll);
            if (matcher.find()) {
                String substring = matcher.group().substring(5);
                if (substring.charAt(0) == '\"') {
                    substring = substring.substring(1, substring.length() - 1);
                }
                Matcher matcher2 = Pattern.compile("\\bexts=(\"[\\p{Graph}|\\p{Blank}]+?\"|\\p{Graph}+\\b)").matcher(replaceAll);
                if (matcher2.find()) {
                    String substring2 = matcher2.group().substring(5);
                    if (substring2.charAt(0) == '\"') {
                        substring2 = substring2.substring(1, substring2.length() - 1);
                    }
                    for (String str2 : substring2.split("[\\p{Blank}|\\p{Punct}]+")) {
                        c(str2, substring);
                    }
                    return;
                }
                return;
            }
            return;
        }
        String[] split = replaceAll.split("\\s+");
        for (int i4 = 1; i4 < split.length; i4++) {
            c(split[i4], split[0]);
        }
    }

    private String sr(String str) {
        String str2;
        String ux = ux(str);
        if (ux.isEmpty()) {
            return null;
        }
        c();
        Map<String, String> map = this.f30225c;
        if (map == null || map.isEmpty()) {
            return null;
        }
        do {
            str2 = this.f30225c.get(ux);
            if (str2 == null) {
                ux = ux(ux);
            }
            if (str2 != null) {
                break;
            }
        } while (!ux.isEmpty());
        return str2;
    }

    private static String ux(String str) {
        int indexOf;
        return (str == null || str.isEmpty() || (indexOf = str.indexOf(46)) < 0 || indexOf >= str.length() + (-1)) ? "" : str.substring(indexOf + 1);
    }

    private static String w(String str) {
        String substring;
        int indexOf = str.indexOf(47);
        int indexOf2 = str.indexOf(59);
        if (indexOf < 0) {
            return null;
        }
        String trim = str.substring(0, indexOf).trim();
        Locale locale = Locale.ENGLISH;
        String lowerCase = trim.toLowerCase(locale);
        if (xv(lowerCase)) {
            int i4 = indexOf + 1;
            if (indexOf2 < 0) {
                substring = str.substring(i4);
            } else {
                substring = str.substring(i4, indexOf2);
            }
            String lowerCase2 = substring.trim().toLowerCase(locale);
            if (xv(lowerCase2)) {
                StringBuilder sb = new StringBuilder(lowerCase.length() + lowerCase2.length() + 1);
                sb.append(lowerCase);
                sb.append('/');
                sb.append(lowerCase2);
                return sb.toString();
            }
            return null;
        }
        return null;
    }

    private static boolean xv(String str) {
        int length = str.length();
        if (length == 0) {
            return false;
        }
        for (int i4 = 0; i4 < length; i4++) {
            if (!c(str.charAt(i4))) {
                return false;
            }
        }
        return true;
    }

    public static String c(Context context, String str) {
        if (str != null) {
            try {
                if (str.startsWith("http") && str.contains("?")) {
                    str = str.split("\\?")[0];
                    if (str.endsWith(TTPathConst.sSeparator)) {
                        str = str.substring(0, str.length() - 1);
                    }
                }
            } catch (Throwable unused) {
            }
        }
        return c(context).c(str);
    }

    static t c(Context context) {
        if (xv == null) {
            synchronized (t.class) {
                if (xv == null) {
                    xv = new t(context);
                }
            }
        }
        return xv;
    }

    public final String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String sr = sr(str);
        if (TextUtils.isEmpty(sr)) {
            return null;
        }
        return w(sr);
    }

    private static boolean c(char c4) {
        return c4 > ' ' && c4 < '\u007f' && "()<>@,;:/[]?=\\\"".indexOf(c4) < 0;
    }

    private void c() {
        if (this.sr == null || this.f30226w) {
            return;
        }
        synchronized (this) {
            if (!this.f30226w) {
                List list = (List) AccessController.doPrivileged(new PrivilegedAction<List<String>>() { // from class: com.bytedance.sdk.component.utils.t.1
                    @Override // java.security.PrivilegedAction
                    /* renamed from: c */
                    public List<String> run() {
                        BufferedReader bufferedReader;
                        InputStream inputStream = null;
                        try {
                            ArrayList arrayList = new ArrayList();
                            InputStream open = t.this.sr.getAssets().open("tt_mime_type.pro");
                            try {
                                bufferedReader = new BufferedReader(new InputStreamReader(open));
                                while (true) {
                                    try {
                                        String readLine = bufferedReader.readLine();
                                        if (readLine == null) {
                                            break;
                                        } else if (!TextUtils.isEmpty(readLine)) {
                                            arrayList.add(readLine);
                                        }
                                    } catch (Throwable unused) {
                                        inputStream = open;
                                        try {
                                            List<String> emptyList = Collections.emptyList();
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable unused2) {
                                                }
                                            }
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable unused3) {
                                                }
                                            }
                                            return emptyList;
                                        } catch (Throwable th) {
                                            if (inputStream != null) {
                                                try {
                                                    inputStream.close();
                                                } catch (Throwable unused4) {
                                                }
                                            }
                                            if (bufferedReader != null) {
                                                try {
                                                    bufferedReader.close();
                                                } catch (Throwable unused5) {
                                                }
                                            }
                                            throw th;
                                        }
                                    }
                                }
                                if (open != null) {
                                    try {
                                        open.close();
                                    } catch (Throwable unused6) {
                                    }
                                }
                                try {
                                    bufferedReader.close();
                                } catch (Throwable unused7) {
                                }
                                return arrayList;
                            } catch (Throwable unused8) {
                                bufferedReader = null;
                            }
                        } catch (Throwable unused9) {
                            bufferedReader = null;
                        }
                    }
                });
                this.f30225c = new HashMap(list.size());
                String str = "";
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    String str2 = str + ((String) it.next());
                    if (str2.endsWith("\\")) {
                        str = str2.substring(0, str2.length() - 1);
                    } else {
                        f(str2);
                        str = "";
                    }
                }
                if (!str.isEmpty()) {
                    f(str);
                }
                this.f30226w = true;
            }
        }
    }

    private void c(String str, String str2) {
        if (str == null || str.isEmpty() || str2 == null || str2.isEmpty() || this.f30225c.containsKey(str)) {
            return;
        }
        this.f30225c.put(str, str2);
    }
}
