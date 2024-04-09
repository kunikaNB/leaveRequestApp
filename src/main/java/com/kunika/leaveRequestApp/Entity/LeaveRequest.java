package com.kunika.leaveRequestApp.Entity;

import com.kunika.leaveRequestApp.Enums.DayType;
import com.kunika.leaveRequestApp.Enums.HalfDayPeriod;
import com.kunika.leaveRequestApp.Enums.LeaveType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "leave_requests")
@Data
public class LeaveRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(name = "new_request", nullable = false)
    private boolean newRequest;

    @Column(name = "business_holiday_checked", nullable = false)
    private boolean businessHolidayChecked;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private LeaveType leaveType;

    @Enumerated(EnumType.STRING)
    @Column(name = "day_type", nullable = false)
    private DayType dayType;

    @Enumerated(EnumType.STRING)
    @Column(name = "half_day_period")
    private HalfDayPeriod halfDayPeriod;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column
    private String reason;

    // Getters and setters
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    // Getters and setters...

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNewRequest() {
        return newRequest;
    }

    public void setNewRequest(boolean newRequest) {
        this.newRequest = newRequest;
    }

    public boolean isBusinessHolidayChecked() {
        return businessHolidayChecked;
    }

    public void setBusinessHolidayChecked(boolean businessHolidayChecked) {
        this.businessHolidayChecked = businessHolidayChecked;
    }

    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    public DayType getDayType() {
        return dayType;
    }

    public void setDayType(DayType dayType) {
        this.dayType = dayType;
    }

    public HalfDayPeriod getHalfDayPeriod() {
        return halfDayPeriod;
    }

    public void setHalfDayPeriod(HalfDayPeriod halfDayPeriod) {
        this.halfDayPeriod = halfDayPeriod;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }


}
