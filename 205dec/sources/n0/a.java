package n0;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a {
    public float a(int i4, int i5) {
        if (i5 <= 0 || i4 <= 0) {
            return 0.0f;
        }
        float f4 = i4 / i5;
        if (f4 > 1.0f) {
            return 1.0f;
        }
        return f4;
    }
}
