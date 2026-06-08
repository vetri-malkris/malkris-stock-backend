package com.malkris.stockmanagement.dashboard.controller;

import com.malkris.stockmanagement.common.response.ApiResponse;
import com.malkris.stockmanagement.dashboard.dto.DashboardResponse;
import com.malkris.stockmanagement.dashboard.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping
    public ApiResponse<DashboardResponse> getDashboard() {

        return ApiResponse.success(
                dashboardService.getDashboard()
        );
    }
}