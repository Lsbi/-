package com.lsb.pojo;

/**
 * 品牌实体类
 */

public class Room {
    // id 主键
    private Integer id        ;
    // 日期
    private String borrowDate;
    // 时间段,1表示8:00-12:00,2表示13:00-17:00,3表示18:00-22:00
    private Integer timeSlot ;
    // 会议室名称
    private String roomName ;
    // 会议室容量
    private Integer capacity  ;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(String borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Integer getTimeSlot() {
        return timeSlot;
    }

    public void setTimeSlot(Integer timeSlot) {
        this.timeSlot = timeSlot;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    // 会议室状态,0表示未被借用
    private Integer status    ;

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", borrowDate='" + borrowDate + '\'' +
                ", timeSlot=" + timeSlot +
                ", roomName='" + roomName + '\'' +
                ", capacity=" + capacity +
                ", status=" + status +
                '}';
    }
}
