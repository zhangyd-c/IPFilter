<%@ page language="java" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<title>评论回复测试页</title>
<style type="text/css">
	.title{
	    font-family: Lato, Helvetica, Arial, sans-serif;
	    padding-top: 15px;
   		border-bottom: 1px solid #e8e8e8;
	}
	.info{
	    font-family: Lato, Helvetica, Arial, sans-serif;
		line-height:2;
		padding-left: 5px;
		padding-right: 5px; 
	}
	.info a{
		cursor: pointer;
	}
	.sepa{
		content: "|";
		margin-left: 3px;
		margin-right: 3px;
	}
	.reply{
		margin-left: 20px
	}
	.closeSon{
		display: none;
	}
	.openSon{
		display: block;
	}
</style>
<div
	style="width: 98%; background-color: white; border: 2px solid gray; border-radius: 5px; padding-top: 20px; padding-left: 10px;">
	<div>评论回复测试</div>
	<ul>
		<c:forEach items="${messages }" var="message">
			<li>
				<div class="parent">
					<div class="title">${message.content }</div>
					<div class="info">
						<fmt:formatDate value="${message.insertTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
						<span class="sepa">|</span>
						回复(<a href="javascript:void(0)" onclick="javascript:showReply('${message.id }',this)">${message.replyNumber }</a>)
						<span class="sepa">|</span>
						${message.ip }
					</div>
				</div>
			</li>
		</c:forEach>
	</ul>
</div>
<script type="text/javascript">
	 function showReply(messageId, target){
		 var $parent = $(target).parent();
		 console.log($parent.find("ul").length > 0);
		 if($parent.find("ul").length > 0){
			 console.log(1);
			 $parent.find("ul").toggleClass("closeSon");
		 }else{
			 $(".zhezhao").show();
			 console.log(2);
			 $.ajax({
				 type:"POST",
				 url:"/render/reply/" + messageId,
				 success:function(json){
					 $parent.find("ul").remove();
					 if(json != null && json.length > 0){
						 var ul = '<ul class="reply">';
						 for(var i = 0 ; i < json.length; i ++){
							 ul += '<li><div><div class="title">'+json[i].content+'</div>';
						     ul += '<div class="info">';
							 ul += json[i].insertTime;
							 ul += '回复(<a href="javascript:void(0)" onclick="javascript:showReply(\''+json[i].id+'\',this)">'+json[i].replyNumber+'</a>)';
							 ul += '<span class="sepa">|</span>'+json[i].ip;
							 ul += '</div></div></li>';
						 }
						 ul += '</ul>';
						 
						 setTimeout(function(){
							 $(".zhezhao").hide();
							 $parent.append(ul);
						 },400);
					 }
				 },
				 error:function(json){
					 
				 }
			 })
		 }
		 
	 }
</script>

