<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

    <script>
        //检索数据集
        var dataList = {
            "grade_universityName": null,
            "grade_type": null,
            "grade_location":null,
            "grade_upto":null,
            "orderBy": null,
            "isDesc": true
        };
        $(function () {
            /******
             * event
             ******/
            //点击查询按钮时
            $("#btn_grade_submit").click(function () {
                var grade_universityName = $.trim($("#input_grade_universityName").val());
                var grade_type= $.trim($("#input_grade_type").val());
                var grade_location = $.trim($("#input_grade_location").val());
                var grade_upto = $.trim($("#input_grade_upto").val());
                //高校性别数组
                //封装数据
                dataList.grade_universityName = encodeURI(grade_universityName);
                dataList.grade_type = encodeURI(grade_type);
                dataList.grade_location = encodeURI(grade_location);
                dataList.grade_upto = encodeURI(grade_upto);

                getData($(this), "fore/grade/0/10", dataList);
            });
            //点击刷新按钮时
            $("#btn_grade_refresh").click(function () {
                //清除数据
                dataList.grade_universityName = null;
                dataList.grade_type=null;
                dataList.grade_location=null;
                dataList.grade_upto=null;
                dataList.orderBy = null;
                dataList.isDesc = true;
                //获取数据
                getData($(this), "fore/grade/0/10", null);
                //清除排序样式
                var table = $("#table_grade_list");
                table.find("span.orderByDesc,span.orderByAsc").css("opacity","0");
                table.find("th.data_info").attr("data-sort","asc");
            });
            //点击th排序时
            $("th.data_info").click(function () {
                var table = $("#table_grade_list");
                if(table.find(">tbody>tr").length <= 1){
                    return;
                }
                //获取排序字段
                dataList.orderBy = $(this).attr("data-name");
                //是否倒序排序
                dataList.isDesc = $(this).attr("data-sort")==="asc";

                getData($(this), "fore/grade/0/10", dataList);
                //设置排序
                table.find("span.orderByDesc,span.orderByAsc").css("opacity","0");
                if(dataList.isDesc){
                    $(this).attr("data-sort","desc").children(".orderByAsc.orderBySelect").removeClass("orderBySelect").css("opacity","1");
                    $(this).children(".orderByDesc").addClass("orderBySelect").css("opacity","1");
                } else {
                    $(this).attr("data-sort","asc").children(".orderByDesc.orderBySelect").removeClass("orderBySelect").css("opacity","1");
                    $(this).children(".orderByAsc").addClass("orderBySelect").css("opacity","1");
                }
            });
            //点击table中的数据时
            $("#table_grade_list").find(">tbody>tr").click(function () {
                trDataStyle($(this));
            });
        });
        //获取高校数据
        function getData(object,url,dataObject) {
            var table = $("#table_grade_list");
            var tbody = table.children("tbody").first();
            $.ajax({
                url: url,
                type: "get",
                data: dataObject,
                traditional: true,
                success: function (data) {
                    //清空原有数据
                    tbody.empty();
                    //设置样式
                    $(".loader").css("display","none");
                    object.attr("disabled",false);
                    //显示高校统计数据
                    $("#grade_count_data").text(data.gradeCount);
                    if (data.gradeList.length > 0) {
                        for (var i = 0; i < data.gradeList.length; i++) {

                            var grade_universityName = data.gradeList[i].grade_universityName;
                            var grade_type = data.gradeList[i].grade_type;
                            var grade_location = data.gradeList[i].grade_location;
                            var grade_year = data.gradeList[i].grade_year;
                            var grade_rank= data.gradeList[i].grade_rank;
                            var grade_predict   = data.gradeList[i].grade_predict;
                            //显示高校数据
                            tbody.append("<tr><td><input type='checkbox' class='cbx_select' id='cbx_university_select_" + grade_universityName + "'>" +
                                "<label for='cbx_university_select_" + grade_universityName + "'></label>" +
                                "</td><td title='" + grade_universityName + "'>" + grade_universityName + "</td>" +
                                "<td title='" + grade_year + "'>" + grade_year + "</td>"+
                                "<td title='" + grade_location + "'>" + grade_location + "</td><" +
                                "td title='" + grade_type + "'>" + grade_type + "</td>" +
                                "<td title='" + grade_rank + "'>" + grade_rank + "</td>"+
                                "<td title='" + grade_predict + "'>" + grade_predict + "</td>");
                        }
                        //绑定事件
                        tbody.children("tr").click(function () {
                            trDataStyle($(this));
                        });
                        //分页
                        var pageUtil = {
                            index: data.pageUtil.index,
                            count: data.pageUtil.count,
                            total: data.pageUtil.total,
                            totalPage: data.totalPage
                        };
                        createPageDiv($(".loader"), pageUtil);
                    }
                },
                beforeSend: function () {
                    $(".loader").css("display","block");
                    object.attr("disabled",true);
                },
                error: function () {

                }
            });
        }

        //获取高校子界面
        function getChildPage(obj) {
            //设置样式
            $("#div_home_title").children("span").text("高校详情");
            document.title = "高校详情";
            //ajax请求页面
            // ajaxUtil.getPage("grade/" + $(obj).parents("tr").find(".grade_id").text(), null, true);
        }

        //获取页码数据
        function getPage(index) {
            getData($(this), "fore/grade/" + index + "/10", dataList);
        }
    </script>
    <style rel="stylesheet">
        #lbl_grade_universityName{
            width: 65px;
        }
    </style>
