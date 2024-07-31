package p640rx.internal.util;

import p640rx.functions.Func1;

/* renamed from: rx.internal.util.n */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class UtilityFunctions {

    /* compiled from: UtilityFunctions.java */
    /* renamed from: rx.internal.util.n$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    enum EnumC16063a implements Func1<Object, Boolean> {
        INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p640rx.functions.Func1
        public Boolean call(Object obj) {
            return Boolean.FALSE;
        }
    }

    /* compiled from: UtilityFunctions.java */
    /* renamed from: rx.internal.util.n$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    enum EnumC16064b implements Func1<Object, Boolean> {
        INSTANCE;

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // p640rx.functions.Func1
        public Boolean call(Object obj) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: UtilityFunctions.java */
    /* renamed from: rx.internal.util.n$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public enum EnumC16065c implements Func1<Object, Object> {
        INSTANCE;

        @Override // p640rx.functions.Func1
        public Object call(Object obj) {
            return obj;
        }
    }

    private UtilityFunctions() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> Func1<? super T, Boolean> m805a() {
        return EnumC16063a.INSTANCE;
    }

    /* renamed from: b */
    public static <T> Func1<? super T, Boolean> m804b() {
        return EnumC16064b.INSTANCE;
    }

    /* renamed from: c */
    public static <T> Func1<T, T> m803c() {
        return EnumC16065c.INSTANCE;
    }
}
