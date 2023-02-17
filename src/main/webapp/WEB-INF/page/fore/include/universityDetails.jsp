<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <script>
        $(function () {

            /******
             * event
             ******/
            //单击取消按钮时
            $("#btn_university_cancel").click(function () {
                $(".menu_li[data-toggle=university]").click();
            });
        });
    </script>
    <style rel="stylesheet">
  

        #table_orderItem_list th:first-child {
            width: auto;
        }
    </style>
</head>

<body>
<div class="details_div_first">
    <input type="hidden" value="${requestScope.university.university_id}" id="details_university_id"/>
    <div class="frm_div">
        <label class="frm_label text_info" id="lbl_university_id">高校编号</label>
        <span class="details_value" id="span_university_id">${requestScope.university.university_id}</span>
    </div>
    <div class="frm_div">
        <label class="frm_label text_info" id="lbl_university_name">高校名</label>
        <span class="details_value" id="span_university_name">${requestScope.university.university_name}</span>
    </div>
</div>
<div class="details_div">
    <span class="details_title text_info">基本信息</span>
    <div class="frm_div">
        <label class="frm_label text_info" id="lbl_university_nickname">高校地址</label>
        <span class="details_value details_value_noRows">${requestScope.university.university_location}</span>
    </div>
    <div class="frm_div">
        <label class="frm_label text_info" id="lbl_university_realname">高校人气</label>
        <span class="details_value details_value_noRows">${requestScope.university.university_popularity}</span>
    </div>
    <div class="frm_div">
        <label class="frm_label text_info" id="lbl_university_birthday">高校概述</label>
        <span class="details_value details_value_noRows">${requestScope.university.university_desc}</span>
    </div>
    <div class="frm_div">
        <label class="frm_label text_info" id="lbl_university_address">开设专业</label>
        <span class="details_value details_value_noRows"
              id="span_university_address">${requestScope.university.university_majors}</span>
    </div>

</div>


<div class="loader"></div>
</body>
</html>
