package com.kunika.leaveRequestApp.Repository;

import com.kunika.leaveRequestApp.Entity.LeaveRequest;
import com.kunika.leaveRequestApp.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LeaveRequestRepository extends JpaRepository<LeaveRequest, Long> {
    List<LeaveRequest> findByUser(User user);

    List<LeaveRequest> findByUserId(Long userId);
}
