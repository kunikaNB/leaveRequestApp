package com.kunika.leaveRequestApp.Controller;


import com.kunika.leaveRequestApp.Entity.LeaveRequest;
import com.kunika.leaveRequestApp.Service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("api/leave_requests")
public class LeaveRequestController {


    private final LeaveRequestService leaveRequestService;

    @Autowired
    public LeaveRequestController(LeaveRequestService leaveRequestService){
        this.leaveRequestService = leaveRequestService;
    }

    @GetMapping
    public ResponseEntity<List<LeaveRequest>> getAllLeaveRequests(){
        List<LeaveRequest> leaveRequests = leaveRequestService.getAllleaveRequests();
        return ResponseEntity.ok(leaveRequests);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaveRequest> getleaveRequestByid(@PathVariable Long id){
        LeaveRequest leaveRequest = leaveRequestService.getleaveRequestById(id);
        if(leaveRequest != null) return ResponseEntity.ok(leaveRequest);
        else return ResponseEntity.notFound().build();
    }

    @PostMapping("createLeaveRequest")
    public ResponseEntity<LeaveRequest> createLeaveRequest(@RequestBody LeaveRequest leaveRequest){
        LeaveRequest createdLeaveRequest = leaveRequestService.createLeaveRequest(leaveRequest);
        return ResponseEntity.created(location(createdLeaveRequest.getId())).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaveRequest> updateLeaveRequest(@PathVariable Long id, @RequestBody LeaveRequest leaveRequest){
        LeaveRequest updatedLeaveRequest = leaveRequestService.updateLeaveRequest(id,leaveRequest);
        if (updatedLeaveRequest != null) {
            return ResponseEntity.ok(updatedLeaveRequest);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeaveRequest(@PathVariable Long id){
        leaveRequestService.deleteLeaveRequest(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LeaveRequest>> getLeaveRequestsByUserId(@PathVariable Long userId){
        List<LeaveRequest> leaveRequests= leaveRequestService.getLeaveRequestsByUserId(userId);
        return ResponseEntity.ok(leaveRequests);
    }

    private URI location(Object resourceId) {
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequestUri()
                .path("/{entityId}")
                .buildAndExpand(resourceId)
                .toUri();
        return location;
    }


}
