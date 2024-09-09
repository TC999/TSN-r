package com.qihoo.bugreport.javacrash;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.qihoo.jiagu.b;
import com.qihoo.jiagu.c;
import com.qihoo.jiagu.e;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EnumMap;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\93344.dex */
public class ExceptionHandleReporter implements Thread.UncaughtExceptionHandler {

    /* renamed from: a  reason: collision with root package name */
    private static ExceptionHandleReporter f41409a;

    /* renamed from: b  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f41410b = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: c  reason: collision with root package name */
    private final Context f41411c;

    /* renamed from: d  reason: collision with root package name */
    private final CrashReportDataFactory f41412d;

    /* renamed from: e  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f41413e;

    private ExceptionHandleReporter(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        this.f41411c = context;
        this.f41413e = uncaughtExceptionHandler;
        this.f41412d = new CrashReportDataFactory(this.f41411c, new GregorianCalendar());
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    public static synchronized ExceptionHandleReporter a(Context context, Thread.UncaughtExceptionHandler uncaughtExceptionHandler) {
        ExceptionHandleReporter exceptionHandleReporter;
        synchronized (ExceptionHandleReporter.class) {
            if (f41409a == null) {
                f41409a = new ExceptionHandleReporter(context, uncaughtExceptionHandler);
            }
            exceptionHandleReporter = f41409a;
        }
        return exceptionHandleReporter;
    }

    @Override // java.lang.Thread.UncaughtExceptionHandler
    public void uncaughtException(Thread thread, Throwable th) {
        uncaughtException(thread, th, false, 0);
    }

    public void uncaughtException(Thread thread, Throwable th, boolean z3) {
        uncaughtException(thread, th, z3, 2);
    }

    public void uncaughtException(Thread thread, Throwable th, boolean z3, int i4) {
        boolean z4 = false;
        try {
            String[] strArr = b.f41423a;
            Context context = this.f41411c;
            int length = strArr.length;
            int i5 = 0;
            while (true) {
                if (i5 < length) {
                    if (!c.a(context, strArr[i5])) {
                        break;
                    }
                    i5++;
                } else {
                    z4 = true;
                    break;
                }
            }
            if (!z4) {
                a(thread, th, z3);
                return;
            }
            CrashReportDataFactory crashReportDataFactory = this.f41412d;
            EnumMap enumMap = new EnumMap(ReportField.class);
            enumMap.put((EnumMap) ReportField.t, (ReportField) "1");
            enumMap.put((EnumMap) ReportField.cpv, (ReportField) "3");
            enumMap.put((EnumMap) ReportField.st, (ReportField) CrashReportDataFactory.a(crashReportDataFactory.f41408a));
            enumMap.put((EnumMap) ReportField.ct, (ReportField) CrashReportDataFactory.a(new GregorianCalendar()));
            String name = th.getClass().getName();
            enumMap.put((EnumMap) ReportField.et, (ReportField) name);
            String message = th.getMessage();
            enumMap.put((EnumMap) ReportField.ec, (ReportField) message);
            enumMap.put((EnumMap) ReportField.jc, (ReportField) String.valueOf(i4));
            ArrayList<String> a4 = CrashReportDataFactory.a(th);
            String a5 = crashReportDataFactory.a(name, message, a4);
            if (a5 != null) {
                enumMap.put((EnumMap) ReportField.me, (ReportField) a5);
            }
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            th.printStackTrace(printWriter);
            String obj = stringWriter.toString();
            printWriter.close();
            String a6 = CrashReportDataFactory.a(obj);
            if (a6 == null) {
                enumMap.put((EnumMap) ReportField.crd, (ReportField) "null");
            } else {
                enumMap.put((EnumMap) ReportField.crd, (ReportField) a6);
            }
            String a7 = CrashReportDataFactory.a(obj, a4);
            if (a7 != null) {
                enumMap.put((EnumMap) ReportField.em, (ReportField) a7);
            }
            String c4 = CrashReportDataFactory.c();
            if (c4 != null) {
                enumMap.put((EnumMap) ReportField.ep, (ReportField) c4);
            }
            HashMap<String, String> a8 = CrashReportDataFactory.a();
            if (a8.get("ed") != null) {
                enumMap.put((EnumMap) ReportField.ed, (ReportField) a8.get("ed"));
            }
            if (a8.get("epd") != null) {
                enumMap.put((EnumMap) ReportField.epd, (ReportField) a8.get("epd"));
            }
            JSONObject a9 = c.a(enumMap, crashReportDataFactory.b());
            if (a9 == null) {
                a(thread, th, z3);
                return;
            }
            a9.toString();
            synchronized (ExceptionHandleReporter.class) {
                if (a(a9, th)) {
                    a(thread, th, z3);
                    return;
                }
                e eVar = new e(this, z3, a9);
                eVar.start();
                eVar.join(4000L);
                a(thread, th, z3);
            }
        } catch (Throwable th2) {
            a(thread, th, z3);
        }
    }

    private synchronized boolean a(JSONObject jSONObject, Throwable th) {
        boolean z3;
        long time;
        if (!jSONObject.has(ReportField.me.name()) || !jSONObject.has(ReportField.ct.name())) {
            z3 = true;
        } else {
            SharedPreferences sharedPreferences = this.f41411c.getSharedPreferences("qihoo_jiagu_crash_report", 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            String string = sharedPreferences.getString("last_report_me", "");
            String string2 = sharedPreferences.getString("last_report_time", "0000/00/00 00:00:00");
            String string3 = sharedPreferences.getString("last_exception_info", "");
            String num = Integer.toString(th.hashCode());
            try {
                String string4 = jSONObject.getString(ReportField.me.name());
                String string5 = jSONObject.getString(ReportField.ct.name());
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.ENGLISH);
                Date parse = simpleDateFormat.parse(string5);
                Date parse2 = simpleDateFormat.parse(string2);
                if (parse.getTime() - parse2.getTime() < 0) {
                    edit.putString("last_report_time", jSONObject.getString(ReportField.ct.name()));
                    edit.commit();
                    z3 = true;
                } else {
                    if (string.equals(string4) || num.equals(string3)) {
                        time = (parse.getTime() - parse2.getTime()) - 600000;
                    } else {
                        time = (parse.getTime() - parse2.getTime()) - PolicyConfig.THREAD_BLOCK_TIMEOUT;
                    }
                    if (time < 0) {
                        z3 = true;
                    } else {
                        edit.putString("last_report_me", jSONObject.getString(ReportField.me.name()));
                        edit.putString("last_report_time", jSONObject.getString(ReportField.ct.name()));
                        edit.putString("last_exception_info", num);
                        edit.commit();
                        z3 = false;
                    }
                }
            } catch (ParseException e4) {
                z3 = true;
            } catch (JSONException e5) {
                z3 = true;
            }
        }
        return z3;
    }

    private void a(Thread thread, Throwable th, boolean z3) {
        if (!z3) {
            try {
                if (this.f41410b != null) {
                    this.f41410b.uncaughtException(thread, th);
                } else {
                    b(thread, th, z3);
                }
            } catch (Throwable th2) {
                b(thread, th, z3);
            }
        }
    }

    private void b(Thread thread, Throwable th, boolean z3) {
        if (!z3) {
            try {
                if (this.f41413e != null) {
                    this.f41413e.uncaughtException(thread, th);
                }
            } catch (Throwable th2) {
            }
        }
    }
}
