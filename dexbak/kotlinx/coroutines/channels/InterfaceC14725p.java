package kotlinx.coroutines.channels;

import androidx.exifinterface.media.ExifInterface;
import kotlin.Annotations;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.coroutines.InterfaceC14268c;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Channel.kt */
@Metadata(m12618bv = {}, m12617d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\bf\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002J\u0013\u0010\u0004\u001a\u00020\u0003H¦Bø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u0006\u001a\u00028\u0000H\u0097@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0005J\u0010\u0010\u0007\u001a\u00028\u0000H¦\u0002¢\u0006\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\t"}, m12616d2 = {"Lkotlinx/coroutines/channels/p;", ExifInterface.LONGITUDE_EAST, "", "", "b", "(Lkotlin/coroutines/c;)Ljava/lang/Object;", "a", "next", "()Ljava/lang/Object;", "kotlinx-coroutines-core"}, m12615k = 1, m12614mv = {1, 4, 0})
/* renamed from: kotlinx.coroutines.channels.p */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public interface InterfaceC14725p<E> {

    /* compiled from: Channel.kt */
    @Metadata(m12618bv = {1, 0, 3}, m12615k = 3, m12614mv = {1, 4, 0})
    /* renamed from: kotlinx.coroutines.channels.p$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static final class C14726a {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Channel.kt */
        @Metadata(m12618bv = {}, m12617d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0010\u0004\u001a\u0004\u0018\u00010\u0003\"\u0006\b\u0000\u0010\u0000 \u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H\u0097@"}, m12616d2 = {ExifInterface.LONGITUDE_EAST, "Lkotlin/coroutines/c;", "continuation", "", "next0"}, m12615k = 3, m12614mv = {1, 4, 0})
        @DebugMetadata(m8639c = "kotlinx.coroutines.channels.ChannelIterator$DefaultImpls", m8638f = "Channel.kt", m8637i = {0}, m8636l = {458}, m8635m = "next", m8634n = {"$this"}, m8633s = {"L$0"})
        /* renamed from: kotlinx.coroutines.channels.p$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public static final class C14727a extends ContinuationImpl {

            /* renamed from: a */
            /* synthetic */ Object f42133a;

            /* renamed from: b */
            int f42134b;

            /* renamed from: c */
            final /* synthetic */ InterfaceC14725p f42135c;

            /* renamed from: d */
            Object f42136d;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C14727a(InterfaceC14725p interfaceC14725p, InterfaceC14268c interfaceC14268c) {
                super(interfaceC14268c);
                this.f42135c = interfaceC14725p;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                this.f42133a = obj;
                this.f42134b |= Integer.MIN_VALUE;
                return C14726a.m5386a(null, this);
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0023  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x0035  */
        /* JADX WARN: Removed duplicated region for block: B:19:0x004b  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0050  */
        @kotlin.Annotations(level = kotlin.DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @kotlin.jvm.JvmName(name = "next")
        @org.jetbrains.annotations.Nullable
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static /* synthetic */ <E> java.lang.Object m5386a(@org.jetbrains.annotations.NotNull kotlinx.coroutines.channels.InterfaceC14725p<? extends E> r4, @org.jetbrains.annotations.NotNull kotlin.coroutines.InterfaceC14268c<? super E> r5) {
            /*
                boolean r0 = r5 instanceof kotlinx.coroutines.channels.InterfaceC14725p.C14726a.C14727a
                if (r0 == 0) goto L13
                r0 = r5
                kotlinx.coroutines.channels.p$a$a r0 = (kotlinx.coroutines.channels.InterfaceC14725p.C14726a.C14727a) r0
                int r1 = r0.f42134b
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f42134b = r1
                goto L18
            L13:
                kotlinx.coroutines.channels.p$a$a r0 = new kotlinx.coroutines.channels.p$a$a
                r0.<init>(r4, r5)
            L18:
                java.lang.Object r5 = r0.f42133a
                java.lang.Object r1 = kotlin.coroutines.intrinsics.C14286a.m8643h()
                int r2 = r0.f42134b
                r3 = 1
                if (r2 == 0) goto L35
                if (r2 != r3) goto L2d
                java.lang.Object r4 = r0.f42136d
                kotlinx.coroutines.channels.p r4 = (kotlinx.coroutines.channels.InterfaceC14725p) r4
                kotlin.C14294d0.m8596n(r5)
                goto L43
            L2d:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r5)
                throw r4
            L35:
                kotlin.C14294d0.m8596n(r5)
                r0.f42136d = r4
                r0.f42134b = r3
                java.lang.Object r5 = r4.mo5387b(r0)
                if (r5 != r1) goto L43
                return r1
            L43:
                java.lang.Boolean r5 = (java.lang.Boolean) r5
                boolean r5 = r5.booleanValue()
                if (r5 == 0) goto L50
                java.lang.Object r4 = r4.next()
                return r4
            L50:
                kotlinx.coroutines.channels.ClosedReceiveChannelException r4 = new kotlinx.coroutines.channels.ClosedReceiveChannelException
                java.lang.String r5 = "Channel was closed"
                r4.<init>(r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.channels.InterfaceC14725p.C14726a.m5386a(kotlinx.coroutines.channels.p, kotlin.coroutines.c):java.lang.Object");
        }
    }

    @Annotations(level = DeprecationLevel.HIDDEN, message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
    @JvmName(name = "next")
    @Nullable
    /* renamed from: a */
    /* synthetic */ Object mo5388a(@NotNull InterfaceC14268c<? super E> interfaceC14268c);

    @Nullable
    /* renamed from: b */
    Object mo5387b(@NotNull InterfaceC14268c<? super Boolean> interfaceC14268c);

    E next();
}
