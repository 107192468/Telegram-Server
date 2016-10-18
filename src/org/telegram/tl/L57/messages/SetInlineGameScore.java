package org.telegram.tl.L57.messages;

import org.telegram.mtproto.ProtocolBuffer;
import org.telegram.tl.TLObject;
import org.telegram.tl.TLVector;
import org.telegram.tl.APIContext;
import org.telegram.tl.L57.*;

public class SetInlineGameScore extends TLObject {

    public static final int ID = 0x15ad9f64;

    public int flags;
    public TLInputBotInlineMessageID id;
    public TLInputUser user_id;
    public int score;

    public SetInlineGameScore() {
    }

    public SetInlineGameScore(int flags, TLInputBotInlineMessageID id, TLInputUser user_id, int score) {
        this.flags = flags;
        this.id = id;
        this.user_id = user_id;
        this.score = score;
    }

    @Override
    public void deserialize(ProtocolBuffer buffer) {
        flags = buffer.readInt();
        id = (TLInputBotInlineMessageID) buffer.readTLObject(APIContext.getInstance());
        user_id = (TLInputUser) buffer.readTLObject(APIContext.getInstance());
        score = buffer.readInt();
    }

    @Override
    public ProtocolBuffer serialize() {
        ProtocolBuffer buffer = new ProtocolBuffer(32);
        setFlags();
        serializeTo(buffer);
        return buffer;
    }

    public void setFlags() {
    }

    @Override
    public void serializeTo(ProtocolBuffer buff) {
        buff.writeInt(getConstructor());
        buff.writeInt(flags);
        buff.writeTLObject(id);
        buff.writeTLObject(user_id);
        buff.writeInt(score);
    }

    public boolean is_edit_message() {
        return (flags & (1 << 0)) != 0;
    }

    public void set_edit_message(boolean v) {
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