package com.kunika.leaveRequestApp.Service;

import com.kunika.leaveRequestApp.Entity.LeaveRequest;
import com.kunika.leaveRequestApp.Repository.LeaveRequestRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeaveRequestServiceImpl implements LeaveRequestService {
    private final LeaveRequestRepository leaveRequestRepository;

    public LeaveRequestServiceImpl(LeaveRequestRepository leaveRequestRepository) {
        this.leaveRequestRepository = leaveRequestRepository;
    }

    @Override
    public List<LeaveRequest> getAllleaveRequests() {
        List<LeaveRequest> leaveRequests = (List<LeaveRequest>) leaveRequestRepository.findAll();
        return leaveRequests;
    }

    @Override
    public LeaveRequest getleaveRequestById(Long id) {
        Optional<LeaveRequest> leaveRequest = leaveRequestRepository.findById(id);
        return leaveRequest.orElse(null);

    }

    @Override
    public LeaveRequest createLeaveRequest(LeaveRequest leaveRequest) {
        return leaveRequestRepository.save(leaveRequest);
    }

    @Override
    public LeaveRequest updateLeaveRequest(Long id, LeaveRequest leaveRequest) {
        Optional<LeaveRequest> optionalLeaveRequest = leaveRequestRepository.findById(id);
        if(optionalLeaveRequest != null){
            LeaveRequest existingLeaveRequest = optionalLeaveRequest.get();
            existingLeaveRequest.setStartDate(leaveRequest.getStartDate());
            existingLeaveRequest.setEndDate(leaveRequest.getEndDate());
            existingLeaveRequest.setDayType(leaveRequest.getDayType());
            existingLeaveRequest.setHalfDayPeriod(leaveRequest.getHalfDayPeriod());
            existingLeaveRequest.setLeaveType(leaveRequest.getLeaveType());
            return leaveRequestRepository.save(existingLeaveRequest);
        }
        return null;
    }

    @Override
    public void deleteLeaveRequest(Long id) {

        leaveRequestRepository.deleteById(id);

    }

    @Override
    public List<LeaveRequest> getLeaveRequestsByUserId(Long userId) {
        return leaveRequestRepository.findByUserId(userId);
    }
}
