package com.springKafka.liveDashboard.model;

import java.util.List;

public class UserEvent {
    private List<String> macIds;
    private String roomId;

    public UserEvent(List<String> macIds, String roomId) {
        this.macIds = macIds;
        this.roomId = roomId;
    }

    public UserEvent() {
    }


    public List<String> getMacIds() {
        return macIds;
    }

    public void setMacIds(List<String> macIds) {
        this.macIds = macIds;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }
}
