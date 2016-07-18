/**
 * 获取项目路径
 */
$.getContextPath = function(){
	var curWwwPath = window.document.location.href;
	var pathName =  window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPaht = curWwwPath.substring(0,pos);
	var projectName = pathName.substring(0,pathName.substr(1).indexOf('/')+1);
	return (localhostPaht + projectName);
}
/**
 * 引入项目中的css或者js
 * path可以是数组
 */
$.include = function(path){
	if("string" != typeof path){
		return;
	}
	for(var c="string"==typeof path?[path]:path,d=0;d<c.length;d++){
		var e=c[d].replace(/^\s|\s$/g,"");
		f=e.split(".");
		g=f[f.length-1].toLowerCase();
		h="css"==g;
		i=h?"link":"script";
		j=h?" type='text/css' rel='stylesheet' ":" language='javascript' type='text/javascript' ";
		k=(h?"href":"src")+"='"+e+"'";
		if(i && j && k){
			$("head").append("<"+i+j+k+"></"+i+">");
		}
	}
}

$.pageInfo = {}