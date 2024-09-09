package com.qq.e.comm.plugin.q0.s;

import com.qq.e.comm.plugin.util.x1;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private String f45536a;

    /* renamed from: b  reason: collision with root package name */
    private String[] f45537b;

    public c(String str, String... strArr) {
        this.f45536a = str;
        this.f45537b = strArr;
    }

    public String a() {
        StringBuilder sb = new StringBuilder();
        String str = this.f45536a;
        if (str != null) {
            sb.append(str);
            sb.append("(");
            String[] strArr = this.f45537b;
            if (strArr != null && strArr.length > 0) {
                sb.append(x1.a(",", strArr));
            }
            sb.append(")");
        }
        return sb.toString();
    }
}
