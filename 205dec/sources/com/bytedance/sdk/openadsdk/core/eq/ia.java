package com.bytedance.sdk.openadsdk.core.eq;

import android.content.Context;
import android.content.res.XmlResourceParser;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ia {

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c {

        /* renamed from: c  reason: collision with root package name */
        String f33263c;

        /* renamed from: w  reason: collision with root package name */
        String f33264w;
        String xv;

        c(String str, String str2, String str3) {
            this.f33263c = str;
            this.f33264w = str2;
            this.xv = str3;
        }

        public boolean equals(Object obj) {
            String str;
            if (obj instanceof c) {
                c cVar = (c) obj;
                String str2 = this.f33263c;
                return str2 != null && str2.equals(cVar.f33263c) && (str = this.xv) != null && str.equals(cVar.xv);
            }
            return super.equals(obj);
        }

        public String toString() {
            try {
                return "<" + this.f33263c + " name=\"" + this.f33264w + "\" path=\"" + this.xv + "\" />";
            } catch (Throwable unused) {
                return super.toString();
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x02ba  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void c() {
        /*
            Method dump skipped, instructions count: 709
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.eq.ia.c():void");
    }

    private static List<c> sr() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c("external-path", "tt_external_root", "."));
        return arrayList;
    }

    private static List<String> w() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.INTERNET");
        arrayList.add("android.permission.ACCESS_NETWORK_STATE");
        arrayList.add("android.permission.ACCESS_WIFI_STATE");
        arrayList.add("android.permission.READ_PHONE_STATE");
        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        arrayList.add("android.permission.REQUEST_INSTALL_PACKAGES");
        arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        arrayList.add("android.permission.ACCESS_FINE_LOCATION");
        return arrayList;
    }

    private static List<c> xv() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new c("external-path", "tt_external_download", "Download"));
        arrayList.add(new c("external-files-path", "tt_external_files_download", "Download"));
        arrayList.add(new c("files-path", "tt_internal_file_download", "Download"));
        arrayList.add(new c("cache-path", "tt_internal_cache_download", "Download"));
        return arrayList;
    }

    private static String c(Context context) {
        try {
            return com.bytedance.sdk.component.utils.s.w(context);
        } catch (Throwable unused) {
            return "unknown";
        }
    }

    private static List<c> c(Context context, int i4) {
        XmlResourceParser xmlResourceParser;
        ArrayList arrayList;
        try {
            arrayList = new ArrayList();
            xmlResourceParser = context.getResources().getXml(i4);
        } catch (Throwable unused) {
            xmlResourceParser = null;
        }
        try {
            for (int eventType = xmlResourceParser.getEventType(); eventType != 1; eventType = xmlResourceParser.next()) {
                if (eventType != 2) {
                    continue;
                } else {
                    String name = xmlResourceParser.getName();
                    int attributeCount = xmlResourceParser.getAttributeCount();
                    String str = null;
                    String str2 = null;
                    for (int i5 = 0; i5 < attributeCount; i5++) {
                        String attributeName = xmlResourceParser.getAttributeName(i5);
                        if (attributeName.equals("name")) {
                            str = xmlResourceParser.getAttributeValue(i5);
                        } else if (attributeName.equals("path")) {
                            str2 = xmlResourceParser.getAttributeValue(i5);
                        }
                    }
                    if (!TextUtils.isEmpty(name) && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                        arrayList.add(new c(name, str, str2));
                        continue;
                    }
                }
            }
            xmlResourceParser.close();
            return arrayList;
        } catch (Throwable unused2) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            return null;
        }
    }
}
