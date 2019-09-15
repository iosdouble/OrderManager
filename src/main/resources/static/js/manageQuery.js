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
var TableInit = function () {
    var oTableInit = new Object();
    //初始化Table
    oTableInit.Init = function () {
        //指定操作表
        $('#appManageRecords').bootstrapTable({
            // url: '/detailQuery/getDetailInfo',   //请求后台的URL（*）
            url: '/manageQuery/getManageInfo',   //请求后台的URL（*）
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
            uniqueId: "id",                     //每一行的唯一标识，一般为主键列
            showToggle: false,                    //是否显示详细视图和列表视图的切换按钮
            cardView: false,                    //是否显示详细视图
            detailView: false,                   //是否显示父子表
            columns: [
                {
                    field: 'id',
                    title: '工单号'
                },
                {
                    field: 'moduleName',
                    width: '60px',
                    title: '名称'
                },
                {
                    field: 'sceneName',
                    width: '280px',
                    title: '审批状态'
                },
                {
                    field: 'detail',
                    title: '操作结果'
                },
                {
                    align: 'center', valign: 'middle',formatter:"operateFormatter",
                    title: '查看详情'
                }]

        });

    };
    //得到查询的参数
    oTableInit.queryParams = function (params) {
        var temp = {   //这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
            limit: params.limit,   //页面大小
            offset: params.offset,  //页码
            orderId:$("#mid").val()
        };
        return temp;
        console.log("获取到工单号"+temp.orderId)
    };
    return oTableInit;
};

function operateFormatter(value, row, index) {
    return [ '<button class="RoleOfedit btn btn-primary btn-sm" data-toggle="modal" onclick= \'see("+row.id+")\' data-target="#myModal" style="display:inline">查看</button>',].join('');

}
/*

查看详情

function see(id) {
    $.ajax({
        type:"select",
        url : "/manageQuery/getManageInfo/"+id,
        dataType:JSON,
        async:false,
    });
}*/
var ButtonInit = function () {
    var oInit = new Object();
    var postdata = {};
    oInit.Init = function () {
        $("#btn_detailQuery").click(function () {
            var orderId = $("#did").val();
            console.log("获取到的工单号"+orderId)
            if (orderId == null || orderId.length == 0) {
                toastr.warning('工单号不能为空！');
                return;
            }
            $("#appManageRecords").bootstrapTable('refreshOptions', {pageNumber: 1, pageSize: 10});
        });
    };
    console.log(oInit)
    return oInit;
};