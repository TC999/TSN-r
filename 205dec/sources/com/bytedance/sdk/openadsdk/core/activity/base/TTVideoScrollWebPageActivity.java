package com.bytedance.sdk.openadsdk.core.activity.base;

import android.os.Bundle;
import android.view.View;
import com.bykv.vk.openvk.component.video.api.sr.xv;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.res.ux;
import com.bytedance.sdk.openadsdk.widget.TTScrollView;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTVideoScrollWebPageActivity extends TTVideoWebPageActivity {
    private TTScrollView sr;

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass1 implements TTScrollView.c {
        AnonymousClass1() {
        }

        @Override // com.bytedance.sdk.openadsdk.widget.TTScrollView.c
        public void c(boolean z3) {
            try {
                xv xvVar = TTVideoScrollWebPageActivity.this.xv;
                if (xvVar != null && (xvVar instanceof com.bytedance.sdk.openadsdk.core.video.nativevideo.xv)) {
                    if (z3 && !xvVar.u()) {
                        ((com.bytedance.sdk.openadsdk.core.video.nativevideo.xv) TTVideoScrollWebPageActivity.this.xv).f(false);
                    } else {
                        TTVideoScrollWebPageActivity.this.xv.f();
                    }
                }
            } catch (Throwable th) {
                a.xv("TTVideoScrollWebPageActivity", "onCreate isShow error", th);
            }
        }
    }

    /* renamed from: com.bytedance.sdk.openadsdk.core.activity.base.TTVideoScrollWebPageActivity$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass2 implements xv.InterfaceC0335xv {
        AnonymousClass2() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
        public void C_() {
            if (TTVideoScrollWebPageActivity.this.sr == null || TTVideoScrollWebPageActivity.this.sr.c()) {
                return;
            }
            a.w("TTVideoScrollWebPageActivity", "video start play but video is hidden so pause");
            xv xvVar = TTVideoScrollWebPageActivity.this.xv;
            if (xvVar != null) {
                xvVar.r();
            }
        }

        @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
        public void D_() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
        public void E_() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
        public void F_() {
        }

        @Override // com.bykv.vk.openvk.component.video.api.sr.xv.InterfaceC0335xv
        public void c(long j4, long j5) {
        }
    }

    static {
        StubApp.interface11(17859);
    }

    @Override // com.bytedance.sdk.openadsdk.core.activity.base.TTVideoWebPageActivity, android.app.Activity
    public native void onCreate(Bundle bundle);

    @Override // android.app.Activity
    public void setContentView(View view) {
        super.setContentView(ux.x(this));
    }
}
