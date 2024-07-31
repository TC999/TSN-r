package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class MLog {
    public static boolean DEBUG = false;
    private static final int LEVEL_DEBUG = 2;
    private static final int LEVEL_ERROR = 5;
    private static final int LEVEL_INFO = 3;
    private static final int LEVEL_VERBOSE = 1;
    private static final int LEVEL_WARN = 4;
    private static int LOG_MAXLENGTH = 2000;
    private static String TAG = "MobclickAgent";

    private MLog() {
    }

    /* renamed from: d */
    public static void m13821d(Locale locale, String str, Object... objArr) {
        try {
            m13825d(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m13816e(th);
        }
    }

    /* renamed from: e */
    public static void m13815e(Locale locale, String str, Object... objArr) {
        try {
            m13819e(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m13816e(th);
        }
    }

    public static String getStackTrace(Throwable th) {
        PrintWriter printWriter;
        StringWriter stringWriter;
        StringWriter stringWriter2 = null;
        try {
            stringWriter = new StringWriter();
            try {
                printWriter = new PrintWriter(stringWriter);
            } catch (Throwable unused) {
                printWriter = null;
            }
        } catch (Throwable unused2) {
            printWriter = null;
        }
        try {
            th.printStackTrace(printWriter);
            printWriter.flush();
            stringWriter.flush();
            String stringWriter3 = stringWriter.toString();
            try {
                stringWriter.close();
            } catch (Throwable unused3) {
            }
            printWriter.close();
            return stringWriter3;
        } catch (Throwable unused4) {
            stringWriter2 = stringWriter;
            if (stringWriter2 != null) {
                try {
                    stringWriter2.close();
                } catch (Throwable unused5) {
                }
            }
            if (printWriter != null) {
                printWriter.close();
            }
            return "";
        }
    }

    /* renamed from: i */
    public static void m13809i(Locale locale, String str, Object... objArr) {
        try {
            m13813i(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m13816e(th);
        }
    }

    private static void print(int i, String str, String str2, Throwable th) {
        if (!TextUtils.isEmpty(str2)) {
            int length = str2.length();
            int i2 = LOG_MAXLENGTH;
            int i3 = 0;
            int i4 = 0;
            while (true) {
                if (i3 >= 100) {
                    break;
                } else if (length > i2) {
                    if (i == 1) {
                        Log.v(str, str2.substring(i4, i2));
                    } else if (i == 2) {
                        Log.d(str, str2.substring(i4, i2));
                    } else if (i == 3) {
                        Log.i(str, str2.substring(i4, i2));
                    } else if (i == 4) {
                        Log.w(str, str2.substring(i4, i2));
                    } else if (i == 5) {
                        Log.e(str, str2.substring(i4, i2));
                    }
                    i3++;
                    i4 = i2;
                    i2 = LOG_MAXLENGTH + i2;
                } else if (i == 1) {
                    Log.v(str, str2.substring(i4, length));
                } else if (i == 2) {
                    Log.d(str, str2.substring(i4, length));
                } else if (i == 3) {
                    Log.i(str, str2.substring(i4, length));
                } else if (i == 4) {
                    Log.w(str, str2.substring(i4, length));
                } else if (i == 5) {
                    Log.e(str, str2.substring(i4, length));
                }
            }
        }
        if (th != null) {
            String stackTrace = getStackTrace(th);
            if (TextUtils.isEmpty(stackTrace)) {
                return;
            }
            if (i == 1) {
                Log.v(str, stackTrace);
            } else if (i == 2) {
                Log.d(str, stackTrace);
            } else if (i == 3) {
                Log.i(str, stackTrace);
            } else if (i == 4) {
                Log.w(str, stackTrace);
            } else if (i != 5) {
            } else {
                Log.e(str, stackTrace);
            }
        }
    }

    /* renamed from: v */
    public static void m13803v(Locale locale, String str, Object... objArr) {
        try {
            m13807v(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m13816e(th);
        }
    }

    /* renamed from: w */
    public static void m13797w(Locale locale, String str, Object... objArr) {
        try {
            m13801w(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m13816e(th);
        }
    }

    /* renamed from: d */
    public static void m13823d(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m13825d(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m13825d(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m13816e(th);
        }
    }

    /* renamed from: e */
    public static void m13817e(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m13819e(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m13819e(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m13816e(th);
        }
    }

    /* renamed from: i */
    public static void m13811i(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m13813i(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m13813i(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m13816e(th);
        }
    }

    /* renamed from: v */
    public static void m13805v(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m13807v(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m13807v(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m13816e(th);
        }
    }

    /* renamed from: w */
    public static void m13799w(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m13801w(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m13801w(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m13816e(th);
        }
    }

    /* renamed from: d */
    public static void m13822d(Throwable th) {
        m13825d(TAG, (String) null, th);
    }

    /* renamed from: e */
    public static void m13816e(Throwable th) {
        m13819e(TAG, (String) null, th);
    }

    /* renamed from: i */
    public static void m13810i(Throwable th) {
        m13813i(TAG, (String) null, th);
    }

    /* renamed from: v */
    public static void m13804v(Throwable th) {
        m13807v(TAG, (String) null, th);
    }

    /* renamed from: w */
    public static void m13798w(Throwable th) {
        m13801w(TAG, (String) null, th);
    }

    /* renamed from: d */
    public static void m13824d(String str, Throwable th) {
        m13825d(TAG, str, th);
    }

    /* renamed from: e */
    public static void m13818e(String str, Throwable th) {
        m13819e(TAG, str, th);
    }

    /* renamed from: i */
    public static void m13812i(String str, Throwable th) {
        m13813i(TAG, str, th);
    }

    /* renamed from: v */
    public static void m13806v(String str, Throwable th) {
        m13807v(TAG, str, th);
    }

    /* renamed from: w */
    public static void m13800w(String str, Throwable th) {
        m13801w(TAG, str, th);
    }

    /* renamed from: d */
    public static void m13826d(String str) {
        m13825d(TAG, str, (Throwable) null);
    }

    /* renamed from: e */
    public static void m13820e(String str) {
        m13819e(TAG, str, (Throwable) null);
    }

    /* renamed from: i */
    public static void m13814i(String str) {
        m13813i(TAG, str, (Throwable) null);
    }

    /* renamed from: v */
    public static void m13808v(String str) {
        m13807v(TAG, str, (Throwable) null);
    }

    /* renamed from: w */
    public static void m13802w(String str) {
        m13801w(TAG, str, (Throwable) null);
    }

    /* renamed from: d */
    public static void m13825d(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(2, str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m13819e(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(5, str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m13813i(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(3, str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m13807v(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(1, str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m13801w(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(4, str, str2, th);
        }
    }
}
