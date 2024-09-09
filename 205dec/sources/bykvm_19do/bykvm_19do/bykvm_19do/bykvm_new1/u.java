package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import java.util.List;

/* compiled from: TTCollectionUtils.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class u {
    public static <T> boolean a(List<T> list) {
        return list == null || list.size() == 0;
    }

    public static <T> boolean b(List<T> list) {
        return list == null || list.size() == 0 || list.get(0) == null;
    }
}
