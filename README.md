# MaillistV2
主页（登录页面）访问地址为localhost:8080
1.模拟数据库操作，初始化4个用户，每个用户只能对自己的通讯录进行增删改操作，互不影响
用户名： 密码
{"aa"："111111",
"bb"："222222" ,
"cc"："333333" ,
"dd","444444" }
    
2.设置了拦截器，用户未登录不能访问其他页面
3.输入值的校验目前使用js实现