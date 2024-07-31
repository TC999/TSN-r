package net.sourceforge.pinyin4j;

import java.io.BufferedInputStream;

/* renamed from: net.sourceforge.pinyin4j.i */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
class ResourceHelper {
    ResourceHelper() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static BufferedInputStream m2823a(String str) {
        return new BufferedInputStream(ResourceHelper.class.getResourceAsStream(str));
    }
}
