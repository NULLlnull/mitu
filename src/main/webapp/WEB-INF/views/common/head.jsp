<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<html lang="en">
<head>
   <meta charset="utf-8"/>
   <title>控制台 - 基础信息管理平台</title>
   <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
   <link href="assets/css/bootstrap.min.css" rel="stylesheet"/>
   <link rel="stylesheet" href="assets/css/font-awesome.min.css"/>
   <link rel="stylesheet" href="assets/css/ace.min.css"/>
   <link rel="stylesheet" href="assets/css/ace-rtl.min.css"/>
   <link rel="stylesheet" href="assets/css/ace-skins.min.css"/>
   <link rel="stylesheet" href="css/style.css"/>
   <script src="assets/js/ace-extra.min.js"></script>
   <script src="js/jquery-1.9.1.min.js"></script>
   <script src="assets/js/bootstrap.min.js"></script>
   <script src="assets/js/typeahead-bs2.min.js"></script>
   <script src="assets/js/ace-elements.min.js"></script>
   <script src="assets/js/ace.min.js"></script>
   <script src="assets/layer/layer.js" type="text/javascript"></script>
   <script src="assets/laydate/laydate.js" type="text/javascript"></script>
   <script type="text/javascript">
       $(function () {
           var cid = $('#nav_list> li>.submenu');
           cid.each(function (i) {
               $(this).attr('id', "Sort_link_" + i);

           })
       })

       $(document).ready(function () {
           $('#nav_list').find('li.home').click(function () {
               $('#nav_list').find('li.home').removeClass('active');
               $(this).addClass('active');
           });

           //时间设置
           function currentTime() {
               var d = new Date(), str = '';
               str += d.getFullYear() + '年';
               str += d.getMonth() + 1 + '月';
               str += d.getDate() + '日';
               str += d.getHours() + '时';
               str += d.getMinutes() + '分';
               str += d.getSeconds() + '秒';
               return str;
           }

           setInterval(function () {
               $('#time').html(currentTime)
           }, 1000);
       });
   </script>
   <style type="text/css">
      .navbar-logo {
         color: #fff;
         font-size: 28px;
         text-shadow: none;
         padding: 5px 5px;
      }
   </style>
</head>
<body>
<div class="navbar navbar-default" id="navbar">
   <div class="navbar-container" id="navbar-container">
      <div class="navbar-header pull-left">
         <div class="navbar-logo">
            <img src="images/logo.jpg" style="width: 60px;height: 60px">
            <span>XXX学校基础数据平台</span>
            <span></span>
         </div>
      </div>
      <div class="navbar-header pull-right" role="navigation">
         <ul class="nav ace-nav" style="padding-top: 15px">
            <li class="light-blue">
               <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                     <span class="time">
                        <em id="time"></em>
                     </span>
                  <span class="user-info">
                        <small>欢迎光临</small>
                     </span>
               </a>
            </li>
         </ul>
      </div>
   </div>
</div>
</body>
</html>
