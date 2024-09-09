package com.qq.e.comm.plugin.util;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.MimeTypeMap;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class i2 {

    /* JADX WARN: $VALUES field not found */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static final class a {

        /* renamed from: d  reason: collision with root package name */
        public static final a f46488d = new a("HTML", 0, "text/html");

        /* renamed from: e  reason: collision with root package name */
        public static final a f46489e = new a("CSS", 1, "text/css");

        /* renamed from: f  reason: collision with root package name */
        public static final a f46490f = new a("JS", 2, "application/x-javascript");

        /* renamed from: g  reason: collision with root package name */
        public static final a f46491g = new a("IMAGE", 3, "image/*");

        /* renamed from: c  reason: collision with root package name */
        private String f46492c;

        private a(String str, int i4, String str2) {
            this.f46492c = str2;
        }

        public String a() {
            return this.f46492c;
        }
    }

    public static String a(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || TextUtils.isEmpty(str)) {
            return str;
        }
        String str4 = str.contains("?") ? "&" : "?";
        return str + str4 + str2 + "=" + str3;
    }

    public static boolean b(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        URL url = null;
        try {
            url = new URL(str);
        } catch (MalformedURLException e4) {
            e4.printStackTrace();
        }
        if (url != null) {
            String query = url.getQuery();
            if (TextUtils.isEmpty(query)) {
                return false;
            }
            return Pattern.compile("(^|&)" + str2 + "=" + str3 + "(&|$)").matcher(query).find();
        }
        return false;
    }

    public static String c(String str, String str2, String str3) {
        Pair<Boolean, String> d4 = d(str, str2, str3);
        if (((Boolean) d4.first).booleanValue()) {
            return (String) d4.second;
        }
        return a(str, str2, str3);
    }

    public static Pair<Boolean, String> d(String str, String str2, String str3) {
        String str4 = "(\\?|&|#)" + str2 + "=([^&#]*)";
        String str5 = str2 + "=" + str3;
        Matcher matcher = Pattern.compile(str4).matcher(str);
        StringBuffer stringBuffer = new StringBuffer();
        boolean z3 = false;
        while (matcher.find()) {
            matcher.appendReplacement(stringBuffer, matcher.group(1) + str5);
            z3 = true;
        }
        matcher.appendTail(stringBuffer);
        return new Pair<>(Boolean.valueOf(z3), stringBuffer.toString());
    }

    public static boolean e(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("weixin://dl");
    }

    public static boolean a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        int indexOf = str.indexOf("?");
        if (indexOf > 0) {
            str = str.substring(0, indexOf - 1);
        }
        int indexOf2 = str2.indexOf("?");
        if (indexOf2 > 0) {
            str2 = str2.substring(0, indexOf2 - 1);
        }
        return TextUtils.equals(str, str2);
    }

    public static boolean c(Uri uri) {
        return (uri == null || uri.getScheme() == null || (!uri.getScheme().equalsIgnoreCase("http") && !uri.getScheme().equalsIgnoreCase("https"))) ? false : true;
    }

    public static boolean c(String str) {
        return (TextUtils.isEmpty(str) || d(str)) ? false : true;
    }

    public static boolean d(String str) {
        return c(Uri.parse(str));
    }

    public static boolean b(Uri uri) {
        return uri != null && uri.isHierarchical() && "gdtmsg".equals(uri.getScheme()) && "e.qq.com".equals(uri.getAuthority());
    }

    public static String a(Uri uri) {
        if (uri == null) {
            return "";
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return "";
        }
        int lastIndexOf = path.lastIndexOf("/0");
        if (lastIndexOf > 0) {
            path = path.substring(0, lastIndexOf);
        }
        String fileExtensionFromUrl = MimeTypeMap.getFileExtensionFromUrl(path);
        return !TextUtils.isEmpty(fileExtensionFromUrl) ? fileExtensionFromUrl.toLowerCase() : "";
    }

    public static String b(String str) {
        int indexOf;
        return (!TextUtils.isEmpty(str) && (indexOf = str.indexOf(63)) > 0) ? str.substring(0, indexOf) : str;
    }

    public static a a(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = str.toLowerCase();
        }
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case 3401:
                if (str.equals("js")) {
                    c4 = 1;
                    break;
                }
                break;
            case 97669:
                if (str.equals("bmp")) {
                    c4 = 6;
                    break;
                }
                break;
            case 98819:
                if (str.equals("css")) {
                    c4 = 0;
                    break;
                }
                break;
            case 102340:
                if (str.equals("gif")) {
                    c4 = 7;
                    break;
                }
                break;
            case 105441:
                if (str.equals("jpg")) {
                    c4 = 2;
                    break;
                }
                break;
            case 111145:
                if (str.equals("png")) {
                    c4 = 4;
                    break;
                }
                break;
            case 3213227:
                if (str.equals("html")) {
                    c4 = '\b';
                    break;
                }
                break;
            case 3268712:
                if (str.equals("jpeg")) {
                    c4 = 3;
                    break;
                }
                break;
            case 3645340:
                if (str.equals("webp")) {
                    c4 = 5;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return a.f46489e;
            case 1:
                return a.f46490f;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return a.f46491g;
            default:
                return a.f46488d;
        }
    }

    public static boolean a(String str, Collection<String> collection) {
        try {
            if (TextUtils.isEmpty(str) || collection == null || collection.size() <= 0) {
                return false;
            }
            return collection.contains(Uri.parse(str).getHost());
        } catch (Throwable th) {
            d1.a(th.getMessage(), th);
            return false;
        }
    }
}
