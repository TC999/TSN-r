package com.umeng.analytics.vshelper;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class PageNameMonitor implements PageLifeCycle {
    private static String currentActivity;
    private static String currentCustomPage;
    private static Object lock = new Object();

    /* renamed from: com.umeng.analytics.vshelper.PageNameMonitor$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13187a {

        /* renamed from: a */
        private static final PageNameMonitor f38527a = new PageNameMonitor();

        private C13187a() {
        }
    }

    public static PageNameMonitor getInstance() {
        return C13187a.f38527a;
    }

    @Override // com.umeng.analytics.vshelper.PageLifeCycle
    public void activityPause(String str) {
        synchronized (lock) {
            currentActivity = null;
        }
    }

    @Override // com.umeng.analytics.vshelper.PageLifeCycle
    public void activityResume(String str) {
        synchronized (lock) {
            currentActivity = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.PageLifeCycle
    public void customPageBegin(String str) {
        synchronized (lock) {
            currentCustomPage = str;
        }
    }

    @Override // com.umeng.analytics.vshelper.PageLifeCycle
    public void customPageEnd(String str) {
        synchronized (lock) {
            currentCustomPage = null;
        }
    }

    public String getCurrenPageName() {
        synchronized (lock) {
            String str = currentCustomPage;
            if (str != null) {
                return str;
            }
            String str2 = currentActivity;
            if (str2 != null) {
                return str2;
            }
            return null;
        }
    }

    public String getCurrentActivityName() {
        String str;
        synchronized (lock) {
            str = currentActivity;
        }
        return str;
    }

    private PageNameMonitor() {
    }
}
