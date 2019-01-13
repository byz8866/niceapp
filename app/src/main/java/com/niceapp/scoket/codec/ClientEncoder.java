package com.niceapp.scoket.codec;


import com.google.gson.Gson;
import com.niceapp.model.request.SendMessage;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolEncoderAdapter;
import org.apache.mina.filter.codec.ProtocolEncoderOutput;

import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.text.DecimalFormat;

class ClientEncoder extends ProtocolEncoderAdapter {

    private final Charset charset;
    private Gson gson;

    public ClientEncoder() {
        this.charset = Charset.defaultCharset();
        gson = new Gson();
    }

    @Override
    public void encode(IoSession session, Object message, ProtocolEncoderOutput out) throws Exception {

        IoBuffer buf = IoBuffer.allocate(100).setAutoExpand(true);

        CharsetEncoder ce = charset.newEncoder();

        if (message instanceof SendMessage) {
            String text = gson.toJson(message);
            DecimalFormat df = new DecimalFormat("0000");
            if (text.getBytes().length > 9999) {
                return;
            }
            String length = df.format(text.getBytes().length);
            text = "^&*@" + length + text;
            buf.putString(text, ce);
        } else {
            buf.putString(message.toString(), ce);
        }

        buf.flip();
        out.write(buf);
    }
}

