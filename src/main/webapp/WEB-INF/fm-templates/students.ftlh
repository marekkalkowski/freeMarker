<#ftl encoding='UTF-8'>

<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8">
    <title>Student</title>
</head>
<body>

<h1>Witaj </h1>

<h2>Lista studentów</h2>

<#--<#list students>-->
<#--<ul>-->
<#--<#items as s>-->
<#--<li>-->
<#--<a href="student?id=${s.id}" >-->
<#--${s.firstName}-->
<#--</a>-->
<#--</li>-->
<#--</#items>-->
<#--</ul>-->

<#--</#list>-->
<#assign color = "lightgrey">
<#list students>

<h1>Liczba studentów: ${students?size}</h1>
    <table>
        <thead>
        <th>First name</th>
        <th>Last name</th>
        <th>Link</th>
        </thead>

        <#items as s>
            <#if s?index % 2 == 0>
                <tr style="background-color: ${color}">
            <#else>
                <tr>
            </#if>
                    <td>
                        ${s.firstName}
                    </td>
                    <td>
                        ${s.lastName?upper_case}
                    </td>
                    <td>
                        <a href="student?id=${s.id}">view</a>
                    </td>
                </tr>

        </#items>
    </table>

</#list>

<#include "footer.ftlh">

</body>
</html>