package kotlin.reflect.jvm.internal.impl.util;

import kotlin.jvm.internal.f0;
import kotlin.jvm.internal.u;
import kotlin.reflect.jvm.internal.impl.descriptors.w;
import kotlin.reflect.jvm.internal.impl.util.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: modifierChecks.kt */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class l implements kotlin.reflect.jvm.internal.impl.util.b {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final String f58524a;

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends l {

        /* renamed from: b  reason: collision with root package name */
        private final int f58525b;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public a(int r3) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "must have at least "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r1 = " value parameter"
                r0.append(r1)
                r1 = 1
                if (r3 <= r1) goto L18
                java.lang.String r1 = "s"
                goto L1a
            L18:
                java.lang.String r1 = ""
            L1a:
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                r1 = 0
                r2.<init>(r0, r1)
                r2.f58525b = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlin.reflect.jvm.internal.impl.util.l.a.<init>(int):void");
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.b
        public boolean b(@NotNull w functionDescriptor) {
            f0.p(functionDescriptor, "functionDescriptor");
            return functionDescriptor.h().size() >= this.f58525b;
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends l {

        /* renamed from: b  reason: collision with root package name */
        private final int f58526b;

        public b(int i4) {
            super("must have exactly " + i4 + " value parameters", null);
            this.f58526b = i4;
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.b
        public boolean b(@NotNull w functionDescriptor) {
            f0.p(functionDescriptor, "functionDescriptor");
            return functionDescriptor.h().size() == this.f58526b;
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c extends l {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final c f58527b = new c();

        private c() {
            super("must have no value parameters", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.b
        public boolean b(@NotNull w functionDescriptor) {
            f0.p(functionDescriptor, "functionDescriptor");
            return functionDescriptor.h().isEmpty();
        }
    }

    /* compiled from: modifierChecks.kt */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d extends l {
        @NotNull

        /* renamed from: b  reason: collision with root package name */
        public static final d f58528b = new d();

        private d() {
            super("must have a single value parameter", null);
        }

        @Override // kotlin.reflect.jvm.internal.impl.util.b
        public boolean b(@NotNull w functionDescriptor) {
            f0.p(functionDescriptor, "functionDescriptor");
            return functionDescriptor.h().size() == 1;
        }
    }

    private l(String str) {
        this.f58524a = str;
    }

    public /* synthetic */ l(String str, u uVar) {
        this(str);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @Nullable
    public String a(@NotNull w wVar) {
        return b.a.a(this, wVar);
    }

    @Override // kotlin.reflect.jvm.internal.impl.util.b
    @NotNull
    public String getDescription() {
        return this.f58524a;
    }
}
