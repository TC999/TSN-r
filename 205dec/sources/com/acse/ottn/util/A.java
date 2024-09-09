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
import com.acse.ottn.service.MainService;
import com.google.gson.Gson;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;
import java.util.TreeMap;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class A {

    /* renamed from: a  reason: collision with root package name */
    private static A f6682a = null;

    /* renamed from: b  reason: collision with root package name */
    public static TimerTask f6683b = null;

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f6684c = null;

    /* renamed from: d  reason: collision with root package name */
    public static com.acse.ottn.receiver.c f6685d = null;

    /* renamed from: e  reason: collision with root package name */
    private static String f6686e = "acse_ShopHelperService";

    /* renamed from: j  reason: collision with root package name */
    public String f6691j;

    /* renamed from: k  reason: collision with root package name */
    List<String> f6692k;

    /* renamed from: m  reason: collision with root package name */
    public TimerTask f6694m;

    /* renamed from: n  reason: collision with root package name */
    public AccessibilityService f6695n;

    /* renamed from: p  reason: collision with root package name */
    private Intent f6697p;

    /* renamed from: q  reason: collision with root package name */
    private Intent f6698q;

    /* renamed from: s  reason: collision with root package name */
    String f6700s;

    /* renamed from: f  reason: collision with root package name */
    private int f6687f = 0;

    /* renamed from: g  reason: collision with root package name */
    private int f6688g = 10069;

    /* renamed from: h  reason: collision with root package name */
    private int f6689h = 10067;

    /* renamed from: i  reason: collision with root package name */
    private int f6690i = 10065;

    /* renamed from: l  reason: collision with root package name */
    int f6693l = 0;

    /* renamed from: o  reason: collision with root package name */
    private boolean f6696o = true;

    /* renamed from: r  reason: collision with root package name */
    boolean f6699r = false;

    /* renamed from: t  reason: collision with root package name */
    Handler f6701t = new HandlerC1454z(this);

    private A() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public void a(AccessibilityService accessibilityService, boolean z3, String str) {
        String str2 = f6686e;
        ra.a(str2, "isOldRedPageInfo= " + z3 + "   readType = " + str);
        List<String> list = this.f6692k;
        if (list != null) {
            list.removeAll(list);
            this.f6692k = null;
            this.f6693l = 0;
        }
        this.f6692k = new ArrayList();
        this.f6693l = 0;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (z3) {
            a(rootInActiveWindow, str);
        } else {
            b(rootInActiveWindow, str);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(PageSettingTypeModel pageSettingTypeModel, String str) {
        TimerTask timerTask = f6683b;
        if (timerTask != null) {
            timerTask.cancel();
            f6683b = null;
        }
        try {
            AdPackageModel b4 = V.a().b();
            if (b4 != null) {
                this.f6699r = !"0".equals(b4.getReadpage_type());
            }
        } catch (Exception e4) {
            this.f6699r = false;
            e4.getMessage();
        }
        List<String> list = this.f6692k;
        if (list != null) {
            list.removeAll(list);
            this.f6692k = null;
        }
        this.f6693l = 0;
        this.f6692k = new ArrayList();
        f6683b = S.a().b(pageSettingTypeModel.getRead_time(), 600, new C1449u(this, pageSettingTypeModel, str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(List<String> list, String str, String str2, String str3) {
        if (!C1442n.c().b() || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        if (list != null) {
            if (!a(str2 + "_request", 500)) {
                return;
            }
        }
        TreeMap treeMap = new TreeMap();
        Gson gson = new Gson();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        treeMap.put("app", str);
        HelpShopAppUtil.getInstance();
        treeMap.put("marker", HelpShopAppUtil.sessionNewID());
        if (list != null) {
            treeMap.put("data", gson.toJson(list));
        } else {
            treeMap.put("data", "");
        }
        treeMap.put("title", str3);
        treeMap.put("new_version", "9");
        treeMap.put("coupon_type", V.a().g(str));
        treeMap.put("genuine_packagename", str2);
        treeMap.put("device_brand", Ka.b());
        treeMap.put("is_snt", CommonUtil.SNT_VERSION);
        treeMap.put("version", CommonUtil.CURRECT_APP_VERSION);
        if (list != null) {
            String str4 = f6686e;
            ra.a(str4, "getCouponInfo string =" + gson.toJson(list));
        }
        new com.acse.ottn.a.c().a(V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).observeOn(F.a()).subscribe(new C1450v(this, str), new C1451w(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(String str) {
        return b(str, 0);
    }

    private boolean a(String str, int i4) {
        return b(str, i4);
    }

    public static A b() {
        if (f6682a == null) {
            synchronized (A.class) {
                if (f6682a == null) {
                    f6682a = new A();
                }
            }
        }
        return f6682a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String b(AccessibilityService accessibilityService, String str) {
        String str2 = f6686e;
        ra.a(str2, "getJDtitle jd id is " + str);
        AccessibilityNodeInfo f4 = C1442n.c().f(accessibilityService, str);
        if (f4 != null && f4.getText() != null) {
            ra.a(f6686e, "nodeInfo.getText()!=null ");
            String trim = f4.getText().toString().trim();
            if (!TextUtils.isEmpty(trim) && trim.length() > 10) {
                C1442n.c().f(f4);
                AccessibilityNodeInfo f5 = C1442n.c().f(accessibilityService, str);
                if (f5 == null && f4.getText() == null) {
                    return "";
                }
                String trim2 = f5.getText().toString().trim();
                if (trim.contains(trim2) || trim2.contains(trim)) {
                    return trim.length() > trim2.length() ? trim : trim2;
                }
                String str3 = f6686e;
                ra.a(str3, "getJDtitle jd id is error=" + str);
                C1419ba.a().b("jd_view_id", "");
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
        ra.a(f6686e, "showFloatWindow");
        if (accessiblityModel == null) {
            return;
        }
        String str = f6686e;
        ra.a(str, "showFloatWindow packageName is model = " + accessiblityModel.getData().getAuto_open_coupon());
        if (this.f6697p != null) {
            ra.a(f6686e, "showFloatWindow stop floatIntent");
            accessibilityService.stopService(this.f6697p);
            this.f6697p = null;
        }
        ra.a(f6686e, "showFloatWindow start");
        Intent intent = new Intent(accessibilityService, MainService.class);
        this.f6697p = intent;
        intent.putExtra("model", accessiblityModel);
        accessibilityService.startService(this.f6697p);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean b(String str) {
        String a4 = T.d().a();
        C1419ba a5 = C1419ba.a();
        if (a4.equals(a5.d("samon_" + str))) {
            String str2 = f6686e;
            ra.a(str2, "the day not requst packageName =" + str);
            return false;
        }
        return true;
    }

    private boolean b(String str, int i4) {
        if (i4 == 0) {
            i4 = 500;
        }
        C1419ba a4 = C1419ba.a();
        Long c4 = a4.c("coupon_" + str);
        String str2 = f6686e;
        ra.b(str2, "controlCouponShow appPageName =" + (System.currentTimeMillis() - c4.longValue()));
        if (System.currentTimeMillis() - c4.longValue() < i4) {
            ra.a(f6686e, "controlCouponShow return false ");
            return false;
        }
        C1419ba a5 = C1419ba.a();
        a5.a("coupon_" + str, System.currentTimeMillis());
        ra.a(f6686e, "controlCouponShow return true");
        return true;
    }

    private Object c() throws ObjectStreamException {
        return f6682a;
    }

    private void c(String str, String str2, int i4, int i5) {
        try {
            Message message = new Message();
            message.what = i4;
            Bundle bundle = new Bundle();
            bundle.putString("coupon_packagename", str);
            bundle.putString("genuine_packagename", str2);
            message.setData(bundle);
            this.f6701t.sendMessageDelayed(message, i5);
        } catch (Exception e4) {
            String str3 = f6686e;
            ra.a(str3, "sendMessage =" + e4.getMessage());
        }
    }

    private void d() {
        if (f6684c != null) {
            return;
        }
        if (T.d().a().equals(C1419ba.a() != null ? C1419ba.a().d("appHeartbeat") : "")) {
            return;
        }
        f6684c = S.a().b(20000, 10000, new C1446q(this));
    }

    /* JADX WARN: Removed duplicated region for block: B:36:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.accessibilityservice.AccessibilityService r8) {
        /*
            r7 = this;
            java.lang.String r0 = "battery_white"
            com.acse.ottn.receiver.c r1 = new com.acse.ottn.receiver.c
            r1.<init>(r8)
            com.acse.ottn.util.A.f6685d = r1
            r1.a()
            com.acse.ottn.util.ba r1 = com.acse.ottn.util.C1419ba.a()     // Catch: java.lang.Exception -> L8e
            if (r1 != 0) goto L13
            return
        L13:
            com.acse.ottn.util.ba r1 = com.acse.ottn.util.C1419ba.a()     // Catch: java.lang.Exception -> L8e
            boolean r1 = r1.a(r0)     // Catch: java.lang.Exception -> L8e
            if (r1 != 0) goto L2e
            java.lang.String r8 = com.acse.ottn.util.A.f6686e     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = "\u6ca1\u6709\u6253\u5f00"
            com.acse.ottn.util.ra.a(r8, r1)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.va r8 = com.acse.ottn.util.va.a()     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = "system_open_accessiblity"
            r8.a(r1)     // Catch: java.lang.Exception -> L8e
            return
        L2e:
            com.acse.ottn.util.va r1 = com.acse.ottn.util.va.a()     // Catch: java.lang.Exception -> L8e
            java.lang.String r2 = "user_open_accessiblity"
            r1.a(r2)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1442n.c()     // Catch: java.lang.Exception -> L8e
            r1.d(r8)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1442n.c()     // Catch: java.lang.Exception -> L8e
            r2 = 100
            r1.a(r2)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1442n.c()     // Catch: java.lang.Exception -> L8e
            r1.d(r8)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1442n.c()     // Catch: java.lang.Exception -> L8e
            java.lang.String r4 = "\u5df2\u4e0b\u8f7d\u7684\u5e94\u7528"
            android.view.accessibility.AccessibilityNodeInfo r1 = r1.j(r8, r4)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r4 = com.acse.ottn.util.C1442n.c()     // Catch: java.lang.Exception -> L8e
            java.lang.String r5 = "\u5df2\u5b89\u88c5\u7684\u670d\u52a1"
            android.view.accessibility.AccessibilityNodeInfo r4 = r4.j(r8, r5)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r5 = com.acse.ottn.util.C1442n.c()     // Catch: java.lang.Exception -> L8e
            java.lang.String r6 = "\u5df2\u4e0b\u8f7d\u7684\u670d\u52a1"
            android.view.accessibility.AccessibilityNodeInfo r5 = r5.j(r8, r6)     // Catch: java.lang.Exception -> L8e
            if (r1 != 0) goto L78
            if (r4 != 0) goto L78
            if (r5 == 0) goto L73
            goto L78
        L73:
            java.lang.String r8 = com.acse.ottn.util.A.f6686e     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = "\u90fd\u6ca1\u6709\u627e\u5230"
            goto L8a
        L78:
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1442n.c()     // Catch: java.lang.Exception -> L8e
            r1.a(r2)     // Catch: java.lang.Exception -> L8e
            com.acse.ottn.util.n r1 = com.acse.ottn.util.C1442n.c()     // Catch: java.lang.Exception -> L8e
            r1.d(r8)     // Catch: java.lang.Exception -> L8e
            java.lang.String r8 = com.acse.ottn.util.A.f6686e     // Catch: java.lang.Exception -> L8e
            java.lang.String r1 = "\u627e\u5230"
        L8a:
            com.acse.ottn.util.ra.a(r8, r1)     // Catch: java.lang.Exception -> L8e
            goto L8f
        L8e:
        L8f:
            com.acse.ottn.util.ba r8 = com.acse.ottn.util.C1419ba.a()
            if (r8 == 0) goto L9d
            com.acse.ottn.util.ba r8 = com.acse.ottn.util.C1419ba.a()
            r1 = 0
            r8.a(r0, r1)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.util.A.a(android.accessibilityservice.AccessibilityService):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x00ab A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00ac A[Catch: Exception -> 0x0860, TRY_LEAVE, TryCatch #0 {Exception -> 0x0860, blocks: (B:9:0x0019, B:11:0x0027, B:13:0x002f, B:15:0x0035, B:36:0x00b5, B:38:0x00be, B:40:0x00d4, B:43:0x00ec, B:45:0x00fe, B:47:0x010f, B:49:0x0115, B:51:0x011b, B:52:0x0120, B:54:0x0128, B:56:0x0132, B:59:0x0146, B:61:0x0152, B:63:0x015e, B:66:0x016c, B:68:0x0178, B:71:0x0186, B:73:0x0192, B:75:0x019e, B:78:0x01ac, B:80:0x01b8, B:82:0x01c0, B:84:0x01c8, B:86:0x01cc, B:87:0x01d9, B:374:0x0790, B:413:0x085c, B:88:0x01dd, B:90:0x01e9, B:92:0x01f1, B:94:0x01f9, B:96:0x01fd, B:97:0x020b, B:99:0x0217, B:101:0x021f, B:103:0x0227, B:105:0x022b, B:106:0x0239, B:108:0x0245, B:111:0x0253, B:113:0x025f, B:115:0x0267, B:117:0x026f, B:119:0x0273, B:120:0x0282, B:122:0x028e, B:124:0x0296, B:126:0x029e, B:128:0x02a2, B:129:0x02b1, B:131:0x02bd, B:133:0x02c5, B:135:0x02cd, B:137:0x02d1, B:138:0x02e0, B:140:0x02ec, B:142:0x02f4, B:144:0x02fc, B:402:0x0829, B:147:0x0312, B:149:0x031e, B:151:0x0326, B:153:0x032e, B:155:0x0332, B:156:0x0341, B:158:0x034d, B:160:0x0355, B:162:0x035d, B:164:0x0361, B:165:0x0370, B:167:0x037c, B:170:0x038a, B:172:0x0396, B:174:0x039e, B:176:0x03a6, B:178:0x03aa, B:179:0x03b9, B:182:0x03c7, B:184:0x03cf, B:186:0x03d7, B:187:0x03e8, B:189:0x03f4, B:191:0x03fc, B:193:0x0404, B:195:0x0408, B:196:0x0417, B:198:0x0423, B:200:0x042f, B:202:0x043b, B:205:0x0449, B:207:0x0455, B:209:0x045d, B:211:0x0465, B:213:0x0469, B:214:0x0478, B:216:0x0484, B:218:0x0490, B:221:0x049e, B:223:0x04aa, B:226:0x04b8, B:228:0x04c4, B:230:0x04d0, B:233:0x04de, B:235:0x04ea, B:237:0x04f2, B:239:0x04fa, B:241:0x04fe, B:242:0x050a, B:244:0x0516, B:246:0x051e, B:248:0x0526, B:250:0x052a, B:251:0x0539, B:253:0x0545, B:255:0x054d, B:257:0x0555, B:259:0x0559, B:260:0x0568, B:262:0x0574, B:264:0x057c, B:266:0x0584, B:268:0x0588, B:269:0x0597, B:271:0x05a3, B:273:0x05ab, B:275:0x05b3, B:277:0x05b7, B:280:0x05c8, B:284:0x05d2, B:287:0x05da, B:291:0x05e4, B:293:0x05ea, B:295:0x05f4, B:296:0x0600, B:299:0x060c, B:302:0x0618, B:304:0x0626, B:306:0x0637, B:308:0x063d, B:310:0x0643, B:312:0x0649, B:314:0x064f, B:315:0x0658, B:412:0x0859, B:316:0x065c, B:318:0x0666, B:319:0x0672, B:321:0x067a, B:323:0x0682, B:325:0x0686, B:326:0x0695, B:328:0x069d, B:330:0x06a5, B:332:0x06a9, B:333:0x06b8, B:335:0x06c0, B:337:0x06c8, B:339:0x06ce, B:341:0x06d4, B:343:0x06e4, B:346:0x0701, B:348:0x0707, B:350:0x070d, B:352:0x0715, B:354:0x071d, B:355:0x072e, B:357:0x0736, B:359:0x073e, B:361:0x0742, B:362:0x0751, B:364:0x0759, B:366:0x0761, B:368:0x0765, B:369:0x0774, B:371:0x077c, B:373:0x0784, B:375:0x0795, B:377:0x079d, B:379:0x07a5, B:381:0x07af, B:383:0x07b5, B:384:0x07b8, B:386:0x07c8, B:389:0x07e2, B:391:0x07ec, B:393:0x07f2, B:394:0x07f5, B:396:0x0809, B:398:0x0811, B:403:0x082d, B:406:0x0838, B:409:0x0843, B:411:0x0851, B:17:0x003b, B:20:0x0041, B:22:0x005e, B:30:0x008c, B:33:0x00ac, B:35:0x00b2, B:23:0x0063, B:25:0x0069, B:27:0x006f, B:29:0x0078), top: B:418:0x0019 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(android.accessibilityservice.AccessibilityService r9, android.view.accessibility.AccessibilityEvent r10) {
        /*
            Method dump skipped, instructions count: 2159
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.acse.ottn.util.A.a(android.accessibilityservice.AccessibilityService, android.view.accessibility.AccessibilityEvent):void");
    }

    public void a(AccessibilityService accessibilityService, AccessiblityModel accessiblityModel) {
        ra.a(f6686e, "couponCountDown ");
        TimerTask timerTask = this.f6694m;
        if (timerTask != null) {
            timerTask.cancel();
            this.f6694m = null;
        }
        if (!TextUtils.isEmpty(accessiblityModel.getData().getSpop_describe())) {
            b().a(this.f6695n, accessiblityModel.getData().getSpop_describe());
        }
        this.f6694m = S.a().b(accessiblityModel.getData().getShow_coupon_time(), 1000, new C1453y(this, accessiblityModel, accessibilityService));
    }

    public void a(AccessibilityService accessibilityService, String str) {
        if (str.length() < 10) {
            return;
        }
        String str2 = f6686e;
        ra.a(str2, "getJDTitleId = " + str);
        try {
            AccessibilityNodeInfo a4 = C1442n.c().a(accessibilityService, str, true);
            if (a4 == null) {
                ra.a(f6686e, "nodeInfo = null");
                return;
            }
            String viewIdResourceName = Build.VERSION.SDK_INT >= 18 ? a4.getViewIdResourceName() : "";
            String str3 = f6686e;
            StringBuilder sb = new StringBuilder();
            sb.append("getJDTitleId jd id is ");
            sb.append(viewIdResourceName);
            ra.a(str3, sb.toString());
            if (TextUtils.isEmpty(viewIdResourceName)) {
                return;
            }
            C1419ba.a().b("jd_view_id", viewIdResourceName);
        } catch (Exception e4) {
            String str4 = f6686e;
            ra.a(str4, "getViewId Exception e =" + e4.getMessage());
        }
    }

    @SuppressLint({"NewApi"})
    public void a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                    if (accessibilityNodeInfo.getChild(i4) != null) {
                        a(accessibilityNodeInfo.getChild(i4), str);
                    }
                }
            }
        } else if (accessibilityNodeInfo.getText() != null) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            if (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().length() > 10 && V.a().b(trim, 5)) {
                this.f6692k.add(accessibilityNodeInfo.getContentDescription().toString());
            }
            if (V.a().b(trim, 5)) {
                this.f6692k.add(trim);
            }
        } else if (accessibilityNodeInfo.getContentDescription() != null) {
            String charSequence = accessibilityNodeInfo.getContentDescription().toString();
            if ("1".equals(str)) {
                if (!V.a().b(charSequence, 5)) {
                    return;
                }
            } else if (!V.a().b(charSequence, 5)) {
                return;
            }
            this.f6692k.add(charSequence);
        }
    }

    public void a(AccessiblityModel accessiblityModel, String str) {
        if (1 == accessiblityModel.getR()) {
            if (str.equals(H.a().J)) {
                accessiblityModel.getData().setPackage_name(H.a().J);
            }
            a(this.f6695n, accessiblityModel);
            if ("1".equals(accessiblityModel.getToast_status())) {
                C1419ba a4 = C1419ba.a();
                a4.b("samon_" + accessiblityModel.getGenuine_packagename(), T.d().a());
            } else if ("0".equals(accessiblityModel.getToast_status())) {
                C1419ba a5 = C1419ba.a();
                a5.b("samon_" + str, T.d().a());
            }
        } else if (accessiblityModel.getR() == 0) {
            if ("1".equals(accessiblityModel.getScrolled_screen())) {
                C1419ba.a().b("scroll_state", accessiblityModel.getScrolled_screen());
                C1419ba.a().b("goods_info", accessiblityModel.getProduct_info());
            }
            if (accessiblityModel.getData() != null && !TextUtils.isEmpty(accessiblityModel.getData().getSpop_describe())) {
                b().a(this.f6695n, accessiblityModel.getData().getSpop_describe());
            }
        }
        if ("1".equals(accessiblityModel.getReset_heartbeat())) {
            C1419ba.a().b("appHeartbeat", "");
        }
    }

    public void a(String str, String str2) {
        ra.a(f6686e, "onNoSelectActivity");
        if (str.toLowerCase().contains("android.widget")) {
            return;
        }
        this.f6691j = str2;
    }

    public void a(String str, String str2, int i4, int i5) {
        ra.a(f6686e, "onAdCallBack");
        this.f6691j = str2;
        CommonUtil.isShowConpunInfor = true;
        if (this.f6696o) {
            this.f6696o = false;
            c(str, str2, i4, i5);
        }
    }

    public void b(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        ra.a(f6686e, "initOpenPermission");
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = accessibilityServiceInfo.flags | 16 | 8 | 64;
        accessibilityServiceInfo.notificationTimeout = 300L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    public void b(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        ArrayList arrayList;
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                    if (accessibilityNodeInfo.getChild(i4) != null) {
                        b(accessibilityNodeInfo.getChild(i4), str);
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
                    this.f6693l = V.a().a(charSequence, this.f6693l);
                    if (!V.a().a(this.f6693l)) {
                        List<String> list = this.f6692k;
                        if (list == null) {
                            return;
                        }
                        list.removeAll(list);
                        this.f6692k = null;
                        this.f6693l = 0;
                        arrayList = new ArrayList();
                    }
                    this.f6692k.add(charSequence);
                    return;
                } else if (charSequence.contains("\u6708\u9500") || charSequence.contains("\u5df2\u552e") || charSequence.matches("[1-9]\\d*\\.?\\d*") || charSequence.contains("\uffe5") || charSequence.contains("\u00a5")) {
                    this.f6693l = V.a().a(charSequence, this.f6693l);
                    if (!V.a().a(this.f6693l)) {
                        List<String> list2 = this.f6692k;
                        if (list2 == null) {
                            return;
                        }
                        list2.removeAll(list2);
                        this.f6692k = null;
                        this.f6693l = 0;
                        arrayList = new ArrayList();
                    }
                    this.f6692k.add(charSequence);
                    return;
                } else {
                    return;
                }
            }
            return;
        }
        String trim = accessibilityNodeInfo.getText().toString().trim();
        if (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().length() > 10) {
            this.f6693l = V.a().a(accessibilityNodeInfo.getContentDescription().toString(), this.f6693l);
            if (V.a().a(this.f6693l)) {
                this.f6692k.add(accessibilityNodeInfo.getContentDescription().toString());
            } else {
                List<String> list3 = this.f6692k;
                if (list3 != null) {
                    list3.removeAll(list3);
                    this.f6692k = null;
                    this.f6693l = 0;
                    this.f6692k = new ArrayList();
                }
            }
        }
        this.f6693l = V.a().a(trim, this.f6693l);
        if (V.a().a(this.f6693l)) {
            this.f6692k.add(trim);
            return;
        }
        List<String> list4 = this.f6692k;
        if (list4 == null) {
            return;
        }
        list4.removeAll(list4);
        this.f6692k = null;
        this.f6693l = 0;
        arrayList = new ArrayList();
        this.f6692k = arrayList;
    }

    public void b(String str, String str2, int i4, int i5) {
        ra.a(f6686e, "onSelectActivity");
        CommonUtil.isShowConpunInfor = true;
        this.f6691j = str2;
        c(str, str2, i4, i5);
    }

    public void c(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        ra.a(f6686e, "initOpenPermission");
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 80;
        accessibilityServiceInfo.notificationTimeout = 100L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    public void c(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) {
            if (accessibilityNodeInfo != null) {
                for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                    if (accessibilityNodeInfo.getChild(i4) != null) {
                        c(accessibilityNodeInfo.getChild(i4), str);
                    }
                }
            }
        } else if (accessibilityNodeInfo.getText() != null) {
            String trim = accessibilityNodeInfo.getText().toString().trim();
            if (accessibilityNodeInfo.getContentDescription() != null && accessibilityNodeInfo.getContentDescription().length() > 10) {
                this.f6692k.add(accessibilityNodeInfo.getContentDescription().toString());
            }
            this.f6692k.add(trim);
        } else if (accessibilityNodeInfo.getContentDescription() != null) {
            String charSequence = accessibilityNodeInfo.getContentDescription().toString();
            if ("1".equals(str) || charSequence.contains("\u6708\u9500") || charSequence.contains("\u5df2\u552e") || charSequence.matches("[1-9]\\d*\\.?\\d*") || charSequence.contains("\uffe5") || charSequence.contains("\u00a5")) {
                this.f6692k.add(charSequence);
            }
        }
    }

    public void d(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        ra.a(f6686e, "initReadPageInfo");
        AccessibilityServiceInfo accessibilityServiceInfo = new AccessibilityServiceInfo();
        accessibilityServiceInfo.flags = 90;
        accessibilityServiceInfo.notificationTimeout = 100L;
        accessibilityServiceInfo.feedbackType = -1;
        accessibilityServiceInfo.eventTypes = -1;
        accessibilityService.setServiceInfo(accessibilityServiceInfo);
    }

    public void e(AccessibilityService accessibilityService) {
        ra.a(f6686e, "onStopService");
        Intent intent = this.f6697p;
        if (intent != null) {
            accessibilityService.stopService(intent);
            this.f6697p = null;
        }
    }
}
