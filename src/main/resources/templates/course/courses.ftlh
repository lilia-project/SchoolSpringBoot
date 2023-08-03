<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>Courses</title>
  <link rel="stylesheet" href="styles.css">
  <link rel="stylesheet" href="tablestyles.css">

</head>

<body>
<header>
  <h1>Courses</h1>
</header>

<#include "../menu.ftlh">

<body>
  <table id="courseTable">
    <thead>
            <form action="/courses/add">
                 <button type="submit">Add</button>
            </form>

    <tr>
      <th>ID</th>
      <th>Name</th>
      <th>Actions</th>
    </tr>
    </thead>
        <tbody>
                <#list courses as course>
                    <tr>
                      <td><a href="/course/${course.getId()}"><p>${course.getId()}</a></td>
                      <td>${course.getName()}</td>
                      <td>
                           <form action="/course/${course.getId()}">
                                <button type="submit">Edit</button>
                           </form>

                           <form action="/courses/delete/${course.getId()}" method="get">
                                <button type="submit">Delete</button>
                           </form>
                      </td>
                    </tr>
                </#list>
        </tbody>
  </table>

   <div id="errorBanner" style="display: none; background-color: #f44336; color: white; text-align: center; padding: 10px;">
                      <p id="errorMessage"></p>
                      <button onclick="hideErrorBanner()">OK</button>
                  </div>
</body>
<footer>
  <p>&copy; 2023 IT School. All rights reserved.</p>
</footer>
</body>

</html>
