package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.model.AccessiblityModel;
import com.acse.ottn.model.AdPackageModel;
import com.acse.ottn.model.PageSettingTypeModel;
import com.acse.ottn.p030a.C1252c;
import com.acse.ottn.receiver.C1555c;
import com.acse.ottn.service.MainService;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.baidu.mobads.sdk.internal.C2624bk;
import com.clj.fastble.BleManager;
import com.google.gson.Gson;
import com.tencent.connect.common.Constants;
import com.umeng.analytics.pro.UMCommonContent;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.TreeMap;

/* renamed from: com.acse.ottn.util.A */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1617A {

    /* renamed from: a */
    private static C1617A f3109a = null;

    /* renamed from: b */
    public static TimerTask f3110b = null;

    /* renamed from: c */
    public static TimerTask f3111c = null;

    /* renamed from: d */
    public static C1555c f3112d = null;

    /* renamed from: e */
    private static String f3113e = "acse_ShopHelperService";

    /* renamed from: j */
    public String f3118j;

    /* renamed from: k */
    List<String> f3119k;

    /* renamed from: m */
    public TimerTask f3121m;

    /* renamed from: n */
    public AccessibilityService f3122n;

    /* renamed from: p */
    private Intent f3124p;

    /* renamed from: q */
    private Intent f3125q;

    /* renamed from: s */
    String f3127s;

    /* renamed from: f */
    private int f3114f = 0;

    /* renamed from: g */
    private int f3115g = 10069;

    /* renamed from: h */
    private int f3116h = 10067;

    /* renamed from: i */
    private int f3117i = 10065;

    /* renamed from: l */
    int f3120l = 0;

    /* renamed from: o */
    private boolean f3123o = true;

    /* renamed from: r */
    boolean f3126r = false;

    /* renamed from: t */
    Handler f3128t = new HandlerC1711z(this);

    private C1617A() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m56348a(AccessibilityService accessibilityService, boolean z, String str) {
        String str2 = f3113e;
        C1694ra.m55917a(str2, "isOldRedPageInfo= " + z + "   readType = " + str);
        List<String> list = this.f3119k;
        if (list != null) {
            list.removeAll(list);
            this.f3119k = null;
            this.f3120l = 0;
        }
        this.f3119k = new ArrayList();
        this.f3120l = 0;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (z) {
            m56347a(rootInActiveWindow, str);
        } else {
            m56327b(rootInActiveWindow, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m56345a(PageSettingTypeModel pageSettingTypeModel, String str) {
        TimerTask timerTask = f3110b;
        if (timerTask != null) {
            timerTask.cancel();
            f3110b = null;
        }
        try {
            AdPackageModel m56133b = C1652V.m56140a().m56133b();
            if (m56133b != null) {
                this.f3126r = !"0".equals(m56133b.getReadpage_type());
            }
        } catch (Exception e) {
            this.f3126r = false;
            e.getMessage();
        }
        List<String> list = this.f3119k;
        if (list != null) {
            list.removeAll(list);
            this.f3119k = null;
        }
        this.f3120l = 0;
        this.f3119k = new ArrayList();
        f3110b = C1648S.m56165a().m56163b(pageSettingTypeModel.getRead_time(), 600, new C1700u(this, pageSettingTypeModel, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public void m56332a(List<String> list, String str, String str2, String str3) {
        if (!C1684n.m55975c().m55984b() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (list != null) {
            if (!m56335a(str2 + "_request", 500)) {
                return;
            }
        }
        TreeMap treeMap = new TreeMap();
        Gson gson = new Gson();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        treeMap.put(Constants.JumpUrlConstants.SRC_TYPE_APP, str);
        HelpShopAppUtil.getInstance();
        treeMap.put("marker", HelpShopAppUtil.sessionNewID());
        if (list != null) {
            treeMap.put("data", gson.toJson(list));
        } else {
            treeMap.put("data", "");
        }
        treeMap.put("title", str3);
        treeMap.put("new_version", Constants.VIA_SHARE_TYPE_MINI_PROGRAM);
        treeMap.put("coupon_type", C1652V.m56140a().m56122g(str));
        treeMap.put("genuine_packagename", str2);
        treeMap.put(UMCommonContent.f37749F, C1638Ka.m56193b());
        treeMap.put("is_snt", CommonUtil.SNT_VERSION);
        treeMap.put(ConstantHelper.LOG_VS, CommonUtil.CURRECT_APP_VERSION);
        if (list != null) {
            String str4 = f3113e;
            C1694ra.m55917a(str4, "getCouponInfo string =" + gson.toJson(list));
        }
        new C1252c().m57359a(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(ExecutorC1627F.m56271a()).subscribe(new C1702v(this, str), new C1705w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public boolean m56336a(String str) {
        return m56323b(str, 0);
    }

    /* renamed from: a */
    private boolean m56335a(String str, int i) {
        return m56323b(str, i);
    }

    /* renamed from: b */
    public static C1617A m56331b() {
        if (f3109a == null) {
            synchronized (C1617A.class) {
                if (f3109a == null) {
                    f3109a = new C1617A();
                }
            }
        }
        return f3109a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public String m56328b(AccessibilityService accessibilityService, String str) {
        String str2 = f3113e;
        C1694ra.m55917a(str2, "getJDtitle jd id is " + str);
        AccessibilityNodeInfo m55959f = C1684n.m55975c().m55959f(accessibilityService, str);
        if (m55959f != null && m55959f.getText() != null) {
            C1694ra.m55917a(f3113e, "nodeInfo.getText()!=null ");
            String trim = m55959f.getText().toString().trim();
            if (!TextUtils.isEmpty(trim) && trim.length() > 10) {
                C1684n.m55975c().m55958f(m55959f);
                AccessibilityNodeInfo m55959f2 = C1684n.m55975c().m55959f(accessibilityService, str);
                if (m55959f2 == null && m55959f.getText() == null) {
                    return "";
                }
                String trim2 = m55959f2.getText().toString().trim();
                if (trim.contains(trim2) || trim2.contains(trim)) {
                    return trim.length() > trim2.length() ? trim : trim2;
                }
                String str3 = f3113e;
                C1694ra.m55917a(str3, "getJDtitle jd id is error=" + str);
                C1661ba.m56097a().m56088b("jd_view_id", "");
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m56329b(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
        C1694ra.m55917a(f3113e, "showFloatWindow");
        if (accessiblityModel == null) {
            return;
        }
        String str = f3113e;
        C1694ra.m55917a(str, "showFloatWindow packageName is model = " + accessiblityModel.getData().getAuto_open_coupon());
        if (this.f3124p != null) {
            C1694ra.m55917a(f3113e, "showFloatWindow stop floatIntent");
            accessibilityService.stopService(this.f3124p);
            this.f3124p = null;
        }
        C1694ra.m55917a(f3113e, "showFloatWindow start");
        Intent intent = new Intent(accessibilityService, MainService.class);
        this.f3124p = intent;
        intent.putExtra(C2624bk.f8685i, accessiblityModel);
        accessibilityService.startService(this.f3124p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public boolean m56324b(String str) {
        String m56161a = C1650T.m56150d().m56161a();
        C1661ba m56097a = C1661ba.m56097a();
        if (m56161a.equals(m56097a.m56086d("samon_" + str))) {
            String str2 = f3113e;
            C1694ra.m55917a(str2, "the day not requst packageName =" + str);
            return false;
        }
        return true;
    }

    /* renamed from: b */
    private boolean m56323b(String str, int i) {
        if (i == 0) {
            i = 500;
        }
        C1661ba m56097a = C1661ba.m56097a();
        Long m56087c = m56097a.m56087c("coupon_" + str);
        String str2 = f3113e;
        C1694ra.m55915b(str2, "controlCouponShow appPageName =" + (System.currentTimeMillis() - m56087c.longValue()));
        if (System.currentTimeMillis() - m56087c.longValue() < i) {
            C1694ra.m55917a(f3113e, "controlCouponShow return false ");
            return false;
        }
        C1661ba m56097a2 = C1661ba.m56097a();
        m56097a2.m56094a("coupon_" + str, System.currentTimeMillis());
        C1694ra.m55917a(f3113e, "controlCouponShow return true");
        return true;
    }

    /* renamed from: c */
    private Object m56321c() throws ObjectStreamException {
        return f3109a;
    }

    /* renamed from: c */
    private void m56317c(String str, String str2, int i, int i2) {
        try {
            Message message = new Message();
            message.what = i;
            Bundle bundle = new Bundle();
            bundle.putString("coupon_packagename", str);
            bundle.putString("genuine_packagename", str2);
            message.setData(bundle);
            this.f3128t.sendMessageDelayed(message, i2);
        } catch (Exception e) {
            String str3 = f3113e;
            C1694ra.m55917a(str3, "sendMessage =" + e.getMessage());
        }
    }

    /* renamed from: d */
    private void m56316d() {
        if (f3111c != null) {
            return;
        }
        if (C1650T.m56150d().m56161a().equals(C1661ba.m56097a() != null ? C1661ba.m56097a().m56086d("appHeartbeat") : "")) {
            return;
        }
        f3111c = C1648S.m56165a().m56163b(20000, BleManager.f22896l, new C1691q(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m56352a(android.accessibilityservice.AccessibilityService r8) {
        /*
            r7 = this;
            java.lang.String r0 = "battery_white"
            com.acse.ottn.receiver.c r1 = new com.acse.ottn.receiver.c
            r1.<init>(r8)
            com.acse.ottn.util.C1617A.f3112d = r1
            r1.m56435a()
            com.acse.ottn.util.ba r1 = com.acse.ottn.util.C1661ba.m56097a()     // Catch: java.lang.Exception -> L8e
            if (r1 != 0) goto L13
            return
        L13:
            com.acse.ottn.util.ba r1 = com.acse.ottn.util.C1661ba.m56097a()     // Catch: java.lang.Exception -> L8e
            boolean r1 = r1.m56096a(r0)     // Catch: java.lang.Exception -> L8e
            if (r1 != 0) goto L2e
            java.lang.String r8 = com.acse.ottn.util.C1617A.f3113e     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = "没有打开"
            com.acse.ottn.util.C1694ra.m55917a(r8, r1)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.va r8 = com.acse.ottn.util.C1703va.m55903a()     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = "system_open_accessiblity"
            r8.m55901a(r1)     // Catch: java.lang.Exception -> L8e
            return
        L2e:
            com.acse.ottn.util.va r1 = com.acse.ottn.util.C1703va.m55903a()     // Catch: java.lang.Exception -> L8e
            java.lang.String r2 = "user_open_accessiblity"
            r1.m55901a(r2)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1684n.m55975c()     // Catch: java.lang.Exception -> L8e
            r1.m55969d(r8)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1684n.m55975c()     // Catch: java.lang.Exception -> L8e
            r2 = 100
            r1.m56005a(r2)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1684n.m55975c()     // Catch: java.lang.Exception -> L8e
            r1.m55969d(r8)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1684n.m55975c()     // Catch: java.lang.Exception -> L8e
            java.lang.String r4 = "已下载的应用"
            android.view.accessibility.AccessibilityNodeInfo r1 = r1.m55951j(r8, r4)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r4 = com.acse.ottn.util.C1684n.m55975c()     // Catch: java.lang.Exception -> L8e
            java.lang.String r5 = "已安装的服务"
            android.view.accessibility.AccessibilityNodeInfo r4 = r4.m55951j(r8, r5)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r5 = com.acse.ottn.util.C1684n.m55975c()     // Catch: java.lang.Exception -> L8e
            java.lang.String r6 = "已下载的服务"
            android.view.accessibility.AccessibilityNodeInfo r5 = r5.m55951j(r8, r6)     // Catch: java.lang.Exception -> L8e
            if (r1 != 0) goto L78
            if (r4 != 0) goto L78
            if (r5 == 0) goto L73
            goto L78
        L73:
            java.lang.String r8 = com.acse.ottn.util.C1617A.f3113e     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = "都没有找到"
            goto L8a
        L78:
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1684n.m55975c()     // Catch: java.lang.Exception -> L8e
            r1.m56005a(r2)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1684n.m55975c()     // Catch: java.lang.Exception -> L8e
            r1.m55969d(r8)     // Catch: java.lang.Exception -> L8e
            java.lang.String r8 = com.acse.ottn.util.C1617A.f3113e     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = "找到"
        L8a:
            com.acse.ottn.util.C1694ra.m55917a(r8, r1)     // Catch: java.lang.Exception -> L8e
            goto L8f
        L8e:
        L8f:
            com.acse.ottn.util.ba r8 = com.acse.ottn.util.C1661ba.m56097a()
            if (r8 == 0) goto L9d
            com.acse.ottn.util.ba r8 = com.acse.ottn.util.C1661ba.m56097a()
            r1 = 0
            r8.m56092a(r0, r1)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.util.C1617A.m56352a(android.accessibilityservice.AccessibilityService):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac A[Catch: Exception -> 0x0860, TRY_LEAVE, TryCatch #0 {Exception -> 0x0860, blocks: (B:9:0x0019, B:11:0x0027, B:13:0x002f, B:15:0x0035, B:36:0x00b5, B:38:0x00be, B:40:0x00d4, B:43:0x00ec, B:45:0x00fe, B:47:0x010f, B:49:0x0115, B:51:0x011b, B:52:0x0120, B:54:0x0128, B:56:0x0132, B:59:0x0146, B:61:0x0152, B:63:0x015e, B:66:0x016c, B:68:0x0178, B:71:0x0186, B:73:0x0192, B:75:0x019e, B:78:0x01ac, B:80:0x01b8, B:82:0x01c0, B:84:0x01c8, B:86:0x01cc, B:87:0x01d9, B:374:0x0790, B:413:0x085c, B:88:0x01dd, B:90:0x01e9, B:92:0x01f1, B:94:0x01f9, B:96:0x01fd, B:97:0x020b, B:99:0x0217, B:101:0x021f, B:103:0x0227, B:105:0x022b, B:106:0x0239, B:108:0x0245, B:111:0x0253, B:113:0x025f, B:115:0x0267, B:117:0x026f, B:119:0x0273, B:120:0x0282, B:122:0x028e, B:124:0x0296, B:126:0x029e, B:128:0x02a2, B:129:0x02b1, B:131:0x02bd, B:133:0x02c5, B:135:0x02cd, B:137:0x02d1, B:138:0x02e0, B:140:0x02ec, B:142:0x02f4, B:144:0x02fc, B:402:0x0829, B:147:0x0312, B:149:0x031e, B:151:0x0326, B:153:0x032e, B:155:0x0332, B:156:0x0341, B:158:0x034d, B:160:0x0355, B:162:0x035d, B:164:0x0361, B:165:0x0370, B:167:0x037c, B:170:0x038a, B:172:0x0396, B:174:0x039e, B:176:0x03a6, B:178:0x03aa, B:179:0x03b9, B:182:0x03c7, B:184:0x03cf, B:186:0x03d7, B:187:0x03e8, B:189:0x03f4, B:191:0x03fc, B:193:0x0404, B:195:0x0408, B:196:0x0417, B:198:0x0423, B:200:0x042f, B:202:0x043b, B:205:0x0449, B:207:0x0455, B:209:0x045d, B:211:0x0465, B:213:0x0469, B:214:0x0478, B:216:0x0484, B:218:0x0490, B:221:0x049e, B:223:0x04aa, B:226:0x04b8, B:228:0x04c4, B:230:0x04d0, B:233:0x04de, B:235:0x04ea, B:237:0x04f2, B:239:0x04fa, B:241:0x04fe, B:242:0x050a, B:244:0x0516, B:246:0x051e, B:248:0x0526, B:250:0x052a, B:251:0x0539, B:253:0x0545, B:255:0x054d, B:257:0x0555, B:259:0x0559, B:260:0x0568, B:262:0x0574, B:264:0x057c, B:266:0x0584, B:268:0x0588, B:269:0x0597, B:271:0x05a3, B:273:0x05ab, B:275:0x05b3, B:277:0x05b7, B:280:0x05c8, B:284:0x05d2, B:287:0x05da, B:291:0x05e4, B:293:0x05ea, B:295:0x05f4, B:296:0x0600, B:299:0x060c, B:302:0x0618, B:304:0x0626, B:306:0x0637, B:308:0x063d, B:310:0x0643, B:312:0x0649, B:314:0x064f, B:315:0x0658, B:412:0x0859, B:316:0x065c, B:318:0x0666, B:319:0x0672, B:321:0x067a, B:323:0x0682, B:325:0x0686, B:326:0x0695, B:328:0x069d, B:330:0x06a5, B:332:0x06a9, B:333:0x06b8, B:335:0x06c0, B:337:0x06c8, B:339:0x06ce, B:341:0x06d4, B:343:0x06e4, B:346:0x0701, B:348:0x0707, B:350:0x070d, B:352:0x0715, B:354:0x071d, B:355:0x072e, B:357:0x0736, B:359:0x073e, B:361:0x0742, B:362:0x0751, B:364:0x0759, B:366:0x0761, B:368:0x0765, B:369:0x0774, B:371:0x077c, B:373:0x0784, B:375:0x0795, B:377:0x079d, B:379:0x07a5, B:381:0x07af, B:383:0x07b5, B:384:0x07b8, B:386:0x07c8, B:389:0x07e2, B:391:0x07ec, B:393:0x07f2, B:394:0x07f5, B:396:0x0809, B:398:0x0811, B:403:0x082d, B:406:0x0838, B:409:0x0843, B:411:0x0851, B:17:0x003b, B:20:0x0041, B:22:0x005e, B:30:0x008c, B:33:0x00ac, B:35:0x00b2, B:23:0x0063, B:25:0x0069, B:27:0x006f, B:29:0x0078), top: B:418:0x0019 }] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m56351a(android.accessibilityservice.AccessibilityService r9, android.view.accessibility.AccessibilityEvent r10) {
        /*
            Method dump skipped, instructions count: 2159
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.util.C1617A.m56351a(android.accessibilityservice.AccessibilityService, android.view.accessibility.AccessibilityEvent):void");
    }

    /* renamed from: a */
    public void m56350a(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
        C1694ra.m55917a(f3113e, "couponCountDown ");
        TimerTask timerTask = this.f3121m;
        if (timerTask != null) {
            timerTask.cancel();
            this.f3121m = null;
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_describe())) {
            m56331b().m56349a(this.f3122n, accessiblityModel.getData().getSpop_describe());
        }
        this.f3121m = C1648S.m56165a().m56163b(accessiblityModel.getData().getShow_coupon_time(), 1000, new C1709y(this, accessiblityModel, accessibilityService));
    }

    /* renamed from: a */
    public void m56349a(AccessibilityService accessibilityService, String str) {
        if (str.length() < 10) {
            return;
        }
        String str2 = f3113e;
        C1694ra.m55917a(str2, "getJDTitleId = " + str);
        try {
            AccessibilityNodeInfo m55996a = C1684n.m55975c().m55996a(accessibilityService, str, true);
            if (m55996a == null) {
                C1694ra.m55917a(f3113e, "nodeInfo = null");
                return;
            }
            String viewIdResourceName = Build.VERSION.SDK_INT >= 18 ? m55996a.getViewIdResourceName() : "";
            String str3 = f3113e;
            StringBuilder sb = new StringBuilder();
            sb.append("getJDTitleId jd id is ");
            sb.append(viewIdResourceName);
            C1694ra.m55917a(str3, sb.toString());
            if (TextUtils.isEmpty(viewIdResourceName)) {
                return;
            }
            C1661ba.m56097a().m56088b("jd_view_id", viewIdResourceName);
        } catch (Exception e) {
            String str4 = f3113e;
            C1694ra.m55917a(str4, "getViewId Exception e =" + e.getMessage());
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public void m56347a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                    if (accessibilityNodeInfo.getChild(i) != null) {
                        m56347a(accessibilityNodeInfo.getChild(i), str);
                    }
                }
            }
        } else if (accessibilityNodeInfo.getText() != null) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            if (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().length() > 10 && C1652V.m56140a().m56130b(trim, 5)) {
                this.f3119k.add(accessibilityNodeInfo.getContentDescription().toString());
            }
            if (C1652V.m56140a().m56130b(trim, 5)) {
                this.f3119k.add(trim);
            }
        } else if (accessibilityNodeInfo.getContentDescription() != null) {
            String charSequence = accessibilityNodeInfo.getContentDescription().toString();
            if ("1".equals(str)) {
                if (!C1652V.m56140a().m56130b(charSequence, 5)) {
                    return;
                }
            } else if (!C1652V.m56140a().m56130b(charSequence, 5)) {
                return;
            }
            this.f3119k.add(charSequence);
        }
    }

    /* renamed from: a */
    public void m56346a(AccessiblityModel accessiblityModel, String str) {
        if (1 == accessiblityModel.getR()) {
            if (str.equals(C1631H.m56262a().f3173J)) {
                accessiblityModel.getData().setPackage_name(C1631H.m56262a().f3173J);
            }
            m56350a(this.f3122n, accessiblityModel);
            if ("1".equals(accessiblityModel.getToast_status())) {
                C1661ba m56097a = C1661ba.m56097a();
                m56097a.m56088b("samon_" + accessiblityModel.getGenuine_packagename(), C1650T.m56150d().m56161a());
            } else if ("0".equals(accessiblityModel.getToast_status())) {
                C1661ba m56097a2 = C1661ba.m56097a();
                m56097a2.m56088b("samon_" + str, C1650T.m56150d().m56161a());
            }
        } else if (accessiblityModel.getR() == 0) {
            if ("1".equals(accessiblityModel.getScrolled_screen())) {
                C1661ba.m56097a().m56088b("scroll_state", accessiblityModel.getScrolled_screen());
                C1661ba.m56097a().m56088b("goods_info", accessiblityModel.getProduct_info());
            }
            if (accessiblityModel.getData() != null && !TextUtils.isEmpty(accessiblityModel.getData().getSpop_describe())) {
                m56331b().m56349a(this.f3122n, accessiblityModel.getData().getSpop_describe());
            }
        }
        if ("1".equals(accessiblityModel.getReset_heartbeat())) {
            C1661ba.m56097a().m56088b("appHeartbeat", "");
        }
    }

    /* renamed from: a */
    public void m56334a(String str, String str2) {
        C1694ra.m55917a(f3113e, "onNoSelectActivity");
        if (str.toLowerCase().contains("android.widget")) {
            return;
        }
        this.f3118j = str2;
    }

    /* renamed from: a */
    public void m56333a(String str, String str2, int i, int i2) {
        C1694ra.m55917a(f3113e, "onAdCallBack");
        this.f3118j = str2;
        CommonUtil.isShowConpunInfor = true;
        if (this.f3123o) {
            this.f3123o = false;
            m56317c(str, str2, i, i2);
        }
    }

    /* renamed from: b */
    public void m56330b(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        C1694ra.m55917a(f3113e, "initOpenPermission");
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = accessibilityServiceInfo.flags | 16 | 8 | 64;
        accessibilityServiceInfo.notificationTimeout = 300L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    /* renamed from: b */
    public void m56327b(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        ArrayList arrayList;
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                    if (accessibilityNodeInfo.getChild(i) != null) {
                        m56327b(accessibilityNodeInfo.getChild(i), str);
                    }
                }
                return;
            }
            return;
        }
        if (accessibilityNodeInfo.getText() == null) {
            if (accessibilityNodeInfo.getContentDescription() != null) {
                String charSequence = accessibilityNodeInfo.getContentDescription().toString();
                if ("1".equals(str)) {
                    this.f3120l = C1652V.m56140a().m56137a(charSequence, this.f3120l);
                    if (!C1652V.m56140a().m56139a(this.f3120l)) {
                        List<String> list = this.f3119k;
                        if (list == null) {
                            return;
                        }
                        list.removeAll(list);
                        this.f3119k = null;
                        this.f3120l = 0;
                        arrayList = new ArrayList();
                    }
                    this.f3119k.add(charSequence);
                    return;
                } else if (charSequence.contains("月销") || charSequence.contains("已售") || charSequence.matches("[1-9]\\d*\\.?\\d*") || charSequence.contains("￥") || charSequence.contains("¥")) {
                    this.f3120l = C1652V.m56140a().m56137a(charSequence, this.f3120l);
                    if (!C1652V.m56140a().m56139a(this.f3120l)) {
                        List<String> list2 = this.f3119k;
                        if (list2 == null) {
                            return;
                        }
                        list2.removeAll(list2);
                        this.f3119k = null;
                        this.f3120l = 0;
                        arrayList = new ArrayList();
                    }
                    this.f3119k.add(charSequence);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        String trim = accessibilityNodeInfo.getText().toString().trim();
        if (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().length() > 10) {
            this.f3120l = C1652V.m56140a().m56137a(accessibilityNodeInfo.getContentDescription().toString(), this.f3120l);
            if (C1652V.m56140a().m56139a(this.f3120l)) {
                this.f3119k.add(accessibilityNodeInfo.getContentDescription().toString());
            } else {
                List<String> list3 = this.f3119k;
                if (list3 != null) {
                    list3.removeAll(list3);
                    this.f3119k = null;
                    this.f3120l = 0;
                    this.f3119k = new ArrayList();
                }
            }
        }
        this.f3120l = C1652V.m56140a().m56137a(trim, this.f3120l);
        if (C1652V.m56140a().m56139a(this.f3120l)) {
            this.f3119k.add(trim);
            return;
        }
        List<String> list4 = this.f3119k;
        if (list4 == null) {
            return;
        }
        list4.removeAll(list4);
        this.f3119k = null;
        this.f3120l = 0;
        arrayList = new ArrayList();
        this.f3119k = arrayList;
    }

    /* renamed from: b */
    public void m56322b(String str, String str2, int i, int i2) {
        C1694ra.m55917a(f3113e, "onSelectActivity");
        CommonUtil.isShowConpunInfor = true;
        this.f3118j = str2;
        m56317c(str, str2, i, i2);
    }

    /* renamed from: c */
    public void m56320c(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        C1694ra.m55917a(f3113e, "initOpenPermission");
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 80;
        accessibilityServiceInfo.notificationTimeout = 100L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    /* renamed from: c */
    public void m56319c(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                    if (accessibilityNodeInfo.getChild(i) != null) {
                        m56319c(accessibilityNodeInfo.getChild(i), str);
                    }
                }
            }
        } else if (accessibilityNodeInfo.getText() != null) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            if (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().length() > 10) {
                this.f3119k.add(accessibilityNodeInfo.getContentDescription().toString());
            }
            this.f3119k.add(trim);
        } else if (accessibilityNodeInfo.getContentDescription() != null) {
            String charSequence = accessibilityNodeInfo.getContentDescription().toString();
            if ("1".equals(str) || charSequence.contains("月销") || charSequence.contains("已售") || charSequence.matches("[1-9]\\d*\\.?\\d*") || charSequence.contains("￥") || charSequence.contains("¥")) {
                this.f3119k.add(charSequence);
            }
        }
    }

    /* renamed from: d */
    public void m56315d(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        C1694ra.m55917a(f3113e, "initReadPageInfo");
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 90;
        accessibilityServiceInfo.notificationTimeout = 100L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    /* renamed from: e */
    public void m56314e(AccessibilityService accessibilityService) {
        C1694ra.m55917a(f3113e, "onStopService");
        Intent intent = this.f3124p;
        if (intent != null) {
            accessibilityService.stopService(intent);
            this.f3124p = null;
        }
    }
}
