$(function () {
    // 1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    // 2.初始化Button的点击事件
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        $('#journalRecords').bootstrapTable({
            url: '/journalController/journalQuery',   //请求后台的URL（*）
            method: 'post',                      //请求方式（*）
            contentType: "application/x-www-form-urlencoded",//post请求的话就加上这个句话
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
            sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
            pageNumber: 1,                       //初始化加载第一页，默认第一页
            pageSize: 10,                       //每页的记录行数（*）
            pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
            search: false,                       //是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
            strictSearch: true,
            showColumns: true,                  //是否显示所有的列
            showRefresh: false,                  //是否显示刷新按钮
            minimumCountColumns: 2,             //最少允许的列数
            clickToSelect: true,                //是否启用点击选中行
            height: 500,                        //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
            uniqueId: "esbFlowNo",                     //每一行的唯一标识，一般为主键列
            showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表

            showExport: true,                   //是否显示导出按钮
            exportTypes: ['excel'],              //导出文件类型
            exportDataType: "all",              //basic', 'all', 'selected'.
            exportOptions: {
                fileName: '流水查询表',           //文件名称设置
                tableName: '流水查询表'
            },

            columns: [
//            	{
//                checkbox: false
//            	},
                {
                    field: 'esbFlowNo',
                    title: 'ESB流水号'
                }, {
                    field: 'reqFlowNo',
                    title: '全局流水号'
                }, {
                    field: 'respCode',
                    title: '响应码'
                }, {
                    field: 'realChannel',
                    title: '请求方'
                }, {
                    field: 'realSystem',
                    title: '服务方'
                }, {
                    field: 'flatDate',
                    title: '交易时间'
                },{
                    field: 'respStatus',
                    title: '响应状态'
                },  {
                    field: 'flowStepID',
                    title: '流水位置'
                }, {
                    field: 'txntlrno',
                    title: '交易码'
                }, {
                    field: 'dstcno',
                    title: '交易柜员'
                }
                , {
                    field: 'instno',
                    title: '机构代号'
                }, {
                    field: 'pkgcontent',
                    title: '报文',
                    events:operateEvents,//给按钮注册事件
                    formatter:addFunctionAlty//表格中增加按钮
                }]
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            startDate: $("#startDate_input").val(),
            endDate: $("#endDate_input").val(),
            esbFlowNo: $("#esbFlowNo_input").val(),
            reqFlowNo: $("#reqFlowNo_input").val(),
            flowStepID: $("#flowStepID_input").val(),
            respStatus: $("#respStatus_input").val(),
            realChannel: $("#realChannel_input").val(),
            realSystem: $("#realSystem_input").val(),
            respCode: $('#respCode_input').val(),
            txntlrno: $('#txntlrno_input').val(),
            dstcno: $('#dstcno_input').val(),
            instno: $('#instno_input').val(),
        };
        return temp;
    };
    return oTableInit;
};

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};
    oInit.Init = function () {
        $("#btn_journalQuery").click(function () {
            var startDate = $("#startDate_input").val();
            if (startDate == null || startDate.length == 0) {
                toastr.warning('起始时间不能为空！');
                return;
            }
            var endDate = $("#endDate_input").val();
            if (endDate == null || endDate.length == 0) {
                toastr.warning('终止时间不能为空！');
                return;
            }
//    		 $("#journalRecords").bootstrapTable('refresh');
            $("#journalRecords").bootstrapTable('refreshOptions', {pageNumber: 1, pageSize: 10});
        });
    };
    return oInit;
};

// 报文详情按钮
function addFunctionAlty(value, row, index) {
    return [
        '<button type="button" id="btn_message" class="btn btn-default" data-toggle="modal" data-target="#message">详情</button>  ',
    ].join('');
}

//报文详情按钮对应实现的方法
window.operateEvents = {
    // 点击修改按钮执行的方法
    'click #btn_message': function (e, value, row, index) {
        $("#pkgcontent2").val(row.pkgcontent);
        $("#message").on("show.bs.modal", function() {
            $(this).removeData("modal");
        });
    },
};


