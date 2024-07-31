package io.netty.handler.codec.redis;

import com.baidu.mobads.sdk.internal.C2640by;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.collection.LongObjectHashMap;
import io.netty.util.collection.LongObjectMap;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class FixedRedisMessagePool implements RedisMessagePool {
    private static final long MAX_CACHED_INTEGER_NUMBER = 128;
    private static final long MIN_CACHED_INTEGER_NUMBER = -1;
    private static final int SIZE_CACHED_INTEGER_NUMBER = 129;
    private Map<ByteBuf, ErrorRedisMessage> byteBufToErrors;
    private Map<ByteBuf, IntegerRedisMessage> byteBufToIntegers;
    private Map<ByteBuf, SimpleStringRedisMessage> byteBufToSimpleStrings;
    private LongObjectMap<byte[]> longToByteBufs;
    private LongObjectMap<IntegerRedisMessage> longToIntegers;
    private Map<String, ErrorRedisMessage> stringToErrors;
    private Map<String, SimpleStringRedisMessage> stringToSimpleStrings;
    private static final String[] DEFAULT_SIMPLE_STRINGS = {C2640by.f8773k, "PONG", "QUEUED"};
    private static final String[] DEFAULT_ERRORS = {"ERR", "ERR index out of range", "ERR no such key", "ERR source and destination objects are the same", "ERR syntax error", "BUSY Redis is busy running a script. You can only call SCRIPT KILL or SHUTDOWN NOSAVE.", "BUSYKEY Target key name already exists.", "EXECABORT Transaction discarded because of previous errors.", "LOADING Redis is loading the dataset in memory", "MASTERDOWN Link with MASTER is down and slave-serve-stale-data is set to 'no'.", "MISCONF Redis is configured to save RDB snapshots, but is currently not able to persist on disk. Commands that may modify the data set are disabled. Please check Redis logs for details about the error.", "NOAUTH Authentication required.", "NOREPLICAS Not enough good slaves to write.", "NOSCRIPT No matching script. Please use EVAL.", "OOM command not allowed when used memory > 'maxmemory'.", "READONLY You can't write against a read only slave.", "WRONGTYPE Operation against a key holding the wrong kind of value"};
    public static final FixedRedisMessagePool INSTANCE = new FixedRedisMessagePool();

    private FixedRedisMessagePool() {
        String[] strArr = DEFAULT_SIMPLE_STRINGS;
        this.byteBufToSimpleStrings = new HashMap(strArr.length, 1.0f);
        this.stringToSimpleStrings = new HashMap(strArr.length, 1.0f);
        for (String str : strArr) {
            ByteBuf unmodifiableBuffer = Unpooled.unmodifiableBuffer(Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(str.getBytes(CharsetUtil.UTF_8))));
            SimpleStringRedisMessage simpleStringRedisMessage = new SimpleStringRedisMessage(str);
            this.byteBufToSimpleStrings.put(unmodifiableBuffer, simpleStringRedisMessage);
            this.stringToSimpleStrings.put(str, simpleStringRedisMessage);
        }
        String[] strArr2 = DEFAULT_ERRORS;
        this.byteBufToErrors = new HashMap(strArr2.length, 1.0f);
        this.stringToErrors = new HashMap(strArr2.length, 1.0f);
        for (String str2 : strArr2) {
            ByteBuf unmodifiableBuffer2 = Unpooled.unmodifiableBuffer(Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(str2.getBytes(CharsetUtil.UTF_8))));
            ErrorRedisMessage errorRedisMessage = new ErrorRedisMessage(str2);
            this.byteBufToErrors.put(unmodifiableBuffer2, errorRedisMessage);
            this.stringToErrors.put(str2, errorRedisMessage);
        }
        this.byteBufToIntegers = new HashMap(129, 1.0f);
        this.longToIntegers = new LongObjectHashMap(129, 1.0f);
        this.longToByteBufs = new LongObjectHashMap(129, 1.0f);
        for (long j = -1; j < 128; j++) {
            byte[] longToAsciiBytes = RedisCodecUtil.longToAsciiBytes(j);
            ByteBuf unmodifiableBuffer3 = Unpooled.unmodifiableBuffer(Unpooled.unreleasableBuffer(Unpooled.wrappedBuffer(longToAsciiBytes)));
            IntegerRedisMessage integerRedisMessage = new IntegerRedisMessage(j);
            this.byteBufToIntegers.put(unmodifiableBuffer3, integerRedisMessage);
            this.longToIntegers.put(j, (long) integerRedisMessage);
            this.longToByteBufs.put(j, (long) longToAsciiBytes);
        }
    }

    @Override // io.netty.handler.codec.redis.RedisMessagePool
    public byte[] getByteBufOfInteger(long j) {
        return this.longToByteBufs.get(j);
    }

    @Override // io.netty.handler.codec.redis.RedisMessagePool
    public ErrorRedisMessage getError(String str) {
        return this.stringToErrors.get(str);
    }

    @Override // io.netty.handler.codec.redis.RedisMessagePool
    public IntegerRedisMessage getInteger(long j) {
        return this.longToIntegers.get(j);
    }

    @Override // io.netty.handler.codec.redis.RedisMessagePool
    public SimpleStringRedisMessage getSimpleString(String str) {
        return this.stringToSimpleStrings.get(str);
    }

    @Override // io.netty.handler.codec.redis.RedisMessagePool
    public ErrorRedisMessage getError(ByteBuf byteBuf) {
        return this.byteBufToErrors.get(byteBuf);
    }

    @Override // io.netty.handler.codec.redis.RedisMessagePool
    public IntegerRedisMessage getInteger(ByteBuf byteBuf) {
        return this.byteBufToIntegers.get(byteBuf);
    }

    @Override // io.netty.handler.codec.redis.RedisMessagePool
    public SimpleStringRedisMessage getSimpleString(ByteBuf byteBuf) {
        return this.byteBufToSimpleStrings.get(byteBuf);
    }
}
