package org.telegram.tl.L57.updates;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class ChannelDifferenceTooLong extends TLChannelDifference {

    public static final int ID = 0x410dee07;

    public int flags;
    public int pts;
    public int timeout;
    public int top_message;
    public int read_inbox_max_id;
    public int read_outbox_max_id;
    public int unread_count;
    public TLVector<TLMessage> messages;
    public TLVector<TLChat> chats;
    public TLVector<TLUser> users;

    public ChannelDifferenceTooLong() {
        this.messages = new TLVector<>();
        this.chats = new TLVector<>();
        this.users = new TLVector<>();
    }

    public ChannelDifferenceTooLong(int flags, int pts, int timeout, int top_message, int read_inbox_max_id, int read_outbox_max_id, int unread_count, TLVector<TLMessage> messages, TLVector<TLChat> chats, TLVector<TLUser> users) {
        this.flags = flags;
        this.pts = pts;
        this.timeout = timeout;
        this.top_message = top_message;
        this.read_inbox_max_id = read_inbox_max_id;
        this.read_outbox_max_id = read_outbox_max_id;
        this.unread_count = unread_count;
        this.messages = messages;
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
        top_message = buffer.readInt();
        read_inbox_max_id = buffer.readInt();
        read_outbox_max_id = buffer.readInt();
        unread_count = buffer.readInt();
        messages = (TLVector<TLMessage>) buffer.readTLObject(APIContext.getInstance());
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
        buff.writeInt(top_message);
        buff.writeInt(read_inbox_max_id);
        buff.writeInt(read_outbox_max_id);
        buff.writeInt(unread_count);
        buff.writeTLObject(messages);
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