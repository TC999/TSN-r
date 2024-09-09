package com.bytedance.embedapplog.util;

import com.bytedance.embedapplog.util.UriConfig;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static final UriConfig f26823c = new UriConfig.c().c("https://log.snssdk.com/service/2/device_register_only/").c(new String[]{"https://log.snssdk.com/service/2/app_log/", "https://applog.snssdk.com/service/2/app_log/"}).w(new String[]{"https://rtlog.snssdk.com/service/2/app_log/", "https://rtapplog.snssdk.com/service/2/app_log/"}).w("https://log.snssdk.com/service/2/log_settings/").c();

    /* renamed from: w  reason: collision with root package name */
    private static final UriConfig f26824w = new UriConfig.c().c("https://toblog.ctobsnssdk.com/service/2/device_register_only/").c(new String[]{"https://toblog.ctobsnssdk.com/service/2/app_log/", "https://tobapplog.ctobsnssdk.com/service/2/app_log/"}).w("https://toblog.ctobsnssdk.com/service/2/log_settings/").xv("https://toblog.ctobsnssdk.com/service/2/abtest_config/").sr("https://success.ctobsnssdk.com/service/2/app_log/").c();

    public static final UriConfig c(int i4) {
        return f26824w;
    }
}
