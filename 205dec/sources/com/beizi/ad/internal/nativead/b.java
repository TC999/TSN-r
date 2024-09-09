package com.beizi.ad.internal.nativead;

import android.content.Context;
import android.graphics.Bitmap;
import com.beizi.ad.NativeAdListener;
import com.beizi.ad.NativeAdResponse;
import com.beizi.ad.R;
import com.beizi.ad.internal.e;
import com.beizi.ad.internal.k;
import com.beizi.ad.internal.network.a;
import com.beizi.ad.internal.utilities.DeviceInfoUtil;
import com.beizi.ad.internal.utilities.HaoboLog;
import com.beizi.ad.internal.utilities.ImageService;
import com.beizi.ad.internal.utilities.StringUtil;
import com.beizi.ad.internal.utilities.UserEnvInfoUtil;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: NativeAdRequestImpl.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b extends com.beizi.ad.internal.network.a implements com.beizi.ad.internal.a {

    /* renamed from: a  reason: collision with root package name */
    public com.beizi.ad.internal.d f13932a;

    /* renamed from: c  reason: collision with root package name */
    private NativeAdListener f13933c;

    /* renamed from: d  reason: collision with root package name */
    private a f13934d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13935e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f13936f;

    /* renamed from: g  reason: collision with root package name */
    private e f13937g;

    /* renamed from: h  reason: collision with root package name */
    private String f13938h;

    /* renamed from: i  reason: collision with root package name */
    private String f13939i;

    /* renamed from: j  reason: collision with root package name */
    private String f13940j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f13941k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f13942l = false;

    public b(Context context, String str, int i4) {
        this.f13937g = null;
        DeviceInfoUtil.retrieveDeviceInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        UserEnvInfoUtil.retrieveUserEnvInfo(StubApp.getOrigApplicationContext(context.getApplicationContext()));
        e eVar = new e(context, StringUtil.createRequestId());
        this.f13937g = eVar;
        eVar.a(str);
        this.f13937g.a(i4);
        this.f13937g.a(k.NATIVE);
        com.beizi.ad.internal.d dVar = new com.beizi.ad.internal.d(this);
        this.f13932a = dVar;
        dVar.a(-1);
        this.f13934d = new a();
    }

    public String d() {
        return this.f13938h;
    }

    public String e() {
        return this.f13939i;
    }

    public NativeAdListener f() {
        return this.f13933c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public e g() {
        return this.f13937g;
    }

    @Override // com.beizi.ad.internal.a
    public k getMediaType() {
        return this.f13937g.i();
    }

    public com.beizi.ad.internal.c h() {
        return this.f13934d;
    }

    public String i() {
        return this.f13940j;
    }

    @Override // com.beizi.ad.internal.a
    public boolean isReadyToStart() {
        return this.f13933c != null && this.f13937g.j();
    }

    public boolean j() {
        return this.f13941k;
    }

    public boolean b() {
        e eVar = this.f13937g;
        if (eVar != null) {
            return eVar.l();
        }
        return true;
    }

    public String c() {
        HaoboLog.d(HaoboLog.nativeLogTag, HaoboLog.getString(R.string.get_placement_id, this.f13937g.c()));
        return this.f13937g.c();
    }

    public void d(boolean z3) {
        this.f13936f = z3;
    }

    public void e(boolean z3) {
        this.f13941k = z3;
    }

    public boolean a() {
        HaoboLog.d(HaoboLog.nativeLogTag, HaoboLog.getString(R.string.get_opens_native_browser, this.f13937g.h()));
        return this.f13937g.h();
    }

    public void d(String str) {
        this.f13940j = str;
    }

    public void b(boolean z3) {
        e eVar = this.f13937g;
        if (eVar != null) {
            eVar.c(z3);
        }
    }

    public void b(String str) {
        this.f13938h = str;
    }

    public void c(String str) {
        this.f13939i = str;
    }

    public void a(boolean z3) {
        HaoboLog.d(HaoboLog.nativeLogTag, HaoboLog.getString(R.string.set_opens_native_browser, z3));
        this.f13937g.b(z3);
    }

    public void c(boolean z3) {
        this.f13935e = z3;
    }

    public void a(String str) {
        HaoboLog.d(HaoboLog.nativeLogTag, HaoboLog.getString(R.string.set_placement_id, str));
        this.f13937g.a(str);
    }

    public void a(NativeAdListener nativeAdListener) {
        this.f13933c = nativeAdListener;
    }

    public boolean a(a.C0126a c0126a) {
        if (this.f13933c == null) {
            HaoboLog.e(HaoboLog.nativeLogTag, "No mNativeAdListener installed for this request, won't load a new ad");
            return false;
        } else if (this.f13942l) {
            HaoboLog.e(HaoboLog.nativeLogTag, "Still loading last nativead ad , won't load a new ad");
            return false;
        } else if (this.f13937g.j()) {
            this.f13932a.a();
            this.f13932a.c();
            this.f13932a.b();
            this.f13942l = true;
            return true;
        } else {
            return false;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: NativeAdRequestImpl.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    private class a implements com.beizi.ad.internal.c, ImageService.ImageServiceListener {

        /* renamed from: a  reason: collision with root package name */
        ImageService f13943a;

        /* renamed from: b  reason: collision with root package name */
        NativeAdResponse f13944b;

        private a() {
        }

        @Override // com.beizi.ad.internal.c
        public void a() {
        }

        @Override // com.beizi.ad.internal.c
        public void a(long j4) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(com.beizi.ad.internal.network.b bVar) {
            if (!bVar.a().equals(k.NATIVE)) {
                a(0);
                return;
            }
            final NativeAdResponse d4 = bVar.d();
            if (d4 == null) {
                return;
            }
            b.this.b(bVar.f());
            b.this.c(bVar.g());
            b.this.e(bVar.i());
            b.this.d(d4.getLandingPageUrl());
            if (!b.this.f13935e && !b.this.f13936f) {
                if (b.this.f13933c != null) {
                    b.this.f13933c.onAdLoaded(d4);
                } else {
                    d4.destroy();
                }
                b.this.f13942l = false;
                return;
            }
            this.f13943a = new ImageService();
            this.f13944b = d4;
            if (b.this.f13935e) {
                this.f13943a.registerImageReceiver(new ImageService.ImageReceiver() { // from class: com.beizi.ad.internal.nativead.b.a.1
                    @Override // com.beizi.ad.internal.utilities.ImageService.ImageReceiver
                    public void onFail() {
                        String str = HaoboLog.httpRespLogTag;
                        HaoboLog.e(str, "Image downloading logFailed for url " + d4.getImageUrl());
                    }

                    @Override // com.beizi.ad.internal.utilities.ImageService.ImageReceiver
                    public void onReceiveImage(Bitmap bitmap) {
                        d4.setImage(bitmap);
                    }
                }, d4.getImageUrl());
            }
            if (b.this.f13936f) {
                this.f13943a.registerImageReceiver(new ImageService.ImageReceiver() { // from class: com.beizi.ad.internal.nativead.b.a.2
                    @Override // com.beizi.ad.internal.utilities.ImageService.ImageReceiver
                    public void onFail() {
                        String str = HaoboLog.httpRespLogTag;
                        HaoboLog.e(str, "Image downloading logFailed for url " + d4.getIconUrl());
                    }

                    @Override // com.beizi.ad.internal.utilities.ImageService.ImageReceiver
                    public void onReceiveImage(Bitmap bitmap) {
                        d4.setIcon(bitmap);
                    }
                }, d4.getIconUrl());
            }
            this.f13943a.registerNotification(this);
            this.f13943a.execute();
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str, int i4) {
        }

        @Override // com.beizi.ad.internal.c
        public void a(String str, String str2) {
        }

        @Override // com.beizi.ad.internal.c
        public void b() {
        }

        @Override // com.beizi.ad.internal.c
        public void c() {
        }

        @Override // com.beizi.ad.internal.c
        public void d() {
        }

        @Override // com.beizi.ad.internal.c
        public void e() {
        }

        @Override // com.beizi.ad.internal.c
        public void f() {
        }

        @Override // com.beizi.ad.internal.utilities.ImageService.ImageServiceListener
        public void onAllImageDownloadsFinish() {
            if (b.this.f13933c != null) {
                b.this.f13933c.onAdLoaded(this.f13944b);
            } else {
                this.f13944b.destroy();
            }
            this.f13943a = null;
            this.f13944b = null;
            b.this.f13942l = false;
        }

        @Override // com.beizi.ad.internal.c
        public void a(int i4) {
            if (b.this.f13933c != null) {
                b.this.f13933c.onAdFailed(i4);
            }
            b.this.f13942l = false;
        }
    }
}
