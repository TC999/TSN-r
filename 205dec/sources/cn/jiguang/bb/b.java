package cn.jiguang.bb;

import android.content.Context;
import android.text.TextUtils;
import com.acse.ottn.f3;
import java.util.ArrayList;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {
    public static cn.jiguang.ba.a a(Context context) {
        if (cn.jiguang.ah.d.a(context, false, "need get getDefaultApiSimInfo")) {
            return null;
        }
        cn.jiguang.ba.a aVar = new cn.jiguang.ba.a();
        aVar.f2520b = "";
        if (cn.jiguang.ar.a.a().e(1025)) {
            aVar.f2520b = cn.jiguang.ah.d.d(context, "");
        }
        aVar.f2521c = "";
        if (cn.jiguang.ar.a.a().e(1023)) {
            aVar.f2521c = cn.jiguang.ah.d.f(context, "");
        }
        aVar.f2519a = "";
        if (cn.jiguang.ar.a.a().e(1024)) {
            aVar.f2519a = cn.jiguang.ah.d.e(context, "");
        }
        return aVar;
    }

    public static String a(Context context, String str) {
        return b(context, str);
    }

    private static String a(Context context, String[] strArr) {
        String a4;
        StringBuilder sb;
        String replace;
        String a5;
        StringBuilder sb2;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        String a6 = a(context, cn.jiguang.az.a.a(0, 0));
        if (TextUtils.isEmpty(a6)) {
            a6 = a(context, cn.jiguang.az.a.a(0, 2));
        }
        if (length > 1) {
            a6 = a6 + "," + a(context, cn.jiguang.az.a.a(0, 1));
        }
        if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
            a6 = a(context, cn.jiguang.az.a.a(0, 3)) + "," + a(context, cn.jiguang.az.a.a(0, 4));
            if ((a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) && ((a6 = a(context, cn.jiguang.az.a.a(0, 6))) == null || TextUtils.isEmpty(a6.trim().replace(",", "")))) {
                String a7 = a(context, cn.jiguang.az.a.a(0, 8));
                String a8 = a(context, cn.jiguang.az.a.a(0, 9));
                String a9 = a(context, cn.jiguang.az.a.a(0, 10));
                if (TextUtils.isEmpty(a8)) {
                    a6 = a7 + "," + a(context, cn.jiguang.az.a.a(0, 10));
                } else if (TextUtils.isEmpty(a9)) {
                    a6 = a7 + "," + a8;
                } else {
                    a6 = a8 + "," + a9;
                }
                if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                    a6 = a(context, cn.jiguang.az.a.a(0, 36)) + "," + a(context, cn.jiguang.az.a.a(0, 37));
                    if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                        a6 = a(context, cn.jiguang.az.a.a(0, 21));
                        if (!TextUtils.isEmpty(a6)) {
                            String a10 = a(context, cn.jiguang.az.a.a(0, 20));
                            if (TextUtils.isEmpty(a10)) {
                                a6 = a(context, cn.jiguang.az.a.a(0, 22)) + "," + a6;
                            } else {
                                a6 = a10 + "," + a6;
                            }
                        }
                        if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                            a6 = a(context, cn.jiguang.az.a.a(0, 11));
                            if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                String a11 = a(context, cn.jiguang.az.a.a(0, 14));
                                if (TextUtils.isEmpty(a11)) {
                                    a11 = a(context, cn.jiguang.az.a.a(0, 13));
                                }
                                a6 = a11 + "," + a(context, cn.jiguang.az.a.a(0, 15));
                                if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                    a6 = a(context, cn.jiguang.az.a.a(0, 17)) + "," + a(context, cn.jiguang.az.a.a(0, 18));
                                    if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                        a6 = a(context, cn.jiguang.az.a.a(0, 22));
                                        if (TextUtils.isEmpty(a6)) {
                                            a6 = a(context, cn.jiguang.az.a.a(0, 23));
                                        }
                                        if (a6 == null || TextUtils.isEmpty(a6)) {
                                            a6 = a(context, cn.jiguang.az.a.a(0, 26));
                                            if (a6 == null || TextUtils.isEmpty(a6.trim())) {
                                                a6 = a(context, cn.jiguang.az.a.a(0, 27)) + "," + a(context, cn.jiguang.az.a.a(0, 28));
                                                if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                    a6 = a(context, cn.jiguang.az.a.a(0, 29)) + "," + a(context, cn.jiguang.az.a.a(0, 30));
                                                    if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                        a6 = a(context, cn.jiguang.az.a.a(0, 31)) + "," + a(context, cn.jiguang.az.a.a(0, 32));
                                                        if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                            a6 = a(context, cn.jiguang.az.a.a(0, 33)) + "," + a(context, cn.jiguang.az.a.a(0, 34));
                                                            if ((a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) && ((a6 = a(context, cn.jiguang.az.a.a(0, 35))) == null || TextUtils.isEmpty(a6.trim().replace(",", "")))) {
                                                                a6 = a(context, cn.jiguang.az.a.a(0, 42)) + "," + a(context, cn.jiguang.az.a.a(0, 43));
                                                                if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                                    a6 = a(context, cn.jiguang.az.a.a(0, 44)) + "," + a(context, cn.jiguang.az.a.a(0, 45));
                                                                    if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                                        String a12 = a(context, cn.jiguang.az.a.a(0, 16));
                                                                        if (a12 == null || TextUtils.isEmpty(a12.trim())) {
                                                                            a6 = a(context, cn.jiguang.az.a.a(0, 19));
                                                                            if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                                                a6 = a(context, cn.jiguang.az.a.a(0, 39)) + "," + a(context, cn.jiguang.az.a.a(0, 40));
                                                                                if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                                                    a6 = a(context, cn.jiguang.az.a.a(0, 38));
                                                                                    if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                                                        a6 = a(context, cn.jiguang.az.a.a(0, 7));
                                                                                        if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                                                            a6 = a(context, cn.jiguang.az.a.a(0, 5));
                                                                                            if (a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) {
                                                                                                a4 = a(context, cn.jiguang.az.a.a(0, 41));
                                                                                                if (a4 == null || TextUtils.isEmpty(a4.trim().replace(",", ""))) {
                                                                                                    return a4;
                                                                                                }
                                                                                            } else if (length > 1) {
                                                                                                sb = new StringBuilder();
                                                                                                sb.append(",");
                                                                                                sb.append(a6);
                                                                                                a6 = sb.toString();
                                                                                            }
                                                                                        }
                                                                                    } else if (length > 1) {
                                                                                        sb = new StringBuilder();
                                                                                        sb.append(a6);
                                                                                        sb.append(",");
                                                                                        a6 = sb.toString();
                                                                                    }
                                                                                } else if (length > 1) {
                                                                                    sb = new StringBuilder();
                                                                                    sb.append(a6);
                                                                                    sb.append(",");
                                                                                    a6 = sb.toString();
                                                                                }
                                                                            }
                                                                        } else {
                                                                            a4 = a12 + ",";
                                                                        }
                                                                        replace = a4.replace("null", "");
                                                                        return replace.replace("N/A", "");
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        } else {
                                            String a13 = a(context, cn.jiguang.az.a.a(0, 24));
                                            a5 = a(context, cn.jiguang.az.a.a(0, 25));
                                            if (TextUtils.isEmpty(a13) || TextUtils.isEmpty(a5)) {
                                                if (!TextUtils.isEmpty(a13)) {
                                                    sb = new StringBuilder();
                                                    sb.append(a6);
                                                    sb.append(",");
                                                    sb.append(a13);
                                                } else if (!TextUtils.isEmpty(a5)) {
                                                    sb2 = new StringBuilder();
                                                    sb2.append(a6);
                                                } else if (length > 1 && !a6.contains(",")) {
                                                    sb = new StringBuilder();
                                                    sb.append(a6);
                                                    sb.append(",");
                                                }
                                                a6 = sb.toString();
                                            } else {
                                                sb2 = new StringBuilder();
                                                sb2.append(a13);
                                            }
                                            sb2.append(",");
                                            sb2.append(a5);
                                            a6 = sb2.toString();
                                        }
                                    }
                                }
                            } else {
                                a5 = a(context, cn.jiguang.az.a.a(0, 12));
                                if (!TextUtils.isEmpty(a5)) {
                                    sb2 = new StringBuilder();
                                    sb2.append(a6);
                                    sb2.append(",");
                                    sb2.append(a5);
                                    a6 = sb2.toString();
                                }
                            }
                        }
                    }
                }
            }
        }
        replace = a6.replace("null", "");
        return replace.replace("N/A", "");
    }

    public static String a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() < 14) {
            return null;
        }
        return str;
    }

    public static String b(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod(f3.f5657f, String.class).invoke(loadClass, new String(str));
        } catch (Throwable unused) {
            return "";
        }
    }

    private static String b(Context context, String[] strArr) {
        StringBuilder sb;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        String a4 = a(context, cn.jiguang.az.a.a(3, 0));
        if (a4 == null || TextUtils.isEmpty(a4.trim().replace(",", ""))) {
            a4 = a(context, cn.jiguang.az.a.a(3, 1)) + "," + a(context, cn.jiguang.az.a.a(3, 2));
            if (a4 == null || TextUtils.isEmpty(a4.trim().replace(",", ""))) {
                a4 = a(context, cn.jiguang.az.a.a(3, 4)) + "," + a(context, cn.jiguang.az.a.a(3, 5));
                if ((a4 == null || TextUtils.isEmpty(a4.trim().replace(",", ""))) && ((a4 = a(context, cn.jiguang.az.a.a(3, 6))) == null || TextUtils.isEmpty(a4.trim().replace(",", "")))) {
                    a4 = a(context, cn.jiguang.az.a.a(3, 7)) + "," + a(context, cn.jiguang.az.a.a(3, 8));
                    if (a4 == null || TextUtils.isEmpty(a4.trim().replace(",", ""))) {
                        a4 = a(context, cn.jiguang.az.a.a(3, 9)) + "," + a(context, cn.jiguang.az.a.a(3, 10));
                        if (a4 == null || TextUtils.isEmpty(a4.trim().replace(",", ""))) {
                            a4 = a(context, cn.jiguang.az.a.a(3, 12)) + "," + a(context, cn.jiguang.az.a.a(3, 12));
                            if (a4 == null || TextUtils.isEmpty(a4.trim().replace(",", ""))) {
                                a4 = a(context, cn.jiguang.az.a.a(3, 13)) + "," + a(context, cn.jiguang.az.a.a(3, 14));
                                if (a4 == null || TextUtils.isEmpty(a4.trim().replace(",", ""))) {
                                    String a5 = a(context, cn.jiguang.az.a.a(3, 3));
                                    if (length == 1) {
                                        a4 = a5;
                                    } else {
                                        if ("ABSENT".equalsIgnoreCase(strArr[1]) && !"ABSENT".equalsIgnoreCase(strArr[0])) {
                                            sb = new StringBuilder();
                                            sb.append(a5);
                                            sb.append(",");
                                        } else if (!"ABSENT".equalsIgnoreCase(strArr[1])) {
                                            sb = new StringBuilder();
                                            sb.append(",");
                                            sb.append(a5);
                                        }
                                        a4 = sb.toString();
                                    }
                                    if (a4 == null || TextUtils.isEmpty(a4.trim().replace(",", ""))) {
                                        return a4;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return a4.replace("null", "").replace("N/A", "");
    }

    public static ArrayList<cn.jiguang.ba.a> b(Context context) {
        String a4 = a(context, cn.jiguang.az.a.a(4, 1));
        String a5 = a(context, cn.jiguang.az.a.a(4, 0));
        if (a4 != null && !TextUtils.isEmpty(a4)) {
            a5 = a5 + "," + a4;
        }
        String[] split = TextUtils.isEmpty(a5) ? null : a5.split(",");
        int length = split == null ? 1 : split.length;
        if (length == 0) {
            return null;
        }
        ArrayList<cn.jiguang.ba.a> arrayList = new ArrayList<>();
        String a6 = cn.jiguang.ar.a.a().e(1024) ? a(context, split) : null;
        String b4 = cn.jiguang.ar.a.a().e(1023) ? b(context, split) : null;
        String c4 = cn.jiguang.ar.a.a().e(1025) ? c(context, split) : null;
        if (length == 1) {
            cn.jiguang.ba.a aVar = new cn.jiguang.ba.a();
            aVar.f2519a = a(a6 == null ? null : a6.trim());
            if (!"ABSENT".equalsIgnoreCase(a5)) {
                aVar.f2521c = b4 == null ? null : b4.trim();
                aVar.f2520b = c4 != null ? c4.trim() : null;
            }
            arrayList.add(aVar);
        } else {
            String[] split2 = a6 != null ? a6.split(",") : null;
            String[] split3 = c4 != null ? c4.split(",") : null;
            String[] split4 = b4 != null ? b4.split(",") : null;
            for (int i4 = 0; i4 < 2; i4++) {
                cn.jiguang.ba.a aVar2 = new cn.jiguang.ba.a();
                if (split2 != null && i4 < split2.length) {
                    aVar2.f2519a = a(split2[i4]);
                }
                if (!"ABSENT".equalsIgnoreCase(split[i4])) {
                    if (split3 != null && i4 < split3.length) {
                        aVar2.f2520b = split3[i4];
                    }
                    if (split4 != null && i4 < split4.length) {
                        aVar2.f2521c = split4[i4];
                    }
                }
                arrayList.add(aVar2);
            }
        }
        return arrayList;
    }

    private static String c(Context context, String[] strArr) {
        String replace;
        StringBuilder sb;
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        String a4 = a(context, cn.jiguang.az.a.a(1, 0));
        String a5 = a(context, cn.jiguang.az.a.a(1, 1));
        if (!TextUtils.isEmpty(a5)) {
            a4 = a4 + "," + a5;
        }
        if (a4 == null || TextUtils.isEmpty(a4.trim().replace(",", ""))) {
            String a6 = a(context, cn.jiguang.az.a.a(1, 2));
            if ((a6 == null || TextUtils.isEmpty(a6.trim().replace(",", ""))) && ((a6 = a(context, cn.jiguang.az.a.a(1, 3))) == null || TextUtils.isEmpty(a6.trim().replace(",", "")) || !a6.contains(","))) {
                String a7 = a(context, cn.jiguang.az.a.a(1, 4));
                if (a7 == null || TextUtils.isEmpty(a7.trim().replace(",", "")) || !a7.contains(",")) {
                    return a7;
                }
                replace = a7.replace("null", "");
            } else {
                replace = a6.replace("null", "");
            }
        } else {
            if (length > 1 && !a4.contains(",")) {
                if ("ABSENT".equalsIgnoreCase(strArr[0])) {
                    sb = new StringBuilder();
                    sb.append(",");
                    sb.append(a4);
                } else {
                    sb = new StringBuilder();
                    sb.append(a4);
                    sb.append(",");
                }
                a4 = sb.toString();
            }
            replace = a4.replace("null", "");
        }
        return replace.replace("N/A", "");
    }
}
