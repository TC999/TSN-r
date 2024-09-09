package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.ParseException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: GwoyeuRomatzyhTranslator.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class c {

    /* renamed from: a  reason: collision with root package name */
    private static String[] f61524a = {"_I", "_II", "_III", "_IV", "_V"};

    c() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str) {
        String a4 = j.a(str);
        String b4 = j.b(str);
        try {
            com.hp.hpl.sparta.g s3 = b.a().b().s("//" + h.f61543b.a() + "[text()='" + a4 + "']");
            if (s3 != null) {
                return s3.u("../" + h.f61548g.a() + f61524a[Integer.parseInt(b4) - 1] + "/text()");
            }
            return null;
        } catch (ParseException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
