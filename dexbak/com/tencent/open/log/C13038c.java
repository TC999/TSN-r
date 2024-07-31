package com.tencent.open.log;

import com.baidu.mobads.sdk.internal.C2624bk;
import com.clj.fastble.BleManager;
import com.tencent.connect.common.Constants;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import java.io.File;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.log.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C13038c {

    /* renamed from: a */
    public static int f37378a = 60;

    /* renamed from: b */
    public static int f37379b = 60;

    /* renamed from: c */
    public static String f37380c = "OpenSDK.Client.File.Tracer";

    /* renamed from: d */
    public static String f37381d;

    /* renamed from: e */
    public static String f37382e;

    /* renamed from: f */
    public static long f37383f;

    /* renamed from: g */
    public static int f37384g;

    /* renamed from: h */
    public static int f37385h;

    /* renamed from: i */
    public static int f37386i;

    /* renamed from: j */
    public static String f37387j;

    /* renamed from: k */
    public static String f37388k;

    /* renamed from: l */
    public static String f37389l;

    /* renamed from: m */
    public static int f37390m;

    /* renamed from: n */
    public static long f37391n;

    /* renamed from: o */
    public static String f37392o;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("Tencent");
        String str = File.separator;
        sb.append(str);
        sb.append("msflogs");
        sb.append(str);
        sb.append("com");
        sb.append(str);
        sb.append(SocializeProtocolConstants.PROTOCOL_KEY_TENCENT);
        sb.append(str);
        sb.append("mobileqq");
        sb.append(str);
        f37381d = sb.toString();
        f37382e = ".log";
        f37383f = 8388608L;
        f37384g = 262144;
        f37385h = 1024;
        f37386i = BleManager.f22896l;
        f37387j = "debug.file.blockcount";
        f37388k = "debug.file.keepperiod";
        f37389l = "debug.file.tracelevel";
        f37390m = 24;
        f37391n = C2624bk.f8680d;
        f37392o = Constants.APP_SPECIFIC_ROOT + str + "logs";
    }
}
