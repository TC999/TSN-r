package androidx.constraintlayout.motion.widget;

import java.util.Arrays;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class KeyCache {
    HashMap<Object, HashMap<String, float[]>> map = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public float getFloatValue(Object obj, String str, int i4) {
        if (this.map.containsKey(obj)) {
            HashMap<String, float[]> hashMap = this.map.get(obj);
            if (hashMap.containsKey(str)) {
                float[] fArr = hashMap.get(str);
                if (fArr.length > i4) {
                    return fArr[i4];
                }
                return Float.NaN;
            }
            return Float.NaN;
        }
        return Float.NaN;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setFloatValue(Object obj, String str, int i4, float f4) {
        if (!this.map.containsKey(obj)) {
            HashMap<String, float[]> hashMap = new HashMap<>();
            float[] fArr = new float[i4 + 1];
            fArr[i4] = f4;
            hashMap.put(str, fArr);
            this.map.put(obj, hashMap);
            return;
        }
        HashMap<String, float[]> hashMap2 = this.map.get(obj);
        if (!hashMap2.containsKey(str)) {
            float[] fArr2 = new float[i4 + 1];
            fArr2[i4] = f4;
            hashMap2.put(str, fArr2);
            this.map.put(obj, hashMap2);
            return;
        }
        float[] fArr3 = hashMap2.get(str);
        if (fArr3.length <= i4) {
            fArr3 = Arrays.copyOf(fArr3, i4 + 1);
        }
        fArr3[i4] = f4;
        hashMap2.put(str, fArr3);
    }
}
