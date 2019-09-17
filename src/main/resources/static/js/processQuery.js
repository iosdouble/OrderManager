$(function () {
    // 1.初始化Table
    var oTable = new TableInit();
    oTable.Init();
    // 2.初始化Button的点击事件
    // var oButtonInit = new ButtonInit();
    // oButtonInit.Init();
    var oButtonInit = new ButtonInit();
    oButtonInit.Init();
});

function search() {

}

var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        //指定操作表
        $('#getProcess').bootstrapTable({
            url: '/processQuery/getProcessById',   //请求后台的URL（*）
            method: 'get',                      //请求方式（*）
            toolbar: '#toolbar',                //工具按钮用哪个容器
            striped: true,                      //是否显示行间隔色
            cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
            pagination: true,                   //是否显示分页（*）
            sortable: false,                     //是否启用排序
            sortOrder: "asc",                   //排序方式
            queryParams: oTableInit.queryParams,//传递参数（*）
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
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [
                {
                    field: 'resApplyId',
                    title: '工单号'
                },
                {
                    field: 'stepName',
                    title: '状态'
                },
                {
                    field: 'cnName',
                    title: '检察人员'
                },
                {
                    field: 'description',
                    title: '描述'
                },
                {
                    align: 'center', valign: 'middle',formatter:"operateFormatter",
                    title: '查看详情'
                }
               ]
        });
    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            id:$("#pid").val()
        };
        return temp;
        console.log("获取到工单号"+temp.id)
    };
    return oTableInit;
};

function operateFormatter(value, row, index) {
    console.log("获取到好多:"+row.id)
    /*$('#getManage').bootstrapTable({
        url:'/manageQuery/getManageById/'+row.id,
        method: 'get',
        height: 250,
        columns: [
            {
                field: 'stepName',
                title: 'stepName'
            },
        ]
    })*/
    return [ '<button class="RoleOfedit btn btn-primary btn-sm" data-toggle="modal" data-target="#myModals" style="display:inline">查看</button>',].join('');
}

var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};
    oInit.Init = function () {
        $("#btn_ProcessQuery").click(function () {
            var id = $("#pid").val();
            console.log("获取到的工单号"+id)
            if (id == null || id.length == 0) {
                toastr.warning('工单号不能为空！');
                return;
            }
            $("#getProcess").bootstrapTable('refreshOptions', {pageNumber: 1, pageSize: 10});
        });
    };
    return oInit;
};


//改变下拉框值
$("#pid").change(function () {
    SelectChange();
});

function SelectChange() {
    //获取下拉框选中项的text属性值
    $("#getProcess").bootstrapTable('refreshOptions', {pageNumber: 1, pageSize: 10});

}
