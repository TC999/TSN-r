package net.sourceforge.pinyin4j;

import com.hp.hpl.sparta.ParseException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: PinyinRomanizationTranslator.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
class g {
    g() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, h hVar, h hVar2) {
        String a4 = j.a(str);
        String b4 = j.b(str);
        try {
            com.hp.hpl.sparta.g s3 = f.a().b().s("//" + hVar.a() + "[text()='" + a4 + "']");
            if (s3 != null) {
                String u3 = s3.u("../" + hVar2.a() + "/text()");
                return u3 + b4;
            }
            return null;
        } catch (ParseException e4) {
            e4.printStackTrace();
            return null;
        }
    }
}
