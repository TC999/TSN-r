package net.sourceforge.pinyin4j;

import java.io.BufferedInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: ResourceHelper.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class i {
    i() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BufferedInputStream a(String str) {
        return new BufferedInputStream(i.class.getResourceAsStream(str));
    }
}
