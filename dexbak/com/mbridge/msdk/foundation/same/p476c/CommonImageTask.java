package com.mbridge.msdk.foundation.same.p476c;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.same.net.C11356k;
import com.mbridge.msdk.foundation.same.net.Listener;
import com.mbridge.msdk.foundation.same.net.p480a.CommonError;
import com.mbridge.msdk.foundation.same.net.p486g.CommonAsyncHttpRequest;
import com.mbridge.msdk.foundation.same.p478e.CommonTask;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import java.io.File;

/* renamed from: com.mbridge.msdk.foundation.same.c.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonImageTask extends CommonTask {

    /* renamed from: a */
    private String f30655a;

    /* renamed from: b */
    private String f30656b;

    /* renamed from: c */
    private String f30657c;

    /* renamed from: d */
    private boolean f30658d = false;

    /* renamed from: e */
    private InterfaceC11323a f30659e;

    /* compiled from: CommonImageTask.java */
    /* renamed from: com.mbridge.msdk.foundation.same.c.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC11323a {
        /* renamed from: a */
        void mo22322a(String str, String str2);

        /* renamed from: b */
        void mo22321b(String str, String str2);
    }

    public CommonImageTask(String str, String str2, String str3) {
        this.f30655a = str;
        this.f30656b = str2;
        this.f30657c = str3;
    }

    @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
    public final void cancelTask() {
    }

    @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
    public final void pauseTask(boolean z) {
    }

    @Override // com.mbridge.msdk.foundation.same.p478e.CommonTask
    public final void runTask() {
        if (!this.f30658d) {
            if (TextUtils.isEmpty(this.f30657c)) {
                m22326a(this.f30656b, "save path is null.");
                return;
            }
            File file = new File(this.f30657c);
            if (file.exists() && file.length() > 0) {
                m22330a();
                return;
            } else {
                m22324b();
                return;
            }
        }
        m22324b();
    }

    /* renamed from: b */
    private void m22324b() {
        try {
            final File file = new File(this.f30657c);
            if (!file.exists()) {
                file.mkdirs();
            }
            if (file.exists()) {
                file.delete();
            }
            CommonAsyncHttpRequest.m22230a(file, this.f30656b, new Listener<Void>() { // from class: com.mbridge.msdk.foundation.same.c.d.1
                @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
                /* renamed from: a */
                public final void mo22265a(long j, long j2) {
                }

                @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
                /* renamed from: a */
                public final void mo21051a(C11356k c11356k) {
                    SameLogTool.m21738a("ImageWorker", "download file from [" + CommonImageTask.this.f30656b + "] save to [" + CommonImageTask.this.f30657c + "]");
                    String unused = CommonImageTask.this.f30657c;
                    CommonImageTask.this.m22330a();
                }

                @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
                /* renamed from: b */
                public final void mo22264b() {
                    SameLogTool.m21736b("ImageWorker", String.format("onFinish size : %s", Long.valueOf(file.length())));
                }

                @Override // com.mbridge.msdk.foundation.same.net.Listener, com.mbridge.msdk.foundation.same.net.IListener
                /* renamed from: a */
                public final void mo21052a(CommonError commonError) {
                    CommonImageTask commonImageTask = CommonImageTask.this;
                    String str = commonImageTask.f30656b;
                    commonImageTask.m22326a(str, "load image from http faild because http return code: " + commonError.f30690a + ".image url is " + CommonImageTask.this.f30656b);
                }
            });
        } catch (Exception e) {
            m22326a(this.f30656b, e.getMessage());
            if (MBridgeConstans.DEBUG) {
                e.printStackTrace();
            }
        } catch (OutOfMemoryError e2) {
            m22326a(this.f30656b, e2.getMessage());
        }
    }

    /* renamed from: a */
    public final void m22325a(boolean z) {
        this.f30658d = z;
    }

    /* renamed from: a */
    public final void m22329a(InterfaceC11323a interfaceC11323a) {
        this.f30659e = interfaceC11323a;
    }

    /* renamed from: a */
    protected final void m22330a() {
        if (new File(this.f30657c).exists()) {
            String str = this.f30656b;
            String str2 = this.f30657c;
            InterfaceC11323a interfaceC11323a = this.f30659e;
            if (interfaceC11323a != null) {
                interfaceC11323a.mo22322a(str, str2);
                return;
            }
            return;
        }
        String str3 = "load image faild.because file[" + this.f30657c + "] is not exist!";
        SameLogTool.m21738a("ImageWorker", str3);
        m22326a(this.f30656b, str3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m22326a(String str, String str2) {
        InterfaceC11323a interfaceC11323a = this.f30659e;
        if (interfaceC11323a != null) {
            interfaceC11323a.mo22321b(str, str2);
        }
    }
}
