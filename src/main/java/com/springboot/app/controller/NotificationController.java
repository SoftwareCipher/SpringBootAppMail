package com.springboot.app.controller;

import com.springboot.app.entities.Notification;
import com.springboot.app.service.impl.NotificationServiceInterface;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(tags = "NotificationController", description = "NotificationController | Rest questions")
@RequestMapping("/notificationApi")
public class NotificationController {

    NotificationServiceInterface notificationEntityService;

    @Autowired
    public NotificationController(NotificationServiceInterface notificationEntityService) {
        this.notificationEntityService = notificationEntityService;
    }

    @GetMapping("/notifications")
    @ApiOperation("Get all notifications")
    public List<Notification> getAllNotification() {
        return notificationEntityService.getAllEntities();
    }

    @GetMapping("/notification/{id}")
    @ApiOperation("Get notification by id")
    public Notification getNotification(@PathVariable long id) {
        Notification notification = notificationEntityService.getEntity(id);
        if (notification == null) {
            System.out.println("There is no Package with id = " + id + " in database");
        }
        return notification;
    }

    @PostMapping("/notification")
    @ApiOperation("Save notification")
    public Notification saveNotification(@RequestBody Notification notification) {
        notificationEntityService.saveOrUpdateEntity(notification);
        return notification;
    }
}