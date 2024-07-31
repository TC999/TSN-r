package com.umeng.commonsdk.statistics.common;

import android.text.TextUtils;
import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Formatter;
import java.util.Locale;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ULog {
    public static boolean DEBUG = false;
    private static final int LEVEL_DEBUG = 2;
    private static final int LEVEL_ERROR = 5;
    private static final int LEVEL_INFO = 3;
    private static final int LEVEL_VERBOSE = 1;
    private static final int LEVEL_WARN = 4;
    private static int LOG_MAXLENGTH = 2000;
    private static String TAG = "ULog";

    private ULog() {
    }

    /* renamed from: d */
    public static void m13791d(Locale locale, String str, Object... objArr) {
        try {
            m13795d(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m13786e(th);
        }
    }

    /* renamed from: e */
    public static void m13785e(Locale locale, String str, Object... objArr) {
        try {
            m13789e(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m13786e(th);
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
    public static void m13779i(Locale locale, String str, Object... objArr) {
        try {
            m13783i(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m13786e(th);
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
    public static void m13773v(Locale locale, String str, Object... objArr) {
        try {
            m13777v(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m13786e(th);
        }
    }

    /* renamed from: w */
    public static void m13767w(Locale locale, String str, Object... objArr) {
        try {
            m13771w(TAG, new Formatter(locale).format(str, objArr).toString(), (Throwable) null);
        } catch (Throwable th) {
            m13786e(th);
        }
    }

    /* renamed from: d */
    public static void m13793d(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m13795d(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m13795d(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m13786e(th);
        }
    }

    /* renamed from: e */
    public static void m13787e(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m13789e(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m13789e(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m13786e(th);
        }
    }

    /* renamed from: i */
    public static void m13781i(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m13783i(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m13783i(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m13786e(th);
        }
    }

    /* renamed from: v */
    public static void m13775v(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m13777v(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m13777v(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m13786e(th);
        }
    }

    /* renamed from: w */
    public static void m13769w(String str, Object... objArr) {
        try {
            if (str.contains("%")) {
                m13771w(TAG, new Formatter().format(str, objArr).toString(), (Throwable) null);
            } else {
                m13771w(str, objArr != null ? (String) objArr[0] : "", (Throwable) null);
            }
        } catch (Throwable th) {
            m13786e(th);
        }
    }

    /* renamed from: d */
    public static void m13792d(Throwable th) {
        m13795d(TAG, (String) null, th);
    }

    /* renamed from: e */
    public static void m13786e(Throwable th) {
        m13789e(TAG, (String) null, th);
    }

    /* renamed from: i */
    public static void m13780i(Throwable th) {
        m13783i(TAG, (String) null, th);
    }

    /* renamed from: v */
    public static void m13774v(Throwable th) {
        m13777v(TAG, (String) null, th);
    }

    /* renamed from: w */
    public static void m13768w(Throwable th) {
        m13771w(TAG, (String) null, th);
    }

    /* renamed from: d */
    public static void m13794d(String str, Throwable th) {
        m13795d(TAG, str, th);
    }

    /* renamed from: e */
    public static void m13788e(String str, Throwable th) {
        m13789e(TAG, str, th);
    }

    /* renamed from: i */
    public static void m13782i(String str, Throwable th) {
        m13783i(TAG, str, th);
    }

    /* renamed from: v */
    public static void m13776v(String str, Throwable th) {
        m13777v(TAG, str, th);
    }

    /* renamed from: w */
    public static void m13770w(String str, Throwable th) {
        m13771w(TAG, str, th);
    }

    /* renamed from: d */
    public static void m13796d(String str) {
        m13795d(TAG, str, (Throwable) null);
    }

    /* renamed from: e */
    public static void m13790e(String str) {
        m13789e(TAG, str, (Throwable) null);
    }

    /* renamed from: i */
    public static void m13784i(String str) {
        m13783i(TAG, str, (Throwable) null);
    }

    /* renamed from: v */
    public static void m13778v(String str) {
        m13777v(TAG, str, (Throwable) null);
    }

    /* renamed from: w */
    public static void m13772w(String str) {
        m13771w(TAG, str, (Throwable) null);
    }

    /* renamed from: d */
    public static void m13795d(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(2, str, str2, th);
        }
    }

    /* renamed from: e */
    public static void m13789e(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(5, str, str2, th);
        }
    }

    /* renamed from: i */
    public static void m13783i(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(3, str, str2, th);
        }
    }

    /* renamed from: v */
    public static void m13777v(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(1, str, str2, th);
        }
    }

    /* renamed from: w */
    public static void m13771w(String str, String str2, Throwable th) {
        if (DEBUG) {
            print(4, str, str2, th);
        }
    }
}
