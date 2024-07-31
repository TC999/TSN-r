package cn.bluemobi.dylan.base.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.net.Uri;
import android.os.Environment;
import android.text.Editable;
import android.text.Html;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.format.DateFormat;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.baidu.mobads.sdk.internal.C2658ck;
import com.bxkj.base.p085v2.common.utils.PhotoBitmapUtils;
import com.github.mikephil.charting.utils.Utils;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.Pattern;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* renamed from: cn.bluemobi.dylan.base.utils.u */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class Tools {

    /* renamed from: a */
    static Toast f1851a;

    /* compiled from: Tools.java */
    /* renamed from: cn.bluemobi.dylan.base.utils.u$a  reason: invalid class name */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class animationAnimation$AnimationListenerC1147a implements Animation.AnimationListener {

        /* renamed from: a */
        final /* synthetic */ View f1852a;

        animationAnimation$AnimationListenerC1147a(View view) {
            this.f1852a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f1852a.setEnabled(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f1852a.setEnabled(false);
        }
    }

    /* compiled from: Tools.java */
    /* renamed from: cn.bluemobi.dylan.base.utils.u$b */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    static class C1148b extends TimerTask {

        /* renamed from: a */
        final /* synthetic */ EditText f1853a;

        /* renamed from: b */
        final /* synthetic */ String f1854b;

        C1148b(EditText editText, String str) {
            this.f1853a = editText;
            this.f1854b = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1853a.getContext().getSystemService("input_method");
            if (this.f1854b.equals("open")) {
                inputMethodManager.showSoftInput(this.f1853a, 2);
            } else {
                inputMethodManager.hideSoftInputFromWindow(this.f1853a.getWindowToken(), 0);
            }
        }
    }

    /* compiled from: Tools.java */
    /* renamed from: cn.bluemobi.dylan.base.utils.u$c */
    /* loaded from: E:\fuckcool\tsn\6276784.dex */
    class C1149c implements TextWatcher {

        /* renamed from: a */
        final /* synthetic */ EditText f1855a;

        /* renamed from: b */
        final /* synthetic */ int f1856b;

        C1149c(EditText editText, int i) {
            this.f1855a = editText;
            this.f1856b = i;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = this.f1855a.getText().toString();
            if (obj.contains(".") && (obj.length() - 1) - obj.indexOf(".") > this.f1856b) {
                obj = obj.substring(0, obj.indexOf(".") + this.f1856b + 1);
                this.f1855a.setText(obj);
                this.f1855a.setSelection(obj.length());
            }
            if (obj.trim().substring(0).equals(".")) {
                obj = "0" + obj;
                this.f1855a.setText(obj);
                this.f1855a.setSelection(2);
            }
            if (!obj.toString().startsWith("0") || obj.trim().length() <= 1 || obj.substring(1, 2).equals(".")) {
                return;
            }
            this.f1855a.setText(obj.subSequence(0, 1));
            this.f1855a.setSelection(1);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }
    }

    /* renamed from: A */
    public static String m57652A(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        Cursor query = contentResolver.query(uri, null, null, null, null);
        query.moveToFirst();
        String string = query.getString(1);
        query.close();
        return string;
    }

    /* renamed from: A0 */
    public static boolean m57651A0(String str) {
        if (m57617b0(str)) {
            return false;
        }
        return str.matches("[\\u4E00-\\u9FA5]{2,4}");
    }

    /* renamed from: B */
    public static String m57650B(long j) {
        return DateFormat.format("MM月dd日", j * 1000).toString();
    }

    /* renamed from: B0 */
    public static boolean m57649B0(String str) {
        return !m57627T(str) && str.trim().length() >= 6 && str.trim().length() <= 16;
    }

    /* renamed from: C */
    public static String m57648C(long j) {
        return DateFormat.format("kk:mm:ss", j * 1000).toString();
    }

    /* renamed from: C0 */
    public static boolean m57647C0(String str) {
        if (m57617b0(str)) {
            return false;
        }
        return str.matches("^1[1,2,3,4,5,6,7,8,9]+\\d{9}$");
    }

    /* renamed from: D */
    public static String m57646D(long j) {
        return DateFormat.format("MM-dd", j * 1000).toString();
    }

    /* renamed from: D0 */
    public static int m57645D0(String str) {
        if (m57647C0(str)) {
            return 1;
        }
        return m57571y0(str) ? 2 : 0;
    }

    /* renamed from: E */
    public static String m57644E(long j) {
        return DateFormat.format("kk:mm", j * 1000).toString();
    }

    /* renamed from: E0 */
    public static boolean m57643E0(String str) {
        if (m57617b0(str)) {
            return false;
        }
        return str.matches("^(\\d{11})$|^(\\d{3,5}[-]?\\d{6,8})$");
    }

    /* renamed from: F */
    public static String m57642F(long j) {
        return DateFormat.format("yy-MM-dd HH:mm", j * 1000).toString();
    }

    /* renamed from: F0 */
    public static boolean m57641F0(String str) {
        if (m57617b0(str)) {
            return false;
        }
        return str.matches("^[a-zA-Z\\d_]+$");
    }

    /* renamed from: G */
    public static String m57640G(int i) {
        int i2;
        String str = "";
        if (i > 99 || i == 0) {
            return "";
        }
        int i3 = (i - (i % 10)) / 10;
        if (i3 != 0) {
            if (i3 == 1) {
                str = "十";
            } else {
                str = m57639H(i3) + "十";
            }
        }
        return str + m57639H(i2);
    }

    /* renamed from: H */
    public static String m57639H(int i) {
        return new String[]{"", "一", "二", "三", "四", "五", "六", "七", "八", "九"}[i];
    }

    /* renamed from: I */
    public static int m57638I(Context context, int i, int i2, int i3) {
        return ((m57636K(context)[0] - m57620a(i, context)) - (m57620a(i2, context) * (i3 - 1))) / i3;
    }

    /* renamed from: J */
    public static String m57637J(long j) {
        return DateFormat.format(PhotoBitmapUtils.f15140b, j).toString();
    }

    /* renamed from: K */
    public static int[] m57636K(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    /* renamed from: L */
    public static String m57635L(View view) {
        try {
            return view.getTag().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: M */
    public static String m57634M(EditText editText) {
        return editText != null ? editText.getText().toString().trim() : "";
    }

    /* renamed from: N */
    public static String m57633N(TextView textView) {
        return textView != null ? textView.getText().toString().trim() : "";
    }

    /* renamed from: O */
    public static String m57632O(Map<String, Object> map, String str) {
        if (map == null || map.size() == 0 || m57617b0(str) || !map.containsKey(str)) {
            return "";
        }
        if (map.get(str) instanceof String) {
            return m57609f0((String) map.get(str)) ? "" : map.get(str).toString();
        }
        return String.valueOf(map.get(str));
    }

    /* renamed from: P */
    public static int m57631P(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: Q */
    public static String m57630Q(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    /* renamed from: R */
    public static int m57629R(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(3);
    }

    /* renamed from: S */
    public static void m57628S(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
    }

    /* renamed from: T */
    public static boolean m57627T(String str) {
        if (m57617b0(str)) {
            return false;
        }
        return Pattern.compile("[一-龥]").matcher(str).find();
    }

    /* renamed from: U */
    public static boolean m57626U(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    /* renamed from: V */
    public static boolean m57625V(List list) {
        return list == null || list.size() == 0;
    }

    /* renamed from: W */
    public static boolean m57624W(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    /* renamed from: X */
    public static boolean m57623X(List... listArr) {
        for (List list : listArr) {
            if (m57625V(list)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Y */
    public static boolean m57622Y(Object[]... objArr) {
        for (Object[] objArr2 : objArr) {
            if (m57624W(objArr2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: Z */
    public static boolean m57621Z(EditText editText) {
        return editText == null || m57617b0(m57634M(editText));
    }

    /* renamed from: a */
    public static int m57620a(float f, Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d = f * displayMetrics.density;
        Double.isNaN(d);
        return (int) (d + 0.5d);
    }

    /* renamed from: a0 */
    public static boolean m57619a0(TextView textView) {
        return textView == null || m57617b0(m57633N(textView));
    }

    /* renamed from: b */
    public static void m57618b(EditText editText, String str) {
        new Timer().schedule(new C1148b(editText, str), 300L);
    }

    /* renamed from: b0 */
    public static boolean m57617b0(String str) {
        return str == null || str.equals("") || str.equalsIgnoreCase("null");
    }

    /* renamed from: c */
    public static String m57616c(List list) {
        return Pattern.compile("\\b([\\w\\W])\\b").matcher(list.toString().substring(1, list.toString().length() - 1)).replaceAll("$1").replaceAll(",", " ");
    }

    /* renamed from: c0 */
    public static boolean m57615c0(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == null || m57617b0(list.get(i))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public static void m57614d(String str) {
        if (str == null) {
            str = "传进来的是null";
        }
        Log.i("logs", str);
    }

    /* renamed from: d0 */
    public static boolean m57613d0(TextView... textViewArr) {
        for (int i = 0; i < textViewArr.length; i++) {
            if (textViewArr[i] == null || m57617b0(m57633N(textViewArr[i]))) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: e */
    public static String m57612e(Map<String, Object> map, String str) {
        return (!map.containsKey(str) || map.get(str) == null || "".equals(map.get(str))) ? "" : ((String) map.get(str)).trim();
    }

    /* renamed from: e0 */
    public static boolean m57611e0(String... strArr) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i] == null || strArr[i].equals("") || strArr[i].equalsIgnoreCase("null")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: f */
    public static int[] m57610f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    /* renamed from: f0 */
    public static boolean m57609f0(String str) {
        return str == null || str.equals("");
    }

    /* renamed from: g */
    public static float m57608g(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    /* renamed from: g0 */
    public static boolean m57607g0(String str) {
        return str != null && str.startsWith("http://");
    }

    /* renamed from: h */
    public static int m57606h(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    /* renamed from: h0 */
    public static boolean m57605h0() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* renamed from: i */
    public static void m57604i(Context context, int i) {
        if (context != null) {
            m57602j(context, context.getString(i));
        }
    }

    /* renamed from: i0 */
    public static boolean m57603i0(String str, String str2) {
        return str != null && str.equals(str2);
    }

    /* renamed from: j */
    public static void m57602j(Context context, String str) {
        if (str != null) {
            Toast.makeText(context, str, 0).show();
        }
    }

    /* renamed from: j0 */
    public static void m57601j0(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    /* renamed from: k */
    public static String m57600k(String str) {
        if (str == null || str.length() != 4) {
            return null;
        }
        return str.substring(0, 2) + ":" + str.substring(2, 4);
    }

    /* renamed from: k0 */
    public static String m57599k0(long j) {
        Object valueOf;
        Object valueOf2;
        int i = 0;
        boolean z = j < 0;
        long abs = Math.abs(j) / 1000;
        int i2 = (int) (abs % 60);
        long j2 = abs / 60;
        int i3 = (int) (j2 % 60);
        long j3 = j2 / 60;
        int i4 = (int) j3;
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        decimalFormat.applyPattern("00");
        if (j3 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(z ? "-" : "");
            if (i4 == 0) {
                valueOf = 0;
            } else if (i4 < 10) {
                valueOf = "0" + i4;
            } else {
                valueOf = Integer.valueOf(i4);
            }
            sb.append(valueOf);
            sb.append(":");
            if (i3 == 0) {
                valueOf2 = 0;
            } else if (i3 < 10) {
                valueOf2 = "0" + i3;
            } else {
                valueOf2 = Integer.valueOf(i3);
            }
            sb.append(valueOf2);
            sb.append(":");
            if (i2 != 0) {
                if (i2 < 10) {
                    i = "0" + i2;
                } else {
                    i = Integer.valueOf(i2);
                }
            }
            sb.append(i);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z ? "-" : "");
        sb2.append(i3);
        sb2.append(":");
        sb2.append(decimalFormat.format(i2));
        return sb2.toString();
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0037: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:20:0x0037 */
    /* renamed from: l */
    public static String m57598l(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String m57768b;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (IOException e) {
                    e = e;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.flush();
                            byteArrayOutputStream3.close();
                        } catch (IOException e2) {
                            e2.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    m57768b = C1138b.m57768b(byteArrayOutputStream2.toByteArray());
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                } catch (IOException e3) {
                    e = e3;
                    e.printStackTrace();
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.flush();
                            byteArrayOutputStream2.close();
                            return null;
                        } catch (IOException e4) {
                            e4.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            } else {
                m57768b = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.flush();
                    byteArrayOutputStream3.close();
                } catch (IOException e5) {
                    e5.printStackTrace();
                }
            }
            return m57768b;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }

    /* renamed from: l0 */
    public static Double m57597l0(double d, int i) {
        BigDecimal bigDecimal;
        if (i >= 0) {
            if (Utils.DOUBLE_EPSILON == d) {
                bigDecimal = new BigDecimal(C2658ck.f8834d);
            } else {
                bigDecimal = new BigDecimal(Double.toString(d));
            }
            return Double.valueOf(bigDecimal.divide(new BigDecimal("1"), i, 4).doubleValue());
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    /* renamed from: m */
    public static Date m57596m(Date date, int i) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(6, i);
        return calendar.getTime();
    }

    /* renamed from: m0 */
    public static Bitmap m57595m0(Bitmap bitmap, int i, int i2) {
        float width = i / bitmap.getWidth();
        float height = i2 / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(width, height);
        matrix.postRotate(0.0f);
        return Bitmap.createScaledBitmap(bitmap, i, i2, false);
    }

    /* renamed from: n */
    public static String m57594n(int i) {
        switch (i) {
            case 1:
                return "星期一";
            case 2:
                return "星期二";
            case 3:
                return "星期三";
            case 4:
                return "星期四";
            case 5:
                return "星期五";
            case 6:
                return "星期六";
            case 7:
                return "星期日";
            default:
                return "";
        }
    }

    /* renamed from: n0 */
    public static Spanned m57593n0(String str) {
        return Html.fromHtml("<font color=#000>" + str + "</font>");
    }

    /* renamed from: o */
    public static Bitmap m57592o(Bitmap bitmap) {
        if (bitmap != null) {
            try {
                int width = bitmap.getWidth();
                int height = bitmap.getHeight();
                if (width > height) {
                    bitmap = Bitmap.createBitmap(bitmap, (width - height) / 2, 0, height, height);
                } else {
                    bitmap = Bitmap.createBitmap(bitmap, 0, (height - width) / 2, width, width);
                }
            } catch (Exception unused) {
            }
        }
        return bitmap;
    }

    /* renamed from: p */
    public static String m57590p(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(":", "");
    }

    /* renamed from: p0 */
    public static void m57589p0(Context context, CharSequence charSequence, int i) {
        Toast toast = f1851a;
        if (toast == null) {
            f1851a = Toast.makeText(context, charSequence, i);
        } else {
            toast.setText(charSequence);
        }
        f1851a.show();
    }

    /* renamed from: q */
    public static boolean m57588q() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    /* renamed from: q0 */
    public static void m57587q0(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
    }

    @SuppressLint({"SimpleDateFormat"})
    /* renamed from: r */
    public static String m57586r(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        try {
            return simpleDateFormat.format(simpleDateFormat.parse(str));
        } catch (ParseException e) {
            e.printStackTrace();
            return str;
        }
    }

    /* renamed from: r0 */
    public static void m57585r0(View view, ImageView imageView, int i, int i2, boolean z) {
        if (z) {
            imageView.setBackgroundResource(i2);
        } else {
            imageView.setBackgroundResource(i);
        }
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f, 1, 0.5f, 1, 0.5f);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.2f, 1.0f, 1.2f, 1.0f, 1, 0.5f, 1, 0.5f);
        scaleAnimation.setStartOffset(0L);
        scaleAnimation.setDuration(50L);
        scaleAnimation2.setStartOffset(50L);
        scaleAnimation2.setDuration(50L);
        animationSet.addAnimation(scaleAnimation);
        animationSet.addAnimation(scaleAnimation2);
        animationSet.setFillAfter(true);
        imageView.startAnimation(animationSet);
        animationSet.setAnimationListener(new animationAnimation$AnimationListenerC1147a(view));
    }

    /* renamed from: s */
    public static String m57584s(Object obj) {
        return m57582t(obj, "yyyy-MM-dd");
    }

    /* renamed from: s0 */
    public static Bitmap m57583s0(Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap m57592o = m57592o(bitmap);
            return m57581t0(m57592o, m57592o.getWidth() / 2);
        }
        return bitmap;
    }

    @SuppressLint({"SimpleDateFormat"})
    /* renamed from: t */
    public static String m57582t(Object obj, String str) {
        try {
            return new SimpleDateFormat(str).format(new Date(Long.parseLong(m57576w(obj)) * 1000));
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: t0 */
    public static Bitmap m57581t0(Bitmap bitmap, int i) {
        if (bitmap != null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                RectF rectF = new RectF(rect);
                float f = i;
                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-12434878);
                canvas.drawRoundRect(rectF, f, f, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, rect, rect, paint);
                return createBitmap;
            } catch (Exception unused) {
            }
        }
        return bitmap;
    }

    /* renamed from: u */
    public static String m57580u(Object obj) {
        String m57576w = m57576w(obj);
        return m57576w.length() == 0 ? "0.00" : m57576w;
    }

    /* renamed from: u0 */
    public static String m57579u0(String str) {
        return !m57617b0(str) ? str.trim() : "";
    }

    /* renamed from: v */
    public static String m57578v(String str) {
        if (str.contains(".")) {
            String[] split = str.split("\\.");
            if (split[1].length() == 0) {
                return split[0] + ".00";
            } else if (split[1].length() == 1) {
                return split[0] + "." + split[1] + "0";
            } else {
                split[1].length();
                return str;
            }
        }
        return str + ".00";
    }

    /* renamed from: v0 */
    public static boolean m57577v0(String str) {
        return Pattern.compile("/^([a-z0-9\\-_.+]+)@([a-z0-9\\-]+[.][a-z0-9\\-.]+)$/").matcher(str).matches();
    }

    /* renamed from: w */
    public static String m57576w(Object obj) {
        try {
            if (!m57617b0(obj.toString())) {
                return obj.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    /* renamed from: w0 */
    public static boolean m57575w0(String str) {
        if (m57617b0(str)) {
            return false;
        }
        return str.matches("^\\d{13,19}$");
    }

    /* renamed from: x */
    public static String m57574x(Object obj) {
        return m57582t(obj, "yyyy-MM-dd HH:mm:ss");
    }

    /* renamed from: x0 */
    public static boolean m57573x0(String str) {
        if (m57617b0(str)) {
            return false;
        }
        return str.matches("^\\d{6}$");
    }

    /* renamed from: y */
    public static ArrayList<String[]> m57572y(double d, int i, double d2, double d3) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        double d4 = i - 1;
        Double.isNaN(d4);
        double d5 = (d2 - d3) / d4;
        for (int i2 = 0; i2 < i; i2++) {
            double d6 = i2;
            Double.isNaN(d6);
            double d7 = ((d2 - (d6 * d5)) * 3.141592653589793d) / 180.0d;
            arrayList.add(new String[]{(Math.cos(d7) * d) + "", (Math.sin(d7) * d) + ""});
        }
        return arrayList;
    }

    /* renamed from: y0 */
    public static boolean m57571y0(String str) {
        if (m57617b0(str)) {
            return false;
        }
        return str.matches("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");
    }

    /* renamed from: z */
    public static String m57570z(ContentResolver contentResolver, Uri uri) {
        try {
            if (uri.getScheme().equals(IDataSource.f43973c)) {
                return uri.getPath();
            }
            return m57652A(contentResolver, uri);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    /* renamed from: z0 */
    public static boolean m57569z0(String str) {
        if (m57617b0(str)) {
            return false;
        }
        return str.matches("^[0-9]{17}[0-9|xX]{1}$");
    }

    /* renamed from: o0 */
    public void m57591o0(EditText editText, int i) {
        editText.addTextChangedListener(new C1149c(editText, i));
    }
}
