package com.tencent.ams.a.a.b;

import java.util.List;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public f f50676a;

    /* renamed from: b  reason: collision with root package name */
    public List<b> f50677b;

    /* renamed from: c  reason: collision with root package name */
    private String f50678c;

    public String toString() {
        String str = this.f50678c;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f50676a != null) {
            sb.append("offlineCache[");
            sb.append("len=");
            sb.append(this.f50676a.f50673a);
            sb.append(",");
            sb.append("timeout=");
            sb.append(this.f50676a.f50675c);
            sb.append(",");
            sb.append("expiration=");
            sb.append(this.f50676a.f50674b);
            sb.append("]");
        }
        List<b> list = this.f50677b;
        if (list != null && list.size() > 0) {
            sb.append("companies{");
            for (b bVar : this.f50677b) {
                if (bVar != null) {
                    sb.append("[");
                    sb.append(bVar.f50658a);
                    if (bVar.f50659b != null) {
                        sb.append("--");
                        sb.append(bVar.f50659b.f50669a);
                    }
                    sb.append("]");
                }
            }
            sb.append("}");
        }
        String sb2 = sb.toString();
        this.f50678c = sb2;
        return sb2;
    }
}
