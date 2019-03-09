//节次
var JCS = ["1", "2", "3", "4", "中1", "中2", "1", "2", "3", "4", "晚1", "晚2", "晚3", "晚4"];

$(function () {
    /*---------初始化表格start---------*/
    //动态添加表格
    cleartable();
    _w_table_rowspan("#data", 1);

    /*---------初始化表格end---------*/

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

    $('#exportExecl').click(function () {
        var lastOper = $('#lastOper').val();
        var param = "";
        if (lastOper == '1') {
            param = $('#clazz').val();
        } else if (lastOper == '2') {
            param = $('#teacher').val();
        } else if (lastOper == '3') {
            param = $('#space').val();
        }

        window.open(baseUrl + "pkxx/exportAll.do?type=" + lastOper + "&param=" + param);
    });

    $('#loadAllBtn').click(function () {
        loadAll();
    });
    /*---------功能区域end---------*/
});

/*--------定义函数start---------*/
function initTableHead() {
    var html = "<tr class='fc-week fc-first'>";
    html += "<td class='fc-day fc-mon fc-widget-content fc-past'></td>";
    for (var xq = 0; xq < 7; xq++) {
        for (var jc = 0; jc < JCS.length; jc++) {
            html += "<td class='fc-day fc-mon fc-widget-content fc-past'>" + JCS[jc] + "</td>";
        }
    }
    html += "</tr>";
    $('#data').append(html);
}

// 生成要渲染的table
function loadClazz() {
    $.ajax({
        type: "GET",
        url: "bjxx/listAll.do",
        data: {},
        dataType: "json",
        success: function (data) {
            $.each(data, function (index, bjxx) {
                var html = "<tr class='fc-week fc-first'>";
                html += "<td class='fc-day fc-mon fc-widget-content fc-past' id='repaint'>" + bjxx.bjmc + "</td>";
                for (var xq = 1; xq <= 7; xq++) {
                    for (var jc = 1; jc <= 14; jc++) {
                        var id = "td_" + bjxx.bjdm + "_" + xq + "_" + jc;
                        html += "<td class='fc-day fc-mon fc-widget-content fc-past'>";
                        html += "<div class='fc-day-content' id=" + id + "></div></td>";
                    }
                }
                html += "</tr>";
                $('#data').append(html);

                //$('#clazz').append("<option value='" + jxrw.ssbj + "'>" + jxrw.bjmc + "</option>");
            });
        }
    });
}

//重绘table
function cleartable() {
    $("#data tbody").html("");
    initTableHead();
    loadClazz();
}

/*-----------定义函数end----------*/

function loadAll() {
    $.ajax({
        type: "GET",
        url: "pkxx/loadPkxx.do",
        data: {},
        dataType: "json",
        success: function (data) {
            //cleartable();
            $.each(data, function (index, pkxx) {
                var tdId = '#td_' + pkxx.ssbj + "_" + pkxx.xqs + "_" + pkxx.jc;
                if (index == 0) {
                    $('#title').html("全校课程表");
                }
                var show = pkxx.skjsxm + '<br/>' + "《" + pkxx.kcmc + "》" + '<br/>' + pkxx.skcdmc;
                $(tdId).html(show);
            });
            merge_col('#data');
            hide_blank_row('#data');
            //$('#lastOper').val('2');
        }
    });
}