package com.example.webdevsu19austenkeeneserverjava.controllers;

import com.example.webdevsu19austenkeeneserverjava.models.Widget;
import com.example.webdevsu19austenkeeneserverjava.services.WidgetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class WidgetController {
    private static WidgetService widgetService = new WidgetService();

    @GetMapping("/api/widgets")
    public List<Widget> findAllWidgets() {
        return widgetService.findAllWidgets();
    }
    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(@PathVariable("widgetId") Integer wid) {
        return widgetService.findWidgetById(wid);
    }
    @GetMapping("/api/widgets/action/create")
    public List<Widget> createWidget() {
        return widgetService.createWidget();
    }
    @PostMapping("/api/widgets/move/up")
    public List<Widget> moveUp(@RequestBody Widget widget) {
        return widgetService.moveUp(widget);
    }
    @PostMapping("/api/widgets/move/down")
    public List<Widget> moveDown(@RequestBody Widget widget) {
        return widgetService.moveDown(widget);
    }
    @PostMapping("/api/widgets/action/delete")
    public void deleteWidget(@RequestBody Widget widget) {
        widgetService.deleteWidget(widget);
    }
    @PostMapping("/api/widgets/action/update")
    public Widget updateWidget(@RequestBody Widget widget) {
        return widgetService.updateWidget(widget.getId(), widget);
    }
}
