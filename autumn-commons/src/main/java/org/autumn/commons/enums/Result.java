package org.autumn.commons.enums;

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
        DEFAULT(0), POST(1), DELETE(2), GET(3), PUT(4);

        private final int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
