package kotlinx.coroutines.flow;

import androidx.exifinterface.media.ExifInterface;
import com.mbridge.msdk.foundation.entity.DomainCampaignEx;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010#\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u001f\n\u0002\b\u0004\u001a9\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002H\u0086@ø\u0001\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a9\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\b\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007H\u0086@ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u001a=\u0010\r\u001a\u00028\u0001\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u000b*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00028\u0001H\u0086@ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000e\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u000f"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Lkotlinx/coroutines/flow/h;", "", RtspHeaders.Values.DESTINATION, "", "b", "(Lkotlinx/coroutines/flow/h;Ljava/util/List;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "", "d", "(Lkotlinx/coroutines/flow/h;Ljava/util/Set;Lkotlin/coroutines/c;)Ljava/lang/Object;", "", "C", "a", "(Lkotlinx/coroutines/flow/h;Ljava/util/Collection;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 5, m12614mv = {1, 4, 0}, m12611xs = "kotlinx/coroutines/flow/FlowKt")
/* renamed from: kotlinx.coroutines.flow.m */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final /* synthetic */ class Collection {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: Collect.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0013\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001b\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0006¸\u0006\u0000"}, m12616d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collect$3", "Lkotlinx/coroutines/flow/i;", DomainCampaignEx.LOOPBACK_VALUE, "Lkotlin/f1;", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/c;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.flow.m$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15013a<T> implements FlowCollector<T> {

        /* renamed from: a */
        final /* synthetic */ java.util.Collection f42884a;

        public C15013a(java.util.Collection collection) {
            this.f42884a = collection;
        }

        @Override // kotlinx.coroutines.flow.FlowCollector
        @Nullable
        public Object emit(Object obj, @NotNull InterfaceC14268c interfaceC14268c) {
            this.f42884a.add(obj);
            return Unit.f41048a;
        }
    }

    /* compiled from: Collection.kt */
    @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\b\u001a\u0004\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u0000\"\u0010\b\u0001\u0010\u0002*\n\u0012\u0006\b\u0000\u0012\u00028\u00000\u0001*\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\u0004\u001a\u00028\u00012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0086@"}, m12616d2 = {ExifInterface.GPS_DIRECTION_TRUE, "", "C", "Lkotlinx/coroutines/flow/h;", RtspHeaders.Values.DESTINATION, "Lkotlin/coroutines/c;", "continuation", "", "toCollection"}, m12615k = 3, m12614mv = {1, 4, 0})
    @DebugMetadata(m8639c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m8638f = "Collection.kt", m8637i = {0, 0, 0}, m8636l = {32}, m8635m = "toCollection", m8634n = {"$this$toCollection", RtspHeaders.Values.DESTINATION, "$this$collect$iv"}, m8633s = {"L$0", "L$1", "L$2"})
    /* renamed from: kotlinx.coroutines.flow.m$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15014b extends ContinuationImpl {

        /* renamed from: a */
        /* synthetic */ Object f42885a;

        /* renamed from: b */
        int f42886b;

        /* renamed from: c */
        Object f42887c;

        /* renamed from: d */
        Object f42888d;

        /* renamed from: e */
        Object f42889e;

        C15014b(InterfaceC14268c interfaceC14268c) {
            super(interfaceC14268c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.f42885a = obj;
            this.f42886b |= Integer.MIN_VALUE;
            return C15006k.m4642g2(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003e  */
    @org.jetbrains.annotations.Nullable
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final <T, C extends java.util.Collection<? super T>> java.lang.Object m4558a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.InterfaceC14958h<? extends T> r4, @org.jetbrains.annotations.NotNull C r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super C> r6) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.flow.Collection.C15014b
            if (r0 == 0) goto L13
            r0 = r6
            kotlinx.coroutines.flow.m$b r0 = (kotlinx.coroutines.flow.Collection.C15014b) r0
            int r1 = r0.f42886b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f42886b = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.m$b r0 = new kotlinx.coroutines.flow.m$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f42885a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
            int r2 = r0.f42886b
            r3 = 1
            if (r2 == 0) goto L3e
            if (r2 != r3) goto L36
            java.lang.Object r4 = r0.f42889e
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.InterfaceC14958h) r4
            java.lang.Object r4 = r0.f42888d
            r5 = r4
            java.util.Collection r5 = (java.util.Collection) r5
            java.lang.Object r4 = r0.f42887c
            kotlinx.coroutines.flow.h r4 = (kotlinx.coroutines.flow.InterfaceC14958h) r4
            kotlin.C14294d0.m8596n(r6)
            goto L55
        L36:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3e:
            kotlin.C14294d0.m8596n(r6)
            kotlinx.coroutines.flow.m$a r6 = new kotlinx.coroutines.flow.m$a
            r6.<init>(r5)
            r0.f42887c = r4
            r0.f42888d = r5
            r0.f42889e = r4
            r0.f42886b = r3
            java.lang.Object r4 = r4.mo4470e(r6, r0)
            if (r4 != r1) goto L55
            return r1
        L55:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.Collection.m4558a(kotlinx.coroutines.flow.h, java.util.Collection, kotlin.coroutines.c):java.lang.Object");
    }

    @Nullable
    /* renamed from: b */
    public static final <T> Object m4557b(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull List<T> list, @NotNull InterfaceC14268c<? super List<? extends T>> interfaceC14268c) {
        return C15006k.m4642g2(interfaceC14958h, list, interfaceC14268c);
    }

    /* renamed from: c */
    public static /* synthetic */ Object m4556c(InterfaceC14958h interfaceC14958h, List list, InterfaceC14268c interfaceC14268c, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return C15006k.m4638h2(interfaceC14958h, list, interfaceC14268c);
    }

    @Nullable
    /* renamed from: d */
    public static final <T> Object m4555d(@NotNull InterfaceC14958h<? extends T> interfaceC14958h, @NotNull Set<T> set, @NotNull InterfaceC14268c<? super Set<? extends T>> interfaceC14268c) {
        return C15006k.m4642g2(interfaceC14958h, set, interfaceC14268c);
    }

    /* renamed from: e */
    public static /* synthetic */ Object m4554e(InterfaceC14958h interfaceC14958h, Set set, InterfaceC14268c interfaceC14268c, int i, Object obj) {
        if ((i & 1) != 0) {
            set = new LinkedHashSet();
        }
        return C15006k.m4630j2(interfaceC14958h, set, interfaceC14268c);
    }
}
