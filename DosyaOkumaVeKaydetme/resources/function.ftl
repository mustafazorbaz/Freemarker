<#function space  param1>
	<#local str = "">
	<#list 1..10 as n>	
 	<#local str =str + lineFeed()>	
	</#list>
  <#return str>  
</#function>
<#function lineFeed><#return enter></#function>