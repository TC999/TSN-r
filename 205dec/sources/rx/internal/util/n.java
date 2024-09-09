package rx.internal.util;

import rx.functions.p;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: UtilityFunctions.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class n {

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: UtilityFunctions.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    enum a implements p<Object, Boolean> {
        INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.p
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: UtilityFunctions.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    enum b implements p<Object, Boolean> {
        INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // rx.functions.p
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: UtilityFunctions.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    enum c implements p<Object, Object> {
        INSTANCE;

        @Override // rx.functions.p
        public Object call(Object obj) {
            return obj;
        }
    }

    private n() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> p<? super T, Boolean> a() {
        return a.INSTANCE;
    }

    public static <T> p<? super T, Boolean> b() {
        return b.INSTANCE;
    }

    public static <T> p<T, T> c() {
        return c.INSTANCE;
    }
}
