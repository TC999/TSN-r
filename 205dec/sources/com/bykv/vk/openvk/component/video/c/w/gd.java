package com.bykv.vk.openvk.component.video.c.w;

import android.net.Uri;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd {

    /* renamed from: c  reason: collision with root package name */
    public final xv f25095c;

    /* renamed from: w  reason: collision with root package name */
    public final List<w> f25096w;
    public final c xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static final class c {

        /* renamed from: c  reason: collision with root package name */
        final int f25097c;

        /* renamed from: f  reason: collision with root package name */
        final String f25098f;

        /* renamed from: r  reason: collision with root package name */
        final List<String> f25099r;
        final int sr;
        final int ux;

        /* renamed from: w  reason: collision with root package name */
        final String f25100w;
        final String xv;

        private c(int i4, String str, String str2, int i5, int i6, String str3, List<String> list) {
            this.f25097c = i4;
            this.f25100w = str;
            this.xv = str2;
            this.sr = i5;
            this.ux = i6;
            this.f25098f = str3;
            this.f25099r = list;
        }

        static c c(xv xvVar, List<w> list) throws sr {
            String str;
            int i4;
            int i5;
            int indexOf = xvVar.f25104w.indexOf("?");
            if (indexOf != -1) {
                ArrayList arrayList = new ArrayList();
                String str2 = null;
                String str3 = null;
                String str4 = null;
                int i6 = 0;
                for (String str5 : xvVar.f25104w.substring(indexOf + 1).split("&")) {
                    String[] split = str5.split("=");
                    if (split.length == 2) {
                        if ("rk".equals(split[0])) {
                            str3 = Uri.decode(split[1]);
                        } else if ("k".equals(split[0])) {
                            str4 = Uri.decode(split[1]);
                        } else if (split[0].startsWith("u")) {
                            arrayList.add(Uri.decode(split[1]));
                        } else if ("f".equals(split[0]) && com.bykv.vk.openvk.component.video.c.xv.c.w(split[1]) == 1) {
                            i6 = 1;
                        }
                    }
                }
                if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
                    if (list != null) {
                        i5 = 0;
                        int i7 = 0;
                        for (w wVar : list) {
                            if (wVar != null && "Range".equalsIgnoreCase(wVar.f25101c)) {
                                int indexOf2 = wVar.f25102w.indexOf("=");
                                if (indexOf2 != -1) {
                                    if ("bytes".equalsIgnoreCase(wVar.f25102w.substring(0, indexOf2).trim())) {
                                        String substring = wVar.f25102w.substring(indexOf2 + 1);
                                        if (!substring.contains(",")) {
                                            int indexOf3 = substring.indexOf("-");
                                            if (indexOf3 != -1) {
                                                String trim = substring.substring(0, indexOf3).trim();
                                                String trim2 = substring.substring(indexOf3 + 1).trim();
                                                try {
                                                    if (trim.length() > 0) {
                                                        i5 = Integer.parseInt(trim);
                                                    }
                                                    if (trim2.length() > 0 && i5 > (i7 = Integer.parseInt(trim2))) {
                                                        throw new sr("Range format error, Range: " + wVar.f25102w);
                                                    }
                                                    str2 = wVar.f25102w;
                                                } catch (NumberFormatException unused) {
                                                    throw new sr("Range format error, Range: " + wVar.f25102w);
                                                }
                                            } else {
                                                throw new sr("Range format error, Range: " + wVar.f25102w);
                                            }
                                        } else {
                                            throw new sr("Range format error, Range: " + wVar.f25102w);
                                        }
                                    } else {
                                        throw new sr("Range format error, Range: " + wVar.f25102w);
                                    }
                                } else {
                                    throw new sr("Range format error, Range: " + wVar.f25102w);
                                }
                            }
                        }
                        i4 = i7;
                        str = str2;
                    } else {
                        str = null;
                        i4 = 0;
                        i5 = 0;
                    }
                    if (!arrayList.isEmpty()) {
                        return new c(i6, str3, str4, i5, i4, str, arrayList);
                    }
                    throw new sr("no url found: path: " + xvVar.f25104w);
                }
                throw new sr("rawKey or key is empty, path: " + xvVar.f25104w);
            }
            throw new sr("path format error, path: " + xvVar.f25104w);
        }

        public String toString() {
            return "Extra{flag=" + this.f25097c + ", rawKey='" + this.f25100w + "', key='" + this.xv + "', from=" + this.sr + ", to=" + this.ux + ", urls=" + this.f25099r + '}';
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class sr extends Exception {
        sr(String str) {
            super(str);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class w {

        /* renamed from: c  reason: collision with root package name */
        public final String f25101c;

        /* renamed from: w  reason: collision with root package name */
        public final String f25102w;

        public w(String str, String str2) {
            this.f25101c = str;
            this.f25102w = str2;
        }

        static w c(String str) throws sr {
            int indexOf = str.indexOf(":");
            if (indexOf != -1) {
                String trim = str.substring(0, indexOf).trim();
                String trim2 = str.substring(indexOf + 1).trim();
                if (trim.length() != 0 && trim2.length() != 0) {
                    return new w(trim, trim2);
                }
                throw new sr("request header format error, header: " + str);
            }
            throw new sr("request header format error, header: " + str);
        }

        public String toString() {
            return "Header{name='" + this.f25101c + "', value='" + this.f25102w + "'}";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static final class xv {

        /* renamed from: c  reason: collision with root package name */
        final String f25103c;

        /* renamed from: w  reason: collision with root package name */
        final String f25104w;
        final String xv;

        private xv(String str, String str2, String str3) {
            this.f25103c = str;
            this.f25104w = str2;
            this.xv = str3;
        }

        static xv c(String str) throws sr {
            int indexOf = str.indexOf(32);
            if (indexOf != -1) {
                int lastIndexOf = str.lastIndexOf(32);
                if (lastIndexOf > indexOf) {
                    String trim = str.substring(0, indexOf).trim();
                    String trim2 = str.substring(indexOf + 1, lastIndexOf).trim();
                    String trim3 = str.substring(lastIndexOf + 1).trim();
                    if (trim.length() != 0 && trim2.length() != 0 && trim3.length() != 0) {
                        return new xv(trim, trim2, trim3);
                    }
                    throw new sr("request line format error, line: " + str);
                }
                throw new sr("request line format error, line: " + str);
            }
            throw new sr("request line format error, line: " + str);
        }

        public String toString() {
            return "RequestLine{method='" + this.f25103c + "', path='" + this.f25104w + "', version='" + this.xv + "'}";
        }
    }

    public gd(xv xvVar, List<w> list, c cVar) {
        this.f25095c = xvVar;
        this.f25096w = list;
        this.xv = cVar;
    }

    public static gd c(InputStream inputStream) throws IOException, sr {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, com.bykv.vk.openvk.component.video.c.xv.c.f25164c));
        ArrayList arrayList = new ArrayList();
        xv xvVar = null;
        while (true) {
            String readLine = bufferedReader.readLine();
            if (TextUtils.isEmpty(readLine)) {
                break;
            }
            String trim = readLine.trim();
            if (xvVar == null) {
                xvVar = xv.c(trim);
            } else {
                arrayList.add(w.c(trim));
            }
        }
        if (xvVar != null) {
            return new gd(xvVar, arrayList, c.c(xvVar, arrayList));
        }
        throw new sr("request line is null");
    }

    public String toString() {
        return "Request{requestLine=" + this.f25095c + ", headers=" + this.f25096w + ", extra=" + this.xv + '}';
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str, String str2, List<String> list) {
        StringBuilder sb = new StringBuilder(512);
        String str3 = null;
        do {
            if (str3 != null) {
                if (list.size() == 1) {
                    return null;
                }
                list.remove(list.size() - 1);
            }
            str3 = c(sb, str, str2, list);
        } while (str3.length() > 3072);
        return str3;
    }

    private static String c(StringBuilder sb, String str, String str2, List<String> list) {
        sb.delete(0, sb.length());
        sb.append("rk");
        sb.append("=");
        sb.append(Uri.encode(str));
        sb.append("&");
        sb.append("k");
        sb.append("=");
        sb.append(Uri.encode(str2));
        int size = list.size();
        for (int i4 = 0; i4 < size; i4++) {
            sb.append("&");
            sb.append("u");
            sb.append(i4);
            sb.append("=");
            sb.append(Uri.encode(list.get(i4)));
        }
        return sb.toString();
    }
}
