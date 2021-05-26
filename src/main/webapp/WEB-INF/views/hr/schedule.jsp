<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<jsp:include page="/WEB-INF/views/details/headTag.jsp" />

<body id="page-top">
<link href="<c:url value="/css/FullCalendar.css" />" rel='stylesheet' />
<script src='<c:url value="/js/FullCalendar.js" />'></script>
<script src='<c:url value="/js/gcal.js" />'></script>
<script src='<c:url value="/js/hrAjax.js" />'></script>
<script>
  document.addEventListener('DOMContentLoaded', function() {
    var calendarEl = document.getElementById('calendar');

    var calendar = new FullCalendar.Calendar(calendarEl, {
      headerToolbar: {
        left: 'prev,today,next',
        center: 'title',
        right: ''
      },
      locale : "ko",
      defaultView: 'dayGridMonth',
      businessHours: true, // 휴일 표시
      selectable: true,    
      dateClick : function(info){ // 선택한 날짜 값 뽑아내기
    	  const clickDate = info.dateStr;
    	  add_ClickSchedule(clickDate);
      },
      eventClick: function(info){ // 클릭한 일정 값 뽑아내기
    	  const scheduleNo = info.event.id;
    	  click_work(scheduleNo);
      }
      ,googleCalendarApiKey : "AIzaSyDcnW6WejpTOCffshGDDb4neIrXVUA1EAE" 
      ,eventSources : [
      // 대한민국의 공휴일
          {
                googleCalendarId : "ko.south_korea#holiday@group.v.calendar.google.com"
              , className : "koHolidays"
              , color : "#FF0000"
              , textColor : "#FFFFFF"
          }]
      // 달력 일정 목록 
      ,events: [
    	  // 나의 일정 목록
    	  <c:forEach var="showList" items="${scheduleList}">
    	  {
    		  id 	: '${showList.getScheduleNo()}',
    		  title : '출근기록',
    		  start : '${showList.getToday()}',
    		  end 	: '${showList.getToday()}'
    	  },
    	  </c:forEach>
    	  {
    		  title : '',
    		  start : ''
    	  }
      ]
    });

    calendar.render();
  });
</script>
    <!-- Page Wrapper -->
    <div id="wrapper">
	
        <!-- Sidebar -->
       	<jsp:include page="/WEB-INF/views/details/sidebar.jsp" />

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">
             	<h1>근태 관리</h1>
             	<form action="<c:url value="schedule"/>" method="GET">
             		<input type="text" id="name" name="name" placeholder="검색할 이름 작성"/>
             		<input type="submit" value="검색" />
             	</form>
             	 <div id='calendar' style="position: relative;" >
             	 </div>
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <jsp:include page="/WEB-INF/views/details/footer.jsp" />

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>
</body>

</html>