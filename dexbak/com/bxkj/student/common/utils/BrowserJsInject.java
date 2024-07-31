package com.bxkj.student.common.utils;

/* renamed from: com.bxkj.student.common.utils.b */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class BrowserJsInject {
    /* renamed from: a */
    public static String m42866a(String url) {
        if (m42865b(url) != null) {
            return "javascript:document.getElementsByClassName('" + m42865b(url) + "')[0].addEventListener('click',function(){local_obj.playing();return false;});";
        }
        return "javascript:";
    }

    /* renamed from: b */
    public static String m42865b(String url) {
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
