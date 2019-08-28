$(function () {
    // 1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    // 2.初始化Button的点击事件
    // var oButtonInit = new ButtonInit();
    // oButtonInit.Init();
});

function search() {
    
}

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        //指定操作表
        $('#appRecords').bootstrapTable({
            url: '/controlController/getInfoBymoduleTyep',   //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            // queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "client",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: true,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "resApplyId",                     //每一行的唯一标识，一般为主键列
            showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [
//            	{
//                checkbox: false
//            	},
                {
                    field: 'resApplyId',
                    title: '工单号'
                }, {
                    field: 'deptCode',
                    title: '工单部门'
                }, {
                    field: 'moduleType',
                    title: '工单类型'
                },
                {
                    field: 'applyUserName',
                    title: '申请人'
                },
                {
                    field: 'applyStatus',
                    title: '工单状态', formatter: function (value, row, index) {
                        if (value == '1') {
                            return '初始';
                        }
                        if (value == '2') {
                            return '运行，探测开启';
                        }
                        if (value == '3') {
                            return '停止';
                        }
                        if (value == '4') {
                            return '运行';
                        }
                        if (value == '5') {
                            return '已删除';
                        }
                        return '待审批';
                    }
                }]
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            appGroup: $("#gid option:selected").text()//选中的文本
//            startDate: $("#startDate_input").val(),
//            endDate: $("#endDate_input").val(),
//            esbFlowNo: $("#esbFlowNo_input").val(),
//            reqFlowNo: $("#reqFlowNo_input").val(),
//            flowStepID: $("#flowStepID_input").val(),
//            respStatus: $("#respStatus_input").val(),
//            realChannel: $("#realChannel_input").val(),
//            realSystem: $("#realSystem_input").val(),
//            respCode: $('#respCode_input').val()   
        };
        return temp;
    };
    return oTableInit;
};

//获取下拉菜单
$("#gid").on('shown.bs.select', function (e) {
    $("#gid").empty();
    $.ajax({
        type: "post",
        url: "/controlController/getSel",
        dataType: "json",
        success: function (data) {
            var depart_list = data;
            var opts = "<option value=al></option>";
            opts += "<option value=all>ALL</option>";
            // var opts = "<option value=all>ALL</option>";
            for (var depart_index = 0; depart_index < depart_list.length; depart_index++) {
                var depart = depart_list[depart_index];
                opts += "<option value='" + depart_index + "'>" + depart + "</option>";
            }
            $("#gid").append(opts);
            $("#gid").selectpicker("refresh");//下拉框内容刷新
            // $('#gid').selectpicker('render');
        }
    });
})

//改变下拉框值
$("#gid").change(function () {
    SelectChange();
});

function SelectChange() {
    //获取下拉框选中项的text属性值
    $("#appRecords").bootstrapTable('refreshOptions', {pageNumber: 1, pageSize: 10});

}

//////////////////////

//启动
function startFunction(value, row, index) {
    return [
        '<button id="btn_start" type="button" data-loading-text="启动中..." class="glyphicon glyphicon-play"/>'
    ].join("")
};
window.startEvents = {
    "click #btn_start": function (e, value, row, index) {
//		console.log("click #btn_edit_script");
        //启动按钮加载状态
        $(this).button('loading').delay(10000).queue(function () {
            $(this).button('reset');
            $(this).dequeue();
        });
        $.ajax({
            type: "post",
            url: "/controlController/operate",
            data: {"appNameEn": row.appNameEn, "operateType": "start"},
            success: function (data) {
                var dataObj = JSON.parse(data);
                var resultFlag = dataObj.success;
                if (resultFlag) {
                    toastr.success(dataObj.msg);
//		                $("#scriptModal").modal('hide'); 
                    $("#appRecords").bootstrapTable('refresh');
                } else {
                    toastr.error(dataObj.msg);
                }
            },
            error: function (data) {
                toastr.error('请求服务失败');
            }
        });
    }
}

//停止
function stopFunction(value, row, index) {
    return [
        '<button id="btn_stop" type="button" data-loading-text="关闭中..." class="glyphicon glyphicon-off"/>'
    ].join("")
};
window.stopEvents = {
    "click #btn_stop": function (e, value, row, index) {
//		console.log("click #btn_edit_script");
        //停止按钮加载状态
        $(this).button('loading').delay(10000).queue(function () {
            $(this).button('reset');
            $(this).dequeue();
        });
        $.ajax({
            type: "post",
            url: "/controlController/operate",
            data: {"appNameEn": row.appNameEn, "operateType": "stop"},
            success: function (data) {
                var dataObj = JSON.parse(data);
                var resultFlag = dataObj.success;
                if (resultFlag) {
                    toastr.success(dataObj.msg);
//		                $("#scriptModal").modal('hide'); 
                    $("#appRecords").bootstrapTable('refresh');
                } else {
                    toastr.error(dataObj.msg);
                }
            },
            error: function (data) {
                toastr.error('请求服务失败');
            }
        });
    }
}

function onDetectFunction(value, row, index) {
    return [
        '<button id="btn_detect_on" type="button" class="glyphicon glyphicon-eye-open"/>'
    ].join("")
};
window.onDetectEvents = {
    "click #btn_detect_on": function (e, value, row, index) {
//		console.log("click #btn_edit_script");
        $.ajax({
            type: "post",
            url: "/controlController/operate",
            data: {"appNameEn": row.appNameEn, "operateType": "onDetect"},
            success: function (data) {
                var dataObj = JSON.parse(data);
                var resultFlag = dataObj.success;
                if (resultFlag) {
                    toastr.success(dataObj.msg);
//		                $("#scriptModal").modal('hide'); 
                    $("#appRecords").bootstrapTable('refresh');
                } else {
                    toastr.error(dataObj.msg);
                }
            },
            error: function (data) {
                toastr.error('请求服务失败');
            }
        });
    }
}


function offDetectFunction(value, row, index) {
    return [
        '<button id="btn_detect_off" type="button" class="glyphicon glyphicon-eye-close"/>'
    ].join("")
};
window.offDetectEvents = {
    "click #btn_detect_off": function (e, value, row, index) {
//		console.log("click #btn_edit_script");
        $.ajax({
            type: "post",
            url: "/controlController/operate",
            data: {"appNameEn": row.appNameEn, "operateType": "offDetect"},
            success: function (data) {
                var dataObj = JSON.parse(data);
                var resultFlag = dataObj.success;
                if (resultFlag) {
                    toastr.success(dataObj.msg);
//		                $("#scriptModal").modal('hide'); 
                    $("#appRecords").bootstrapTable('refresh');
                } else {
                    toastr.error(dataObj.msg);
                }
            },
            error: function (data) {
                toastr.error('请求服务失败');
            }
        });
    }
}


//var ButtonInit = function () {
//    var oInit = new Object();
//    var postdata = {};
//    oInit.Init = function () {
//    	$("#btn_journalQuery").click(function () {
//    		var startDate = $("#startDate_input").val();
//            if (startDate==null||startDate.length==0) {
//                toastr.warning('起始时间不能为空！');
//                return;
//            }
//            var endDate = $("#endDate_input").val();
//            if (endDate==null||endDate.length==0) {
//                toastr.warning('终止时间不能为空！');
//                return;
//            }
////    		 $("#journalRecords").bootstrapTable('refresh');
//    		 $("#journalRecords").bootstrapTable('refreshOptions',{pageNumber:1,pageSize:10});
//          });
//    };
//    return oInit;
//};