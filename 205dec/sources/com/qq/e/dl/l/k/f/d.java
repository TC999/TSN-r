package com.qq.e.dl.l.k.f;

import com.qq.e.dl.k.g;
import com.qq.e.dl.k.n;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class d extends com.qq.e.dl.l.k.d<a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public d(com.qq.e.dl.a aVar) {
        super(aVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.qq.e.dl.l.k.d, com.qq.e.dl.l.h
    public boolean a(String str, g gVar) {
        if (super.a(str, gVar)) {
            return true;
        }
        char c4 = '\uffff';
        int hashCode = str.hashCode();
        if (hashCode != 1571) {
            if (hashCode == 1692 && str.equals("51")) {
                c4 = 0;
            }
        } else if (str.equals("14")) {
            c4 = 1;
        }
        if (c4 == 0) {
            ((a) this.f47070h).b(gVar.b(new JSONObject[0]));
            return true;
        } else if (c4 != 1) {
            return false;
        } else {
            ((a) this.f47070h).a(n.b(gVar));
            return true;
        }
    }
}
