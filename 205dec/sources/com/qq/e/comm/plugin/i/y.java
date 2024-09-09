package com.qq.e.comm.plugin.i;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import yaq.pro;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class y implements o {

    /* renamed from: a  reason: collision with root package name */
    private String f44212a;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class a implements Future<com.qq.e.comm.plugin.g0.g> {

        /* renamed from: c  reason: collision with root package name */
        private com.qq.e.comm.plugin.g0.g f44213c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ Future f44214d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ h f44215e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.i0.n.f f44216f;

        a(Future future, h hVar, com.qq.e.comm.plugin.i0.n.f fVar) {
            this.f44214d = future;
            this.f44215e = hVar;
            this.f44216f = fVar;
        }

        @Override // java.util.concurrent.Future
        /* renamed from: a */
        public com.qq.e.comm.plugin.g0.g get() {
            return get(this.f44215e.f44152y, TimeUnit.SECONDS);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z3) {
            return this.f44214d.cancel(z3);
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f44214d.isCancelled();
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f44214d.isDone();
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0039 A[Catch: all -> 0x009f, TRY_ENTER, TryCatch #4 {, blocks: (B:3:0x0001, B:19:0x0039, B:21:0x005a, B:23:0x005e, B:25:0x006e, B:27:0x0076, B:30:0x007d, B:36:0x009b, B:31:0x0081, B:35:0x0098, B:34:0x0094, B:20:0x0049), top: B:43:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:20:0x0049 A[Catch: all -> 0x009f, TryCatch #4 {, blocks: (B:3:0x0001, B:19:0x0039, B:21:0x005a, B:23:0x005e, B:25:0x006e, B:27:0x0076, B:30:0x007d, B:36:0x009b, B:31:0x0081, B:35:0x0098, B:34:0x0094, B:20:0x0049), top: B:43:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:23:0x005e A[Catch: all -> 0x009f, TryCatch #4 {, blocks: (B:3:0x0001, B:19:0x0039, B:21:0x005a, B:23:0x005e, B:25:0x006e, B:27:0x0076, B:30:0x007d, B:36:0x009b, B:31:0x0081, B:35:0x0098, B:34:0x0094, B:20:0x0049), top: B:43:0x0001 }] */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0093  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x0094 A[Catch: all -> 0x009f, TryCatch #4 {, blocks: (B:3:0x0001, B:19:0x0039, B:21:0x005a, B:23:0x005e, B:25:0x006e, B:27:0x0076, B:30:0x007d, B:36:0x009b, B:31:0x0081, B:35:0x0098, B:34:0x0094, B:20:0x0049), top: B:43:0x0001 }] */
        @Override // java.util.concurrent.Future
        /* renamed from: a */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public synchronized com.qq.e.comm.plugin.g0.g get(long r5, java.util.concurrent.TimeUnit r7) {
            /*
                r4 = this;
                monitor-enter(r4)
                com.qq.e.comm.plugin.g0.g r0 = r4.f44213c     // Catch: java.lang.Throwable -> L9f
                if (r0 == 0) goto L7
                monitor-exit(r4)
                return r0
            L7:
                r0 = 0
                long r1 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                java.util.concurrent.Future r3 = r4.f44214d     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                java.lang.Object r5 = r3.get(r5, r7)     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                com.qq.e.comm.plugin.i0.n.g r5 = (com.qq.e.comm.plugin.i0.n.g) r5     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                r6 = 2300009(0x231869, float:3.222999E-39)
                com.qq.e.comm.plugin.i.h r7 = r4.f44215e     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                com.qq.e.comm.plugin.i.j.a(r6, r1, r7)     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                if (r5 != 0) goto L1f
                goto L2b
            L1f:
                com.qq.e.comm.plugin.i.y r6 = com.qq.e.comm.plugin.i.y.this     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                com.qq.e.comm.plugin.i.h r7 = r4.f44215e     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                com.qq.e.comm.plugin.g0.g r5 = com.qq.e.comm.plugin.i.y.a(r6, r5, r7)     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                r4.f44213c = r5     // Catch: java.lang.Throwable -> L2b java.util.concurrent.ExecutionException -> L2e java.util.concurrent.TimeoutException -> L31 java.lang.InterruptedException -> L34
                r5 = 0
                goto L36
            L2b:
                r5 = -5006(0xffffffffffffec72, float:NaN)
                goto L36
            L2e:
                r5 = -5005(0xffffffffffffec73, float:NaN)
                goto L36
            L31:
                r5 = -5004(0xffffffffffffec74, float:NaN)
                goto L36
            L34:
                r5 = -5003(0xffffffffffffec75, float:NaN)
            L36:
                r6 = 1
                if (r5 == 0) goto L49
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L9f
                java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Throwable -> L9f
                r6[r0] = r7     // Catch: java.lang.Throwable -> L9f
                java.lang.String r7 = "#clickRes#"
                java.lang.String r0 = "resp == null,errorCode:%s"
                com.qq.e.comm.plugin.util.f2.a(r7, r0, r6)     // Catch: java.lang.Throwable -> L9f
                goto L5a
            L49:
                java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch: java.lang.Throwable -> L9f
                com.qq.e.comm.plugin.i.y r7 = com.qq.e.comm.plugin.i.y.this     // Catch: java.lang.Throwable -> L9f
                java.lang.String r7 = com.qq.e.comm.plugin.i.y.a(r7)     // Catch: java.lang.Throwable -> L9f
                r6[r0] = r7     // Catch: java.lang.Throwable -> L9f
                java.lang.String r7 = "#clickRes#"
                java.lang.String r0 = "resp:%s"
                com.qq.e.comm.plugin.util.f2.a(r7, r0, r6)     // Catch: java.lang.Throwable -> L9f
            L5a:
                com.qq.e.comm.plugin.g0.g r6 = r4.f44213c     // Catch: java.lang.Throwable -> L9f
                if (r6 != 0) goto L6c
                java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch: java.lang.Throwable -> L9f
                com.qq.e.comm.plugin.i.h r7 = r4.f44215e     // Catch: java.lang.Throwable -> L9f
                com.qq.e.comm.plugin.i.j.a(r6, r5, r7)     // Catch: java.lang.Throwable -> L9f
                com.qq.e.comm.plugin.g0.g r6 = new com.qq.e.comm.plugin.g0.g     // Catch: java.lang.Throwable -> L9f
                r6.<init>(r5)     // Catch: java.lang.Throwable -> L9f
                r4.f44213c = r6     // Catch: java.lang.Throwable -> L9f
            L6c:
                if (r5 != 0) goto L81
                com.qq.e.comm.plugin.g0.g r6 = r4.f44213c     // Catch: java.lang.Throwable -> L9f
                int r6 = r6.f43572a     // Catch: java.lang.Throwable -> L9f
                r7 = 200(0xc8, float:2.8E-43)
                if (r6 == r7) goto L7d
                boolean r6 = com.qq.e.comm.plugin.util.v0.a(r6)     // Catch: java.lang.Throwable -> L9f
                if (r6 != 0) goto L7d
                goto L81
            L7d:
                com.qq.e.comm.plugin.l0.h.b.i()     // Catch: java.lang.Throwable -> L9f
                goto L9b
            L81:
                com.qq.e.comm.plugin.i.h r6 = r4.f44215e     // Catch: java.lang.Throwable -> L9f
                com.qq.e.comm.plugin.g0.e r6 = r6.C     // Catch: java.lang.Throwable -> L9f
                com.qq.e.comm.plugin.i0.n.f r7 = r4.f44216f     // Catch: java.lang.Throwable -> L9f
                java.lang.String r7 = r7.getUrl()     // Catch: java.lang.Throwable -> L9f
                com.qq.e.comm.plugin.i0.n.f r0 = r4.f44216f     // Catch: java.lang.Throwable -> L9f
                java.util.Map r0 = r0.f()     // Catch: java.lang.Throwable -> L9f
                if (r5 == 0) goto L94
                goto L98
            L94:
                com.qq.e.comm.plugin.g0.g r5 = r4.f44213c     // Catch: java.lang.Throwable -> L9f
                int r5 = r5.f43572a     // Catch: java.lang.Throwable -> L9f
            L98:
                com.qq.e.comm.plugin.l0.h.b.a(r6, r7, r0, r5)     // Catch: java.lang.Throwable -> L9f
            L9b:
                com.qq.e.comm.plugin.g0.g r5 = r4.f44213c     // Catch: java.lang.Throwable -> L9f
                monitor-exit(r4)
                return r5
            L9f:
                r5 = move-exception
                monitor-exit(r4)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.qq.e.comm.plugin.i.y.a.get(long, java.util.concurrent.TimeUnit):com.qq.e.comm.plugin.g0.g");
        }
    }

    static /* synthetic */ com.qq.e.comm.plugin.g0.g a(y yVar, com.qq.e.comm.plugin.i0.n.g gVar, h hVar) {
        return (com.qq.e.comm.plugin.g0.g) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_OPEN_RESULT, 1, yVar, gVar, hVar);
    }

    private com.qq.e.comm.plugin.g0.g a(com.qq.e.comm.plugin.i0.n.g gVar, h hVar) {
        return (com.qq.e.comm.plugin.g0.g) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_INIT_MTU, 0, this, gVar, hVar);
    }

    static /* synthetic */ String a(y yVar) {
        return (String) pro.getobjresult(357, 1, yVar);
    }

    private String b(h hVar) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP, 0, this, hVar);
    }

    private String b(h hVar, String str) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_SPEEDX_DROP_FPS_LIMIT, 0, this, hVar, str);
    }

    private String c(h hVar, String str) {
        return (String) pro.getobjresult(360, 0, this, hVar, str);
    }

    private Future<com.qq.e.comm.plugin.g0.g> d(h hVar, String str) {
        return (Future) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODER_STALL, 0, this, hVar, str);
    }

    protected String a(h hVar, String str) {
        return (String) pro.getobjresult(MediaPlayer.MEDIA_PLAYER_OPTION_DEMUXER_STALL_THRESHOLD, 0, this, hVar, str);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_DECODER_STALL_THRESHOLD, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(MediaPlayer.MEDIA_PLAYER_OPTION_LAST_VIDEO_DEMUX_TIME, 0, this, hVar, bVar);
    }
}
