package com.mbridge.msdk.splash.c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.i;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.splash.c.e;
import com.mbridge.msdk.splash.view.MBSplashView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: ResManager.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {

    /* renamed from: b  reason: collision with root package name */
    private static String f40542b = "ResManager";

    /* renamed from: c  reason: collision with root package name */
    private static int f40543c = 1;

    /* renamed from: a  reason: collision with root package name */
    public static f f40541a = f.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));

    /* renamed from: d  reason: collision with root package name */
    private static ConcurrentHashMap<String, Boolean> f40544d = new ConcurrentHashMap<>();

    private static String c(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return "file:///" + file.getAbsolutePath();
            }
            return "";
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Exception e4) {
                e4.getMessage();
                return "";
            }
        }
    }

    public static CampaignEx a(MBSplashView mBSplashView, String str, String str2, String str3, boolean z3, int i4, boolean z4, boolean z5) {
        if (f40541a == null) {
            f40541a = f.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
        }
        com.mbridge.msdk.c.a b4 = com.mbridge.msdk.c.b.a().b(com.mbridge.msdk.foundation.controller.a.f().k());
        if (b4 == null) {
            b4 = com.mbridge.msdk.c.b.a().b();
        }
        long ag = b4.ag() * 1000;
        long W = b4.W() * 1000;
        if (f40541a == null) {
            f40541a = f.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
        }
        f40541a.b(W, str2);
        List<CampaignEx> a4 = f40541a.a(str2, 0, 0, f40543c, !TextUtils.isEmpty(str3));
        if (a4 == null || a4.size() <= 0) {
            return null;
        }
        CampaignEx campaignEx = a4.get(0);
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j4 = currentTimeMillis - ag;
        if (!z4) {
            if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= currentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j4)) {
                if (a(mBSplashView, campaignEx, str, str2, z3, i4, z5)) {
                    String str4 = f40542b;
                    x.d(str4, "cache campain is picked:" + campaignEx.getAppName());
                    return a(campaignEx);
                }
                return null;
            }
            x.a(f40542b, "========\u5df2\u7ecf\u8d85\u4e86\u7f13\u5b58\u65f6\u95f4");
            return null;
        } else if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= currentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j4)) {
            if (a(mBSplashView, campaignEx, str, str2, z3, i4, z5)) {
                String str5 = f40542b;
                x.d(str5, "cache campain is picked:" + campaignEx.getAppName());
                return a(campaignEx);
            }
            return null;
        } else if (a(mBSplashView, campaignEx, str, str2, z3, i4, z5) && campaignEx.isSpareOffer(ag, W)) {
            return a(campaignEx);
        } else {
            return null;
        }
    }

    public static void b(String str) {
        f40544d.remove(str);
    }

    private static CampaignEx a(CampaignEx campaignEx) {
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && (TextUtils.isEmpty(campaignEx.getAdHtml()) || !campaignEx.getAdHtml().contains("<MBTPLMARK>"))) {
            campaignEx.setHasMBTplMark(false);
            campaignEx.setIsMraid(true);
        } else {
            campaignEx.setHasMBTplMark(true);
            campaignEx.setIsMraid(false);
        }
        return campaignEx;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00aa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean a(com.mbridge.msdk.splash.view.MBSplashView r13, com.mbridge.msdk.foundation.entity.CampaignEx r14, java.lang.String r15, java.lang.String r16, boolean r17, int r18, boolean r19) {
        /*
            r7 = r13
            r8 = r14
            r9 = r16
            r10 = 0
            if (r8 == 0) goto Lc7
            r13.clearResState()
            java.lang.String r0 = r14.getVideoUrlEncode()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r11 = 1
            if (r0 != 0) goto L3a
            boolean r0 = r13.isVideoReady()
            if (r0 != 0) goto L2e
            com.mbridge.msdk.videocommon.download.b r0 = com.mbridge.msdk.videocommon.download.b.getInstance()
            r1 = 297(0x129, float:4.16E-43)
            boolean r2 = r14.isBidCampaign()
            boolean r0 = r0.a(r1, r9, r2)
            if (r0 == 0) goto L2c
            goto L2e
        L2c:
            r0 = 0
            goto L2f
        L2e:
            r0 = 1
        L2f:
            if (r0 != 0) goto L35
            a(r13, r14, r9)
            goto L38
        L35:
            r13.setVideoReady(r11)
        L38:
            r12 = r0
            goto L3b
        L3a:
            r12 = 1
        L3b:
            java.lang.String r0 = r14.getAdZip()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L6d
            boolean r0 = r13.isH5Ready()
            if (r0 != 0) goto L6d
            com.mbridge.msdk.foundation.download.download.H5DownLoadManager r0 = com.mbridge.msdk.foundation.download.download.H5DownLoadManager.getInstance()
            java.lang.String r1 = r14.getAdZip()
            java.lang.String r1 = r0.getH5ResAddress(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto L6c
            if (r19 != 0) goto L6d
            r0 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            a(r0, r1, r2, r3, r4, r5, r6)
            goto L6d
        L6c:
            r12 = 0
        L6d:
            java.lang.String r0 = r14.getAdZip()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto La3
            java.lang.String r0 = r14.getAdHtml()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto La3
            boolean r0 = r13.isH5Ready()
            if (r0 != 0) goto La3
            java.lang.String r0 = r14.getAdHtml()
            java.lang.String r1 = c(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto La4
            if (r19 != 0) goto La3
            r0 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            a(r0, r1, r2, r3, r4, r5, r6)
        La3:
            r10 = r12
        La4:
            boolean r0 = r14.isDynamicView()
            if (r0 == 0) goto Lc7
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r0 = com.mbridge.msdk.splash.c.b.f40544d
            java.lang.String r1 = r14.getImageUrl()
            java.lang.Object r0 = r0.get(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto Lbd
            boolean r0 = r0.booleanValue()
            r10 = r0
        Lbd:
            if (r10 != 0) goto Lc4
            r0 = 0
            a(r13, r14, r0)
            goto Lc7
        Lc4:
            r13.setImageReady(r11)
        Lc7:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.c.b.a(com.mbridge.msdk.splash.view.MBSplashView, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, java.lang.String, boolean, int, boolean):boolean");
    }

    private static void a(final MBSplashView mBSplashView, CampaignEx campaignEx, String str) {
        com.mbridge.msdk.videocommon.listener.a aVar = new com.mbridge.msdk.videocommon.listener.a() { // from class: com.mbridge.msdk.splash.c.b.1
            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str2) {
                MBSplashView.this.setVideoReady(true);
                x.a(b.f40542b, "========VIDEO SUC");
            }

            @Override // com.mbridge.msdk.videocommon.listener.a
            public final void a(String str2, String str3) {
                MBSplashView.this.setVideoReady(false);
                x.a(b.f40542b, "========VIDEO FAILED");
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        com.mbridge.msdk.videocommon.download.b.getInstance().createUnitCache(com.mbridge.msdk.foundation.controller.a.f().j(), str, arrayList, MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, aVar);
        if (!com.mbridge.msdk.videocommon.download.b.getInstance().a(MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, str, campaignEx.isBidCampaign())) {
            com.mbridge.msdk.videocommon.download.b.getInstance().load(str);
        } else {
            mBSplashView.setVideoReady(true);
        }
    }

    public static void a(final MBSplashView mBSplashView, final CampaignEx campaignEx, final com.mbridge.msdk.splash.view.nativeview.a aVar) {
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.f().j()).a(campaignEx.getImageUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.c.b.2
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
                b.f40544d.put(CampaignEx.this.getImageUrl(), Boolean.FALSE);
                com.mbridge.msdk.splash.view.nativeview.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.b();
                }
                MBSplashView mBSplashView2 = mBSplashView;
                if (mBSplashView2 != null) {
                    mBSplashView2.setImageReady(false);
                }
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                b.f40544d.put(CampaignEx.this.getImageUrl(), Boolean.TRUE);
                com.mbridge.msdk.splash.view.nativeview.a aVar2 = aVar;
                if (aVar2 != null) {
                    aVar2.a();
                }
                MBSplashView mBSplashView2 = mBSplashView;
                if (mBSplashView2 != null) {
                    mBSplashView2.setImageReady(true);
                }
            }
        });
        if (TextUtils.isEmpty(campaignEx.getIconUrl())) {
            return;
        }
        com.mbridge.msdk.foundation.same.c.b.a(com.mbridge.msdk.foundation.controller.a.f().j()).a(campaignEx.getIconUrl(), new com.mbridge.msdk.foundation.same.c.c() { // from class: com.mbridge.msdk.splash.c.b.3
            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onFailedLoad(String str, String str2) {
            }

            @Override // com.mbridge.msdk.foundation.same.c.c
            public final void onSuccessLoad(Bitmap bitmap, String str) {
            }
        });
    }

    private static void a(MBSplashView mBSplashView, String str, CampaignEx campaignEx, String str2, String str3, boolean z3, int i4) {
        e.c cVar = new e.c();
        cVar.c(str3);
        cVar.b(str2);
        cVar.a(campaignEx);
        cVar.a(str);
        cVar.a(z3);
        cVar.a(i4);
        e.a.a().a(mBSplashView, cVar, null);
    }

    public static boolean a(MBSplashView mBSplashView, CampaignEx campaignEx) {
        if (mBSplashView == null) {
            x.d(f40542b, "mbSplashView  is null");
            return false;
        }
        boolean z3 = true;
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            z3 = mBSplashView.isVideoReady();
            String str = f40542b;
            x.d(str, "======isReady isVideoReady:" + z3);
        }
        if (z3 && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            z3 = mBSplashView.isH5Ready();
            String str2 = f40542b;
            x.d(str2, "======isReady getAdZip:" + z3);
        }
        if (z3 && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            z3 = mBSplashView.isH5Ready();
            String str3 = f40542b;
            x.d(str3, "======isReady getAdHtml:" + z3);
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            x.d(f40542b, "======isReady getAdHtml  getAdZip all are empty");
            z3 = false;
        }
        if (campaignEx.isDynamicView()) {
            boolean isImageReady = TextUtils.isEmpty(campaignEx.getImageUrl()) ? false : mBSplashView.isImageReady();
            String str4 = f40542b;
            x.d(str4, "======isReady DYNAMIC VIEW and image state is : " + isImageReady);
            return isImageReady;
        }
        return z3;
    }

    public static void a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (f40541a == null) {
            f40541a = f.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
        }
        f40541a.b(arrayList, str);
    }

    public static void a(String str) {
        if (f40541a == null) {
            f40541a = f.a(i.a(com.mbridge.msdk.foundation.controller.a.f().j()));
        }
        f40541a.a(str, 0, f40543c);
    }
}
