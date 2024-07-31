package com.mbridge.msdk.splash.p504c;

import android.graphics.Bitmap;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.p472db.CampaignDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoader;
import com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.mbridge.msdk.splash.p504c.WebViewRenderManager;
import com.mbridge.msdk.splash.view.MBSplashView;
import com.mbridge.msdk.splash.view.nativeview.SplashImageLoadListener;
import com.mbridge.msdk.videocommon.download.DownLoadManager;
import com.mbridge.msdk.videocommon.listener.VideoDownloadListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.mbridge.msdk.splash.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class ResManager {

    /* renamed from: b */
    private static String f31770b = "ResManager";

    /* renamed from: c */
    private static int f31771c = 1;

    /* renamed from: a */
    public static CampaignDao f31769a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));

    /* renamed from: d */
    private static ConcurrentHashMap<String, Boolean> f31772d = new ConcurrentHashMap<>();

    /* renamed from: c */
    private static String m21224c(String str) {
        try {
            File file = new File(str);
            if (file.exists()) {
                return "file:///" + file.getAbsolutePath();
            }
            return "";
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Exception e) {
                e.getMessage();
                return "";
            }
        }
    }

    /* renamed from: a */
    public static CampaignEx m21228a(MBSplashView mBSplashView, String str, String str2, String str3, boolean z, int i, boolean z2, boolean z3) {
        if (f31769a == null) {
            f31769a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
        }
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        long m23365ag = m23252b.m23365ag() * 1000;
        long m23408W = m23252b.m23408W() * 1000;
        if (f31769a == null) {
            f31769a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
        }
        f31769a.m22744b(m23408W, str2);
        List<CampaignEx> m22759a = f31769a.m22759a(str2, 0, 0, f31771c, !TextUtils.isEmpty(str3));
        if (m22759a == null || m22759a.size() <= 0) {
            return null;
        }
        CampaignEx campaignEx = m22759a.get(0);
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j = currentTimeMillis - m23365ag;
        if (!z2) {
            if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= currentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j)) {
                if (m21230a(mBSplashView, campaignEx, str, str2, z, i, z3)) {
                    String str4 = f31770b;
                    SameLogTool.m21733d(str4, "cache campain is picked:" + campaignEx.getAppName());
                    return m21235a(campaignEx);
                }
                return null;
            }
            SameLogTool.m21738a(f31770b, "========已经超了缓存时间");
            return null;
        } else if ((campaignEx.getPlct() > 0 && (campaignEx.getPlct() * 1000) + campaignEx.getTimestamp() >= currentTimeMillis) || (campaignEx.getPlct() <= 0 && campaignEx.getTimestamp() >= j)) {
            if (m21230a(mBSplashView, campaignEx, str, str2, z, i, z3)) {
                String str5 = f31770b;
                SameLogTool.m21733d(str5, "cache campain is picked:" + campaignEx.getAppName());
                return m21235a(campaignEx);
            }
            return null;
        } else if (m21230a(mBSplashView, campaignEx, str, str2, z, i, z3) && campaignEx.isSpareOffer(m23365ag, m23408W)) {
            return m21235a(campaignEx);
        } else {
            return null;
        }
    }

    /* renamed from: b */
    public static void m21225b(String str) {
        f31772d.remove(str);
    }

    /* renamed from: a */
    private static CampaignEx m21235a(CampaignEx campaignEx) {
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean m21230a(com.mbridge.msdk.splash.view.MBSplashView r13, com.mbridge.msdk.foundation.entity.CampaignEx r14, java.lang.String r15, java.lang.String r16, boolean r17, int r18, boolean r19) {
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
            com.mbridge.msdk.videocommon.download.b r0 = com.mbridge.msdk.videocommon.download.DownLoadManager.getInstance()
            r1 = 297(0x129, float:4.16E-43)
            boolean r2 = r14.isBidCampaign()
            boolean r0 = r0.m20680a(r1, r9, r2)
            if (r0 == 0) goto L2c
            goto L2e
        L2c:
            r0 = 0
            goto L2f
        L2e:
            r0 = 1
        L2f:
            if (r0 != 0) goto L35
            m21231a(r13, r14, r9)
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
            m21229a(r0, r1, r2, r3, r4, r5, r6)
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
            java.lang.String r1 = m21224c(r0)
            boolean r0 = android.text.TextUtils.isEmpty(r1)
            if (r0 != 0) goto La4
            if (r19 != 0) goto La3
            r0 = r13
            r2 = r14
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r18
            m21229a(r0, r1, r2, r3, r4, r5, r6)
        La3:
            r10 = r12
        La4:
            boolean r0 = r14.isDynamicView()
            if (r0 == 0) goto Lc7
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.lang.Boolean> r0 = com.mbridge.msdk.splash.p504c.ResManager.f31772d
            java.lang.String r1 = r14.getImageUrl()
            java.lang.Object r0 = r0.get(r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            if (r0 == 0) goto Lbd
            boolean r0 = r0.booleanValue()
            r10 = r0
        Lbd:
            if (r10 != 0) goto Lc4
            r0 = 0
            m21232a(r13, r14, r0)
            goto Lc7
        Lc4:
            r13.setImageReady(r11)
        Lc7:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.splash.p504c.ResManager.m21230a(com.mbridge.msdk.splash.view.MBSplashView, com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, java.lang.String, boolean, int, boolean):boolean");
    }

    /* renamed from: a */
    private static void m21231a(final MBSplashView mBSplashView, CampaignEx campaignEx, String str) {
        VideoDownloadListener videoDownloadListener = new VideoDownloadListener() { // from class: com.mbridge.msdk.splash.c.b.1
            @Override // com.mbridge.msdk.videocommon.listener.VideoDownloadListener
            /* renamed from: a */
            public final void mo20641a(String str2) {
                MBSplashView.this.setVideoReady(true);
                SameLogTool.m21738a(ResManager.f31770b, "========VIDEO SUC");
            }

            @Override // com.mbridge.msdk.videocommon.listener.VideoDownloadListener
            /* renamed from: a */
            public final void mo20640a(String str2, String str3) {
                MBSplashView.this.setVideoReady(false);
                SameLogTool.m21738a(ResManager.f31770b, "========VIDEO FAILED");
            }
        };
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        DownLoadManager.getInstance().createUnitCache(MBSDKContext.m22865f().m22861j(), str, arrayList, 297, videoDownloadListener);
        if (!DownLoadManager.getInstance().m20680a(297, str, campaignEx.isBidCampaign())) {
            DownLoadManager.getInstance().load(str);
        } else {
            mBSplashView.setVideoReady(true);
        }
    }

    /* renamed from: a */
    public static void m21232a(final MBSplashView mBSplashView, final CampaignEx campaignEx, final SplashImageLoadListener splashImageLoadListener) {
        CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22339a(campaignEx.getImageUrl(), new CommonImageLoaderListener() { // from class: com.mbridge.msdk.splash.c.b.2
            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onFailedLoad(String str, String str2) {
                ResManager.f31772d.put(CampaignEx.this.getImageUrl(), Boolean.FALSE);
                SplashImageLoadListener splashImageLoadListener2 = splashImageLoadListener;
                if (splashImageLoadListener2 != null) {
                    splashImageLoadListener2.mo20942b();
                }
                MBSplashView mBSplashView2 = mBSplashView;
                if (mBSplashView2 != null) {
                    mBSplashView2.setImageReady(false);
                }
            }

            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onSuccessLoad(Bitmap bitmap, String str) {
                ResManager.f31772d.put(CampaignEx.this.getImageUrl(), Boolean.TRUE);
                SplashImageLoadListener splashImageLoadListener2 = splashImageLoadListener;
                if (splashImageLoadListener2 != null) {
                    splashImageLoadListener2.mo20943a();
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
        CommonImageLoader.m22343a(MBSDKContext.m22865f().m22861j()).m22339a(campaignEx.getIconUrl(), new CommonImageLoaderListener() { // from class: com.mbridge.msdk.splash.c.b.3
            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onFailedLoad(String str, String str2) {
            }

            @Override // com.mbridge.msdk.foundation.same.p476c.CommonImageLoaderListener
            public final void onSuccessLoad(Bitmap bitmap, String str) {
            }
        });
    }

    /* renamed from: a */
    private static void m21229a(MBSplashView mBSplashView, String str, CampaignEx campaignEx, String str2, String str3, boolean z, int i) {
        WebViewRenderManager.C11597c c11597c = new WebViewRenderManager.C11597c();
        c11597c.m21124c(str3);
        c11597c.m21126b(str2);
        c11597c.m21130a(campaignEx);
        c11597c.m21129a(str);
        c11597c.m21128a(z);
        c11597c.m21131a(i);
        WebViewRenderManager.C11595a.m21136a().m21141a(mBSplashView, c11597c, null);
    }

    /* renamed from: a */
    public static boolean m21233a(MBSplashView mBSplashView, CampaignEx campaignEx) {
        if (mBSplashView == null) {
            SameLogTool.m21733d(f31770b, "mbSplashView  is null");
            return false;
        }
        boolean z = true;
        if (!TextUtils.isEmpty(campaignEx.getVideoUrlEncode())) {
            z = mBSplashView.isVideoReady();
            String str = f31770b;
            SameLogTool.m21733d(str, "======isReady isVideoReady:" + z);
        }
        if (z && !TextUtils.isEmpty(campaignEx.getAdZip())) {
            z = mBSplashView.isH5Ready();
            String str2 = f31770b;
            SameLogTool.m21733d(str2, "======isReady getAdZip:" + z);
        }
        if (z && TextUtils.isEmpty(campaignEx.getAdZip()) && !TextUtils.isEmpty(campaignEx.getAdHtml())) {
            z = mBSplashView.isH5Ready();
            String str3 = f31770b;
            SameLogTool.m21733d(str3, "======isReady getAdHtml:" + z);
        }
        if (TextUtils.isEmpty(campaignEx.getAdZip()) && TextUtils.isEmpty(campaignEx.getAdHtml())) {
            SameLogTool.m21733d(f31770b, "======isReady getAdHtml  getAdZip all are empty");
            z = false;
        }
        if (campaignEx.isDynamicView()) {
            boolean isImageReady = TextUtils.isEmpty(campaignEx.getImageUrl()) ? false : mBSplashView.isImageReady();
            String str4 = f31770b;
            SameLogTool.m21733d(str4, "======isReady DYNAMIC VIEW and image state is : " + isImageReady);
            return isImageReady;
        }
        return z;
    }

    /* renamed from: a */
    public static void m21234a(CampaignEx campaignEx, String str) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(campaignEx);
        if (f31769a == null) {
            f31769a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
        }
        f31769a.m22738b(arrayList, str);
    }

    /* renamed from: a */
    public static void m21227a(String str) {
        if (f31769a == null) {
            f31769a = CampaignDao.m22767a(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j()));
        }
        f31769a.m22762a(str, 0, f31771c);
    }
}
