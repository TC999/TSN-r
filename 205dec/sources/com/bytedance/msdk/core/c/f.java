package com.bytedance.msdk.core.c;

import com.bykv.c.c.c.c.b;
import com.bykv.vk.openvk.api.proto.Bridge;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {
    public static com.bytedance.msdk.api.sr.c.xv.sr c(final Bridge bridge) {
        if (bridge != null) {
            return new com.bytedance.msdk.api.sr.c.xv.sr() { // from class: com.bytedance.msdk.core.c.f.1
                @Override // com.bytedance.msdk.api.sr.c.r.f
                public void reportVideoAutoStart() {
                    Bridge.this.call(8170, null, null);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.f
                public void reportVideoBreak(long j4) {
                    b a4 = b.a();
                    a4.f(8074, j4);
                    Bridge.this.call(8169, a4.l(), null);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.f
                public void reportVideoContinue(long j4) {
                    b a4 = b.a();
                    a4.f(8074, j4);
                    Bridge.this.call(8167, a4.l(), null);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.f
                public void reportVideoError(long j4, int i4, int i5) {
                    b a4 = b.a();
                    a4.f(8074, j4);
                    a4.e(8014, i4);
                    a4.e(8075, i5);
                    Bridge.this.call(8172, a4.l(), null);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.f
                public void reportVideoFinish() {
                    Bridge.this.call(8168, null, null);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.f
                public void reportVideoPause(long j4) {
                    b a4 = b.a();
                    a4.f(8074, j4);
                    Bridge.this.call(8166, a4.l(), null);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.f
                public void reportVideoStart() {
                    Bridge.this.call(8165, null, null);
                }

                @Override // com.bytedance.msdk.api.sr.c.r.f
                public void reportVideoStartError(int i4, int i5) {
                    b a4 = b.a();
                    a4.e(8014, i4);
                    a4.e(8075, i5);
                    Bridge.this.call(8171, a4.l(), null);
                }
            };
        }
        return null;
    }
}
