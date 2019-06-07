package com.example.webdevsu19austenkeeneserverjava.models;

public class Widget {

    public enum WidgetType {
        HEADING, LIST, PARAGRAPH, IMAGE, LINK
    }

    public enum WidgetDataType {
        INTEGER, STRING, DATE, BOOLEAN
    }

    private String name;
    private Integer id;
    private WidgetType type;
    private Integer order;
    private String text;
    private String url;
    private Integer size;
    private Integer width;
    private Integer height;
    private String cssClass;
    private String style;
    private String value;
    private WidgetDataType dataType;
    private String listOrder;

    public Widget() {

    }

    public Widget(String name, Integer id, WidgetType type, Integer order, String text, String url, Integer size, Integer width, Integer height, String cssClass, String style, String value, WidgetDataType dataType, String listOrder) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.order = order;
        this.text = text;
        this.url = url;
        this.size = size;
        this.width = width;
        this.height = height;
        this.cssClass = cssClass;
        this.style = style;
        this.value = value;
        this.dataType = dataType;
        this.listOrder = listOrder;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public WidgetType getType() {
        return type;
    }

    public void setType(WidgetType type) {
        this.type = type;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public String getCssClass() {
        return cssClass;
    }

    public void setCssClass(String cssClass) {
        this.cssClass = cssClass;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public WidgetDataType getDataType() {
        return dataType;
    }

    public void setDataType(WidgetDataType dataType) {
        this.dataType = dataType;
    }

    public String getListOrder() {
        return listOrder;
    }

    public void setListOrder(String listOrder) {
        this.listOrder = listOrder;
    }
}
