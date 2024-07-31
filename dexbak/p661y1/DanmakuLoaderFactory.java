package p661y1;

import p658x1.ILoader;

/* renamed from: y1.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class DanmakuLoaderFactory {

    /* renamed from: a */
    public static String f47154a = "bili";

    /* renamed from: b */
    public static String f47155b = "acfun";

    /* renamed from: a */
    public static ILoader m17a(String str) {
        if (f47154a.equalsIgnoreCase(str)) {
            return BiliDanmakuLoader.m18c();
        }
        if (f47155b.equalsIgnoreCase(str)) {
            return AcFunDanmakuLoader.m21c();
        }
        return null;
    }
}
