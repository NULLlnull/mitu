$(function () {
    /*---------初始化表格start---------*/
    //动态添加表格
    dynamicTable();
    _w_table_rowspan("#data", 1);

    $.ajax({
        type: "GET",
        url: "pkxx/loadTeachers.do",
        data: {},
        dataType: "json",
        success: function (data) {
            $.each(data, function (index, pkxx) {
                $('#teacher').append("<option value='" + pkxx.skjs + "'>" + pkxx.skjsxm + "</option>");
            });
        }
    });

    $.ajax({
        type: "GET",
        url: "pkxx/loadSpaces.do",
        data: {},
        dataType: "json",
        success: function (data) {
            $.each(data, function (index, pkxx) {
                $('#space').append("<option value='" + pkxx.skcddm + "'>" + pkxx.skcdmc + "</option>");
            });
        }
    });

    $.ajax({
        type: "GET",
        url: "pkxx/loadClazz.do",
        data: {},
        dataType: "json",
        success: function (data) {
            $.each(data, function (index, jxrw) {
                $('#clazz').append("<option value='" + jxrw.ssbj + "'>" + jxrw.bjmc + "</option>");
            });
        }
    });
    /*---------初始化表格end---------*/


    /*---------筛选项start---------*/
    //班级选择
    $('#clazz').change(function () {
        $.ajax({
            type: "GET",
            url: "pkxx/loadPkxxByclazz.do",
            data: {
                "ssbj": $('#clazz').val()
            },
            dataType: "json",
            success: function (data) {
                cleartable();
                $.each(data, function (index, pkxx) {
                    //$('#data').find("tr").eq(pkxx.jc).find("td").eq(pkxx.xqs).attr('class', "fc-today fc-state-highlight");
                    var show = pkxx.kcmc + "<br/>" + pkxx.bjmc + '<br/>' + pkxx.pkzc + '<br/>' + pkxx.skjsxm;
                    $('#data').find("tr").eq(pkxx.jc).find("td").eq((pkxx.xqs + 1)).html(show);
                    if (index == 0) {
                        $('#title').html(pkxx.title);
                    }
                });
                mergecell();
                $('#lastOper').val('1');
            }
        });
    });

    //教师选择
    $('#teacher').change(function () {
        $.ajax({
            type: "GET",
            url: "pkxx/loadPkxx.do",
            data: {
                "skjs": $('#teacher').val()
            },
            dataType: "json",
            success: function (data) {
                cleartable();
                $.each(data, function (index, pkxx) {
                    //$('#data').find("tr").eq(pkxx.jc).find("td").eq(pkxx.xqs).attr('class', "fc-today fc-state-highlight");
                    var show = pkxx.kcmc + "<br/>" + pkxx.bjmc + '<br/>' + pkxx.pkzc + '<br/>' + pkxx.skjsxm;
                    $('#data').find("tr").eq(pkxx.jc).find("td").eq((pkxx.xqs + 1)).html(show);
                    if (index == 0) {
                        $('#title').html(pkxx.skjsxm + " 课程表");
                    }
                });
                mergecell();
                $('#lastOper').val('2');
            }
        });
    });

    //场地选择
    $('#space').change(function () {
        $.ajax({
            type: "GET",
            url: "pkxx/loadPkxx.do",
            data: {
                "skcddm": $('#space').val()
            },
            dataType: "json",
            success: function (data) {
                cleartable();
                $.each(data, function (index, pkxx) {
                    //$('#data').find("tr").eq(pkxx.jc).find("td").eq(pkxx.xqs).attr('class', "fc-today fc-state-highlight");
                    var show = pkxx.kcmc + "<br/>" + pkxx.bjmc + '<br/>' + pkxx.pkzc + '<br/>' + pkxx.skjsxm;
                    $('#data').find("tr").eq(pkxx.jc).find("td").eq((pkxx.xqs + 1)).html(show);
                    if (index == 0) {
                        $('#title').html(pkxx.skcdmc + " 课程表");
                    }
                });
                mergecell();
                $('#lastOper').val('3');
            }
        });
    });
    /*-----------筛选项end-----------*/

    /*---------功能区域start---------*/
    $('#printBtn').click(function () {
        $("#data").print({
            globalStyles: true,
            //是否包含父文档的样式，默认为true
            mediaPrint: false,
            //是否包含media='print'的链接标签。会被globalStyles选项覆盖，默认为false
            stylesheet: null,
            //外部样式表的URL地址，默认为null
            noPrintSelector: ".no-print",
            //不想打印的元素的jQuery选择器，默认为".no-print"
            iframe: true,
            //是否使用一个iframe来替代打印表单的弹出窗口，true为在本页面进行打印，false就是说新开一个页面打印，默认为true
            append: null,
            //将内容添加到打印内容的后面
            prepend: $('#title').html(),
            //将内容添加到打印内容的前面，可以用来作为要打印内容
            deferred: $.Deferred() //回调函数
        });
    });


    /*  $("#exportExecl").click(function(){
        	 $('#data').tableExport({formats:['xlsx']});
        	 $('#data caption').css("display","");
        	 $('#data caption button').click();
         }); */


    $('#exportExecl').click(function () {
        var lastOper = $('#lastOper').val();
        var param = "";
        if (lastOper == '1') {
            param = $('#clazz').val();
        } else if (lastOper == '2') {
            param = $('#teacher').val();
        } else if (lastOper == '3') {
            param = $('#space').val();
        } else {
            alert("请选择数据!");
            return;
        }
        window.open(baseUrl + "pkxx/exportExecl.do?type=" + lastOper + "&param=" + param);
    });

    $('#loadAllBtn').click(function () {
        window.open(baseUrl + "pkxx/toListAll.do");
    });
    /*---------功能区域end---------*/
});

