<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Student</title>
</head>
<body>


<h1>Witaj </h1>

<h2>${student.firstName?upper_case}  ${student.lastName}
    <#if student.active>
        <span style="color: #7fff00; ">Acitve</span>
    <#else>
        <span style="color: red; ">Inactive</span>
    </#if>
    <br>
    Grades:<#list student.grades as g>
        ${g}<#sep>,</#sep>
<#else> no grades

    </#list>

</h2>

<a href="students">powrót</a>

<#include "footer.ftlh">
</body>
</html>