package com.mbridge.msdk.foundation.same.report.p489c;

/* renamed from: com.mbridge.msdk.foundation.same.report.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class LogFileController {

    /* renamed from: a */
    public static final String f30924a = "a";

    /* renamed from: b */
    private static LogFileController f30925b;

    private LogFileController() {
    }

    /* renamed from: a */
    public static LogFileController m22107a() {
        if (f30925b == null) {
            synchronized (LogFileController.class) {
                if (f30925b == null) {
                    f30925b = new LogFileController();
                }
            }
        }
        return f30925b;
    }
}
