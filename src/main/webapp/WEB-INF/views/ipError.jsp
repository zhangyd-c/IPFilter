<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>IP访问次数限制错误提示页</title>
<style type="text/css">
   em {
 	 	font-family: "Georgia";
    	font-size: 18px;
    	font-weight: bold;
    	color: #f54343;
   }
</style>
<div style="width: 98%;height: 500px;background-color: aliceblue;border: 2px solid red;border-radius: 5px;padding-top: 20px;padding-left: 10px;">
	<em>系统检查到你的IP地址在短时间内进行了大量访问，因此你的IP暂时被列入“限制访问”名单。</em>
	<p>若你是机器人，那你也看不懂，你请便就行；</p>
	<p>如果不是机器人，那么烦请你先休息1个小时，喝杯咖啡散散步，千万别累着。</p>
	<c:if test="${remainingTime ne null && remainingTime > 0 }">
		<p><em>剩余时间(s)：<span id="remainingTime">${remainingTime }</span></em></p>
		<script type="text/javascript">
			var remainingTimeTag = document.getElementById("remainingTime");
			window.setInterval(function(){
				drawing();
			},1000);
			function drawing(){
				var remainingTime = remainingTimeTag.innerHTML;
				if(remainingTime <= 0){
					console.log("OK，冤家~~~休息够了么？休息够了就tm脱了膀子继续干！");
					setTimeout(function(){
						window.location.href = "/render/index";
					},2000)
					return;
				}
				remainingTimeTag.innerHTML = remainingTime - 1;
			}
		</script>
	</c:if>
</div>



