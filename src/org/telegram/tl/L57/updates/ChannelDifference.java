package org.telegram.tl.L57.updates;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class ChannelDifference extends TLChannelDifference {

    public static final int ID = 0x2064674e;

    public int flags;
    public int pts;
    public int timeout;
    public TLVector<TLMessage> new_messages;
    public TLVector<TLUpdate> other_updates;
    public TLVector<TLChat> chats;
    public TLVector<TLUser> users;

    public ChannelDifference() {
        this.new_messages = new TLVector<>();
        this.other_updates = new TLVector<>();
        this.chats = new TLVector<>();
        this.users = new TLVector<>();
    }

    public ChannelDifference(int flags, int pts, int timeout, TLVector<TLMessage> new_messages, TLVector<TLUpdate> other_updates, TLVector<TLChat> chats, TLVector<TLUser> users) {
        this.flags = flags;
        this.pts = pts;
        this.timeout = timeout;
        this.new_messages = new_messages;
        this.other_updates = other_updates;
        this.chats = chats;
        this.users = users;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        flags = buffer.readInt();
        pts = buffer.readInt();
        if ((flags & (1 << 1)) != 0) {
            timeout = buffer.readInt();
        }
        new_messages = (TLVector<TLMessage>) buffer.readTLObject(APIContext.getInstance());
        other_updates = (TLVector<TLUpdate>) buffer.readTLObject(APIContext.getInstance());
        chats = (TLVector<TLChat>) buffer.readTLObject(APIContext.getInstance());
        users = (TLVector<TLUser>) buffer.readTLObject(APIContext.getInstance());
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        setFlags();
        serializeTo(buffer);
        return buffer;
    }

    public void setFlags() {
        if (timeout != 0) {
            flags |= (1 << 1);
        }
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(flags);
        buff.writeInt(pts);
        if ((flags & (1 << 1)) != 0) {
            buff.writeInt(timeout);
        }
        buff.writeTLObject(new_messages);
        buff.writeTLObject(other_updates);
        buff.writeTLObject(chats);
        buff.writeTLObject(users);
    }

    public boolean is_final() {
        return (flags & (1 << 0)) != 0;
    }

    public void set_final(boolean v) {
        if (v) {
            flags |= (1 << 0);
        } else {
            flags &= ~(1 << 0);
        }
    }

    public int getConstructor() {
        return ID;
    }
}