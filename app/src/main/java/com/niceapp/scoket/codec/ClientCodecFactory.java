package com.niceapp.scoket.codec;

import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.ProtocolCodecFactory;
import org.apache.mina.filter.codec.ProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolEncoder;

public class ClientCodecFactory implements ProtocolCodecFactory {

    private final ProtocolEncoder encoder;
    private final ProtocolDecoder decoder;

    public ClientCodecFactory() {
        this.encoder = new ClientEncoder();
        this.decoder = new ClientDecoder();
    }


    /* (non-Javadoc)
     * @see org.apache.mina.filter.codec.ProtocolCodecFactory#getDecoder(org.apache.mina.core.session.IoSession)
     */
    @Override
    public ProtocolDecoder getDecoder(IoSession arg0) throws Exception {
        return decoder;
    }

    /* (non-Javadoc)
     * @see org.apache.mina.filter.codec.ProtocolCodecFactory#getEncoder(org.apache.mina.core.session.IoSession)
     */
    @Override
    public ProtocolEncoder getEncoder(IoSession arg0) throws Exception {
        return encoder;
    }

}  