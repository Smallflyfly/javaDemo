let DEFAULT_TOTAL_COUNT = 0, DEFAULT_PAGE_INDEX = 1, DEFAULT_PAGE_SIZE = 10;
let DEFAULT_FORM_ADD_EDIT_DEPT = {
    deptNo: 0,
    deptName: '',
    deptLevel: 2,
    deptLoc: '',
    deptPNo: 1
};

// 查询条件
let query = new Vue({
    el: '#wholeAppForm',
    data() {
        return {
            queryItem: {
                deptNo: '',
                deptName: ''
            }
        }
    },
    methods: {
        query() {
            dataShow.pageIndex = DEFAULT_PAGE_INDEX;
            dataShow.refresh();
        }
    }
});

// 数据处理
let dataShow = new Vue({
    el: '#wholeAppShow',
    data() {
        return {
            loading: true,
            userTableColumns: [
                {
                    title: '部门编号',
                    key: 'deptNo',
                    width: 90
                },
                {
                    title: '部门名称',
                    key: 'deptName',
                    render: (h, params) => {
                        return h('div', [
                            h('strong', params.row.deptName)
                        ]);
                    }
                },
                {
                    title: '部门级别',
                    key: 'deptLevel'
                },
                {
                    title: '部门地址',
                    key: 'deptLoc'
                },
                {
                    title: '操作',
                    key: 'action',
                    width: 200,
                    align: 'center',
                    render: (h, params) => {
                        return h('div', [
                            h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.show(params.index)
                                        }
                                    }
                                },
                                '详情'
                            ),
                            h('Button', {
                                    props: {
                                        type: 'ghost',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.edit(params.index)
                                        }
                                    }
                                },
                                '修改'
                            ),
                            h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.remove(params.index)
                                        }
                                    }
                                },
                                '删除'
                            )
                        ]);
                    }
                }
            ],
            userInfoList: [],
            // Page相关
            totalCount: DEFAULT_TOTAL_COUNT,
            pageIndex: DEFAULT_PAGE_INDEX,
            pageSize: DEFAULT_PAGE_SIZE,
            styleList: 'margin-top: 6px;text-align: right;',
            // 新增、编辑对话框
            modalAddEdit: false,
            formAddEdit: { // 这里不能直接赋值 DEFAULT_FORM_ADD_EDIT_DEPT
                deptNo: DEFAULT_FORM_ADD_EDIT_DEPT.deptNo,
                deptName: DEFAULT_FORM_ADD_EDIT_DEPT.deptName,
                deptLevel: DEFAULT_FORM_ADD_EDIT_DEPT.deptLevel,
                deptLoc: DEFAULT_FORM_ADD_EDIT_DEPT.deptLoc,
                deptPNo: DEFAULT_FORM_ADD_EDIT_DEPT.deptPNo
            }
        }
    },
    created() {
        this.queryData(this.pageIndex, this.pageSize, '');
    },
    methods: {
        queryData(pageIndex, pageSize, deptName) {
            let that = this;
            that.loading = true;
            axios.get(`/deptList?page=${pageIndex}&pageSize=${pageSize}&deptName=${deptName ? deptName : ''}`)
                .then(function (response) {
                    console.log(response);
                    that.loading = false;
                    if (response.data.success) {
                        that.userInfoList = response.data.data;
                        that.totalCount = response.data.total;
                    } else {
                        that.$Message.error(response.data.message);
                    }
                })
                .catch(function (error) {
                    that.loading = false;
                    that.$Message.error('异常：' + error);
                });
        },
        add() {
            // 重置对话框数据
            resetData(this.formAddEdit, DEFAULT_FORM_ADD_EDIT_DEPT);

            // 显示对话框
            this.modalAddEdit = true;
        },
        show(index) {
            this.$Modal.info({
                title: '部门信息',
                content: `部门编号：${this.userInfoList[index].deptNo}<br>部门名称：${this.userInfoList[index].deptName}<br>部门级别：${this.userInfoList[index].deptLevel}<br>部门地址：${this.userInfoList[index].deptLoc}`
            });
        },
        edit(index) {
            // 填充修改数据
            let deptInfo = this.userInfoList[index];
            this.formAddEdit.deptNo = deptInfo.deptNo;
            this.formAddEdit.deptName = deptInfo.deptName;
            this.formAddEdit.deptLevel = deptInfo.deptLevel;
            this.formAddEdit.deptLoc = deptInfo.deptLoc;
            this.formAddEdit.deptPNo = deptInfo.deptPNo;

            // 显示对话框
            this.modalAddEdit = true;
        },
        remove(index) {
            let that = this;
            this.$Modal.confirm({
                title: '删除确认',
                content: `部门编号：${this.userInfoList[index].deptNo}<br>部门名称：${this.userInfoList[index].deptName}`,
                onOk() {
                    // request带编号id到服务端删除
                    that.userInfoList.splice(index, 1);
                }
            });
        },
        refresh() {
            this.queryData(this.pageIndex, this.pageSize, query.queryItem.deptName);
        },
        // 翻页部分
        handlePage(pageIndex) {
            this.pageIndex = pageIndex;
            this.refresh();
        },
        handlePageSize(pageSize) {
            this.pageSize = pageSize;
            this.refresh();
        },
        // modal部分
        modalOk() {
            let that = this;
            let deptNo = that.formAddEdit.deptNo; // 传参，判断新增或修改
            // 以下是axios的form表单形式提交
            axios({
                headers: {
                    'Content-Type': 'application/x-www-form-urlencoded',
                },
                url: '/addEditDept',
                method: 'post',
                params: {
                    deptNo: deptNo,
                    deptName: that.formAddEdit.deptName,
                    deptLoc: that.formAddEdit.deptLoc
                }
            }).then(function (response) {
                if (response.data.success) {
                    that.$Message.info(response.data.message);
                    if (deptNo > 0) { // 修改，刷新当前页数据
                        dataShow.refresh();
                    } else {
                        query.query();
                    }
                } else {
                    that.$Message.error(response.data.message);
                }
            }).catch(function (error) {
                that.$Message.error('异常：' + error);
            });
        },
        modalCancel() {
            this.$Message.info('你取消了新增或修改');
        }
    }
});