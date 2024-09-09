package com.bxkj.base.v2.netty4android.client.handler;

import kotlin.Metadata;
import kotlin.jvm.internal.f0;
import org.jetbrains.annotations.NotNull;

/* compiled from: CheckNum.kt */
@Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\bf\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002\u00a8\u0006\u0003"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/handler/a;", "", "a", "base_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\TSN-r\205dec\4499832.dex */
public interface a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    public static final C0207a f18767a = C0207a.f18768a;

    /* compiled from: CheckNum.kt */
    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002\u00a8\u0006\b"}, d2 = {"Lcom/bxkj/base/v2/netty4android/client/handler/a$a;", "", "", "bytes", "", "a", "<init>", "()V", "base_release"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.bxkj.base.v2.netty4android.client.handler.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\4499832.dex */
    public static final class C0207a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ C0207a f18768a = new C0207a();

        private C0207a() {
        }

        public final int a(@NotNull byte[] bytes) {
            f0.p(bytes, "bytes");
            int length = bytes.length - 1;
            int i4 = 0;
            if (length >= 0) {
                int i5 = 0;
                while (true) {
                    int i6 = i4 + 1;
                    i5 += bytes[i4];
                    if (i6 > length) {
                        break;
                    }
                    i4 = i6;
                }
                i4 = i5;
            }
            if (i4 > 255) {
                i4 = (i4 ^ (-1)) + 1;
            }
            return 255 & i4;
        }
    }
}
