<h1>test</h1>

<#assign foo = "var">

Wartość zmiennej: ${foo}<br>

<#assign x = 5..9>

<#list x as i>
${i}<#sep>,</#sep>

</#list>