package com.kunika.leaveRequestApp.Service;

import com.kunika.leaveRequestApp.Entity.LeaveRequest;
import com.kunika.leaveRequestApp.Entity.User;
import com.kunika.leaveRequestApp.Enums.LeaveType;

import java.util.List;

public interface LeaveRequestService {

    List<LeaveRequest> getAllleaveRequests();

    LeaveRequest getleaveRequestById(Long id);

    LeaveRequest createLeaveRequest(LeaveRequest leaveRequest);

    LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest);

    void deleteLeaveRequest(Long id);

    List<LeaveRequest> getLeaveRequestsByUserId(Long userId);
}
