package com.niceapp.model.result;

public class ResultMessage<T> {


    /**
     * result : success
     * action : 操作
     * data : {"token":"AJFLNG949L84HHG114rLNGYbvh42N_"}
     * error : {"code":-10010,"message":"登录错误"}
     */

    private String result;
    private String action;
    private T data;
    private ErrorBean error;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ErrorBean getError() {
        return error;
    }

    public void setError(ErrorBean error) {
        this.error = error;
    }


    public boolean isSuccess() {
        return "success".equals(getResult());
    }

    public static class ErrorBean {
        /**
         * code : -10010
         * message : 登录错误
         */

        private int code;
        private String message;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }

    @Override
    public String toString() {
        return "ResultMessage{" +
                "result='" + result + '\'' +
                ", action='" + action + '\'' +
                ", data=" + data +
                ", error=" + error +
                '}';
    }
}