</head>
<body>
<div class="frm_div text_info">
    <div class="frm_group">
        <label class="frm_label" id="lbl_grade_universityName" for="input_grade_universityName">高校名</label>


        <input class="frm_input" id="input_grade_universityName" type="text" maxlength="50"/>
        <label class="frm_label" id="lbl_grade_location" for="input_grade_location">高考地点</label>
<%--        <input class="frm_input" id="input_grade_location" type="text" maxlength="50"/>--%>
        <select class="frm_input" id="input_grade_location" value="11">
            <option value="11">北京</option>
            <option value="12">天津</option>
            <option value="13">河北</option>
            <option value="14">山西</option>
            <option value="15">内蒙古</option>
            <option value="21">辽宁</option>
            <option value="22">吉林</option>
            <option value="23">黑龙江</option>
            <option value="31">上海</option>
            <option value="32">江苏</option>
            <option value="33">浙江</option>
            <option value="34">安徽</option>
            <option value="35">福建</option>
            <option value="36">江西</option>
            <option value="37">山东</option>
            <option value="41">河南</option>
            <option value="42">湖北</option>
            <option value="43">湖南</option>
            <option value="44">广东</option>
            <option value="45">广西</option>
            <option value="46">海南</option>
            <option value="50">重庆</option>
            <option value="51">四川</option>
            <option value="52">贵州</option>
            <option value="53">云南</option>
            <option value="54">西藏</option>
            <option value="61">陕西</option>
            <option value="62">甘肃</option>
            <option value="63">青海</option>
            <option value="64">宁夏</option>
            <option value="65">新疆</option>
            <option value="71">台湾</option>
            <option value="81">香港</option>
            <option value="82">澳门</option>
        </select>


        <label class="frm_label" id="lbl_grade_type" for="input_grade_type">文/理科选择</label>
        <select  class="frm_input" id="input_grade_type"  value="0">
            <option value="0">理科</option>
            　　<option  value="1">文科</option>
        </select>
        <label class="frm_label" id="lbl_grade_upto" for="input_grade_upto">预估成绩</label>
        <input class="frm_input" id="input_grade_upto" type="text" maxlength="50"/>
        <input class="frm_btn" id="btn_grade_submit" type="button" value="查询"/>
        <input class="frm_btn frm_clear" id="btn_clear" type="button" value="重置"/>
    </div>

    <div class="frm_group_last">
        <input class="frm_btn frm_refresh" id="btn_grade_refresh" type="button" value="刷新高校列表"/>
    </div>
