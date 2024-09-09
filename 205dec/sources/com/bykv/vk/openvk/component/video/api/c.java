package com.bykv.vk.openvk.component.video.api;

import android.graphics.SurfaceTexture;
import android.view.SurfaceHolder;
import com.bykv.vk.openvk.component.video.api.xv.sr;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public interface c {

    /* renamed from: com.bykv.vk.openvk.component.video.api.c$c  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface InterfaceC0334c {
        void c(c cVar);

        void c(c cVar, int i4);

        void c(c cVar, int i4, int i5);

        void c(c cVar, int i4, int i5, int i6);

        void c(c cVar, long j4);

        void c(c cVar, long j4, long j5);

        void c(c cVar, com.bykv.vk.openvk.component.video.api.xv.w wVar);

        void c(c cVar, JSONObject jSONObject, String str);

        void c(c cVar, boolean z3);

        void sr(c cVar);

        void ux(c cVar);

        void w(c cVar);

        void w(c cVar, int i4);

        void xv(c cVar);
    }

    int a();

    boolean bk();

    void c();

    void c(float f4);

    void c(int i4);

    void c(long j4);

    void c(SurfaceTexture surfaceTexture);

    void c(SurfaceHolder surfaceHolder);

    void c(InterfaceC0334c interfaceC0334c);

    void c(sr srVar);

    void c(boolean z3);

    void c(boolean z3, long j4, boolean z4);

    SurfaceTexture ev();

    boolean f();

    long fp();

    long fz();

    boolean gd();

    int ia();

    int k();

    boolean p();

    SurfaceHolder r();

    long s();

    void sr();

    boolean t();

    void ux();

    void w();

    void w(int i4);

    void w(boolean z3);

    void xv();

    boolean ys();
}