/*--------定义函数start---------*/

// 生成要渲染的table
function dynamicTable() {
    $("#data tbody").html("");
    for (var index = 1; index <= 14; index++) {
        var html = "<tr class='fc-week fc-first'>";

        html += "<td class='fc-day fc-mon fc-widget-content fc-past' id='repaint'><div class='fc-day-number'></div>";
        if (index <= 4) {
            html += "上午</td><td class='fc-day fc-mon fc-widget-content fc-past' id='repaint'><div class='fc-day-number'></div>第" + index + "节</td>";
        }
        if (index > 4 && index <= 6) {
            html += "中午</td><td class='fc-day fc-mon fc-widget-content fc-past' id='repaint'><div class='fc-day-number'></div>中午" + (index - 4) + "</td>";
        }
        if (index > 6 && index <= 10) {
            html += "下午</td><td class='fc-day fc-mon fc-widget-content fc-past' id='repaint'><div class='fc-day-number'></div>第" + (index - 2) + "节</td>";
        }
        if (index > 10 && index <= 14) {
            html += "晚上</td><td class='fc-day fc-mon fc-widget-content fc-past' id='repaint'><div class='fc-day-number'></div>第" + (index - 2) + "节</td>";
        }

        for (var col = 2; col <= 8; col++) {
            html += "<td class='fc-day fc-mon fc-widget-content fc-past'><div class='fc-day-content'></div></td>";
        }
        html += "</tr>";
        $('#data').append(html);
    }
}

//重绘table
function cleartable() {
    dynamicTable();
    $("#data tr:not(:first)").each(function () {
        $(this).children('td:not(\'#repaint\')').text("");
    });
}

//合并单元格
function mergecell() {
    for (var i = 1; i < 10; i++) {
        _w_table_rowspan("#data", i);
    }

    //中午
    hideBlankRow("#data", 4, 2);
    //晚上
    hideBlankRow("#data", 10, 4);
    //周六日
    hideWeekendBlankRow("#data");
}

//
function hideBlankRow(_w_table_id, start, end) {
    var flag = false;
    var filter = "tr:gt(" + start + "):lt(" + end + ")";
    var _w_table_tr = $(_w_table_id).find(filter);
    _w_table_tr.each(function () {
        var _w_table_td = $(this).find('td:not(\'#repaint\')');
        _w_table_td.each(function () {
            var val = $(this).text();
            if (val != null && val != undefined && val != "") {
                flag = true;
                return false;
            }
        });
        if (flag) {
            return false;
        }
    });

    if (!flag) {
        var index = start + 1;
        var end = index + end;
        for (; index < end; index++) {
            $(_w_table_id).find("tr").eq(index).css("display", "none");
        }
    }
}

//周末
function hideWeekendBlankRow(_w_table_id) {
    resetHeader();
    var flag = false;
    var filter = "td:gt(6):lt(2)";
    var _w_table_tr = $(_w_table_id).find("tr:not(:eq(1))");
    _w_table_tr.each(function () {
        var _w_table_td = $(this).find(filter);
        _w_table_td.each(function () {
            var val = $(this).text();
            if (val != null && val != undefined && val != "") {
                flag = true;
                return false;
            }
        });
        if (flag) {
            return false;
        }
    });

    if (!flag) {
        $(_w_table_id).find("tr").each(function () {
            $(this).find(filter).each(function () {
                $(this).css("display", "none");
            });
        });
        hideHeader();
    }
}

function resetHeader() {
    var thfilter = "th:gt(6):lt(2)";
    $('#data').find(thfilter).each(function () {
        $(this).css("display", "");
    });
}

function hideHeader() {
    var thfilter = "th:gt(6):lt(2)";
    $('#data').find(thfilter).each(function () {
        $(this).css("display", "none");
    });
}

/*-----------定义函数end----------*/

function loadAll() {
    $.ajax({
        type: "GET",
        url: "pkxx/loadPkxx.do",
        data: {},
        dataType: "json",
        success: function (data) {
            cleartable();
            alert("data=" + data.length);
            $.each(data, function (index, pkxx) {
                //$('#data').find("tr").eq(pkxx.jc).find("td").eq(pkxx.xqs).attr('class', "fc-today fc-state-highlight");
                var show = pkxx.skjsxm + "《" + pkxx.kcmc + "》" + pkxx.bjmc;
                var text = $('#data').find("tr").eq(pkxx.jc).find("td").eq((pkxx.xqs + 1)).html();
                $('#data').find("tr").eq(pkxx.jc).find("td").eq((pkxx.xqs + 1)).html(text + "<br/>" + show);
                if (index == 0) {
                    $('#title').html("全校课程表");
                }
            });
            mergecell();
            $('#lastOper').val('2');
        }
    });
}