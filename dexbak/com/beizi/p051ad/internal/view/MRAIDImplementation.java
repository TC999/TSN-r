package com.beizi.p051ad.internal.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.util.Base64;
import android.util.Pair;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.beizi.p051ad.AdActivity;
import com.beizi.p051ad.C2750R;
import com.beizi.p051ad.internal.EnumC2888k;
import com.beizi.p051ad.internal.utilities.HaoboLog;
import com.beizi.p051ad.internal.utilities.Hex;
import com.beizi.p051ad.internal.utilities.StringUtil;
import com.beizi.p051ad.internal.utilities.ViewUtil;
import com.beizi.p051ad.internal.utilities.W3CEvent;
import com.beizi.p051ad.internal.view.AdWebView;
import com.beizi.p051ad.lance.p062a.C3019b;
import com.beizi.p051ad.lance.p062a.FileUtil;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import io.netty.handler.codec.http.HttpHeaders;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import javax.mail.Part;

@SuppressLint({"InlinedApi"})
/* renamed from: com.beizi.ad.internal.view.f */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class MRAIDImplementation {

    /* renamed from: a */
    protected static final String[] f10726a = {"default", "expanded"};

    /* renamed from: b */
    protected final AdWebView f10727b;

    /* renamed from: e */
    int f10730e;

    /* renamed from: f */
    int f10731f;

    /* renamed from: g */
    int f10732g;

    /* renamed from: j */
    boolean f10735j;

    /* renamed from: l */
    private int f10737l;

    /* renamed from: m */
    private int f10738m;

    /* renamed from: n */
    private Activity f10739n;

    /* renamed from: o */
    private ViewGroup f10740o;

    /* renamed from: q */
    private int f10742q;

    /* renamed from: k */
    private boolean f10736k = false;

    /* renamed from: c */
    boolean f10728c = false;

    /* renamed from: d */
    boolean f10729d = false;

    /* renamed from: h */
    boolean f10733h = false;

    /* renamed from: i */
    boolean f10734i = false;

    /* renamed from: p */
    private int[] f10741p = new int[4];

    /* renamed from: r */
    private boolean f10743r = false;

    /* renamed from: s */
    private C3015g f10744s = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: MRAIDImplementation.java */
    /* renamed from: com.beizi.ad.internal.view.f$4 */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static /* synthetic */ class C30124 {

        /* renamed from: a */
        static final /* synthetic */ int[] f10751a;

        static {
            int[] iArr = new int[AdActivity.EnumC2742b.values().length];
            f10751a = iArr;
            try {
                iArr[AdActivity.EnumC2742b.landscape.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f10751a[AdActivity.EnumC2742b.portrait.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f10751a[AdActivity.EnumC2742b.none.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* compiled from: MRAIDImplementation.java */
    /* renamed from: com.beizi.ad.internal.view.f$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC3013a {
        top_left,
        top_right,
        center,
        bottom_left,
        bottom_right,
        top_center,
        bottom_center
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: MRAIDImplementation.java */
    /* renamed from: com.beizi.ad.internal.view.f$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public enum EnumC3014b {
        STARTING_DEFAULT,
        STARTING_EXPANDED
    }

    public MRAIDImplementation(AdWebView adWebView) {
        this.f10727b = adWebView;
    }

    /* renamed from: c */
    private void m49106c(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("uri")) {
                str = Uri.decode((String) next.second);
            }
        }
        if (StringUtil.isEmpty(str)) {
            return;
        }
        this.f10727b.m49190b(str);
        this.f10727b.m49189c();
    }

    /* renamed from: d */
    private void m49104d(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("uri")) {
                str = (String) next.second;
            }
        }
        if (str == null) {
            HaoboLog.m49292d(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.store_picture_error));
            return;
        }
        final String decode = Uri.decode(str);
        AlertDialog.Builder builder = new AlertDialog.Builder(ViewUtil.getTopContext(this.f10727b));
        builder.setTitle(C2750R.C2755string.store_picture_title);
        builder.setMessage(C2750R.C2755string.store_picture_message);
        builder.setPositiveButton(C2750R.C2755string.store_picture_accept, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.f.2
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r7v49 */
            @Override // android.content.DialogInterface.OnClickListener
            @SuppressLint({"NewApi"})
            public void onClick(DialogInterface dialogInterface, int i) {
                String str2;
                String string;
                FileOutputStream fileOutputStream;
                int i2;
                int i3;
                byte[] decode2;
                try {
                    if (decode.startsWith("data:")) {
                        boolean contains = decode.contains("image/gif");
                        String str3 = PhotoBitmapUtils.f15141c;
                        if (contains) {
                            str3 = ".gif";
                        } else {
                            if (!decode.contains("image/jpeg") && !decode.contains("image/pjpeg")) {
                                if (!decode.contains("image/png")) {
                                    if (decode.contains("image/tiff")) {
                                        str3 = ".tif";
                                    } else if (decode.contains("image/svg+xml")) {
                                        str3 = ".svg";
                                    }
                                }
                            }
                            str3 = ".jpg";
                        }
                        boolean contains2 = decode.contains(HttpHeaders.Values.BASE64);
                        File m49057b = FileUtil.m49057b(MRAIDImplementation.this.f10727b.getContext());
                        File file = new File(m49057b, System.currentTimeMillis() + str3);
                        FileOutputStream fileOutputStream2 = 0;
                        try {
                            try {
                                fileOutputStream = new FileOutputStream(file);
                                try {
                                    boolean canWrite = file.canWrite();
                                    i2 = canWrite;
                                    if (canWrite) {
                                        if (!contains2) {
                                            String str4 = decode;
                                            int lastIndexOf = str4.lastIndexOf(",") + 1;
                                            decode2 = Hex.hexStringToByteArray(str4.substring(lastIndexOf, decode.length()));
                                            i3 = lastIndexOf;
                                        } else {
                                            String str5 = decode;
                                            i3 = false;
                                            decode2 = Base64.decode(str5.substring(str5.lastIndexOf(",") + 1, decode.length()), 0);
                                        }
                                        fileOutputStream.write(decode2);
                                        i2 = i3;
                                    }
                                } catch (FileNotFoundException unused) {
                                    fileOutputStream2 = fileOutputStream;
                                    HaoboLog.m49292d(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.store_picture_error));
                                    fileOutputStream2 = fileOutputStream2;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                            fileOutputStream2 = fileOutputStream2;
                                        } catch (IOException unused2) {
                                            str2 = HaoboLog.mraidLogTag;
                                            string = HaoboLog.getString(C2750R.C2755string.store_picture_error);
                                            HaoboLog.m49292d(str2, string);
                                            MRAIDImplementation.this.f10727b.m49189c();
                                        }
                                    }
                                    MRAIDImplementation.this.f10727b.m49189c();
                                } catch (IOException unused3) {
                                    fileOutputStream2 = fileOutputStream;
                                    HaoboLog.m49292d(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.store_picture_error));
                                    fileOutputStream2 = fileOutputStream2;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                            fileOutputStream2 = fileOutputStream2;
                                        } catch (IOException unused4) {
                                            str2 = HaoboLog.mraidLogTag;
                                            string = HaoboLog.getString(C2750R.C2755string.store_picture_error);
                                            HaoboLog.m49292d(str2, string);
                                            MRAIDImplementation.this.f10727b.m49189c();
                                        }
                                    }
                                    MRAIDImplementation.this.f10727b.m49189c();
                                } catch (IllegalArgumentException unused5) {
                                    fileOutputStream2 = fileOutputStream;
                                    HaoboLog.m49292d(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.store_picture_error));
                                    fileOutputStream2 = fileOutputStream2;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                            fileOutputStream2 = fileOutputStream2;
                                        } catch (IOException unused6) {
                                            str2 = HaoboLog.mraidLogTag;
                                            string = HaoboLog.getString(C2750R.C2755string.store_picture_error);
                                            HaoboLog.m49292d(str2, string);
                                            MRAIDImplementation.this.f10727b.m49189c();
                                        }
                                    }
                                    MRAIDImplementation.this.f10727b.m49189c();
                                } catch (Throwable th) {
                                    th = th;
                                    fileOutputStream2 = fileOutputStream;
                                    if (fileOutputStream2 != null) {
                                        try {
                                            fileOutputStream2.close();
                                        } catch (IOException unused7) {
                                            HaoboLog.m49292d(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.store_picture_error));
                                        }
                                    }
                                    throw th;
                                }
                            } catch (FileNotFoundException unused8) {
                            } catch (IOException unused9) {
                            } catch (IllegalArgumentException unused10) {
                            }
                            try {
                                fileOutputStream.close();
                                fileOutputStream2 = i2;
                            } catch (IOException unused11) {
                                str2 = HaoboLog.mraidLogTag;
                                string = HaoboLog.getString(C2750R.C2755string.store_picture_error);
                                HaoboLog.m49292d(str2, string);
                                MRAIDImplementation.this.f10727b.m49189c();
                            }
                        } catch (Throwable th2) {
                            th = th2;
                        }
                    }
                    MRAIDImplementation.this.f10727b.m49189c();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        builder.setNegativeButton(C2750R.C2755string.store_picture_decline, new DialogInterface.OnClickListener() { // from class: com.beizi.ad.internal.view.f.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        builder.create().show();
    }

    /* renamed from: e */
    private void m49103e() {
        Activity activity = (Activity) this.f10727b.getContextFromMutableContext();
        this.f10727b.getLocationOnScreen(r2);
        int[] iArr = {0, iArr[1] - activity.getWindow().findViewById(16908290).getTop()};
        this.f10727b.measure(0, 0);
        int[] iArr2 = {this.f10727b.getMeasuredWidth(), this.f10727b.getMeasuredHeight()};
        ViewUtil.convertFromPixelsToDP(activity, iArr2);
        this.f10727b.m49186c(String.format("javascript:window.mraid.util.setDefaultPosition(%d, %d, %d, %d)", Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr2[0]), Integer.valueOf(iArr2[1])));
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0022 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    /* renamed from: f */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m49100f(java.util.ArrayList<android.util.Pair<java.lang.String, java.lang.String>> r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1f
            int r0 = r2.size()     // Catch: java.io.UnsupportedEncodingException -> L1e
            if (r0 <= 0) goto L1f
            r0 = 0
            java.lang.Object r2 = r2.get(r0)     // Catch: java.io.UnsupportedEncodingException -> L1e
            android.util.Pair r2 = (android.util.Pair) r2     // Catch: java.io.UnsupportedEncodingException -> L1e
            java.lang.Object r2 = r2.second     // Catch: java.io.UnsupportedEncodingException -> L1e
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.io.UnsupportedEncodingException -> L1e
            java.lang.String r0 = "UTF-8"
            java.lang.String r2 = java.net.URLDecoder.decode(r2, r0)     // Catch: java.io.UnsupportedEncodingException -> L1e
            com.beizi.ad.internal.utilities.W3CEvent r2 = com.beizi.p051ad.internal.utilities.W3CEvent.createFromJSON(r2)     // Catch: java.io.UnsupportedEncodingException -> L1e
            goto L20
        L1e:
            return
        L1f:
            r2 = 0
        L20:
            if (r2 == 0) goto L44
            android.content.Intent r2 = r2.getInsertIntent()     // Catch: java.lang.Exception -> L44
            r0 = 268435456(0x10000000, float:2.524355E-29)
            r2.setFlags(r0)     // Catch: java.lang.Exception -> L44
            com.beizi.ad.internal.view.AdWebView r0 = r1.f10727b     // Catch: java.lang.Exception -> L44
            android.content.Context r0 = r0.getContext()     // Catch: java.lang.Exception -> L44
            r0.startActivity(r2)     // Catch: java.lang.Exception -> L44
            com.beizi.ad.internal.view.AdWebView r2 = r1.f10727b     // Catch: java.lang.Exception -> L44
            r2.m49189c()     // Catch: java.lang.Exception -> L44
            java.lang.String r2 = com.beizi.p051ad.internal.utilities.HaoboLog.mraidLogTag     // Catch: java.lang.Exception -> L44
            int r0 = com.beizi.p051ad.C2750R.C2755string.create_calendar_event     // Catch: java.lang.Exception -> L44
            java.lang.String r0 = com.beizi.p051ad.internal.utilities.HaoboLog.getString(r0)     // Catch: java.lang.Exception -> L44
            com.beizi.p051ad.internal.utilities.HaoboLog.m49292d(r2, r0)     // Catch: java.lang.Exception -> L44
        L44:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.p051ad.internal.view.MRAIDImplementation.m49100f(java.util.ArrayList):void");
    }

    /* renamed from: g */
    private void m49098g(ArrayList<Pair<String, String>> arrayList) {
        AdActivity.EnumC2742b enumC2742b = AdActivity.EnumC2742b.none;
        Iterator<Pair<String, String>> it = arrayList.iterator();
        int i = 1;
        boolean z = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("allow_orientation_change")) {
                z = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("force_orientation")) {
                enumC2742b = m49113a((String) next.second);
            }
        }
        if (this.f10728c || this.f10727b.adViewImpl.mo49147e()) {
            AdWebView adWebView = this.f10727b;
            Activity m49107c = adWebView.f10625a ? m49107c() : (Activity) ViewUtil.getTopContext(adWebView);
            if (z) {
                AdActivity.m50211b(m49107c);
                return;
            }
            int i2 = C30124.f10751a[enumC2742b.ordinal()];
            if (i2 == 1) {
                i = 2;
            } else if (i2 != 2) {
                i = 0;
            }
            AdActivity.m50213a(m49107c, i);
        }
    }

    /* renamed from: h */
    private void m49097h(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        int i = 0;
        int i2 = -1;
        String str = "top-right";
        int i3 = -1;
        int i4 = 0;
        boolean z = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            try {
                if (((String) next.first).equals(IAdInterListener.AdReqParam.WIDTH)) {
                    i2 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("h")) {
                    i3 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("offset_x")) {
                    i = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("offset_y")) {
                    i4 = Integer.parseInt((String) next.second);
                } else if (((String) next.first).equals("custom_close_position")) {
                    str = (String) next.second;
                } else if (((String) next.first).equals("allow_offscreen")) {
                    z = Boolean.parseBoolean((String) next.second);
                }
            } catch (NumberFormatException unused) {
                HaoboLog.m49292d(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.number_format));
                return;
            }
        }
        if (i2 > this.f10737l && i3 > this.f10738m) {
            this.f10727b.m49186c("javascript:mraid.util.errorEvent('Resize called with resizeProperties larger than the screen.', 'mraid.resize()')");
            return;
        }
        EnumC3013a enumC3013a = EnumC3013a.top_right;
        try {
            enumC3013a = EnumC3013a.valueOf(str.replace('-', '_'));
        } catch (IllegalArgumentException unused2) {
        }
        int i5 = i2;
        int i6 = i3;
        int i7 = i;
        int i8 = i4;
        boolean z2 = z;
        HaoboLog.m49292d(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.resize, i5, i6, i7, i8, str, z2));
        this.f10727b.resize(i5, i6, i7, i8, enumC3013a, z2);
        this.f10727b.m49189c();
        this.f10727b.m49186c("javascript:window.mraid.util.stateChangeEvent('resized');");
        this.f10729d = true;
    }

    /* renamed from: b */
    void m49108b(ArrayList<Pair<String, String>> arrayList) {
        AdActivity.EnumC2742b enumC2742b = AdActivity.EnumC2742b.none;
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        final AdActivity.EnumC2742b enumC2742b2 = enumC2742b;
        int i = -1;
        int i2 = -1;
        boolean z = false;
        final boolean z2 = true;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals(IAdInterListener.AdReqParam.WIDTH)) {
                try {
                    i = Integer.parseInt((String) next.second);
                } catch (NumberFormatException unused) {
                }
            } else if (((String) next.first).equals("h")) {
                i2 = Integer.parseInt((String) next.second);
            } else if (((String) next.first).equals("useCustomClose")) {
                z = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("url")) {
                str = Uri.decode((String) next.second);
            } else if (((String) next.first).equals("allow_orientation_change")) {
                z2 = Boolean.parseBoolean((String) next.second);
            } else if (((String) next.first).equals("force_orientation")) {
                enumC2742b2 = m49113a((String) next.second);
            }
        }
        if (!StringUtil.isEmpty(str)) {
            try {
                C3015g c3015g = new C3015g(this.f10727b.adViewImpl, this);
                this.f10744s = c3015g;
                c3015g.m49195a(str);
                this.f10727b.adViewImpl.m49244a(this.f10744s.getMRAIDImplementation(), z, new AdWebView.InterfaceC2992b() { // from class: com.beizi.ad.internal.view.f.1
                    @Override // com.beizi.p051ad.internal.view.AdWebView.InterfaceC2992b
                    /* renamed from: a */
                    public void mo49096a() {
                        if (MRAIDImplementation.this.m49107c() != null) {
                            MRAIDImplementation.this.f10744s.m49204a(MRAIDImplementation.this.m49107c(), z2, enumC2742b2);
                            AdViewImpl.setMRAIDFullscreenListener(null);
                        }
                    }
                });
            } catch (Exception e) {
                String str2 = HaoboLog.baseLogTag;
                HaoboLog.m49290e(str2, "Exception initializing the redirect webview: " + e.getMessage());
            }
        } else {
            this.f10727b.m49205a(i, i2, z, this, z2, enumC2742b2);
        }
        this.f10727b.m49186c("javascript:window.mraid.util.stateChangeEvent('expanded');");
        this.f10728c = true;
        if (this.f10727b.adViewImpl.mo49147e()) {
            return;
        }
        this.f10727b.adViewImpl.getAdDispatcher().mo49213c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49116a(AdWebView adWebView, String str) {
        if (this.f10736k) {
            return;
        }
        String str2 = this.f10727b.adViewImpl.mo49148d() ? Part.INLINE : MediationConstant.RIT_TYPE_INTERSTITIAL;
        boolean equals = str.equals(f10726a[EnumC3014b.STARTING_EXPANDED.ordinal()]);
        this.f10743r = equals;
        this.f10727b.f10625a = equals;
        adWebView.m49186c("javascript:window.mraid.util.setPlacementType('" + str2 + "')");
        if (!this.f10743r) {
            m49117a(adWebView);
            m49099g();
            m49101f();
            m49103e();
        }
        this.f10727b.m49179f();
        adWebView.m49186c("javascript:window.mraid.util.stateChangeEvent('" + str + "')");
        adWebView.m49186c("javascript:window.mraid.util.readyEvent();");
        this.f10730e = this.f10727b.getLayoutParams().width;
        this.f10731f = this.f10727b.getLayoutParams().height;
        if (this.f10727b.adViewImpl.getMediaType().equals(EnumC2888k.BANNER)) {
            this.f10732g = ((FrameLayout.LayoutParams) this.f10727b.getLayoutParams()).gravity;
        }
        this.f10736k = true;
        m49110a(this.f10727b.m49176g());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public Activity m49107c() {
        return this.f10739n;
    }

    /* renamed from: f */
    private void m49101f() {
        if (this.f10727b.getContextFromMutableContext() instanceof Activity) {
            Activity activity = (Activity) this.f10727b.getContextFromMutableContext();
            int[] screenSizeAsPixels = ViewUtil.getScreenSizeAsPixels(activity);
            int i = screenSizeAsPixels[0];
            float f = activity.getResources().getDisplayMetrics().density;
            int i2 = (int) ((i / f) + 0.5f);
            AdWebView adWebView = this.f10727b;
            adWebView.m49186c("javascript:window.mraid.util.setMaxSize(" + i2 + ", " + ((int) (((screenSizeAsPixels[1] - activity.getWindow().findViewById(16908290).getTop()) / f) + 0.5f)) + ")");
        }
    }

    /* renamed from: e */
    private void m49102e(ArrayList<Pair<String, String>> arrayList) {
        Iterator<Pair<String, String>> it = arrayList.iterator();
        String str = null;
        while (it.hasNext()) {
            Pair<String, String> next = it.next();
            if (((String) next.first).equals("uri")) {
                str = (String) next.second;
            }
        }
        if (str == null) {
            HaoboLog.m49292d(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.play_vide_no_uri));
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(268435456);
        try {
            intent.setDataAndType(Uri.parse(URLDecoder.decode(str, "UTF-8")), "video/mp4");
            try {
                this.f10727b.getContext().startActivity(intent);
                this.f10727b.m49189c();
            } catch (Exception unused) {
            }
        } catch (UnsupportedEncodingException unused2) {
            HaoboLog.m49292d(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.unsupported_encoding));
        }
    }

    /* renamed from: g */
    private void m49099g() {
        if (this.f10727b.getContextFromMutableContext() instanceof Activity) {
            int[] screenSizeAsDP = ViewUtil.getScreenSizeAsDP((Activity) this.f10727b.getContextFromMutableContext());
            this.f10737l = screenSizeAsDP[0];
            this.f10738m = screenSizeAsDP[1];
            AdWebView adWebView = this.f10727b;
            adWebView.m49186c("javascript:window.mraid.util.setScreenSize(" + this.f10737l + ", " + this.f10738m + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: d */
    public ViewGroup m49105d() {
        return this.f10740o;
    }

    /* renamed from: a */
    private void m49115a(AdWebView adWebView, String str, boolean z) {
        adWebView.m49186c(String.format("javascript:window.mraid.util.setSupports('%s', %s)", str, String.valueOf(z)));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m49117a(AdWebView adWebView) {
        if (m49119a(new Intent("android.intent.action.VIEW", Uri.parse("sms:5555555555")))) {
            m49115a(adWebView, "sms", true);
        }
        if (m49119a(new Intent("android.intent.action.VIEW", Uri.parse("tel:5555555555")))) {
            m49115a(adWebView, "tel", true);
        }
        try {
            if (m49119a(new Intent("android.intent.action.EDIT").setData(Uri.parse(C3019b.m49089a("Y29udGVudDovL2NvbS5hbmRyb2lkLmNhbGVuZGFyL2V2ZW50cw=="))))) {
                m49115a(adWebView, "calendar", true);
                this.f10734i = true;
            } else if (m49119a(new Intent("android.intent.action.EDIT").setType("vnd.android.cursor.item/event"))) {
                m49115a(adWebView, "calendar", true);
                this.f10734i = true;
                W3CEvent.useMIME = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        m49115a(adWebView, "inlineVideo", true);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public void m49109b() {
        boolean m49176g = this.f10727b.m49176g();
        if (this.f10735j != m49176g) {
            m49110a(m49176g);
        }
    }

    /* renamed from: a */
    boolean m49119a(Intent intent) {
        return this.f10727b.getContext().getPackageManager().queryIntentActivities(intent, 0).size() > 0;
    }

    /* renamed from: a */
    void m49110a(boolean z) {
        if (this.f10736k) {
            this.f10735j = z;
            AdWebView adWebView = this.f10727b;
            adWebView.m49186c("javascript:window.mraid.util.setIsViewable(" + z + ")");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49121a(int i, int i2, int i3, int i4) {
        int[] iArr = this.f10741p;
        if (iArr[0] == i && iArr[1] == i2 && iArr[2] == i3 && iArr[3] == i4) {
            return;
        }
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        Activity activity = (Activity) this.f10727b.getContextFromMutableContext();
        int[] iArr2 = {i, i2 - activity.getWindow().findViewById(16908290).getTop(), i3, i4};
        ViewUtil.convertFromPixelsToDP(activity, iArr2);
        int i5 = iArr2[0];
        int i6 = iArr2[1];
        int i7 = iArr2[2];
        int i8 = iArr2[3];
        this.f10727b.m49186c(String.format("javascript:window.mraid.util.setCurrentPosition(%d, %d, %d, %d)", Integer.valueOf(i5), Integer.valueOf(i6), Integer.valueOf(i7), Integer.valueOf(i8)));
        this.f10727b.m49186c(String.format("javascript:window.mraid.util.sizeChangeEvent(%d, %d)", Integer.valueOf(i7), Integer.valueOf(i8)));
    }

    /* renamed from: a */
    public void m49123a() {
        if (!this.f10728c && !this.f10729d && !this.f10743r) {
            if (this.f10727b.adViewImpl.mo49147e()) {
                this.f10727b.adViewImpl.getAdDispatcher().mo49214b();
                Activity activity = (Activity) this.f10727b.getContextFromMutableContext();
                if (activity == null || activity.isFinishing()) {
                    return;
                }
                activity.finish();
                return;
            }
            this.f10727b.m49185d();
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(this.f10727b.getLayoutParams());
        layoutParams.height = this.f10731f;
        layoutParams.width = this.f10730e;
        if (this.f10727b.adViewImpl.getMediaType().equals(EnumC2888k.BANNER)) {
            layoutParams.gravity = this.f10732g;
        } else {
            layoutParams.gravity = 17;
        }
        this.f10727b.setLayoutParams(layoutParams);
        this.f10727b.mo49095e();
        this.f10727b.m49186c("javascript:window.mraid.util.stateChangeEvent('default');");
        if (!this.f10727b.adViewImpl.mo49147e() && !this.f10743r) {
            this.f10727b.adViewImpl.getAdDispatcher().mo49214b();
        }
        Activity activity2 = (Activity) this.f10727b.getContextFromMutableContext();
        if (activity2 != null) {
            activity2.setRequestedOrientation(-1);
        }
        this.f10728c = false;
        this.f10729d = false;
        this.f10744s = null;
    }

    /* renamed from: a */
    void m49111a(ArrayList<Pair<String, String>> arrayList) {
        this.f10727b.setMRAIDUseCustomClose(Boolean.parseBoolean((String) arrayList.get(0).second));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49112a(String str, boolean z) {
        String replaceFirst = str.replaceFirst("mraid://", "");
        String[] split = replaceFirst.split("\\?");
        String replaceAll = split[0].replaceAll("/", "");
        ArrayList<Pair<String, String>> arrayList = new ArrayList<>();
        if (split.length > 1) {
            for (String str2 : replaceFirst.substring(replaceFirst.indexOf("?") + 1).split("&")) {
                String[] split2 = str2.split("=");
                if (split2.length >= 2 && !StringUtil.isEmpty(split2[1]) && !"undefined".equals(split2[1])) {
                    arrayList.add(new Pair<>(split2[0], split2[1]));
                }
            }
        }
        if (replaceAll.equals("expand")) {
            if (z) {
                m49108b(arrayList);
            } else {
                HaoboLog.m49284w(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.no_user_interaction, replaceFirst));
            }
        } else if (replaceAll.equals("close")) {
            m49123a();
        } else if (replaceAll.equals("resize")) {
            if (z) {
                m49097h(arrayList);
            } else {
                HaoboLog.m49284w(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.no_user_interaction, replaceFirst));
            }
        } else if (replaceAll.equals("setOrientationProperties")) {
            m49098g(arrayList);
        } else if (this.f10734i && replaceAll.equals("createCalendarEvent")) {
            if (z) {
                m49100f(arrayList);
            } else {
                HaoboLog.m49284w(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.no_user_interaction, replaceFirst));
            }
        } else if (replaceAll.equals("playVideo")) {
            if (z) {
                m49102e(arrayList);
            } else {
                HaoboLog.m49284w(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.no_user_interaction, replaceFirst));
            }
        } else if (this.f10733h && replaceAll.equals("storePicture")) {
            if (z) {
                m49104d(arrayList);
            } else {
                HaoboLog.m49284w(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.no_user_interaction, replaceFirst));
            }
        } else if (replaceAll.equals("open")) {
            if (z) {
                m49106c(arrayList);
            } else {
                HaoboLog.m49284w(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.no_user_interaction, replaceFirst));
            }
        } else if (replaceAll.equals("setUseCustomClose")) {
            m49111a(arrayList);
        } else if (!replaceAll.equals("enable")) {
            HaoboLog.m49292d(HaoboLog.mraidLogTag, HaoboLog.getString(C2750R.C2755string.unsupported_mraid, replaceAll));
        }
    }

    /* renamed from: a */
    private AdActivity.EnumC2742b m49113a(String str) {
        AdActivity.EnumC2742b enumC2742b = AdActivity.EnumC2742b.none;
        if (str.equals("landscape")) {
            return AdActivity.EnumC2742b.landscape;
        }
        return str.equals("portrait") ? AdActivity.EnumC2742b.portrait : enumC2742b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49122a(int i) {
        if (this.f10742q != i) {
            this.f10742q = i;
            m49101f();
            m49099g();
        }
    }

    /* renamed from: a */
    public void m49120a(Activity activity) {
        this.f10739n = activity;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m49118a(ViewGroup viewGroup) {
        this.f10740o = viewGroup;
    }
}
