package io.netty.handler.codec.spdy;

import io.netty.util.internal.StringUtil;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class DefaultSpdySettingsFrame implements SpdySettingsFrame {
    private boolean clear;
    private final Map<Integer, Setting> settingsMap = new TreeMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public static final class Setting {
        private boolean persist;
        private boolean persisted;
        private int value;

        Setting(int i4, boolean z3, boolean z4) {
            this.value = i4;
            this.persist = z3;
            this.persisted = z4;
        }

        int getValue() {
            return this.value;
        }

        boolean isPersist() {
            return this.persist;
        }

        boolean isPersisted() {
            return this.persisted;
        }

        void setPersist(boolean z3) {
            this.persist = z3;
        }

        void setPersisted(boolean z3) {
            this.persisted = z3;
        }

        void setValue(int i4) {
            this.value = i4;
        }
    }

    private void appendSettings(StringBuilder sb) {
        for (Map.Entry<Integer, Setting> entry : getSettings()) {
            Setting value = entry.getValue();
            sb.append("--> ");
            sb.append(entry.getKey());
            sb.append(':');
            sb.append(value.getValue());
            sb.append(" (persist value: ");
            sb.append(value.isPersist());
            sb.append("; persisted: ");
            sb.append(value.isPersisted());
            sb.append(')');
            sb.append(StringUtil.NEWLINE);
        }
    }

    private Set<Map.Entry<Integer, Setting>> getSettings() {
        return this.settingsMap.entrySet();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean clearPreviouslyPersistedSettings() {
        return this.clear;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public int getValue(int i4) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i4));
        if (setting != null) {
            return setting.getValue();
        }
        return -1;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public Set<Integer> ids() {
        return this.settingsMap.keySet();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isPersistValue(int i4) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i4));
        return setting != null && setting.isPersist();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isPersisted(int i4) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i4));
        return setting != null && setting.isPersisted();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public boolean isSet(int i4) {
        return this.settingsMap.containsKey(Integer.valueOf(i4));
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame removeValue(int i4) {
        this.settingsMap.remove(Integer.valueOf(i4));
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setClearPreviouslyPersistedSettings(boolean z3) {
        this.clear = z3;
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setPersistValue(int i4, boolean z3) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i4));
        if (setting != null) {
            setting.setPersist(z3);
        }
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setPersisted(int i4, boolean z3) {
        Setting setting = this.settingsMap.get(Integer.valueOf(i4));
        if (setting != null) {
            setting.setPersisted(z3);
        }
        return this;
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setValue(int i4, int i5) {
        return setValue(i4, i5, false, false);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(StringUtil.simpleClassName(this));
        String str = StringUtil.NEWLINE;
        sb.append(str);
        appendSettings(sb);
        sb.setLength(sb.length() - str.length());
        return sb.toString();
    }

    @Override // io.netty.handler.codec.spdy.SpdySettingsFrame
    public SpdySettingsFrame setValue(int i4, int i5, boolean z3, boolean z4) {
        if (i4 >= 0 && i4 <= 16777215) {
            Integer valueOf = Integer.valueOf(i4);
            Setting setting = this.settingsMap.get(valueOf);
            if (setting != null) {
                setting.setValue(i5);
                setting.setPersist(z3);
                setting.setPersisted(z4);
            } else {
                this.settingsMap.put(valueOf, new Setting(i5, z3, z4));
            }
            return this;
        }
        throw new IllegalArgumentException("Setting ID is not valid: " + i4);
    }
}
