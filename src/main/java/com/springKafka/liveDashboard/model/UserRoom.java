package com.springKafka.liveDashboard.model;

import java.util.List;

public class UserRoom {
    private String roomId;
    private List<String> personName;

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public List<String> getPersonName() {
        return personName;
    }

    public void setPersonName(List<String> personName) {
        this.personName = personName;
    }
}
