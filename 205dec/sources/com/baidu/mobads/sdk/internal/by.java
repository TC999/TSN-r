package com.baidu.mobads.sdk.internal;

import com.baidu.mobads.sdk.internal.ck;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class by implements ck.a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ bx f12573a;

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public static final class a extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private static final long f12574a = 2978543166232984104L;

        public a(String str) {
            bs.a().c(str);
        }
    }

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    protected static final class b extends Exception {

        /* renamed from: a  reason: collision with root package name */
        private static final long f12575a = -7838296421993681751L;

        public b(String str) {
            bs.a().c(str);
        }
    }

    /* loaded from: E:\TSN-r\205dec\7241516.dex */
    public interface c {
        void a(boolean z3);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public by(bx bxVar) {
        this.f12573a = bxVar;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void a(bz bzVar) {
        this.f12573a.a("OK", bzVar, "download apk successfully, downloader exit");
        bx unused = bx.f12563h = null;
    }

    @Override // com.baidu.mobads.sdk.internal.ck.a
    public void b(bz bzVar) {
        this.f12573a.a("ERROR", bzVar, "downloadApk failed");
    }
}
