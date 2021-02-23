package com.shopMallProject.common.utils;

public class Constant {

    /**
     * Controller 方法类型枚举
     * 0：LOGIN 登录
     * 1：CREATE 添加
     * 2：QUERY 查询
     * 3：UPDATE 修改
     * 4：DELETE 删除
     * 9：LOGOUT 登出
     *
     * @version：2018年9月27日 下午10:13:08
     * @author：49935
     */
    public enum MethodType {
        EMPTY("", "EMPTY"),
        LOGIN("0", "LOGIN"),
        CREATE("1", "CREATE"),
        QUERY("2", "QUERY"),
        UPDATE("3", "UPDATE"),
        DELETE("4", "DELETE"),
        LOGOUT("9", "LOGOUT");

        private String value;

        private String name;

        public String getValue() {
            return value;
        }

        public String getName() {
            return name;
        }

        MethodType(String value, String name) {
            this.value = value;
            this.name = name;
        }

    }
}
