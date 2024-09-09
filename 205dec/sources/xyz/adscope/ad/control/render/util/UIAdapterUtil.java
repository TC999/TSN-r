package xyz.adscope.ad.control.render.util;

import android.graphics.Color;
import android.text.TextUtils;
import java.util.regex.Pattern;
import xyz.adscope.ad.AdScopeSDK;
import xyz.adscope.common.tool.utils.SystemUtil;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class UIAdapterUtil {
    private static UIAdapterUtil instance;
    private String darkColor;
    private boolean isInit;
    private boolean isSystemUiDarkMode;
    private String lightColor;
    private int uiMode;
    private String defaultLightColor = "#FFFFFF";
    private String defaultDarkColor = "#000000";

    public static UIAdapterUtil getInstance() {
        if (instance == null) {
            synchronized (UIAdapterUtil.class) {
                if (instance == null) {
                    instance = new UIAdapterUtil();
                }
            }
        }
        return instance;
    }

    private int hexToNumber(String str) {
        return Integer.parseInt(str, 16);
    }

    private boolean isValidHex(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return Pattern.compile("^[A-Fa-f0-9]{2}$").matcher(str).matches();
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    private String numberToHex(int i4) {
        String hexString = Integer.toHexString(i4);
        if (hexString.length() == 1) {
            return "0" + hexString;
        }
        return hexString;
    }

    private int reversalColor(String str) {
        int parseColor = Color.parseColor(str);
        int i4 = (parseColor >> 16) & 255;
        int i5 = (parseColor >> 8) & 255;
        int i6 = parseColor & 255;
        return (i4 == i5 && i4 == i6) ? Color.argb(Color.alpha(parseColor), 255 - i4, 255 - i5, 255 - i6) : parseColor;
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00b6 A[Catch: all -> 0x00dd, TryCatch #0 {all -> 0x00dd, blocks: (B:3:0x0004, B:5:0x0008, B:8:0x000f, B:10:0x0012, B:15:0x0029, B:26:0x005f, B:28:0x0065, B:30:0x006b, B:33:0x0072, B:36:0x0082, B:38:0x0086, B:40:0x00b2, B:42:0x00b6, B:44:0x00c3, B:43:0x00bd, B:19:0x0034, B:23:0x0040, B:24:0x004d), top: B:49:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00bd A[Catch: all -> 0x00dd, TryCatch #0 {all -> 0x00dd, blocks: (B:3:0x0004, B:5:0x0008, B:8:0x000f, B:10:0x0012, B:15:0x0029, B:26:0x005f, B:28:0x0065, B:30:0x006b, B:33:0x0072, B:36:0x0082, B:38:0x0086, B:40:0x00b2, B:42:0x00b6, B:44:0x00c3, B:43:0x00bd, B:19:0x0034, B:23:0x0040, B:24:0x004d), top: B:49:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String autoInterfaceStyleColor(java.lang.String r14) {
        /*
            r13 = this;
            java.lang.String r0 = "#"
            java.lang.String r1 = ""
            int r2 = r13.uiMode     // Catch: java.lang.Throwable -> Ldd
            if (r2 != 0) goto L12
            boolean r0 = r13.isColorValid(r14)     // Catch: java.lang.Throwable -> Ldd
            if (r0 == 0) goto Lf
            return r14
        Lf:
            java.lang.String r14 = r13.lightColor     // Catch: java.lang.Throwable -> Ldd
            return r14
        L12:
            java.lang.String r2 = r14.replace(r0, r1)     // Catch: java.lang.Throwable -> Ldd
            int r3 = r2.length()     // Catch: java.lang.Throwable -> Ldd
            r4 = 0
            java.lang.String r5 = "00"
            r6 = 1
            r7 = 4
            r8 = 2
            r9 = 6
            java.lang.String r10 = "FF"
            if (r3 == r9) goto L4d
            r11 = 8
            if (r3 == r11) goto L34
            int r2 = r13.uiMode     // Catch: java.lang.Throwable -> Ldd
            if (r2 != r6) goto L30
            r2 = r5
            r3 = r2
            goto L5c
        L30:
            r2 = r10
            r3 = r2
            r5 = r3
            goto L5c
        L34:
            java.lang.String r3 = r2.substring(r4, r8)     // Catch: java.lang.Throwable -> Ldd
            boolean r4 = r13.isValidHex(r3)     // Catch: java.lang.Throwable -> Ldd
            if (r4 != 0) goto L3f
            goto L40
        L3f:
            r10 = r3
        L40:
            java.lang.String r3 = r2.substring(r8, r7)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r4 = r2.substring(r7, r9)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r2 = r2.substring(r9, r11)     // Catch: java.lang.Throwable -> Ldd
            goto L5f
        L4d:
            java.lang.String r5 = r2.substring(r4, r8)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r3 = r2.substring(r8, r7)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r2 = r2.substring(r7, r9)     // Catch: java.lang.Throwable -> Ldd
            r12 = r5
            r5 = r2
            r2 = r12
        L5c:
            r4 = r3
            r3 = r2
            r2 = r5
        L5f:
            boolean r5 = r13.isValidHex(r3)     // Catch: java.lang.Throwable -> Ldd
            if (r5 == 0) goto Lb2
            boolean r5 = r13.isValidHex(r4)     // Catch: java.lang.Throwable -> Ldd
            if (r5 == 0) goto Lb2
            boolean r5 = r13.isValidHex(r2)     // Catch: java.lang.Throwable -> Ldd
            if (r5 != 0) goto L72
            goto Lb2
        L72:
            int r3 = r13.hexToNumber(r3)     // Catch: java.lang.Throwable -> Ldd
            int r4 = r13.hexToNumber(r4)     // Catch: java.lang.Throwable -> Ldd
            int r2 = r13.hexToNumber(r2)     // Catch: java.lang.Throwable -> Ldd
            if (r3 != r4) goto Lb1
            if (r4 != r2) goto Lb1
            int r2 = r13.uiMode     // Catch: java.lang.Throwable -> Ldd
            if (r2 != r6) goto Lb1
            int r2 = 255 - r3
            java.lang.String r2 = r13.numberToHex(r2)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r2 = r2.toUpperCase()     // Catch: java.lang.Throwable -> Ldd
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ldd
            r3.<init>()     // Catch: java.lang.Throwable -> Ldd
            r3.append(r0)     // Catch: java.lang.Throwable -> Ldd
            r3.append(r10)     // Catch: java.lang.Throwable -> Ldd
            r3.append(r1)     // Catch: java.lang.Throwable -> Ldd
            r3.append(r2)     // Catch: java.lang.Throwable -> Ldd
            r3.append(r1)     // Catch: java.lang.Throwable -> Ldd
            r3.append(r2)     // Catch: java.lang.Throwable -> Ldd
            r3.append(r1)     // Catch: java.lang.Throwable -> Ldd
            r3.append(r2)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r14 = r3.toString()     // Catch: java.lang.Throwable -> Ldd
        Lb1:
            return r14
        Lb2:
            int r2 = r13.uiMode     // Catch: java.lang.Throwable -> Ldd
            if (r2 != r6) goto Lbd
            java.lang.String r2 = r13.darkColor     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r2 = r2.replace(r0, r1)     // Catch: java.lang.Throwable -> Ldd
            goto Lc3
        Lbd:
            java.lang.String r2 = r13.lightColor     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r2 = r2.replace(r0, r1)     // Catch: java.lang.Throwable -> Ldd
        Lc3:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Ldd
            r3.<init>()     // Catch: java.lang.Throwable -> Ldd
            r3.append(r0)     // Catch: java.lang.Throwable -> Ldd
            r3.append(r10)     // Catch: java.lang.Throwable -> Ldd
            r3.append(r1)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r0 = r2.toUpperCase()     // Catch: java.lang.Throwable -> Ldd
            r3.append(r0)     // Catch: java.lang.Throwable -> Ldd
            java.lang.String r14 = r3.toString()     // Catch: java.lang.Throwable -> Ldd
            return r14
        Ldd:
            r0 = move-exception
            r0.printStackTrace()
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: xyz.adscope.ad.control.render.util.UIAdapterUtil.autoInterfaceStyleColor(java.lang.String):java.lang.String");
    }

    public boolean isColorValid(String str) {
        try {
            return Pattern.compile("^#([A-Fa-f0-9]{6}|[A-Fa-f0-9]{8})$").matcher(str).matches();
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public boolean isDarkMode() {
        return this.uiMode == 1;
    }

    public void setUiStyle(int i4, String str, String str2) {
        if (this.isInit) {
            return;
        }
        this.isInit = true;
        this.uiMode = i4;
        this.lightColor = str;
        this.darkColor = str2;
        if (TextUtils.isEmpty(str)) {
            this.lightColor = this.defaultLightColor;
        }
        if (TextUtils.isEmpty(str2)) {
            this.darkColor = this.defaultDarkColor;
        }
        boolean isDarkUiMode = SystemUtil.isDarkUiMode(AdScopeSDK.getContext());
        this.isSystemUiDarkMode = isDarkUiMode;
        if (i4 == 2 && isDarkUiMode) {
            this.uiMode = 1;
        }
    }
}
