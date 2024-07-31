package com.kwad.framework.filedownloader.p353f;

/* renamed from: com.kwad.framework.filedownloader.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C9489a {
    /* renamed from: a */
    private static void m28559a(String str, Object... objArr) {
        C9498d.m28534d(C9489a.class, str + ", but the download service isn't connected yet.\nYou can use FileDownloader#isServiceConnected() to check whether the service has been connected, \nbesides you can use following functions easier to control your requestHttpCode invoke after the service has been connected: \n1. FileDownloader#bindService(Runnable)\n2. FileDownloader#insureServiceBind()\n3. FileDownloader#insureServiceBindAsync()", objArr);
    }

    /* renamed from: bd */
    public static boolean m28558bd(int i) {
        m28559a("request pause the task[%d] in the download service", Integer.valueOf(i));
        return false;
    }

    /* renamed from: be */
    public static byte m28557be(int i) {
        m28559a("request get the status for the task[%d] in the download service", Integer.valueOf(i));
        return (byte) 0;
    }

    /* renamed from: bf */
    public static boolean m28556bf(int i) {
        m28559a("request clear the task[%d] data in the database", Integer.valueOf(i));
        return false;
    }

    /* renamed from: h */
    public static boolean m28555h(String str, String str2, boolean z) {
        m28559a("request start the task([%s], [%s], [%B]) in the download service", str, str2, Boolean.valueOf(z));
        return false;
    }
}
