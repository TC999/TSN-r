package com.qq.e.dl.k;

import java.util.List;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    List<g> f47008a;

    public b(List<g> list) {
        this.f47008a = list;
    }

    @Override // com.qq.e.dl.k.g
    public g a() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.qq.e.dl.k.c
    public Object a(JSONObject jSONObject) {
        List<g> list = this.f47008a;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (g gVar : this.f47008a) {
            if (gVar instanceof j) {
                sb.append(gVar.e(jSONObject));
            } else if (gVar instanceof c) {
                Object a4 = ((c) gVar).a(jSONObject);
                if (a4 == null) {
                    return null;
                }
                sb.append(a4);
            } else {
                continue;
            }
        }
        return sb.toString();
    }

    @Override // com.qq.e.dl.k.c, com.qq.e.dl.k.g
    public Object c(JSONObject... jSONObjectArr) {
        List<g> list = this.f47008a;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (g gVar : this.f47008a) {
            if (gVar instanceof j) {
                sb.append(gVar.c(jSONObjectArr));
            } else if (!(gVar instanceof c)) {
                continue;
            } else if (gVar.c(jSONObjectArr) == null) {
                return null;
            } else {
                sb.append(gVar.c(jSONObjectArr));
            }
        }
        return sb.toString();
    }

    @Override // com.qq.e.dl.k.c, com.qq.e.dl.k.g
    public String e(JSONObject... jSONObjectArr) {
        List<g> list = this.f47008a;
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (g gVar : this.f47008a) {
            if (gVar instanceof j) {
                sb.append(gVar.e(jSONObjectArr));
            } else if (gVar instanceof c) {
                String e4 = gVar.e(jSONObjectArr);
                if (e4 == null) {
                    return null;
                }
                sb.append(e4);
            } else {
                continue;
            }
        }
        return sb.toString();
    }
}
