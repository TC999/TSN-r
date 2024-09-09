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
import cn.jpush.android.local.JPushConstants;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: Tools.java */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    static Toast f1837a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Tools.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class a implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f1838a;

        a(View view) {
            this.f1838a = view;
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            this.f1838a.setEnabled(true);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            this.f1838a.setEnabled(false);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Tools.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    static class b extends TimerTask {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f1839a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f1840b;

        b(EditText editText, String str) {
            this.f1839a = editText;
            this.f1840b = str;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            InputMethodManager inputMethodManager = (InputMethodManager) this.f1839a.getContext().getSystemService("input_method");
            if (this.f1840b.equals("open")) {
                inputMethodManager.showSoftInput(this.f1839a, 2);
            } else {
                inputMethodManager.hideSoftInputFromWindow(this.f1839a.getWindowToken(), 0);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: Tools.java */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f1841a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f1842b;

        c(EditText editText, int i4) {
            this.f1841a = editText;
            this.f1842b = i4;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            String obj = this.f1841a.getText().toString();
            if (obj.contains(".") && (obj.length() - 1) - obj.indexOf(".") > this.f1842b) {
                obj = obj.substring(0, obj.indexOf(".") + this.f1842b + 1);
                this.f1841a.setText(obj);
                this.f1841a.setSelection(obj.length());
            }
            if (obj.trim().substring(0).equals(".")) {
                obj = "0" + obj;
                this.f1841a.setText(obj);
                this.f1841a.setSelection(2);
            }
            if (!obj.toString().startsWith("0") || obj.trim().length() <= 1 || obj.substring(1, 2).equals(".")) {
                return;
            }
            this.f1841a.setText(obj.subSequence(0, 1));
            this.f1841a.setSelection(1);
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i4, int i5, int i6) {
        }
    }

    public static String A(ContentResolver contentResolver, Uri uri) throws FileNotFoundException {
        Cursor query = contentResolver.query(uri, null, null, null, null);
        query.moveToFirst();
        String string = query.getString(1);
        query.close();
        return string;
    }

    public static boolean A0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("[\\u4E00-\\u9FA5]{2,4}");
    }

    public static String B(long j4) {
        return DateFormat.format("MM\u6708dd\u65e5", j4 * 1000).toString();
    }

    public static boolean B0(String str) {
        return !T(str) && str.trim().length() >= 6 && str.trim().length() <= 16;
    }

    public static String C(long j4) {
        return DateFormat.format("kk:mm:ss", j4 * 1000).toString();
    }

    public static boolean C0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^1[1,2,3,4,5,6,7,8,9]+\\d{9}$");
    }

    public static String D(long j4) {
        return DateFormat.format("MM-dd", j4 * 1000).toString();
    }

    public static int D0(String str) {
        if (C0(str)) {
            return 1;
        }
        return y0(str) ? 2 : 0;
    }

    public static String E(long j4) {
        return DateFormat.format("kk:mm", j4 * 1000).toString();
    }

    public static boolean E0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^(\\d{11})$|^(\\d{3,5}[-]?\\d{6,8})$");
    }

    public static String F(long j4) {
        return DateFormat.format("yy-MM-dd HH:mm", j4 * 1000).toString();
    }

    public static boolean F0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^[a-zA-Z\\d_]+$");
    }

    public static String G(int i4) {
        int i5;
        String str = "";
        if (i4 > 99 || i4 == 0) {
            return "";
        }
        int i6 = (i4 - (i4 % 10)) / 10;
        if (i6 != 0) {
            if (i6 == 1) {
                str = "\u5341";
            } else {
                str = H(i6) + "\u5341";
            }
        }
        return str + H(i5);
    }

    public static String H(int i4) {
        return new String[]{"", "\u4e00", "\u4e8c", "\u4e09", "\u56db", "\u4e94", "\u516d", "\u4e03", "\u516b", "\u4e5d"}[i4];
    }

    public static int I(Context context, int i4, int i5, int i6) {
        return ((K(context)[0] - a(i4, context)) - (a(i5, context) * (i6 - 1))) / i6;
    }

    public static String J(long j4) {
        return DateFormat.format("yyyyMMddHHmmss", j4).toString();
    }

    public static int[] K(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static String L(View view) {
        try {
            return view.getTag().toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String M(EditText editText) {
        return editText != null ? editText.getText().toString().trim() : "";
    }

    public static String N(TextView textView) {
        return textView != null ? textView.getText().toString().trim() : "";
    }

    public static String O(Map<String, Object> map, String str) {
        if (map == null || map.size() == 0 || b0(str) || !map.containsKey(str)) {
            return "";
        }
        if (map.get(str) instanceof String) {
            return f0((String) map.get(str)) ? "" : map.get(str).toString();
        }
        return String.valueOf(map.get(str));
    }

    public static int P(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static String Q(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e4) {
            e4.printStackTrace();
            return "";
        }
    }

    @SuppressLint({"SimpleDateFormat"})
    public static int R(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(3);
    }

    public static void S(Activity activity) {
        ((InputMethodManager) activity.getSystemService("input_method")).hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 2);
    }

    public static boolean T(String str) {
        if (b0(str)) {
            return false;
        }
        return Pattern.compile("[\u4e00-\u9fa5]").matcher(str).find();
    }

    public static boolean U(String str) {
        return Pattern.compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$").matcher(str).matches();
    }

    public static boolean V(List list) {
        return list == null || list.size() == 0;
    }

    public static boolean W(Object[] objArr) {
        return objArr == null || objArr.length == 0;
    }

    public static boolean X(List... listArr) {
        for (List list : listArr) {
            if (V(list)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Y(Object[]... objArr) {
        for (Object[] objArr2 : objArr) {
            if (W(objArr2)) {
                return true;
            }
        }
        return false;
    }

    public static boolean Z(EditText editText) {
        return editText == null || b0(M(editText));
    }

    public static int a(float f4, Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        double d4 = f4 * displayMetrics.density;
        Double.isNaN(d4);
        return (int) (d4 + 0.5d);
    }

    public static boolean a0(TextView textView) {
        return textView == null || b0(N(textView));
    }

    public static void b(EditText editText, String str) {
        new Timer().schedule(new b(editText, str), 300L);
    }

    public static boolean b0(String str) {
        return str == null || str.equals("") || str.equalsIgnoreCase("null");
    }

    public static String c(List list) {
        return Pattern.compile("\\b([\\w\\W])\\b").matcher(list.toString().substring(1, list.toString().length() - 1)).replaceAll("$1").replaceAll(",", " ");
    }

    public static boolean c0(List<String> list) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            if (list.get(i4) == null || b0(list.get(i4))) {
                return true;
            }
        }
        return false;
    }

    public static void d(String str) {
        if (str == null) {
            str = "\u4f20\u8fdb\u6765\u7684\u662fnull";
        }
        Log.i("logs", str);
    }

    public static boolean d0(TextView... textViewArr) {
        for (int i4 = 0; i4 < textViewArr.length; i4++) {
            if (textViewArr[i4] == null || b0(N(textViewArr[i4]))) {
                return true;
            }
        }
        return false;
    }

    public static String e(Map<String, Object> map, String str) {
        return (!map.containsKey(str) || map.get(str) == null || "".equals(map.get(str))) ? "" : ((String) map.get(str)).trim();
    }

    public static boolean e0(String... strArr) {
        for (int i4 = 0; i4 < strArr.length; i4++) {
            if (strArr[i4] == null || strArr[i4].equals("") || strArr[i4].equalsIgnoreCase("null")) {
                return true;
            }
        }
        return false;
    }

    public static int[] f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels};
    }

    public static boolean f0(String str) {
        return str == null || str.equals("");
    }

    public static float g(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static boolean g0(String str) {
        return str != null && str.startsWith(JPushConstants.HTTP_PRE);
    }

    public static int h(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            return 0;
        }
    }

    public static boolean h0() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void i(Context context, int i4) {
        if (context != null) {
            j(context, context.getString(i4));
        }
    }

    public static boolean i0(String str, String str2) {
        return str != null && str.equals(str2);
    }

    public static void j(Context context, String str) {
        if (str != null) {
            Toast.makeText(context, str, 0).show();
        }
    }

    public static void j0(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdir();
    }

    public static String k(String str) {
        if (str == null || str.length() != 4) {
            return null;
        }
        return str.substring(0, 2) + ":" + str.substring(2, 4);
    }

    public static String k0(long j4) {
        Object valueOf;
        Object valueOf2;
        int i4 = 0;
        boolean z3 = j4 < 0;
        long abs = Math.abs(j4) / 1000;
        int i5 = (int) (abs % 60);
        long j5 = abs / 60;
        int i6 = (int) (j5 % 60);
        long j6 = j5 / 60;
        int i7 = (int) j6;
        DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getInstance(Locale.US);
        decimalFormat.applyPattern("00");
        if (j6 > 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(z3 ? "-" : "");
            if (i7 == 0) {
                valueOf = 0;
            } else if (i7 < 10) {
                valueOf = "0" + i7;
            } else {
                valueOf = Integer.valueOf(i7);
            }
            sb.append(valueOf);
            sb.append(":");
            if (i6 == 0) {
                valueOf2 = 0;
            } else if (i6 < 10) {
                valueOf2 = "0" + i6;
            } else {
                valueOf2 = Integer.valueOf(i6);
            }
            sb.append(valueOf2);
            sb.append(":");
            if (i5 != 0) {
                if (i5 < 10) {
                    i4 = "0" + i5;
                } else {
                    i4 = Integer.valueOf(i5);
                }
            }
            sb.append(i4);
            return sb.toString();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z3 ? "-" : "");
        sb2.append(i6);
        sb2.append(":");
        sb2.append(decimalFormat.format(i5));
        return sb2.toString();
    }

    /* JADX WARN: Not initialized variable reg: 1, insn: 0x0037: MOVE  (r0 I:??[OBJECT, ARRAY]) = (r1 I:??[OBJECT, ARRAY]), block:B:20:0x0037 */
    public static String l(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2;
        String b4;
        ByteArrayOutputStream byteArrayOutputStream3 = null;
        try {
            if (bitmap != null) {
                try {
                    byteArrayOutputStream2 = new ByteArrayOutputStream();
                } catch (IOException e4) {
                    e = e4;
                    byteArrayOutputStream2 = null;
                } catch (Throwable th) {
                    th = th;
                    if (byteArrayOutputStream3 != null) {
                        try {
                            byteArrayOutputStream3.flush();
                            byteArrayOutputStream3.close();
                        } catch (IOException e5) {
                            e5.printStackTrace();
                        }
                    }
                    throw th;
                }
                try {
                    bitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream2);
                    byteArrayOutputStream2.flush();
                    byteArrayOutputStream2.close();
                    b4 = cn.bluemobi.dylan.base.utils.b.b(byteArrayOutputStream2.toByteArray());
                    byteArrayOutputStream3 = byteArrayOutputStream2;
                } catch (IOException e6) {
                    e = e6;
                    e.printStackTrace();
                    if (byteArrayOutputStream2 != null) {
                        try {
                            byteArrayOutputStream2.flush();
                            byteArrayOutputStream2.close();
                            return null;
                        } catch (IOException e7) {
                            e7.printStackTrace();
                            return null;
                        }
                    }
                    return null;
                }
            } else {
                b4 = null;
            }
            if (byteArrayOutputStream3 != null) {
                try {
                    byteArrayOutputStream3.flush();
                    byteArrayOutputStream3.close();
                } catch (IOException e8) {
                    e8.printStackTrace();
                }
            }
            return b4;
        } catch (Throwable th2) {
            th = th2;
            byteArrayOutputStream3 = byteArrayOutputStream;
        }
    }

    public static Double l0(double d4, int i4) {
        BigDecimal bigDecimal;
        if (i4 >= 0) {
            if (0.0d == d4) {
                bigDecimal = new BigDecimal("0.0");
            } else {
                bigDecimal = new BigDecimal(Double.toString(d4));
            }
            return Double.valueOf(bigDecimal.divide(new BigDecimal("1"), i4, 4).doubleValue());
        }
        throw new IllegalArgumentException("The scale must be a positive integer or zero");
    }

    public static Date m(Date date, int i4) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(6, i4);
        return calendar.getTime();
    }

    public static Bitmap m0(Bitmap bitmap, int i4, int i5) {
        float width = i4 / bitmap.getWidth();
        float height = i5 / bitmap.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale(width, height);
        matrix.postRotate(0.0f);
        return Bitmap.createScaledBitmap(bitmap, i4, i5, false);
    }

    public static String n(int i4) {
        switch (i4) {
            case 1:
                return "\u661f\u671f\u4e00";
            case 2:
                return "\u661f\u671f\u4e8c";
            case 3:
                return "\u661f\u671f\u4e09";
            case 4:
                return "\u661f\u671f\u56db";
            case 5:
                return "\u661f\u671f\u4e94";
            case 6:
                return "\u661f\u671f\u516d";
            case 7:
                return "\u661f\u671f\u65e5";
            default:
                return "";
        }
    }

    public static Spanned n0(String str) {
        return Html.fromHtml("<font color=#000>" + str + "</font>");
    }

    public static Bitmap o(Bitmap bitmap) {
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

    public static String p(String str) {
        if (str == null) {
            return null;
        }
        return str.replace(":", "");
    }

    public static void p0(Context context, CharSequence charSequence, int i4) {
        Toast toast = f1837a;
        if (toast == null) {
            f1837a = Toast.makeText(context, charSequence, i4);
        } else {
            toast.setText(charSequence);
        }
        f1837a.show();
    }

    public static boolean q() {
        return Environment.getExternalStorageState().equals("mounted");
    }

    public static void q0(View view) {
        ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 2);
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String r(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd HH:mm");
        try {
            return simpleDateFormat.format(simpleDateFormat.parse(str));
        } catch (ParseException e4) {
            e4.printStackTrace();
            return str;
        }
    }

    public static void r0(View view, ImageView imageView, int i4, int i5, boolean z3) {
        if (z3) {
            imageView.setBackgroundResource(i5);
        } else {
            imageView.setBackgroundResource(i4);
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
        animationSet.setAnimationListener(new a(view));
    }

    public static String s(Object obj) {
        return t(obj, "yyyy-MM-dd");
    }

    public static Bitmap s0(Bitmap bitmap) {
        if (bitmap != null) {
            Bitmap o4 = o(bitmap);
            return t0(o4, o4.getWidth() / 2);
        }
        return bitmap;
    }

    @SuppressLint({"SimpleDateFormat"})
    public static String t(Object obj, String str) {
        try {
            return new SimpleDateFormat(str).format(new Date(Long.parseLong(w(obj)) * 1000));
        } catch (Exception unused) {
            return "";
        }
    }

    public static Bitmap t0(Bitmap bitmap, int i4) {
        if (bitmap != null) {
            try {
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
                RectF rectF = new RectF(rect);
                float f4 = i4;
                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(-12434878);
                canvas.drawRoundRect(rectF, f4, f4, paint);
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
                canvas.drawBitmap(bitmap, rect, rect, paint);
                return createBitmap;
            } catch (Exception unused) {
            }
        }
        return bitmap;
    }

    public static String u(Object obj) {
        String w3 = w(obj);
        return w3.length() == 0 ? "0.00" : w3;
    }

    public static String u0(String str) {
        return !b0(str) ? str.trim() : "";
    }

    public static String v(String str) {
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

    public static boolean v0(String str) {
        return Pattern.compile("/^([a-z0-9\\-_.+]+)@([a-z0-9\\-]+[.][a-z0-9\\-.]+)$/").matcher(str).matches();
    }

    public static String w(Object obj) {
        try {
            if (!b0(obj.toString())) {
                return obj.toString();
            }
        } catch (Exception unused) {
        }
        return "";
    }

    public static boolean w0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^\\d{13,19}$");
    }

    public static String x(Object obj) {
        return t(obj, "yyyy-MM-dd HH:mm:ss");
    }

    public static boolean x0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^\\d{6}$");
    }

    public static ArrayList<String[]> y(double d4, int i4, double d5, double d6) {
        ArrayList<String[]> arrayList = new ArrayList<>();
        double d7 = i4 - 1;
        Double.isNaN(d7);
        double d8 = (d5 - d6) / d7;
        for (int i5 = 0; i5 < i4; i5++) {
            double d9 = i5;
            Double.isNaN(d9);
            double d10 = ((d5 - (d9 * d8)) * 3.141592653589793d) / 180.0d;
            arrayList.add(new String[]{(Math.cos(d10) * d4) + "", (Math.sin(d10) * d4) + ""});
        }
        return arrayList;
    }

    public static boolean y0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$");
    }

    public static String z(ContentResolver contentResolver, Uri uri) {
        try {
            if (uri.getScheme().equals("file")) {
                return uri.getPath();
            }
            return A(contentResolver, uri);
        } catch (FileNotFoundException unused) {
            return null;
        }
    }

    public static boolean z0(String str) {
        if (b0(str)) {
            return false;
        }
        return str.matches("^[0-9]{17}[0-9|xX]{1}$");
    }

    public void o0(EditText editText, int i4) {
        editText.addTextChangedListener(new c(editText, i4));
    }
}
