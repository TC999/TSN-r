package io.netty.channel;

import io.netty.channel.Channel;
import io.netty.util.internal.StringUtil;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ReflectiveChannelFactory<T extends Channel> implements ChannelFactory<T> {
    private final Class<? extends T> clazz;

    public ReflectiveChannelFactory(Class<? extends T> cls) {
        if (cls != null) {
            this.clazz = cls;
            return;
        }
        throw new NullPointerException("clazz");
    }

    @Override // io.netty.channel.ChannelFactory, io.netty.bootstrap.ChannelFactory
    public T newChannel() {
        try {
            return this.clazz.newInstance();
        } catch (Throwable th) {
            throw new ChannelException("Unable to create Channel from class " + this.clazz, th);
        }
    }

    public String toString() {
        return StringUtil.simpleClassName((Class<?>) this.clazz) + ".class";
    }
}
