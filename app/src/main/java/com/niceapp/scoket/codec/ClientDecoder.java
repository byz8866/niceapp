package com.niceapp.scoket.codec;

import com.google.gson.Gson;
import com.niceapp.model.result.ResultMessage;
import com.niceapp.utils.JsonValidator;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;
import org.apache.mina.filter.codec.CumulativeProtocolDecoder;
import org.apache.mina.filter.codec.ProtocolDecoderOutput;

import java.util.regex.Pattern;


class ClientDecoder extends CumulativeProtocolDecoder {

    /* (non-Javadoc)
     * @see org.apache.mina.filter.codec.ProtocolDecoder#decode(org.apache.mina.core.session.IoSession, org.apache.mina.core.buffer.IoBuffer, org.apache.mina.filter.codec.ProtocolDecoderOutput)
     */
    private Gson gson;

    ClientDecoder() {
        gson = new Gson();
    }

    @Override
    protected boolean doDecode(IoSession session, IoBuffer in, ProtocolDecoderOutput out) throws Exception {

        if (in.remaining() > 8) {//有数据时。读取前8字节推断消息长度

            byte[] validateBytes = new byte[4];
            byte[] sizeBytes = new byte[4];

            in.mark();//标记当前位置。以便reset

            //校验前四个字节验证是否是正常的数据包
            in.get(validateBytes, 0, 4);

            //服务器的数据包的长度是保存在第4-8个字节中，
            in.get(sizeBytes, 0, 4);//读取字节

            int size = 0;
            if (isInteger(new String(sizeBytes))) {
                size = Integer.parseInt(new String(sizeBytes));
            }

            String validate = new String(validateBytes);

            if (!"^&*@".equals(validate) || size == 0) { //如果校验信息不正确，则清空该消息读取下一条消息
                while (in.hasRemaining()) {
                    in.get();
                }
                return false;
            }

            if (size > in.remaining()) { //假设消息内容不够，则重置。相当于不读取size
                in.reset();
                return false;//父类接收新数据，以拼凑成完整数据
            } else {

                byte[] content = new byte[size];
                in.get(content, 0, size);

                String str = new String(content);

                if (str.isEmpty()) {
                    return false;
                }

                if (!new JsonValidator().validate(str)) {
                    return false;
                }

                ResultMessage message = gson.fromJson(str, ResultMessage.class);

                out.write(message);
                if (in.remaining() > 0) {
                    return true;
                }

            }

        }
        return false; //处理成功，让父类进行接收下个包
    }

    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }


}