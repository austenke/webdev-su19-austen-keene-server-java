package com.example.webdevsu19austenkeeneserverjava.controllers;

import com.example.webdevsu19austenkeeneserverjava.models.Widget;
import com.example.webdevsu19austenkeeneserverjava.repositories.WidgetRepository;
import com.example.webdevsu19austenkeeneserverjava.services.WidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@CrossOrigin(origins = "*")
@RestController
public class WidgetController {

    @Autowired
    private WidgetRepository widgetRepository;
    private static WidgetService widgetService = new WidgetService();

    @GetMapping("/api/widget")
    public List<Widget> findAllWidgets() {
        return (List<Widget>) widgetRepository.findAll();
    }

    @GetMapping("/api/widget/{wid}")
    public Widget findWidgetById(@PathVariable("wid") Integer wid) {
        return widgetRepository.findById(wid).orElseThrow(() -> new IllegalArgumentException("No widget with this ID exists"));
    }

    @PostMapping("/api/widget")
    public List<Widget> createWidget() {
        Widget w = new Widget("New Widget", new Random().nextInt(500), Widget.WidgetType.HEADING,
                (int) widgetRepository.count(), "123", "", 1, 10, 10, "123",
                "123", "123",
                Widget.WidgetDataType.BOOLEAN, "UNORDERED");

        widgetRepository.save(w);
        return (List<Widget>) widgetRepository.findAll();
    }

    @PostMapping("/api/widget/move/up")
    public List<Widget> moveUp(@RequestBody Widget widget) {
        for (Widget w : widgetRepository.findAll()) {
            if (w.getOrder() == widget.getOrder() - 1) {
                w.setOrder(widget.getOrder());
                widgetRepository.save(w);
                break;
            }
        }

        widget.setOrder(widget.getOrder() - 1);
        widgetRepository.save(widget);
        return (List<Widget>) widgetRepository.findAll();
    }

    @PostMapping("/api/widget/move/down")
    public List<Widget> moveDown(@RequestBody Widget widget) {
        for (Widget w : widgetRepository.findAll()) {
            if (w.getOrder() == widget.getOrder() + 1) {
                w.setOrder(widget.getOrder());
                widgetRepository.save(w);
                break;
            }
        }

        widget.setOrder(widget.getOrder() + 1);
        widgetRepository.save(widget);
        return (List<Widget>) widgetRepository.findAll();
    }

    @DeleteMapping("/api/widget/{wid}")
    public void deleteWidget(@PathVariable("wid") Integer wid) {
        widgetRepository.deleteById(wid);
    }

    @PutMapping("/api/widget/{wid}")
    public Widget updateWidget(@PathVariable("wid") Integer wid, @RequestBody Widget widget) {
        widgetRepository.save(widget);
        return widget;
    }
}
