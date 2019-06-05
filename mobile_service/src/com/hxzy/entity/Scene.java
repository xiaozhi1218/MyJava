package com.hxzy.entity;

/**
 * 使用场景
 *
 * @author chenyongzhi
 * @create 2019/6/3 15:56
 */
public class Scene {

    private String type;

    private int data;

    private String description;

    public Scene() {
        //super();
    }

    public Scene(String type, int data, String description) {
        this.type = type;
        this.data = data;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
