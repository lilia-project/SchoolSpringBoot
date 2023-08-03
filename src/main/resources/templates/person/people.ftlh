<!DOCTYPE html>
<html>

<head>
  <meta charset="UTF-8">
  <title>People</title>
  <link rel="stylesheet" href="styles.css">
  <link rel="stylesheet" href="tablestyles.css">

</head>

<body>
<header>
  <h1>People</h1>
</header>

<#include "../menu.ftlh">

<body>
  <table id="peopleTable">
    <thead>
            <form action="/person/add">
                 <button type="submit">Add</button>
            </form>

    <tr>
      <th>ID</th>
      <th>lastName</th>
      <th>Actions</th>
    </tr>
    </thead>
        <tbody>
                <#list people as course>
                    <tr>
                      <td><a href="/person/${person.getId()}"><p>${person.getId()}</a></td>
                      <td>${person.getLastName()}</td>
                      <td>
                           <form action="/person/${person.getId()}">
                                <button type="submit">Edit</button>
                           </form>

                           <form action="/people/delete/${person.getId()}" method="get">
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
