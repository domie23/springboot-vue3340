const base = {
    get() {
        return {
            url : "http://localhost:8080/xueshengkaoqinguanlia/",
            name: "xueshengkaoqinguanlia",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/xueshengkaoqinguanlia/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "学生考勤管理系统"
        } 
    }
}
export default base
