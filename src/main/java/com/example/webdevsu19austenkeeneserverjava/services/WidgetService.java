package com.example.webdevsu19austenkeeneserverjava.services;

import com.example.webdevsu19austenkeeneserverjava.models.Widget;
import com.example.webdevsu19austenkeeneserverjava.repositories.WidgetRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class WidgetService {

    private static List<Widget> widgets = new ArrayList<>();

    static {
        widgets.add(new Widget("Widget 1", 123, Widget.WidgetType.HEADING, 0, "123",
                "", 1, 10, 10, "123", "123", "123",
                Widget.WidgetDataType.BOOLEAN, "UNORDERED"));
        widgets.add(new Widget("Widget 2", 234, Widget.WidgetType.LIST, 1, "123",
                "", 1, 10, 10, "123", "123", "123",
                Widget.WidgetDataType.BOOLEAN, "UNORDERED"));
        widgets.add(new Widget("Widget 3", 345, Widget.WidgetType.PARAGRAPH, 2, "123",
                "", 1, 10, 10, "123", "123", "123",
                Widget.WidgetDataType.BOOLEAN, "UNORDERED"));
        widgets.add(new Widget("Widget 4", 456, Widget.WidgetType.IMAGE, 3, "123",
                "https://cdn.arstechnica.net/wp-content/uploads/2016/02/5718897981_10faa45ac3_b-640x624.jpg", 1, 10, 10, "123", "123", "123",
                Widget.WidgetDataType.BOOLEAN, "UNORDERED"));
        widgets.add(new Widget("Widget 5", 789, Widget.WidgetType.LINK, 4, "123",
                "https://google.com", 1, 10, 10, "123", "123", "123",
                Widget.WidgetDataType.BOOLEAN, "UNORDERED"));
    }

    public List<Widget> createWidget() {
        widgets.add(new Widget("New Widget", new Random().nextInt(500), Widget.WidgetType.HEADING, widgets.size(), "123",
                "", 1, 10, 10, "123", "123", "123",
                Widget.WidgetDataType.BOOLEAN, "UNORDERED"));
        return widgets;
    }

    public List<Widget> findAllWidgets() {
        return widgets;
    }

    public List<Widget> moveUp(Widget widget) {
        System.out.println("Moving up " + widget.getId());
        for (int i = 0; i < widgets.size(); i++) {
            Widget w = widgets.get(i);
            if (w.getId().equals(widget.getId())) {
                w.setOrder(w.getOrder() - 1);
            } else if (w.getOrder().equals(widget.getOrder() - 1)) {
                w.setOrder(w.getOrder() + 1);
            }
        }

        return widgets;
    }

    public List<Widget> moveDown(Widget widget) {
        for (int i = 0; i < widgets.size(); i++) {
            Widget w = widgets.get(i);
            if (w.getId().equals(widget.getId())) {
                w.setOrder(w.getOrder() + 1);
            } else if (w.getOrder().equals(widget.getOrder() + 1)) {
                w.setOrder(w.getOrder() - 1);
            }
        }

        return widgets;
    }

    public Widget findWidgetById(Integer wid) {
        for(Widget w: widgets) {
            if(w.getId().equals(wid))
                return w;
        }
        return null;
    }

    public Widget updateWidget(Integer wid, Widget widget) {


        for (int i = 0; i < widgets.size(); i++) {
            Widget w = widgets.get(i);
            if (w.getId().equals(wid)) {
                widgets.set(i, widget);
            }
        }

        return widget;
    }

    public List<Widget> deleteWidget(Integer wid) {
        List<Widget> matchingWidgets = widgets.stream().filter(widget -> widget.getId().equals(wid)).collect(Collectors.toList());

        if (matchingWidgets.size() == 0 || matchingWidgets.size() > 1) {
            throw new IllegalArgumentException("Cannot delete widget " + wid + ", " + matchingWidgets.size() + " widgets found");
        }

        Widget w = matchingWidgets.get(0);
        widgets = widgets.stream().filter(widget -> !widget.getId().equals(wid)).collect(Collectors.toList());

        for (Widget widget : widgets) {
            if (widget.getOrder() > w.getOrder()) {
                widget.setOrder(widget.getOrder() - 1);
            }
        }

        return widgets;
    }
}
