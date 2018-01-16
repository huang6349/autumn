package org.autumn.commons.enums;

import org.apache.commons.lang.StringUtils;

public enum Result {
    SUCCESS(200, "请求成功"),
    SUCCESS_POST(200, "新增数据成功"),
    SUCCESS_DELETE(200, "删除数据成功"),
    SUCCESS_GET(200, "查询数据成功"),
    SUCCESS_PUT(200, "修改数据成功"),
    ERROR(500, "请求失败，请稍后再试"),
    ERROR_POST(500, "新增数据失败，请稍后再试"),
    ERROR_DELETE(500, "删除数据失败，请稍后再试"),
    ERROR_GET(500, "查询数据失败，请稍后再试"),
    ERROR_PUT(500, "修改数据失败，请稍后再试");

    private final int state;

    private final String message;

    Result(int state, String message) {
        this.state = state;
        this.message = message;
    }

    public int getState() {
        return state;
    }

    public String getMessage() {
        return message;
    }

    public enum Type {
        DEFAULT(0) {
            @Override
            public int getState(Network network, Integer state) {
                return (state == null) ? ((Network.SUCCESS == network) ? SUCCESS.getState() : ERROR.getState()) : state;
            }

            @Override
            public String getMessage(Network network, String message) {
                return StringUtils.isBlank(message) ? ((Network.SUCCESS == network) ? SUCCESS.getMessage() : ERROR.getMessage()) : message;
            }
        },
        POST(1) {
            @Override
            public int getState(Network network, Integer state) {
                return (state == null) ? ((Network.SUCCESS == network) ? SUCCESS_POST.getState() : ERROR_POST.getState()) : state;
            }

            @Override
            public String getMessage(Network network, String message) {
                return StringUtils.isBlank(message) ? ((Network.SUCCESS == network) ? SUCCESS_POST.getMessage() : ERROR_POST.getMessage()) : message;
            }
        },
        DELETE(2) {
            @Override
            public int getState(Network network, Integer state) {
                return (state == null) ? ((Network.SUCCESS == network) ? SUCCESS_DELETE.getState() : ERROR_DELETE.getState()) : state;
            }

            @Override
            public String getMessage(Network network, String message) {
                return StringUtils.isBlank(message) ? ((Network.SUCCESS == network) ? SUCCESS_DELETE.getMessage() : ERROR_DELETE.getMessage()) : message;
            }
        },
        GET(3) {
            @Override
            public int getState(Network network, Integer state) {
                return (state == null) ? ((Network.SUCCESS == network) ? SUCCESS_GET.getState() : ERROR_GET.getState()) : state;
            }

            @Override
            public String getMessage(Network network, String message) {
                return StringUtils.isBlank(message) ? ((Network.SUCCESS == network) ? SUCCESS_GET.getMessage() : ERROR_GET.getMessage()) : message;
            }
        },
        PUT(4) {
            @Override
            public int getState(Network network, Integer state) {
                return (state == null) ? ((Network.SUCCESS == network) ? SUCCESS_PUT.getState() : ERROR_PUT.getState()) : state;
            }

            @Override
            public String getMessage(Network network, String message) {
                return StringUtils.isBlank(message) ? ((Network.SUCCESS == network) ? SUCCESS_PUT.getMessage() : ERROR_PUT.getMessage()) : message;
            }
        };

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public abstract int getState(Network network, Integer state);

        public abstract String getMessage(Network network, String message);
    }

    public enum Network {
        SUCCESS(1), ERROR(2);

        private final int value;

        Network(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
