package com.mbridge.msdk.click;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.widget.Toast;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.mbridge.msdk.DomainMBridgeConstans;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.CommonJumpLoader;
import com.mbridge.msdk.click.p460a.RetryReportControl;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.ClickTime;
import com.mbridge.msdk.foundation.p472db.CampaignClickDao;
import com.mbridge.msdk.foundation.p472db.CampaignReportDao;
import com.mbridge.msdk.foundation.p472db.CommonSDKDBHelper;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.same.report.MBBatchReportManager;
import com.mbridge.msdk.foundation.same.report.ReportController;
import com.mbridge.msdk.foundation.tools.C11400ae;
import com.mbridge.msdk.foundation.tools.DomainSameFileTool;
import com.mbridge.msdk.foundation.tools.DomainSameSDKTool;
import com.mbridge.msdk.foundation.tools.MIMManager;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.SameSDKTool;
import com.mbridge.msdk.foundation.tools.SameTool;
import com.mbridge.msdk.foundation.tools.StringUtils;
import com.mbridge.msdk.foundation.tools.TargetAdaptionUtils;
import com.mbridge.msdk.mbdownload.manager.ADownloadManager;
import com.mbridge.msdk.optimize.SimpleDownload;
import com.mbridge.msdk.optimize.SimpleDownloadCallback;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.IDownloadListener;
import com.mbridge.msdk.out.LoadingActivity;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.p457c.Setting;
import com.mbridge.msdk.p457c.SettingManager;
import com.stub.StubApp;
import com.tencent.p562mm.opensdk.modelbase.BaseReq;
import com.tencent.p562mm.opensdk.modelbiz.WXLaunchMiniProgram;
import com.tencent.p562mm.opensdk.openapi.IWXAPI;
import com.umeng.commonsdk.framework.UMModuleRegister;
import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: com.mbridge.msdk.click.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class CommonClickControl {

    /* renamed from: a */
    public static boolean f30011a;

    /* renamed from: b */
    public static Set<String> f30012b = new HashSet();

    /* renamed from: c */
    public static Set<String> f30013c = new HashSet();

    /* renamed from: d */
    public static Map<String, Long> f30014d = new HashMap();

    /* renamed from: e */
    public static Map<String, Long> f30015e = new HashMap();

    /* renamed from: f */
    static Handler f30016f = new Handler(Looper.getMainLooper()) { // from class: com.mbridge.msdk.click.b.9
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i != 0) {
                if (i != 1) {
                    return;
                }
                CommonClickControl.m23091d();
                return;
            }
            Object obj = message.obj;
            if (obj == null || !(obj instanceof Context)) {
                return;
            }
            CommonClickControl.m23130a((Context) obj);
        }
    };

    /* renamed from: g */
    private String f30017g;

    /* renamed from: h */
    private long f30018h;

    /* renamed from: i */
    private long f30019i;

    /* renamed from: j */
    private boolean f30020j;

    /* renamed from: k */
    private boolean f30021k;

    /* renamed from: l */
    private boolean f30022l;

    /* renamed from: o */
    private Setting f30025o;

    /* renamed from: p */
    private CommonSDKDBHelper f30026p;

    /* renamed from: q */
    private Context f30027q;

    /* renamed from: r */
    private CommonJumpLoader f30028r;

    /* renamed from: s */
    private HashMap<String, CommonJumpLoader> f30029s;

    /* renamed from: u */
    private ReportController f30031u;

    /* renamed from: m */
    private boolean f30023m = false;

    /* renamed from: n */
    private boolean f30024n = true;

    /* renamed from: t */
    private NativeListener.NativeTrackingListener f30030t = null;

    /* renamed from: v */
    private Handler f30032v = new Handler() { // from class: com.mbridge.msdk.click.b.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 0) {
                if (CommonClickControl.this.f30030t != null) {
                    CommonClickControl.this.f30030t.onDownloadStart(null);
                }
            } else if (i != 1) {
                if (i == 2 && CommonClickControl.this.f30030t != null) {
                    CommonClickControl.this.f30030t.onDownloadFinish((Campaign) message.obj);
                }
            } else if (CommonClickControl.this.f30030t != null) {
                CommonClickControl.this.f30030t.onDownloadProgress(message.arg1);
            }
        }
    };

    public CommonClickControl(Context context, String str) {
        this.f30026p = null;
        this.f30027q = null;
        Setting m23252b = SettingManager.m23261a().m23252b(str);
        this.f30025o = m23252b;
        if (m23252b == null) {
            this.f30025o = SettingManager.m23261a().m23253b();
        }
        this.f30021k = this.f30025o.m23368ad();
        Context origApplicationContext = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f30027q = origApplicationContext;
        this.f30017g = str;
        if (this.f30026p == null) {
            this.f30026p = CommonSDKDBHelper.m22721a(origApplicationContext);
        }
        this.f30031u = new ReportController(this.f30027q);
        this.f30029s = new HashMap<>();
    }

    /* renamed from: g */
    static /* synthetic */ void m23084g(CommonClickControl commonClickControl) {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            commonClickControl.f30027q.sendBroadcast(intent);
        } catch (Exception e) {
            SameLogTool.m21735b("MBridge SDK M", "Exception", e);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0007, code lost:
        if (2 != r8.getLinkType()) goto L29;
     */
    /* renamed from: d */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m23089d(com.mbridge.msdk.foundation.entity.CampaignEx r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L9
            r0 = 2
            int r1 = r8.getLinkType()     // Catch: java.lang.Exception -> L79
            if (r0 == r1) goto L10
        L9:
            r0 = 3
            int r1 = r8.getLinkType()     // Catch: java.lang.Exception -> L79
            if (r0 != r1) goto L81
        L10:
            java.lang.String r0 = r8.getId()     // Catch: java.lang.Exception -> L79
            java.util.Map<java.lang.String, java.lang.Long> r1 = com.mbridge.msdk.click.CommonClickControl.f30014d     // Catch: java.lang.Exception -> L79
            if (r1 == 0) goto L81
            boolean r1 = r1.containsKey(r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r2 = "MBridge SDK M"
            if (r1 == 0) goto L60
            java.util.Map<java.lang.String, java.lang.Long> r1 = com.mbridge.msdk.click.CommonClickControl.f30014d     // Catch: java.lang.Exception -> L79
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Exception -> L79
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.Exception -> L79
            if (r0 == 0) goto L60
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L79
            long r5 = r0.longValue()     // Catch: java.lang.Exception -> L79
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 > 0) goto L42
            java.util.Set<java.lang.String> r1 = com.mbridge.msdk.click.CommonClickControl.f30012b     // Catch: java.lang.Exception -> L79
            java.lang.String r5 = r8.getId()     // Catch: java.lang.Exception -> L79
            boolean r1 = r1.contains(r5)     // Catch: java.lang.Exception -> L79
            if (r1 == 0) goto L60
        L42:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L79
            r8.<init>()     // Catch: java.lang.Exception -> L79
            java.lang.String r1 = "点击时间未超过coit "
            r8.append(r1)     // Catch: java.lang.Exception -> L79
            r8.append(r3)     // Catch: java.lang.Exception -> L79
            java.lang.String r1 = "|"
            r8.append(r1)     // Catch: java.lang.Exception -> L79
            r8.append(r0)     // Catch: java.lang.Exception -> L79
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L79
            com.mbridge.msdk.foundation.tools.SameLogTool.m21736b(r2, r8)     // Catch: java.lang.Exception -> L79
            r8 = 0
            return r8
        L60:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L79
            r0.<init>()     // Catch: java.lang.Exception -> L79
            java.lang.String r1 = "未发现有点击或点击超时保存点击时间 interval = "
            r0.append(r1)     // Catch: java.lang.Exception -> L79
            int r8 = r8.getClickTimeOutInterval()     // Catch: java.lang.Exception -> L79
            r0.append(r8)     // Catch: java.lang.Exception -> L79
            java.lang.String r8 = r0.toString()     // Catch: java.lang.Exception -> L79
            com.mbridge.msdk.foundation.tools.SameLogTool.m21736b(r2, r8)     // Catch: java.lang.Exception -> L79
            goto L81
        L79:
            r8 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L81
            r8.printStackTrace()
        L81:
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.CommonClickControl.m23089d(com.mbridge.msdk.foundation.entity.CampaignEx):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0007, code lost:
        if (2 != r8.getLinkType()) goto L29;
     */
    /* renamed from: e */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m23087e(com.mbridge.msdk.foundation.entity.CampaignEx r8) {
        /*
            r7 = this;
            if (r8 == 0) goto L9
            r0 = 2
            int r1 = r8.getLinkType()     // Catch: java.lang.Exception -> L92
            if (r0 == r1) goto L10
        L9:
            r0 = 3
            int r1 = r8.getLinkType()     // Catch: java.lang.Exception -> L92
            if (r0 != r1) goto L9a
        L10:
            java.lang.String r0 = r8.getId()     // Catch: java.lang.Exception -> L92
            java.util.Map<java.lang.String, java.lang.Long> r1 = com.mbridge.msdk.click.CommonClickControl.f30014d     // Catch: java.lang.Exception -> L92
            if (r1 == 0) goto L9a
            boolean r1 = r1.containsKey(r0)     // Catch: java.lang.Exception -> L92
            java.lang.String r2 = "MBridge SDK M"
            if (r1 == 0) goto L60
            java.util.Map<java.lang.String, java.lang.Long> r1 = com.mbridge.msdk.click.CommonClickControl.f30014d     // Catch: java.lang.Exception -> L92
            java.lang.Object r0 = r1.get(r0)     // Catch: java.lang.Exception -> L92
            java.lang.Long r0 = (java.lang.Long) r0     // Catch: java.lang.Exception -> L92
            if (r0 == 0) goto L60
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L92
            long r5 = r0.longValue()     // Catch: java.lang.Exception -> L92
            int r1 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r1 > 0) goto L42
            java.util.Set<java.lang.String> r1 = com.mbridge.msdk.click.CommonClickControl.f30012b     // Catch: java.lang.Exception -> L92
            java.lang.String r5 = r8.getId()     // Catch: java.lang.Exception -> L92
            boolean r1 = r1.contains(r5)     // Catch: java.lang.Exception -> L92
            if (r1 == 0) goto L60
        L42:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92
            r8.<init>()     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = "点击时间未超过coit "
            r8.append(r1)     // Catch: java.lang.Exception -> L92
            r8.append(r3)     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = "|"
            r8.append(r1)     // Catch: java.lang.Exception -> L92
            r8.append(r0)     // Catch: java.lang.Exception -> L92
            java.lang.String r8 = r8.toString()     // Catch: java.lang.Exception -> L92
            com.mbridge.msdk.foundation.tools.SameLogTool.m21736b(r2, r8)     // Catch: java.lang.Exception -> L92
            r8 = 0
            return r8
        L60:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L92
            r0.<init>()     // Catch: java.lang.Exception -> L92
            java.lang.String r1 = "未发现有点击或点击超时保存点击时间 interval = "
            r0.append(r1)     // Catch: java.lang.Exception -> L92
            int r1 = r8.getClickTimeOutInterval()     // Catch: java.lang.Exception -> L92
            r0.append(r1)     // Catch: java.lang.Exception -> L92
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L92
            com.mbridge.msdk.foundation.tools.SameLogTool.m21736b(r2, r0)     // Catch: java.lang.Exception -> L92
            int r0 = r8.getClickTimeOutInterval()     // Catch: java.lang.Exception -> L92
            int r0 = r0 * 1000
            java.util.Map<java.lang.String, java.lang.Long> r1 = com.mbridge.msdk.click.CommonClickControl.f30014d     // Catch: java.lang.Exception -> L92
            java.lang.String r8 = r8.getId()     // Catch: java.lang.Exception -> L92
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L92
            long r4 = (long) r0     // Catch: java.lang.Exception -> L92
            long r2 = r2 + r4
            java.lang.Long r0 = java.lang.Long.valueOf(r2)     // Catch: java.lang.Exception -> L92
            r1.put(r8, r0)     // Catch: java.lang.Exception -> L92
            goto L9a
        L92:
            r8 = move-exception
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L9a
            r8.printStackTrace()
        L9a:
            r8 = 1
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.CommonClickControl.m23087e(com.mbridge.msdk.foundation.entity.CampaignEx):boolean");
    }

    /* renamed from: f */
    private void m23085f(CampaignEx campaignEx) {
        if (m23096c() == 2) {
            SameSDKTool.m22033a(this.f30027q, campaignEx.getClickURL(), campaignEx, this.f30030t);
        } else {
            SameSDKTool.m22029b(this.f30027q, campaignEx.getClickURL(), this.f30030t);
        }
    }

    /* renamed from: c */
    public final void m23094c(CampaignEx campaignEx) {
        try {
            this.f30020j = false;
            if (m23087e(campaignEx)) {
                String noticeUrl = campaignEx.getNoticeUrl();
                CampaignClickDao m22799a = CampaignClickDao.m22799a(this.f30026p);
                m22799a.m22800a();
                CommonJumpLoader.JumpLoaderResult m22795b = m22799a.m22795b(campaignEx.getId(), this.f30017g);
                if (m22795b != null) {
                    if (m22795b.getNoticeurl() != null) {
                        m22795b.setNoticeurl(null);
                    }
                    campaignEx.setJumpResult(m22795b);
                    m22799a.m22798a(campaignEx, this.f30017g, false, -1, campaignEx.getTtc_type());
                }
                if (SameTool.m22016a(campaignEx)) {
                    MIMManager.m21838a().m21836a(campaignEx);
                    if (CommonClickUtil.m23064e(this.f30027q, campaignEx.getDeepLinkURL())) {
                        NativeListener.NativeTrackingListener nativeTrackingListener = this.f30030t;
                        if (nativeTrackingListener != null) {
                            nativeTrackingListener.onStartRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        if (this.f30027q != null) {
                            Intent intent = new Intent();
                            intent.setAction("mb_dp_close_broadcast_receiver");
                            try {
                                this.f30027q.sendBroadcast(intent);
                            } catch (Exception unused) {
                            }
                        }
                        m23108a(campaignEx, noticeUrl + "&opdptype=1", -1);
                        CommonClickUtil.m23067b(campaignEx);
                        NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f30030t;
                        if (nativeTrackingListener2 != null) {
                            nativeTrackingListener2.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                            return;
                        }
                        return;
                    }
                    noticeUrl = noticeUrl + "&opdptype=0";
                    MIMManager.m21838a().m21829b(campaignEx);
                }
                if (campaignEx.getLinkType() == 12) {
                    NativeListener.NativeTrackingListener nativeTrackingListener3 = this.f30030t;
                    if (nativeTrackingListener3 != null) {
                        nativeTrackingListener3.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    m23108a(campaignEx, noticeUrl, -1);
                    m23129a(this.f30027q, campaignEx);
                    NativeListener.NativeTrackingListener nativeTrackingListener4 = this.f30030t;
                    if (nativeTrackingListener4 != null) {
                        nativeTrackingListener4.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                    }
                } else if (!campaignEx.getUserActivation() && CommonClickUtil.m23065d(this.f30027q, campaignEx.getPackageName())) {
                    CommonClickUtil.m23063f(this.f30027q, campaignEx.getPackageName());
                    SameLogTool.m21738a("MBridge SDK M", campaignEx.getPackageName() + " is intalled.");
                    m23108a(campaignEx, noticeUrl, CommonConst.f30569J);
                    NativeListener.NativeTrackingListener nativeTrackingListener5 = this.f30030t;
                    if (nativeTrackingListener5 != null) {
                        nativeTrackingListener5.onStartRedirection(campaignEx, campaignEx.getClickURL());
                    }
                    m23106a(campaignEx, false, false, false, campaignEx.getTtc_type(), true, Boolean.TRUE);
                    NativeListener.NativeTrackingListener nativeTrackingListener6 = this.f30030t;
                    if (nativeTrackingListener6 != null) {
                        nativeTrackingListener6.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        SameSDKTool.m22031a(this.f30030t);
                    }
                } else {
                    int linkType = campaignEx.getLinkType();
                    int m23096c = m23096c();
                    if (linkType != 3) {
                        m23108a(campaignEx, noticeUrl, -1);
                    }
                    SameLogTool.m21736b("MBridge SDK M", "======302跳转前linkType:" + linkType + " openType:" + m23096c + "======landingType：" + campaignEx.getLandingType());
                    if (linkType == 8 || linkType == 9 || linkType == 4) {
                        String clickURL = campaignEx.getClickURL();
                        NativeListener.NativeTrackingListener nativeTrackingListener7 = this.f30030t;
                        if (nativeTrackingListener7 != null) {
                            nativeTrackingListener7.onStartRedirection(campaignEx, clickURL);
                        }
                        if (TextUtils.isEmpty(clickURL)) {
                            SameLogTool.m21736b("MBridge SDK M", "linketype=" + linkType + " clickurl 为空");
                            NativeListener.NativeTrackingListener nativeTrackingListener8 = this.f30030t;
                            if (nativeTrackingListener8 != null) {
                                nativeTrackingListener8.onRedirectionFailed(campaignEx, clickURL);
                            }
                            m23124a(m22795b, campaignEx, true, false);
                        } else if (linkType == 8) {
                            SameLogTool.m21736b("MBridge SDK M", "linketype=8 用webview 打开");
                            SameSDKTool.m22033a(this.f30027q, clickURL, campaignEx, this.f30030t);
                            m23124a(m22795b, campaignEx, false, false);
                            NativeListener.NativeTrackingListener nativeTrackingListener9 = this.f30030t;
                            if (nativeTrackingListener9 != null) {
                                nativeTrackingListener9.onFinishRedirection(campaignEx, clickURL);
                            }
                        } else if (linkType == 9) {
                            SameLogTool.m21736b("MBridge SDK M", "linketype=9 用浏览器 打开");
                            SameSDKTool.m22029b(this.f30027q, clickURL, this.f30030t);
                            m23124a(m22795b, campaignEx, false, false);
                            NativeListener.NativeTrackingListener nativeTrackingListener10 = this.f30030t;
                            if (nativeTrackingListener10 != null) {
                                nativeTrackingListener10.onFinishRedirection(campaignEx, clickURL);
                            }
                        } else {
                            if (linkType == 4) {
                                if (m23096c == 2) {
                                    SameLogTool.m21736b("MBridge SDK M", "linketype=4 opent=2 用webview 打开");
                                    SameSDKTool.m22033a(this.f30027q, clickURL, campaignEx, this.f30030t);
                                } else {
                                    SameLogTool.m21736b("MBridge SDK M", "linketype=4 opent=不为2 用Browser 打开");
                                    SameSDKTool.m22029b(this.f30027q, clickURL, this.f30030t);
                                }
                            }
                            NativeListener.NativeTrackingListener nativeTrackingListener11 = this.f30030t;
                            if (nativeTrackingListener11 != null) {
                                nativeTrackingListener11.onFinishRedirection(campaignEx, clickURL);
                            }
                            m23124a(m22795b, campaignEx, false, false);
                        }
                    } else if (linkType == 2) {
                        SameLogTool.m21736b("MBridge SDK M", "linktype为2 开始做302跳转" + campaignEx.getClickURL());
                        if (!campaignEx.getClickURL().startsWith("market://") && !campaignEx.getClickURL().startsWith("https://play.google.com/")) {
                            m23106a(campaignEx, false, true, false, campaignEx.getTtc_type(), false, Boolean.TRUE);
                            return;
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener12 = this.f30030t;
                        if (nativeTrackingListener12 != null) {
                            nativeTrackingListener12.onStartRedirection(campaignEx, campaignEx.getClickURL());
                        }
                        if (!SameSDKTool.C11399a.m22027a(this.f30027q, campaignEx.getClickURL(), this.f30030t)) {
                            m23131a(m23096c, campaignEx.getClickURL(), campaignEx, this.f30030t);
                        }
                        m23124a(m22795b, campaignEx, false, false);
                        SameLogTool.m21736b("MBridge SDK M", "不用做302跳转 最终地址已经是gp了：" + campaignEx.getClickURL());
                        NativeListener.NativeTrackingListener nativeTrackingListener13 = this.f30030t;
                        if (nativeTrackingListener13 != null) {
                            nativeTrackingListener13.onFinishRedirection(campaignEx, campaignEx.getClickURL());
                        }
                    } else if (linkType == 3) {
                        SameLogTool.m21736b("MBridge SDK M", "linktype为3 开始做302跳转" + campaignEx.getClickURL());
                        m23106a(campaignEx, false, true, false, campaignEx.getTtc_type(), false, Boolean.TRUE);
                    } else {
                        String clickURL2 = campaignEx.getClickURL();
                        if (TextUtils.isEmpty(clickURL2)) {
                            SameLogTool.m21736b("MBridge SDK M", "linketype=" + linkType + " clickurl 为空");
                            NativeListener.NativeTrackingListener nativeTrackingListener14 = this.f30030t;
                            if (nativeTrackingListener14 != null) {
                                nativeTrackingListener14.onRedirectionFailed(campaignEx, clickURL2);
                            }
                            m23124a(m22795b, campaignEx, true, false);
                            return;
                        }
                        NativeListener.NativeTrackingListener nativeTrackingListener15 = this.f30030t;
                        if (nativeTrackingListener15 != null) {
                            nativeTrackingListener15.onFinishRedirection(campaignEx, clickURL2);
                        }
                        SameLogTool.m21736b("MBridge SDK M", "linketyp不是23489的值 用浏览器 打开");
                        SameSDKTool.m22029b(this.f30027q, clickURL2, this.f30030t);
                        m23124a(m22795b, campaignEx, false, false);
                    }
                }
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("MBridge SDK M", th.getMessage(), th);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x005f  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m23099b(com.mbridge.msdk.foundation.entity.CampaignEx r10) {
        /*
            r9 = this;
            boolean r0 = r9.m23089d(r10)
            r1 = 1
            if (r0 != 0) goto L8
            return r1
        L8:
            boolean r0 = com.mbridge.msdk.foundation.tools.SameTool.m22016a(r10)
            if (r0 == 0) goto L8e
            java.lang.String r0 = r10.getNoticeUrl()
            com.mbridge.msdk.foundation.tools.o r2 = com.mbridge.msdk.foundation.tools.MIMManager.m21838a()
            r2.m21836a(r10)
            android.content.Context r2 = r9.f30027q
            java.lang.String r3 = r10.getDeepLinkURL()
            boolean r2 = com.mbridge.msdk.click.CommonClickUtil.m23064e(r2, r3)
            if (r2 == 0) goto L87
            r2 = 2
            int r3 = r10.getLinkType()     // Catch: java.lang.Exception -> L34
            if (r2 == r3) goto L36
            r2 = 3
            int r3 = r10.getLinkType()     // Catch: java.lang.Exception -> L34
            if (r2 != r3) goto L5b
            goto L36
        L34:
            r2 = move-exception
            goto L54
        L36:
            java.lang.String r2 = r10.getId()     // Catch: java.lang.Exception -> L34
            java.util.Map<java.lang.String, java.lang.Long> r3 = com.mbridge.msdk.click.CommonClickControl.f30014d     // Catch: java.lang.Exception -> L34
            if (r3 == 0) goto L5b
            int r3 = r10.getClickTimeOutInterval()     // Catch: java.lang.Exception -> L34
            int r3 = r3 * 1000
            java.util.Map<java.lang.String, java.lang.Long> r4 = com.mbridge.msdk.click.CommonClickControl.f30014d     // Catch: java.lang.Exception -> L34
            long r5 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Exception -> L34
            long r7 = (long) r3     // Catch: java.lang.Exception -> L34
            long r5 = r5 + r7
            java.lang.Long r3 = java.lang.Long.valueOf(r5)     // Catch: java.lang.Exception -> L34
            r4.put(r2, r3)     // Catch: java.lang.Exception -> L34
            goto L5b
        L54:
            boolean r3 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r3 == 0) goto L5b
            r2.printStackTrace()
        L5b:
            android.content.Context r2 = r9.f30027q
            if (r2 == 0) goto L6e
            android.content.Intent r2 = new android.content.Intent
            r2.<init>()
            java.lang.String r3 = "mb_dp_close_broadcast_receiver"
            r2.setAction(r3)
            android.content.Context r3 = r9.f30027q     // Catch: java.lang.Exception -> L6e
            r3.sendBroadcast(r2)     // Catch: java.lang.Exception -> L6e
        L6e:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = "&opdptype=1"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r2 = -1
            r9.m23108a(r10, r0, r2)
            com.mbridge.msdk.click.CommonClickUtil.m23067b(r10)
            return r1
        L87:
            com.mbridge.msdk.foundation.tools.o r0 = com.mbridge.msdk.foundation.tools.MIMManager.m21838a()
            r0.m21829b(r10)
        L8e:
            r10 = 0
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.CommonClickControl.m23099b(com.mbridge.msdk.foundation.entity.CampaignEx):boolean");
    }

    /* renamed from: a */
    public final void m23103a(String str) {
        this.f30017g = str;
    }

    /* renamed from: a */
    public final void m23104a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.f30030t = nativeTrackingListener;
    }

    /* renamed from: a */
    public final void m23102a(boolean z) {
        this.f30024n = z;
    }

    /* renamed from: a */
    public final void m23133a() {
        Set<Map.Entry<String, CommonJumpLoader>> entrySet;
        CommonJumpLoader value;
        try {
            HashMap<String, CommonJumpLoader> hashMap = this.f30029s;
            if (hashMap != null && (entrySet = hashMap.entrySet()) != null && entrySet.size() > 0) {
                for (Map.Entry<String, CommonJumpLoader> entry : entrySet) {
                    if (entry != null && (value = entry.getValue()) != null) {
                        value.mo23030a();
                    }
                }
            }
            this.f30030t = null;
        } catch (Exception unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static void m23091d() {
        try {
            String language = Locale.getDefault().getLanguage();
            if (!TextUtils.isEmpty(language) && language.equals("zh")) {
                Toast.makeText(MBSDKContext.m22865f().m22861j(), "正在下载中,请稍候...", 0).show();
            } else {
                Toast.makeText(MBSDKContext.m22865f().m22861j(), "Downloading....", 0).show();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public final void m23109a(CampaignEx campaignEx, NativeListener.NativeAdListener nativeAdListener) {
        if (nativeAdListener != null && campaignEx != null) {
            nativeAdListener.onAdClick(campaignEx);
        }
        SameLogTool.m21736b("MBridge SDK M", "clickStart");
        m23094c(campaignEx);
    }

    /* renamed from: a */
    public final void m23114a(CampaignEx campaignEx) {
        try {
            if (m23087e(campaignEx)) {
                CampaignClickDao m22799a = CampaignClickDao.m22799a(this.f30026p);
                m22799a.m22800a();
                CommonJumpLoader.JumpLoaderResult m22795b = m22799a.m22795b(campaignEx.getId(), this.f30017g);
                if (m22795b != null) {
                    if (m22795b.getNoticeurl() != null) {
                        m22795b.setNoticeurl(null);
                    }
                    campaignEx.setJumpResult(m22795b);
                    m22799a.m22798a(campaignEx, this.f30017g, false, -1, campaignEx.getTtc_type());
                }
                if (CommonClickUtil.m23065d(this.f30027q, campaignEx.getPackageName())) {
                    SameLogTool.m21738a("MBridge SDK M", campaignEx.getPackageName() + " is intalled.");
                    return;
                }
                m23106a(campaignEx, false, false, false, campaignEx.getTtc_type(), false, Boolean.FALSE);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("MBridge SDK M", th.getMessage(), th);
        }
    }

    /* renamed from: b */
    public static void m23098b(CampaignEx campaignEx, Context context, String str) {
        try {
            if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_START) || str.equals("downloading")) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    m23130a(context);
                } else {
                    Message obtainMessage = f30016f.obtainMessage(0);
                    obtainMessage.obj = context;
                    f30016f.sendMessage(obtainMessage);
                }
            }
            m23093c(campaignEx, context, str);
        } catch (Throwable th) {
            SameLogTool.m21735b("MBridge SDK M", th.getMessage(), th);
        }
    }

    /* renamed from: b */
    private void m23097b(final CampaignEx campaignEx, final String str, final boolean z) {
        String md5;
        Context m22861j;
        boolean m21955a;
        boolean m21953c;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getAkdlui())) {
            md5 = campaignEx.getAkdlui();
        } else {
            md5 = SameMD5.getMD5(str);
        }
        final String str2 = md5;
        try {
            DomainSameSDKTool.m21876a(str, 1, campaignEx);
            m22861j = MBSDKContext.m22865f().m22861j();
            m21955a = TargetAdaptionUtils.m21955a(m22861j);
            m21953c = TargetAdaptionUtils.m21953c(m22861j);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (!TargetAdaptionUtils.m21954b(m22861j)) {
                m23108a(campaignEx, campaignEx.getNoticeUrl(), CommonConst.f30567H);
                CommonClickUtil.m23075a(m22861j, str, str2);
            } else if (!m21953c) {
                m23092c(campaignEx, str, z);
            } else if (!m21955a) {
                m23092c(campaignEx, str, z);
            } else {
                Context m22861j2 = MBSDKContext.m22865f().m22861j();
                C11400ae.m21963a(m22861j2, str2 + "isDowning", Long.valueOf(System.currentTimeMillis()));
                Context m22861j3 = MBSDKContext.m22865f().m22861j();
                C11400ae.m21963a(m22861j3, str2 + UMModuleRegister.PROCESS, Integer.valueOf(Process.myPid()));
                String str3 = (String) ADownloadManager.class.getMethod("initAPKDownloadTask", CampaignEx.class, String.class, IDownloadListener.class).invoke(ADownloadManager.class.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), campaignEx, str, new IDownloadListener() { // from class: com.mbridge.msdk.click.b.10
                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onEnd(int i, int i2, String str4) {
                        SameLogTool.m21736b("MBridge SDK M", "download listener onEnd result = " + i + " nid = " + i2 + " file = " + str4 + "-sdkclick:" + z);
                        Context m22861j4 = MBSDKContext.m22865f().m22861j();
                        StringBuilder sb = new StringBuilder();
                        sb.append(str2);
                        sb.append("isDowning");
                        C11400ae.m21963a(m22861j4, sb.toString(), 0L);
                        Context m22861j5 = MBSDKContext.m22865f().m22861j();
                        C11400ae.m21963a(m22861j5, str2 + UMModuleRegister.PROCESS, 0);
                        if (!TextUtils.isEmpty(str4)) {
                            CommonClickControl.m23098b(campaignEx, CommonClickControl.this.f30027q, "end");
                            CampaignReportDao.m22726b(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22727a(campaignEx);
                            File file = new File(str4);
                            if (file.exists() && z) {
                                CommonClickUtil.m23077a(CommonClickControl.this.f30027q, Uri.fromFile(file), str, str2);
                                C11400ae.m21963a(MBSDKContext.m22865f().m22861j(), str2, str4);
                            } else if (!z) {
                                C11400ae.m21963a(MBSDKContext.m22865f().m22861j(), str2, str4);
                            }
                        }
                        if (CommonClickControl.this.f30030t == null || i != 1) {
                            return;
                        }
                        CommonClickControl.this.f30030t.onDownloadFinish(campaignEx);
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onProgressUpdate(int i) {
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onStart() {
                        CommonClickControl commonClickControl = CommonClickControl.this;
                        CampaignEx campaignEx2 = campaignEx;
                        commonClickControl.m23108a(campaignEx2, campaignEx2.getNoticeUrl(), CommonConst.f30565F);
                        CommonClickControl.m23098b(campaignEx, CommonClickControl.this.f30027q, CampaignEx.JSON_NATIVE_VIDEO_START);
                        if (CommonClickControl.this.f30030t != null) {
                            CommonClickControl.this.f30030t.onDownloadStart(null);
                        }
                    }

                    @Override // com.mbridge.msdk.out.IDownloadListener
                    public final void onStatus(int i) {
                    }
                });
            }
        } catch (Throwable th2) {
            th = th2;
            Context m22861j4 = MBSDKContext.m22865f().m22861j();
            C11400ae.m21963a(m22861j4, str2 + "isDowning", 0L);
            Context m22861j5 = MBSDKContext.m22865f().m22861j();
            C11400ae.m21963a(m22861j5, str2 + UMModuleRegister.PROCESS, 0);
            if (MBridgeConstans.DEBUG) {
                th.printStackTrace();
            }
            m23092c(campaignEx, str, z);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m23108a(CampaignEx campaignEx, String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (i != -1) {
            str = str + "&apk_ptype=" + i;
        }
        if (!str.contains("opdptype")) {
            str = str + "&opdptype=0";
        }
        m23127a(this.f30027q, campaignEx, this.f30017g, str, true, false, RetryReportControl.f29982i);
    }

    /* renamed from: a */
    private void m23129a(Context context, CampaignEx campaignEx) {
        if (context == null) {
            C11385e.m22083a(MBSDKContext.m22865f().m22861j(), campaignEx, 2, "context is null", this.f30017g);
            return;
        }
        boolean z = SameDiTool.m21770v() == 1;
        boolean z2 = SameDiTool.m21774r(context) == 1;
        if (z && z2) {
            String ghId = campaignEx.getGhId();
            String ghPath = campaignEx.getGhPath();
            String bindId = campaignEx.getBindId();
            String m22858m = MBSDKContext.m22865f().m22858m();
            if (!TextUtils.isEmpty(ghId)) {
                try {
                    if (!TextUtils.isEmpty(m22858m)) {
                        bindId = m22858m;
                    }
                    Object m21780f = SameDiTool.m21780f(bindId);
                    Object newInstance = WXLaunchMiniProgram.Req.class.newInstance();
                    WXLaunchMiniProgram.Req.class.getField("userName").set(newInstance, ghId);
                    WXLaunchMiniProgram.Req.class.getField("path").set(newInstance, ghPath);
                    WXLaunchMiniProgram.Req.class.getField("miniprogramType").set(newInstance, WXLaunchMiniProgram.Req.class.getField("MINIPTOGRAM_TYPE_RELEASE").get(null));
                    IWXAPI.class.getMethod("sendReq", BaseReq.class).invoke(m21780f, newInstance);
                    C11385e.m22083a(context, campaignEx, 1, "", this.f30017g);
                    return;
                } catch (Throwable th) {
                    C11385e.m22083a(context, campaignEx, 2, th.getMessage(), this.f30017g);
                    m23085f(campaignEx);
                    return;
                }
            }
            m23085f(campaignEx);
            C11385e.m22083a(context, campaignEx, 2, "ghid is empty", this.f30017g);
            return;
        }
        C11385e.m22083a(context, campaignEx, 2, "integrated:" + z + "-hasWx:" + z2, this.f30017g);
        m23085f(campaignEx);
    }

    /* renamed from: a */
    public static void m23128a(Context context, CampaignEx campaignEx, String str, String str2, boolean z, boolean z2) {
        if (context == null) {
            return;
        }
        new CommonJumpLoader(StubApp.getOrigApplicationContext(context.getApplicationContext()), true).m23169a("2", str, campaignEx, null, str2, z, z2, RetryReportControl.f29979f);
    }

    /* renamed from: a */
    public static void m23127a(Context context, CampaignEx campaignEx, String str, String str2, boolean z, boolean z2, int i) {
        if (context == null) {
            return;
        }
        new CommonJumpLoader(StubApp.getOrigApplicationContext(context.getApplicationContext()), true).m23169a("2", str, campaignEx, null, str2, z, z2, i);
    }

    /* renamed from: a */
    public static void m23126a(Context context, CampaignEx campaignEx, String str, String[] strArr, boolean z, boolean z2) {
        if (context == null || campaignEx == null || TextUtils.isEmpty(str) || strArr == null) {
            return;
        }
        CommonJumpLoader commonJumpLoader = new CommonJumpLoader(StubApp.getOrigApplicationContext(context.getApplicationContext()), true);
        for (String str2 : strArr) {
            commonJumpLoader.m23169a("2", str, campaignEx, null, str2, z, z2, RetryReportControl.f29979f);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x015d A[Catch: Exception -> 0x01ad, TryCatch #0 {Exception -> 0x01ad, blocks: (B:3:0x0008, B:6:0x0016, B:8:0x001b, B:12:0x002a, B:15:0x0031, B:16:0x004d, B:19:0x0055, B:21:0x0066, B:23:0x0072, B:24:0x008a, B:27:0x0095, B:28:0x00a5, B:29:0x00aa, B:31:0x00bc, B:33:0x00c2, B:36:0x00d9, B:39:0x00e0, B:40:0x00ec, B:56:0x0145, B:58:0x015d, B:59:0x0160, B:61:0x0164, B:63:0x016e, B:65:0x0172, B:66:0x017e, B:68:0x0184, B:41:0x00f1, B:43:0x00fd, B:45:0x0107, B:48:0x0110, B:51:0x0132, B:52:0x013b, B:54:0x0140), top: B:73:0x0008 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m23106a(final com.mbridge.msdk.foundation.entity.CampaignEx r17, final boolean r18, boolean r19, boolean r20, final int r21, final boolean r22, final java.lang.Boolean r23) {
        /*
            Method dump skipped, instructions count: 434
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.CommonClickControl.m23106a(com.mbridge.msdk.foundation.entity.CampaignEx, boolean, boolean, boolean, int, boolean, java.lang.Boolean):void");
    }

    /* renamed from: c */
    private int m23096c() {
        try {
            Setting setting = this.f30025o;
            if (setting != null) {
                return setting.m23412U();
            }
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 1;
        }
    }

    /* renamed from: c */
    private static void m23093c(CampaignEx campaignEx, Context context, String str) {
        if (campaignEx != null) {
            try {
                if (campaignEx.getNativeVideoTracking() == null) {
                    return;
                }
                int i = 0;
                if (!str.equals(CampaignEx.JSON_NATIVE_VIDEO_START) && !str.equals("shortcuts_start")) {
                    if (str.equals("end")) {
                        if (campaignEx.getNativeVideoTracking().m22515b() != null) {
                            while (i < campaignEx.getNativeVideoTracking().m22515b().length) {
                                m23128a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().m22515b()[i], false, false);
                                i++;
                            }
                            return;
                        }
                        return;
                    } else if (str.equals("install")) {
                        if (campaignEx.getNativeVideoTracking().m22513c() != null) {
                            while (i < campaignEx.getNativeVideoTracking().m22513c().length) {
                                m23128a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().m22513c()[i], false, false);
                                i++;
                            }
                        }
                        CampaignReportDao.m22726b(CommonSDKDBHelper.m22721a(context)).m22724i(campaignEx.getPackageName());
                        return;
                    } else {
                        return;
                    }
                }
                if (campaignEx.getNativeVideoTracking().m22518a() != null) {
                    while (i < campaignEx.getNativeVideoTracking().m22518a().length) {
                        m23128a(context, campaignEx, campaignEx.getCampaignUnitId(), campaignEx.getNativeVideoTracking().m22518a()[i], false, false);
                        i++;
                    }
                }
            } catch (Throwable th) {
                SameLogTool.m21735b("MBridge SDK M", th.getMessage(), th);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x002e A[Catch: all -> 0x0091, TryCatch #0 {all -> 0x0091, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0012, B:9:0x0018, B:10:0x001c, B:12:0x002e, B:14:0x003b), top: B:21:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:14:0x003b A[Catch: all -> 0x0091, TRY_LEAVE, TryCatch #0 {all -> 0x0091, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0012, B:9:0x0018, B:10:0x001c, B:12:0x002e, B:14:0x003b), top: B:21:0x0002 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0018 A[Catch: all -> 0x0091, TryCatch #0 {all -> 0x0091, blocks: (B:3:0x0002, B:5:0x000c, B:7:0x0012, B:9:0x0018, B:10:0x001c, B:12:0x002e, B:14:0x003b), top: B:21:0x0002 }] */
    /* renamed from: c */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m23092c(final com.mbridge.msdk.foundation.entity.CampaignEx r6, final java.lang.String r7, final boolean r8) {
        /*
            r5 = this;
            if (r6 == 0) goto L11
            java.lang.String r0 = r6.getAkdlui()     // Catch: java.lang.Throwable -> L91
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L91
            if (r0 != 0) goto L11
            java.lang.String r0 = r6.getAkdlui()     // Catch: java.lang.Throwable -> L91
            goto L12
        L11:
            r0 = r7
        L12:
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L91
            if (r1 == 0) goto L1c
            java.lang.String r0 = com.mbridge.msdk.foundation.tools.SameMD5.getMD5(r7)     // Catch: java.lang.Throwable -> L91
        L1c:
            r1 = 2
            com.mbridge.msdk.foundation.tools.DomainSameSDKTool.m21876a(r7, r1, r6)     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()     // Catch: java.lang.Throwable -> L91
            android.content.Context r1 = r1.m22861j()     // Catch: java.lang.Throwable -> L91
            boolean r2 = com.mbridge.msdk.foundation.tools.TargetAdaptionUtils.m21954b(r1)     // Catch: java.lang.Throwable -> L91
            if (r2 != 0) goto L3b
            java.lang.String r8 = r6.getNoticeUrl()     // Catch: java.lang.Throwable -> L91
            int r2 = com.mbridge.msdk.foundation.same.CommonConst.f30567H     // Catch: java.lang.Throwable -> L91
            r5.m23108a(r6, r8, r2)     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.click.CommonClickUtil.m23075a(r1, r7, r0)     // Catch: java.lang.Throwable -> L91
            return
        L3b:
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()     // Catch: java.lang.Throwable -> L91
            android.content.Context r1 = r1.m22861j()     // Catch: java.lang.Throwable -> L91
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91
            r2.<init>()     // Catch: java.lang.Throwable -> L91
            r2.append(r0)     // Catch: java.lang.Throwable -> L91
            java.lang.String r3 = "isDowning"
            r2.append(r3)     // Catch: java.lang.Throwable -> L91
            java.lang.String r2 = r2.toString()     // Catch: java.lang.Throwable -> L91
            long r3 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L91
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.foundation.tools.C11400ae.m21963a(r1, r2, r3)     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.foundation.controller.a r1 = com.mbridge.msdk.foundation.controller.MBSDKContext.m22865f()     // Catch: java.lang.Throwable -> L91
            android.content.Context r1 = r1.m22861j()     // Catch: java.lang.Throwable -> L91
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L91
            r2.<init>()     // Catch: java.lang.Throwable -> L91
            r2.append(r0)     // Catch: java.lang.Throwable -> L91
            java.lang.String r0 = "process"
            r2.append(r0)     // Catch: java.lang.Throwable -> L91
            java.lang.String r0 = r2.toString()     // Catch: java.lang.Throwable -> L91
            int r2 = android.os.Process.myPid()     // Catch: java.lang.Throwable -> L91
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.foundation.tools.C11400ae.m21963a(r1, r0, r2)     // Catch: java.lang.Throwable -> L91
            java.lang.Thread r0 = new java.lang.Thread     // Catch: java.lang.Throwable -> L91
            com.mbridge.msdk.click.b$2 r1 = new com.mbridge.msdk.click.b$2     // Catch: java.lang.Throwable -> L91
            r1.<init>()     // Catch: java.lang.Throwable -> L91
            r0.<init>(r1)     // Catch: java.lang.Throwable -> L91
            r0.start()     // Catch: java.lang.Throwable -> L91
            goto L99
        L91:
            r6 = move-exception
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r7 == 0) goto L99
            r6.printStackTrace()
        L99:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.CommonClickControl.m23092c(com.mbridge.msdk.foundation.entity.CampaignEx, java.lang.String, boolean):void");
    }

    /* renamed from: a */
    private void m23125a(CommonJumpLoader.JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, int i, boolean z) {
        if (campaignEx == null || jumpLoaderResult == null) {
            return;
        }
        try {
            this.f30019i = System.currentTimeMillis() - this.f30018h;
            ClickTime clickTime = new ClickTime();
            int m21804D = SameDiTool.m21804D(this.f30027q);
            clickTime.m22597a(m21804D);
            clickTime.m22595a(SameDiTool.m21784a(this.f30027q, m21804D));
            clickTime.m22580j(campaignEx.getRequestId());
            clickTime.m22579k(campaignEx.getRequestIdNotice());
            clickTime.m22589d(i);
            clickTime.m22581i(this.f30019i + "");
            clickTime.m22582h(campaignEx.getId());
            clickTime.m22585f(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                clickTime.m22583g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            clickTime.m22590c((this.f30018h / 1000) + "");
            clickTime.m22593b(Integer.parseInt(campaignEx.getLandingType()));
            clickTime.m22591c(campaignEx.getLinkType());
            clickTime.m22592b(this.f30017g);
            clickTime.m22585f(jumpLoaderResult.getType());
            if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                clickTime.m22583g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
            }
            if (this.f30021k) {
                clickTime.m22587e(jumpLoaderResult.getStatusCode());
                if (!TextUtils.isEmpty(jumpLoaderResult.getHeader())) {
                    clickTime.m22586e(URLEncoder.encode(jumpLoaderResult.getHeader(), "utf-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                    clickTime.m22584f(URLEncoder.encode(jumpLoaderResult.getContent(), "UTF-8"));
                }
                if (!TextUtils.isEmpty(jumpLoaderResult.getExceptionMsg())) {
                    clickTime.m22588d(URLEncoder.encode(jumpLoaderResult.getExceptionMsg(), "utf-8"));
                }
            }
            if (z) {
                this.f30031u.m22097a("click_jump_error", clickTime, this.f30017g);
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(clickTime);
            String m22594a = ClickTime.m22594a(arrayList);
            if (StringUtils.m21956b(m22594a)) {
                if (MBBatchReportManager.m22142a().m22135c()) {
                    MBBatchReportManager.m22142a().m22139a(m22594a);
                } else {
                    new ReportController(this.f30027q, 0).m22095a("click_jump_success", m22594a, (String) null, (Frame) null);
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    public final void m23105a(Campaign campaign, String str) {
        try {
            if (!TextUtils.isEmpty(str) && campaign != null) {
                CampaignEx campaignEx = campaign instanceof CampaignEx ? (CampaignEx) campaign : null;
                if (!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) {
                    DomainMBridgeConstans.ALLOW_APK_DOWNLOAD = Setting.m23355aq();
                    if (!str.toLowerCase().endsWith(".apk") || DomainMBridgeConstans.ALLOW_APK_DOWNLOAD) {
                        return;
                    }
                    if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getPackageName())) {
                        Context context = this.f30027q;
                        if (!SameSDKTool.C11399a.m22027a(context, "market://details?id=" + campaignEx.getPackageName(), this.f30030t)) {
                            try {
                                this.f30032v.post(new Runnable() { // from class: com.mbridge.msdk.click.b.8
                                    @Override // java.lang.Runnable
                                    public final void run() {
                                        Toast.makeText(CommonClickControl.this.f30027q, "Opps!Access Unavailable", 0).show();
                                    }
                                });
                                return;
                            } catch (Exception unused) {
                                SameLogTool.m21733d("MBridge SDK M", "Opps!Access Unavailable.");
                                return;
                            }
                        } else if (DomainMBridgeConstans.ALLOW_APK_DOWNLOAD) {
                            m23107a(campaignEx, str, true);
                            return;
                        } else {
                            return;
                        }
                    } else if (DomainMBridgeConstans.ALLOW_APK_DOWNLOAD) {
                        m23107a(campaignEx, str, true);
                        return;
                    } else {
                        return;
                    }
                }
                if (!SameSDKTool.C11399a.m22027a(this.f30027q, str, this.f30030t) && campaignEx != null) {
                    if (!TextUtils.isEmpty(campaignEx.getPackageName())) {
                        Context context2 = this.f30027q;
                        SameSDKTool.C11399a.m22027a(context2, "market://details?id=" + campaignEx.getPackageName(), this.f30030t);
                    } else if (m23096c() == 2) {
                        SameSDKTool.m22033a(this.f30027q, campaignEx.getClickURL(), campaignEx, this.f30030t);
                    } else {
                        SameSDKTool.m22029b(this.f30027q, campaignEx.getClickURL(), this.f30030t);
                    }
                }
                SameLogTool.m21736b("MBridge SDK M", "Jump to Google Play: " + str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m23124a(CommonJumpLoader.JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, boolean z, boolean z2) {
        if (this.f30020j) {
            m23125a(jumpLoaderResult, campaignEx, 1, z);
        } else if (z2) {
            m23125a(jumpLoaderResult, campaignEx, 2, z);
        }
    }

    /* renamed from: a */
    private void m23131a(int i, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener) {
        try {
            if (!TextUtils.isEmpty(str)) {
                if (i == 2) {
                    SameSDKTool.m22033a(this.f30027q, str, campaignEx, nativeTrackingListener);
                } else {
                    SameSDKTool.m22029b(this.f30027q, str, nativeTrackingListener);
                }
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("MBridge SDK M", th.getMessage(), th);
        }
    }

    /* renamed from: a */
    private boolean m23111a(CampaignEx campaignEx, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, boolean z, boolean z2, int i) {
        boolean z3 = false;
        if (z) {
            try {
                int intValue = Integer.valueOf(campaignEx.getLandingType()).intValue();
                if (intValue == 1) {
                    SameSDKTool.m22029b(this.f30027q, jumpLoaderResult.getUrl(), this.f30030t);
                } else if (intValue == 2) {
                    SameSDKTool.m22033a(this.f30027q, jumpLoaderResult.getUrl(), campaignEx, this.f30030t);
                } else if (campaignEx.getPackageName() != null) {
                    Context context = this.f30027q;
                    if (!SameSDKTool.C11399a.m22027a(context, "market://details?id=" + campaignEx.getPackageName(), this.f30030t)) {
                        m23131a(i, jumpLoaderResult.getUrl(), campaignEx, this.f30030t);
                    }
                } else {
                    m23131a(i, jumpLoaderResult.getUrl(), campaignEx, this.f30030t);
                }
                z3 = true;
            } catch (Throwable th) {
                SameLogTool.m21735b("MBridge SDK M", th.getMessage(), th);
            }
        }
        if (z3) {
            m23124a(jumpLoaderResult, campaignEx, true, z2);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f30030t;
            if (nativeTrackingListener != null && z) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            }
        } else {
            m23124a(jumpLoaderResult, campaignEx, true, z2);
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f30030t;
            if (nativeTrackingListener2 != null && z) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z3;
    }

    /* renamed from: a */
    private boolean m23112a(CampaignEx campaignEx, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, boolean z, boolean z2) {
        boolean z3 = false;
        if (z) {
            try {
                m23108a(campaignEx, campaignEx.getNoticeUrl(), CommonConst.f30567H);
                SameSDKTool.m22029b(this.f30027q, campaignEx.getClickURL(), this.f30030t);
                z3 = true;
            } catch (Throwable th) {
                SameLogTool.m21735b("MBridge SDK M", th.getMessage(), th);
            }
        }
        if (z3) {
            m23124a(jumpLoaderResult, campaignEx, true, z2);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.f30030t;
            if (nativeTrackingListener != null && z) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            }
        } else {
            m23124a(jumpLoaderResult, campaignEx, true, z2);
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.f30030t;
            if (nativeTrackingListener2 != null && z) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:100:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:101:?, code lost:
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0101, code lost:
        if (com.mbridge.msdk.foundation.tools.SameSDKTool.C11399a.m22027a(r6, "market://details?id=" + r12.getPackageName(), r11.f30030t) == false) goto L70;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x01f0, code lost:
        m23124a(r13, r12, true, r16);
        r0 = r11.f30030t;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x01f5, code lost:
        if (r0 == null) goto L101;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x01f7, code lost:
        if (r14 == false) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x01f9, code lost:
        r0.onRedirectionFailed(null, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01fd, code lost:
        return;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m23110a(com.mbridge.msdk.foundation.entity.CampaignEx r12, com.mbridge.msdk.click.CommonJumpLoader.JumpLoaderResult r13, boolean r14, boolean r15, boolean r16, java.lang.Boolean r17) {
        /*
            Method dump skipped, instructions count: 515
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.CommonClickControl.m23110a(com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.click.CommonJumpLoader$JumpLoaderResult, boolean, boolean, boolean, java.lang.Boolean):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0010, code lost:
        if (android.text.TextUtils.isEmpty(r5) == false) goto L7;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean m23132a(int r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            if (r4 != r0) goto Lc
            boolean r4 = com.mbridge.msdk.foundation.tools.SameSDKTool.C11399a.m22026a(r5)     // Catch: java.lang.Exception -> L16
            if (r4 == 0) goto L13
            goto L14
        Lc:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch: java.lang.Exception -> L16
            if (r4 != 0) goto L13
            goto L14
        L13:
            r1 = 0
        L14:
            r2 = r1
            goto L1a
        L16:
            r4 = move-exception
            r4.printStackTrace()
        L1a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.CommonClickControl.m23132a(int, java.lang.String):boolean");
    }

    /* renamed from: a */
    private void m23107a(CampaignEx campaignEx, String str, boolean z) {
        String akdlui = campaignEx.getAkdlui();
        if (TextUtils.isEmpty(akdlui)) {
            akdlui = SameMD5.getMD5(str);
        }
        try {
            String obj = C11400ae.m21961b(MBSDKContext.m22865f().m22861j(), akdlui, "").toString();
            if (!TextUtils.isEmpty(obj)) {
                File file = new File(obj);
                if (file.exists()) {
                    if (z) {
                        m23108a(campaignEx, campaignEx.getNoticeUrl(), CommonConst.f30568I);
                        CommonClickUtil.m23077a(this.f30027q, Uri.fromFile(file), str, akdlui);
                        return;
                    }
                    return;
                }
            } else {
                Context m22861j = MBSDKContext.m22865f().m22861j();
                int intValue = ((Integer) C11400ae.m21961b(m22861j, akdlui + UMModuleRegister.PROCESS, 0)).intValue();
                int myPid = Process.myPid();
                if (intValue != 0 && intValue == myPid) {
                    Context m22861j2 = MBSDKContext.m22865f().m22861j();
                    long longValue = ((Long) C11400ae.m21961b(m22861j2, akdlui + "isDowning", 0L)).longValue();
                    long currentTimeMillis = System.currentTimeMillis() - longValue;
                    if (longValue != 0 && currentTimeMillis < TTAdConstant.AD_MAX_EVENT_TIME) {
                        if (z) {
                            Context m22861j3 = MBSDKContext.m22865f().m22861j();
                            int intValue2 = ((Integer) C11400ae.m21961b(m22861j3, akdlui + "downloadType", -1)).intValue();
                            if (intValue2 == 1) {
                                m23098b(campaignEx, this.f30027q, "downloading");
                                m23108a(campaignEx, campaignEx.getNoticeUrl(), CommonConst.f30564E);
                                return;
                            } else if (intValue2 == 2) {
                                m23113a(campaignEx, this.f30027q, "downloading");
                                m23108a(campaignEx, campaignEx.getNoticeUrl(), CommonConst.f30564E);
                                return;
                            } else {
                                SameSDKTool.m22029b(this.f30027q, campaignEx.getClickURL(), this.f30030t);
                                m23108a(campaignEx, campaignEx.getNoticeUrl(), CommonConst.f30567H);
                                return;
                            }
                        }
                        return;
                    }
                }
            }
            if (TargetAdaptionUtils.f30996a == -1) {
                try {
                    Class.forName("com.mbridge.msdk.mbdownload.b");
                    Class.forName("com.mbridge.msdk.mbdownload.f");
                    TargetAdaptionUtils.f30996a = 1;
                    TargetAdaptionUtils.f30997b = "ok";
                } catch (ClassNotFoundException e) {
                    TargetAdaptionUtils.f30996a = 0;
                    TargetAdaptionUtils.f30997b = e.getMessage();
                }
            }
            if (TargetAdaptionUtils.f30996a == 1 && z) {
                m23097b(campaignEx, str, z);
            } else {
                m23092c(campaignEx, str, z);
            }
        } catch (Throwable th) {
            TargetAdaptionUtils.f30996a = -1;
            TargetAdaptionUtils.f30997b = th.getMessage();
            SameLogTool.m21736b("downloadapk", "can't find download jar, use simple method");
            m23092c(campaignEx, str, z);
        }
    }

    /* renamed from: a */
    public static void m23113a(CampaignEx campaignEx, Context context, String str) {
        try {
            if (str.equals(CampaignEx.JSON_NATIVE_VIDEO_START) || str.equals("downloading")) {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    m23091d();
                } else {
                    Message obtainMessage = f30016f.obtainMessage(1);
                    obtainMessage.obj = context;
                    f30016f.sendMessage(obtainMessage);
                }
            }
            m23093c(campaignEx, context, str);
        } catch (Throwable th) {
            SameLogTool.m21735b("MBridge SDK M", th.getMessage(), th);
        }
    }

    /* renamed from: a */
    public static void m23130a(Context context) {
        Setting m23252b = SettingManager.m23261a().m23252b(MBSDKContext.m22865f().m22860k());
        if (m23252b == null) {
            m23252b = SettingManager.m23261a().m23253b();
        }
        if (m23252b != null) {
            if (MBSDKContext.m22865f().m22861j() == null && context != null) {
                Toast.makeText(context, m23252b.m23420Q(), 0).show();
            } else {
                Toast.makeText(MBSDKContext.m22865f().m22861j(), m23252b.m23420Q(), 0).show();
            }
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23117a(CommonClickControl commonClickControl, CampaignEx campaignEx, boolean z, CommonJumpLoader.JumpLoaderResult jumpLoaderResult, int i, boolean z2) {
        if (campaignEx == null) {
            return;
        }
        String str = "";
        if (jumpLoaderResult != null) {
            try {
                str = jumpLoaderResult.getUrl();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        CampaignClickDao m22799a = CampaignClickDao.m22799a(commonClickControl.f30026p);
        if (commonClickControl.m23132a(campaignEx.getLinkType(), str)) {
            commonClickControl.m23124a(jumpLoaderResult, campaignEx, false, z2);
            if (campaignEx.getJumpResult() != null && !TextUtils.isEmpty(campaignEx.getNoticeUrl())) {
                campaignEx.getJumpResult().setNoticeurl(campaignEx.getNoticeUrl());
            }
            m22799a.m22798a(campaignEx, commonClickControl.f30017g, z, 1, i);
            return;
        }
        commonClickControl.m23124a(jumpLoaderResult, campaignEx, true, z2);
        m22799a.m22798a(campaignEx, commonClickControl.f30017g, z, 0, i);
    }

    /* renamed from: a */
    static /* synthetic */ void m23121a(CommonClickControl commonClickControl, CampaignEx campaignEx) {
        try {
            Intent intent = new Intent(commonClickControl.f30027q, LoadingActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            commonClickControl.f30027q.startActivity(intent);
        } catch (Exception e) {
            SameLogTool.m21735b("MBridge SDK M", "Exception", e);
        }
    }

    /* renamed from: a */
    static /* synthetic */ void m23115a(CommonClickControl commonClickControl, final boolean z, final Campaign campaign) {
        new Handler(Looper.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.click.b.7
            @Override // java.lang.Runnable
            public final void run() {
                if (z && !CommonClickControl.f30011a && MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                    CommonClickControl.m23084g(CommonClickControl.this);
                }
                if (CommonClickControl.this.f30030t == null || CommonClickControl.f30011a || !MBridgeConstans.NATIVE_SHOW_LOADINGPAGER) {
                    return;
                }
                CommonClickControl.this.f30030t.onDismissLoading(campaign);
            }
        });
    }

    /* renamed from: a */
    static /* synthetic */ void m23118a(CommonClickControl commonClickControl, final CampaignEx campaignEx, final String str, final boolean z) {
        String md5;
        if (campaignEx != null && !TextUtils.isEmpty(campaignEx.getAkdlui())) {
            md5 = campaignEx.getAkdlui();
        } else {
            md5 = SameMD5.getMD5(str);
        }
        try {
            final String str2 = md5;
            SimpleDownload.m21369a(DomainSameFileTool.m21879a("/apk", commonClickControl.f30027q, new boolean[1]), CommonClickUtil.m23072a(str), str, new SimpleDownloadCallback() { // from class: com.mbridge.msdk.click.b.3
                @Override // com.mbridge.msdk.optimize.SimpleDownloadCallback
                /* renamed from: a */
                public final void mo21334a() {
                    CommonClickControl.this.f30032v.sendMessage(CommonClickControl.this.f30032v.obtainMessage(0));
                    CommonClickControl commonClickControl2 = CommonClickControl.this;
                    CampaignEx campaignEx2 = campaignEx;
                    commonClickControl2.m23108a(campaignEx2, campaignEx2.getNoticeUrl(), CommonConst.f30566G);
                    if (z) {
                        CommonClickControl.m23113a(campaignEx, CommonClickControl.this.f30027q, CampaignEx.JSON_NATIVE_VIDEO_START);
                    } else {
                        CommonClickControl.m23113a(campaignEx, CommonClickControl.this.f30027q, "shortcuts_start");
                    }
                }

                @Override // com.mbridge.msdk.optimize.SimpleDownloadCallback
                /* renamed from: b */
                public final void mo21331b() {
                    CommonClickUtil.m23075a(CommonClickControl.this.f30027q, str, str2);
                }

                @Override // com.mbridge.msdk.optimize.SimpleDownloadCallback
                /* renamed from: a */
                public final void mo21333a(int i) {
                    Message obtainMessage = CommonClickControl.this.f30032v.obtainMessage(1);
                    obtainMessage.arg1 = i;
                    CommonClickControl.this.f30032v.sendMessage(obtainMessage);
                }

                @Override // com.mbridge.msdk.optimize.SimpleDownloadCallback
                /* renamed from: a */
                public final void mo21332a(File file) {
                    Context m22861j = MBSDKContext.m22865f().m22861j();
                    C11400ae.m21963a(m22861j, str2 + "isDowning", 0L);
                    Context m22861j2 = MBSDKContext.m22865f().m22861j();
                    C11400ae.m21963a(m22861j2, str2 + UMModuleRegister.PROCESS, 0);
                    CommonClickControl.m23113a(campaignEx, CommonClickControl.this.f30027q, "end");
                    CampaignReportDao.m22726b(CommonSDKDBHelper.m22721a(MBSDKContext.m22865f().m22861j())).m22727a(campaignEx);
                    if (file.exists() && z) {
                        CommonClickUtil.m23077a(CommonClickControl.this.f30027q, Uri.fromFile(file), str, str2);
                        C11400ae.m21963a(MBSDKContext.m22865f().m22861j(), str2, file.getAbsolutePath());
                    } else if (z) {
                    } else {
                        C11400ae.m21963a(MBSDKContext.m22865f().m22861j(), str2, file.getAbsolutePath());
                    }
                }
            });
        } catch (Throwable unused) {
            CommonClickUtil.m23075a(MBSDKContext.m22865f().m22861j(), str, md5);
        }
    }
}