</div>
<div class="data_count_div text_info">
    <svg class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="2522" width="16"
         height="16">
        <path d="M401.976676 735.74897c-88.721671 0-172.124196-34.635845-234.843656-97.526197-62.724577-62.86784-97.271394-146.453537-97.271394-235.358379s34.546817-172.490539 97.276511-235.361449c62.715367-62.887282 146.117892-97.522104 234.838539-97.522104 88.719624 0 172.135452 34.633798 234.881518 97.522104 62.704111 62.875003 97.235578 146.4607 97.235578 235.361449 0 88.901773-34.530444 172.487469-97.231485 235.358379C574.112128 701.116195 490.6963 735.74897 401.976676 735.74897zM401.976676 121.204479c-75.012438 0-145.533584 29.290093-198.572568 82.474386-109.585861 109.834524-109.585861 288.539602-0.004093 398.36901 53.043077 53.188386 123.564223 82.47848 198.577684 82.47848 75.015507 0 145.553027-29.291117 198.620663-82.47848C710.126918 492.220514 710.126918 313.511343 600.593246 203.678866 547.530726 150.496619 476.992183 121.204479 401.976676 121.204479z"
              p-id="2523" fill="#FF7874">
        </path>
        <path d="M932.538427 958.228017c-6.565533 0-13.129019-2.508123-18.132986-7.52437L606.670661 642.206504c-9.989515-10.014074-9.969049-26.231431 0.045025-36.220946s26.230408-9.969049 36.220946 0.045025l307.73478 308.497143c9.989515 10.014074 9.969049 26.231431-0.045025 36.220946C945.627537 955.735244 939.081447 958.228017 932.538427 958.228017z"
              p-id="2524" fill="#FF7874">
        </path>
    </svg>

</div>
<div class="table_normal_div">
    <table class="table_normal" id="table_grade_list">
        <thead class="text_info">
        <tr>
            <th><input type="checkbox" class="cbx_select" id="cbx_select_all"><label for="cbx_select_all"></label></th>
            <th class="data_info" data-sort="asc" data-name="grade_universityName">
                <span>高校名</span>
                <span class="orderByDesc"></span>
                <span class="orderByAsc orderBySelect"></span>
            </th>
            <th class="data_info" data-sort="asc" data-name="grade_year">
                <span>年份</span>
                <span class="orderByDesc"></span>
                <span class="orderByAsc orderBySelect"></span>
            </th>
            <th class="data_info" data-sort="asc" data-name="grade_location">
                <span>高考地</span>
                <span class="orderByDesc"></span>
                <span class="orderByAsc orderBySelect"></span>
            </th>
            <th class="data_info" data-sort="asc" data-name="grade_type">
                <span>文/理科</span>
                <span class="orderByDesc"></span>
                <span class="orderByAsc orderBySelect"></span>
            </th>
            <th class="data_info" data-sort="asc" data-name="grade_rank">
                <span>分数线/排名</span>
                <span class="orderByDesc"></span>
                <span class="orderByAsc orderBySelect"></span>
            </th>
            <th class="data_info" data-sort="asc" data-name="grade_rank">
                <span>预测分数线</span>
                <span class="orderByDesc"></span>
                <span class="orderByAsc orderBySelect"></span>
            </th>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${requestScope.gradeList}" var="grade">
            <tr>
                <td><input type="checkbox" class="cbx_select" id="cbx_university_select_${grade.grade_universityName}"><label for="cbx_university_select_${grade.grade_universityName}"></label></td>
                <td title="${grade.grade_universityName}">${grade.grade_universityName}</td>
                <td title="${grade.grade_year}">${grade.grade_year}</td>
                <td title="${grade.grade_location}">${grade.grade_location}</td>
                <td title="${grade.grade_type}">${grade.grade_type}</td>
                <td title="${grade.grade_rank}">${grade.grade_rank}</td>
                <td title="${grade.grade_predict}">${grade.grade_predict}</td>
<%--                <td title="${grade.grade_desc}">${grade.grade_desc}</td>--%>
                    <%--                <td>--%>
                    <%--                    <c:choose>--%>
                    <%--                        <c:when test="${grade.grade_gender==0}">男</c:when>--%>
                    <%--                        <c:otherwise>女</c:otherwise>--%>
                    <%--                    </c:choose>--%>
                    <%--                </td>--%>
<%--                <td><span class="td_special" title="查看高校详情"><a href='javascript:void(0)'--%>
<%--                                                               onclick='getChildPage(this)'>详情</a></span></td>--%>
<%--                <td hidden class="grade_id">${grade.grade_id}</td>--%>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <%@ include file="include/page.jsp" %>
    <div class="loader"></div>
</div>
</body>
</html>
