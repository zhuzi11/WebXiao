$(function(){
	$("form").submit(function(){
		var flag = true;
		$("[type='text'],[type='password']").each(function(index,item){
			if($(item).val() == ""){
				alert("不能为空");
				$(item).focus();
				flag = false;
				return false;
			}
		});
		if(!flag){
			return false;/*阻止表单提交*/
		}
		
		if($("[type='radio']:checked").length == 0){
			alert("请选择性别");
			return false;
		}
		
		return true;
	});
});