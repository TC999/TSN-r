package com.bxkj.student.common.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: BrowserJsInject.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class b {
    public static String a(String url) {
        if (b(url) != null) {
            return "javascript:document.getElementsByClassName('" + b(url) + "')[0].addEventListener('click',function(){local_obj.playing();return false;});";
        }
        return "javascript:";
    }

    public static String b(String url) {
        if (url.contains("letv")) {
            return "hv_ico_screen";
        }
        if (url.contains("youku")) {
            return "x-zoomin";
        }
        if (url.contains("bilibili")) {
            return "icon-widescreen";
        }
        if (url.contains("qq")) {
            return "tvp_fullscreen_button";
        }
        return null;
    }
}
