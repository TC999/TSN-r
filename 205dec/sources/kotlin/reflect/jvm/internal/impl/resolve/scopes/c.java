package kotlin.reflect.jvm.internal.impl.resolve.scopes;

import kotlin.reflect.jvm.internal.impl.resolve.scopes.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: MemberScope.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class c {

    /* compiled from: MemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends c {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final a f57887a = new a();

        /* renamed from: b  reason: collision with root package name */
        private static final int f57888b;

        static {
            d.a aVar = d.f57890c;
            f57888b = ((aVar.i() | aVar.d()) ^ (-1)) & aVar.b();
        }

        private a() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.c
        public int a() {
            return f57888b;
        }
    }

    /* compiled from: MemberScope.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends c {
        @NotNull

        /* renamed from: a  reason: collision with root package name */
        public static final b f57889a = new b();

        private b() {
        }

        @Override // kotlin.reflect.jvm.internal.impl.resolve.scopes.c
        public int a() {
            return 0;
        }
    }

    public abstract int a();

    public String toString() {
        return getClass().getSimpleName();
    }
}
