package kotlin.reflect.jvm.internal.impl.load.java.lazy;

import org.jetbrains.annotations.NotNull;

/* compiled from: context.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public interface d {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final a f56773a = a.f56774a;

    /* compiled from: context.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ a f56774a = new a();

        private a() {
        }
    }

    /* compiled from: context.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b implements d {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final b f56775b = new b();

        private b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.d
        public boolean a() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.d
        public boolean b() {
            return false;
        }

        @Override // kotlin.reflect.jvm.internal.impl.load.java.lazy.d
        public boolean c() {
            return false;
        }
    }

    boolean a();

    boolean b();

    boolean c();
}
