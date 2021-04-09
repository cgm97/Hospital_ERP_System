 <%@ page language="java" contentType="text/html; charset=UTF-8"
     pageEncoding="UTF-8"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="<c:url value="/"/>">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">OO병원 <sup></sup></div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="<c:url value="/"/>">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Management
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseTrade"
                    aria-expanded="true" aria-controls="collapseTrade">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>재고관리</span>
                </a>
                <div id="collapseTrade" class="collapse" aria-labelledby="collapseTrade" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Trade:</h6>
                        <a class="collapse-item" href="<c:url value="/item/use"/>">약품 사용 등록</a>
                        <a class="collapse-item" href="<c:url value="/item/machineList"/>">의료 기계 현황</a>
                        <a class="collapse-item" href="<c:url value="/item/totalList"/>">총 재고 현황</a>
                    </div>
                </div>
            </li>
			
			<!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseOrder"
                    aria-expanded="true" aria-controls="collapseOrder">
                    <i class="fas fa-fw fa-cart-plus"></i>
                    <span>발주관리</span>
                </a>
                <div id="collapseOrder" class="collapse" aria-labelledby="collapseOrder" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Order:</h6>
                        <a class="collapse-item" href="<c:url value="/order/add"/>">주문 신청</a>
                        <a class="collapse-item" href="<c:url value="/order/list"/>">주문 내역 조회</a>
                    </div>
                </div>
            </li>
            
            <!-- Nav Item - Utilities Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseHR"
                    aria-expanded="true" aria-controls="collapseHR">
                    <i class="fas fa-fw fa-user"></i>
                    <span>인사관리</span>
                </a>
                <div id="collapseHR" class="collapse" aria-labelledby="collapseHR"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Human Resources:</h6>
                        <a class="collapse-item" href="<c:url value="/humanResource/list"/>">직원 목록</a>
                        <a class="collapse-item" href="<c:url value="/humanResource/schedule"/>">근태 관리</a>
                        <a class="collapse-item" href="<c:url value="/humanResource/salary"/>">급여 관리</a>
                    </div>
                </div>
            </li>

             <!-- Nav Item - Utilities Collapse Menu -->
             <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapsePatient"
                    aria-expanded="true" aria-controls="collapsePatient">
                    <i class="fas fa-fw fa-users"></i>
                    <span>환자관리</span>
                </a>
                <div id="collapsePatient" class="collapse" aria-labelledby="collapsePatient"
                    data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">PATIENT:</h6>
                        <a class="collapse-item" href="<c:url value="/patient/add"/>">환자 등록</a>
                        <a class="collapse-item" href="<c:url value="/patient/list"/>">환자 목록</a>
                    </div>
                </div>
            </li>
			
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">

            <!-- Heading -->
            <div class="sidebar-heading">
                doctor
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link collapsed" href="#" data-toggle="collapse" data-target="#collapseEMR"
                    aria-expanded="true" aria-controls="collapseEMR">
                    <i class="fas fa-fw fa-newspaper"></i>
                    <span>EMR</span>
                </a>
                <div id="collapseEMR" class="collapse" aria-labelledby="collapseEMR" data-parent="#accordionSidebar">
                    <div class="bg-white py-2 collapse-inner rounded">
                        <h6 class="collapse-header">Chart:</h6>
                        <a class="collapse-item" href="<c:url value="/emr/add"/>">차트 생성</a>
                        <a class="collapse-item" href="<c:url value="/emr/list"/>">차트 조회</a>
                    </div>
                </div>
            </li>
        </ul>
        <!-- End of Sidebar -->