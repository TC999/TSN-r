package cn.bluemobi.dylan.base.utils;

import java.io.Serializable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class SeralizableMap implements Serializable {
    private static final long serialVersionUID = 1;
    private Map<String, Object> map;

    public Map<String, Object> getMap() {
        return this.map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
