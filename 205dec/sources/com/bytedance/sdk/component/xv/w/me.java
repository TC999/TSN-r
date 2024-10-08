package com.bytedance.sdk.component.xv.w;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum me {
    TLS_1_3("TLSv1.3"),
    TLS_1_2("TLSv1.2"),
    TLS_1_1("TLSv1.1"),
    TLS_1_0("TLSv1"),
    SSL_3_0("SSLv3");
    

    /* renamed from: f  reason: collision with root package name */
    final String f31066f;

    me(String str) {
        this.f31066f = str;
    }

    public static me c(String str) {
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -503070503:
                if (str.equals("TLSv1.1")) {
                    c4 = 0;
                    break;
                }
                break;
            case -503070502:
                if (str.equals("TLSv1.2")) {
                    c4 = 1;
                    break;
                }
                break;
            case -503070501:
                if (str.equals("TLSv1.3")) {
                    c4 = 2;
                    break;
                }
                break;
            case 79201641:
                if (str.equals("SSLv3")) {
                    c4 = 3;
                    break;
                }
                break;
            case 79923350:
                if (str.equals("TLSv1")) {
                    c4 = 4;
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
                return TLS_1_1;
            case 1:
                return TLS_1_2;
            case 2:
                return TLS_1_3;
            case 3:
                return SSL_3_0;
            case 4:
                return TLS_1_0;
            default:
                throw new IllegalArgumentException("Unexpected TLS version: " + str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static List<me> c(String... strArr) {
        ArrayList arrayList = new ArrayList(strArr.length);
        for (String str : strArr) {
            arrayList.add(c(str));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public String c() {
        return this.f31066f;
    }
}
